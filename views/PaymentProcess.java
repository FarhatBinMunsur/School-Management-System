package views;

import java.lang.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import models.*;
import controllers.*;

public class PaymentProcess extends JFrame implements ActionListener {
    private JLabel titleLabel,payMethodLabel,trnxIDLabel,PaymentIDLabel,warningLabel;
    private JTextField paymentIDTF,trnxTF;
    private JButton backButton,submitButton;
    private JComboBox payMethodCMB;
    private JPanel panel;
    User u;
    String paymentID;

    public PaymentProcess(User u,String paymentID){
        
        super("Payment");
        this.setSize(550,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel=new JPanel();
        this.panel.setLayout(null);

        this.titleLabel=new JLabel("PAYMENT");
        this.titleLabel.setFont(new Font("Cambria",Font.BOLD,16));
        this.titleLabel.setBounds(180,30,150,30);
        this.panel.add(titleLabel);

        this.payMethodLabel=new JLabel("Payment Method :");
        this.payMethodLabel.setBounds(50,90,150,30);
        this.panel.add(payMethodLabel);

        String data[]={"Master Card","Visa","Amex","Bkash","Nagad","Rocket","Upay","ইউসুফ সরকার"};

        this.payMethodCMB=new JComboBox(data);
        this.payMethodCMB.setBounds(220,90,80,30);
        this.panel.add(payMethodCMB);

        this.trnxIDLabel=new JLabel("Transaction ID : ");
        this.trnxIDLabel.setBounds(50,200,150,30);
        this.panel.add(trnxIDLabel);

        this.trnxTF=new JTextField();
        this.trnxTF.setBounds(220,200,100,30);
        this.panel.add(trnxTF);

        this.PaymentIDLabel=new JLabel("Payment ID : ");
        this.PaymentIDLabel.setBounds(50,150,150,30);
        this.panel.add(PaymentIDLabel);

        this.paymentID=paymentID;
        this.paymentIDTF=new JTextField();
        this.paymentIDTF.setBounds(220,150,150,30);
        this.paymentIDTF.setText(paymentID);
        this.paymentIDTF.setEditable(false);
        this.panel.add(paymentIDTF);

        this.warningLabel=new JLabel("[[ ** You Must Use the PAYMENT ID as a REFERENCE while paying the fees !! ]]");
        this.warningLabel.setFont(new Font("Cambria",Font.ITALIC,13));
        this.warningLabel.setForeground(Color.RED);
        this.warningLabel.setBounds(25,320,520,30);
        this.panel.add(warningLabel);

        this.submitButton=new JButton("Submit");
        this.submitButton.setBounds(150,250,100,30);
        this.submitButton.addActionListener(this);
        this.panel.add(submitButton);

        this.backButton=new JButton("Back");
        this.backButton.setBounds(280,250,100,30);
        this.backButton.addActionListener(this);
        this.panel.add(backButton);

        this.u=u;
       
        this.add(panel);
        
    }

    // public void rcvPaymentID(String pID){
    //     this.paymentID=pID;
    // }

    public void actionPerformed (ActionEvent ae){
        String command =ae.getActionCommand();

        if(submitButton.getText().equals(command)){
            if(!trnxTF.getText().isEmpty()){
            String[] record={ paymentID," , ",payMethodCMB.getSelectedItem().toString()," , ",trnxTF.getText()," , paid" +"\n"};
            FileIO fio=new FileIO();
            fio.writeFile("controllers/data/payRecord.txt",record,true);   //dummy operation
            JOptionPane.showMessageDialog(this, " Submitted Successfully !");
            StudentHomeFrame shf=new StudentHomeFrame(this.u);
            this.setVisible(false);
            shf.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, " Enter a transactionID !!");
        }
    }

        if(backButton.getText().equals(command)){
            PaymentView pv=new PaymentView(u);
            this.setVisible(false);
            pv.setVisible(true);
        }
    }
}