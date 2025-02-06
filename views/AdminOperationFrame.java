package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import models.*;
import controllers.*;

public class AdminOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, ageLabel, securityQuesLabel, securityAnsLabel, passLabel, adminTypeLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF;
	private JPasswordField passPF;
	private JComboBox adminTypeCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable adminTable;
	private JScrollPane adminTableSP;
	private Color c,c1,c2;
	private JPanel panel;
	private User u;
	
	public AdminOperationFrame(User u)
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
		this.ageLabel.setBounds(50,250,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(120,250,100,30);
		this.panel.add(ageTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your Favourite Game?:");
		this.securityQuesLabel.setBounds(280,50,300,30);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(280,100,100,30);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(390,100,100,30);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(280,150,100,30);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(390,150,100,30);
		this.panel.add(passPF);
		
		this.adminTypeLabel=new JLabel("Admin Type:");
		this.adminTypeLabel.setBounds(280,200,100,30);
		this.panel.add(adminTypeLabel);
		
		String[] type={"Head Admin", "Management Admin"};
		this.adminTypeCMB=new JComboBox(type);
		this.adminTypeCMB.setBounds(390,200,200,30);
		this.panel.add(adminTypeCMB);
		
		this.c=new Color(245, 229, 108);
		this.c1=new Color(230, 212, 188);
		
		this.addBtn=new JButton("Add Admin");
		this.addBtn.setBounds(50,350,100,30);
		this.addBtn.addActionListener(this);
		this.addBtn.setBackground(c1);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("update Admin");
		this.updateBtn.setBounds(160,350,120,30);
		this.updateBtn.addActionListener(this);
		this.updateBtn.setBackground(c1);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("remove Admin");
		this.removeBtn.setBounds(290,350,120,30);
		this.removeBtn.addActionListener(this);
		this.removeBtn.setBackground(c1);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("search Admin");
		this.searchBtn.setBounds(420,350,120,30);
		this.searchBtn.addActionListener(this);
		this.searchBtn.setBackground(c1);
		this.panel.add(searchBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(550,350,100,30);
		this.resetBtn.addActionListener(this);
		this.resetBtn.setBackground(c1);
		this.panel.add(resetBtn);
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(660,350,100,30);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(c);
		this.panel.add(backBtn);
		
		AdminController adc=new AdminController();
		Admin[] adminList=adc.getAllAdmin();

		String adminData1[][]=new String[adminList.length][6];
		for(int i=0;i<adminList.length;i++)
		{
		
			if(adminList[i]!=null)
			{
				System.out.println(adminList[i].toStringAdmin());
				adminData1[i][0]=adminList[i].getUserID();
				adminData1[i][1]=adminList[i].getUserName();
				adminData1[i][2]=String.valueOf(adminList[i].getAge());
				adminData1[i][3]=adminList[i].getEmail();
				adminData1[i][4]=adminList[i].getPhoneNo();
				adminData1[i][5]=adminList[i].getAdminType();
			}
			
		}
		
		String head1[]={"Id","Name","Age","Email","Phone No","AdminType"};
		
		this.adminTable=new JTable(adminData1,head1);
	
		this.adminTableSP=new JScrollPane(adminTable);
		this.adminTableSP.setBounds(50,400,700,200);
		this.adminTable.setEnabled(false);
		this.panel.add(adminTableSP);
		
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
			if(!userTF.getText().isEmpty() && !nameTF.getText().isEmpty() && !ageTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty() && !securityAnsTF.getText().isEmpty() && !passPF.getText().isEmpty())
			{
				UserController uc=new UserController();
				AdminController adc=new AdminController();
				User u=uc.searchUser(userTF.getText());
				if(u!=null)
				{
					JOptionPane.showMessageDialog(this,"User Id is already used");
				}
				
				else
				{
					String userId=userTF.getText();
					String name=nameTF.getText();
					
					int age=0;
					try
					{
						age=Integer.parseInt(ageTF.getText());
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					String email=emailTF.getText();
					String phoneNo=phoneNoTF.getText();
					int role=1;
					String securityAns=securityAnsTF.getText();
					String password=passPF.getText();
					String adminType=adminTypeCMB.getSelectedItem().toString();
					
					Admin a=new Admin(userId,name,age,email,phoneNo,role,password,securityAns,adminType);
					uc.insertUser(a);
					adc.insertAdmin(a);
					JOptionPane.showMessageDialog(this,"Operation Successful");
					
					this.setVisible(false);
					AdminOperationFrame ahf=new AdminOperationFrame(u);
					ahf.setVisible(true);
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
				
				AdminController adc=new AdminController();
				Admin a=adc.searchAdmin(userTF.getText());
				if(a!=null)
				{
					String userId=userTF.getText();
					String name=nameTF.getText();
					
					int age=0;
					
					try
					{
						age=Integer.parseInt(ageTF.getText());
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					String email=emailTF.getText();
					String phoneNo=phoneNoTF.getText();
					
					String adminType=adminTypeCMB.getSelectedItem().toString();
					
					
					a.setUserName(name);
					a.setAge(age);
					a.setEmail(email);
					a.setPhoneNo(phoneNo);
					a.setAdminType(adminType);
					adc.updateAdmin(a);
					JOptionPane.showMessageDialog(this,"Operation Successful");
					
					this.setVisible(false);
					AdminOperationFrame ahf=new AdminOperationFrame(u);
					ahf.setVisible(true);
					
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Admin not found");
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
					AdminController adc=new AdminController();
					adc.deleteAdmin(userId);
					JOptionPane.showMessageDialog(this,"Deleted Successfully");
					
					AdminOperationFrame aof=new AdminOperationFrame(u);
					this.setVisible(false);
					aof.setVisible(true);
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
				AdminController adc=new AdminController();
				String userId=userTF.getText();
				Admin a=adc.searchAdmin(userId);
				
				if(a!=null)
				{
					userTF.setEnabled(false);
					nameTF.setText(a.getUserName());
					
					ageTF.setText(String.valueOf(a.getAge()));
					emailTF.setText(a.getEmail());
					phoneNoTF.setText(a.getPhoneNo());
					adminTypeCMB.setSelectedItem(a.getAdminType());
					
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Admin not found !!");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"please provide userId !!");
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
		}
		
		if(command.equals(backBtn.getText()))
		{
			AdminHomeFrame ahf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			ahf.setVisible(true);
			
		}
	}
	
}