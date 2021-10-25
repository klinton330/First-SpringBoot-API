package com.hari;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentInfoRepository {
	Connection con=null;
	List<StudentInfo>list=null;

    //INITIALIZING DATABASE CONNECTION	
	public StudentInfoRepository()

	{
		String url = "jdbc:mysql://localhost:3306/wcis";
		String username = "root";
		String password = "saibaba330";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<StudentInfo> getStudent()
	{
		list=new ArrayList<StudentInfo>();
		String sql="select*from studentinfo";
		try
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				StudentInfo si=new StudentInfo();
				si.setSname(rs.getString("sname"));
				si.setAge(rs.getInt("age"));
				si.setCourse(rs.getString("course"));
				si.setMobile(rs.getString("mobile"));
				si.setCity(rs.getString("city"));
				list.add(si);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	public StudentInfo createNewStudent(StudentInfo s)
	{
		String sql="insert into studentinfo(sname,age,course,mobile,city)values(?,?,?,?,?)";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, s.getSname());
			ps.setInt(2, s.getAge());
			ps.setString(3, s.getCourse());
			ps.setString(4, s.getMobile());
			ps.setString(5, s.getCity());
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("INserted");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return s;
	}
	
	public void updateStudent(StudentInfo s,String Mobile)
	{
		String sql="update studentinfo set sname=?,age=?,course=?,mobile=?,city=? where mobile=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, s.getSname());
			ps.setInt(2, s.getAge());
			ps.setString(3, s.getCourse());
			ps.setString(4, s.getMobile());
			ps.setString(5, s.getCity());
			ps.setString(6, Mobile);
			int i=ps.executeUpdate();
			if(i>0)
				System.out.println("updated");
			else
		        System.out.println("Not updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public StudentInfo getParticularStudent(String mobile)
	{
		String sql="select*from studentinfo where mobile=?";
		StudentInfo sf=new StudentInfo();
		try
		{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, mobile);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			sf.setSname(rs.getString("sname"));
			sf.setAge(rs.getInt("age"));
			sf.setCourse(rs.getString("course"));
			sf.setMobile(rs.getString("mobile"));
			sf.setCity(rs.getString("city"));
			sf.setId(rs.getInt("id"));
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sf;
		
	}
	public void deleteStudent(String mobile)
	{
		String sql="delete from studentinfo where mobile=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, mobile);
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("deleted");
			}
			else
			{
				System.out.println("Not deleted");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


}
