package Intranet;

import java.util.ArrayList;
import java.util.Date;

public class Executor extends Employee{
	private int rate;
	private ArrayList<Orders> newOrders = new ArrayList<Orders>();
	private ArrayList<Orders> acceptedOrders;
	private ArrayList<Orders> rejectedOrders;
	private ArrayList<Orders> doneOrders;
	public Executor(String username, String password, String name, String surname, Gender gender, String phoneNumber,
			String email, String iD, Date birthday) {
		super(username, password, name, surname, gender, phoneNumber, email, iD, birthday);
		this.rate = 0;
	}
	
	// get new orders from the employee
	public boolean getNewOrders() {
		if(!super.getOrders().isEmpty()) return false;
		else {
			newOrders = super.getOrders();
			return true;
		}
	}
	// view new orders and accept/reject 
	// TO DO
	public String viewNewOrder() {
		String order = newOrders.get(i);
		return order;
	}
	
	// view of accepted orders
	public String viewAcceptedOrders() {
		String view = null;
		for(Orders order : acceptedOrders) {
			view+=order.getProblemDescription() + " " + order.getSendedDate() + '\n';
		}
		return view;
	}
	// view of rejected orders
	public String viewRejectedOrder() {
		String view = null;
		for(Orders order : rejectedOrders) {
			view+=order.getProblemDescription() + " " + order.getSendedDate() + '\n';
		}
		return view;
	}
	// do orders 
	public boolean doOrder(String order) {
		for(Orders makeOrder : acceptedOrders) {
			if(makeOrder.getProblemDescription().equals(order)) {
				doneOrders.add(makeOrder);
				this.rate++;
				super.getOrders().remove(makeOrder);
				return true;
			}
		}
		return false;
	}
	// view done orders
	public String viewDoneOrders() {
		String view = null;
		for(Orders order : doneOrders) {
			view+=order.getProblemDescription() + " " + order.getSendedDate() + '\n';
		}
		return view;
	}
	
	
}
