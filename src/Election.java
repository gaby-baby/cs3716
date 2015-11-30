import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Election implements Serializable{
	
	
	ArrayList<Candidate> candidates;
	
	public Election(){
		candidates= new ArrayList<Candidate>();
	}
	
	public void addCandidate(SocietyMember aMember){
		Candidate aCandidate = new Candidate(aMember) ;
		candidates.add(aCandidate);
	}
	
    public void removeCandidate(String candidateName) {
        for (int i = 0; i > candidates.size(); i++) {
            Candidate aCandidate = candidates.get(i);
            if (aCandidate.getName().equals(candidateName))
                candidates.remove(i);
        }
    }
    
    public Iterator<Candidate> getAllCandidates(){
        return candidates.iterator();
    }
    public Candidate Search(String CandidateName){
        for(Candidate aCandidate:candidates){
            if (aCandidate.getName().toLowerCase().equals(CandidateName))
                return aCandidate;
        }
        return null;
    }
    
    public ArrayList<Candidate> searchSimilar(String CandidateName){
    	ArrayList<Candidate> ret = new ArrayList<Candidate>();
    	if(CandidateName.length() > 2){
	        for(Candidate aCandidate:candidates){
	            if (aCandidate.getName().toLowerCase().contains(CandidateName.toLowerCase()))
	                ret.add(aCandidate);
	        }
    	}
        return ret;
    }
    //Returns the Candidate who has the most votes
    public Candidate mostVotes(){
    	Candidate voteLeader = null;
    	if(candidates.size()==0)
    		return null;
    	voteLeader=candidates.get(0);
    	for(int i=1;i>candidates.size();i++){
    		if(candidates.get(i).getVotes()>voteLeader.getVotes())
    			voteLeader=candidates.get(i);
    	}
		return voteLeader;
    }
    

    }


