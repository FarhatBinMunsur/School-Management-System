package views;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import models.*;
import controllers.*;

public class ViewTeacherProfileFrame extends JFrame implements ActionListener {
	 private JLabel userIdLabel, nameLabel, ageLabel, emailLabel, phoneLabel, subjectLabel, salaryLabel;
	 private JButton backbtn;
	 private JPanel panel;
	 private User u;
	 private ImageIcon backImg;
	 
	  public ViewTeacherProfileFrame(User u) {
        super("Your Profile");
        this.setSize(420, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.backImg=new ImageIcon("images/teachers.jpg");
        this.panel = new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(backImg.getImage(),0,0,null);
			}
		};
        this.panel.setLayout(null);
		
		Teacher t=new Teacher();
		TeacherController tc=new TeacherController();
		t=tc.searchTeacher(u.getUserID());
        
		this.userIdLabel = new JLabel("Your User ID: " + t.getUserID());
        this.userIdLabel.setBounds(20, 200, 300, 20);
        this.panel.add(userIdLabel);

        this.nameLabel = new JLabel("Name: " + t.getUserName());
        this.nameLabel.setBounds(20, 240, 300, 20);
        this.panel.add(nameLabel);

        this.ageLabel = new JLabel("Age: " + t.getAge());
        this.ageLabel.setBounds(20, 280, 300, 20);
        this.panel.add(ageLabel);

        this.emailLabel = new JLabel("Email: " + t.getEmail());
        this.emailLabel.setBounds(20, 320, 300, 20);
        this.panel.add(emailLabel);

        this.phoneLabel = new JLabel("Phone No.: " + t.getPhoneNo());
        this.phoneLabel.setBounds(20, 360, 300, 20);
        this.panel.add(phoneLabel);

        this.subjectLabel = new JLabel("Subject Specialization: " + t.getSubjectSpec());
        this.subjectLabel.setBounds(20, 400, 300, 20);
        this.panel.add(subjectLabel);

        this.salaryLabel = new JLabel("Salary: " + t.getSalary());
        this.salaryLabel.setBounds(20, 440, 300, 20);
        this.panel.add(salaryLabel);
		
		this.backbtn=new JButton("Back");
		this.backbtn.setBounds(130,470,100,30);
		this.backbtn.addActionListener(this);
		this.panel.add(backbtn);
		
        this.add(panel);
		this.u=u;
    }
	
	public void actionPerformed(ActionEvent ae){
		String command=ae.getActionCommand();
		
		if(command.equals(backbtn.getText())){
			TeachersHomeFrame thf=new TeachersHomeFrame(this.u);
			this.setVisible(false);
			thf.setVisible(true);
		}
	}
}