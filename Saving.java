package Fxjava;

public class Saving extends Account {
public Saving(String ID, double balance) {
super(ID, balance);
// TODO Auto-generated constructor stub
}
@Override
public boolean withdraw(double amount) {
if((amount+2)<=balance)
{
balance=balance-amount-2;
return true;
}
else
// TODO Auto-generated method stub
return false;
}
@Override
public void deposit(double amount) {
// TODO Auto-generated method stub
balance=amount;
}}

