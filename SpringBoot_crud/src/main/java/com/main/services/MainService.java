package com.main.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.MainDao;
import com.main.entities.Student;

@Service
public class MainService {

	@Autowired
	private MainDao dao;

	public String addStudent(Student std) {

		String msg = dao.addStudent(std);

		if (Objects.isNull(std)) {
			msg = "due to some error";
		}
		return msg;
	}

	public String updateStudent(int id, Student std) {

		String msg = dao.updateStudent(id, std);

		if (Objects.isNull(msg)) {
			msg = "due to some error";
		}

		return msg;
	}

	public String deletestudent(int id) {

		String msg = dao.deletestudent(id);
		if (Objects.isNull(msg)) {
			msg = "due to some error";
		}

		return msg;
	}

	public Student getByid(int id) {
		return dao.getByid(id);

	}

	public List<Student> getAllstudent() {

		return dao.getAllstudent();

	}

}
