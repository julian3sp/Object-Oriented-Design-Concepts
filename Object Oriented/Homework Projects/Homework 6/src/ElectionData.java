
import java.util.*;

public class ElectionData {
    private HashMap<String, Votes> candidateVotes;
    private I3VoteStrategy voteStrategy;
    public ElectionData(I3VoteStrategy strategy){
        this.candidateVotes = new HashMap<>();
        this.voteStrategy = strategy;
    }
    public void setStrategy(I3VoteStrategy strategy){
        this.voteStrategy = strategy;
    }
    public Set<String> getCandidates(){
        return new HashSet<>(candidateVotes.keySet());
    }
    public void nominateCandidate(String person) throws AlreadyNominatedException{
        if(candidateVotes.containsKey(person)){
            throw new AlreadyNominatedException(person);
        }
        else{
            candidateVotes.put(person, new Votes(0, 0, 0));
        }
    }
    public void submitVote(String first, String second, String third) throws CandidateNotNominatedException, MoreThanOnceException{
    validCandidate(first);
    validCandidate(second);
    validCandidate(third);
    noDuplicates(first, second, third);
    candidateVotes.get(first).voteFirst();
    candidateVotes.get(second).voteSecond();
    candidateVotes.get(third).voteThird();

    }
    public HashMap<String, Votes> deepCopy(){
        HashMap<String, Votes> deepCopy = new HashMap<>();
        for (HashMap.Entry<String, Votes> entry : candidateVotes.entrySet()) {
            deepCopy.put(entry.getKey(), new Votes(entry.getValue()));
        }
        return deepCopy;
    }
    public Optional<String> calculateWinner() {
        return voteStrategy.calculateWinner(deepCopy());
    }

    public void validCandidate(String candidate) throws CandidateNotNominatedException{
    if(!candidateVotes.containsKey(candidate)){
        throw new CandidateNotNominatedException(candidate);
    }
    }
    public void noDuplicates(String first, String second, String third) throws MoreThanOnceException {
        String candidate = "";
        if (first.equals(second)) {
            candidate = second;
            throw new MoreThanOnceException(candidate);
        }
        if (first.equals(third)) {
            candidate = third;
            throw new MoreThanOnceException(candidate);
        }
        if (third.equals(second)) {
            candidate = third;
            throw new MoreThanOnceException(candidate);
        }
    }


}
