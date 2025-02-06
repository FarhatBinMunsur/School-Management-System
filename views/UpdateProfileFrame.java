package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import models.*;
import controllers.*;

public class UpdateProfileFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel,adminTypeLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, adminTypeTF;
	private JButton updateBtn, backBtn;
	private JPanel panel;
	private Color c;
	private ImageIcon backImg;
	private User u;
	private Admin admin;
	
	
	
	public UpdateProfileFrame(User u)
	{
		super("Admin update profile Frame");
		this.setSize(500,450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.backImg=new ImageIcon("images/password.jpg");
        this.panel = new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(backImg.getImage(),0,0,null);
			}
		};
		this.panel.setLayout(null);
		
		//getting admin's info in Admin type object ref.
		AdminController adc=new AdminController();
		this.admin=adc.searchAdmin(u.getUserID());
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(120,50,100,30);
		this.userTF.setText(u.getUserID());
		this.userTF.setEditable(false);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.nameTF.setText(admin.getUserName());
		this.nameTF.setEditable(false);
		this.panel.add(nameTF);
		
		this.emailLabel=new JLabel("email:");
		this.emailLabel.setBounds(50,150,60,30);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(120,150,150,30);
		this.emailTF.setText(admin.getEmail());
		this.panel.add(emailTF);
		
		this.phoneNoLabel=new JLabel("phone No:");
		this.phoneNoLabel.setBounds(50,200,60,30);
		this.panel.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(120,200,100,30);
		this.phoneNoTF.setText(admin.getPhoneNo());
		this.panel.add(phoneNoTF);
		
		
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(50,250,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(120,250,100,30);
		this.ageTF.setText(String.valueOf(admin.getAge()));
		this.ageTF.setEditable(false);
		this.panel.add(ageTF);
		
		this.adminTypeLabel=new JLabel("Admin Type:");
		this.adminTypeLabel.setBounds(50,300,100,30);
		this.panel.add(adminTypeLabel);
		
		this.adminTypeTF=new JTextField();
		this.adminTypeTF.setBounds(160,300,100,30);
		this.adminTypeTF.setText(admin.getAdminType());
		this.adminTypeTF.setEditable(false);
		this.panel.add(adminTypeTF);
		
		this.c=new Color(245, 229, 108);
		this.updateBtn=new JButton("update");
		this.updateBtn.setBounds(50,350,120,30);
		this.updateBtn.setBackground(c);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(190,350,100,30);
		this.backBtn.setBackground(c);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		
		if(command.equals(updateBtn.getText()))
		{
			
			if((!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()))
			{
				admin.setEmail(emailTF.getText());
				admin.setPhoneNo(phoneNoTF.getText());
				
				AdminController addc=new AdminController();
				addc.updateAdmin(admin);
				
				JOptionPane.showMessageDialog(this,"admin updated Successfully");
		
			}
			else
			{
			
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			
			AdminHomeFrame adf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		}
	}
	
}