package co.com.technicaltest.store.persistence;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;


import co.com.technicaltest.store.domain.repository.IStoreRepository;
import co.com.technicaltest.store.persistence.model.Order;
import co.com.technicaltest.store.persistence.model.Product;

@Repository
public class StoreRepository implements IStoreRepository {
	
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<Product> products = new ArrayList<>();

	@Override
	public Order createOrder(Order order) {
		orders.add(order);
		return order;
	}

	@Override
	public ArrayList<Product> getProducts() {
		products.add(new Product("Jabón", "Jabón de manos", 500, 0));
		products.add(new Product("crema", "crema de dientes", 200, 0));
		products.add(new Product("Shampoo", "Sahmpoo rizos", 700, 0));
		products.add(new Product("Cepillo", "Cepillo duro", 100, 0));
		products.add(new Product("Estropajo", "Estropajo natural", 300, 0));
		return products ;
	}

	@Override
	public ArrayList<Order> cancelOrder (ArrayList<Order> order) {
		orders = order;
		return orders;
	}

	@Override
	public ArrayList<Order> modificateOrder(ArrayList<Order> order) {
			orders = order;
		return orders;
	}

	@Override
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	
}
