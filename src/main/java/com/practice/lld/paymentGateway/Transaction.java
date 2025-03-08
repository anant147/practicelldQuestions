package com.practice.lld.paymentGateway;

public class Transaction {
	
	int txid;
	int amount;
	int senderid;
	int senderAccountId;
	int senderInstId;
	int receiverid;
	int receiverAccountId;
	TransactionStatus status;
	
	public Transaction(int txid, UserBankAccount sender, UserBankAccount receiver, int senderInstId, int amount) {
		this.txid = txid;
		this.amount = amount;
		this.senderid = sender.user.userid;
		this.senderAccountId = sender.ubid;
		this.senderInstId = senderInstId;
		this.receiverid = receiver.user.userid;
		this.receiverAccountId = receiver.ubid;
		this.status = TransactionStatus.SUCCESS;
	}

	@Override
	public String toString() {
		return "Transaction [txid=" + txid + ", amount=" + amount + ", senderid=" + senderid + ", senderAccountId="
				+ senderAccountId + ", senderInstId=" + senderInstId + ", receiverid=" + receiverid
				+ ", receiverAccountId=" + receiverAccountId  + ", status="
				+ status + "]";
	}
	
	
}
