package com.practice.lld.Atm;

public class AtmMainClass {
	
	public static void main(String args[]) {
		AtmRoom atmRoom = new AtmRoom(50000, 15, 30, 50);
		
		atmRoom.printAtmDetails();
		User user = new User("abc", "Andy", 40000);
		user.setCard("123", "456");
		
		atmRoom.checkBalance(user, "456");
		atmRoom.pinChange(user, "456", "789");
		atmRoom.cashWithdrawal(user, "789", 32400);
		
		atmRoom.printAtmDetails();

		System.out.println("\n\n");
		
		atmRoom.checkBalance(user, "789");
		atmRoom.cashWithdrawal(user, "789", 2900);
		
		atmRoom.printAtmDetails();

	}
}
