package Intranet;
import java.util.*;
public class Teacher extends Employee{
	
	private ArrayList<Course> teacherCourses = new ArrayList<Course>();
	
	public Teacher(String username, String password, String name, String surname, Gender gender, String phoneNumber,
			String email, String iD, Date birthday) {
		super(username, password, name, surname, gender, phoneNumber, email, iD, birthday);
	}
	
	
	public ArrayList<Course> getTeacherCourses() {
		return teacherCourses;
	}


	public void setTeacherCourses(ArrayList<Course> teacherCourses) {
		this.teacherCourses = teacherCourses;
	}

	public String toString() {
		return getName() + " " + getSurname() + " " + getEmail();
	}
	public boolean addCourse(Course addedCourse) {
		if(!Database.isCourseExist(addedCourse.getName())) {
			Database.vectorOfCourses.add(addedCourse);
			teacherCourses.add(addedCourse);
			return true;
		}
		return false;
	}
	
	// show all courses that have in university system DONE*****
	public Vector<Course> viewCourses(){
		return Database.vectorOfCourses;
	}
	// show only teacher studied courses
	public ArrayList<Course> viewOwnCourses(){
		return teacherCourses;
	}
	// show list of students in one course
	public ArrayList<Student> showStudents(Course course){
		ArrayList<Student> listOfStudents = null;
		for(Course c : teacherCourses) {
			if(c.equals(course)) {
				listOfStudents = c.getListStudents();
			}
		}
		return listOfStudents;
	}
	// DONE WITHOUT EXCEPTIONS******************
	public boolean putMarks(Course course, Student student, String attestation, double grade) {
		for(Course c: teacherCourses) {
			if(c.equals(course)) {
				for(Student s : c.getListStudents()) {
					if(s.equals(student)) {
						if(attestation.equals("first")) {
							s.getTranscript().getJournal().get(c).setFirstAttestation(grade);
							return true;
						}	
						else if(attestation.equals("second")) {
							s.getTranscript().getJournal().get(c).setSecondAttestation(grade);
							return true;
						}
						else if(attestation.equals("final")) {
							s.getTranscript().getJournal().get(c).setFinalScore(grade);
							return true;
						}	
					}	
				}
			}
		}
		return false;
	}	
}
