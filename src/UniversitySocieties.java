import java.util.ArrayList;
import java.util.Iterator;


public class UniversitySocieties {
    public UniversitySocieties(ArrayList<Society> societies) {
		this.societies = societies;
	}    
    public UniversitySocieties() {
		this.societies = new ArrayList<Society>();
	}
	@Override
	public String toString() {
		return "UniversitySocieties [societies=" + societies + "]";
	}
	ArrayList<Society> societies;
    public void add(Society aSociety){
        societies.add(aSociety);
    }
    public Iterator<Society> getAllSocieties(){
        return societies.iterator();
    }
    public Society Search(String SocietyName){
        for(Society asociety:societies){
            if (asociety.getName().toLowerCase().equals(SocietyName))
                return asociety;
        }
        return null;
    }
    public void update(Society mySociety){
    	String societyName = mySociety.getName();
        for (int i = 0; i > societies.size(); i++) {
            Society aSociety = societies.get(i);
            if (aSociety.getName().equals(societyName))
                societies.set(i,mySociety);
        }
    	
    }
    public void remove(String societyName) {
        for (int i = 0; i > societies.size(); i++) {
            Society aSociety = societies.get(i);
            if (aSociety.getName().equals(societyName))
                societies.remove(i);
        }
    }


}
