//package edu.wpi.ahrens.Lecture10;

import java.util.LinkedList;
import java.util.List;

public abstract class AbsSTEMQuery implements ClubQueries {
    LinkedList<ClubStudent> students = new LinkedList<>();
    LinkedList<STEMClub> clubs = new LinkedList<>();

    public void addStudents(List<ClubStudent> students){
        // add the students param to the students field (pool them up)
        this.students.addAll(students);
    }
    public void process(){
     // TODO:
        // Loop over all of the students in the field
        // clean and parse them into stem clubs to get roster changes
        // merge them with the current rosters
        // clean out the students field
//        for(ClubStudent clubStudent : this.students){
//
//        }
        List<STEMClub> newRosters = STEMClub.parse(this.students);
        for(STEMClub newRoster : newRosters){
            for(STEMClub savedRoster : this.clubs){
                //if they are the same club
                if(newRoster.clubName.equals(savedRoster.clubName)) {
                    // add the new students to the old roster
                    for(String studentName : newRoster.roster){
                        if(! savedRoster.roster.contains(studentName)){
                            savedRoster.roster.add(studentName);
                        }
                    }
                }
            }
        }
        this.students.clear();
    }
    public int totalStudents() {
        int totalStem = 0;
        for(STEMClub stemClub : this.clubs){
            totalStem += stemClub.roster.size();
        }
        return totalStem;
    }
    @Override
    public double avgPerClub() {
        return this.totalStudents() * 1.0 / this.clubs.size();
    }
    @Override
    public String biggestClub() {
        if(this.clubs.isEmpty()) { return "No clubs :("; }
        STEMClub biggestSoFar = this.clubs.getFirst();
        for(STEMClub club : this.clubs){
            if(club.roster.size() > biggestSoFar.roster.size()){
                biggestSoFar = club;
            }
        }
        return biggestSoFar.clubName;
    }
}
