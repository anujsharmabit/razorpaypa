package com.pay.repository;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pay.entity.StudentOrder;

@Repository
public interface Studentrepo extends JpaRepository<StudentOrder, Integer> {

	
	public StudentOrder findByRazorpayOrderId(String orderId);
	
}
 