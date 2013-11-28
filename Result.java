package psd3;

public class Result {
    private String firstname;
    private String surname;
    private int studentID;
    private char assignmentLab1;
    private char assignmentLab2;
    private String course;
    
    public Result(String n1, String n2, int n3, char n4, char n5, String n6) {
        firstname = n1;
        surname = n2;
        studentID = n3;
        assignmentLab1 = n4;
        assignmentLab2 = n5;
        course = n6;
    }
    
    public void setFirstName(String n) {
        firstname = n;
    }
    
    public void setSurname(String n) {
        surname = n;
    }
    
    public void setStudentID(int n) {
        studentID = n;
    }
    
    public void setAssignmentLab1(char n) {
        assignmentLab1 = n;
    }
    
    public void setAssignmentLab2(char n) {
        assignmentLab2 = n;
    }
    
    public void setAssignmentLab2(String n) {
        course = n;
    }
    
    public String getFirstName() {
        return firstname;
    }
    
    public String getSurname() {
       return surname;
    }
    
    public int getStudentID() {
        return studentID;
    }
    
    public char getAssignmentLab1() {
        return assignmentLab1;
    }
    
    public char getAssignmentLab2() {
        return assignmentLab2;
    }
    
    public String getCourse() {
        return course;
    }
}
