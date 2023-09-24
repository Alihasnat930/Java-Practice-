package Fxjava;

public abstract class Account {
protected String ID;
protected double balance;
public Account (String ID, double balance)
{
this.ID= ID;
this.balance=balance;
}
public String getID() {
return this. ID;
} 
public double getBalance() {
return this.balance;
} 
public abstract boolean withdraw(double amount); 
public abstract void deposit(double amount); 
}
