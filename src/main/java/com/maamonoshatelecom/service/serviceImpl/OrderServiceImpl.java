package com.maamonoshatelecom.service.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maamonoshatelecom.Entity.AddressEntity;
import com.maamonoshatelecom.Entity.OrderEntity;
import com.maamonoshatelecom.Entity.ProductEntity;
import com.maamonoshatelecom.Entity.UserEntity;
import com.maamonoshatelecom.Repo.AddressRepo;
import com.maamonoshatelecom.Repo.OrderRepo;
import com.maamonoshatelecom.Repo.ProductRepo;
import com.maamonoshatelecom.Repo.UserRepo;
import com.maamonoshatelecom.Response.OrderResponse;
import com.maamonoshatelecom.model.OrderModel;
import com.maamonoshatelecom.service.OrderService;
import com.maamonoshatelecom.util.OrderStatusConstant;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private AddressRepo addressRepo;
	@Autowired
	private ProductRepo productRepo;

	@Override
	public ResponseEntity<?> saveOrder(OrderModel orderModel) {
		OrderEntity orderEntity = new OrderEntity();

		// Fetching the user entity
		Optional<UserEntity> user = this.userRepo.findById(orderModel.getUser_id());
		orderEntity.setUserEntity(user.get());

		// Fetching the Shipping Address Entity
		Optional<AddressEntity> shippindAddress = this.addressRepo.findById(orderModel.getShippingaddressID());
		orderEntity.setShippingAddress(shippindAddress.get());

		// Fetching the billing address entity
		Optional<AddressEntity> billingAddress = this.addressRepo.findById(orderModel.getBillingAddressID());
		orderEntity.setShippingAddress(billingAddress.get());

		// Fetching the current date and time and saving is using "LocalDateTime" OBJECT
		orderEntity.setOrderDateTime(LocalDateTime.now());

		orderEntity.setExpectedDelivery(LocalDateTime.now().plusDays(7));

		orderEntity.setStatus(OrderStatusConstant.waiting_for_confirmation);

		long totalAmount = 0;

		List<ProductEntity> productList = new ArrayList<>();

		// Iterating the map to store the products with its counts
		for (Map.Entry<Integer, Integer> productsMap : orderModel.getProductList().entrySet()) {

			Optional<ProductEntity> product = this.productRepo.findById(productsMap.getKey());

			for (int i = 0; i < productsMap.getValue(); i++) {
				productList.add(product.get());
				totalAmount += product.get().getProductPrice();
			}
		}

		orderEntity.setProducts(productList);
		orderEntity.setTotalAmount(totalAmount);
		orderEntity.setNotes(orderModel.getNotes());

		OrderEntity save = this.orderRepo.save(orderEntity);

		return ResponseEntity.ok(save);
	}

	@Override
	public ResponseEntity<?> getOrder(String user_id) {
		Optional<UserEntity> user = this.userRepo.findById(user_id);
		if (user.isPresent()) {
			List<OrderEntity> orderEntities = this.orderRepo.findByuserEntity(user.get());

			if (orderEntities.size() > 0) {

				List<OrderResponse> orderResponses = new ArrayList<>();

				orderEntities.forEach(order -> {
					OrderResponse orderResponse = new OrderResponse();

					orderResponse.setId(order.getId());
					orderResponse.setShipping_address_id(order.getShippingAddress().getId());
					orderResponse.setBilling_address_id(order.getBillingAddress().getId());

					orderResponse.setNotes(order.getNotes());
					orderResponse.setStatus(order.getStatus());
					orderResponse.setTotalAmount(order.getTotalAmount());
					orderResponse.setOrderDateTime(order.getOrderDateTime());
					orderResponse.setExpectedDelivery(order.getExpectedDelivery());

					Map<Integer, Integer> productList = new HashMap<>();

					order.getProducts().forEach(product -> {
						if (!productList.containsKey(product.getId())) {
							productList.put(product.getId(), 1);
						} else {
							productList.put(product.getId(), productList.get(product.getId()) + 1);
						}
					});

					orderResponse.setProductList(productList);

					orderResponses.add(orderResponse);
				});

				return ResponseEntity.ok(orderResponses);
			} else {
				return ResponseEntity.noContent().build();
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User NOT FOUND");
		}
	}

	@Override
	public ResponseEntity<?> cancelOrder(String id) {
		Optional<OrderEntity> order = this.orderRepo.findById(id);
		if (order.isPresent()) {
			order.get().setStatus(OrderStatusConstant.canceled);
			OrderEntity save = this.orderRepo.save(order.get());
			if (save != null) {
				return ResponseEntity.ok("Order Cnceled");
			} else {
				return ResponseEntity.internalServerError().body("Server Error!! Try after some time");
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
		}
	}

	@Override
	public ResponseEntity<?> getOrderByID(String order_id) {
		Optional<OrderEntity> order = this.orderRepo.findById(order_id);
		if (order.isPresent()) {
			return ResponseEntity.ok(order.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Not found");
		}
	}

	@Override
	public ResponseEntity<?> getUserOrdersByDate(String orderDate, String user_id) {
		List<OrderEntity> orderEntity = this.orderRepo.findByuserEntity(this.userRepo.findById(user_id).get());

		if (orderEntity.size() > 0) {

			List<OrderResponse> orderResponses = new ArrayList<>();

			DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
			orderEntity.forEach(order -> {
				// Fetching the order date, Converting it into string using DateTimeFormattor
				// and check that user input date(in String format) is present or not
				if (order.getOrderDateTime().format(formatter).contains(orderDate)) {
					OrderResponse orderResponse = new OrderResponse();

					orderResponse.setId(order.getId());
					orderResponse.setShipping_address_id(order.getShippingAddress().getId());
					orderResponse.setBilling_address_id(order.getBillingAddress().getId());

					orderResponse.setNotes(order.getNotes());
					orderResponse.setStatus(order.getStatus());
					orderResponse.setTotalAmount(order.getTotalAmount());
					orderResponse.setOrderDateTime(order.getOrderDateTime());
					orderResponse.setExpectedDelivery(order.getExpectedDelivery());

					Map<Integer, Integer> productList = new HashMap<>();

					order.getProducts().forEach(product -> {
						if (!productList.containsKey(product.getId())) {
							productList.put(product.getId(), 1);
						} else {
							productList.put(product.getId(), productList.get(product.getId()) + 1);
						}
					});

					orderResponse.setProductList(productList);

					orderResponses.add(orderResponse);
				}
			});

			return ResponseEntity.ok(orderResponses);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@Override
	public ResponseEntity<?> getLastOrder(String user_id) {
		OrderEntity order = this.orderRepo.getLstOrder(user_id);
		if (order != null) {
			OrderResponse orderResponse = new OrderResponse();

			orderResponse.setId(order.getId());
			orderResponse.setShipping_address_id(order.getShippingAddress().getId());
			orderResponse.setBilling_address_id(order.getBillingAddress().getId());

			orderResponse.setNotes(order.getNotes());
			orderResponse.setStatus(order.getStatus());
			orderResponse.setTotalAmount(order.getTotalAmount());
			orderResponse.setOrderDateTime(order.getOrderDateTime());
			orderResponse.setExpectedDelivery(order.getExpectedDelivery());

			Map<Integer, Integer> productList = new HashMap<>();

			order.getProducts().forEach(product -> {
				if (!productList.containsKey(product.getId())) {
					productList.put(product.getId(), 1);
				} else {
					productList.put(product.getId(), productList.get(product.getId()) + 1);
				}
			});

			orderResponse.setProductList(productList);

			return ResponseEntity.ok(orderResponse);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Order Found");
		}
	}

	@Override
	public ResponseEntity<?> getLast_3_Orders(String user_id) {
		List<OrderEntity> orderEntities = this.orderRepo.getLst3Order(user_id);
		if (orderEntities.size() > 0) {

			List<OrderResponse> orderResponses = new ArrayList<>();

			orderEntities.forEach(order -> {
				OrderResponse orderResponse = new OrderResponse();

				orderResponse.setId(order.getId());
				orderResponse.setShipping_address_id(order.getShippingAddress().getId());
				orderResponse.setBilling_address_id(order.getBillingAddress().getId());

				orderResponse.setNotes(order.getNotes());
				orderResponse.setStatus(order.getStatus());
				orderResponse.setTotalAmount(order.getTotalAmount());
				orderResponse.setOrderDateTime(order.getOrderDateTime());
				orderResponse.setExpectedDelivery(order.getExpectedDelivery());

				Map<Integer, Integer> productList = new HashMap<>();

				order.getProducts().forEach(product -> {
					if (!productList.containsKey(product.getId())) {
						productList.put(product.getId(), 1);
					} else {
						productList.put(product.getId(), productList.get(product.getId()) + 1);
					}
				});

				orderResponse.setProductList(productList);

				orderResponses.add(orderResponse);
			});

			return ResponseEntity.ok(orderResponses);
		}else {
			return ResponseEntity.noContent().build();
		}
	}

	@Override
	public ResponseEntity<?> downloadInvoice(String order_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
