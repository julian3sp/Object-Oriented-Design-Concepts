import java.util.HashMap;
import java.util.Optional;

public class MostAgreeableStrategy implements I3VoteStrategy{
    @Override
    public Optional<String> calculateWinner(HashMap<String, Votes> votes) {
        String mostVotedCandidate = null;
        int maxVotes = 0;
        for (HashMap.Entry<String, Votes> entry : votes.entrySet()) {
            int firstVotes = entry.getValue().getFirstVotes();
            int secondVotes = entry.getValue().getSecondVotes();
            int thirdVotes = entry.getValue().getThirdVotes();
            if (firstVotes > maxVotes) {
                mostVotedCandidate = entry.getKey();
                maxVotes = firstVotes;
            }
            if (secondVotes > maxVotes) {
                mostVotedCandidate = entry.getKey();
                maxVotes = secondVotes;
            }
            if (thirdVotes > maxVotes) {
                mostVotedCandidate = entry.getKey();
                maxVotes = thirdVotes;
            }
        }
        if (!(mostVotedCandidate == null)) {
            return Optional.of(mostVotedCandidate);
        }
        else{
            return Optional.empty();
        }
    }
}
