package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;



@DataJpaTest
class GetDataControllerTest {
	
	@Autowired
	TaskRepository taskRepository;
	
	public List<Task> prod;
	@Test
	void test1() throws JSONException {
		GetDataController getDataController = new GetDataController();
	
		 String fecha = "2020-06-14 10.00";

		 prod=taskRepository.findByProducto(35455, 1,  getDataController.getFecha(fecha));
		 JSONArray jsonArray = new JSONArray();
		 for (int i=0; i < prod.size(); i++) {
			 	 jsonArray.put("product_id: "+ prod.get(i).getProduct_id());
		         jsonArray.put("cadena: " + prod.get(i).getBrand_id());  
		         jsonArray.put("tarifa a aplicar: " + prod.get(i).getPrice_List());
		         jsonArray.put("fecha inicio: " + prod.get(i).getStart_Date());
		         jsonArray.put("fecha fin: " + prod.get(i).getEnd_Date());
		         jsonArray.put("precio final: " + prod.get(i).getPrice());   
		         jsonArray.put("-------------------------------");
		 }
			
		System.out.println("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)");
	 	System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(jsonArray.toString(4));
		assertEquals(1, prod.get(0).getPrice_List());
	}
	
	@Test
	void test2() throws JSONException {
		GetDataController getDataController = new GetDataController();
	
		 String fecha = "2020-06-14 16.00";

		 prod=taskRepository.findByProducto(35455, 1,  getDataController.getFecha(fecha));
		 JSONArray jsonArray = new JSONArray();
		 for (int i=0; i < prod.size(); i++) {
			 	 
			 	 jsonArray.put("product_id: "+ prod.get(i).getProduct_id());
		         jsonArray.put("cadena: " + prod.get(i).getBrand_id());  
		         jsonArray.put("tarifa a aplicar: " + prod.get(i).getPrice_List());
		         jsonArray.put("fecha inicio: " + prod.get(i).getStart_Date());
		         jsonArray.put("fecha fin: " + prod.get(i).getEnd_Date());
		         jsonArray.put("precio final: " + prod.get(i).getPrice());
		         jsonArray.put("-------------------------------");
		 }
		
		System.out.println("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)");
	 	System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(jsonArray.toString(4));
		assertEquals(1, prod.get(0).getPrice_List());
		assertEquals(2, prod.get(1).getPrice_List());
	}
	
	@Test
	void test3() throws JSONException {
		GetDataController getDataController = new GetDataController();
	
		 String fecha = "2020-06-14 21.00";

		 prod=taskRepository.findByProducto(35455, 1,  getDataController.getFecha(fecha));
		 JSONArray jsonArray = new JSONArray();
		 for (int i=0; i < prod.size(); i++) {
			 	 
			 	 jsonArray.put("product_id: "+ prod.get(i).getProduct_id());
		         jsonArray.put("cadena: " + prod.get(i).getBrand_id());  
		         jsonArray.put("tarifa a aplicar: " + prod.get(i).getPrice_List());
		         jsonArray.put("fecha inicio: " + prod.get(i).getStart_Date());
		         jsonArray.put("fecha fin: " + prod.get(i).getEnd_Date());
		         jsonArray.put("precio final: " + prod.get(i).getPrice());  
		         jsonArray.put("-------------------------------");
		 }
		
		System.out.println("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)");
	 	System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(jsonArray.toString(4));
		assertEquals(1, prod.get(0).getPrice_List());
		
	}
	
	@Test
	void test4() throws JSONException {
		GetDataController getDataController = new GetDataController();
	
		 String fecha = "2020-06-15 10.00";

		 prod=taskRepository.findByProducto(35455, 1,  getDataController.getFecha(fecha));
		 JSONArray jsonArray = new JSONArray();
		 for (int i=0; i < prod.size(); i++) {
			 	 
			 	 jsonArray.put("product_id: "+ prod.get(i).getProduct_id());
		         jsonArray.put("cadena: " + prod.get(i).getBrand_id());  
		         jsonArray.put("tarifa a aplicar: " + prod.get(i).getPrice_List());
		         jsonArray.put("fecha inicio: " + prod.get(i).getStart_Date());
		         jsonArray.put("fecha fin: " + prod.get(i).getEnd_Date());
		         jsonArray.put("precio final: " + prod.get(i).getPrice() ); 
		         jsonArray.put("-------------------------------");
		 }
		
		System.out.println("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)");
	 	System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(jsonArray.toString(4));
		assertEquals(1, prod.get(0).getPrice_List());
		assertEquals(3, prod.get(1).getPrice_List());
		
	}
	
	@Test
	void test5() throws JSONException {
		GetDataController getDataController = new GetDataController();
	
		 String fecha = "2020-06-16 21.00";

		 prod=taskRepository.findByProducto(35455, 1,  getDataController.getFecha(fecha));
		 JSONArray jsonArray = new JSONArray();
		 for (int i=0; i < prod.size(); i++) {
			 	
			 	 jsonArray.put("product_id: "+ prod.get(i).getProduct_id());
		         jsonArray.put("cadena: " + prod.get(i).getBrand_id());  
		         jsonArray.put("tarifa a aplicar: " + prod.get(i).getPrice_List());
		         jsonArray.put("fecha inicio: " + prod.get(i).getStart_Date());
		         jsonArray.put("fecha fin: " + prod.get(i).getEnd_Date());
		         jsonArray.put("precio final: " + prod.get(i).getPrice());
		         jsonArray.put("-------------------------------");
		         System.out.println();
		 }
			
		System.out.println("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)");
	 	System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(jsonArray.toString(4));
		assertEquals(1, prod.get(0).getPrice_List());
		assertEquals(4, prod.get(1).getPrice_List());
		
	}

}
