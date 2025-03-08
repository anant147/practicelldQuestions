package com.practice.lld.paymentGateway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionController {
	
	List<Transaction> transactions;
	Map<Integer, List<Transaction>> transactionMap;
	
	public TransactionController() {
		this.transactions = new ArrayList<>();
		this.transactionMap = new HashMap<>();
	}
	
	public void addTransaction(Transaction txn) {
		this.transactions.add(txn);
		addEntryInTxnMap(txn.senderid, txn);
		addEntryInTxnMap(txn.receiverid, txn);
	}

	private void addEntryInTxnMap(int userid, Transaction txn) {
		List<Transaction> txns = new ArrayList<>();
		if (this.transactionMap.get(userid) != null) {
			txns = this.transactionMap.get(userid);
		}
		else {
			this.transactionMap.put(userid, txns);
		}
		txns.add(txn);
	}
	
	public void showTransactionHistoryForUser(int userid) {
		
		if (this.transactionMap.get(userid) != null) {
			List<Transaction> txns = this.transactionMap.get(userid);
			System.out.println("\n transaction history of user : " + userid);
			for (Transaction txn : txns) {
				if (userid == txn.senderid) {
					System.out.println(" sent : " + txn);
				}
				else {
					System.out.println(" received : " + txn);
				}
			}
		}
		else {
			System.out.println(" no transaction for user : " + userid);
		}
	}
	
	
}
