package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

@RestController
@RequestMapping (value="getdatacontroller")
public  class GetDataController{
	
	@Autowired
	private TaskRepository taskRepository;
	
	 
	 @GetMapping(value="listProduct/{product_id}/{brand_id}/{fecha}")
	 public List<Task> findProducto(@PathVariable Integer product_id, @PathVariable Integer brand_id, @PathVariable String fecha){
		

		 return taskRepository.findByProducto(product_id, brand_id, getFecha(fecha));
		 
	 
	 }
	 
	 public LocalDateTime getFecha(String fecha) {
		 String fechaOutput = fecha;
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm"); // formato que quieras la fecha
		 LocalDateTime fechaFinal = LocalDateTime.parse(fechaOutput, formatter); //parsea a LocalDateTime , la fecha de entrada con el respectivo formato indicado

		 return fechaFinal;
	 }


	
}

