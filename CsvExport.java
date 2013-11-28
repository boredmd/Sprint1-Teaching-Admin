package psd3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CsvExport {

    public CsvExport() {
    }

    public boolean ExportAllStudentGrade(String course, ArrayList<Result> r) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(course + " - Student Grade.csv");
        boolean written = false;
        try {
            for (int i = 0; i < r.size(); i++) {
                if (r.get(i).getCourse().matches(course)) {
                    writer.println(r.get(i).getFirstName() + ", "
                            + r.get(i).getSurname() + ", "
                            + r.get(i).getStudentID() + ", "
                            + r.get(i).getAssignmentLab1() + ", "
                            + r.get(i).getAssignmentLab2());
                }
            }
        } finally {
            writer.close();
            written = true;
            return written;
        }
    }

    public boolean ExportSingleStudentReport(String name, ArrayList<Grade> g) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(name + "'s Student Report.txt");
        boolean written = false;

        try {
            for (int i = 0; i < g.size(); i++) {
                if (g.get(i).getStudentName().matches(name)) {
                    String shortForm = "";
                    if (g.get(i).getCourse().matches("Programming Language 3"))
                        shortForm = "PL3";
                    else if(g.get(i).getCourse().matches("Professional Software Development 3"))
                        shortForm = "PSD3";
                    else if(g.get(i).getCourse().matches("Interactive System 3"))
                        shortForm = "IS3";
                    
                    writer.println(shortForm + ", "
                            + g.get(i).getCourseID() + ", "
                            + g.get(i).getCoursework() + ", "
                            + g.get(i).getExam() + ", "
                            + g.get(i).getTotal());
                }
            }
        } finally {
            writer.close();
            written = true;
            return written;
        }
    }
}
