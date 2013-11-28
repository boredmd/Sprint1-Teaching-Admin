import java.io.*;
import java.util.*;

public class Psdapp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int getInput = 0;
        try {
            getInput = printMenu(br);

            switch (getInput) {
                case 1:
                    System.out.println("\n\nLogin as Admin success\n");
                    try {
                        do {
                            Admin admin = new Admin();
                            getInput = admin.printMenuAdmin(br);
                            if (getInput == 1) {
                                System.out.println("Exporting all student grades");
                            } else if (getInput == 2) {
                                System.out.println("Exporting all student grades");
                            }
                        } while (getInput != 3);

                    } catch (NumberFormatException nfe) {
                        System.err.println("Invalid Format!");
                    }


                    //do something.
                    break;
                case 2:
                    System.out.println("Choice 2 choosen!");
                    getInput = printMenu(br);
                    //do something.
                    break;
                case 3:
                    System.out.println("Login as Tutor Success");
                    try {
                        do {
                            Tutor tutor = new Tutor();
                            getInput = tutor.printMenuTutor(br);
                            if (getInput == 1) {
                                System.out.println("Viewing all Session");
                            } else if (getInput == 2) {
                                System.out.println("Exporting all student grades");
                            }
                        } while (getInput != 3);

                    } catch (NumberFormatException nfe) {
                        System.err.println("Invalid Format!");
                    }


                    //do something.
                    break;
                case 4:
                    System.out.println("Choice 4 choosen!");
                    getInput = printMenu(br);
                    //do something.
                    break;
                case 5:
                    System.out.println("Choice 5 choosen!");
                    //do something.
                    break;
                default:
                    System.out.println("**Invalid choice!**/n");
                    getInput = printMenu(br);
                    break;
            }
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
    }

    private static int printMenu(BufferedReader br) throws IOException {
        System.out.println("\n\n\n\n\n\n");
        System.out.println("Login as :");
        System.out.println("1. Teaching Administrator/Secretary");
        System.out.println("2. Course Lecturers");
        System.out.println("3. Tutors");
        System.out.println("5. Exit");
        System.out.print("Please enter a choice : ");
        return Integer.parseInt(br.readLine());
    }
//    private static int printMenuLecturer(BufferedReader br) throws IOException {
//    
//        System.out.println("\n\n1. Export all student grades for all completed assignments");
//        System.out.println("2. Export all grades for a single student");
//        System.out.println("3. Sign out");
//        System.out.print("Please enter a choice : ");
//
//        return Integer.parseInt(br.readLine());
//    }
//    private static int printMenuTutor(BufferedReader br) throws IOException {
//    
//        System.out.println("1. View Session");
//        System.out.println("2. Export all grades for a single student");
//        System.out.println("3. Sign out");
//        System.out.print("Please enter a choice : ");
//
//        return Integer.parseInt(br.readLine());
//    }   
}
