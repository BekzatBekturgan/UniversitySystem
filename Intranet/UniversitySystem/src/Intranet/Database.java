package Intranet;

import java.io.Serializable;
import java.util.*;

public class Database implements Serializable{
	public static  Vector<Student> vectorOfStudent = new Vector<>();
	public static Vector<Teacher> vectorOfTeacher = new Vector<>();
	public static Vector<DepartmentManager> vectorOfDepartmentManager = new Vector<>();
	public static Vector<ORManager> vectorOfOrManager = new Vector<>();
	public static Vector<Executor> vectorOfExecutor = new Vector<>();
	public static Vector<Course> vectorOfCourses = new Vector<>();

	
	private static final String STUDENTS = "students.txt";
	private static final String TEACHERS = "teachers.txt";
	private static final String DEPARTMENTMANAGERS = "departmentManagers.txt";
	private static final String ORMANAGERS = "ormanagers.txt";
	private static final String EXECUTORS = "executors.txt";
	private static final String COURSES = "courses.txt";
	
	// may change for to foreach
	public static boolean isUsernameExist(String username) {
		if(!vectorOfStudent.isEmpty()) {
			for(int i = 0; i < vectorOfStudent.size(); i++) {
				if(vectorOfStudent.get(i).getUsername().equals(username)) return false;
			}
		}
		if(!vectorOfTeacher.isEmpty()) {
			for(int i = 0; i < vectorOfTeacher.size(); i++) {
				if(vectorOfTeacher.get(i).getUsername().equals(username)) return false;
			}
		}
		if(!vectorOfDepartmentManager.isEmpty()) {
			for(int i = 0; i < vectorOfDepartmentManager.size(); i++) {
				if(vectorOfDepartmentManager.get(i).getUsername().equals(username)) return false;
			}
		}
		if(!vectorOfOrManager.isEmpty()) {
			for(int i = 0; i < vectorOfOrManager.size(); i++) {
				if(vectorOfOrManager.get(i).getUsername().equals(username)) return false;
			}
		}
		if(!vectorOfExecutor.isEmpty()) {
			for(int i = 0; i < vectorOfExecutor.size(); i++) {
				if(vectorOfExecutor.get(i).getUsername().equals(username)) return false;
			}
		}
		return true;
	}
	public static boolean isCourseExist(String courseName) {
		for(Course course: vectorOfCourses) {
			if(course.getName().equals(courseName)) return true;
		}
		return false;
	}
	public static void finish() throws Exception {
		//byte[] stream1 = Serialize.serialize(vectorOfStudent);
		FileOperation.Writer(vectorOfStudent, STUDENTS);
		//byte[] stream2 = Serialize.serialize(vectorOfTeacher);
		FileOperation.Writer(vectorOfTeacher, TEACHERS);
		//byte[] stream3 = Serialize.serialize(vectorOfOrManager);
		FileOperation.Writer(vectorOfOrManager, ORMANAGERS);
		//byte[] stream4 = Serialize.serialize(vectorOfDepartmentManager);
		FileOperation.Writer(vectorOfDepartmentManager, DEPARTMENTMANAGERS);
		//byte[] stream5 = Serialize.serialize(vectorOfExecutor);
		FileOperation.Writer(vectorOfExecutor, EXECUTORS);
		//byte[] stream6 = Serialize.serialize(vectorOfCourses);
		FileOperation.Writer(vectorOfCourses, COURSES);
	}
	public static void start() throws Throwable {
		/*
		vectorOfStudent = Serialize.deserialize(FileOperation.Reader(STUDENTS));
		vectorOfTeacher = Serialize.deserialize(FileOperation.Reader(TEACHERS));
		vectorOfOrManager =	Serialize.deserialize(FileOperation.Reader(ORMANAGERS));
		vectorOfDepartmentManager = Serialize.deserialize(FileOperation.Reader(DEPARTMENTMANAGERS));
		vectorOfExecutor = Serialize.deserialize(FileOperation.Reader(EXECUTORS));
		vectorOfCourses = Serialize.deserialize(FileOperation.Reader(COURSES));
		*/
		vectorOfStudent = (Vector<Student>)FileOperation.Reader(STUDENTS);
		vectorOfTeacher = (Vector<Teacher>)FileOperation.Reader(TEACHERS);
		vectorOfOrManager = (Vector<ORManager>)FileOperation.Reader(ORMANAGERS);
		vectorOfDepartmentManager = (Vector<DepartmentManager>)FileOperation.Reader(DEPARTMENTMANAGERS);
		vectorOfExecutor = (Vector<Executor>)FileOperation.Reader(EXECUTORS);
		vectorOfCourses = (Vector<Course>)FileOperation.Reader(COURSES);
	}
	
}

