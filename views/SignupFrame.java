package views;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class SignupFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel,ageLabel, addressLabel, securityQuesLabel, securityAnsLabel,DOBLabel, passLabel,rollLabel,sectionLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF,rollTF,DOBTF;
	private JPasswordField passPF;
	private JButton submitBtn, backBtn;
	private JComboBox sectionCmb;
	private Color c1,c2;
	private JPanel panel;
/*String userID,int role,String password,String securityAns,String userName,int age,
String email,String phoneNo,int rollNo,String DOB,String sectionID,String adress,String gradeID*/
	
	public SignupFrame()
	{
		super("SignUp Frame");
		this.setSize(1100,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.c1=new Color(245, 129, 66);
		this.c2=new Color(230, 212, 188);
		
		this.panel=new JPanel();
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
		
		this.submitBtn=new JButton("Submit");
		this.submitBtn.setBounds(400,350,100,30);
		this.submitBtn.addActionListener(this);
		this.submitBtn.setBackground(c1);
		this.panel.add(submitBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(570,350,100,30);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(c1);
		this.panel.add(backBtn);
	
		this.add(panel);

		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			if(!userTF.getText().isEmpty() && !nameTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty() && !addressTF.getText().isEmpty() && !ageTF.getText().isEmpty() && !passPF.getText().isEmpty() && !securityAnsTF.getText().isEmpty() && !rollTF.getText().isEmpty() && !DOBTF.getText().isEmpty())
			{
				String userTFValue=userTF.getText();
				String nameValue=nameTF.getText();
				
				int ageValue=0;
				String inputAge=ageTF.getText();
				ageValue=Integer.parseInt(inputAge);
				
				String emailValue=emailTF.getText();
				String phoneNoValue=phoneNoTF.getText();
				String addressValue=addressTF.getText();
				String securityAnsValue=securityAnsTF.getText();
				String passwordValue=passPF.getText();
				
				String inputRoll=rollTF.getText();
				int rollValue=Integer.parseInt(inputRoll);
				
				String sectionValue=sectionCmb.getSelectedItem().toString();	//**
				String DOBValue=DOBTF.getText();
				int role=3;
				
				
				Student s=new Student(userTFValue,role,passwordValue,securityAnsValue,nameValue,ageValue,emailValue,phoneNoValue,rollValue,DOBValue,sectionValue,addressValue);
				
				UserController uc=new UserController();
				uc.insertUser(s);
				
				StudentController sc=new StudentController();
				sc.insertStudent(s);
				
				JOptionPane.showMessageDialog(this, "Registered Successfully !");
				
				LoginFrame lf=new LoginFrame();
				this.setVisible(false);
				lf.setVisible(true);
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please Fill Up All The Field Correctly !!");
			}
		}
		
		if(command.equals(backBtn.getText()))
		{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
	}
	
}