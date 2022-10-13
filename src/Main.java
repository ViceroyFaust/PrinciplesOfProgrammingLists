import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/*
Create class Student:
+ name
+ surname
+ year of birth

Create a program which asks for student list.
User should enter student with one line:
Petro Petrenko 2005

Program should get this input as one string and parse it:
- Split the string by « » space, String.split
- Delete redundant spaces String.trim()
- Create Student object
- Put values into corresponding properties name, surname
- Convert year string into int and put it into corresponding Student property.

Add new value unless user finished.

Output list of Student objects one by one (enhanced for loop).
 === GROUP 3 === */
public class Main {
    // Gets a new line of text from the user
    public static String getUserString(String prompt) {
        System.out.print(prompt);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
    // Checks if the input is an integer or not
    public static boolean isNumber(String text) {
        if (text.length() == 0 || (text.length() == 1 && text.charAt(0) == '-'))
            return false;
       int startIndex = 0;
        if (text.charAt(0) == '-')
            ++startIndex;
        for (int i = startIndex; i < text.length(); ++i) {
            char c = text.charAt(i);
            if (c < '0' || c > '9') // Check if char is a number, if not return false
                return false;
        }
        return true;
    }
    // Parses the data about the student from input
    public static Student parseStudent(String text) {
        String[] parts = text.trim().split("\s+"); // \s+ removes all whitespace between words
        if (parts.length != 3 || !isNumber(parts[2]))
            return null; //Returns null if the year of birth is not a number
        String name = parts[0];
        String surname = parts[1];
        int birthYear = Integer.parseInt(parts[2]);
        return new Student(name, surname, birthYear);
    }

    // Prints a list of student objects in the format "<NAME> <SURNAME>, born y. <YEAR>"
    public static void printStudentList(List<Student> students) {
        for (Student s : students)
            System.out.printf("%s %s, born y. %d\n", s.name(), s.surname(), s.birthYear());
    }

    // Adds each student to a list via user input, checking if the data given is correct
    public static void addStudents(List<Student> students) {
        String exitWord = "0";
        boolean go = true;
        while (go) {
            String input = getUserString("Input \"name surname birthYear\" or " + exitWord + " to stop: ");
            if (input.equals(exitWord)) {
                go = false;
                continue;
            }
            Student student = parseStudent(input);
            if (student != null)
                students.add(student);
            else
                System.out.println("DATA INCORRECT, STUDENT NOT ADDED");
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        addStudents(students);
        System.out.println("List of Students:");
        printStudentList(students);
    }
}