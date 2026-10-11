# 员工信息管理系统（Web-Exam-Servlet）

> Servlet + JSP + JDBC 原生 JavaWeb 实战

## 📖 项目简介

一个不依赖任何框架、基于**原生 Servlet 3.1 + JSP + JDBC** 的员工信息管理系统，采用经典 DAO 分层，实现登录验证与员工信息的增删改查，适合作为 JavaWeb 入门与课程实训的基础模板。

## ✨ 功能特性

- 员工列表查询
- 员工添加 / 修改 / 删除
- 登录验证
- JSP 页面 + Servlet 控制器 + DAO 三层结构

## 🛠 技术栈

- Java Servlet 3.1 + JSP
- JDBC + MySQL（`WebContent/WEB-INF/lib/mysqldriver.jar`）
- Eclipse Dynamic Web Project 结构
- DAO 分层架构

## 📂 目录结构

```
Web-Exam-Servlet/
├── WebContent/
│   ├── WEB-INF/web.xml            # Servlet 映射与配置
│   ├── WEB-INF/lib/mysqldriver.jar
│   ├── login.jsp                  # 登录页
│   ├── main.jsp                   # 主/列表页
│   ├── add.jsp                    # 新增页
│   ├── update.jsp                 # 修改页
│   ├── css/  img/
├── src/com/qf/
│   ├── entity/Emp.java
│   ├── dao/EmpDao.java
│   ├── servlet/EmpServlet.java
│   └── util/DBUtil.java           # 数据库连接工具
└── build/                          # 编译产物
```

## 🚀 快速开始

1. **环境**：JDK 8+、Tomcat 8+、MySQL 5.7+。
2. **建库建表**：

```sql
CREATE DATABASE test DEFAULT CHARSET utf8mb4;
USE test;
CREATE TABLE emp (
  eno    INT PRIMARY KEY AUTO_INCREMENT,
  ename  VARCHAR(50),
  pwd    VARCHAR(50),
  salary DOUBLE,
  age    INT
);
INSERT INTO emp VALUES (NULL, 'admin', '123456', 8000, 28);
```

3. 修改 `src/com/qf/util/DBUtil.java` 中的数据库连接信息。
4. 导入 Eclipse 并部署到 Tomcat，访问：

```
http://localhost:8080/EmpProject/
```

## ⚠️ 说明

- 示例中的默认账号（`admin / 123456`）仅用于本地演示，请勿用于生产环境。
- 项目使用 `WebContent` 目录结构，需以 Eclipse Dynamic Web Project 方式导入。
