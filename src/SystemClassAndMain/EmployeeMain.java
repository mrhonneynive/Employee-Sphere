package SystemClassAndMain;

import java.util.ArrayList;

import GUI.MainFrame;
import Inheritance.Department;

public class EmployeeMain {
    public static void main(String args[]) {
    	ArrayList<Department> departments = new ArrayList<>();
    	departments.add(new Department(0, "Accounting and Finance"));
    	departments.add(new Department(1, "Marketing"));
    	departments.add(new Department(2, "IT"));
    	departments.add(new Department(3, "Customer Service"));
    	
    	EmployeeSystem.setDepartments(departments);
    	
    	EmployeeSystem.readFromFile();
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
