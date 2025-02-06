package views;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import models.*;
import controllers.*;

public class GradeOperationFrame extends JFrame implements ActionListener{
	private JLabel gradeIDLabel,studentIdLabel,subjectIDLabel,teacherIDLabel;
	private JTextField gradeTF,studentIdTF,subjectTF,teacherTF;
	private JButton addBtn,backBtn,deleteBtn;
	private JTable gradeTable;
	private JScrollPane gradeTableSP;
	private ImageIcon backImage;
	private Color c,c1;
	private JPanel panel;
	private User u;
	
	public GradeOperationFrame(User u){
		super("Grade Operation Frame");
        this.setSize(740,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.u = u;
		
		this.backImage=new ImageIcon("images/grade.jpg");
        this.panel = new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(backImage.getImage(),0,0,null);
				
			}
		};
		
        this.panel.setLayout(null);

        this.gradeIDLabel = new JLabel("Grade :");
        this.gradeIDLabel.setBounds(50, 50, 100, 30);
        this.panel.add(gradeIDLabel);

        this.gradeTF = new JTextField();
        this.gradeTF.setBounds(160, 50, 150, 30);
        this.panel.add(gradeTF);

        this.studentIdLabel = new JLabel("Student ID:");
        this.studentIdLabel.setBounds(50, 100, 100, 30);
        this.panel.add(studentIdLabel); 

        this.studentIdTF = new JTextField();
        this.studentIdTF.setBounds(160, 100, 150, 30);
        this.panel.add(studentIdTF);

        this.subjectIDLabel = new JLabel("Subject ID:");
        this.subjectIDLabel.setBounds(50, 150, 100, 30);
        this.panel.add(subjectIDLabel);
		
        this.subjectTF = new JTextField();
        this.subjectTF.setBounds(160, 150, 150, 30);
        this.panel.add(subjectTF);

        this.teacherIDLabel = new JLabel("Teacher ID:");
        this.teacherIDLabel.setBounds(50, 200, 100, 30);
        this.panel.add(teacherIDLabel);

        this.teacherTF = new JTextField();
        this.teacherTF.setBounds(160, 200, 150, 30);
        this.teacherTF.setText(u.getUserID());
        this.panel.add(teacherTF);


		this.c=new Color(245, 229, 108);
		this.c1=new Color(230, 212, 188);
		
        this.addBtn = new JButton("✅Add");
        this.addBtn.setBounds(50, 300, 100, 30);
        this.addBtn.addActionListener(this);
		this.addBtn.setBackground(c1);
        this.panel.add(addBtn);
		
		this.deleteBtn=new JButton("Delete");
		this.deleteBtn.setBounds(180, 300, 100, 30);  
        this.deleteBtn.addActionListener(this);
		this.deleteBtn.setBackground(c1);
        this.panel.add(deleteBtn);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(310, 300, 100, 30);  
        this.backBtn.addActionListener(this);
		this.backBtn.setBackground(c);
        this.panel.add(backBtn);
		
		
		
		GradeController gc=new GradeController();
		Grade gradeList[] =gc.getAllGrade();
		
		String gradedata[][]=new String[gradeList.length][5];
		for(int i=0;i<gradeList.length;i++){
			User u2 =new User();
			UserController uc=new UserController();
			
			Subject s=new Subject();
			SubjectController sc=new SubjectController();
			
			Student s2=new Student();
			StudentController stc=new StudentController();
			
			if(gradeList[i]!=null){
				
				u2=uc.searchUser(gradeList[i].getStudentID());
				s=sc.searchSubject(gradeList[i].getSubjectID());
				s2=stc.searchStudent(u2.getUserID());
				System.out.println(gradeList[i].toStringGrade());
				
				try{
				gradedata[i][0]=gradeList[i].getStudentID();
				gradedata[i][1]=s2.getUserName();
				gradedata[i][2]=gradeList[i].getSubjectID();
				gradedata[i][3]=s.getSubjectName();
				gradedata[i][4]=gradeList[i].getGradeID();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
		String head[]={"Student ID","Student Name","Subject Code","Subject Name","Grade"};
		
		this.gradeTable=new JTable(gradedata,head);
		
		this.gradeTableSP=new JScrollPane(gradeTable);
		this.gradeTableSP.setBounds(30,400,680,200);
		this.gradeTable.setEnabled(false);
		this.panel.add(gradeTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae){
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText())){
			
			if(!gradeTF.getText().isEmpty() && !studentIdTF.getText().isEmpty() && !subjectTF.getText().isEmpty() && !teacherTF.getText().isEmpty()){
				String studentID=studentIdTF.getText();
				String subjectID=subjectTF.getText();
				String gradeID=gradeTF.getText();
				String teacherID=teacherTF.getText();
				
				GradeController gc=new GradeController();
				Grade g=new Grade(gradeID,studentID,subjectID,teacherID);
				gc.insertGrade(g);
				JOptionPane.showMessageDialog(this,"Inserted !");
				
				this.setVisible(false);
				GradeOperationFrame gof=new GradeOperationFrame(u);
				gof.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up field properly");
			}
		}
		
		if(command.equals(deleteBtn.getText())){
			if(!gradeTF.getText().isEmpty() && !studentIdTF.getText().isEmpty() && !subjectTF.getText().isEmpty()){
				GradeController gc= new GradeController();
				Grade g=gc.searchGrade(gradeTF.getText());
				
				if(g!=null){

					gc.deleteGrade(gradeTF.getText(),studentIdTF.getText(),subjectTF.getText());
					
			JOptionPane.showMessageDialog(this,"Operation Successful");
			this.setVisible(false);
			
			GradeOperationFrame gof=new GradeOperationFrame(this.u);
			this.setVisible(false);
			gof.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(this,"Grade is not Available");
				}
				
			}
		else {
			JOptionPane.showMessageDialog(this,"Please fill up field properly");
		}

		}
		
		if(command.equals(backBtn.getText())){
			this.setVisible(false);
			TeachersHomeFrame thf=new TeachersHomeFrame(u);
			thf.setVisible(true);
		}
	}
	
	
}