package com.main.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entities.Student;
import com.main.services.MainService;

@RestController
public class MainController {

	@Autowired
	private MainService servi;

	@PostMapping("addstd")
	public ResponseEntity<String> addStudent(Student std) {

		String msg = servi.addStudent(std);

		return ResponseEntity.ok(msg);

	}

	@PutMapping("upstd/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody Student std) {

		String msg = servi.updateStudent(id, std);

		return ResponseEntity.ok(msg);

	}

	@DeleteMapping("deletestd/{id}")
	public ResponseEntity<String> deletestudent(@PathVariable int id) {

		String msg = servi.deletestudent(id);

		return ResponseEntity.ok(msg);

	}

	@GetMapping("getstd/{id}")
	public ResponseEntity<Student> getByid(@PathVariable int id) {

		Student std = servi.getByid(id);

		return ResponseEntity.ok(std);

	}

	@GetMapping("getstd")
	public ResponseEntity<List<Student>> getAllstudent() {

		List<Student> list = servi.getAllstudent();

		return ResponseEntity.ok(list);

	}

}
