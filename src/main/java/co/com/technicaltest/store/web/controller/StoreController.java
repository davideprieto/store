package co.com.technicaltest.store.web.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import co.com.technicaltest.store.domain.service.IStoreService;
import co.com.technicaltest.store.persistence.model.Order;
import co.com.technicaltest.store.persistence.model.Product;

@RestController
@RequestMapping("/v0")
public class StoreController {
	
	@Autowired
	private IStoreService storeService;
	
	@GetMapping("/test")
	public String test() {
		return "online";
	}
	
	@PostMapping("/order")
	public ResponseEntity<Order> createOrder(@RequestBody ArrayList<Product> products, 
			@RequestParam int idCustomer, @RequestParam String address ) {
		return new ResponseEntity<>(storeService.createOrder(idCustomer, address, products), HttpStatus.CREATED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<ArrayList<Product>> getProducts(){
		return new ResponseEntity<>(storeService.getProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/order")
	public ResponseEntity<ArrayList<Order>> getOrders(){
		return new ResponseEntity<>(storeService.getOrders(), HttpStatus.OK);
	}
	
	@PutMapping("/order")
	public ResponseEntity<ArrayList<Order>> modificateOrder(@RequestBody Order order ){
		return new ResponseEntity<>(storeService.modificateOrder(order), HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/order")
	public ResponseEntity<ArrayList<Order>> cancelOrder(@RequestParam String id){
		return new ResponseEntity<>(storeService.cancelOrder(id), HttpStatus.ACCEPTED);
	}
}
	

