package co.com.technicaltest.store.domain.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.technicaltest.store.domain.repository.IStoreRepository;
import co.com.technicaltest.store.domain.service.IStoreService;
import co.com.technicaltest.store.persistence.model.Order;
import co.com.technicaltest.store.persistence.model.Product;

@Service
public class OrderService implements IStoreService{
	
	@Autowired
	private IStoreRepository repository;

	@Override
	public Order createOrder( int idCustomer, String address, ArrayList<Product> products) {
		
		Order order = new Order();
		order = calculateTotal(order, products);
		
		order.setId(UUID.randomUUID().toString());
		order.setIdCustomer(idCustomer);
		order.setAddress(address);
		order.setDateOrder(new Date());
		order.setStatus("Aprobado");
		order.setProducts(products);
		
		return  repository.createOrder(order);
	}
	
	public Order calculateTotal(Order order, ArrayList<Product> products) {
		
		int totalPrice = 0;
		for (Product product : products) {
			if (product.getAmount() > 0) {
				totalPrice += product.getAmount() * product.getPrice();
			}else {
			totalPrice += product.getPrice();
		}}
		if (totalPrice > 70000 && totalPrice <= 100000) {
			order.setTotalPrice(totalPrice + (totalPrice*.19 ) + 1500);
			order.setDeliveryCost(1500);
			order.setTax("19%");
		}else if(totalPrice > 100000){
			order.setTotalPrice(totalPrice + (totalPrice*.19 ));
			order.setDeliveryCost(0);
			order.setTax("19%");
		}else {
			order.setTotalPrice(totalPrice + 1500);
			order.setDeliveryCost(1500);
			order.setTax("0");
		}
		return order;
	}

	@Override
	public ArrayList<Product> getProducts() {
		
		return repository.getProducts();
	}
	
	@Override
	public ArrayList<Order> getOrders() {
		
		return repository.getOrders();
	}


	@Override
	public  ArrayList<Order> cancelOrder (String id) {
		ArrayList<Order> orders = repository.getOrders();
		for(int i = 0; i < orders.size(); i++) {
			if(id.equals(orders.get(i).getId())) {
				double hour = calculateTime(new Date(), orders.get(i).getDateOrder());
				
				if(hour <= 12 ) {
					orders.get(i).setStatus("Cancelado");
					orders.get(i).setTotalPrice(0);
					orders.get(i).setTax("0");
					orders.get(i).setDeliveryCost(0);
				}else if(hour > 12) {
					orders.get(i).setStatus("Cancelado");
					orders.get(i).setTotalPrice(orders.get(i).getTotalPrice() * 0.1);
					orders.get(i).setTax("0");
					orders.get(i).setDeliveryCost(0);
				}
			}
		}
		
		
		return repository.cancelOrder(orders);
	}

	@Override
	public ArrayList<Order> modificateOrder(Order order) {
		ArrayList<Order> orders = repository.getOrders();
		order.setDateOrder(new Date());
		order = calculateTotal(order, order.getProducts());
		for (int i = 0; i < orders.size(); i++) {
			if(order.getId().equals(orders.get(i).getId())) {
				
				double hour = calculateTime(order.getDateOrder(), orders.get(i).getDateOrder());
				
				if(hour <= 5 && order.getTotalPrice() >= orders.get(i).getTotalPrice()) {
					if((orders.get(i).getTotalPrice() > 70000 && orders.get(i).getTotalPrice() <= 100000 )
							&& (order.getTotalPrice() > 100000)  ) {
						order.setTotalPrice(order.getTotalPrice() - order.getDeliveryCost());
						order.setDeliveryCost(0);
						
					}
					orders.set(i, order);
				}
			}
			
		}
		return repository.modificateOrder(orders);
	}

	public double calculateTime(Date fechaini, Date fechafin) {
		double difference = fechafin.getTime() - fechaini.getTime(); 
		double hour = difference / (60*60*1000);
		return hour;
		
	}
	
	
	
}
