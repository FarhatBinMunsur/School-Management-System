package views;

import java.lang.*;
import models.*;
import controllers.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NoticeOperationFrame extends JFrame implements ActionListener{
	private JLabel  titleLabel,noticeIDLabel,noticeLabel;
	private JTextField noticeIDTF,noticeTF;
	private JButton addBtn,updateBtn,deleteBtn,backBtn;
	private JPanel panel;
	private User u;
	public NoticeOperationFrame(User u){
		super("Notice Operation");
		this.setSize(800,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		/*
		this.font1=new Font("Comic Sans MS", Font.BOLD,20);
		this.titleLabel=new JLabel("Notice");
		this.titleLabel.setBounds(150,100,140,30);
		this.titleLabel.setOpaque(true);
		this.titleLabel.setFont(font1);
		this.panel.add(titleLabel);
		*/
		this.noticeIDLabel=new JLabel("NoticeID: ");
		this.noticeIDLabel.setBounds(50,50,100,30);
		this.panel.add(noticeIDLabel);
		
		this.noticeIDTF=new JTextField();
		this.noticeIDTF.setBounds(170,50,100,30);
		this.panel.add(noticeIDTF);
		
		this.noticeLabel=new JLabel("Notice: ");
		this.noticeLabel.setBounds(50,120,80,30);
		this.panel.add(noticeLabel);
		
		this.noticeTF=new JTextField();
		this.noticeTF.setBounds(170,120,500,50);
		this.panel.add(noticeTF);
		
		
		this.addBtn=new JButton("add");
		this.addBtn.setBounds(50,200,100,30);
		this.addBtn.addActionListener(this);
		//this.addBtn.setBackground(c1);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("Update");
		this.updateBtn.setBounds(180,200,100,30);
		this.updateBtn.addActionListener(this);
		//this.removeBtn.setBackground(c1);
		this.panel.add(updateBtn);
		
		/*this.searchBtn=new JButton("Search");
		this.searchBtn.setBounds(530,350,100,30);
		this.searchBtn.addActionListener(this);
		this.searchBtn.setBackground(c1);
		this.panel.add(searchBtn);
		*/
		
		this.deleteBtn=new JButton("delete");
		this.deleteBtn.setBounds(310,200,100,30);
		this.deleteBtn.addActionListener(this);
		//this.deleteBtn.setBackground(c1);
		this.panel.add(deleteBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(440,200,100,30);
		this.backBtn.addActionListener(this);
		//this.backBtn.setBackground(c);
		this.panel.add(backBtn);
		this.u=u;
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae){
		String command=ae.getActionCommand();

		if(command.equals(addBtn.getText())){
			if(!noticeTF.getText().isEmpty()){
				String noticeID=noticeIDTF.getText();
				String notice=noticeTF.getText();

				NoticeController nc=new NoticeController();
				Notice n=new Notice(noticeID,notice);
				nc.insertNotice(n);
				JOptionPane.showMessageDialog(this,"Notice Posted!");

				this.setVisible(false);
				NoticeView nv=new NoticeView(this.u);
				nv.setVisible(true);


			}
			else{
				JOptionPane.showMessageDialog(this,"Enter a valid Notice");
			}
			
		}
		
		if(command.equals(updateBtn.getText())){
			if(!noticeIDTF.getText().isEmpty() && !noticeTF.getText().isEmpty()){
				String noticeID=noticeIDTF.getText();
				
				
				NoticeController nc=new NoticeController();
				Notice n=nc.searchNotice(noticeID);
				if(n!=null){
				String notice=noticeTF.getText();
				n.setNotice(notice);
				
				nc.updateNotice(n);
				JOptionPane.showMessageDialog(this,"Notice Updated!");

				this.setVisible(false);
				NoticeView nv=new NoticeView(this.u);
				nv.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(this,"Notice is not available!");
			}
			}
			else {
				JOptionPane.showMessageDialog(this,"please fillup all the field !");

			}
		}
		
		if(command.equals(deleteBtn.getText())){
			if(!noticeIDTF.getText().isEmpty()){
				String noticeID=noticeIDTF.getText();

				NoticeController nc=new NoticeController();
				nc.deleteNotice(noticeID);
				JOptionPane.showMessageDialog(this,"Notice Deleted!");

				this.setVisible(false);
				NoticeView nv=new NoticeView(this.u);
				nv.setVisible(true);
			}
			
		}
		
		if(command.equals(backBtn.getText())){
			AdminHomeFrame ahf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			ahf.setVisible(true);
		}
	}
}