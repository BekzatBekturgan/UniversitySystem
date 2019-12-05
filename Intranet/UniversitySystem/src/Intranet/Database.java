package Intranet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Database implements Serializable{
	public static  Vector<Student> vectorOfStudent = new Vector<>();
	public static Vector<Teacher> vectorOfTeacher = new Vector<>();
	public static Vector<DepartmentManager> vectorOfDepartmentManager = new Vector<>();
	public static Vector<ORManager> vectorOfOrManager = new Vector<>();
	public static Vector<Executor> vectorOfExecutor = new Vector<>();
	public static Vector<Course> vectorOfCourses = new Vector<>();

	
	private static final String STUDENTS = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\students.txt";
	private static final String TEACHERS = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\teachers.txt";
	private static final String DEPARTMENTMANAGERS = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\departmentManagers.txt";
	private static final String ORMANAGERS = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\ormanagers.txt";
	private static final String EXECUTORS = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\executors.txt";
	private static final String COURSES = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\courses.txt";
	
	// may change for to foreach
	public static boolean isUsernameExist(String username) throws NullPointerException {
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
	
//  DESERIALIZAION
    public static void saveData() {
        saveManagers();
        saveOrManagers();
        saveTeachers();
        saveStudents();
        saveExecutors();
    }

    private static void saveStudents() {
        try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(STUDENTS));
            
            oot.writeObject(vectorOfStudent);
            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(STUDENTS + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(STUDENTS + ": " + "File io");
        }
    }

    private static void saveTeachers() {
        try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(TEACHERS));

            oot.writeObject(vectorOfTeacher);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(TEACHERS + ": " + "Except file");
        }
        catch (IOException e) {
            System.out.println(TEACHERS + ": " + "Except io");
        }
    }

    private static void saveManagers() {
        try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(DEPARTMENTMANAGERS));

            oot.writeObject(vectorOfDepartmentManager);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(DEPARTMENTMANAGERS + ": " + "Except file");
        }
        catch (IOException e) {
            System.out.println(DEPARTMENTMANAGERS + ": " + "File io");
        }
    }

    private static void saveOrManagers() {
        try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(ORMANAGERS));
            
            oot.writeObject(vectorOfOrManager);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(ORMANAGERS + ": " + "Except File");
        }
        catch (IOException e) {
            System.out.println(ORMANAGERS + ": " + "File io");
        }
    }

    private static void saveExecutors() {
        try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(EXECUTORS));

            oot.writeObject(vectorOfExecutor);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(EXECUTORS + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(EXECUTORS + ": " + "File io");
        }
    }
//  SERIALIZATION
    public static void loadData() {
        loadStudents();
        loadTeachers();
        loadExecutors();
        loadManagers();
        loadOrManagers();
    }

    private static void loadStudents() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(STUDENTS));

            vectorOfStudent = (Vector<Student>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(STUDENTS + ": " + "Class except");
        }
        catch (FileNotFoundException e) {
            System.out.println(STUDENTS + ": " + "File except");
        }
        catch (IOException e) {
            System.out.println(STUDENTS + ": " + "File io");
        }
    }

    private static void loadTeachers() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TEACHERS));

            vectorOfTeacher = (Vector<Teacher>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(TEACHERS + ": " + "Class except");
        }
        catch (FileNotFoundException e) {
            System.out.println(TEACHERS + ": " + "File Except");
        }
        catch (IOException e) {
            System.out.println(TEACHERS + ": " + "File io");
        }
    }

    private static void loadManagers() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DEPARTMENTMANAGERS));

            vectorOfDepartmentManager = (Vector<DepartmentManager>) ois.readObject();

            ois.close();
        }
        catch (ClassNotFoundException e) {
            System.out.println(DEPARTMENTMANAGERS + ": " + "class except");
        }
        catch (FileNotFoundException e) {
            System.out.println(DEPARTMENTMANAGERS + ": " + "file except");
        }
        catch (IOException e) {
            System.out.println(DEPARTMENTMANAGERS + ": " + "file io");
        }
    }

    private static void loadOrManagers() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ORMANAGERS));

            vectorOfOrManager = (Vector<ORManager>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(ORMANAGERS + ": " + "class except");
        }
        catch (FileNotFoundException e) {
            System.out.println(ORMANAGERS + ": " + "file except");
        }
        catch (IOException e) {
            System.out.println(ORMANAGERS + ": " + "file io");
        }
    }

    private static void loadExecutors() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(EXECUTORS));

            vectorOfExecutor = (Vector<Executor>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(EXECUTORS + ": " + "class except");
        }
        catch (FileNotFoundException e) {
            System.out.println(EXECUTORS + ": " + "file except");
        }
        catch (IOException e) {
            System.out.println(EXECUTORS + ": " + "file io");
        }
    }
    

    /*
	public static void start() throws Throwable, NullPointerException {
		
		vectorOfStudent = Serialize.deserialize(FileOperation.Reader(STUDENTS));
		vectorOfTeacher = Serialize.deserialize(FileOperation.Reader(TEACHERS));
		vectorOfOrManager =	Serialize.deserialize(FileOperation.Reader(ORMANAGERS));
		vectorOfDepartmentManager = Serialize.deserialize(FileOperation.Reader(DEPARTMENTMANAGERS));
		vectorOfExecutor = Serialize.deserialize(FileOperation.Reader(EXECUTORS));
		vectorOfCourses = Serialize.deserialize(FileOperation.Reader(COURSES));
		*/
    /*
		vectorOfStudent = (Vector<Student>)FileOperation.studentReader(STUDENTS);
		vectorOfTeacher = (Vector<Teacher>)FileOperation.teacherReader(TEACHERS);
		vectorOfOrManager = (Vector<ORManager>)FileOperation.orManagerReader(ORMANAGERS);
		vectorOfDepartmentManager = (Vector<DepartmentManager>)FileOperation.departmentManagerReader(DEPARTMENTMANAGERS);
		vectorOfExecutor = (Vector<Executor>)FileOperation.executorReader(EXECUTORS);
		vectorOfCourses = (Vector<Course>)FileOperation.courseReader(COURSES);
	}*/
	
}


