package Labmanual; 
class Employee extends Person {
	 private String office;
	 private double salary;
	 private String hireDate;
	 
	 public Employee(String name, String address, String phoneNumber, String emailAddress) {
	  super(name, address, phoneNumber, emailAddress);
	 }
	 public String getOffice() {
	  return this.office;
	 }
	 public void setOffice(String office) {
	  this.office = office;
	 }
	 public double getSalary() {
	  return this.salary;
	 }
	 public void setSalary(double salary) {
	  this.salary = salary;
	 }
	 public String getHireDate() {
	  return this.hireDate;
	 }
	 public void setHireDate(String hireDate) {
	  this.hireDate = hireDate;
	 }
	 public String toString() {
	  StringBuffer sb = new StringBuffer();
	  sb.append(super.toString()+"\n");
	  sb.append("\tOffice:").append(office).append("\n");
	  sb.append("\tSalary:").append(salary).append("\n");
	  sb.append("\tHire Date:").append(hireDate).append("\n"); 
	  
	  return sb.toString();
	 }
	}


class Faculty extends Employee {
	 private String officeHours;
	 private String rank;
	 public Faculty(String name, String address, String phoneNumber, String emailAddress) {
	  super(name, address, phoneNumber, emailAddress);
	 }
	 public String getOfficeHours() {
	  return this.officeHours;
	 }
	 public void setOfficeHours(String officeHours) {
	  this.officeHours = officeHours;
	 }
	 public String getRank() {
	  return this.rank;
	 }
	 public void setRank(String rank) {
	  this.rank = rank;
	 }
	 public String toString() {
	  StringBuffer sb = new StringBuffer();
	  sb.append(super.toString()+"\n");
	  sb.append("\tOffice Hours:").append(officeHours).append("\n");
	  sb.append("\tRank:").append(rank).append("\n");
	  return sb.toString();
	 }
	}
class Staff extends Employee {
	
	private String title;
	
	public Staff(String name, String address, 
			String phoneNumber, String emailAddress) {
		super(name, address, phoneNumber, emailAddress);
    }
	
	public String getTitle() {
		
		return this.title;
    }
	
	public void setTitle(String title) {
		
		this.title = title;
    }
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
        sb.append(super.toString()+"\n");
        sb.append("\tTitle:").append(title).append("\n");
  
        return sb.toString();
    }
}
class Student extends Person {
	
	private String status;
	
	public Student(String name, String address, 
			String phoneNumber, String emailAddress) {
		
		super(name, address, phoneNumber, emailAddress);
    }
	
	public String getStatus() {
		
		return this.status;
    }
	
	public void setStatus(String status) {
		
		this.status = status;
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString()+"\n");
		sb.append("\tStatus:").append(status).append("\n");  
		
		return sb.toString();
	}
}