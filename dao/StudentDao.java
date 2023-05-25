package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.Student;
import com.jsp.helper.HelperClass;

public class StudentDao {

	//to save a student
	
	HelperClass helperclass=new HelperClass();
	
	Connection connection=null;
	public Student saveStudent(Student student)
	{
		 connection=helperclass.getConnection();
		
		String sql="insert into student values(?,?,?)";//?-Delimiter/Place holder
		//create statement
	   try {
		PreparedStatement preparedstatement=connection.prepareStatement(sql);
		
		//set the dynamic value
		
		preparedstatement.setInt(1, student.getId());
		preparedstatement.setString(2, student.getName());
		preparedstatement.setString(3, student.getEmail());		
		
		//execute query/statement
		
		preparedstatement.execute();
		
	       } catch (SQLException e) 
	       {
	      	e.printStackTrace();	
	       }finally {
	    	   try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	       }
	   
	   return student;
		
	}
	
	//delete records
	
	public boolean deleteStudentById(int id)
	{
		//get connection
		 connection=helperclass.getConnection();
		
		//create statement
		boolean b=false;
		
		String query="delete from student where id=?";
		
		try {
			// pass the query
			PreparedStatement pdstmt=connection.prepareStatement(query);
			
			//set the id dynamically
			
			pdstmt.setInt(1, id);
			
			// this method returns int value
			
			int result=pdstmt.executeUpdate();
			
			if(result>0)
			{
				b=true;
			}else
			{
				b=false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return b;
	}
	
	public boolean updateStudent(String email, int id)
	{
		//create connection
		
    	 connection=helperclass.getConnection();
    	
    	//write incomplete query
    	
    	String query="update student set email=? where id=?";
    	
    	boolean b=false;
    	
    	try {
    		
			PreparedStatement pdstmt=connection.prepareStatement(query);
			
			pdstmt.setString(1, email);
			pdstmt.setInt(2, id);
			
			int res=pdstmt.executeUpdate();
			if(res>0)
			{
				b=true;
			}else
			{
				b=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	return b;
	
	}
	
	public List<Student> getAllStudents()
	{
		//create connection
		
	     connection=helperclass.getConnection();
	    
	    String query="select * from student";
	    
	    ArrayList<Student> al=null;
	    
		try {
			PreparedStatement pdstmt = connection.prepareStatement(query);
		    ResultSet resultset= pdstmt.executeQuery();
		    
		    al=new ArrayList<Student>();
		    while(resultset.next())
		    {
		    	int id=resultset.getInt(1);
		    	String name=resultset.getString(2);
		    	String email=resultset.getString(3);
		    	
		    	Student s=new Student();
		    	s.setId(id);
		    	s.setName(name);
		    	s.setEmail(email);
		    	
		    	al.add(s);
		    }

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	    return al;
	}
	
	public Student getStudentByID(int sid)
	{
		 connection=helperclass.getConnection();
		
		String query="select * from student where id=?";
		Student s=null;
		try {
			PreparedStatement pdstmt=connection.prepareStatement(query);
			
			pdstmt.setInt(1, sid);
			
			ResultSet rst=pdstmt.executeQuery();
			s=new Student();
			
			while(rst.next())
			{
				int id=rst.getInt(1);
				String name=rst.getString(2);
				String email=rst.getString(3);
				
				s.setId(id);
				s.setName(name);
				s.setEmail(email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return s;	
	}
	
	public void addMultipleStudent(List<Student>  students)
	{
		connection=helperclass.getConnection();
		
		String query="insert into student values(?,?,?)";
		
		try {
			//statement created
			PreparedStatement pd=connection.prepareStatement(query);
			
			//execute statement
			for (Student s : students) 
			{
				pd.setInt(1, s.getId());
				pd.setString(2, s.getName());
				pd.setString(3, s.getEmail());
				pd.addBatch();
			}
			pd.executeBatch();
			System.out.println("done");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
