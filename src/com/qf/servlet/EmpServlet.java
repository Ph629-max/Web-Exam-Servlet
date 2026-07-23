package com.qf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.dao.EmpDao;
import com.qf.entity.Emp;

@WebServlet("*.do")
public class EmpServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao dao=new EmpDao();
		//接收前端浏览器用户传递的信息
		String URI=request.getRequestURI();
		if(URI.equals("/EmpProject/main.do")){
			//将主页面信息返回给用户
			//获取数据库中的所有员工信息
			List<Emp>emps=dao.findAll();
			//将信息绑定 并发给页面
			request.setAttribute("emps", emps);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}if(URI.equals("/EmpProject/toAdd.do")){
			//跳转到add.jsp
			response.sendRedirect("add.jsp");
		}if(URI.equals("/EmpProject/add.do")){
			//获取浏览器发送过来的员工姓名  薪资  年龄等数据
			String name=request.getParameter("name");
			double salary=Double.parseDouble(request.getParameter("salary"));
			int age=Integer.parseInt(request.getParameter("age"));
			//调用数据访问层逻辑来完成员工信息的添加 Dao层
			Emp e=new Emp();
			e.setEname(name);
			e.setSalary(salary);
			e.setAge(age);
			e.setPwd("111111");
			dao.addEmp(e);
			//添加完员工信息后  请跳转会主页面进行添加后的信息查看
			response.sendRedirect("main.do");
		}else if(URI.equals("/EmpProject/delete.do")){
			//获取发送到服务器端的员工编号
			int id=Integer.parseInt(request.getParameter("id"));
			//根据获取的员工id信息 调用dao层的删除功能 将对应的数据从数据库中删除
			dao.delEmp(id);
			//删除成功后 调回到主页面  查看删除员工信息是否成功
			response.sendRedirect("main.do");
		}else if(URI.equals("/EmpProject/toUpdate.do")){
			//获取前端传递的要被修改的员工的 员工编号
			int id=Integer.parseInt(request.getParameter("id"));
			//根据员工编号查询对应的原始员工信息
			Emp e=dao.findById(id);
			//将原始员工信息 传递给 修改页面 并让修改页显示出原始的员工信息
			request.setAttribute("emp", e);
			//跳转到修改页
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}else if(URI.equals("/EmpProject/update.do")){
			//获取浏览发送过来的被修改后的员工信息
			//id  name salary age
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			double salary=Double.parseDouble(request.getParameter("salary"));
			int age=Integer.parseInt(request.getParameter("age"));
			//调用dao层的修改功能
			Emp e=new Emp();
			e.setEname(name);
			e.setSalary(salary);
			e.setAge(age);
			e.setEno(id);
			dao.update(e);
			//修改成功之后要调回到主页面 查看修改结果
			response.sendRedirect("main.do");
		}else if(URI.equals("/EmpProject/login.do")){
			//获取浏览发送过来的用户编号和密码
			int id=Integer.parseInt(request.getParameter("id"));
			String pwd=request.getParameter("pwd");
			//调用dao层的根据用户名和密码查询用户信息的方法
			//根据方法的返回值判断是否登录成功
			//如果返回员工对象 表示登录成功 跳转到主页面
			//如果返回null表示登录失败 提示用户  用户名或密码错误
			Emp e=dao.login(id, pwd);
			if(e!=null){
				//跳转到主页面
				response.sendRedirect("main.do");
			}else{
				//提示用户 用户名或密码错误
				request.setAttribute("msg", "用户名或密码错误");
				//返回到登录页
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
			
			
		}
	}

}
