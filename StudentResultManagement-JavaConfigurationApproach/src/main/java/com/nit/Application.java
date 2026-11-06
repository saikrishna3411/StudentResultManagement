package com.nit;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(UniversityConfig.class);
		
		Student student=context.getBean("student",Student.class);
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("               Check Your Result");
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("Press 1 for Results");
			System.out.println("Press 2 for StudentDetails");
			System.out.println("Press 3 for UniveristyDetails");
			System.out.println("Press 4 for All Subject Marks");
			System.out.println("Press 5 for Exist");
			System.out.println(" ");
			System.out.println(" ");
			int enterValue =sc.nextInt();
			
			switch(enterValue) {
			
			case 1: String checkResult = student.checkResult();
					System.out.println(checkResult);
					break;
			case 2: String studentDetails = student.studentDetails();
					System.out.println(studentDetails);
					break;
			case 3: String universityDetails = student.universityDetails();
					System.out.println(universityDetails);
					break;
			case 4:String studentAllSubjectMarks = student.studentAllSubjectMarks();
				System.out.println(studentAllSubjectMarks);
					break;
			case 5:System.out.println("Thank You Visit Again ..");
					System.exit(0);
			default:
				System.out.println("Choise the Correst Option \n Invaild Data");
			
			}
			
			
		}
		
	}

}
