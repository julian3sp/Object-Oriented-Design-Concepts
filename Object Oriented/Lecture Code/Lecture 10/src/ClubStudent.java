//package edu.wpi.ahrens.Lecture10;

public class ClubStudent {
    public String student;
    public String club;
    public ClubStudent(String student, String club){
        this.student = student;
        this.club = club;
    }

    @Override
    public String toString(){
        return this.student + ":" + this.club;
    }

    public int compareTo(ClubStudent clubStudent){
        return this.club.compareTo(clubStudent.club);
    }
}
