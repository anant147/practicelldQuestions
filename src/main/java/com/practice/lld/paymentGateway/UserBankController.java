package com.practice.lld.paymentGateway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserBankController {
	
	List<Bank> banks;
	Map<String, Bank> bankMap;
	List<UserBankAccount> userBankAccounts;
	Map<Bank, List<UserBankAccount>> bankAccountMap;
	Map<User, List<UserBankAccount>> userAccountMap;
	
	public UserBankController() {
		this.bankMap = new HashMap<>();
		this.banks = new ArrayList<>();
		this.userBankAccounts = new ArrayList<>();
		this.bankAccountMap = new HashMap<>();
		this.userAccountMap = new HashMap<>();
	}
	
	public void addBank(Bank bank) {
		if (this.bankMap.get(bank.getBankName()) == null) {
			this.banks.add(bank);
			this.bankMap.put(bank.getBankName(), bank);
		}
		else {
			System.out.println(" bank : " + bank.getBankName() + " already exists");
		}
	}
	
	public Bank getBank(String bankName) {
		if (this.bankMap.get(bankName) != null) {
			return this.bankMap.get(bankName);
		}
		System.out.println(" bank : " + bankName + " do not exists");
		return null;
	}
	
	// add check related to user in calling class
	public void addUserBankAccount(User user, String bankName, int ubid, int amount) {
		 Bank bank = getBank(bankName);
		 if (bank != null) {
			 UserBankAccount uba = new UserBankAccount(ubid, user, bank, amount);
			 this.userBankAccounts.add(uba);
			 addEntryInBankAccountMap(uba);
			 addEntryInUserAccountMap(uba);
		 }
	}

	private void addEntryInUserAccountMap(UserBankAccount uba) {
		Bank bank = uba.bank;
		List<UserBankAccount> ubs = new ArrayList<>();
		if (this.bankAccountMap.get(bank) == null) {
			this.bankAccountMap.put(bank, ubs);
		}
		else {
			ubs = this.bankAccountMap.get(bank);
		}
		ubs.add(uba);
	}

	private void addEntryInBankAccountMap(UserBankAccount uba) {
		User user = uba.user;
		List<UserBankAccount> ubs = new ArrayList<>();
		if (this.userAccountMap.get(user) == null) {
			this.userAccountMap.put(user, ubs);
		}
		else {
			ubs = this.userAccountMap.get(user);
		}
		ubs.add(uba);
	}
	
	public UserBankAccount getUserBankAccount(int userid, String bank) {
		for (UserBankAccount ub : this.userBankAccounts) {
			
			if (ub.user.userid == userid && bank.equals(ub.bank.bankName))
				return ub;
		}
		System.out.println(" no account exist for user : "+ userid + " and bank : " + bank);
		return null;
	}
	
	public void getAllUserBankAccounts(User user) {
		if (this.userAccountMap.get(user) != null) {
			List<UserBankAccount> ubs = this.userAccountMap.get(user);
			System.out.println(" user : " + user.userid + " , its accounts : ");
			for (UserBankAccount ub : ubs) {
				System.out.println(ub);
				showUserInstruments(ub);
			}
		}
		else {
			System.out.println(" no user bank account for user : " + user.userid);
		}
	}

	private void showUserInstruments(UserBankAccount ub) {
		Map<InstrumentType, UserBankInstrument> instMap = ub.instMap;
		if (instMap.isEmpty()) {
			System.out.println(" no instrument for user : " + ub.user.userid);
		}
		else {
			for (UserBankInstrument ubi : instMap.values()) {
				System.out.println(ubi);
			}
		}
	}
	
	public void showBalanceOfUserAccount(int userid, String bank) {
		UserBankAccount ub = getUserBankAccount( userid,  bank);
		if (ub != null) {
			System.out.println(" for userid " + userid + ", bank : " + bank + ",, amount : " + ub.amount);
		}
	}
	
	
	public void creditMoneyInUserAccount(int userid, String bank, int amount) {
		UserBankAccount ub = getUserBankAccount( userid,  bank);
		if (ub != null) {
			ub.creditMoney(amount);
		}
	}
	
	public void debitMoneyFromUserAccount(int userid, String bank, int amount) {
		UserBankAccount ub = getUserBankAccount( userid,  bank);
		if (ub != null) {
			ub.debitMoney(amount);
		}
	}
	
	public boolean checkEnoughMonenyInUserAccount(int userid, String bank, int amount) {
		UserBankAccount ub = getUserBankAccount( userid,  bank);
		if (ub != null) {
			boolean val = ub.enoughMoney(amount);
			System.out.println(" money : " + amount + " present for user acc. : " + userid + " and bank : " + bank + " ::: " + val);
			return val;
		}
		return false;
	}
	
	public void addUserInstrument(int userid, String bank, InstrumentDo istrument) {
		UserBankAccount ub = getUserBankAccount( userid,  bank);
		UserBankInstrument ui = InstrumentFactory.makeUserBankInstrument(istrument);
		
		if (ub != null && ui != null) {
			ub.addInstrument(ui);
		}
	}
	
	public UserBankInstrument getUserInstrument(int userid, String bank, InstrumentType it) {
		UserBankAccount ub = getUserBankAccount( userid,  bank);
		if (ub != null) {
			Map<InstrumentType, UserBankInstrument> instMap = ub.instMap;
			if (instMap.get(it) != null) {
				return instMap.get(it);
			}
			System.out.println(" Inst : " +  it + " not exist for user : " + userid + " & bank : " + bank);
		}
		return null;
	}
	
}
