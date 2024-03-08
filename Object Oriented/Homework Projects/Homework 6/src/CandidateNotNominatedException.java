public class CandidateNotNominatedException extends Exception{
private String candidate;

    CandidateNotNominatedException(String candidate){
        super(candidate + " has not been nominated");
        this.candidate = candidate;
    }

    public String getCandidate(){
        return this.candidate;
    }
}
