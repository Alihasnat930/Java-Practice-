/*Lab Tasks 1:
Develop Java Class IU_Mark_Sheet with following Constructor and Methods.
Constructor:
IU_Mark_Sheet(String Student, String Registration Number);
Methods: 
Void Subject_Name(String Subject[]);
Void Subject_Max_Mark(double MaxMark[]);
Void Subject_Scored_Mark(double ScoredMark[]);
Double StudentGPA();*/
package pr.java;
public class pr1 {
	
	pr1(String student, String regnum){
		 System.out.println("Student Name :"+ student +"\nID :"  +regnum );}
		
	 static void Subject_Name(String subject) {
		 System.out.println("Subject: " +subject);
	 }

	 static void Subject_Max_Mark(double MaxMark) {
		 System.out.println("MAxmarks: " +MaxMark);
	 }

	 static void Subject_Scored_Mark(double ScoredMark){
	
		 System.out.println("Scored mark: " +ScoredMark);
	 }

	 static Double StudentGPA()  { 
		 double StudentGPA = 3.99d;
		return StudentGPA;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pr1 obj = new pr1("Ali", "59750");
        Subject_Name("Maths");
        Subject_Max_Mark(1000);
        Subject_Scored_Mark(990);
        System.out.println("Student GPA: " + StudentGPA());
		
		
		
		
	}

}
