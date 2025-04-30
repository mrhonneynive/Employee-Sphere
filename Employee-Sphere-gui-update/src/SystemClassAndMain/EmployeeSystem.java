package SystemClassAndMain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import Inheritance.*;

public class EmployeeSystem {
    private static final int MAX_EMPLOYEES = 100;
    private static ArrayList<Department> departments = new ArrayList<>();
    private static Set<Employee> firedEmployees = new HashSet<>();
    
    
    
    
    public static ArrayList<Department> getDepartments() {
		return departments;
	}

	public static void setDepartments(ArrayList<Department> departments) {
		EmployeeSystem.departments = departments;
	}

	public static boolean readFromFile() {
        //role, id, name, surname, salary, tasks, department
    	Scanner sc = null;
        
    	int departmentId;
        String role;
        int id;
        String name,surname;
        double salary;
        int tasks;
        
       
        try {
            File file1 = new File("employeeSphere.txt");

            sc = new Scanner(file1);
            while (sc.hasNext()) {
                departmentId=sc.nextInt();
                
                role = sc.next();
                
                id=sc.nextInt();
            	name=sc.next();
            	surname=sc.next();
            	salary=sc.nextDouble();
            	tasks=sc.nextInt();
                if (role.equalsIgnoreCase("manager")) {
                	addManager(id, name, surname, salary, departmentId);
                	//departments.get(departmentId - 1).setTotalTasksOfDept(tasks);
                	
				} else if (role.equalsIgnoreCase("worker")) {
					addWorker(id, name, surname, salary, departmentId, tasks);
				}
            }
        } catch (FileNotFoundException ex) {
        	return false;
        }
        sc.close();
        return true;
    }
    
    public static boolean deleteEmployee(int id) {
    	Employee emp = searchEmployee(id);
    	
    	if (emp == null)
    		return false;
    	
    	else if (emp instanceof Worker) {
            departments.get(emp.getDepartmentId()).getWorkers().remove(emp);
            firedEmployees.add(emp);
            Employee.totalEmployees--;
            return true;
        }
        else {
            departments.get(emp.getDepartmentId()).setManager(null);
            firedEmployees.add(emp);
            Employee.totalEmployees--;
            return true;
        }

    }

    public static void promoteWorkerToManager(Worker worker) {
        Manager manager = new Manager(worker.getId(), worker.getName(), worker.getSurname(), worker.getSalary() * 1.4, worker.getDepartmentId());
        manager.calculatePerformanceScore(departments.get(manager.getDepartmentId()).getTotalTasksOfDept(), departments.get(manager.getDepartmentId()).getTotalDoneTasksOfDept());
        firedEmployees.add(departments.get(worker.getDepartmentId()).getManager());
        departments.get(worker.getDepartmentId()).setManager(manager);
        departments.get(worker.getDepartmentId()).getWorkers().remove(worker);
    }
    
    public static boolean addWorker(int id, String name, String surname, double salary, int departmentId, int tasks) {
    	departmentId--;
        if (searchEmployee(id) == null) {
            Worker worker = new Worker(id, name, surname, salary, departmentId, tasks);
            departments.get(departmentId).getWorkers().add(worker);
            worker.calculatePerformanceScore(tasks, worker.getDoneTasks());
            return true;
        }
        return false;
    }

    public static boolean addManager(int id, String name, String surname, double salary, int departmentId) {
    	departmentId--;
        if (departments.get(departmentId).getManager() == null) {
            Manager manager = new Manager(id, name, surname, salary, departmentId);
            departments.get(departmentId).setTotalTasksOfDept();
            departments.get(departmentId).setTotalDoneTasksOfDept();
            manager.calculatePerformanceScore(departments.get(departmentId).getTotalTasksOfDept(), departments.get(departmentId).getTotalDoneTasksOfDept());
            departments.get(departmentId).setManager(manager);
            return true;
        }
        return false;
    }

   

    public static Employee searchEmployee (int id) {
        Employee employee = null;
        for(Department department: departments){
            for (Worker worker : department.getWorkers()) {
                if (worker.getId() == id) {
                    employee = worker;
                    return employee;
                }
                else if (department.getManager().getId() == id) {
                    employee = department.getManager();
                    return employee;
                }
            }
        }
        return employee;
    }

    

 
    
    public static String display(int[] selectedDepartmentsArray, boolean[] selectedEmployeesArray) {
        String value = "";

        for (int i = 0; i < selectedDepartmentsArray.length; i++) {
            value += departments.get(selectedDepartmentsArray[i]).toString();
            if (selectedEmployeesArray[0]) { // for manager
            	if(departments.get(selectedDepartmentsArray[i]).getManager()!=null) {
                    value += departments.get(selectedDepartmentsArray[i]).getManager().toString() + "\n\n";

            	}else {
            		return "Please add a manager first. This department doesn't have a manager";
            	}

            }
            
            if (selectedEmployeesArray[1]) { // for workers
                for (Worker worker : departments.get(selectedDepartmentsArray[i]).getWorkers()) {
                    value += worker.toString() + "\n\n";
                }
            }
        }

        return value;
    }
    
    public static String displayByPerformanceScore(int[] selectedDepartmentsArray, boolean[] selectedEmployeesArray) {
        String res = "";

        TreeSet<Employee> tsByPerformanceScore = new TreeSet<>();

        for (int deptIndex : selectedDepartmentsArray) {
            Department department = departments.get(deptIndex);

            if (selectedEmployeesArray[0]) { // For managers
                Manager manager = department.getManager();
                if (manager != null) {
                    tsByPerformanceScore.add(manager);
                } else {
                    return "Please add a manager first. Department " + deptIndex + " doesn't have a manager.";
                }
            }

            if (selectedEmployeesArray[1]) { // For workers
                tsByPerformanceScore.addAll(department.getWorkers());
            }
        }

        for (Employee employee : tsByPerformanceScore) {
            res += employee instanceof Manager ? "Manager: " : "Worker: ";
            res += employee.toString() + "\n\n";
        }

        return res;
    }


    public static String displayFiredEmployees() {
        String value = "";
        for (Employee emp : firedEmployees) {
            value += emp.toString();
        }

        return value;
    }

}
