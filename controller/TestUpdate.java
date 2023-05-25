package com.jsp.controller;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class TestUpdate {

	public static void main(String[] args) {
		
		StudentDao stdao=new StudentDao();
		
		String email="ABC@gmail.com";
		boolean b=stdao.updateStudent(email,2);
		
		System.out.println(b);
		
	}
}
