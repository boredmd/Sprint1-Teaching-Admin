package psd3;

import java.util.ArrayList;

public class Attendance {
    /*
     * A attendance can be many.
     * Location: Lab/Tutorial Room
     * Date: 
     * Time: Actual booking timing
     * Course: 
     * ArrayList<Student> student
     * ArrayList<boolean> attended
     */
    
    private String location;
    //private Date dateTime;
    private int dateTime;
    private String course;
    private ArrayList<String> students;
    private ArrayList<Boolean> attended;
    
    public Attendance(String[] student, int date) {
        location = "";
        dateTime = date;
        course = "";
        students = new ArrayList<String>();
        attended = new ArrayList<Boolean>();
        for(int i = 0; i < student.length; i++){
            addStudents(student[i]);
        }
    }
    
    private void addStudents(String student){
        students.add(student);
        attended.add(false);
    }
    
    public void setLocation(String n) {
        location = n;
    }
    
    public void setDateTime(int n) {
        dateTime = n;
    }
//    public void setDateTime(Date n) {
//        dateTime = n;
//    }
    
    public void setCourse(String n) {
        course = n;
    }
    
    public void setAttending(int studentID) {
        if(attended.get(studentID) == false)
            attended.set(studentID, true);
        else
            attended.set(studentID, false);
    }
    
    public void setAttending(int studentID, boolean setAttend) {
            attended.set(studentID, setAttend);
    } 
    
    public String getLocation() {
        return location;
    }
    
    public int getDateTime() {
        return dateTime;
    }
//    public Date getDateTime() {
//        return dateTime;
//    }
    
    public String getCourse() {
        return course;
    }
    
    public ArrayList<String> getListOfStudent() {
        return students;
    }
    
    public String getStudent(int i) {
        return students.get(i);
    }
    
    public ArrayList<Boolean> getAttendingList() {
        return attended;
    }
    
    public boolean getAttending(int i) {
        return attended.get(i);
    }
}
