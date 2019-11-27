package Intranet;
import java.util.*;
import java.io.*;

public class Admin {
	private String username;
	private String password;
	private static final String adminPath = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\adminPath.txt"; // логин, пароль для аккаунта админ
	private static final String pathLogFiles = "C:\\Users\\Bekzat Bekturgan\\Desktop\\Intranet\\UniversitySystem\\logFiles.txt"; // путь к log files
	public void addUsers() {
		
	}
	public void removeUsers() {
		
	}
	public void setInfoAboutUsers() {
		
	}
	public String seeLogFiles() {
		return 
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
		return adminsData;
	}
	// check the username and password that given by console 
	public boolean checkUsernamePassword(String username, String password) throws Exception{
		String[] getAdminsData = readFromAdminPath();
		this.username = getAdminsData[0];
		this.password = getAdminsData[1];
		
		if(this.username.equals(getHash(username)) && this.password.equals(getHash(username))) return true;
		return false;
		
		
	}
	// надо потом реализацию придумать 
	private String getHash(String hashing) {
		String result;
		/*
		 какой то алгоритм для пароля и логина чтобы зашифровать
		 */
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
