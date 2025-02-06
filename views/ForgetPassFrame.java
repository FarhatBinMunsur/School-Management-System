package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;
import java.awt.*;

public class ForgetPassFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel, securityQuesLabel, securityAnsLabel, passLabel,titleLabel;
	private JTextField userTF, securityAnsTF;
	private JPasswordField passPF;
	private ImageIcon backImg;
	private JButton submitBtn, exitBtn, backBtn;
	private ImageIcon img;
	private JLabel imgLabel;
	private Color c1;
	private User u;
	private JPanel panel;
	private Font font1;
	
	
	public ForgetPassFrame(User u)
	{
		super("Forget/Update Password Frame");
		this.setSize(700,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.backImg=new ImageIcon("images/password.jpg");
		this.font1=new Font("Cambria", Font.BOLD,20);
		
		this.panel=new JPanel(){
			/*protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(backImg.getImage(),0,0,null);
			}*/
		};
		
		this.c1=new Color(235, 242, 208);
		this.panel.setBackground(c1);
		this.panel.setLayout(null);
		
		this.titleLabel=new JLabel("Reset/Update Password");
		this.titleLabel.setBounds(100,30,250,30);
		this.titleLabel.setOpaque(true);
		this.titleLabel.setBackground(c1);
		this.titleLabel.setFont(font1);
		this.panel.add(titleLabel);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(100,80,60,20);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(180,80,100,30);
		this.panel.add(userTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your Favourite Game?:");
		this.securityQuesLabel.setBounds(100,130,300,20);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(100,180,100,20);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(220,180,100,30);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("New Password:");
		this.passLabel.setBounds(100,230,100,20);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(220,230,100,30);
		this.panel.add(passPF);
		
		this.submitBtn=new JButton("Submit");
		this.submitBtn.setBounds(80,320,100,30);
		this.submitBtn.addActionListener(this);
		this.panel.add(submitBtn);
		
		this.exitBtn=new JButton("Exit");
		this.exitBtn.setBounds(200,320,100,30);
		this.exitBtn.addActionListener(this);
		this.panel.add(exitBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(320,320,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		this.img=new ImageIcon("images/sec.png");
		this.imgLabel=new JLabel(img);
		this.imgLabel.setBounds(380,80,315,335);
		this.panel.add(imgLabel);
		
		this.u=u;
		this.add(panel);
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command= ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			if(!userTF.getText().isEmpty() && !securityAnsTF.getText().isEmpty() && !passPF.getText().isEmpty())
			{
				String userTFValue=userTF.getText();
				String passPFValue=passPF.getText();
				String securityAnsTFValue=securityAnsTF.getText();
				UserController uc=new UserController();
				User u=uc.searchUser(userTFValue);
				if(u!=null)
				{
					if(u.getSecurityAns().equals(securityAnsTFValue))
					{
						u.setPassword(passPFValue);
						uc.updateUser(u);
						JOptionPane.showMessageDialog(this,"Password Updated Successfully");
						LoginFrame lf=new LoginFrame();
						this.setVisible(false);
						lf.setVisible(true);
					}
					
					else
					{
						JOptionPane.showMessageDialog(this,"Wrong Security ans");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Wrong userId");
				}
			}
		}
		
		if(command.equals(backBtn.getText()))
		{
		if(u!=null){
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
			
		else if(u.getRole()==3) {
			StudentHomeFrame shf =new StudentHomeFrame(this.u);
			this.setVisible(false);
			shf.setVisible(true);
		}
		}
		
		else{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
		}
		
		
		if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
	}
	
}
