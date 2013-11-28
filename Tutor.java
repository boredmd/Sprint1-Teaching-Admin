package psd3;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Tutor {

    private static final String[] COURSE = {"PL3",
        "PSD3", "IS3"};

    public int printMenuTutor(BufferedReader br) throws IOException {

        System.out.println("\n\n\n1. View Session");
        System.out.println("2. Import student attendance");
        System.out.println("3. Sign out");
        System.out.print("Please enter a choice : ");

        return Integer.parseInt(br.readLine());
    }

    public int printMenuViewAttendance(BufferedReader br, Attendance attendance) throws IOException {
        System.out.println("\n\n");
        for (int e = 0; e < attendance.getListOfStudent().size(); e++) {
            System.out.println((e + 1) + ". " + attendance.getStudent(e)
                    + " : " + (attendance.getAttending(e) ? "Attend" : "Did not attend"));
        }
        System.out.println("Enter ID to update that student's attendance");
        System.out.print("Enter '0' to go back : ");
        return Integer.parseInt(br.readLine());
    }

    public int printMenuImportAttendance(BufferedReader br) throws IOException {

        return Integer.parseInt(br.readLine());
    }

    public int printMenuEditAttendance(BufferedReader br,
            Attendance a) throws IOException {

        for (int i = 0; i < a.getListOfStudent().size(); i++) {
            System.out.println((i + i) + ". " + a.getListOfStudent().get(i) + " : "
                    + a.getAttendingList().get(i));
        }

        System.out.println("\nPlease enter number to edit attendance : ");

        return Integer.parseInt(br.readLine());
    }

    public int printCalendar(BufferedReader br, int hasFound, int getInput) throws IOException {
        System.out.println("\t\t\t\t\t\tNovember 2013");
        //Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
        System.out.println("---------------------------------------------------"
                + "--------------------------------------------------------------");
        System.out.println("|Su\t\t|Mo\t\t|Tu\t\t|We\t\t|Th\t\t|Fr\t\t|Sa\t\t|");
        System.out.println("---------------------------------------------------"
                + "--------------------------------------------------------------");

        System.out.println("|\t\t|\t\t|\t\t|\t\t|\t\t|1\t\t|2\t\t|");

        System.out.println("---------------------------------------------------"
                + "--------------------------------------------------------------");

        System.out.println("|03 " + COURSE[0] + " \t|04 " + COURSE[1]
                + "\t|05 " + COURSE[1] + "\t|06\t\t|07\t\t|08\t\t|09\t\t|");

        System.out.println("---------------------------------------------------"
                + "--------------------------------------------------------------");

        System.out.println("|10 " + COURSE[0] + " \t|11 " + COURSE[1]
                + "\t|12 " + COURSE[1] + "\t|13\t\t|14\t\t|15\t\t|16\t\t|");

        System.out.println("---------------------------------------------------"
                + "--------------------------------------------------------------");

        System.out.println("|17 " + COURSE[0] + " \t|18 " + COURSE[1]
                + "\t|19 " + COURSE[1] + "\t|20\t\t|21\t\t|22\t\t|23\t\t|");

        System.out.println("---------------------------------------------------"
                + "--------------------------------------------------------------");

        System.out.println("|24 " + COURSE[0] + " \t|25 " + COURSE[1]
                + "\t|26 " + COURSE[1] + "\t|27\t\t|28\t\t|29\t\t|30\t\t|");

        System.out.println("---------------------------------------------------"
                + "--------------------------------------------------------------");
        if (hasFound == 0) {
            System.out.println("Attendance of input date : '" + getInput + "' not found!");
        }

        System.out.println("Please enter which session in the format 'ddmmyy' that you wish to view");
        System.out.print("Enter '0' to go back : ");
        return Integer.parseInt(br.readLine());
    }
}
