package com.jsp.controller;

import java.util.ArrayList;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class InsertMultipleStudent {

	public static void main(String[] args) {
		
		StudentDao sdao =new StudentDao();
		
		Student s1=new Student();
		
		s1.setId(3);
		s1.setName("tanmay");
		s1.setEmail("tanmay@123");
		
		Student s2=new Student();
		
		s2.setId(4);
		s2.setName("khan");
		s2.setEmail("khan@123");
		
		Student s3=new Student();
		
		s3.setId(5);
		s3.setName("surya");
		s3.setEmail("surya@123");
		
		ArrayList<Student> al=new ArrayList<>();
		
		al.add(s1);
		al.add(s2);
		al.add(s3);
		
		sdao.addMultipleStudent(al);
	}
}
