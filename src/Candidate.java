import java.io.Serializable;

public class Candidate implements Serializable{
	SocietyMember aMember; //Was going to use Student but I feel SocietyMember makes more sence
	int votes; //keep track of how many votes they've received
	//We can add in a description field to allow the candidate to tell people why to vote for them
	public Candidate(SocietyMember aMember) {
		this.aMember = aMember;
		this.votes=0;
	}
	public String getName(){
		return aMember.getName();
	}
	public SocietyMember getMember() {
		return aMember;
	}
	public void setMember(SocietyMember aMember) {
		this.aMember = aMember;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public void vote(){
		this.votes++;
	}
	
	
	

}
