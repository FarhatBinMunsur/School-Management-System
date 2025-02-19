package views;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.*;
import controllers.*;

public class PaymentView extends JFrame implements ActionListener{
    private JPanel panel;
    private JLabel studentIDLabel, paymentDetailsLabel,totalLabel;
    private JTextField studentIDTF;
    private JTextArea paymentDetailsTA;
    private JButton payBtn,backBtn;
    private User u;
    Payment p;

    public PaymentView(User u) {
        
        super("Student Payment View");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        this.u=u;
        

        this.studentIDLabel = new JLabel("Student ID:");
        this.studentIDLabel.setBounds(50, 30, 100, 30);
        this.panel.add(studentIDLabel);

        this.studentIDTF = new JTextField();
        this.studentIDTF.setBounds(170, 30, 150, 30);
        this.studentIDTF.setText(u.getUserID());
        this.studentIDTF.setEditable(false); 
        this.panel.add(studentIDTF);

        this.paymentDetailsLabel = new JLabel("Payment Details:");
        this.paymentDetailsLabel.setBounds(50, 70, 150, 30);
        this.panel.add(paymentDetailsLabel);
        
        PaymentController pc=new PaymentController();
        this.p=pc.searchPayment(this.u.getUserID());
        
        //System.out.println(p.getTutionFee());
        this.paymentDetailsTA = new JTextArea();
        this.paymentDetailsTA.setBounds(50, 100, 200, 200);
        paymentDetailsTA.setText(" Tuition Fee: "+p.getTutionFee()+"\n\n Lab Fee: " +p.getLabFee()+"\n\n Others Fee: "+p.getOthersFee());
        this.paymentDetailsTA.setEditable(false);
        this.panel.add(paymentDetailsTA);        

        int total =Integer.parseInt(p.getTutionFee()) + Integer.parseInt(p.getLabFee()) + Integer.parseInt(p.getOthersFee());

        this.totalLabel=new JLabel("Total: "+String.valueOf(total));
        this.totalLabel.setFont(new Font("Aptos",Font.BOLD,14));
        this.totalLabel.setBounds(300,150,200,30);
        this.panel.add(totalLabel);

        this.payBtn = new JButton("Pay Now");
        this.payBtn.setBounds(270, 200, 120, 30);
        this.payBtn.addActionListener(this);
        this.panel.add(payBtn);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(420, 200, 100, 30);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);
        }

    public void actionPerformed(ActionEvent ae){
        String command=ae.getActionCommand();

        if(payBtn.getText().equals(command)){
            PaymentProcess pp=new PaymentProcess(this.u,p.getPaymentID());
            //pp.rcvPaymentID(p.getPaymentID());
            this.setVisible(false);
            pp.setVisible(true); 
        }

        if(backBtn.getText().equals(command)){
            StudentHomeFrame shf=new StudentHomeFrame(this.u);
            this.setVisible(false);
            shf.setVisible(true);
        }
    }
}
