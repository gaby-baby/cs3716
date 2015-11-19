import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class tester {
	public static void main(String[] args){
		Student aStudent = new Student("Mike Peacock", "200945921", "mnp457@mun.ca");
		UniversitySocieties mySystem = new UniversitySocieties(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int selectionNumber = 1;
		while(selectionNumber!=0){
			
				System.out.println("To create a new societies please enter the value '1'");
				System.out.println("To see a list of societies please enter the value '2'");
				System.out.println("To join a society please enter the value '3'");
				System.out.println("To leave a society please enter the value '4'");
				System.out.println("To exit please enter the value '5'");
				try{
				selectionNumber = Integer.parseInt(br.readLine());
				switch(selectionNumber){

					case 1:
						System.out.println("Please enter the society name");
						String name=br.readLine();
						System.out.println("Please enter a description of the society");
						String description=br.readLine();
						System.out.println("Please enter the major this society is for");
						String major = br.readLine();
						Society mySociety = new Society(name,description,major,aStudent);
						mySystem.add(mySociety);
						System.out.println(mySociety.getName() + " has been created.");
						break;
					case 2:
						Iterator<Society> mySocietys= mySystem.getAllSocieties();
						System.out.println("List of all Societys: ");
						while(mySocietys.hasNext()){
							System.out.println(mySocietys.next().getName());
						}
						break;
					case 3:
						System.out.println("Please enter the society name");
						String aName = br.readLine();
						Society searchedSociety = mySystem.Search(aName);
						if (searchedSociety==null){
							System.out.println("Society not found.");
							break;
						}
						else{
							searchedSociety.joinSociety(aStudent);
							mySystem.update(searchedSociety);
							System.out.println("Members of "+ searchedSociety.getName() + " are : ");
							ArrayList<SocietyMember> myMembers= searchedSociety.getMembers();
							for(int i=0;i<myMembers.size();i++){
								System.out.println(myMembers.get(i).getName());
							}
							break;
						}
					case 4:
						System.out.println("please enter the name of the Society you wish to leave : ");
						String deletedName = br.readLine();
						String studentId=aStudent.getStudentNumber();
						Society aSociety = mySystem.Search(deletedName);
						if (aSociety==null){
							System.out.println("Society not found.");
							break;
						}
						else{
							if(aSociety.leaveSociety(studentId)){
								mySystem.update(aSociety);
								System.out.println(aStudent.getName() + " Has been removed from " + aSociety.getName());
								break;
							}else
							{
								System.out.println(aStudent.getName()+ " Was not in " + aSociety.getName());
								break;
								 
							}
						}
					case 5:
						selectionNumber=0;
						break;
						
						
						
				}

	        }catch(NumberFormatException nfe){
	            System.err.println("Invalid Format!");
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
