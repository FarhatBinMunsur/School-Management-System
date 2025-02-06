package models;
import java.lang.*;

public class Teacher extends User{
	private String subjectSpecialization;
	private int salary;
	
	public Teacher (){}
	
	public Teacher (String userID,int role,String password,String securityAns,String userName,int age,String email,String phoneNo,String subjectSpecialization,int salary){
		super(userID,role,password,securityAns);
		this.userName=userName;
		this.age=age;
		this.email=email;
		this.phoneNo=phoneNo;
		this.subjectSpecialization=subjectSpecialization;
		this.salary=salary;
	}
	
	public void setSubjectSpec(String subjectSpecialization){
		this.subjectSpecialization=subjectSpecialization;
	}
	
	
	public void setSalary(int salary){
		this.salary=salary;
	}
	
	public String getSubjectSpec(){
		return this.subjectSpecialization;
	}
	
	public int getSalary(){
		return this.salary;
	}
	
	public String toStringTeacher(){
		String str=this.userID+","+this.userName+","+this.age+","+this.email+","+this.phoneNo+","+this.subjectSpecialization+","+this.salary+"\n";
		
		return str;
	}
	
	public Teacher formTeacher(String str){
		String data[]=str.split(",");
		
		Teacher t =new Teacher();
		
		t.setUserID(data[0]);
		t.setUserName(data[1]);
		t.setAge(Integer.parseInt(data[2]));
		t.setEmail(data[3]);
		t.setPhoneNo(data[4]);
		t.setSubjectSpec(data[5]);
		t.setSalary(Integer.parseInt(data[6]));
		
		return t;
	}
	

}