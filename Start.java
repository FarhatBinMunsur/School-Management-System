import java.lang.*;
import controllers.*;
import models.*;
import views.*;

public class Start{
	
	public static void main(String [] args){
		/*
		//USER
		String data[]=new String[3];
		
		data[0]="A2,1,8890,football\n";
		
		FileIO fio=new FileIO();
		String fileName1="controllers/data/users.txt";
		String fileName2="controllers/data/students.txt";
		String fileName3="controllers/data/teachers.txt";
		
		fio.writeFile(fileName1,data);
		
		
		
		String data1[]=new String[3];
		String data2[]=new String[3];
		
		data1[0]="S1,3,1232,fBall,Rahim,27,rahim@,012,2,9-1-2007,9A,Dhaka,A+";
		data2[0]="T1,2,3452,cricket,Karimm,24,karim@,012,English,24000";
		fio.writeFile(fileName2,data1);
		fio.writeFile(fileName3,data2);
		
		
		User u1=new User("A1",1,"1234","cricket");
		Student st2=new Student("S2",3,"1232","fBall","Rahim",17,"rahim@","012",2,"9-1-2007","9A","Dhaka","A+");	//(String userID,int role,String password,String securityAns,String userName,int age,String email,String phoneNo,int rollNo,String DOB,String sectionID,String adress,String gradeID)	
		Teacher t3=new Teacher("T2",2,"4656","BasketBall","Fahim",23,"fahim@","012","Bangla",25000);//(String userID,int role,String password,String securityAns,String userName,int age,String email,String phoneNo,String subjectSpecialization,int salary)
		
		UserController uc=new UserController();
		StudentController stc =new StudentController();
		TeacherController tc =new TeacherController();
		
		uc.insertUser(u1);
		stc.insertStudent(st2);
		tc.insertTeacher(t3);
		
		
		
	//SUBJECT
	Subject s1=new Subject("101","Bangla");
	Subject s2=new Subject("102","English");
	Subject s3=new Subject("109","Math");
	Subject s4=new Subject("129","ICT");
	Subject s5=new Subject("123","BGS");
	Subject s6=new Subject("145","Islamic studies");
	
	SubjectController sc=new SubjectController();
	
	sc.insertSubject(s1);
	sc.insertSubject(s2);
	sc.insertSubject(s3);
	sc.insertSubject(s4);
	sc.insertSubject(s5);
	sc.insertSubject(s6);
	
	String fileName4="controllers/data/subjects.txt";
	//FileIO fio=new FileIO();
	String subjects[] = fio.readFile(fileName4);
	
	

s4.setSubjectName("ICT-1");
sc.updateSubject(s4);	
	//FileIO fio=new FileIO();
	subjects = fio.readFile(fileName4);
for(int i=0;i<subjects.length;i++){
		if(subjects[i]!=null){
		System.out.println(subjects[i]);
	}
	}
	System.out.println(s4.getSubjectID());
	
	sc.deleteSubject("123");
	System.out.println(sc.searchSubject("145").getSubjectName());
	*/
	
	LoginFrame lf=new LoginFrame();
	lf.setVisible(true);
	}
}
