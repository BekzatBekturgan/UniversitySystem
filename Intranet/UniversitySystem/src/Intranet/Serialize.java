package Intranet;
import java.io.*;
import java.util.*;

public abstract class Serialize {
	public static byte[] serialize(Vector<?> v) throws Exception {
		byte[] stream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(v);
		oos.close();
		stream = baos.toByteArray();
		return stream;
	}
	public static Vector<?> deserialize(byte[] stream) {
		Vector<?> ans;
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(stream);
			ObjectInputStream ois = new ObjectInputStream(bais);
			Object o = (Object)ois.readObject();
		}
			catch(IOException e) {
				e.printStackTrace();
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		return ans;
	}
}
