package com.qf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qf.entity.Emp;
import com.qf.util.DBUtil;

public class EmpDao {
	//查询所有员工信息
	public List<Emp>findAll(){
		//定义存储数据的list集合
		List<Emp>emps=new ArrayList<Emp>();
		//链接数据库
		Connection con=DBUtil.getConnection();
		//定义数据库查询语句
		String sql="select * from emp";
		
		try {
			//定义PreparedStatement
			PreparedStatement prep=con.prepareStatement(sql);
			//执行查询
			ResultSet rs=prep.executeQuery();
			//将查询的数据封装到集合list中
			while(rs.next()){
				Emp emp=new Emp();
				emp.setEno(rs.getInt("eno"));
				emp.setEname(rs.getString("ename"));
				emp.setPwd(rs.getString("pwd"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setAge(rs.getInt("age"));
				emps.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emps;
	}
	//根据员工编号删除员工信息
	public void delEmp(int eno){
		//链接数据库
		Connection con=DBUtil.getConnection();
		//定义数据库查询语句
		String sql="delete from emp where eno=?";
		try {
			PreparedStatement prep=con.prepareStatement(sql);
			prep.setInt(1,eno);
			prep.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	}
	//添加员工信息
	public void addEmp(Emp emp){
		//链接数据库
		Connection con=DBUtil.getConnection();
		//定义数据库查询语句
		String sql="insert into emp(ename,pwd,salary,age) values(?,?,?,?)";
		try {
			PreparedStatement prep=con.prepareStatement(sql);
			prep.setString(1,emp.getEname());
			prep.setString(2,emp.getPwd());
			prep.setDouble(3,emp.getSalary());
			prep.setInt(4,emp.getAge());
			prep.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	//根据员工编号查询员工信息
	public Emp findById(int eno){
		Emp emp=null;
		//链接数据库
		Connection con=DBUtil.getConnection();
		//定义数据库查询语句
		String sql="select * from emp where eno=?";
		
		try {
			//定义PreparedStatement
			PreparedStatement prep=con.prepareStatement(sql);
			prep.setInt(1,eno);
			//执行查询
			ResultSet rs=prep.executeQuery();
			//将查询的数据封装到集合list中
			while(rs.next()){
				emp=new Emp();
				emp.setEno(rs.getInt("eno"));
				emp.setEname(rs.getString("ename"));
				emp.setPwd(rs.getString("pwd"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setAge(rs.getInt("age"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	
		
	}
	
	//修改员工信息
	public void update(Emp emp){

		//链接数据库
		Connection con=DBUtil.getConnection();
		//定义数据库查询语句
		String sql="update emp set ename=?,salary=?,age=? where eno=?";
		try {
			PreparedStatement prep=con.prepareStatement(sql);
			prep.setString(1,emp.getEname());
			prep.setDouble(2,emp.getSalary());
			prep.setInt(3,emp.getAge());
			prep.setInt(4,emp.getEno());
			prep.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
		
	}
	
	//根据员工编号和密码 查询员工信息
	public Emp login(Integer id,String pwd){
		Emp emp=null;
		//链接数据库
		Connection con=DBUtil.getConnection();
		//定义数据库查询语句
		String sql="select * from emp where eno=? and pwd=?";
		
		try {
			//定义PreparedStatement
			PreparedStatement prep=con.prepareStatement(sql);
			prep.setInt(1,id);
			prep.setString(2, pwd);
			//执行查询
			ResultSet rs=prep.executeQuery();
			//将查询的数据封装到集合list中
			while(rs.next()){
				emp=new Emp();
				emp.setEno(rs.getInt("eno"));
				emp.setEname(rs.getString("ename"));
				emp.setPwd(rs.getString("pwd"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setAge(rs.getInt("age"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	
		
	
	}
	
	
	public static void main(String[] args) {
		EmpDao dao=new EmpDao();
		/*Emp emp=new Emp();
		emp.setEname("lisi");
		emp.setPwd("1234");
		emp.setSalary(3000);
		emp.setAge(23);
		dao.addEmp(emp);*/
		//dao.delEmp(1001);
		//System.out.println(dao.findAll());
		System.out.println(dao.findById(1002));
	}
}
