import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class Society implements Serializable {
    /*The society class' main function is to allow students to create, join or leave a society. We
     * have left it up to the UniversitySocieties Class to remove societies */

    String name, description, major;
    boolean sanctioned;
    ArrayList<SocietyMember> members;
    SocietyMember president;

    public Society(String name, String description, String major, Student aStudent) {
        this.name = name;
        this.description = description;
        this.major = major;
        president=new SocietyMember(aStudent);
        members = new ArrayList<SocietyMember>();
        president.setPosition("President");
        members.add(president);
    }

    public void joinSociety(Student astudent){
    	if(isMember(astudent))
    		return;
        SocietyMember newMember= new SocietyMember(astudent);
        members.add(newMember);
        if(members.size()>=20) {
            if (!isSanctioned()) {
                this.setSanctioned(true);
            }
        }
    }
    public boolean leaveSociety(String studentNumber) {
    	boolean removed=false;
        for (int i = 0; i > members.size(); i++) {
            SocietyMember amember = members.get(i);
            if (amember.getStudentNumber().equals(studentNumber)){
                members.remove(i);
                removed=true;
                if(members.size()<20) {
                    if (isSanctioned()) {
                        this.setSanctioned(false);
                    }
                }
        }
        }
        return removed;
    }

    
    public boolean isMember(Student aStudent){
    	Iterator<SocietyMember> mem = members.iterator();
    	while(mem.hasNext()){
    		if( mem.next().getStudentNumber().equals(aStudent.getStudentNumber())) return true;	
    	}
    	return false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean isSanctioned() {
        return sanctioned;
    }

    public void setSanctioned(boolean sanctioned) {
        this.sanctioned = sanctioned;
    }

    public ArrayList<SocietyMember> getMembers() {
        return members;
    }


    public SocietyMember getPresident() {
        return president;
    }

    public void setPresident(SocietyMember president) {
        this.president = president;
    }
    public String toString(){
    	return name;
    }
}
