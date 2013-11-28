package psd3;

import java.io.BufferedReader;
import java.io.IOException;

public class CourseLecturer {
    
    public int printCourseLecturer(BufferedReader br) throws IOException {
        System.out.println("\n\n\n1. View Session");
        System.out.println("0. Sign out");
        System.out.print("Please enter a choice : ");

        return Integer.parseInt(br.readLine());
    }
}
