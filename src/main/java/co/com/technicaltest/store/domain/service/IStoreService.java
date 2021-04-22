package co.com.technicaltest.store.domain.service;

import java.util.ArrayList;
import co.com.technicaltest.store.persistence.model.Order;
import co.com.technicaltest.store.persistence.model.Product;

public interface IStoreService {
	
	 Order createOrder( int idCustomer, String address, ArrayList<Product> products);
	 ArrayList<Product> getProducts();
	 ArrayList<Order> getOrders();
	 ArrayList<Order> cancelOrder (String order);
	 ArrayList<Order> modificateOrder(Order order);
	 }
