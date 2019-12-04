package Intranet;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;


public abstract class FileOperation {
	
	public static ArrayList<String> BufferedReader(String adminPath) {
		ArrayList<String> logFiles = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(adminPath));
			String readerLogFiles;
			while((readerLogFiles = br.readLine())!=null){
				logFiles.add(readerLogFiles);
			}
			br.close();
		}
		catch(Exception e) {
			
		}
		return logFiles;
	}
	public static boolean Writer(Vector v, String path) {
		try {
			FileOutputStream file = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(v);
			out.close();
			file.close();
			return true;
		}
		catch(IOException ex) {
			return false;
		}
	}
	public static Vector<?> Reader(String path) throws ClassNotFoundException {
		Vector<?> ans = null;
		try {
			FileInputStream file = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(file);
			ans = (Vector<?>) in.readObject();
			in.close();
			file.close();
		}
		catch(IOException ex) {
			
		}
		return ans;
	}
}
