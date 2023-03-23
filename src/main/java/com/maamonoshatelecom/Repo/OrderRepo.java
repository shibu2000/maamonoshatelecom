package com.maamonoshatelecom.Repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maamonoshatelecom.Entity.OrderEntity;
import com.maamonoshatelecom.Entity.UserEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, String>{
	
	List<OrderEntity> findByuserEntity(UserEntity userEntity);
	
	//Fetch Last Order record
	@Query(value = "SELECT * FROM orders where order_date_time=(SELECT MAX(order_date_time) FROM orders where user_id=user_id)", nativeQuery = true)
	OrderEntity getLstOrder(@Param("user_id") String user_id);
	
	//Fetch Last/resent 3 order records
	@Query(value = "SELECT * FROM orders where user_id=user_id ORDER BY order_date_time DESC LIMIT 3", nativeQuery = true)
	List<OrderEntity> getLst3Order(@Param("user_id") String user_id);
	
}
