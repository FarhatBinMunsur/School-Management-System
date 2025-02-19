package views;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class AllStudentFrame extends JFrame implements ActionListener{
	private JLabel titleLabel;
	private JButton backBtn;
	private JTable studentTable;
	private JScrollPane studentTableSP;
	private User u;
	private ImageIcon img;
	private JLabel imgLabel;
	private Color c,c1;
	private JPanel panel;
	
	public AllStudentFrame(User u){
		super ("All Students");
		this.setSize(1000,700);
		this.c=new Color(245, 229, 108);
		this.c1=new Color(230, 212, 188);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.panel=new JPanel();
		
		this.panel.setBackground(c1);
		this.panel.setLayout(null);

		// this.titleLabel=new JLabel(" Students List ");
		// this.titleLabel.setBounds(400,30,200,50);
		// this.titleLabel.setFont(new Font("Cambria",Font.BOLD,30));
		// this.titleLabel.setForeground(Color.red);
		// this.panel.add(titleLabel);

		this.backBtn=new JButton("<<- Back");
		this.backBtn.setBounds(800,530,120,30);
		this.backBtn.setBackground(c);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		StudentController st=new StudentController();
		Student stList[]=st.getAllStudent();
		
		String studentData[][]=new String[stList.length][9];
	for(int i=0;i<stList.length;i++){
		if(stList[i]!=null){
			
			studentData[i][0]=stList[i].getUserID();
			studentData[i][1]=stList[i].getUserName();
			studentData[i][2]=String.valueOf(stList[i].getAge());
			studentData[i][3]=stList[i].getEmail();
			studentData[i][4]=stList[i].getPhoneNo();
			studentData[i][5]=String.valueOf(stList[i].getRollNo());
			studentData[i][6]=stList[i].getDOB();
			studentData[i][7]=stList[i].getsectionID();
			studentData[i][8]=stList[i].getAdress();
			
			
		}
	}
	
		String head1[]={"Id","Name","Age","Email","Phone No","Roll no","Date Of Birth","Section","Adress"};
		
		this.studentTable=new JTable(studentData,head1);
	
		this.studentTableSP=new JScrollPane(studentTable);
		this.studentTableSP.setBounds(50,150,900,350);
		this.studentTable.setEnabled(false);
		this.panel.add(studentTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.img=new ImageIcon("images/allS.jpg");
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