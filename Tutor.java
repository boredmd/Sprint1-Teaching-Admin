/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psd3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author JasonPeh
 */
public class Tutor {
    
    public Tutor(){};
     public int printMenuTutor(BufferedReader br) throws IOException {
    
        System.out.println("1. View Session");
        System.out.println("2. Export all grades for a single student");
        System.out.println("3. Sign out");
        System.out.print("Please enter a choice : ");

        return Integer.parseInt(br.readLine());
    }   
}
