package Intranet;

import java.util.Date;

public abstract class Employee extends User{

	public Employee(String name, String surname, Gender gender, String phoneNumber, String email, Date birthday) {
		super(name, surname, gender, phoneNumber, email, birthday);
	}
	
}
