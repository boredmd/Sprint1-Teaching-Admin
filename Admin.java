/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author JasonPeh
 */
public class Admin {

    public Admin(){};
      public int printMenuAdmin(BufferedReader br) throws IOException {
    
        System.out.println("\n\n1. Export all student grades for all completed assignments");
        System.out.println("2. Export all grades for a single student");
        System.out.println("3. Sign out");
        System.out.print("Please enter a choice : ");

        return Integer.parseInt(br.readLine());
    }
  
    /**
     * @param args the command line arguments
     */
 //   public static void main(String[] args) {
        // TODO code application logic here
//    }
}
