package Labmanual;

import java.lang.*;

public class lab9a implements CharSequence { private String charSequence; 
public lab9a (String charSequence) {
	System.out.println("String is " + charSequence); 
    char[] strArray = charSequence.toCharArray(); 
    char[] reversedArray = strArray.clone();
    int j = strArray.length - 1; for (int i = 0; i < strArray.length; i++)
    { reversedArray[j] = strArray[i]; j--; }
    this.charSequence = new String(reversedArray); 
    System.out.println("Reversed String to " + this.charSequence); }
 @Override 
 public int length() { 
	 return charSequence.length(); 
 }
@Override 
public char charAt(int i) {
	return charSequence.charAt(i); }

 @Override
 public CharSequence subSequence(int i, int i1) {
	 return charSequence.subSequence(i, i1); } 
@Override 
public String toString(){
	return charSequence; }
public static void main (String[] args) {
	 String test = "Select one of the sentences";
	 lab9a test2 = new lab9a(test);
	 System.out.println("length = " + test2.length());
	 System.out.println("charAt 2 = " + test2.charAt(2));
	 System.out.println("subSequence 1-6 = " + 
	test2.subSequence(1,6));
	 System.out.println("toString = " + test2.toString());
	 System.out.println("Maaz ");
	}
	}
