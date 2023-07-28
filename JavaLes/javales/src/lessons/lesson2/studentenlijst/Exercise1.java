package javales.src.lessons.lesson2.studentenlijst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise1 {

    private static List<Classroom> classRooms;

    public static void main(String[] args) {
        setup();
    }

    private static void setup() {
        // create the students and assign their grades
        Student droes = new Student("Droes", 16);
        droes.addGrade("Nederlands", 5.5);
        Student anton = new Student("Anton", 15);
        anton.addGrade("Nederlands", 7.0);
        Student antoinette = new Student("Antoinette", 16);
        anton.addGrade("Nederlands", 9.7);

        Student roy = new Student("Roy", 17);
        roy.addGrade("Nederlands", 6);
        Student kees = new Student("Kees", 16);
        kees.addGrade("Nederlands", 4.0);
        Student marie = new Student("Marie", 16);
        marie.addGrade("Nederlands", 2.0);

        Student tim = new Student("Tim", 17);
        tim.addGrade("Nederlands", 3.2);
        Student piet = new Student("Piet", 16);
        piet.addGrade("Nederlands", 7.0);
        Student kim = new Student("Kim", 16);
        kim.addGrade("Nederlands", 6.0);

        // create the class rooms and add the students
        Classroom room1 = new Classroom("4a", new Mentor("Klaas Vaartjes", 54));
        room1.setStudents(new ArrayList<>(Arrays.asList(droes, anton, antoinette)));

        Classroom room2 = new Classroom("5a", new Mentor("Roos Vaartjes", 52));
        room2.setStudents(new ArrayList<>(Arrays.asList(roy, kees, marie)));

        Classroom room3 = new Classroom("5b", new Mentor("Nico Dijkstra", 46));
        room3.setStudents(new ArrayList<>(Arrays.asList(tim, piet, kim)));

        // set the classrooms list
        classRooms = new ArrayList<>(Arrays.asList(room1, room2, room3));
    }

}
