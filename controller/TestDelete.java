package com.jsp.controller;

import com.jsp.dao.StudentDao;

public class TestDelete {

	public static void main(String[] args) {
		
		StudentDao stdao=new StudentDao();
		
		
		boolean b=stdao.deleteStudentById(2);
		
		System.out.println(b);
	}
}
