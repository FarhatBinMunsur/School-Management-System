package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import models.*;
import controllers.*;


public class AdminHomeFrame extends JFrame implements ActionListener
{
	
	private JButton adminBtn, studentBtn, teacherBtn, teachersBtn, studentsBtn,profileBtn, updatePassBtn, logOutBtn,sectionBtn,noticeBtn,paymentBtn;
	private JPanel panel;
	private ImageIcon backImg;
	private User u;
	private Color c,c2,c3,c4,c5;
	
	
	
	public AdminHomeFrame(User u)
	{
		
		super("Admin Home Frame");
		this.setSize(740,535);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.backImg=new ImageIcon("images/Admin3.jpg");
		this.panel=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(backImg.getImage(),0,0,null);
			}
		};
		this.panel.setLayout(null);
		
		/*
		this.img1=new ImageIcon("images/Admin.png"); 
		this.imgLabel=new JLabel(img1);
		this.imgLabel.setBounds(50,50,527,655);
		this.panel.add(imgLabel);
		*/
		
		this.c=new Color(250, 130, 130);
		this.c2=new Color(255, 255, 153);
		this.c3=new Color(255, 181, 112);
		this.c4=new Color(255, 228, 150);
		this.c5=new Color(204, 255, 204);
		

		this.adminBtn=new JButton("Admin operation");
		this.adminBtn.setBounds(90,50,150,50);
		this.adminBtn.addActionListener(this);
		this.adminBtn.setBackground(c2);
		this.panel.add(adminBtn);
		
		
		this.studentBtn=new JButton("Student operation");
		this.studentBtn.setBounds(260,50,150,50);
		this.studentBtn.addActionListener(this);
		this.studentBtn.setBackground(c2);
		this.panel.add(studentBtn);
		
		
		this.teacherBtn=new JButton("Teachers operation");
		this.teacherBtn.setBounds(450,50,150,50);
		this.teacherBtn.addActionListener(this);
		this.teacherBtn.setBackground(c2);
		this.panel.add(teacherBtn);
		
		this.teachersBtn=new JButton("View Teachers");
		this.teachersBtn.setBounds(260,150,150,50);
		this.teachersBtn.addActionListener(this);
		this.teachersBtn.setBackground(c4);
		this.panel.add(teachersBtn);
		
		this.studentsBtn=new JButton("View Students");
		this.studentsBtn.setBounds(450,150,150,50);
		this.studentsBtn.addActionListener(this);
		this.studentsBtn.setBackground(c4);
		this.panel.add(studentsBtn);
		
		this.profileBtn=new JButton("Update Profile");
		this.profileBtn.setBounds(170,350,150,50);
		this.profileBtn.addActionListener(this);
		this.profileBtn.setBackground(c3);
		this.panel.add(profileBtn);
		
		this.updatePassBtn=new JButton("Update Password");
		this.updatePassBtn.setBounds(340,350,150,50);
		this.updatePassBtn.addActionListener(this);
		this.updatePassBtn.setBackground(c3);
		this.panel.add(updatePassBtn);
		
		this.sectionBtn=new JButton("Section Operation");
		this.sectionBtn.setBounds(170,250,150,50);
		this.sectionBtn.addActionListener(this);
		this.sectionBtn.setBackground(c5);
		this.panel.add(sectionBtn);
		
		
		this.noticeBtn=new JButton("Notice");
		this.noticeBtn.setBounds(90,150,150,50);
		this.noticeBtn.setBackground(c4);
		this.noticeBtn.addActionListener(this);
		this.panel.add(noticeBtn);
		
		this.paymentBtn=new JButton("Payment Operation");
		this.paymentBtn.setBounds(340,250,150,50);
		this.paymentBtn.setBackground(c5);

		this.paymentBtn.addActionListener(this);
		this.panel.add(paymentBtn);

		
		this.logOutBtn=new JButton("Log Out");
		this.logOutBtn.setBounds(270,435,100,50);
		this.logOutBtn.setBackground(c);
		this.logOutBtn.addActionListener(this);
		this.panel.add(logOutBtn);
		
		this.add(panel);
		this.u=u;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try{
		String command=ae.getActionCommand();
		
		if(adminBtn.getText().equals(command))
		{
			AdminOperationFrame aof=new AdminOperationFrame(u);
			this.setVisible(false);
			aof.setVisible(true);
		}
		
		if(teacherBtn.getText().equals(command)){
			TeacherOperationFrame tf=new TeacherOperationFrame(this.u);
			this.setVisible(false);
			tf.setVisible(true);
		}
		
		if(studentBtn.getText().equals(command)){
			StudentOperationFrame sof=new StudentOperationFrame(this.u);
			this.setVisible(false);
			sof.setVisible(true);
		}
		
		if(teachersBtn.getText().equals(command))
		{
			this.setVisible(false);
			AllTeacherFrame atf=new AllTeacherFrame(this.u);
			atf.setVisible(true);
		}
		
		if(studentsBtn.getText().equals(command))
		{
			this.setVisible(false);
			AllStudentFrame asf=new AllStudentFrame(this.u);
			asf.setVisible(true);
		}
		
		if(profileBtn.getText().equals(command))
		{
			this.setVisible(false);
			UpdateProfileFrame upf=new UpdateProfileFrame(this.u);
			upf.setVisible(true);
		}
		
		if(logOutBtn.getText().equals(command)){
			LoginFrame lgf=new LoginFrame();
			this.setVisible(false);
			lgf.setVisible(true);
		}
		if(updatePassBtn.getText().equals(command)){
			ForgetPassFrame fpf=new ForgetPassFrame(this.u);
			this.setVisible(false);
			fpf.setVisible(true);
		}
		
		if(sectionBtn.getText().equals(command)){
			SectionOperationFrame sof= new SectionOperationFrame(this.u);
			this.setVisible(false);
			sof.setVisible(true);
		}
		if(noticeBtn.getText().equals(command)){
			NoticeOperationFrame nof=new NoticeOperationFrame(this.u);
			this.setVisible(false);
			nof.setVisible(true);
		}

		if(paymentBtn.getText().equals(command)){
			PaymentOperationFrame pof=new PaymentOperationFrame(this.u);
			this.setVisible(false);
			pof.setVisible(true);
		}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
