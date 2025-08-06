# 👨‍💼 Employee Management System (Java + MySQL)

This project is a **Java-based Employee Management System** using **Swing GUI** and **MySQL** with **JDBC**. It features secure login for employees and managers, project tracking, and real-time database updates in a user-friendly graphical interface.

---

## 📌 Features

### 🔐 Authentication
- Employee and Manager login portals.
- Credentials verified via MySQL `SELECT` queries.

### 👤 Employee Panel
- View employee ID, name, and assigned project.
- Option to mark assigned project as completed.

### 🧑‍💼 Manager Panel
- View manager details and their project.
- Assign unassigned employees to projects.
- Remove employees from their current project.

### 🛢 Database Integration (JDBC)
- Connects to MySQL using:
  ```java
  DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "1234");
