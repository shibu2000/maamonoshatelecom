package com.maamonoshatelecom.service;

import org.springframework.http.ResponseEntity;

import com.maamonoshatelecom.model.OrderModel;

public interface OrderService {

	ResponseEntity<?> saveOrder(OrderModel orderModel);
	
	//get orders by user_id
	ResponseEntity<?> getOrder(String user_id);
	ResponseEntity<?> cancelOrder(String order_id);
	ResponseEntity<?> getOrderByID(String _order_id);
	ResponseEntity<?> getUserOrdersByDate(String orderDate, String user_id);
	ResponseEntity<?> getLastOrder(String user_id);
	ResponseEntity<?> getLast_3_Orders(String user_id);
	ResponseEntity<?> downloadInvoice(String order_id);
}
