package views;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import models.*;
import controllers.*;


public class LoginFrame extends JFrame implements ActionListener
{
	private JLabel userIDLabel, passLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton loginBtn, exitBtn, signUpBtn, forgetPassBtn;
	private ImageIcon img;
	private JLabel imgLabel;
	private ImageIcon backImg;
	private JPanel panel;
	private Color c1,c2;
	private User u;
	
	public LoginFrame()
	{
		super("Login Frame");
		this.setSize(720,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.backImg=new ImageIcon("images/school-4.jpg");
		
		this.panel=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(backImg.getImage(),0,0,null);
			}
		};
		
		this.c1=new Color(236, 230, 245);
		
		this.panel.setLayout(null);
		
		this.userIDLabel=new JLabel("User ID :");
		this.userIDLabel.setBounds(280,30,50,20);
		this.panel.add(userIDLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(350,30,130,30);
		this.panel.add(userTF);
		
		this.passLabel=new JLabel("Password :");
		this.passLabel.setBounds(280,70,80,20);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(350,70,130,30);
		this.panel.add(passPF);
		
		this.loginBtn=new JButton("Login");
		this.loginBtn.setBounds(295,130,100,30);
		this.loginBtn.addActionListener(this);
		this.loginBtn.setBackground(c1);
		this.panel.add(loginBtn);
		
		this.signUpBtn=new JButton("Sign Up");
		this.signUpBtn.setBounds(430,130,100,30);
		this.signUpBtn.addActionListener(this);
		this.signUpBtn.setBackground(c1);
		this.panel.add(signUpBtn);
		
		this.forgetPassBtn=new JButton("Forget Password");
		this.forgetPassBtn.setBounds(280,170,130,30);
		this.forgetPassBtn.addActionListener(this);
		this.forgetPassBtn.setBackground(c1);
		this.panel.add(forgetPassBtn);
		
		this.exitBtn=new JButton("Exit");
		this.exitBtn.setBounds(430,170,100,30);
		this.exitBtn.addActionListener(this);
		this.exitBtn.setBackground(c1);
		this.panel.add(exitBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{	
		try{
		String command= ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			if(!userTF.getText().isEmpty() && !passPF.getText().isEmpty())
			{
				String userTFValue=userTF.getText();
				String passPFValue=passPF.getText();
				
				UserController uc=new UserController();
				User u=uc.searchUser(userTFValue);
				
				if(u!=null)
				{
					if(u.getPassword().equals(passPFValue))
					{
						if(u.getRole()==1)
						{
							AdminHomeFrame adhf=new AdminHomeFrame(u);
							this.setVisible(false);
							adhf.setVisible(true);
						}
						
						else if(u.getRole()==2)
						{
							TeachersHomeFrame thf=new TeachersHomeFrame(u);
							this.setVisible(false);
							thf.setVisible(true);
						}
						
						else
						{
							StudentHomeFrame shf=new StudentHomeFrame(u);
							this.setVisible(false);
							shf.setVisible(true);
						}
					}
					
					else
					{
						JOptionPane.showMessageDialog(this,"Wrong password");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Wrong User Id");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Fill up All the Field");
			}
			
		}
		
		if(command.equals(signUpBtn.getText()))
		{
			SignupFrame suf=new SignupFrame();
			this.setVisible(false);
			suf.setVisible(true);
		}
		
		if(command.equals(forgetPassBtn.getText()))
		{
			ForgetPassFrame fpf=new ForgetPassFrame(null);
			this.setVisible(false);
			fpf.setVisible(true);
		}
		
		if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
