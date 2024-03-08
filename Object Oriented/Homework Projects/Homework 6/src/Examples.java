import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class Examples {
    ElectionData eData;

    public Examples(){
        eData = new ElectionData(new MostFirstVotesStrategy());
    }

    @Test
    public void testOneVote(){
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
            this.eData.submitVote("gompei", "husky", "bristaco");
        }
        catch(Exception e){
            fail(e.getMessage());
        }
        assertEquals(Optional.of("gompei"), this.eData.calculateWinner());
    }
    @Test
    public void testNoVote(){
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
        }
        catch(Exception e){
            fail(e.getMessage());
        }
        assertEquals(Optional.empty(), this.eData.calculateWinner());
    }
    @Test
    public void testNoSimpleMajority(){
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
            this.eData.submitVote("gompei", "husky", "bristaco");
            this.eData.submitVote("bristaco", "husky", "gompei");
        }
        catch(Exception e){
            fail(e.getMessage());
        }
        assertEquals(Optional.empty(), this.eData.calculateWinner());
    }
    @Test
    public void testMostAgreeable(){
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
            this.eData.submitVote("gompei", "husky", "bristaco");
            this.eData.submitVote("bristaco", "husky", "gompei");
            this.eData.setStrategy(new MostAgreeableStrategy());
        }
        catch(Exception e){
            fail(e.getMessage());
        }
        assertEquals(Optional.of("husky"), this.eData.calculateWinner());
    }
    @Test
    public void testEncapsulateCandidates() throws AlreadyNominatedException{
        this.eData.nominateCandidate("gompei");
        assertTrue(this.eData.getCandidates().contains("gompei"));
        this.eData.getCandidates().clear();
        assertTrue(this.eData.getCandidates().contains("gompei"));
    }
    @Test(expected=AlreadyNominatedException.class)
    public void testCandidateAlreadyNominated() throws AlreadyNominatedException{
        this.eData.nominateCandidate("gompei");
        this.eData.nominateCandidate("gompei");
        fail("did not throw exception properly");
    }
    @Test(expected=CandidateNotNominatedException.class)
    public void testCandidateNotNominated() throws CandidateNotNominatedException, MoreThanOnceException{
        this.eData.submitVote("gompei", "husky", "bristaco");
        fail("did not throw exception properly");
    }
    @Test(expected=MoreThanOnceException.class)
    public void testMoreThanOnce() throws CandidateNotNominatedException, MoreThanOnceException, AlreadyNominatedException{
        this.eData.nominateCandidate("gompei");
        this.eData.nominateCandidate("husky");
        this.eData.nominateCandidate("bristaco");
        this.eData.submitVote("gompei", "gompei", "bristaco");
        fail("did not throw exception properly");
    }
}
