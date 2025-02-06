package views;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import models.*;
import controllers.*;

public class SectionOperationFrame extends JFrame implements ActionListener{
	private JLabel sectionIDLabel,stdCountLabel,teacherIDLabel,subjectIDLabel;
	private JTextField secTF,stdCntTF,tcrTF,sbjctTF;
	private JButton addBtn,updateBtn,deleteBtn,searchBtn,backBtn;
	private JTable sectionTable;
	private JScrollPane sectionTableSP;
	private Color c;
	private User u;
	private JPanel panel;
	
	public SectionOperationFrame(User u){
		super ("Section Operation Frame");
		this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.u = u;
		
		this.panel = new JPanel();
        this.panel.setLayout(null);

		this.sectionIDLabel=new JLabel("Section ID: ");
		this.sectionIDLabel.setBounds(50,50,100,30);
		this.panel.add(sectionIDLabel);
		
		this.secTF = new JTextField();
        this.secTF.setBounds(160, 50, 150, 30);
        this.panel.add(secTF);
		
		this.stdCountLabel=new JLabel("Student Count: ");
		this.stdCountLabel.setBounds(50, 100, 100, 30);
        this.panel.add(stdCountLabel); 

        this.stdCntTF = new JTextField();
        this.stdCntTF.setBounds(160, 100, 150, 30);
        this.panel.add(stdCntTF);

        this.teacherIDLabel = new JLabel("Subject ID:");
        this.teacherIDLabel.setBounds(50, 150, 100, 30);
        this.panel.add(teacherIDLabel);

        this.tcrTF= new JTextField();
        this.tcrTF.setBounds(160, 150, 150, 30);
        this.panel.add(tcrTF);

        this.subjectIDLabel = new JLabel("Teacher ID:");
        this.subjectIDLabel.setBounds(50, 200, 100, 30);
        this.panel.add(subjectIDLabel);

        this.sbjctTF= new JTextField();
        this.sbjctTF.setBounds(160, 200, 150, 30);
        this.panel.add(sbjctTF);
		
		this.c=new Color(245, 229, 108);
		
		this.addBtn = new JButton("✅Add");
        this.addBtn.setBounds(50, 300, 100, 30);
        this.addBtn.addActionListener(this);
		this.addBtn.setBackground(c);
        this.panel.add(addBtn);
		
		this.updateBtn=new JButton("Update");
		this.updateBtn.setBounds(180, 300, 100, 30);
		this.updateBtn.addActionListener(this);
		this.updateBtn.setBackground(c);
		this.panel.add(updateBtn);
		
        this.deleteBtn = new JButton("Delete");
        this.deleteBtn.setBounds(310, 300, 100, 30);  
        this.deleteBtn.addActionListener(this);
		this.deleteBtn.setBackground(c);
        this.panel.add(deleteBtn);
		
		this.searchBtn = new JButton("Search");
        this.searchBtn.setBounds(440, 300, 100, 30);  
        this.searchBtn.addActionListener(this);
		this.searchBtn.setBackground(c);
        this.panel.add(searchBtn);
		
		this.backBtn = new JButton("Back");
        this.backBtn.setBounds(570, 300, 100, 30);  
        this.backBtn.addActionListener(this);
		this.backBtn.setBackground(c);
        this.panel.add(backBtn);
		
		SectionController sc=new SectionController();
		Section sectionList[] =sc.getAllSection();
		
		String sectionData[][]=new String[sectionList.length][4];
		
		for(int i=0;i<sectionList.length;i++){
			
			try{
			sectionData[i][0]=sectionList[i].getSectionID();
			sectionData[i][1]=String.valueOf(sectionList[i].getStudentCount());
			sectionData[i][2]=sectionList[i].getTeacherID();
			sectionData[i][3]=sectionList[i].getSubjectID();
			}
			catch(Exception e){
					e.printStackTrace();
				}
		}
		
		String head[]={"Section","Student Count","Subject Code","Teacher ID"};
		
		this.sectionTable=new JTable(sectionData,head);
		
		this.sectionTableSP=new JScrollPane(sectionTable);
		this.sectionTableSP.setBounds(50,400,700,200);
		this.sectionTable.setEnabled(false);
		this.panel.add(sectionTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae){
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText())){
			if(!secTF.getText().isEmpty() && !stdCntTF.getText().isEmpty() && !sbjctTF.getText().isEmpty() && !tcrTF.getText().isEmpty()){
				String sectionID=secTF.getText();
				int studentCount=Integer.parseInt(stdCntTF.getText());
				String teacherID=tcrTF.getText();
				String subjectID=sbjctTF.getText();
				
				SectionController sc=new SectionController();
				Section s=new Section(sectionID,studentCount,teacherID,subjectID);
				sc.insertSection(s);
				JOptionPane.showMessageDialog(this,"Inserted !");
				
				this.setVisible(false);
				SectionOperationFrame sof=new SectionOperationFrame(u);
				sof.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up field properly");
			}
		}
		
		if(command.equals(updateBtn.getText())){
			if(!secTF.getText().isEmpty() && !stdCntTF.getText().isEmpty() && !sbjctTF.getText().isEmpty() && !tcrTF.getText().isEmpty()){
			SectionController sc=new SectionController();
			Section s= sc.searchSection(secTF.getText());
			
			if(s!=null){
			String sectionID=secTF.getText();
			int studentCount=Integer.parseInt(stdCntTF.getText());
			String teacherID=tcrTF.getText();
			String subjectID=sbjctTF.getText();
			
			
			
			s.setSectionID(sectionID);
			s.setStudentCount(studentCount);
			s.setTeacherID(teacherID);
			s.setSubjectID(subjectID);
			
			sc.updateSection(s);
			
			JOptionPane.showMessageDialog(this,"Operation Successful");
			this.setVisible(false);
			SectionOperationFrame sof=new SectionOperationFrame(this.u);
			sof.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(this,"Section not found");
			}
			
		}
		else {
			JOptionPane.showMessageDialog(this,"Please fill up field properly");
		}
	}
	
	if(command.equals(deleteBtn.getText())){
		if(!secTF.getText().isEmpty()){
			SectionController sc=new SectionController();
			Section s= sc.searchSection(secTF.getText());
			
			//confirms that section exists
			if(s!=null){
				sc.deleteSection(secTF.getText());
				JOptionPane.showMessageDialog(this,"Deleted Successfully");
				
				this.setVisible(false);
				SectionOperationFrame sof=new SectionOperationFrame(this.u);
				sof.setVisible(true);
			}
			else
				{
				JOptionPane.showMessageDialog(this,"Not Found! Provide a valid ID.");
				}
	}
	else{
		JOptionPane.showMessageDialog(this,"Please Provide a Section ID!");
		}
	
	}
	
	if(command.equals(searchBtn.getText())){
		if(!secTF.getText().isEmpty()){
			SectionController sc=new SectionController();
			Section s= sc.searchSection(secTF.getText());
			
			if(s!=null){
				secTF.setText(s.getSectionID());
				stdCntTF.setText(String.valueOf(s.getStudentCount()));
				tcrTF.setText(s.getTeacherID());
				sbjctTF.setText(s.getSubjectID());
			}
			else {
				JOptionPane.showMessageDialog(this,"Section not found");
			}
			
		}
		else{
				JOptionPane.showMessageDialog(this,"please provide Section Id");
		}
		
	}
	
	if(command.equals(backBtn.getText())){
		AdminHomeFrame ahf=new AdminHomeFrame(this.u);
		this.setVisible(false);
		ahf.setVisible(true);
	}
}
}