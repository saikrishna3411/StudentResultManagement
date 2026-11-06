package com.nit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@PropertySource("classpath:com/nit/application.properties")
public class Student {
	
	
	@Value("${studentId}")
	private int studentId;
	@Value("${studentName}")
	private String studentName;
	@Value("${studentAddress}")
	private String studentAddress;
	@Value("${subject1Marks}")
	private float subject1Marks;
	@Value("${subject2Marks}")
	private float subject2Marks;
	@Value("${subject3Marks}")
	private float subject3Marks;
	@Value("${subject4Marks}")
	private float subject4Marks;
	
	@Value("${isAttendExam}")
	private boolean isAttendExam;
	
	@Autowired
	private University university;
	
	
	
	public String checkResult() {
		
		String result=null;
		if(isAttendExam) {
			System.out.println("Student Attend For Exams ");
			System.out.println("Marks Sourced in Subject");
			System.out.println("Subject1  "+subject1Marks );
			System.out.println("Subject2  "+subject2Marks );
			System.out.println("Subject3  "+subject3Marks );
			System.out.println("Subject4  "+subject4Marks );
			float total=subject1Marks+subject2Marks+subject3Marks+subject4Marks;
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("Total Marks Sourced"+total);
			float average=total/4;
			if(average>=90 && average<=100) {
				System.out.println("Your  Marks is "+average);
				result="A Grade";
			}
			else if(average>=70 && average<90) {
				System.out.println("Your  Marks is "+average);
				result="B Grade";
			}
			else {
				System.out.println("Your MArks is "+average);
				
				result="C Grade ";
			}
		}
		else {
			System.out.println("Student is Not Attend For Exams");
		}
		
		return result;
	}



	
	public String studentDetails() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ "]";
	}




	
	public String universityDetails() {
		return "Student [university=" + university + "]";
	}




	
	public String studentAllSubjectMarks() {
		return "Student [subject1Marks=" + subject1Marks + ", subject2Marks=" + subject2Marks + ", subject3Marks="
				+ subject3Marks + ", subject4Marks=" + subject4Marks + "]";
	}
	
	
	
	
	
	
	

}
