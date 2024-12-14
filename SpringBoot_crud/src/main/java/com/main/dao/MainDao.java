package com.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.entities.Student;

@Repository
public class MainDao {

	@Autowired
	private SessionFactory sf;

	public String addStudent(Student std) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.persist(std);
			tx.commit();
			return "Data Inserted Successfully....";

		} catch (Exception e) {

			tx.rollback();

			return "due to some error";

		}

	}

	public String updateStudent(int id, Student std) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {

			Student student = session.get(Student.class, id);

			student.setName(std.getName());
			student.setEmail(std.getEmail());
			student.setAge(std.getAge());

			tx.commit();
			return "Data Upadated Successfully....";

		} catch (Exception e) {
			tx.rollback();
			return "due to some error";

		}

	}

	public String deletestudent(int id) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {

			Student std = session.get(Student.class, id);

			session.remove(std);
			tx.commit();
			return "Data Deleted Successfully....";

		} catch (Exception e) {

			tx.rollback();
			return "due to some error";

		}

	}

	public Student getByid(int id) {

		Session session = sf.openSession();

		Student std = session.get(Student.class, id);

		return std;
	}

	public List<Student> getAllstudent() {

		Session session = sf.openSession();

		Query<Student> query = session.createQuery("from Student", Student.class);

		List<Student> list = query.list();

		return list;

	}

}