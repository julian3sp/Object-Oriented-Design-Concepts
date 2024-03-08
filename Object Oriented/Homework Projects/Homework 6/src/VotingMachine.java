import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static java.util.Optional.*;

public class VotingMachine {
        private ElectionData electionData;
        private Scanner scanner;
        public VotingMachine() {
            this.electionData = new ElectionData(new MostFirstVotesStrategy());
            this.scanner = new Scanner(System.in);
        }

        public static void main(String[] args) throws AlreadyNominatedException, MoreThanOnceException, CandidateNotNominatedException {
            Scanner keyboard = new Scanner(System.in);
            boolean keepGoing = true;
            String currentCandidate = null;
            String firstVote = null;
            String secondVote = null;
            String thirdVote = null;
            VotingMachine votingMachine = new VotingMachine();
            System.out.println("The current candidates are: " + votingMachine.printCandidates());
            while(keepGoing) {
                System.out.println("Do you want to [n]ominate someone, [v]ote for someone, change winner [s]trategy, see who [w]on, or [q]uit?");
                String nextLine = keyboard.nextLine().toLowerCase().strip();
                if (nextLine.charAt(0) == 'n') {
                    System.out.println("Who would you like to nominate");
                    currentCandidate = keyboard.nextLine();
                    if(votingMachine.electionData.getCandidates().contains(currentCandidate)){
                        System.out.println("This candidate has already been nominated");
                    }
                    else{
                        votingMachine.electionData.nominateCandidate(currentCandidate);
                        System.out.println("The current candidates are: " + votingMachine.printCandidates());
                    }

                } else if (nextLine.charAt(0) == 'v') {
                    System.out.println("first choice:");
                    firstVote = keyboard.nextLine();
                    System.out.println("second choice:");
                    secondVote = keyboard.nextLine();
                    System.out.println("third choice:");
                    thirdVote = keyboard.nextLine();
                    try {
                        votingMachine.electionData.submitVote(firstVote, secondVote, thirdVote);
                        System.out.println("Vote cast successfully!");
                    } catch (CandidateNotNominatedException e) {
                        votingMachine.missingCandidate(e.getCandidate());
                    } catch (MoreThanOnceException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (nextLine.charAt(0) == 's') {
                    System.out.println("Which strategy would you like to use? most [f]irst votes or most [a]greeable?");
                    if(keyboard.nextLine().toLowerCase().startsWith("f")){
                        votingMachine.electionData.setStrategy(new MostFirstVotesStrategy());
                    } else if (keyboard.nextLine().toLowerCase().startsWith("a")) {
                        votingMachine.electionData.setStrategy(new MostAgreeableStrategy());
                    }
                    else {
                        System.err.println("invalid strategy");
                    }
                } else if ((nextLine.charAt(0) == 'w')) {
                    if(! votingMachine.electionData.getCandidates().isEmpty()){
                        if(votingMachine.electionData.calculateWinner().isPresent()) {
                            System.out.println(votingMachine.electionData.calculateWinner());
                        }
                        else {
                            System.err.println("No clear winner under the current strategy.");
                        }
                    }
                } else if ((nextLine.charAt(0) == 'q')) {
                    keepGoing = false;
                }

            }

        }

        private void missingCandidate(String missingCandidate) throws AlreadyNominatedException {
            System.out.println("The candidate " + missingCandidate + " is not nominated");
            System.out.println("Would you like to nominate the candidate? [y]es or [n]o");
            String nextLine = scanner.nextLine().toLowerCase();
            if (nextLine.startsWith("y")) {
                electionData.nominateCandidate(missingCandidate);
            } else {
                System.out.println("Restarting the voting process.");
            }
        }


        private List<String> printCandidates(){
            List<String> candidates = new ArrayList<>();
            for(String candidate : electionData.getCandidates()){
                candidates.add(candidate);
            }
            return candidates;
        }
}
