package views;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.*;
import controllers.*;

public class PaymentOperationFrame extends JFrame implements ActionListener{
    private JLabel studentIDLabel, paymentIDLabel,tuitionLabel,labFeeLabel,othersFeeLabel;
    private JButton addBtn,updateBtn,deleteBtn,backBtn;
    private JTextField studentIDTF,paymentIDTF,tuitionTF,labFeeTF,othersFeeTF;
    private Color c1;
    private ImageIcon backImg;
    private User u;
    private JPanel panel;

    public PaymentOperationFrame(User u){
        super ("Payment Operation");
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.backImg=new ImageIcon("images/paymentjpg.jpg");
        this.panel =new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(backImg.getImage(),0,0,null);
            }
        };
        this.panel.setLayout(null);

        this.studentIDLabel = new JLabel("Student ID:");
        this.studentIDLabel.setBounds(50, 50, 100, 30);
        this.panel.add(studentIDLabel);

        this.studentIDTF = new JTextField();
        this.studentIDTF.setBounds(170, 50, 150, 30);
        this.panel.add(studentIDTF);

        this.paymentIDLabel = new JLabel("Payment ID:");
        this.paymentIDLabel.setBounds(50, 90, 100, 30);
        this.panel.add(paymentIDLabel);

        this.paymentIDTF = new JTextField();
        this.paymentIDTF.setBounds(170, 90, 150, 30);
        this.panel.add(paymentIDTF);
        
        this.tuitionLabel = new JLabel("Tuition Fee:");
        this.tuitionLabel.setBounds(50, 130, 100, 30);
        this.panel.add(tuitionLabel);

        this.tuitionTF = new JTextField();
        this.tuitionTF.setBounds(170, 130, 150, 30);
        this.panel.add(tuitionTF);

        this.labFeeLabel = new JLabel("Lab Fee:");
        this.labFeeLabel.setBounds(50, 170, 100, 30);
        this.panel.add(labFeeLabel);

        this.labFeeTF = new JTextField();
        this.labFeeTF.setBounds(170, 170, 150, 30);
        this.panel.add(labFeeTF);

        this.othersFeeLabel = new JLabel("Other Fees:");
        this.othersFeeLabel.setBounds(50, 210, 100, 30);
        this.panel.add(othersFeeLabel);

        this.othersFeeTF = new JTextField();
        this.othersFeeTF.setBounds(170, 210, 150, 30);
        this.panel.add(othersFeeTF);

        this.addBtn = new JButton("Add");
        this.addBtn.setBounds(50, 260, 80, 30);
        this.addBtn.setBackground(new Color(21, 40, 66));
        this.addBtn.setForeground(Color.white);
        this.addBtn.addActionListener(this);
        this.panel.add(addBtn);

        this.updateBtn = new JButton("Update");
        this.updateBtn.setBounds(140, 260, 80, 30);
        this.updateBtn.setBackground(new Color(21, 40, 66));
        this.updateBtn.setForeground(Color.white);
        this.updateBtn.addActionListener(this);
        this.panel.add(updateBtn);

        this.deleteBtn = new JButton("Delete");
        this.deleteBtn.setBounds(230, 260, 80, 30);
        this.deleteBtn.setBackground(new Color(21, 40, 66));
        this.deleteBtn.setForeground(Color.white);
        this.deleteBtn.addActionListener(this);
        this.panel.add(deleteBtn);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(140, 300, 80, 30);
        this.backBtn.setBackground(new Color(21, 40, 66));
        this.backBtn.setForeground(Color.white);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);
        
        this.add(panel);
        this.u=u;
    }

    public void actionPerformed(ActionEvent ae){
        String command=ae.getActionCommand();
        
        if (command.equals(addBtn.getText())) {
            if (!studentIDTF.getText().isEmpty() && !paymentIDTF.getText().isEmpty() && !tuitionTF.getText().isEmpty() && !othersFeeTF.getText().isEmpty() && !labFeeTF.getText().isEmpty()) {
                String studentID = studentIDTF.getText();
                String paymentID = paymentIDTF.getText();
                String tuitionFee=tuitionTF.getText();
                String labFee=labFeeTF.getText();
                String othersFee=othersFeeTF.getText();
                
                Payment p=new Payment(paymentID,studentID,tuitionFee,labFee,othersFee);
                PaymentController pmc=new PaymentController();
                pmc.insertPayment(p);
                
                JOptionPane.showMessageDialog(this, "Payment Added for Student ID: " + studentID);

                PaymentOperationFrame pof =new PaymentOperationFrame(this.u);
                this.setVisible(false);
                pof.setVisible(true);
                
            }

            else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!");
            }
        }

        if (command.equals(updateBtn.getText())) {

            if (!studentIDTF.getText().isEmpty() && !paymentIDTF.getText().isEmpty() && !tuitionTF.getText().isEmpty() && !othersFeeTF.getText().isEmpty() && !labFeeTF.getText().isEmpty()) {
                String studentID = studentIDTF.getText();
                String paymentID = paymentIDTF.getText();
                String tuitionFee=tuitionTF.getText();
                String labFee=labFeeTF.getText();
                String othersFee=othersFeeTF.getText();
                PaymentController pmc=new PaymentController();

                Payment p=pmc.searchPayment(studentID);
                if(p!=null){
                    p.setPaymentID(paymentID);
                    p.setTutionFee(tuitionFee);
                    p.setLabFee(labFee);
                    p.setOthersFee(othersFee);
                }
                pmc.updatePayment(p);
                JOptionPane.showMessageDialog(this, "Payment Updated for Student ID: " + studentIDTF.getText());
                PaymentOperationFrame pof =new PaymentOperationFrame(this.u);
                this.setVisible(false);
                pof.setVisible(true);
                
            }
            else {
                JOptionPane.showMessageDialog(this, "Please provide a payment ID!");
            }
        }

        if (command.equals(deleteBtn.getText())) {
            if (!paymentIDTF.getText().isEmpty()) {
                PaymentController pmc=new PaymentController();
                pmc.deletePayment(paymentIDTF.getText());
                JOptionPane.showMessageDialog(this, "Payment Deleted for Student ID: " + studentIDTF.getText());
                PaymentOperationFrame pof =new PaymentOperationFrame(this.u);
                this.setVisible(false);
                pof.setVisible(true);
                
            }
            else {
                JOptionPane.showMessageDialog(this, "Please provide a Student ID to delete!");
            }
        }

        if (command.equals(backBtn.getText())) {
            this.setVisible(false);
            AdminHomeFrame ahf=new AdminHomeFrame(this.u);
            ahf.setVisible(true);
        }
    }


}