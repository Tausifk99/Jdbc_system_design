package com.jsp.controller;

import java.util.ArrayList;
import java.util.List;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class TestGetAll {

	public static void main(String[] args) {
		
		StudentDao stdao=new StudentDao();
		
		List<Student> li=new ArrayList<Student>();
		li=stdao.getAllStudents();
		
		for(Student s:li)
		{
			System.out.println(s.getId()+" "+s.getName()+" "+s.getEmail());
		}
	}
}
