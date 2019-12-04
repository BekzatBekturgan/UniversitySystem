package Intranet;

import java.io.Serializable;
import java.util.*;

public class Database implements Serializable{
	public static Vector<Student> vectorOfStudent = new Vector<Student>();
	public static Vector<Teacher> vectorOfTeacher = new Vector<Teacher>();
	public static Vector<DepartmentManager> vectorOfDepartmentManager = new Vector<DepartmentManager>();
	public static Vector<ORManager> vectorOfOrManager = new Vector<ORManager>();
	public static Vector<Executor> vectorOfExecutor = new Vector<Executor>();
	public static Vector<Course> vectorOfCourses = new Vector<Course>();
	
	private static final String STUDENTS = "students.txt";
	private static final String TEACHERS = "teachers.txt";
	private static final String DEPARTMENTMANAGERS = "departmentManagers.txt";
	private static final String ORMANAGERS = "ormanagers.txt";
	private static final String EXECUTORS = "executors.txt";
	private static final String COURSES = "courses.txt";
	
	// may change for to foreach
	public static boolean isUsernameExist(String username) {
		for(int i = 0; i < vectorOfStudent.size(); i++) {
			if(vectorOfStudent.get(i).getUsername().equals(username)) return false;
		}
		for(int i = 0; i < vectorOfTeacher.size(); i++) {
			if(vectorOfTeacher.get(i).getUsername().equals(username)) return false;
		}
		for(int i = 0; i < vectorOfDepartmentManager.size(); i++) {
			if(vectorOfDepartmentManager.get(i).getUsername().equals(username)) return false;
		}
		for(int i = 0; i < vectorOfOrManager.size(); i++) {
			if(vectorOfOrManager.get(i).getUsername().equals(username)) return false;
		}
		for(int i = 0; i < vectorOfExecutor.size(); i++) {
			if(vectorOfExecutor.get(i).getUsername().equals(username)) return false;
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
		vectorOfStudent = (Vector<Student>) Serialize.deserialize(FileOperation.Reader(STUDENTS));
		vectorOfTeacher = (Vector<Teacher>) Serialize.deserialize(FileOperation.Reader(TEACHERS));
		vectorOfOrManager = (Vector<ORManager>) Serialize.deserialize(FileOperation.Reader(ORMANAGERS));
		vectorOfDepartmentManager = (Vector<DepartmentManager>) Serialize.deserialize(FileOperation.Reader(DEPARTMENTMANAGERS));
		vectorOfExecutor = (Vector<Executor>) Serialize.deserialize(FileOperation.Reader(EXECUTORS));
		vectorOfCourses = (Vector<Course>) Serialize.deserialize(FileOperation.Reader(COURSES));
		*/
		vectorOfStudent = (Vector<Student>)FileOperation.Reader(STUDENTS);
		vectorOfTeacher = (Vector<Teacher>)FileOperation.Reader(TEACHERS);
		vectorOfOrManager = (Vector<ORManager>)FileOperation.Reader(ORMANAGERS);
		vectorOfDepartmentManager = (Vector<DepartmentManager>)FileOperation.Reader(DEPARTMENTMANAGERS);
		vectorOfExecutor = (Vector<Executor>)FileOperation.Reader(EXECUTORS);
		vectorOfCourses = (Vector<Course>)FileOperation.Reader(COURSES);
	}
	
}

