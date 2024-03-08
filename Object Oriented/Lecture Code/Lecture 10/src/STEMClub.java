// edu.wpi.ahrens.Lecture10;

import java.util.ArrayList;
import java.util.List;

public class STEMClub {
    // How do we initialize an object to do
    // the work we did last time in a
    // reusable / maintainable way

    // Remember the SO from SOLID:
    // - Single Responsibility
    //   - no unit of code does too much
    // - Open-extension, closed-modify
    //   - write reusable code that
    //     won't need to be edited later

    public ArrayList<String> roster;
    public String clubName;
    public static ArrayList<String> STEM_CLUBS =
            new ArrayList(List.of("ACM", "SWE", "Math Club",
                    "Science Club", "Robotics",
                    "Biology Club", "Physics Club"));

    public STEMClub(String clubName, List<ClubStudent> students){
        if(!STEMClub.STEM_CLUBS.contains(clubName)){
            System.err.println(clubName +
                    " is not a stem club");
        }
        this.clubName = clubName;
        roster = new ArrayList<>();
        this.clean(students);
    }

    public void clean(List<ClubStudent> students){
        for(ClubStudent student : students){
            if(student.club.equals(this.clubName)){
                roster.add(student.student);
            }
        }
    }

    // make a stem club object for each stem club
    public static List<STEMClub> parse(List<ClubStudent> students){
        ArrayList<STEMClub> stemClubs = new ArrayList<>();
        for(String clubName : STEMClub.STEM_CLUBS){
            stemClubs.add(new STEMClub(clubName,students));
        }
        return stemClubs;
    }





}
