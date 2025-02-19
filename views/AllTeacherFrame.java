package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import models.*;
import controllers.*;

public class AllTeacherFrame extends JFrame implements ActionListener{
	private JButton backBtn;
	private JTable teacherTable;
	private JLabel titleLabel;
	private JScrollPane teacherTableSP;
	private JLabel imgLabel;
	private ImageIcon img;
	private Color c,c2;
	private User u;
	private JPanel panel;
	
	public AllTeacherFrame(User u){
		super ("All Teachers");
		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.c=new Color(245, 229, 108);
		this.c2=new Color(230, 212, 188);
		this.panel=new JPanel();
		this.panel.setBackground(c2);
		this.panel.setLayout(null);
		
		// this.titleLabel=new JLabel(" Teachers List ");
		// this.titleLabel.setBounds(400,30,200,50);
		// this.titleLabel.setFont(new Font("Cambria",Font.BOLD,30));
		// this.titleLabel.setForeground(Color.red);
		// this.panel.add(titleLabel);

		this.backBtn=new JButton("<<- Back");
		this.backBtn.setBounds(800,530,120,30);
		this.backBtn.setBackground(c);
		this.backBtn.addActionListener(this);
		
		this.panel.add(backBtn);
		
		TeacherController tc=new TeacherController();
		Teacher tcList[]=tc.getAllTeacher();
		
		String teacherData[][]=new String[tcList.length][6];
	for(int i=0;i<tcList.length;i++){
		if(tcList[i]!=null){
			
			teacherData[i][0]=tcList[i].getUserID();
			teacherData[i][1]=tcList[i].getUserName();
			teacherData[i][2]=String.valueOf(tcList[i].getAge());
			teacherData[i][3]=tcList[i].getEmail();
			teacherData[i][4]=tcList[i].getPhoneNo();
			teacherData[i][5]=tcList[i].getSubjectSpec();
		}
	}
	
		String head1[]={"Id","Name","Age","Email","Phone No","Subject"};
		
		this.teacherTable=new JTable(teacherData,head1);
	
		this.teacherTableSP=new JScrollPane(teacherTable);
		this.teacherTableSP.setBounds(50,150,900,350);
		this.teacherTable.setEnabled(false);
		this.panel.add(teacherTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		

		this.img=new ImageIcon("images/allT.jpg");
		this.imgLabel=new JLabel(img);
		this.imgLabel.setBounds(280,5,447,123);
		this.panel.add(imgLabel);
		this.add(panel);	
		
		this.u=u;
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		if(command.equals(backBtn.getText()))
		{
			if(u.getRole()==1){
			AdminHomeFrame adf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
			}
			else if(u.getRole()==2){
				TeachersHomeFrame thf=new TeachersHomeFrame(this.u);
				this.setVisible(false);
				thf.setVisible(true);
			}
			
			else {
			StudentHomeFrame shf =new StudentHomeFrame(this.u);
			this.setVisible(false);
			shf.setVisible(true);
		}
		}
	}
}