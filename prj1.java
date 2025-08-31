package P1;
import java.util.*;
import java.util.random.*;

public class prj1 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String FirstName,LastName;
		System.out.println("Enter The first name:");
		FirstName=s.next();
		s.nextLine();
		System.out.println("Enter The Last name:");
		LastName=s.next();
		employee e1=new employee(FirstName,LastName);
		e1.SelectDept();
		e1.generateEmail();
		e1.Position();
		e1.ShowCredentials();
		System.out.println("Do you want to reset Password:(Yes/y");
		String ch=s.next();
		if(ch.equalsIgnoreCase("yes") || ch.equalsIgnoreCase("y"))  {
		e1.resetPassword();}
		s.close();
		package P1;
import java.util.*;
import java.util.random.*;

public class prj1 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String FirstName,LastName;
		System.out.println("Enter The first name:");
		FirstName=s.next();
		s.nextLine();
		System.out.println("Enter The Last name:");
		LastName=s.next();
		employee e1=new employee(FirstName,LastName);
		e1.SelectDept();
		e1.generateEmail();
		e1.Position();
		e1.ShowCredentials();
		System.out.println("Do you want to reset Password:(Yes/y");
		String ch=s.next();
		if(ch.equalsIgnoreCase("yes") || ch.equalsIgnoreCase("y"))  {
		e1.resetPassword();}
		s.close();
		
		
	}

}
class employee{
	static Scanner s=new Scanner(System.in);
	String FirstName,LastName,email,Dept,pos;
	char[] password=new char[8];
	private int employeeID;
    private static int idCounter = 1000;
	employee(String FirstName,String LastName){
		this.FirstName=FirstName;
		this.LastName=LastName;
		this.employeeID = idCounter++;
		
	}
	public void generateEmail() {
		this.email=FirstName+LastName+"@"+Dept+".skit.ac.in";
		
	}
	public void SelectDept() {
		System.out.println("Select the department of employee \n1.Technical\n2.Admin\n3.Human Resource\n4.legal");
		int dept=s.nextInt();
		
			switch(dept) {
			case 1:Dept="Technical";break;
			case 2:Dept="Admin";break;
			case 3:Dept="Human Resource";break;
			case 4:Dept="Legal";break;
			}		
	}
	public void ShowCredentials() {
		System.out.println("Employee Crendentials Are:");
		System.out.println(FirstName+" "+LastName);
		System.out.println("Employee ID: " + employeeID);
		System.out.println("Email address :"+email);
		System.out.println("Department :"+Dept+"  Position:"+pos);
		System.out.println("Password :");
		for(int i=0;i<8;i++){
			System.out.print(password[i]);
		}
		
	}
	public void generatePassword() {
		String CapitalLetters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String SmallLetters="abcdefghijklmnopqrstuvwxyz";
		String numbers="0123456789";
		String symbols=",./?';:";
		String values=CapitalLetters+SmallLetters+numbers+symbols;
		Random r=new Random();
		for(int i=0;i<8;i++) {
			this.password[i]=values.charAt(r.nextInt(values.length()));
		}
		
	
	}
	private boolean isPasswordStrong(String password) {
	    String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
	    return password.matches(passwordPattern);
	}

	public void resetPassword() {
	    System.out.println("Enter current password");
	    String cp = s.next();
	    s.nextLine();
	    String currentPassword = new String(this.password);
	    
	    if (cp.equals(currentPassword)) {
	        String newPass;
	        while (true) {
	            System.out.println("Enter new password (must be 8+ chars, with uppercase, lowercase, and a number):");
	            newPass = s.next();
	            if (isPasswordStrong(newPass)) {
	                this.password = newPass.toCharArray();
	                System.out.println("Password successfully updated!");
	                break;
	            } else {
	                System.out.println("Weak password. Please try again.");
	            }
	        }
	    } else {
	        System.out.println("Incorrect password, Try Again.");
	    }
	}
	
	public void Position() {
		System.out.println("Enter Your position in the organisation");
		this.pos=s.next();
		s.nextLine();
	}
			
	
	

}

		
	}

}
class employee{
	static Scanner s=new Scanner(System.in);
	String FirstName,LastName,email,Dept,pos;
	char[] password=new char[8];
	employee(String FirstName,String LastName){
		this.FirstName=FirstName;
		this.LastName=LastName;
		
	}
	public void generateEmail() {
		this.email=FirstName+LastName+"@"+Dept+".skit.ac.in";
		
	}
	public void SelectDept() {
		System.out.println("Select the department of employee \n1.Technical\n2.Admin\n3.Human Resource\n4.legal");
		int dept=s.nextInt();
		
			switch(dept) {
			case 1:Dept="Technical";break;
			case 2:Dept="Admin";break;
			case 3:Dept="Human Resource";break;
			case 4:Dept="Legal";break;
			}		
	}
	public void ShowCredentials() {
		System.out.println("Employee Crendentials Are:");
		System.out.println(FirstName+" "+LastName);
		System.out.println("Email address :"+email);
		System.out.println("Department :"+Dept+"  Position:"+pos);
		System.out.println("Password :"+password);
	}
	public void generatePassword() {
		String CapitalLetters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String SmallLetters="abcdefghijklmnopqrstuvwxyz";
		String numbers="0123456789";
		String symbols=",./?';:";
		String values=CapitalLetters+SmallLetters+numbers+symbols;
		Random r=new Random();
		for(int i=0;i<8;i++) {
			this.password[i]=values.charAt(r.nextInt(values.length()));
		}
		
	
	}
	public void resetPassword() {
		System.out.println("Enter current password");
		String cp=s.next();
		s.nextLine();
		if(cp==this.password.toString()) {
			System.out.println("Enter new password");
			 String newPass = s.next();
	            this.password = newPass.toCharArray();
	            System.out.println("Password successfully updated!");
	        } else {
	            System.out.println("Incorrect password,Try Again.");
	        }
	    }
	public void Position() {
		System.out.println("Enter Your position in the organisation");
		this.pos=s.next();
		s.nextLine();
	}
			
	
	

}

