package bankApplication;

public class UserBean {
public String accno,accHolderName;
public double accBalance,transactionTime,amount,transactionId;
public UserBean() {
	super();
	// TODO Auto-generated constructor stub
}
public String getAccno() {
	return accno;
}
public void setAccno(String accno) {
	this.accno = accno;
}
public String getAccHolderName() {
	return accHolderName;
}
public void setAccHolderName(String accHolderName) {
	this.accHolderName = accHolderName;
}
public double getAccBalance() {
	return accBalance;
}
public void setAccBalance(double depositBalance) {
	this.accBalance = depositBalance;
}
public double getTransactionTime() {
	return transactionTime;
}
public void setTransactionTime(double transactionTime) {
	this.transactionTime = transactionTime;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public double getTransactionId() {
	return transactionId;
}
public void setTransactionId(double transactionId) {
	this.transactionId = transactionId;
}

}
