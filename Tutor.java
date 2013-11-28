package psd3;

import java.io.BufferedReader;
import java.io.IOException;

public class Tutor {

    public int printMenuTutor(BufferedReader br) throws IOException {

        System.out.println("\n\n\n1. View Session");
        System.out.println("2. Import student attendance");
        System.out.println("0. Sign out");
        System.out.print("Please enter a choice : ");

        return Integer.parseInt(br.readLine());
    }

    public int printMenuImportAttendance(BufferedReader br, Attendance a) throws IOException {
        
        return Integer.parseInt(br.readLine());
    }
}
