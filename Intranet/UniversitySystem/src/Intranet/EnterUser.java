package Intranet;
import java.util.*;

public abstract class EnterUser {
	private static final Scanner sc = new Scanner(System.in);
	public static void sessionStudent(User user) {
		Student student = (Student)user;
		System.out.println("You are logged as student!");
		int selecter = 0;
		while(selecter!=7) {
			System.out.println("1. Change password");
			System.out.println("2. View transcript");
			System.out.println("3. View journal");
			System.out.println("4. View information about teacher for specific course");
			System.out.println("5. View course files");
			System.out.println("6. Regisration for courses");
			System.out.println("7. Exit");
			switch(selecter) {
			case 1: System.out.println("Enter new password:");
					student.setPassword(sc.next());
					break;
			case 2: System.out.println(student.showTranscript());
					break;
			case 3: System.out.println(student.showMarksOfCurrentCourses());
					break;
			case 4: System.out.println("Enter name of the course");
					System.out.println(student.viewInfoAboutTeacher(sc.next()));
					break;
			case 5: System.out.println("Enter name of the course");
					System.out.println(student.viewCourseFiles(sc.next()));
					break;
			case 6: student.registerForCourse();
					break;
			}
		}
	}
	public static void sessionTeacher(User user) {
		Teacher teacher = (Teacher)user;
	}
	public static void sessionOrManager(User user) {
		ORManager orManager = (ORManager)user;
	}
	public static void sessionDepartmentManager(User user) {
		DepartmentManager departmentManager = (DepartmentManager)user;
	}
	public static void sessionExecutor(User user) {
		Executor executor = (Executor)user;
	}
}
