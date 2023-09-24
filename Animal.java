package fxjava;


public class Animal implements moveable,crawable{
	@Override
	public void crawlable() {
		System.out.println("Animals which moves are:"); 
System.out.println("snail"); 
System.out.println("crocodile:");
System.out.println("snakes"); } 
@Override 
public void moveable()
{ System.out.println("Animals which moves are:");
System.out.println("cats");
System.out.println("Hans"); 
System.out.println("Hourse"); } 
public static void main(String[] args) {
Animal A=new Animal(); A.crawlable(); A.moveable(); } }

