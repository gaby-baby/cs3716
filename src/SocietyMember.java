import java.io.Serializable;

public class SocietyMember extends Student implements Serializable{
    /*Having SocietyMember extend student it will be easy for to make special rules for society members, perhaps
    * interest rates on their accounts, attendance record of meetings, ect*/
    double account;

    public SocietyMember(Student aStudent){
        super(aStudent.getName(),aStudent.getStudentNumber(),aStudent.getEmail());
        account=0;
    }
    public void chargeAccount(double value){
        account=account-value;
    }
    public void addPayment(double value){
        account=account+value;
    }
    public double getBalance(){
        return account;
    }
	



}
