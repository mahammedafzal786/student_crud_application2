package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.bean.StudentsBean;
import com.util.DBConnection;

//PreparedStatement ---> "SQL Queries Execute"
//
//StudentDaoPrep---> student (student table)
public class StudentsDao {

	/*
	 * Topic : CRUD Operation in Using PreparedStatement 
	 * 
	 * CRUD ---> Create , Read , Update , Delete 
	 * 
	 * */
	
	public int insertStudent(StudentsBean sbean) {
		
		int rowAffected = 0;
		String insertQuery = "INSERT INTO students(first_name,last_name,email,phone,dob,gender,address,course,batch_time,payment_mode,sports,music,debate,volunteering) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
//		String insertQuery = "INSERT INTO student(student_id,first_name,last_name,email,phone,dob,gender,address,course,batch_time,payment_mode,sports,music,debate,volunteering) VALUES(?,?,?)";
		
		
		System.out.println("insertQuery : "+insertQuery);
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		if (conn != null) {
			
			try {
				
			pstmt = conn.prepareStatement(insertQuery);
			
			pstmt.setString(1, sbean.getFirst_name());
			pstmt.setString(2, sbean.getLast_name());
			pstmt.setString(3, sbean.getEmail());
			pstmt.setString(4, sbean.getPhone());
			pstmt.setString(5, sbean.getDob());
			pstmt.setString(6, sbean.getGender());
			pstmt.setString(7, sbean.getAddress());
			pstmt.setString(8, sbean.getCourse());
			pstmt.setString(9, sbean.getBatch_time());
			pstmt.setString(10, sbean.getPayment_mode());
			pstmt.setBoolean(11, sbean.isSports());
			pstmt.setBoolean(12, sbean.isMusic());
			pstmt.setBoolean(13, sbean.isDebate());
			pstmt.setBoolean(14, sbean.isVolunteering());
			
			rowAffected = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("StudentsDao -------> insertStudent()----->Database Not Connected"+conn);
		}
		
		return rowAffected;
	}

	


	// student Table ----> update SQL
	public int updateStudent(StudentsBean sbean,int student_id) {
		
		String updateQuery = "UPDATE students SET first_name=?,last_name=?,email=?,phone=?,dob=?,gender=?,address=?,course=?,batch_time=?,payment_mode=?,sports=?,music=?,debate=?,volunteering=? WHERE student_id=?";
		
		System.out.println("updateQuery : "+updateQuery);
		
		Connection conn =  DBConnection.getConnection();
		
		PreparedStatement pstmt = null;

		int rowAffected = 0;
		
		if (conn != null) {
		try {

			pstmt =  conn.prepareStatement(updateQuery);
			
			
			pstmt.setString(1, sbean.getFirst_name());
			pstmt.setString(2, sbean.getLast_name());
			pstmt.setString(3, sbean.getEmail());
			pstmt.setString(4, sbean.getPhone());
			pstmt.setString(5, sbean.getDob());
			pstmt.setString(6, sbean.getGender());
			pstmt.setString(7, sbean.getAddress());
			pstmt.setString(8, sbean.getCourse());
			pstmt.setString(9, sbean.getBatch_time());
			pstmt.setString(10, sbean.getPayment_mode());
			pstmt.setBoolean(11, sbean.isSports());
			pstmt.setBoolean(12, sbean.isMusic());
			pstmt.setBoolean(13, sbean.isDebate());
			pstmt.setBoolean(14, sbean.isVolunteering());
			pstmt.setInt(15, student_id);
			
			
			rowAffected = pstmt.executeUpdate();
			

			System.out.println("Update Query: => "+pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}else {
			System.out.println("StudentsDao -------> updateStudent()----->Database Not Connected"+conn);
		}
		return rowAffected;
		
	}

	

	// student Table ----> delete  SQL
	public int deleteStudent(int student_id) {
		
		int rowAffected = 0;
		String deleteQuery = "DELETE FROM students WHERE student_id=?";
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		if (conn != null) {
			
			try {
				
				pstmt = conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1,student_id);
				
				rowAffected = pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		} else {
			System.out.println("StudentsDao -------> deleteStudent()----->Database Not Connected"+conn);
		}
		
		return rowAffected;
	}
	
	

	// student Table ----> select  SQL
	public ArrayList<StudentsBean> getAllStudentsRecords() {
		
		ArrayList<StudentsBean> list = new ArrayList<StudentsBean>();
		
		String selectQuery = "SELECT student_id,first_name,last_name,email,phone,dob,gender,address,course,batch_time,payment_mode,sports,music,debate,volunteering FROM students";
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		StudentsBean sbean = null;
		
		if (conn != null) {
			
			try {
				
				pstmt = conn.prepareStatement(selectQuery);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
					int student_id = rs.getInt(student_id) ;
					String first_name = rs.getString(first_name);
					String last_name = rs.getNString(last_name);
					String email = rs.getNString(email);
					String phone = rs.getNString(phone);
					String dob = rs.getNString(dob);
					String gender = rs.getNString(gender);
					String address = rs.getNString(address);
					String course = rs.getNString(course);
					String batch_time = rs.getNString(batch_time);
					String payment_mode = rs.getNString(payment_mode);
					boolean sports = rs.getBoolean(sports);
					boolean music = rs.getBoolean(music);
					boolean debate = rs.getBoolean(debate);
					boolean volunteering = rs.getBoolean(volunteering);
					
					sbean = new StudentsBean(student_id, first_name, last_name, email, phone, dob, gender, address, course, batch_time, payment_mode, sports, music, debate, volunteering);
					list.add(sbean);
					
					 
				}
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("StudentsDao -------> getAllStudentsRecords()----->Database Not Connected"+conn);
		}
		
		return list;
		
	}
	
	public Object getStudentByRno(int student_id) 
	{
		String selectStudentByRno = "SELECT * FROM students WHERE student_id=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt  = null; 
		ResultSet rs = null;
		StudentsBean sbean = null;
		
		if (conn!=null) 
		{
			try 
			{
				pstmt  = conn.prepareStatement(selectStudentByRno);
			
				pstmt.setInt(1, student_id);
				
				rs = pstmt.executeQuery();
				if (rs.next()) 
				{
					int student_id1;
					String first_name = rs.getString(first_name);
					String last_name = rs.getNString(last_name);
					String email = rs.getNString(email);
					String phone = rs.getNString(phone);
					String dob = rs.getNString(dob);
					String gender = rs.getNString(gender);
					String address = rs.getNString(address);
					String course = rs.getNString(course);
					String batch_time = rs.getNString(batch_time);
					String payment_mode = rs.getNString(payment_mode);
					boolean sports = rs.getBoolean(sports);
					boolean music = rs.getBoolean(music);
					boolean debate = rs.getBoolean(debate);
					boolean volunteering = rs.getBoolean(volunteering);
					
					sbean = new StudentsBean(student_id, first_name, last_name, email, phone, dob, gender, address, course, batch_time, payment_mode, sports, music, debate, volunteering);
					
					return sbean;
				} else 
				{
					System.out.println("Student record not found");
					return false;
				} 
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("Db not conncected");
		}
		return false; 
	}


	
	public static void main(String[] args) {
		

		//------------INSERT Student--------
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter First  Name: ");
		String first_name = sc.nextLine();
		System.out.println("Enter Last Name: ");
		String last_name = sc.nextLine();
		System.out.println("Enter Email: ");
		String email = sc.nextLine();
		System.out.println("Enter Phone No : ");
		String phone = sc.nextLine() ;
		System.out.println("Enter DOB : ");
		String dob = sc.nextLine();
		System.out.println("Enter gender : ");
		String gender = sc.nextLine();
		System.out.println("Enter Address : ");
		String address = sc.nextLine();
		System.out.println("Enter Course :");
		String course = sc.nextLine();
		System.out.println("Enter Batch Time : ");
		String batch_time = sc.nextLine();
		System.out.println("Enter Payment Mode : ");
		String payment_mode = sc.nextLine();
		System.out.println("Enter Sports(True/False) : ");
		boolean sports = sc.nextBoolean();
		System.out.println("Enter Music(True/False) : ");
		boolean music = sc.nextBoolean();
		System.out.println("Enter Debate(True/False) : ");
		boolean debate = sc.nextBoolean();
		System.out.println("Enter Volunteering(True/False) : ");
		boolean volunteering = sc.nextBoolean();
		
		StudentsDao dao = new StudentsDao();
		
		StudentsBean sbean = new StudentsBean(0, first_name, last_name, email, phone, dob, gender, address, course, batch_time, payment_mode, sports, music, debate, volunteering);
		
		int rowAffected = dao.insertStudent(sbean);
		
		if (rowAffected > 0) {
			
			System.out.println("Student record successfully inserted : "+rowAffected);
			
		} else {

			System.out.println("Student record Not inserted : "+rowAffected);
		}
		
		*/
		

		//-------------UPDATE Student Records----------------------
		
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter rno which you want to Update : ");
		int student_id = sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter First  Name: ");
		String first_name = sc.nextLine();
		System.out.println("Enter Last Name: ");
		String last_name = sc.nextLine();
		System.out.println("Enter Email: ");
		String email = sc.nextLine();
		System.out.println("Enter Phone No : ");
		String phone = sc.nextLine() ;
		System.out.println("Enter DOB : ");
		String dob = sc.nextLine();
		System.out.println("Enter gender : ");
		String gender = sc.nextLine();
		System.out.println("Enter Address : ");
		String address = sc.nextLine();
		System.out.println("Enter Course :");
		String course = sc.nextLine();
		System.out.println("Enter Batch Time : ");
		String batch_time = sc.nextLine();
		System.out.println("Enter Payment Mode : ");
		String payment_mode = sc.nextLine();
		System.out.println("Enter Sports(True/False) : ");
		boolean sports = sc.nextBoolean();
		System.out.println("Enter Music(True/False) : ");
		boolean music = sc.nextBoolean();
		System.out.println("Enter Debate(True/False) : ");
		boolean debate = sc.nextBoolean();
		System.out.println("Enter Volunteering(True/False) : ");
		boolean volunteering = sc.nextBoolean();
		
		StudentsDao dao = new StudentsDao();
		
		StudentsBean sbean = new StudentsBean(student_id, first_name, last_name, email, phone, dob, gender, address, course, batch_time, payment_mode, sports, music, debate, volunteering);
		
		
		int rowAffected = dao.updateStudent(sbean, student_id);
		
		if (rowAffected > 0) {
			
			System.out.println("Student record successfully Updated : "+rowAffected);
			
		} else {

			System.out.println("Student record Not Updated : "+rowAffected);
		}
		
		*/
		

		

		//-------------DELETE Student--------------
		/*	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter rno which you want to Delete Student record : ");
		int student_id = sc.nextInt();

		StudentsDao dao = new StudentsDao();
		
		int rowAffected =  dao.deleteStudent(student_id);
	
		if (rowAffected > 0) {
			
			System.out.println("Student record successfully Deleted : "+rowAffected);
			
		} else {

			System.out.println("Student record Not Deleted : "+rowAffected);
		}
		
		*/


		//-----------------getAllStudentsRecords --------------------
		
		
		StudentsDao dao = new StudentsDao();         
		
		ArrayList<StudentsBean> list = dao.getAllStudentsRecords();
		
		System.out.println("list.size(): "+list.size());
		
		for (int i = 0; i < list.size(); i++) {
			
			StudentsBean s = list.get(i);
			
			System.out.println(s.getFirst_name()+" "+s.getLast_name()+" "+s.getEmail()+" "+s.getPhone()+" "+s.getDob()+" "+s.getGender()+" "+s.getAddress()+" "+s.getCourse()+" "+s.getBatch_time()+" "+s.getPayment_mode()+" "+s.isSports()+" "+s.isMusic()+" "+s.isDebate()+" "+s.isVolunteering());
			
		}
		

	}
	
}
