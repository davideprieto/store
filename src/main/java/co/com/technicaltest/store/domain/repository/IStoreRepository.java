package co.com.technicaltest.store.domain.repository;

import java.util.ArrayList;

import co.com.technicaltest.store.persistence.model.Order;
import co.com.technicaltest.store.persistence.model.Product;

public interface IStoreRepository {
	
	Order createOrder(Order order);
	ArrayList<Product> getProducts();
	ArrayList<Order> getOrders();
	ArrayList<Order> cancelOrder (ArrayList<Order> order);
	ArrayList<Order> modificateOrder(ArrayList<Order> order);
	
}
