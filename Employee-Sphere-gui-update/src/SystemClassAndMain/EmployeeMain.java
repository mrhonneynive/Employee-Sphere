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
    	for (Department department : departments) {
    		department.setTotalTasksOfDept();
    		department.setTotalDoneTasksOfDept();
			department.getManager().calculatePerformanceScore(department.getTotalTasksOfDept(),department.getTotalDoneTasksOfDept());
		}
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
