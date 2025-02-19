package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import models.*;
import controllers.*;


public class TeachersHomeFrame extends JFrame implements ActionListener
{
	
	private JButton  studentBtn, teacherBtn, teachersBtn, studentsBtn,profileBtn, updatePassBtn, noticeBtn,logOutBtn;
	private JPanel panel;
	private ImageIcon backImg;
	private Color c,c2;
	private User u;
	
	public TeachersHomeFrame(User u)
	{
		
		super("Teacher Home Frame");
		this.setSize(600,430);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.backImg=new ImageIcon("images/teacher3.jpg");
		this.panel=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(backImg.getImage(),0,0,null);
			}
		};
		this.panel.setLayout(null);
		
		this.c=new Color(245, 229, 108);
		this.c2=new Color(222, 209, 177);
		
		this.studentBtn=new JButton("Upload Grade");
		this.studentBtn.setBounds(220,40,150,40);
		this.studentBtn.addActionListener(this);
		this.studentBtn.setBackground(c2);
		this.panel.add(studentBtn);
		
		this.studentsBtn=new JButton("View Students");
		this.studentsBtn.setBounds(220,100,150,40);
		this.studentsBtn.addActionListener(this);
		this.studentsBtn.setBackground(c2);
		this.panel.add(studentsBtn);
		
		this.profileBtn=new JButton("View Profile");
		this.profileBtn.setBounds(220,160,150,40);
		this.profileBtn.addActionListener(this);
		this.profileBtn.setBackground(c2);
		this.panel.add(profileBtn);
		
		this.updatePassBtn=new JButton("Update Password");
		this.updatePassBtn.setBounds(220,220,150,40);
		this.updatePassBtn.addActionListener(this);
		this.updatePassBtn.setBackground(c2);
		this.panel.add(updatePassBtn);
		
		this.noticeBtn=new JButton("Notice");
		this.noticeBtn.setBounds(220,280,150,40);
		this.noticeBtn.setBackground(c2);
		this.noticeBtn.addActionListener(this);
		this.panel.add(noticeBtn);
		
		this.logOutBtn=new JButton("Log Out");
		this.logOutBtn.setBounds(240,330,120,40);
		this.logOutBtn.addActionListener(this);
		this.logOutBtn.setBackground(c);
		this.panel.add(logOutBtn);
		
		
		
		
		this.add(panel);
		this.u=u;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try{
		String command=ae.getActionCommand();
		/*
		if(adminBtn.getText().equals(command))
		{
			AdminOperationFrame aof=new AdminOperationFrame(u);
			this.setVisible(false);
			aof.setVisible(true);
		}*/
		
		/*
		if(teacherBtn.getText().equals(command)){
			TeacherOperationFrame tf=new TeacherOperationFrame(this.u);
			this.setVisible(false);
			tf.setVisible(true);
		}
		*/
		
		if(studentBtn.getText().equals(command)){
			GradeOperationFrame gof=new GradeOperationFrame(this.u);
			this.setVisible(false);
			gof.setVisible(true);
		}
		
		/*if(teachersBtn.getText().equals(command))
		{
			this.setVisible(false);
			AllTeacherFrame atf=new AllTeacherFrame(this.u);
			atf.setVisible(true);
		}*/
		
		if(studentsBtn.getText().equals(command))
		{
			this.setVisible(false);
			// AllStudentFrame asf=new AllStudentFrame(this.u);
			// asf.setVisible(true);
			AssignedSection as=new AssignedSection(this.u);
			as.setVisible(true);
		}
		
		if(profileBtn.getText().equals(command))
		{
			this.setVisible(false);
			ViewTeacherProfileFrame vtpf=new ViewTeacherProfileFrame(this.u);
			vtpf.setVisible(true);
		}
		
		if(noticeBtn.getText().equals(command)){
			NoticeView nv=new NoticeView(this.u);
			this.setVisible(false);
			nv.setVisible(true);
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
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
