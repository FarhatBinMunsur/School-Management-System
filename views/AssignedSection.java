package views;
import java.lang.*;
import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class AssignedSection extends JFrame implements ActionListener{
    private JLabel sectionaLabel,StudentLabel;
    private JButton backBtn;
    private User u;
    private JPanel panel;


    public AssignedSection(User uu){
        super("Assigned Sections");
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.panel=new JPanel();
        this.panel.setLayout(null);

        this.backBtn=new JButton("BACK");
        this.backBtn.setBounds(450,700,100,30);
        this.panel.add(backBtn);

        this.u=uu;
        // TeacherController tc=new TeacherController();
        // Teacher t= tc.searchTeacher(u.getUserID());

        SectionController sc=new SectionController();
        Section[] sections=sc.getAllSection();
        
        Vector<String> v=new Vector<>();

        for(int i=0;i<sections.length;i++){
            if(sections[i]==null ) break;
            else if(sections[i].getTeacherID().equals(u.getUserID())){
                if(sections!=null) JOptionPane.showMessageDialog(this,"Null");
                v.add(sections[i].getSectionID());
                System.out.println("Sections added to vector: " + v); // Debugging      
        }
        }
        
        System.out.println(v.size()+"::::"+sections.length);
        
        int i=1;
        int x=30,y=50,w=100,h=30;
        for(String secID:v){
            this.sectionaLabel=new JLabel("section " + i +":"+secID);
            this.sectionaLabel.setFont(new Font("Arial", Font.BOLD, 16)); 
            this.sectionaLabel.setForeground(Color.RED);
            this.sectionaLabel.setBounds(x,y,w,h);
            this.panel.add(sectionaLabel);

            i++;

            StudentController stc=new StudentController();
            Student [] studentList=stc.getAllStudent();

            int j=1;
            for(int k=0;k<studentList.length;k++){
                
                
                if(studentList[k]==null) {
                    y+=50;
                    break;
                }
                else if(studentList[k].getsectionID().equals(secID)){
                    y+=50;
                    StudentLabel=new JLabel("Student: "+j+" : [  "+studentList[k].getUserID()+"   "+studentList[k].getUserName()+"  ]");
                    this.StudentLabel.setBounds(x,y,200,h);
                    this.panel.add(StudentLabel);
                    j++;
                }
            }

            

            
        }
        this.add(panel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}