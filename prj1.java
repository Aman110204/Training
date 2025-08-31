package P1;
import java.util.*;

public class prj1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter The first name:");
        String firstName = s.next();
        System.out.println("Enter The Last name:");
        String lastName = s.next();
        employee e1 = new employee(firstName, lastName);
        e1.SelectDept();
        e1.generateEmail();
        e1.Position();
        e1.generatePassword();
        e1.ShowCredentials();
        System.out.println("Do you want to reset Password:(Yes/y)");
        String ch = s.next();
        if (ch.equalsIgnoreCase("yes") || ch.equalsIgnoreCase("y")) {
            e1.resetPassword();
        }
        s.close();
    }
}

class employee {
    static Scanner s = new Scanner(System.in);
    String firstName, lastName, email, dept, pos;
    char[] password = new char[8];
    private int employeeID;
    private static int idCounter = 1000;

    employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = idCounter++;
    }

    public void generateEmail() {
        this.email = firstName + lastName + "@" + dept + ".skit.ac.in";
    }

    public void SelectDept() {
        System.out.println("Select the department of employee \n1.Technical\n2.Admin\n3.Human Resource\n4.Legal");
        int d = s.nextInt();
        switch (d) {
            case 1 -> dept = "Technical";
            case 2 -> dept = "Admin";
            case 3 -> dept = "Human Resource";
            case 4 -> dept = "Legal";
        }
    }

    public void ShowCredentials() {
        System.out.println("Employee Credentials Are:");
        System.out.println(firstName + " " + lastName);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Email address: " + email);
        System.out.println("Department: " + dept + "  Position: " + pos);
        System.out.println("Password: " + new String(password));
    }

    public void generatePassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789,./?';:";
        Random r = new Random();
        for (int i = 0; i < 8; i++) {
            password[i] = chars.charAt(r.nextInt(chars.length()));
        }
    }

    private boolean isPasswordStrong(String password) {
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        return password.matches(pattern);
    }

    public void resetPassword() {
        System.out.println("Enter current password");
        String cp = s.next();
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
        this.pos = s.next();
    }
}
