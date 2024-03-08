//package edu.wpi.ahrens.Lecture10;

import java.util.List;
public interface ClubQueries {

    void addStudents(List<ClubStudent> students);

    int totalStudents();

    double avgPerClub();

    String biggestClub();

}
