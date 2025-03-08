package com.practice.lld.paymentGateway;

import java.util.Random;

public class PaymentGatewayController {
	
	UserController userController;
	UserBankController userBankController;
	TransactionController transactionController;
	
	public PaymentGatewayController() {
		this.userController = new UserController();
		this.userBankController = new UserBankController();
		this.transactionController = new TransactionController();
	}
	
	// user controller - start
	
	public void addUser(User user) {
		this.userController.addUser(user);
	}
	
	public User getUser(int userid) {
		return this.userController.getUser(userid);
	}
	
	// user controller - end
	
	// user bank controller - start
	
	public void addBank(Bank bank) {
		 this.userBankController.addBank(bank);
	}
	
	public Bank getBank(String bankName) {
		return this.userBankController.getBank(bankName);
	}
	
	
	public void addUserBankAccount(int userid, String bankName, int ubid, int amount) {
		User user = getUser(userid);
		if (user != null) {
			this.userBankController.addUserBankAccount(user, bankName, ubid, amount);
		}
	}
	
	public UserBankAccount getUserBankAccount(int userid, String bankName) {
		User user = getUser(userid);
		if (user != null) {
			return this.userBankController.getUserBankAccount(userid, bankName);
		}
		return null;
	}
	
	public void showAllUserBankAccounts(int userid) {
		User user = getUser(userid);
		if (user != null) {
			 this.userBankController.getAllUserBankAccounts(user);
		}
	}
	
	public void showBalanceOfUser(int userid, String bank) {
		User user = getUser(userid);
		if (user != null) {
			 this.userBankController.showBalanceOfUserAccount(userid, bank);
		}
	}
	
	public void creditMoney(int userid, String bank, int amount) {
		User user = getUser(userid);
		if (user != null) {
			this.userBankController.creditMoneyInUserAccount(userid, bank, amount);
		}
	}
	
	public void debitMoney(int userid, String bank, int amount) {
		User user = getUser(userid);
		if (user != null) {
			this.userBankController.debitMoneyFromUserAccount(userid, bank, amount);
		}
	}
	
	public boolean checkEnoughMoney(int userid, String bank, int amount) {
		User user = getUser(userid);
		if (user != null) {
			return this.userBankController.checkEnoughMonenyInUserAccount(userid, bank, amount);
		}
		return false;
	}
	
	public void addUserInstrument(int userid, String bank, InstrumentDo istrument) {
		User user = getUser(userid);
		if (user != null) {
			 this.userBankController.addUserInstrument(userid, bank, istrument);
		} 
	}
	
	public UserBankInstrument getUserInstrument(int userid, String bank, InstrumentType it) {
		User user = getUser(userid);
		if (user != null) {
			 return this.userBankController.getUserInstrument(userid, bank, it);
		} 
		return null;
	}
	
	// user bank controller - end
	
	public void transferMoney(int senderid, String senderBank, int receiverid, 
			String receiverBank, int amount, InstrumentDo instrument) {
		User sender = getUser(senderid);
		User receiver = getUser(receiverid);
		if (sender == null || receiver == null) {
			return;
		}
		
		UserBankAccount senderBankAccount = getUserBankAccount(senderid, senderBank);
		UserBankAccount receiverBankAccount = getUserBankAccount(receiverid, receiverBank);
		if (senderBankAccount == null || receiverBankAccount == null) {
			return;
		}
		
		UserBankInstrument senderInstrument =  getUserInstrument( senderid, senderBank, instrument.type);
		if (senderInstrument == null ) {
			return;
		}
		
		if (!senderInstrument.matchCredentials(instrument)) {
			System.out.println(" wrong credential are entered");
			return;
		}
		
		if (!senderBankAccount.enoughMoney(amount)) {
			System.out.println(" user : " + senderid + " do not have enough balance of " + amount);
			return;
		}
		
		senderBankAccount.debitMoney(amount);
		receiverBankAccount.creditMoney(amount);
		
		Transaction txn = new Transaction( getRandomNumber(),  senderBankAccount, receiverBankAccount, senderInstrument.uid,  amount);
		this.transactionController.addTransaction(txn);
		
		String senderMessage = "Amount : " + amount + " is sent to user : " + receiverBankAccount.user.userid + " with bank : " + receiverBankAccount.bank.bankName;
		senderBankAccount.notifyMessage(senderMessage);
		
		String receiverMessage = "Amount : " + amount + " is receiver from user : " + senderBankAccount.user.userid + " with bank : " + senderBankAccount.bank.bankName;
		receiverBankAccount.notifyMessage(receiverMessage);	
		
		System.out.println(" sender balance : " + senderBankAccount.getAmount());
		System.out.println(" receiver balance : " + receiverBankAccount.getAmount());
		
	}
	
	private int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(10000);
	}

	public void printTransactionHistory(int userid) {
		this.transactionController.showTransactionHistoryForUser(userid);
	}
}
