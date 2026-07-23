<%@page import="com.qf.entity.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">员工管理系统</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						欢迎使用!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								员工编号
							</td>
							<td>
								员工姓名
							</td>
							<td>
								员工薪资
							</td>
							<td>
								员工年龄
							</td>
							<td>
								操作选项
							</td>
						</tr>
						<%
							//获取数据
							List<Emp>emps=(List<Emp>)request.getAttribute("emps");
						
							for(Emp e:emps){
						%>
						
						<tr class="row1">
							<td>
								<%=e.getEno() %>
							</td>
							<td>
								<%=e.getEname() %>
							</td>
							<td>
								<%=e.getSalary()%>
							</td>
							<td>
								<%=e.getAge() %>
							</td>
							<td>
								<a href="delete.do?id=<%=e.getEno() %>">删除员工</a>&nbsp;<a href="toUpdate.do?id=<%=e.getEno() %>">修改员工</a>
							</td>
						</tr>
						<%} %>
					</table>
					<p>
						<input type="button" class="button" value="添加员工" onclick="location='toAdd.do'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
    