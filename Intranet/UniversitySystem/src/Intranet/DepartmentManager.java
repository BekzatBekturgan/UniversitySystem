package Intranet;

import java.util.Date;

public class DepartmentManager extends Employee{
	private Faculty faculty;
	public DepartmentManager(String name, String surname, Gender gender, String phoneNumber, String email,
			Date birthday, Faculty faculty) {
		super(name, surname, gender, phoneNumber, email, birthday);
		this.faculty = faculty;
	}
	
}
