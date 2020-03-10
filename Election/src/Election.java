public class Election {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> candidateList = new ArrayList<String>(5);
		ArrayList<String> candidateRank = new ArrayList<String>(5); // unsure on what to use this on atm.
		ArrayList<Set<ArrayList>> listOfCandidateSets = new ArrayList<Set<ArrayList>>(5);
//		Set<String> candidate1 = new DynamicSet<String>(10);
//		Set<String> candidate2 = new DynamicSet<String>(10);
//		Set<String> candidate3 = new DynamicSet<String>(10);
//		Set<String> candidate4 = new DynamicSet<String>(10);
//		Set<String> candidate5 = new DynamicSet<String>(10);
		Set<ArrayList> candidate1 = new DynamicSet<ArrayList>(10);
		Set<ArrayList> candidate2 = new DynamicSet<ArrayList>(10);
		Set<ArrayList> candidate3 = new DynamicSet<ArrayList>(10);
		Set<ArrayList> candidate4 = new DynamicSet<ArrayList>(10);
		Set<ArrayList> candidate5 = new DynamicSet<ArrayList>(10);
		listOfCandidateSets.add(candidate1);
		listOfCandidateSets.add(candidate2);
		listOfCandidateSets.add(candidate3);
		listOfCandidateSets.add(candidate4);
		listOfCandidateSets.add(candidate5);

		int BallotNum;

		Ballot.storeCandidates(candidateList);

		BallotNum = Ballot.storeBallots(candidate1, candidate2, candidate3, candidate4, candidate5);

		System.out.println("Number of Ballots: " + BallotNum);

		Ballot.winBy50(listOfCandidateSets, BallotNum);

	}
}
