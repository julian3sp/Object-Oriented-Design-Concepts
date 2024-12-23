//package edu.wpi.ahrens.Lecture10;

import java.util.LinkedList;
import java.util.List;

public class Main {
    /* Agenda:
     *  Split up an algorithm into steps
     *  - Cleaning: Filter out data we don't need to solve the problem
     *  - Parsing: Restructure the data into a form that makes solving the problem easier
     */


    // Problem: given a collection of students with a primary club
    // - How many stem club students are there?
    // - How do we get the average number of participants in STEM related clubs?
    // - How do we find the STEM club with the most participants?
    public static void main(String[] args){
        List<STEMClub> stemClubs = STEMClub.parse(students());

        int totalStem = 0;
        for(STEMClub stemClub : stemClubs){
            totalStem += stemClub.roster.size();
        }
        // How many stem students?
        System.out.println("STEM club students: " + totalStem );
        System.out.println("STEM AVG " + (totalStem / stemClubs.size()));



    }





    // Data generated by ChatGPT4.0
    public static List<ClubStudent> students(){
        LinkedList<ClubStudent> students = new LinkedList<>(List.of(
                new ClubStudent("Abbey", "Theatre"),
                new ClubStudent("Ben", "Theatre"),
                new ClubStudent("Cindy", "Pep Band"),
                new ClubStudent("Daniel", "ACM"),
                new ClubStudent("Edith", "ACM"),
                new ClubStudent("Fran", "SWE"),
                new ClubStudent("George", "Chess Club"),
                new ClubStudent("Hannah", "Math Club"),
                new ClubStudent("Ian", "Debate Team"),
                new ClubStudent("Julia", "Science Club"),
                new ClubStudent("Kevin", "Robotics"),
                new ClubStudent("Laura", "Art Club"),
                new ClubStudent("Miguel", "Drama Club"),
                new ClubStudent("Nina", "Eco Club"),
                new ClubStudent("Oscar", "Photography"),
                new ClubStudent("Priya", "Literature Club"),
                new ClubStudent("Quincy", "ACM"),
                new ClubStudent("Rita", "Biology Club"),
                new ClubStudent("Sam", "History Club"),
                new ClubStudent("Tina", "Physics Club"),
                new ClubStudent("Umar", "Film Club"),
                new ClubStudent("Vera", "Astronomy Club"),
                new ClubStudent("Walter", "Chess Club"),
                new ClubStudent("Xena", "Debate Team"),
                new ClubStudent("Yasmin", "Science Club"),
                new ClubStudent("Zach", "Robotics"),
                new ClubStudent("Amelia", "Art Club"),
                new ClubStudent("Brad", "Drama Club"),
                new ClubStudent("Claire", "Eco Club"),
                new ClubStudent("David", "Photography"),
                new ClubStudent("Elaine", "Literature Club"),
                new ClubStudent("Felix", "ACM"),
                new ClubStudent("Grace", "Biology Club"),
                new ClubStudent("Henry", "History Club"),
                new ClubStudent("Isla", "Physics Club"),
                new ClubStudent("Jake", "Film Club"),
                new ClubStudent("Kelly", "Astronomy Club"),
                new ClubStudent("Leo", "Chess Club"),
                new ClubStudent("Mia", "Debate Team"),
                new ClubStudent("Noah", "Science Club"),
                new ClubStudent("Olivia", "Robotics"),
                new ClubStudent("Pablo", "Art Club"),
                new ClubStudent("Quinn", "Drama Club"),
                new ClubStudent("Rachel", "Eco Club"),
                new ClubStudent("Steve", "Photography"),
                new ClubStudent("Tara", "Literature Club"),
                new ClubStudent("Ulysses", "ACM"),
                new ClubStudent("Violet", "Biology Club"),
                new ClubStudent("William", "History Club"),
                new ClubStudent("Xander", "Physics Club"),
                new ClubStudent("Yvette", "Film Club"),
                new ClubStudent("Zoe", "Astronomy Club"),
                new ClubStudent("Aaron", "Chess Club"),
                new ClubStudent("Bella", "Debate Team"),
                new ClubStudent("Carlos", "Science Club"),
                new ClubStudent("Diana", "Robotics"),
                new ClubStudent("Ethan", "Art Club"),
                new ClubStudent("Fiona", "Drama Club"),
                new ClubStudent("Gavin", "Eco Club"),
                new ClubStudent("Hazel", "Photography"),
                new ClubStudent("Ivan", "Literature Club"),
                new ClubStudent("Jasmine", "ACM"),
                new ClubStudent("Kyle", "Biology Club"),
                new ClubStudent("Lily", "History Club"),
                new ClubStudent("Marco", "Physics Club"),
                new ClubStudent("Nora", "Film Club"),
                new ClubStudent("Owen", "Astronomy Club"),
                new ClubStudent("Paige", "Chess Club"),
                new ClubStudent("Quentin", "Debate Team"),
                new ClubStudent("Ruby", "Science Club"),
                new ClubStudent("Sean", "Robotics"),
                new ClubStudent("Tracy", "Art Club"),
                new ClubStudent("Ursula", "Drama Club"),
                new ClubStudent("Victor", "Eco Club"),
                new ClubStudent("Wendy", "Photography"),
                new ClubStudent("Xiomara", "Literature Club"),
                new ClubStudent("Yuri", "ACM"),
                new ClubStudent("Zara", "Biology Club"),
                new ClubStudent("Anthony", "History Club"),
                new ClubStudent("Bethany", "Physics Club"),
                new ClubStudent("Carter", "Film Club"),
                new ClubStudent("Daphne", "Astronomy Club"),
                new ClubStudent("Eduardo", "Chess Club"),
                new ClubStudent("Faye", "Debate Team"),
                new ClubStudent("Gerald", "Science Club"),
                new ClubStudent("Holly", "Robotics"),
                new ClubStudent("Isaac", "Art Club"),
                new ClubStudent("Jenna", "Drama Club"),
                new ClubStudent("Kurt", "Eco Club"),
                new ClubStudent("Luna", "Photography"),
                new ClubStudent("Mohammed", "Literature Club"),
                new ClubStudent("Natalie", "ACM"),
                new ClubStudent("Orlando", "Biology Club"),
                new ClubStudent("Piper", "History Club"),
                new ClubStudent("Quincy", "Physics Club"),
                new ClubStudent("Rebecca", "Film Club"),
                new ClubStudent("Sid", "Astronomy Club"),
                new ClubStudent("Tiffany", "Chess Club"),
                new ClubStudent("Ugo", "Debate Team"),
                new ClubStudent("Valerie", "Science Club"),
                new ClubStudent("Wayne", "Robotics"),
                new ClubStudent("Xenia", "Art Club"),
                new ClubStudent("Yolanda", "Drama Club"),
                new ClubStudent("Zack", "Eco Club")
        ));

        return students;
    }

}
