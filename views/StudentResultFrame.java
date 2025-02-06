package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import models.*;
import controllers.*;

public class StudentResultFrame extends JFrame implements ActionListener{
	
	
	private User u;
	private JLabel subjectLabel,titleLabel;
	private JButton backBtn;
	private JPanel panel;
	private ImageIcon backImg;
	private Font font1;
	
	public StudentResultFrame(User u){
	
	super("Your Result");
	this.setSize(450,600);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.backImg=new ImageIcon("images/result.jpg");
		
		this.panel= new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(backImg.getImage(),0,0,null);
			}
		};
	this.panel.setLayout(null);
	
	this.font1=new Font("Comic Sans MS", Font.BOLD,20);
	this.titleLabel=new JLabel("Result Sheet");
	this.titleLabel.setBounds(150,100,140,30);
	this.titleLabel.setOpaque(true);
	this.titleLabel.setFont(font1);
	this.panel.add(titleLabel);

	
	GradeController gc=new GradeController();
	Grade grades[]=gc.getAllGrade();
	
	for(int i=0,j=150;i<grades.length && j<500;i++,j+=20){
		if(grades[i]!=null && grades[i].getStudentID().equals(u.getUserID())){
			SubjectController sc=new SubjectController();
			Subject s=sc.searchSubject(grades[i].getSubjectID());
			this.subjectLabel=new JLabel("Subject: "+s.getSubjectName()+"     result: "+grades[i].getGradeID());
			this.subjectLabel.setBounds(100,j,200,30);
			this.panel.add(subjectLabel);
		}
	}
	
	this.backBtn=new JButton(" Back ");
	this.backBtn.setBounds(150,450,100,30);
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