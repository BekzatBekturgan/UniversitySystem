package Intranet;
import java.util.*;
public class Controller {
	private Mode mode;
	private Admin admin;
	//single Scanner
	private static final Scanner sc = new Scanner(System.in);
	
	//Start of the system
	public static void begin() {
		// process of choosing mode for system
		System.out.println("Choose one of two:" + '\n' + "1.Enter like USER" + '\n' + "2.Enter like ADMIN" + '\n' + "Please, write 1 or 2");
		
		int modeForSystem = sc.nextInt();
		
		// потом можно будет через try catch исправить
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
	private void enterLikeAdmin(String username, String password) throws Exception {
		admin = new Admin();
		int counterOfEnterAttempts = 0;
		while(!admin.checkUsernamePassword(username, password)) {
			System.out.println("Wrong username or password, please, try again");
			String usernameForMistake = sc.nextLine();
			String passwordForMistake = sc.nextLine();
			enterLikeAdmin(usernameForMistake, passwordForMistake);
		}
		if(admin.checkUsernamePassword(username, password)){
			System.out.println("1. Add user to the University System");
			System.out.println("2. Remove user from the University System");
			System.out.println("3. Change user's datas");
			System.out.println("4. See log file");
			System.out.println("Please, choose 1, 2, 3, 4");
			int selecter = sc.nextInt();
			switch(selecter) {
				case 1: admin.addUsers();
						break;
				case 2: admin.removeUsers();
						break;
				case 3: admin.setInfoAboutUsers();
						break;
				case 4: System.out.println(admin.seeLogFiles());
						break;
			}
		}
	}
	private void enterLikeUser(String username, String password) {
		
	}
}
