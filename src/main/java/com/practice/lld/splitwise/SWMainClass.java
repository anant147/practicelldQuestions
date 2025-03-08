package com.practice.lld.splitwise;

import java.util.ArrayList;
import java.util.List;

public class SWMainClass {

	public static void main(String[] args) {
		
		Splitwise splitWise = new Splitwise();
		User user1 = new User(1, "ab");
		User user2 = new User(2, "bc");
		User user3 = new User(3, "cd");
		User user4 = new User(4, "de");
		User user5 = new User(5, "ef");
		
		splitWise.addUser(user1);
		splitWise.addUser(user2);
		splitWise.addUser(user3);
		splitWise.addUser(user4);
		splitWise.addUser(user5);
		
		Group group1 = new Group(11, "Dinner");
		splitWise.addGroup(group1);
		group1.addUser(user1);
		group1.addUser(user2);
		group1.addUser(user3);
		
		List<Split> splits1 = new ArrayList<>();
		splits1.add(new Split(user1, 100, 0));
		splits1.add(new Split(user2, 100, 0));
		splits1.add(new Split(user3, 200, 0));

		splitWise.addExpenseInGroup(11, 1, "Dinner in night", 400, user1, SplitType.UNEQUAL, splits1);
		
		Group group2 = new Group(12, "Lunch");
		splitWise.addGroup(group2);
		group2.addUser(user5);
		group2.addUser(user2);
		group2.addUser(user4);
		
		List<Split> splits2 = new ArrayList<>();
		splits2.add(new Split(user5, 0, 40));
		splits2.add(new Split(user2, 0, 30));
		splits2.add(new Split(user4, 0, 30));
		
		splitWise.addExpenseInGroup( 12, 2, "Lunch in Noon", 500, user5, SplitType.PERCENTAGE, splits2);

		List<Split> splits3 = new ArrayList<>();
		splits3.add(new Split(user1, 250, 0));
		splits3.add(new Split(user2, 250, 0));
		
		splitWise.addExpenseWithout( 3, "Lunch in Noon", 500, user1, SplitType.EQUAL, splits3);
		
		splitWise.printUserDetails();

	}

}
