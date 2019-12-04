package Intranet;
import java.util.*;
public class Controller {
	private Mode mode;
	private static Admin admin;
	private static User user;
	private Teacher teacher;
	private Student student;
	/*private DepartmentManager departmentManager;
	private ORManager orManager;
	private Executor executor;*/
	//single Scanner
	private static final Scanner sc = new Scanner(System.in);
	
	//Start of the system
	public void begin() throws Throwable {
		Database.start();
		// process of choosing mode for system
		System.out.println("Choose one of two:" + '\n' + "1.Enter like USER" + '\n' + "2.Enter like ADMIN" + '\n' + "Please, write 1 or 2");
		
		int modeForSystem = sc.nextInt();
		if(modeForSystem==1 || modeForSystem==2) {
			System.out.println("Enter your username and password (2 lines)");
			String username = sc.nextLine();
			String password = sc.nextLine();
			switch(modeForSystem) {
			case 1:
				enterLikeUser(username, password);
				break;
			case 2:
				enterLikeAdmin(username, password);
				break;
			}
		}	
	}
	
	private static void enterLikeAdmin(String username, String password) throws Exception {
		admin = new Admin();
		while(!admin.checkUsernamePassword(username, password)) {
			System.out.println("Wrong username or password, please, try again");
			String usernameForMistake = sc.nextLine();
			String passwordForMistake = sc.nextLine();
		}
		if(admin.checkUsernamePassword(username, password)){
			int selecter;
			while(selecter!=5) { 
				System.out.println("1. Add user to the University System");
				System.out.println("2. Remove user from the University System");
				System.out.println("3. Change user's datas");
				System.out.println("4. See log file");
				System.out.println("5. Exit");
				System.out.println("Please, choose 1, 2, 3, 4, 5");
				selecter = sc.nextInt();
				switch(selecter) {		
					case 1:	int selecterMode;
							while(selecterMode!=6) {
								System.out.println("Choose one of the five");
								System.out.println("1. Add student");
								System.out.println("2. Add teacher");
								System.out.println("3. Add department manager");
								System.out.println("4. Add OR manager");
								System.out.println("5. Add executor");
								System.out.println("6. Exit");
								selecterMode = sc.nextInt();
								switch(selecterMode) {
									case 1: 
											break;
									case 2: teacher = new Teacher();
											admin.addUsers(user);
											break;
									case 3: user = new DepartmentManager();
											admin.addUsers(user);
											break;
									case 4: user = new ORManager();
											admin.addUsers(user);
											break;
									case 5: user = new Executor();
											admin.addUsers(user);
											break;
								}
							}
							break;
							// ошибка пошла, пока остановился
					case 2: int selecterModeForRemoveUsers;
							while(selecterModeForRemoveUsers!=6) {
								System.out.println("Choose one of the five");
								System.out.println("1. Remove student");
								System.out.println("2. Remove teacher");
								System.out.println("3. Remove department manager");
								System.out.println("4. Remove OR manager");
								System.out.println("5. Remove executor");
								System.out.println("6. Exit");
								selecterMode = sc.nextInt();
							}
							break;
					case 3: for(int i = 0; i < admin.seeLogFiles().size(); i++) {
								System.out.println(admin.seeLogFiles().get(i));
							}
							break;
					case 4: System.out.println(admin.seeLogFiles());
							break;
					case 5: System.exit(0);
				}
			}
			
		}
	}
	private static void enterLikeUser(String username, String password) {
		
	}
	
}
