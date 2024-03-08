//package edu.wpi.ahrens.Lecture10;



import java.util.List;

public class STEMQueryRealtime extends AbsSTEMQuery implements ClubQueries {
    @Override
    public void addStudents(List<ClubStudent> students) {
        super.addStudents(students);
        super.process();
    }

}
