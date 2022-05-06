package week3.day1.org.Student;

import week3.day1.org.college.College;

public class MyStudent {

	public static void main(String[] args) {
		College c = new College();
		/*
		 * Method overloading - using constructor to differnt number or type of the
		 * arguments
		 */
		Student s = new Student(2018, 14, "Steve", "stv@gmail.com");
		Student s2 = new Student(28);
		
		System.out.println("Student Details s1:");
		s.studentId();
		s.studentName();
		s.studentMail();
		s.studentDepartment();
	

		System.out.println("\n Student Details s2:");
		s2.studentId();
		s2.studentName();
		s2.studentDepartment();
		s2.studentMail();
		s2.collegeName();
		/* c.college rank is not accessible directly as it has only package scope. */
	}

}
