package psd3;

import java.io.*;
import java.util.*;

public class Psd3 {

    private static ArrayList<Result> result = new ArrayList<Result>();
    private static ArrayList<Grade> grade = new ArrayList<Grade>();
    private static ArrayList<Attendance> attendance = new ArrayList<Attendance>();
    private static final String[] COURSE = {"Programming Language 3",
        "Professional Software Development 3", "Interactive System 3"};
    private static final String[] STUDENT = {"May Chan", "Hosehbo Lim",
        "Porkchai Tan", "Jason Peh"};    
    
    public static void main(String[] args) throws IOException {
        /*Init all data*/
        initResult();
        initGrades();
        initAttendance();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int getInput = 0;
        do {
            getInput = printMenu(br);
            switch (getInput) {
                case 1: /*---------------------Admin--------------------------*/
                    System.out.println("\n\nLogin as Admin success\n");
                    do {
                        Admin admin = new Admin();
                        getInput = admin.printMenuAdmin(br); //Print Admin Menu
                        boolean successful;

                        if (getInput == 1) {
                            getInput = admin.printMenuByModule(br, COURSE); //Export all student grades
                            do {
                                if (getInput != 4) {
                                    CsvExport export = new CsvExport();
                                    String module = null;

                                    if (getInput == 1) { //Course Name 1
                                        module = COURSE[0]; //"Programming Language 3"
                                    } else if (getInput == 2) { //Course Name 2
                                        module = COURSE[1]; //"Professional Software Development 3"
                                    } else if (getInput == 3) {
                                        module = COURSE[2]; //"Interactive System 3"
                                    }

                                    successful = export.ExportAllStudentGrade(module, result);
                                    if (successful) {
                                        System.out.println("\n\nExported all student grades");
                                    } else {
                                        System.out.println("\n\nUnable to export all student grades");
                                    }
                                    getInput = 4;
                                }
                            } while (getInput != 4);
                        } else if (getInput == 2) {
                            getInput = admin.printMenuByStudent(br, STUDENT); //Export all grades for a single student
                            do {
                                if (getInput != (STUDENT.length + 1)) {
                                    CsvExport export = new CsvExport();
                                    String studentName = null;

                                    if (getInput == 1) { //Course Name 1
                                        studentName = STUDENT[(getInput - 1)]; //First Student
                                    } else if (getInput == 2) { //Course Name 2
                                        studentName = STUDENT[(getInput - 1)]; //Second Student
                                    } else if (getInput == 3) {
                                        studentName = STUDENT[(getInput - 1)]; //Third Student
                                    } else if (getInput == 4) {
                                        studentName = STUDENT[(getInput - 1)]; //Third Student
                                    }

                                    successful = export.ExportSingleStudentReport(studentName, grade);
                                    if (successful) {
                                        System.out.println("\n\nExported " + STUDENT[(getInput - 1)] + "'s grades");
                                    } else {
                                        System.out.println("\n\nUnable to export " + STUDENT[(getInput - 1)] + "'s grades");
                                    }
                                    getInput = (STUDENT.length + 1);
                                }
                            } while (getInput != (STUDENT.length + 1));
                            System.out.println("\n\nExported student result slip");
                        }
                    } while (getInput != 0);
                    break;
                case 2: /*-----------------Course Lecturers-------------------*/
                    System.out.println("\n\nLogin as Course Lecturer : <NAME HERE>\n");
                    do {
                        CourseLecturer lecturer = new CourseLecturer();
                        CommonMenu commonMenu = new CommonMenu();
                        
                        getInput = lecturer.printCourseLecturer(br);
                        
                        int hasFound = -1;

                        if (getInput == 1) { // View Session
                            do {
                                getInput = commonMenu.printCalendar(br, hasFound, getInput); // Print Calendar Menu
                                if (getInput != 0) {
                                    if (!attendance.isEmpty()) { // Check if there are any attendance records   
                                        for (int i = 0; i < attendance.size(); i++) {
                                            if (attendance.get(i).getDateTime() == getInput) {
                                                do {
                                                    getInput = commonMenu.printMenuViewAttendance(br, attendance.get(i)); // View Attendance
                                                    if (getInput != 0) {
                                                        attendance.get(i).setAttending((getInput - 1));
                                                        hasFound = 1;
                                                    }
                                                } while (getInput != 0);
                                                if (hasFound == 1) {
                                                    break;
                                                }
                                            } else {
                                                hasFound = 0;
                                            }
                                        }
                                    }
                                }
                            } while (getInput != 0 && hasFound != 1);
                        }
                    } while(getInput != 0);
                    break;
                case 3: /*---------------------Tutors-------------------------*/
                    System.out.println("\n\nLogin as Tutor success\n");
                    do {
                        Tutor tutor = new Tutor();
                        CommonMenu commonMenu = new CommonMenu();
                        
                        getInput = tutor.printMenuTutor(br); // Display Tutor Menu
                        int hasFound = -1;

                        if (getInput == 1) { // View Session
                            do {
                                getInput = commonMenu.printCalendar(br, hasFound, getInput); // Print Calendar Menu
                                if (getInput != 0) {
                                    if (!attendance.isEmpty()) { // Check if there are any attendance records   
                                        for (int i = 0; i < attendance.size(); i++) {
                                            if (attendance.get(i).getDateTime() == getInput) {
                                                do {
                                                    getInput = commonMenu.printMenuViewAttendance(br, attendance.get(i)); // View Attendance
                                                    if (getInput != 0) {
                                                        attendance.get(i).setAttending((getInput - 1));
                                                        hasFound = 1;
                                                    }
                                                } while (getInput != 0);
                                                if (hasFound == 1) {
                                                    break;
                                                }
                                            } else {
                                                hasFound = 0;
                                            }
                                        }
                                    }
                                }
                            } while (getInput != 0 && hasFound != 1);
                        } else if (getInput == 2) { // Import student attendance
                            boolean goBack = false;
                            do {
                                System.out.println("\n\n\n\nPlease enter the location of the csv file");
                                System.out.println("Format C:\\temp\\abc.csv");
                                System.out.println("0. Back");
                                System.out.print("Path : ");
                                String getPath = br.readLine(); //"C:\\Users\\kIaN hOcK\\Documents\\NetBeansProjects\\psd3\\111113.csv";//
                                FileReader reader = null;
                                String csvSplitBy = ",";

                                try {
                                    if (!getPath.matches("0")) { // If user did not enter zero (Go back)
                                        reader = new FileReader(getPath);
                                        Scanner line = new Scanner(reader);
                                        ArrayList<Boolean> tempAttendance = new ArrayList<Boolean>();
                                        int getDate = 0;
                                        
                                        for (int i = 0; line.hasNextLine(); i++) {
                                            String readline = line.nextLine();
                                            String[] words = readline.split(csvSplitBy);
                                            String course, dateOfAttendance;
                                            
                                            if(words.length > 1)
                                                words[1] = words[1].trim();
                                            // Print first to allow user to check if the data is correct
                                            if (i == 0){
                                                System.out.println("\n\nCourse: " + words[0]);
                                                System.out.println("Attendance Date: " + words[1]);
                                                getDate = Integer.parseInt(words[1]);
                                            }
                                            else if (!words[0].isEmpty()) {
                                                System.out.println((i + 1) + "Student Name : " + words[0] + ", " + words[1]);
                                                if(words[1].trim().matches("attend"))
                                                    tempAttendance.add(true);
                                                else
                                                    tempAttendance.add(false);
                                            }
                                        }
                                        System.out.print("\nIs the above data correct? (Y/N) : ");
                                        String getYesNo = br.readLine().toLowerCase();
                                        if(getYesNo.matches("yes") || getYesNo.matches("y")) {
                                            // Add into database System.out.println("Data Correct!");
                                            for (int i = 0; i < attendance.size(); i++) {
                                                if (attendance.get(i).getDateTime() == getDate) {
                                                    for (int n = 0; n < tempAttendance.size(); n++) {
                                                        attendance.get(i).setAttending(n, tempAttendance.get(n));
                                                    }
                                                    break; // Break from the loop when the correct attendance is found
                                                }
                                            }
                                        }
                                        else {
                                            System.out.println("Please make sure your data is correct!");
                                        }
                                        goBack = true;
                                    }
                                    else
                                        goBack = true;
                                } finally {
                                    if (reader != null) {
                                        reader.close();
                                    }
                                }

                            } while (goBack != true);
                        }
                    } while (getInput != 0);
                    break;
            }
        } while (getInput != 4);
    }

    private static int printMenu(BufferedReader br) throws IOException {
        System.out.println("\n\n\n\n\n\n");
        System.out.println("Login as :");
        System.out.println("1. Teaching Administrator/Secretary");
        System.out.println("2. Course Lecturers");
        System.out.println("3. Tutors");
        System.out.println("4. Exit");
        System.out.print("Please enter a choice : ");
        return Integer.parseInt(br.readLine());
    }

    private static void initResult() {
        /*PL3*/
        Result r1 = new Result("May", "Chan", 9801001, 'A', 'E', COURSE[0]);
        Result r2 = new Result("Hosehbo", "Lim", 9801002, 'A', 'C', COURSE[0]);
        Result r3 = new Result("Porkchai", "Tan", 9801003, 'A', 'D', COURSE[0]);
        Result r4 = new Result("Jason", "1", 9801004, 'A', 'B', COURSE[0]);
        /*PSD3*/
        Result r5 = new Result("May", "Chan", 9801001, 'A', 'E', COURSE[1]);
        Result r6 = new Result("Hosehbo", "Lim", 9801002, 'A', 'C', COURSE[1]);
        Result r7 = new Result("Porkchai", "Tan", 9801003, 'A', 'D', COURSE[1]);
        Result r8 = new Result("Jason", "Peh", 9801004, 'A', 'B', COURSE[1]);

        /*IS3*/
        Result r9 = new Result("May", "Chan", 9801001, 'A', 'E', COURSE[2]);
        Result r10 = new Result("Hosehbo", "Lim", 9801002, 'A', 'C', COURSE[2]);
        Result r11 = new Result("Porkchai", "Tan", 9801003, 'A', 'D', COURSE[2]);
        Result r12 = new Result("Jason", "Peh", 9801004, 'A', 'B', COURSE[2]);

        result.add(r1);
        result.add(r2);
        result.add(r3);
        result.add(r4);
        result.add(r5);
        result.add(r6);
        result.add(r7);
        result.add(r8);
        result.add(r9);
        result.add(r10);
        result.add(r11);
        result.add(r12);
    }

    private static void initGrades() {
        Grade r1 = new Grade(STUDENT[0], COURSE[0], "COMPSCI2001", 15, 70);
        Grade r2 = new Grade(STUDENT[0], COURSE[1], "COMPSCI2007", 25, 70);
        Grade r3 = new Grade(STUDENT[0], COURSE[2], "COMPSCI2008", 20, 70);

        Grade r4 = new Grade(STUDENT[1], COURSE[0], "COMPSCI2001", 16, 70);
        Grade r5 = new Grade(STUDENT[1], COURSE[1], "COMPSCI2007", 27, 70);
        Grade r6 = new Grade(STUDENT[1], COURSE[2], "COMPSCI2008", 25, 70);

        Grade r7 = new Grade(STUDENT[2], COURSE[0], "COMPSCI2001", 12, 70);
        Grade r8 = new Grade(STUDENT[2], COURSE[1], "COMPSCI2007", 24, 70);
        Grade r9 = new Grade(STUDENT[2], COURSE[2], "COMPSCI2008", 26, 70);

        Grade r10 = new Grade(STUDENT[3], COURSE[0], "COMPSCI2001", 30, 70);
        Grade r11 = new Grade(STUDENT[3], COURSE[1], "COMPSCI2007", 29, 70);
        Grade r12 = new Grade(STUDENT[3], COURSE[2], "COMPSCI2008", 28, 70);

        grade.add(r1);
        grade.add(r2);
        grade.add(r3);
        grade.add(r4);
        grade.add(r5);
        grade.add(r6);
        grade.add(r7);
        grade.add(r8);
        grade.add(r9);
        grade.add(r10);
        grade.add(r11);
        grade.add(r12);
    }

    private static void initAttendance() {
        Attendance nov03 = new Attendance(STUDENT, 031113); // New attendance list for PL3
        Attendance nov04 = new Attendance(STUDENT, 041113); // New attendance list for PSD3
        Attendance nov05 = new Attendance(STUDENT, 051113); // New attendance list for IS3

        Attendance nov10 = new Attendance(STUDENT, 101113); // New attendance list for PL3
        Attendance nov11 = new Attendance(STUDENT, 111113); // New attendance list for PSD3
        Attendance nov12 = new Attendance(STUDENT, 121113); // New attendance list for IS3

        Attendance nov17 = new Attendance(STUDENT, 171113); // New attendance list for PL3
        Attendance nov18 = new Attendance(STUDENT, 181113); // New attendance list for PSD3
        Attendance nov19 = new Attendance(STUDENT, 191113); // New attendance list for IS3

        Attendance nov24 = new Attendance(STUDENT, 241113); // New attendance list for PL3
        Attendance nov25 = new Attendance(STUDENT, 251113); // New attendance list for PSD3
        Attendance nov26 = new Attendance(STUDENT, 261113); // New attendance list for IS3

        attendance.add(nov03);
        attendance.add(nov04);
        attendance.add(nov04);

        attendance.add(nov10);
        attendance.add(nov11);
        attendance.add(nov12);

        attendance.add(nov17);
        attendance.add(nov18);
        attendance.add(nov19);

        attendance.add(nov24);
        attendance.add(nov25);
        attendance.add(nov26);
    }

    private static int printMenuLecturer(BufferedReader br) throws IOException {

        System.out.println("\n\n1. Export all student grades for all completed assignments");
        System.out.println("2. Export all grades for a single student");
        System.out.println("3. Sign out");
        System.out.print("Please enter a choice : ");

        return Integer.parseInt(br.readLine());
    }

    private static int printMenuTutor(BufferedReader br) throws IOException {

        System.out.println("1. View Session");
        System.out.println("2. Export all grades for a single student");
        System.out.println("3. Sign out");
        System.out.print("Please enter a choice : ");

        return Integer.parseInt(br.readLine());
    }
}
