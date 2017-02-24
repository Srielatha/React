package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dbutil.DbConnection;
import com.model.Student;


@Service
public class StudentService {
	public List<Student> retrieveStudents() {
		List<Student> userList = new ArrayList<Student>();
		Connection conn = null;
		ResultSet rs = null;
		String query = "select * from student_data";
		System.out.println(query);
		try {
			conn = DbConnection.getInstance().sqliteConnection();
			System.out.println(conn);
			rs  = conn.createStatement().executeQuery(query);
			while (rs.next()) {
				Student userObject = new Student();
				userObject.setId(rs.getInt(1));
				
				userObject.setFirstName(rs.getString(2));
				userObject.setLastName(rs.getString(3));
				userObject.setAge(rs.getInt(4));
				
				userList.add(userObject);
				System.out.println(userList);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return userList;
	}


	public void updateStudent(Student user) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		String query = "update student_data set first_name = '"+user.getFirstName()+"' ,last_name = '"+user.getLastName()+"' , age = "+user.getAge()+"   where rowid = "+user.getId();
		try {
			conn = DbConnection.getInstance().sqliteConnection();
			stmt = conn.createStatement();
		 int i = stmt.executeUpdate(query);
		 System.out.println("edit status :: "+ i);
		
		} catch (Exception e) {
			throw new Exception();
		}
		
	}

	public void deleteStudent(int id) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		String query = "delete from student_data where rowid = "+id;
		try {
			conn = DbConnection.getInstance().sqliteConnection();
			stmt = conn.createStatement();
			stmt.execute(query);
		} catch (Exception e) {
			throw new Exception();
		}
	
	}

	public void addStudent(Student user) throws Exception {
		String age = user.getAge()+"";
		Connection conn = null;
		String query = "insert into student_data values(null, '"+user.getFirstName()+"','"+user.getLastName()+"',"+age+")";
		System.out.println(query);
		try {
			conn = DbConnection.getInstance().sqliteConnection();
			conn.createStatement().executeUpdate(query);
		} catch (Exception e) {
			throw new Exception();
		}
	
	}

	public Student retrieveStudent(int id) {
		Connection conn = null;
		ResultSet rs = null;
		String query = "select * from student_data where rowid = "+id;
		Student userObject = new Student();
		try {
			conn = DbConnection.getInstance().sqliteConnection();
			rs  = conn.createStatement().executeQuery(query);
			while (rs.next()) {
				userObject.setId(rs.getInt(1));
				userObject.setFirstName(rs.getString(2));
				userObject.setLastName(rs.getString(3));
				userObject.setAge(rs.getInt(4));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return userObject;
	}
}