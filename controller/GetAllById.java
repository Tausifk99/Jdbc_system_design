package com.jsp.controller;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class GetAllById {

	public static void main(String[] args) {
		
		StudentDao stdao=new StudentDao();
		
		Student s=stdao.getStudentByID(2);
		
	     System.out.println(s.getId()+" "+s.getName()+" "+s.getEmail());
	}
}
