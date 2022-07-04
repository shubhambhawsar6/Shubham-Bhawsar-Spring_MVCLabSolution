package com.greatlearning.debateEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.greatlearning.debateEvent.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService {

	private SessionFactory sessionfactory;
	private Session session;

	public StudentServiceImpl(SessionFactory sessionfactory) {

		this.sessionfactory = sessionfactory;
		try {
			session = this.sessionfactory.getCurrentSession();
		} catch (HibernateException e) {
			session = this.sessionfactory.openSession();
		}

	}

	@Transactional
	@Override
	public List<Student> findAll() {

		List<Student> studList = session.createQuery("from Student").list();
		for (Student s : studList) {
			System.out.println(s);
		}

		return studList;
	}

	@Transactional
	public Student findByid(Integer id) {

		Student student = session.get(Student.class, id);

		return student;
	}

	@Transactional
	public void save(Student student) {

		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(student);
		tr.commit();
	}

	@Override
	@Transactional
	public void delete(Student student) {
		Transaction tr = session.beginTransaction();
		session.delete(student);
		tr.commit();

	}

	@Override
	@Transactional
	public List<Student> findByfirstName_country(String firstName) {
		List<Student> studList=null;
		String query="";
		if(firstName.length()!=0 )
			query="from Student where firstName like '%"+firstName+"%' ";
		
		else
			query="from Student";
		if(query.length()!=0)
		{
			studList=session.createQuery(query).list();
		}
		return studList;
	}

}
