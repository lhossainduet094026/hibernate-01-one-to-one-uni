package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2Code.hibernate.demo.entity.Instructor;
import com.luv2Code.hibernate.demo.entity.InstructorDetail;
import com.luv2Code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// create sessionfactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session object
		Session session = factory.getCurrentSession();
		try {
			// create objects
			/*
			 * Instructor tempInstructor = new Instructor("chand", "derby",
			 * "chand@gmail.com"); InstructorDetail tempInstructorDetail = new
			 * InstructorDetail("http://luv2Code.com/youtube", "luv 2 code!!!");
			 */
			Instructor tempInstructor = new Instructor("salman", "siddique", "salman@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://digitalManager.com/youtube",
					"social activity!!!");
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			// begin transaction
			session.beginTransaction();
			// save instructor
			// note:save instructor and also save instructor detail because of using cascade
			// type ALL
			System.out.println("Saving Instructor...." + tempInstructor);
			session.save(tempInstructor);
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
