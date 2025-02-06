package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import models.*;
import controllers.*;

public class StudentOperationFrame extends JFrame implements ActionListener{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel,ageLabel, addressLabel, securityQuesLabel, securityAnsLabel,DOBLabel, passLabel,rollLabel,sectionLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF,rollTF,DOBTF;
	private JPasswordField passPF;
	private ButtonGroup bg;
	private JButton submitBtn,removeBtn,updateBtn,resetBtn,searchBtn,backBtn;
	private JComboBox sectionCmb;
	private ImageIcon backImg;
	private JTable studentTable;
	private JScrollPane studentTableSP;
	private Color c,c1,c2;
	private JPanel panel;
	private User u;
	
	public StudentOperationFrame(User u)
	{
		super("Student Operation Frame");
		this.setSize(1000,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		this.panel=new JPanel();
		this.c2=new Color(245, 238, 218);
		this.panel.setBackground(c2);
		this.panel.setLayout(null);
		
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(180,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(250,50,120,30);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(180,100,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(250,100,120,30);
		this.panel.add(nameTF);
		
		this.emailLabel=new JLabel("Email:");
		this.emailLabel.setBounds(180,150,60,30);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(250,150,120,30);
		this.panel.add(emailTF);
		
		this.phoneNoLabel=new JLabel("Phone No:");
		this.phoneNoLabel.setBounds(180,200,60,30);
		this.panel.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(250,200,120,30);
		this.panel.add(phoneNoTF);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(180,250,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(250,250,120,30);
		this.panel.add(ageTF);
		
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(650,50,60,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(730,50,160,30);
		this.panel.add(addressTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your favourite game? : ");
		this.securityQuesLabel.setBounds(650,100,300,30);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(650,150,100,30);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(770,150,120,30);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(650,200,100,30);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(770,200,120,30);
		this.panel.add(passPF);
		
		this.rollLabel=new JLabel("Roll no:");
		this.rollLabel.setBounds(650,250,100,30);
		this.panel.add(rollLabel);
		
		this.rollTF=new JTextField();
		this.rollTF.setBounds(770,250,120,30);
		this.panel.add(rollTF);
		
		this.DOBLabel=new JLabel("Date of Birth: ");
		this.DOBLabel.setBounds(650,300,100,30);
		this.panel.add(DOBLabel);
		
		this.DOBTF=new JTextField();
		this.DOBTF.setBounds(770,300,120,30);
		this.panel.add(DOBTF);
		
		
		this.sectionLabel=new JLabel("Section :");
		this.sectionLabel.setBounds(180,300,70,30);
		this.panel.add(sectionLabel);
		
		String data1[]={"6A","6B","7A","7B","8A","8B","9A","9B","10A","10B"};
		this.sectionCmb=new JComboBox(data1);
		this.sectionCmb.setBounds(270,300,60,30);
		this.panel.add(sectionCmb);
		
		
		this.c=new Color(245, 229, 108);
		this.c1=new Color(230, 212, 188);
		
		this.submitBtn=new JButton("Add");
		this.submitBtn.setBounds(170,350,100,30);
		this.submitBtn.addActionListener(this);
		this.submitBtn.setBackground(c1);
		this.panel.add(submitBtn);
		
		this.updateBtn=new JButton("Update");
		this.updateBtn.setBounds(290,350,100,30);
		this.updateBtn.addActionListener(this);
		this.updateBtn.setBackground(c1);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("Remove");
		this.removeBtn.setBounds(410,350,100,30);
		this.removeBtn.addActionListener(this);
		this.removeBtn.setBackground(c1);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("Search");
		this.searchBtn.setBounds(530,350,100,30);
		this.searchBtn.addActionListener(this);
		this.searchBtn.setBackground(c1);
		this.panel.add(searchBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(650,350,100,30);
		this.resetBtn.addActionListener(this);
		this.resetBtn.setBackground(c1);
		this.panel.add(resetBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(770,350,100,30);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(c);
		this.panel.add(backBtn);
		
		StudentController sc =new StudentController();
		Student [] studentList =sc.getAllStudent();
		
		String studentData[][]=new String[studentList.length][9];
		
		for(int i=0;i<studentList.length;i++){
			if(studentList[i]!=null){
				System.out.println(studentList[i].toStringStudent());
				studentData[i][0]=studentList[i].getUserID();
				studentData[i][1]=studentList[i].getUserName();
				studentData[i][2]=studentList[i].getEmail();
				studentData[i][3]=studentList[i].getPhoneNo();
				studentData[i][4]=String.valueOf(studentList[i].getAge());
				studentData[i][5]=studentList[i].getAdress();
				studentData[i][6]=String.valueOf(studentList[i].getRollNo());
				studentData[i][7]=studentList[i].getDOB();
				studentData[i][8]=studentList[i].getsectionID();
			}
		}
		
		String head1[]={"Id","Name","Email","Phone No","Age","Adress","Roll NO","Date of Birth","Section"};
		
		this.studentTable=new JTable(studentData,head1);
		this.studentTableSP=new JScrollPane(studentTable);
		this.studentTableSP.setBounds(160,400,730,200);
		this.studentTable.setEnabled(false);
		this.panel.add(studentTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		
		this.add(panel);
		this.u=u;
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			if(!userTF.getText().isEmpty() && !nameTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty() && !addressTF.getText().isEmpty() && !ageTF.getText().isEmpty() && !passPF.getText().isEmpty() && !securityAnsTF.getText().isEmpty() && !rollTF.getText().isEmpty() && !DOBTF.getText().isEmpty())
			{
				UserController uc=new UserController();
				StudentController sc=new StudentController();
				User u=uc.searchUser(userTF.getText());
				
				if(u!=null){
					JOptionPane.showMessageDialog(this,"User Id is already used");
				}
				
				else{
				
				String userTFValue=userTF.getText();
				String nameValue=nameTF.getText();
				
				int ageValue=Integer.parseInt(ageTF.getText());
				String emailValue=emailTF.getText();
				String phoneNoValue=phoneNoTF.getText();
				String addressValue=addressTF.getText();
				String securityAnsValue=securityAnsTF.getText();
				String passwordValue=passPF.getText();
				int rollValue=Integer.parseInt(rollTF.getText());
				String sectionValue=sectionCmb.getSelectedItem().toString();
				String DOBValue=DOBTF.getText();
				int role=3;
				
				
				Student s=new Student(userTFValue,role,passwordValue,securityAnsValue,nameValue,ageValue,emailValue,phoneNoValue,rollValue,DOBValue,sectionValue,addressValue);
	
				uc.insertUser(s);
				
				sc.insertStudent(s);
				
				JOptionPane.showMessageDialog(this, "Registered Successfully !");
				
				this.setVisible(false);
				StudentOperationFrame sof=new StudentOperationFrame(this.u);
				sof.setVisible(true);
			}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please Fill Up All The Field Correctly !!");
			}
		}
		
		if(command.equals(updateBtn.getText())){
			if(!userTF.getText().isEmpty() && !nameTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty() && !addressTF.getText().isEmpty() && !ageTF.getText().isEmpty() && !passPF.getText().isEmpty() && !securityAnsTF.getText().isEmpty() && !rollTF.getText().isEmpty() && !DOBTF.getText().isEmpty())
			{
				StudentController sc=new StudentController();
				String userID=userTF.getText();
				Student s=sc.searchStudent(userID);
				
				if(s!=null){
				String userTFValue=userTF.getText();
				String nameValue=nameTF.getText();
				
				int ageValue=Integer.parseInt(ageTF.getText());
				String emailValue=emailTF.getText();
				String phoneNoValue=phoneNoTF.getText();
				String addressValue=addressTF.getText();
	
				
				int rollValue=Integer.parseInt(rollTF.getText());
				String sectionValue=sectionCmb.getSelectedItem().toString();
				String DOBValue=DOBTF.getText();
				
				s.setUserName(nameValue);
				s.setAge(ageValue);
				s.setEmail(emailValue);
				s.setPhoneNo(phoneNoValue);
				s.setAdress(addressValue);
				s.setRollNo(rollValue);
				s.setsectionID(sectionValue);
				s.setDOB(DOBValue);
				
				sc.updateStudent(s);
				JOptionPane.showMessageDialog(this,"Operation Successful");
				
				this.setVisible(false);
				StudentOperationFrame sof=new StudentOperationFrame(this.u);
				sof.setVisible(true);
					
				
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Student not found");
				}
				
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up field properly");
			}
			
		}
		if(command.equals(removeBtn.getText())){
			try{
			if(!userTF.getText().isEmpty()){
				//int roll=Integer.parseInt(rollTF.getText());
				String userID=userTF.getText();
				UserController uc=new UserController();
				User u2= uc.searchUser(userID);
				
				if(u2!=null){
					uc.deleteUser(userID);
					
					StudentController sc=new StudentController();
					sc.deleteStudent(userID);
					
					JOptionPane.showMessageDialog(this,"Deleted Successfully");
					StudentOperationFrame sof=new StudentOperationFrame(this.u);
					this.setVisible(false);
					sof.setVisible(true);
					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Not Found! Provide a valid ID.");
				}
			}
			else{
					JOptionPane.showMessageDialog(this,"Please Provide a UserID!");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
		
		if(command.equals(searchBtn.getText())){
			if(!userTF.getText().isEmpty()){
				StudentController sc=new StudentController();
				String userID=userTF.getText();
				Student s=sc.searchStudent(userID);
			
			if(s!=null){
				userTF.setEnabled(true);
				nameTF.setText(s.getUserName());
				ageTF.setText(String.valueOf(s.getAge())) ;
				emailTF.setText(s.getEmail());
				phoneNoTF.setText(s.getPhoneNo());
				addressTF.setText(s.getAdress());
				rollTF.setText(String.valueOf(s.getRollNo()));
				DOBTF.setText(s.getDOB());
				
				
			}
			else{
				JOptionPane.showMessageDialog(this,"Student not found");
			}
		}
		
		else{
				JOptionPane.showMessageDialog(this,"please provide userId");
		}
	}
		
		
		if(command.equals(resetBtn.getText())){
			userTF.setEnabled(true);
			userTF.setText("");
			nameTF.setText("");
			ageTF.setText("");
			emailTF.setText("");
			phoneNoTF.setText("");
			passPF.setText("");
			addressTF.setText("");
			rollTF.setText("");
			DOBTF.setText("");
			securityAnsTF.setText("");
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			AdminHomeFrame ahf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			ahf.setVisible(true);
		}
	}
}