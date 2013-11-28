package psd3;

public class Grade {
    private String studentName;
    private String course;
    private String courseID;
    private int coursework;
    private int exam;
    private int total;
    
    public Grade(String name, String n1, String n2, int n3, int n4) {
        studentName = name;
        course = n1;
        courseID = n2;
        coursework = n3;
        exam = n4;
        total = n3+n4;
    }
    
    public void setStudentName(String n1) {
        studentName = n1;
    }
    
    public void setCourse(String n1) {
        course = n1;
    }
    
    public void setCourseID(String n1) {
        courseID = n1;
    }
    
    public void setCoursework(int n1) {
        coursework = n1;
    }
    
    public void setExam(int n1) {
        exam = n1;
    }
    
    public void setTotal(int n1) {
        total = n1;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public String getCourse() {
        return course;
    }
    
    public String getCourseID() {
        return courseID;
    }
    
    public int getCoursework() {
        return coursework;
    }
    
    public int getExam() {
        return exam;
    }
    
    public int getTotal() {
        return total;
    }
}
