package Labmanual;

public class Person_Info  {

	 public static void main(String args[]) throws Exception {
		 
	  Person p = new Person(" Ali Hasnat", 
			  " DHA Phase 8 , Karachi, Pakistan", 
			  "03132388919", 
			  " Syed.59750@iqra.edu.pk");
	  
	  System.out.println("Person Details are:");
	  System.out.println(p.toString());
	  
	  Student s = new Student(" Muhammad Maaz", 
			  " Gardan saddar, Karachi, Pakistan", 
			  " 0311-222-4501", 
			  " muhammad.51379@iqra.edu.pk");
	  
	  s.setStatus(" Sophomore");
	  
	  System.out.println("Student Details are:");
	  System.out.println(s.toString());
	  
	  Employee e = new Employee(" Muhammad.Raina", 
			  " Defence phase 5, Karachi, Pakistan", 
			  " 044-111-1113", 
			  " M.raina.5@gmail.com");
	  
	  e.setOffice(" Bhadurabad");
	  e.setSalary(100000);
	  e.setHireDate(" 09-02-2021");
	  
	  System.out.println("Employee Details are:");
	  System.out.println(e.toString());
	  
	  Faculty f = new Faculty(" John Cena",
			  " 69 street, Chicago, United States", 
			  " 9901-284-1222", 
			  " youCan'tSeeMe@johncena.com");
	  
	  f.setOffice(" Wachington BC");
	  f.setSalary(120000);
	  f.setHireDate(" 19-06-2021");
	  f.setOfficeHours(" Day");
	  f.setRank(" Manager");
	  
	  System.out.println("Faculty Details are:");
	  System.out.println(f.toString());
	  
	  Staff st = new Staff(" Burak Deniz", 
			  " Istaklal street, Istambul, Turkey", 
			  " 882-111-7015", 
			  " BurakDeniz@gmail.com");
	  
	  st.setOffice(" Blue Mosuqe street");
	  st.setSalary(800000);
	  st.setHireDate(" 11-02-2021");
	  st.setTitle(" Executive Director");
	  System.out.println(" Staff Details are:");
	  System.out.println(st.toString());
	 }
	}
