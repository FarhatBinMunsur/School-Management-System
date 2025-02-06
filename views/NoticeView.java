package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import models.*;
import controllers.*;

public class NoticeView extends JFrame implements ActionListener{
	public JLabel newLabel,prevLabel;
	private JTextArea newTF,prevTA;
	private JButton backBtn;
	private JScrollPane prevSP;
    private JPanel panel;
	private User u;
	private Color c1,c2;
	
    public NoticeView(User u){
        super("Notice");
        this.setSize(800,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.c1=new Color(250, 200, 197);
		this.c2=new Color(250, 236, 195);
		
        this.panel=new JPanel();
		this.panel.setBackground(c1);
        this.panel.setLayout(null);
		
		this.newLabel=new JLabel("New Notice");
		this.newLabel.setBounds(320,50,100,30);
		this.panel.add(newLabel);
		
		
		this.newTF=new JTextArea();
		this.newTF.setEditable(false);
		this.newTF.setBackground(c2);
		this.newTF.setBounds(50,100,700,50);
		this.panel.add(newTF);
		
		this.prevLabel=new JLabel("Previous Notice");
		this.prevLabel.setBounds(300,200,100,30);
		this.panel.add(prevLabel);
		
		this.prevTA=new JTextArea();
		this.prevTA.setEditable(false);
		this.prevTA.setLineWrap(false);
		this.prevTA.setBackground(c2);
		this.prevSP=new JScrollPane(prevTA);
		this.prevSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		this.prevSP.setBounds(50,250,700,300);
		this.panel.add(prevSP);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(320,600,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		NoticeController nc=new NoticeController();
		Notice notices[]=nc.getAllNotice();
		Notice n= new Notice();

		
		for(int i=notices.length-1;i>=0;i--){
			if(notices[i]!=null){
				//System.out.println(notices[i].getNotice());
				this.prevTA.append(notices[i].getNoticeID()+" → "+notices[i].getNotice()+"\n\n");
		}
		}
		for(int j=notices.length-1;j>=0;j--){
			if(notices[j]!=null){
				//view the latest notice
				this.newTF.setText(notices[j].getNoticeID()+" ->  "+notices[j].getNotice());
				break;
		}
		}
		this.u=u;
        this.add(panel);
    }
	
	public void actionPerformed(ActionEvent ae){
		String command=ae.getActionCommand();
		
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
		}
	}
}