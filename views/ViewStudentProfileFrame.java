package views;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class ViewStudentProfileFrame extends JFrame implements ActionListener{
	private JLabel userIDLabel,nameLabel,emailLabel,phoneNoLabel,rollLabel,ageLabel,DOBLabel,sectionLabel,adressLabel;
	private JButton backBtn;
	private JPanel panel;
	private ImageIcon backImg;
	private User u;
	
	public ViewStudentProfileFrame(User u){
		super("Your profile");
		this.setSize(400,600);
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.backImg=new ImageIcon("images/pencil4.jpg");
		
		this.panel= new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(backImg.getImage(),0,0,null);
			}
		};
        this.panel.setLayout(null);
		
		Student s=new Student();
		StudentController sc=new StudentController();
		s=sc.searchStudent(u.getUserID());
		
		this.userIDLabel = new JLabel("Your User ID: " + s.getUserID());
        this.userIDLabel.setBounds(20, 20, 300, 20);
        this.panel.add(userIDLabel);

        this.nameLabel = new JLabel("Name: " + s.getUserName());
        this.nameLabel.setBounds(20, 60, 300, 20);
        this.panel.add(nameLabel);


        this.DOBLabel = new JLabel("Date of Birth: "+s.getDOB());
        this.DOBLabel.setBounds(20, 100, 300, 20);
        this.panel.add(DOBLabel);
		
        this.ageLabel = new JLabel("Age: " + s.getAge());
        this.ageLabel.setBounds(20, 140, 300, 20);
        this.panel.add(ageLabel);
		
		
        this.sectionLabel = new JLabel("Section: " + s.getsectionID());
        this.sectionLabel.setBounds(20, 180, 300, 20);
        this.panel.add(sectionLabel);
		
        this.rollLabel= new JLabel("Roll NO: " + s.getRollNo());
        this.rollLabel.setBounds(20, 220, 300, 20);
        this.panel.add(rollLabel);
		
        this.adressLabel= new JLabel("Adress : " + s.getAdress());
        this.adressLabel.setBounds(20, 260, 300, 20);
        this.panel.add(adressLabel);
		
        this.phoneNoLabel= new JLabel("Phone No.: " + s.getPhoneNo());
        this.phoneNoLabel.setBounds(20, 300, 300, 20);
        this.panel.add(phoneNoLabel);
		
        this.emailLabel = new JLabel("Email: " + s.getEmail());
        this.emailLabel.setBounds(20, 340, 300, 20);
        this.panel.add(emailLabel);
		
		this.backBtn=new JButton(" Back ");
		this.backBtn.setBounds(130,380,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
        this.add(panel);
		this.u=u;
		
	}
	
	public void actionPerformed(ActionEvent ae){
		String command=ae.getActionCommand();
		
		if(command.equals(backBtn.getText())){
			StudentHomeFrame shf=new StudentHomeFrame(this.u);
			this.setVisible(false);
			shf.setVisible(true);
		}
	}
	
}