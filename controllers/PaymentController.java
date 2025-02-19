package controllers;
import java.lang.*;
import models.*;

public class PaymentController{
    public Payment[] getAllPayment(){
        FileIO fio=new FileIO();
        String data[]=fio.readFile("controllers/data/payments.txt");
        Payment[] payments=new Payment[100];
        for (int i=0;i<data.length;i++){
            if(data[i]!=null && payments[i]==null){
                Payment p=new Payment();
                payments[i]=p.formPayment(data[i]);
                
            }
			
        }
		return payments;
    }
    public void write(Payment[] p){
        String data[]=new String [100];

        for(int i=0;i<data.length;i++){
            if(p[i]!=null){
                data[i]=p[i].toStringPayment();
            }
        }

        FileIO fio=new FileIO();
        fio.writeFile("controllers/data/payments.txt",data,false);
    }

    public void insertPayment(Payment p){
		Payment [] payments=this.getAllPayment();
		
		for(int i=0;i<payments.length;i++){
			if(payments[i]==null){
				payments[i]=p;
				break;
			}
		}
		this.write(payments);
	}

    public void deletePayment(String paymentID){
		
		Payment payments[]=this.getAllPayment();
		for(int i=0;i<payments.length;i++){
			if(payments[i]!=null){
				if(payments[i].getPaymentID().equals(paymentID)){
					payments[i]=null;
				}
			}
		}
		this.write(payments);
	}
    public void updatePayment(Payment p){
		
		Payment payments[]=this.getAllPayment();
		for(int i=0;i<payments.length;i++){
			if(payments[i]!=null){
				if(payments[i].getPaymentID().equals(p.getPaymentID())){
					payments[i]=p;
				}
			}
		}
		this.write(payments);
	}
	
    public Payment searchPayment(String studentID){
		
		Payment payments[]=this.getAllPayment();
		for(int i=0;i<payments.length;i++){
			if(payments[i]!=null){
				if(payments[i].getStudentID().equals(studentID)){
					return payments[i];
				}
			}
		}
		return null;
	}
}