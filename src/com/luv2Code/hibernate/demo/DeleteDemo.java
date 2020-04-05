package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2Code.hibernate.demo.entity.Instructor;
import com.luv2Code.hibernate.demo.entity.InstructorDetail;
import com.luv2Code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		// create sessionfactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session object
		Session session = factory.getCurrentSession();
		try {
			// begin transaction
			session.beginTransaction();
			// getting instructor with primary key/id which one to delete
			int id = 2;
			Instructor tempInstructor = session.get(Instructor.class, id);

			// deleting instructor
			// note:delete instructor and also delete instructor detail because of using
			// cascade
			// type ALL
			System.out.println("deleting Instructor...." + tempInstructor);
			if (tempInstructor != null) {
				session.delete(tempInstructor);
			}
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done.");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
