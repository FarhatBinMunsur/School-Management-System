package models;
import java.lang.*;
import javax.swing.*;
import java.awt.*;

public class Payment {
    private String paymentID;
    private String studentID;
    private String tutionFee;
    private String labFee;
    private String othersFee;

    public Payment(){}

    public Payment (String paymentID,String studentID,String tutionFee,String labFee,String othersFee){
        this.paymentID=paymentID;
        this.studentID=studentID;
        this.tutionFee=tutionFee;
        this.labFee=labFee;
        this.othersFee=othersFee;
    }

    
    public String getPaymentID() {
        return this.paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getTutionFee() {
        return this.tutionFee;
    }

    public void setTutionFee(String tutionFee) {
        this.tutionFee = tutionFee;
    }

    public String getLabFee() {
        return this.labFee;
    }

    public void setLabFee(String labFee) {
        this.labFee = labFee;
    }

    public String getOthersFee() {
        return this.othersFee;
    }

    public void setOthersFee(String othersFee) {
        this.othersFee = othersFee;
    }

    public String toStringPayment(){
        String str=this.paymentID+","+this.studentID+","+this.tutionFee+","+this.labFee+","+this.othersFee+"\n";
        return str;
    }

    public Payment formPayment(String s){
        String data[]=s.split(",");
        Payment p=new Payment();

        p.setPaymentID(data[0]);
        p.setStudentID(data[1]);
        p.setTutionFee(data[2]);
        p.setLabFee(data[3]);
        p.setOthersFee(data[4]);
        
        return p;

    }
}