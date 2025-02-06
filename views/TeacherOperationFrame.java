package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import models.*;
import controllers.*;
//String userID,int role,String password,String securityAns,String userName,int age,
//String email,String phoneNo,String subjectSpecialization,int salary
public class TeacherOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, ageLabel, securityQuesLabel, securityAnsLabel, passLabel, sspLabel,salaryLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF,salaryTF;
	private JPasswordField passPF;

	private JComboBox sspCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable teacherTable;
	private JScrollPane teacherTableSP;
	private JPanel panel;
	private Color c,c1,c2;
	private User u;
	
	public TeacherOperationFrame(User u)
	{
		super("Admin Operation Frame");
		this.setSize(800,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.c2=new Color(245, 238, 218);
		this.panel.setBackground(c2);
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(120,50,100,30);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.panel.add(nameTF);
		
		this.emailLabel=new JLabel("email:");
		this.emailLabel.setBounds(50,150,60,30);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(120,150,100,30);
		this.panel.add(emailTF);
		
		this.phoneNoLabel=new JLabel("phone No:");
		this.phoneNoLabel.setBounds(50,200,60,30);
		this.panel.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(120,200,100,30);
		this.panel.add(phoneNoTF);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(50,300,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(120,300,100,30);
		this.panel.add(ageTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your Favourite Game?:");
		this.securityQuesLabel.setBounds(280,100,300,30);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(280,150,100,30);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(390,150,100,30);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(280,200,100,30);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(390,200,100,30);
		this.panel.add(passPF);
		
		this.sspLabel=new JLabel("Subject :");
		this.sspLabel.setBounds(280,250,100,30);
		this.panel.add(sspLabel);
		
		String[] ssp={"Bangla","English","Math","ICT","BGS","Religion studies","Physics","Chemistry","Biology","Higher Math"};
		this.sspCMB=new JComboBox(ssp);
		this.sspCMB.setBounds(390,250,200,30);
		this.panel.add(sspCMB);
		
		this.salaryLabel=new JLabel("Salary");
		this.salaryLabel.setBounds(250,300,100,30);
		this.panel.add(salaryLabel);
		
		this.salaryTF=new JTextField();
		this.salaryTF.setBounds(390,300,100,30);
		this.panel.add(salaryTF);
		
		this.c=new Color(245, 229, 108);
		this.c1=new Color(230, 212, 188);
		
		this.addBtn=new JButton("Add Teacher");
		this.addBtn.setBounds(50,350,100,30);
		this.addBtn.addActionListener(this);
		this.addBtn.setBackground(c1);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("update Teacher");
		this.updateBtn.setBounds(160,350,120,30);
		this.updateBtn.addActionListener(this);
		this.updateBtn.setBackground(c1);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("remove Teacher");
		this.removeBtn.setBounds(290,350,120,30);
		this.removeBtn.addActionListener(this);
		this.removeBtn.setBackground(c1);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("search Teacher");
		this.searchBtn.setBounds(420,350,120,30);
		this.searchBtn.addActionListener(this);
		this.searchBtn.setBackground(c1);
		this.panel.add(searchBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(550,350,100,30);
		this.resetBtn.addActionListener(this);
		this.resetBtn.setBackground(c1);
		this.panel.add(resetBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(660,350,100,30);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(c);
		this.panel.add(backBtn);
		
		TeacherController tc=new TeacherController();
		Teacher[] teacherList =tc.getAllTeacher();

		String teacherData1[][] =new String[teacherList.length][7];
		for(int i=0;i<teacherList.length;i++)
		{
		
			if(teacherList[i]!=null)
			{
				System.out.println(teacherList[i].toStringTeacher());
				teacherData1[i][0]=teacherList[i].getUserID();
				teacherData1[i][1]=teacherList[i].getUserName();
				teacherData1[i][2]=String.valueOf(teacherList[i].getAge());
				teacherData1[i][3]=teacherList[i].getEmail();
				teacherData1[i][4]=teacherList[i].getPhoneNo();
				teacherData1[i][5]=teacherList[i].getSubjectSpec();
				teacherData1[i][6]=String.valueOf(teacherList[i].getSalary());
			}
			
			
			
		}
		
		String head1[]={"Id","Name","Age","Email","Phone No","Subject","Salary"};
		
		this.teacherTable=new JTable(teacherData1,head1);
	
		this.teacherTableSP=new JScrollPane(teacherTable);
		this.teacherTableSP.setBounds(50,400,700,200);
		this.teacherTable.setEnabled(false);
		this.panel.add(teacherTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);

		this.u=u;
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText()))
		{
			if(!userTF.getText().isEmpty() &&!nameTF.getText().isEmpty() && !ageTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty() && !securityAnsTF.getText().isEmpty() && !passPF.getText().isEmpty()&& !salaryTF.getText().isEmpty())
			{
				UserController uc=new UserController();
				TeacherController tc=new TeacherController();
				User u=uc.searchUser(userTF.getText());
				if(u!=null)
				{
					JOptionPane.showMessageDialog(this,"User Id is already used");
				}
				
				else
				{
					String userId=userTF.getText();
					String name=nameTF.getText();
					
					int age=0,salary=0;
					try
					{
						age=Integer.parseInt(ageTF.getText());
						salary=Integer.parseInt(salaryTF.getText());
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					String email=emailTF.getText();
					String phoneNo=phoneNoTF.getText();
					int role=2;
					String securityAns=securityAnsTF.getText();
					String password=passPF.getText();
					String ssp=sspCMB.getSelectedItem().toString();
					
					
					Teacher t=new Teacher(userId,role,password,securityAns,name,age,email,phoneNo,ssp,salary);
					uc.insertUser(t);
					tc.insertTeacher(t);
					JOptionPane.showMessageDialog(this,"Operation Successful");
					
					this.setVisible(false);
					TeacherOperationFrame thf=new TeacherOperationFrame(this.u);
					thf.setVisible(true);
				}	
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up field properly");
			}
				
		}
		
		if(command.equals(updateBtn.getText()))
		{
			if(!userTF.getText().isEmpty() &&!nameTF.getText().isEmpty() && !ageTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty() )
			{
				
				TeacherController tc=new TeacherController();
				Teacher t=tc.searchTeacher(userTF.getText());
				if(t!=null)
				{
					String userId=userTF.getText();
					String name=nameTF.getText();
					
					int age=0, salary=0;
					
					try
					{
						age=Integer.parseInt(ageTF.getText());
						salary=Integer.parseInt(salaryTF.getText());
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					String email=emailTF.getText();
					String phoneNo=phoneNoTF.getText();
					
					String ssp=sspCMB.getSelectedItem().toString();
					
					t.setUserName(name);
					t.setAge(age);
					t.setEmail(email);
					t.setPhoneNo(phoneNo);
					t.setSubjectSpec(ssp);
					t.setSalary(salary);
					tc.updateTeacher(t);
					JOptionPane.showMessageDialog(this,"Operation Successful");
					
					this.setVisible(false);
					TeacherOperationFrame tf=new TeacherOperationFrame(this.u);
					tf.setVisible(true);
					
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Teacher not found");
				}
				
				
				
				
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up field properly");
			}
			
		}
		
		if(command.equals(removeBtn.getText()))
		{
			if(!userTF.getText().isEmpty())
			{
				String userId=userTF.getText();
				UserController uc=new UserController();
				User user=uc.searchUser(userId);
				if(user!=null)
				{
					uc.deleteUser(userId);
					TeacherController tc=new TeacherController();
					tc.deleteTeacher(userId);
					JOptionPane.showMessageDialog(this,"Deleted Successfully");
					TeacherOperationFrame tf=new TeacherOperationFrame(this.u);
					this.setVisible(false);
					tf.setVisible(true);
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Not Found! Provide a valid ID.");
				}
				
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please Provide a UserID!");
			}
		}
		
		if(command.equals(searchBtn.getText()))
		{
			if(!userTF.getText().isEmpty())
			{
				TeacherController tc=new TeacherController();
				String userId=userTF.getText();
				Teacher t=tc.searchTeacher(userId);
				
				if(t!=null)
				{
					userTF.setEnabled(false);
					nameTF.setText(t.getUserName());
					
					ageTF.setText(String.valueOf(t.getAge()));
					emailTF.setText(t.getEmail());
					phoneNoTF.setText(t.getPhoneNo());
					sspCMB.setSelectedItem(t.getSubjectSpec());
					salaryTF.setText(String.valueOf(t.getSalary()));			
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Admin not found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"please provide userId");
			}
		}
		
		if(command.equals(resetBtn.getText()))
		{
			userTF.setEnabled(true);
			userTF.setText("");
			nameTF.setText("");
			ageTF.setText("");
			emailTF.setText("");
			phoneNoTF.setText("");
			passPF.setText("");
			securityAnsTF.setText("");
			salaryTF.setText("");
		}
		
		if(command.equals(backBtn.getText()))
		{
			AdminHomeFrame ahf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			ahf.setVisible(true);
			
		}
	}
	
}