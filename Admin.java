package psd3;

import java.io.BufferedReader;
import java.io.IOException;

public class Admin {

    public int printMenuAdmin(BufferedReader br) throws IOException {
        System.out.println("\n\n\n1. Export all student grades for all completed assignments");
        System.out.println("2. Export all grades for a single student");
        System.out.println("3. Sign out");
        System.out.print("Please enter a choice : ");

        return Integer.parseInt(br.readLine());
    }

    public static int printMenuByModule(BufferedReader br, String[] course) throws IOException {
        System.out.println("\nSelect a Course\n\n");

        for (int i = 0; i < course.length; i++) {
            System.out.println((i + 1) + ".  " + course[i]);
        }
        System.out.println("4.  Back");
        System.out.print("Please enter a choice : ");
        return Integer.parseInt(br.readLine());
    }

    public static int printMenuByStudent(BufferedReader br, String[] student) throws IOException {
        System.out.println("\nSelect a Student\n\n");

        for (int i = 0; i < student.length; i++) {
            System.out.println((i + 1) + ".  " + student[i]);
        }
        System.out.println((student.length + 1) + ".  Back");
        System.out.print("Please enter a choice : ");
        return Integer.parseInt(br.readLine());
    }
}
