package week3.day1.org.Student;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import week3.day1.org.department.Department;

public class Student extends Department {

	int year;
	int rollId;
	String email;
	String name;

	public Student(int year, int rollId, String name, String email) {
		this.year = year;
		this.rollId = rollId;
		this.name = name;
		this.email = email;

	}

	public Student(int rollId) {
		this.rollId = rollId;
		this.year = LocalDate.now().getYear();
		this.name = "protected for security reasons";
		this.email = "protected for security reasons";
	}

	public void studentName() {

		System.out.println("StudentName: " + name);

	}

	public void studentMail() {

		System.out.println("StudentMailId: " + email);

	}

	public void studentDepartment() {

		super.departmentName();

	}

	public void studentId() {

		System.out.println("StudentId:" + collegeCode() + year + departmentId() + rollId);
	}

}
