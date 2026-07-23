# 员工信息管理系统 (JavaWeb-Exam)

## 项目简介
基于 Servlet + JSP + JDBC 的员工信息管理系统，实现员工信息的增删改查和登录功能。

## 技术栈
- Java Servlet 3.1 + JSP
- JDBC + MySQL
- DAO 分层架构

## 功能列表
- 员工列表查询
- 员工添加
- 员工修改
- 员工删除
- 登录验证

## 运行要求
- JDK 8+
- Tomcat 8+
- MySQL 5.7+

## 数据库配置
1. 创建数据库 `test`
2. 执行建表 SQL:
```sql
CREATE TABLE emp (
  eno   INT PRIMARY KEY AUTO_INCREMENT,
  ename VARCHAR(50),
  pwd   VARCHAR(50),
  salary DOUBLE,
  age   INT
);
INSERT INTO emp VALUES (NULL, 'admin', '123456', 8000, 28);
```
3. 修改 `src/com/qf/util/DBUtil.java` 中的数据库连接信息

## 访问地址
启动后访问 `http://localhost:8080/EmpProject/`
