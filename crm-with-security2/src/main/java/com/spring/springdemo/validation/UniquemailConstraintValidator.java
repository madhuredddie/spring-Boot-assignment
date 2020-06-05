package com.spring.springdemo.validation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spring.springdemo.entity.Customer;

//import springMVC.validation.UniversityCode;

public class UniquemailConstraintValidator implements
ConstraintValidator<Uniquemail,String>{
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	@Transactional
	public boolean isValid(String code, ConstraintValidatorContext context) {
		boolean result=true;
		System.out.println(code);
		try {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery=
				currentSession.createQuery("from Customer order by firstName",Customer.class);
		//return list
		List<Customer> customers=theQuery.getResultList();
		
		if(code!=null)
		{
			for(Customer cus : customers)
			{
				System.out.println(cus.getEmail());
				if(code.equals(cus.getEmail()))
				{
					result=false;
					break;
				}
			}
		}
		
		else
		{
			result=true;
		}
	}
		catch(Exception e)
		{
			e.printStackTrace();
			result=true;
		}
		
		
		return result;
	} 

}
