package Intranet;
import java.util.*;
import java.io.*;

public class Admin {
	private String username;
	private String password;
	private Vector<User> vectorOfUsers = new Vector<User>(); // пробная версия потом поменяю
	private static final String adminPath = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\adminPath.txt"; // логин, пароль для аккаунта админ
	private static final String pathLogFiles = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\logFiles.txt"; // путь к log files
	
	// getter of vectorOfUsers
	public Vector<User> getVectorOfUsers(){
		return vectorOfUsers;
	}
	// main methods of admin
	// потом может придумаю как сообщить админу о том что такой user уже есть
	public void addUsers(User user) {
		boolean test = false;
		for(int i = 0; i < getVectorOfUsers().size(); i++) {
			if(getVectorOfUsers().get(i).equals(user)) {
				test = true;
				return;
			}
		}
		if(!test) {
			getVectorOfUsers().add(user);
		}
	}
	// думаю готово, но правильно ли vectorOfUsers делать приватным и обращаться к нему через getter
	public void removeUsers(String id) {
		for(int i = 0; i < getVectorOfUsers().size(); i++) {
			if(getVectorOfUsers().get(i).getID().equals(id)){
				getVectorOfUsers().remove(i);
				break;
			}
		}
	}
	// подумать надо какую информацию надо поменять
	// если все то надо каждому прописывать
	public void setInfoAboutUsers(User user) {
		for(int i = 0; i < getVectorOfUsers().size(); i++) {
			if(getVectorOfUsers().get(i).equals(user)) {
				//getVectorOfUsers().get(i).set
			}
		}
	}
	// ПРОСМОТР ЛОГ ФАЙЛОВ ВРОДЕ ГОТОВО, НО НАДО ПРОВЕРИТЬ ЧЕРЕЗ ТЕСТЫ
	public ArrayList<String> seeLogFiles() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pathLogFiles));
		ArrayList<String> logFiles = new ArrayList<String>();
		String readerLogFiles;
		while((readerLogFiles = br.readLine())!=null){
			logFiles.add(readerLogFiles);
		}
		br.close();
		return logFiles;
	}
	private String[] readFromAdminPath() throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(adminPath));
		String[] adminsData = new String[2]; // будет хранить пароль и логин который получить с файла
		String adderToStringArray;
		int i = 0; // индекс по массиву
		while((adderToStringArray = br.readLine())!=null) {
			adminsData[i] = adderToStringArray;
			i++;
		}
		br.close();
		return adminsData;
	}
	// check the username and password that given by console 
	public boolean checkUsernamePassword(String username, String password) throws Exception{
		String[] getAdminsData = readFromAdminPath();
		this.username = getAdminsData[0];
		this.password = getAdminsData[1];
		
		if(this.username.equals(getHash(username)) && this.password.equals(getHash(password))) return true;
		return false;
		
		
	}
	// надо потом реализацию придумать 
	private String getHash(String hashing) {
		String result = this.username;
		return result;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
}	
