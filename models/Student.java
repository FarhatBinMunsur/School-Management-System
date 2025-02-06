package models;
import java.lang.*;

public class Student extends User{
	private int rollNo;
	private String DOB;
	private String adress;
	private String sectionID;
	private String gradeID;
	
	public Student(){
	}
	
	public Student(String userID,int role,String password,String securityAns,String userName,int age,String email,String phoneNo,int rollNo,String DOB,String sectionID,String adress){
		super(userID,role,password,securityAns);
		this.userName=userName;
		this.age=age;
		this.email=email;
		this.phoneNo=phoneNo;
		this.rollNo=rollNo;
		this.DOB=DOB;
		this.sectionID=sectionID;
		this.adress=adress;
		
		
	}
	
	public void setRollNo(int rollNo){
		this.rollNo=rollNo;
	}
	
	public void setDOB(String DOB){
		this.DOB=DOB;
	}
	
	public void setsectionID(String sectionID){
		this.sectionID=sectionID;
	}
	
	public void setAdress(String adress){
		this.adress=adress;
	}

	
	public int getRollNo(){
		return this.rollNo;
	}
	
	public String getDOB(){
		return this.DOB;
	}
	
	public String getsectionID(){
		return this.sectionID;
	}
	
	public String getAdress(){
		return this.adress;
	}

	public String toStringStudent(){
		String str=this.userID+","+this.userName+","+this.age+","+this.email+","+this.phoneNo+","+this.role+","+this.password+","+this.securityAns+","+this.rollNo+","+this.DOB+","+this.sectionID+","+this.adress+"\n";
		
	return str;
	}
	
	public Student formStudent(String str){
		String data[] = str.split(",");
		
		Student st= new Student();
		st.setUserID(data[0]);
		st.setUserName(data[1]);
		st.setAge(Integer.parseInt(data[2]));
		st.setEmail(data[3]);
		st.setPhoneNo(data[4]);
		st.setRole(Integer.parseInt(data[5]));
		st.setPassword(data[6]);
		st.setSecurityAns(data[7]);
		st.setRollNo(Integer.parseInt(data[8]));
		st.setDOB(data[9]);
		st.setsectionID(data[10]);
		st.setAdress(data[11]);
		
		return st;
	
	}
	
	
	
}