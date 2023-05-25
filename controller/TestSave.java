package com.jsp.controller;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class TestSave {

	public static void main(String[] args) {
		
		Student student=new Student();
		student.setId(2);
		student.setName("abc");
		student.setEmail("abc@gmail.com");
		
		StudentDao studao=new StudentDao();
		
		Student s=studao.saveStudent(student);
		
		System.out.println(s.getName()+" saved succesfully");	
	}
}
