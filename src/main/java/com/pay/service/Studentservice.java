package com.pay.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pay.entity.StudentOrder;
import com.pay.repository.Studentrepo;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class Studentservice {
	
	@Autowired
	private Studentrepo studentrepo;

	@Value("${razorpay.key.id}")
	private String razorPayKey;
	
	@Value("${razorpay.sercet.key}")
	private String razorPaySecret;
	
	private RazorpayClient razorpayClient;
	
	
	public StudentOrder  createorder(StudentOrder studentOrder) throws RazorpayException {
		
		JSONObject orderreq=new JSONObject();
		
		orderreq.put("amount", studentOrder.getAmount()*100);  //amount in paisa
        orderreq.put("currency", "INR");       //currency in indian rupee
        orderreq.put("receipt", studentOrder.getEmail());
        
        this.razorpayClient=new RazorpayClient(razorPayKey, razorPaySecret);
		
		
		//create order in razorpay
		Order  razorPayOrder=razorpayClient.orders.create(orderreq);
		
		System.out.println(razorPayOrder);
		
		studentOrder.setRazorpayOrderId(razorPayOrder.get("id"));
		
		studentOrder.setOrderStatus(razorPayOrder.get("status"));
		
		studentrepo.save(studentOrder);
		
		return studentOrder;
		
	}
	
	public StudentOrder updateorder(Map<String, String> responsePayLoad) {
		
		String razorPayOrderId=responsePayLoad.get("razorpay_order_id");
	StudentOrder order	=studentrepo.findByRazorpayOrderId(razorPayOrderId);
		
	order.setOrderStatus("PAYMENT_COMPLETED");
	
      StudentOrder updateorder	=studentrepo.save(order);
      
      return updateorder;
	}

	
	
	
}
