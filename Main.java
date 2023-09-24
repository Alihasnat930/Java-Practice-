
package Fxjava;
public class Main {
public static void main(String[] args) {
// TODO Auto-generated method stub
Saving obj=new Saving("AliHasnat", 59750);
System.out.println("id is "+obj.ID+" your balance is "+obj.balance
);
if(obj.withdraw(3))
{
System.out.println(" succesfully widthdraw \n remaining Amount"+obj.balance);
}else
System.out.println("you have low balance");
}}