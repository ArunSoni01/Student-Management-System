# 🎓 Student Management System (Java + JDBC)

A simple **console-based Student Management System** built with Java, JDBC, and MySQL. This project demonstrates clean architecture and separation of concerns using repository and service layers.


---

## 🚀 Features

- Add a new student
- View all students
- Update existing student details
- Delete a student by ID
- Find a student by ID
- JDBC-based connection to a MySQL database

---

## 🧠 Technologies Used

- Java 8 and above
- JDBC (Java Database Connectivity)
- MySQL
- Maven (optional if you integrate build lifecycle)

---

## 🛠️ Setup Instructions

### 1. 🧱 Database Setup

Create a MySQL database and a `student` table:

```sql
CREATE DATABASE student_db;

USE student_db;

CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    email VARCHAR(100)
);
```
### 2. ⚙️ Configuration File
Create a db.properties file in src/main/resources/ with the following content:

```
db.url=jdbc:mysql://localhost:3306/student_db
db.username=your_mysql_username
db.password=your_mysql_password
```
💡 Replace your_mysql_username and your_mysql_password with your actual credentials.

---
## 🧪 How to Run
1. Import the project into IntelliJ, VS Code or Eclipse

2. Make sure MySQL is running and jdbc_practice DB exists

3. Add MySQL JDBC driver:
    - Maven dependency:
        ```
        <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
          <version>8.0.29</version>
        </dependency>
        ```
    - Or manually add the .jar file

4. Run the Main class and follow the menu
