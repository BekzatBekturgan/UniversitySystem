package Intranet;

import java.sql.Date;
import java.util.Calendar;

public class Orders {
	private String problemDescription;
	private Date sendedDate;
	
	public Orders(String problemDescription) {
		super();
		this.problemDescription = problemDescription;
		this.sendedDate = (Date) Calendar.getInstance().getTime();
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public Date getSendedDate() {
		return sendedDate;
	}

	public void setSendedDate(Date sendedDate) {
		this.sendedDate = sendedDate;
	}
	
}
