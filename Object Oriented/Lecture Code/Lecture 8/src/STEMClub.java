import java.util.ArrayList;
import java.util.List;

public abstract class STEMClub {
    //How do we initialize a class to do the work we did last time ina  reusable / maintainable way
    //Remember the SO SOLID:
    // - Single Responsibility, no unit of code does too much. open extnesion, closed modify. Write reusable code

    public ArrayList<String> roster;
    public String clubName;

    public static ArrayList<String> STEM_CLUBS = new ArrayList(List.of("ACM", "SWE", "Math Club",
            "Science Club",
            "Robotics", "Biology Club",
            "Physics Club"));

    public STEMClub(String club,
                    ArrayList<ClubStudent> students){
        this.clubName = club;
        if(!STEMClub.STEM_CLUBS.contains(clubName)){
            System.err.println(clubName + " is not a STEM CLub");
        }
        roster = new ArrayList<>();
                this.clean(students);

    }

    public void clean(ArrayList<ClubStudent> students){
        for(ClubStudent student : students){
            if(student.club.equals(this.clubName)){
                roster.add(student.student);
            }
        }
    }
    //make a stem club object for each stem club
    public static  List<STEMClub> parse(List<ClubStudent> students){
        ArrayList<STEMClub> stemClubs = new ArrayList<>();
        for(String club : STEMClub.STEM_CLUBS){
            stemClubs.add(new STEMClub(clubName,students);


        }
        return stemClubs;
    }
}
