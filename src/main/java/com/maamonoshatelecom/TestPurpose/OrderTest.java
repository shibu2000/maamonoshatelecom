package com.maamonoshatelecom.TestPurpose;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class OrderTest {

	private int id;

//	@ManyToOne
//    @JoinColumn(name = "user_id")
//    private UserEntity userEntity;
//	
//	@ManyToMany
//    @JoinTable(name = "order_items",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private List<ProductEntity> products = new ArrayList<>();
//	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "shipping_address_id")
//    private AddressEntity shippingAddress;
//    
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "billing_address_id")
//    private AddressEntity billingAddress;

//	@Temporal(TemporalType.TIMESTAMP)
//	private Date orderDate;

	private String status;

	private String paymentMethod;

	private BigDecimal totalAmount;

	private String notes;


}
