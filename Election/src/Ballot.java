import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Ballot<E> extends ArrayList {

	public Ballot(int initialCapacity) {
		super(initialCapacity);
		initialCapacity = 0;
	}
	
	// Method used to store all the ballots in their appropiate structures

	@SuppressWarnings("unchecked") 
	public static int storeBallots(Set<ArrayList> a, Set<ArrayList> b, Set<ArrayList> c, Set<ArrayList> d, Set<ArrayList> e) {

		File file = new File("\\Users\\chris\\eclipse-workspace\\Election\\ballots.csv");
		int counter = 0;

		try (Scanner sc = new Scanner(file)) {
			while(sc.hasNextLine()) {
				String[] s = sc.nextLine().split(","); // Splits the line and creates an array of strings

				Ballot t = new Ballot(s.length); // Creates an arraylist of the same size as array

				for(int i = 0; i < s.length; i++) { // Copies everything from the array to an arraylist
					t.add(s[i]);
				}

				if(t.isValid()); {  // If the ballot is valid, print it on to the console
					t.storeToSet(a, b, c, d, e);// Helper method, can be found below. 
					counter++; // This will be the number of ballots
				}
			}
		} 
		catch (FileNotFoundException f) {
			f.printStackTrace();
		}
		return counter;
	}

	public static void storeCandidates(ArrayList<String> candidateList) {
		File file = new File("\\Users\\chris\\eclipse-workspace\\Election\\candidates.csv");

		try(Scanner sc = new Scanner(file)) {
			while(sc.hasNextLine()) {
				String[] s = sc.nextLine().split(",");
				candidateList.add(s[0]); // adds the candidate from the current line on to the list from the parameter
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	@SuppressWarnings("unused")
	public static void winBy50(ArrayList<Set<ArrayList>> e, int BallotNum) { // If anyone 
		Set<String> eliminate  = new DynamicSet<String>(5);
		int counter = 0;
		int num = 0;
		
		for(int i = 0; i < e.size(); i++) {
			for(Set<ArrayList> o: e) {
				counter++;
			}
			System.out.println(counter);
		}
	}
	
	public static void votingRounds() {
		
	}

	public boolean eliminate(int candidateID) {
		if(candidateID == 1) {

		}
		if(candidateID == 2) {

		}
		if(candidateID == 3) {

		}
		if(candidateID == 4) {

		}
		if(candidateID == 5) {

		}
		return false;
	}
	
	public int getBallotNum() {
		return Integer.parseInt((String) this.get(0));
	}

	public int getRankByCandidate(int candidateID) {

		return 0;
	}

	public int getCandidateByRank(int rank) {
		return 0;
	}
	
	//All helper methods are below
	
	@SuppressWarnings("unchecked")
	/* Takes the ballot and checks which candidate is the favorite in that ballot, then it adds the ballot to
	 * that candidate's set.
	 */
	public void storeToSet(Set<E> a, Set<E> b, Set<E> c, Set<E> d, Set<E> e) { 
		if(this.get(1).equals("1:1")) {
			a.add((E) this);
		}
		if(this.get(1).equals("2:1")) {
			b.add((E) this);
		}
		if(this.get(1).equals("3:1")) {
			c.add((E) this);
		}
		if(this.get(1).equals("4:1")) {
			d.add((E) this);
		}
		if(this.get(1).equals("5:1")) {
			e.add((E) this);
		}
	}
	
	public boolean isValid() {
		if(this.size() == 1) return false; // The ballot is empty
		return false;
	}
	
	public static void printSet(Set<String> theSet) {
		int n = 0;
		for(Object obj: theSet) {
			n++;
			System.out.println(obj + " theSet[" + n + "]");
		}
		System.out.println("Set size: " + theSet.size());
	}

}
