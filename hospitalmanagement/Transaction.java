import java.util.Date;
import java.util.Random;

import enums.TransactionType;

public class Transaction {
  
  //attributes
  private long transactionId;
  private Date transactionDate;
  private double amount;
  private TransactionType transactionType;

//parameterized constructor
  public Transaction(long transactionId, Date transactionDate, double amount, TransactionType transactionType) {
    this.transactionId = transactionId;
    this.transactionDate = transactionDate;
    this.amount = amount;
    this.transactionType = transactionType;
  }


  //default constructor
  public Transaction() {
  }

  //setters and getters
  public long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(long transactionId) {
    this.transactionId = transactionId;
  }

  public Date getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public TransactionType getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
  }


  //generating a transaction ids
  public long generateTransactionId() 
  {
    long min=1000000000000L;
    //long max= 9999999999999L;

    //Random random = new Random();
    long transactionId = (long) (min * Math.random());
    //((long)(random.min*(max-min)))
    return transactionId;
  }

  
  
}
