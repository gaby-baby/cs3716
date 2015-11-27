import java.io.Serializable;

public class SocietyMember extends Student implements Serializable{
    /*Having SocietyMember extend student it will be easy for to make special rules for society members, perhaps
    * interest rates on their accounts, attendance record of meetings, ect*/
    double account;
    String position;
    
    public SocietyMember(Student aStudent){
        super(aStudent.getName(),aStudent.getStudentNumber(),aStudent.getEmail());
        account=0;
        position="Member";
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		
		this.position = position;
	}
	



}
