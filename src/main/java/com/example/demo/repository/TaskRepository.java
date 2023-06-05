package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.Task;


public interface TaskRepository extends JpaRepository<Task, Long>{
		
	 @Query(value="select * from prices p   where p.product_id = :product_id and p.brand_id = :brand_id and :fecha BETWEEN p.start_date AND p.end_date ", nativeQuery=true)
	 List<Task> findByProducto(Integer product_id, Integer brand_id, @Param("fecha")  LocalDateTime fecha);

}