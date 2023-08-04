package javales.src.lessons.lesson2.studentenlijst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Exercise1 {

    /**
     * @value javales.src.lessons.lesson2.studentenlijst#AVERAGE
     */
    private static final double AVERAGE = 5.0;

    /**
     * @value javales.src.lessons.lesson2.studentenlijst#DIVIDER
     */
    private static final String DIVIDER = "=".repeat(20) + "\n";

    /**
     * @value javales.src.lessons.lesson2.studentenlijst#NEDERLANDS
     */
    private static final String NEDERLANDS = "Nederlands";

    /**
     * ArrayList of classrooms containing students
     */
    private static List<Classroom> classRooms;

    /**
     * ArrayList of students
     */
    private static List<IStudent> students;

    public static void main(String[] args) {
        setup();

        printStudentByClassroom();

        printStudentsPassedAndFailed();

    }

    /**
     * Print a list of passing and failing students
     */
    private static void printStudentsPassedAndFailed() {
        String output = "";

        List<IStudent> passed = getStudentsByCriteriaSortedByAVGGrade((IStudent s) -> s.getAverage() > AVERAGE);
        List<IStudent> failed = getStudentsByCriteriaSortedByAVGGrade((IStudent s) -> s.getAverage() <= AVERAGE);

        output += "Passing grades:\n";
        output += DIVIDER;
        output += addAvgGradeListToOutput(passed);
        output += "\nFailing grades:\n";
        output += DIVIDER;
        output += addAvgGradeListToOutput(failed);

        System.out.print(output);
    }

    private static List<IStudent> getStudentsByCriteriaSortedByAVGGrade(Predicate<IStudent> consumer) {
        return students.stream().filter(consumer)
                .sorted(Comparator.comparingDouble(IStudent::getAverage).reversed()).toList();
    }

    /**
     * Convert a list of students to a textual representation with average grade
     * 
     * @param List<Student> students
     * @return String output
     */
    private static String addAvgGradeListToOutput(List<IStudent> students) {
        var output = new Object() {
            String value = "";
        };
        students.forEach((IStudent student) -> output.value += String.format("%s:\t%.1f%n", student.toListEntry(),
                student.getAverage()));

        return output.value;
    }

    /**
     * Print Student grade list by class
     */
    private static void printStudentByClassroom() {
        var output = new Object() {
            String value = "";
        };

        classRooms.forEach(classroom -> {
            output.value += String.format("Klas %s :%n", classroom.getName());
            output.value += DIVIDER;

            classroom.getStudents().forEach(student -> {
                output.value += String.format("%s:%n", student.toListEntry());
                output.value += "-".repeat(20) + "\n";

                student.getGrades().forEach(
                        subject -> output.value += String.format("%s: %.1f%n", subject.getName(), subject.getGrade()));

                output.value += "\n";
            });

            System.out.print(output.value);
        });
    }

    private static void setup() {
        // create the students and assign their grades
        Student droes = new Student("Droes", 16, "0001");
        droes.addGrade(new Subject(NEDERLANDS, 5.5));
        Student anton = new Student("Anton", 15, "0002");
        anton.addGrade(new Subject(NEDERLANDS, 7.0));
        Student antoinette = new Student("Antoinette", 16, "0003");
        anton.addGrade(new Subject(NEDERLANDS, 9.7));

        Student roy = new Student("Roy", 17, "0004");
        roy.addGrade(new Subject(NEDERLANDS, 6));
        Student kees = new Student("Kees", 16, "0005");
        kees.addGrade(new Subject(NEDERLANDS, 4.0));
        Student marie = new Student("Marie", 16, "0006");
        marie.addGrade(new Subject(NEDERLANDS, 2.0));

        Student tim = new Student("Tim", 17, "0007");
        tim.addGrade(new Subject(NEDERLANDS, 3.2));
        Student piet = new Student("Piet", 16, "0008");
        piet.addGrade(new Subject(NEDERLANDS, 7.0));
        Student kim = new Student("Kim", 16, "0009");
        kim.addGrade(new Subject(NEDERLANDS, 6.0));

        // create the class rooms and add the students
        Classroom room1 = new Classroom("4a", new Mentor("Klaas Vaartjes", 54));
        room1.setStudents(new ArrayList<>(Arrays.asList(droes, anton, antoinette)));

        Classroom room2 = new Classroom("5a", new Mentor("Roos Vaartjes", 52));
        room2.setStudents(new ArrayList<>(Arrays.asList(roy, kees, marie)));

        Classroom room3 = new Classroom("5b", new Mentor("Nico Dijkstra", 46));
        room3.setStudents(new ArrayList<>(Arrays.asList(tim, piet, kim)));

        // set the classrooms list
        classRooms = new ArrayList<>(Arrays.asList(room1, room2, room3));

        // set the students list
        students = new ArrayList<>(Arrays.asList(droes, anton, antoinette, roy, kees, marie, tim, piet, kim));
    }

}
