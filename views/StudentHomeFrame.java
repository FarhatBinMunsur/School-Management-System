package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import models.*;
import controllers.*;


public class StudentHomeFrame extends JFrame implements ActionListener
{
	private JLabel titleLabel;
	private JButton resultBtn,teacherBtn,profileBtn,updatePassBtn, logOutBtn,noticeBtn;
	private JPanel panel;
	private Color c,c2;
	private Font font1;
	private ImageIcon backImg;
	private User u;
	
	public StudentHomeFrame(User u)
	{
		
		super("Student Home Frame");
		this.setSize(850,480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.u=u;
		this.backImg=new ImageIcon("images/greenB.jpg");
		this.panel=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(backImg.getImage(),0,0,null);
			}
		};
		this.panel.setLayout(null);
		
		this.c=new Color(245, 229, 108);
		this.c2=new Color(242, 200, 189);
		
		Student s=new Student();
		StudentController sc=new StudentController();
		s=sc.searchStudent(u.getUserID());
		
		this.font1=new Font("Comic Sans MS", Font.BOLD,35);
		this.titleLabel=new JLabel("Hello, " +s.getUserName() + " !!");
		this.titleLabel.setBounds(200,30,400,50);
		//this.titleLabel.setOpaque(true);
		this.titleLabel.setFont(font1);
		this.panel.add(titleLabel);
		
		
		this.noticeBtn=new JButton("Notice");
		this.noticeBtn.setBounds(150,140,150,40);
		this.noticeBtn.addActionListener(this);
		this.noticeBtn.setBackground(c2);
		this.panel.add(noticeBtn);
		
		this.profileBtn=new JButton("View Profile");
		this.profileBtn.setBounds(330,140,150,40);
		this.profileBtn.addActionListener(this);
		this.profileBtn.setBackground(c2);
		this.panel.add(profileBtn);
		
		this.teacherBtn=new JButton("View teachers");
		this.teacherBtn.setBounds(150,230,150,40);
		this.teacherBtn.addActionListener(this);
		this.teacherBtn.setBackground(c2);
		this.panel.add(teacherBtn);		
		
		this.resultBtn=new JButton("View Result");
		this.resultBtn.setBounds(330,230,150,40);
		this.resultBtn.addActionListener(this);
		this.resultBtn.setBackground(c2);
		this.panel.add(resultBtn);
		
		this.updatePassBtn=new JButton("Update Password");
		this.updatePassBtn.setBounds(150,320,150,40);
		this.updatePassBtn.addActionListener(this);
		this.updatePassBtn.setBackground(c2);
		this.panel.add(updatePassBtn);
		
		this.logOutBtn=new JButton("Log Out");
		this.logOutBtn.setBounds(330,320,150,40);
		this.logOutBtn.addActionListener(this);
		this.logOutBtn.setBackground(c);
		this.panel.add(logOutBtn);
		
		
		
		this.add(panel);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try{
		String command=ae.getActionCommand();
		
		if(profileBtn.getText().equals(command))
		{
			ViewStudentProfileFrame vspf=new ViewStudentProfileFrame(this.u);
			this.setVisible(false);
			vspf.setVisible(true);
		}
		
		
		if(teacherBtn.getText().equals(command)){
			AllTeacherFrame atf=new AllTeacherFrame(this.u);
			this.setVisible(false);
			atf.setVisible(true);
		}
		
		if(resultBtn.getText().equals(command))
		{
			this.setVisible(false);
			StudentResultFrame srf=new StudentResultFrame(this.u);
			srf.setVisible(true);
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
		
		if(noticeBtn.getText().equals(command)){
			NoticeView nv=new NoticeView(this.u);
			this.setVisible(false);
			nv.setVisible(true);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
