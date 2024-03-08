import java.util.*;

public class MostFirstVotesStrategy implements I3VoteStrategy {

    public int firstVoteCount(HashMap<String, Votes> votes) {
        int totalFirstVotes = 0;
        for (HashMap.Entry<String, Votes> entry : votes.entrySet()) {
            int firstVotes = entry.getValue().getFirstVotes();
            totalFirstVotes =+ firstVotes;
        }
        return totalFirstVotes;
    }
    @Override
    public Optional<String> calculateWinner(HashMap<String, Votes> votes) {
        String mostVotedCandidate = null;
        int maxVotes = 0;
        int count = 0;
        Set<String> tiedCandidates = new HashSet<>();
        for (HashMap.Entry<String, Votes> entry : votes.entrySet()) {
            int firstVotes = entry.getValue().getFirstVotes();
            if (firstVotes > maxVotes && firstVotes > (firstVoteCount(votes) / 2)) {
                mostVotedCandidate = entry.getKey();
                maxVotes = firstVotes;
            } else if (firstVotes == maxVotes && count > 1 ) {
            tiedCandidates.add(entry.getKey());
            }
            count += 1;
        }
        if (!(mostVotedCandidate == null) && tiedCandidates.isEmpty()) {
            return Optional.of(mostVotedCandidate);
        }
         else{
                return Optional.empty();
            }
        }
    }

