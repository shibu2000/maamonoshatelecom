package com.maamonoshatelecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maamonoshatelecom.model.OrderModel;
import com.maamonoshatelecom.service.OrderService;

@RestController
@RequestMapping(value = "/maamonoshatelecom/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/save")
	ResponseEntity<?> saveOrder(@RequestBody OrderModel orderModel) {
		System.err.println(orderModel);
		this.orderService.saveOrder(orderModel);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/get")
	ResponseEntity<?> getOrder(@RequestParam("user_id") String user_id) {
		return this.orderService.getOrder(user_id);
	}

	@DeleteMapping(value = "/cancel")
	ResponseEntity<?> cancelOrder(@RequestParam("order_id") String order_id) {
		return this.orderService.cancelOrder(order_id);
	}

	@GetMapping(value = "/get-order-by-id")
	ResponseEntity<?> getOrderByID(@RequestParam("order_id") String order_id) {
		return this.orderService.getOrderByID(order_id);
	}
	
	@GetMapping(value = "/get-order-by-date")
	ResponseEntity<?> getUserOrdersByDate(@RequestParam("orderDate") String orderDate, @RequestParam("user_id") String user_id) {
		return this.orderService.getUserOrdersByDate(orderDate, user_id);
	}
	
	@GetMapping(value = "/get-last-order")
	ResponseEntity<?> getLastOrder(@RequestParam("user_id") String user_id){
		return this.orderService.getLastOrder(user_id);
	}
	
	@GetMapping(value = "/get-last-3-order")
	ResponseEntity<?> getLast_3_Orders(@RequestParam("user_id") String user_id){
		return this.orderService.getLast_3_Orders(user_id);
	}
	
	@GetMapping(value = "/download-invoice")
	ResponseEntity<?> downloadInvoice(@RequestParam("order_id") String order_id){
		return this.orderService.downloadInvoice(order_id);
	}
}
