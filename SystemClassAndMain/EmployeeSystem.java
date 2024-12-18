package SystemClassAndMain;

import java.util.*;
import Inheritance.*;

public class EmployeeSystem {
    private static final int MAX_EMPLOYEES = 100;
    private static ArrayList<Department> departments = new ArrayList<>();
    private static Set<Employee> firedEmployees = new HashSet<>();

    public static boolean deleteEmployee(Employee emp) {
        if (emp instanceof Worker) {
            departments.get(emp.getDepartmentId()).getWorkers().remove(emp);
            firedEmployees.add(emp);
            Employee.totalEmployees--;
            return true;
        }
        else if (emp instanceof Manager) {
            departments.get(emp.getDepartmentId()).setManager(null);
            firedEmployees.add(emp);
            Employee.totalEmployees--;
            return true;
        }
        return false;
    }

    public static void promoteWorkerToManager(Worker worker) {
        Manager manager = new Manager(worker.getId(), worker.getName(), worker.getSurname(), worker.getSalary() * 1.4, worker.getDepartmentId());
        manager.calculatePerformanceScore(departments.get(manager.getDepartmentId()).getTotalTasksOfDept(), departments.get(manager.getDepartmentId()).getTotalDoneTasksOfDept());

        departments.get(worker.getDepartmentId()).setManager(manager);
        departments.get(worker.getDepartmentId()).getWorkers().remove(worker);
    }
    public static boolean addWorker(int id, String name, String surname, double salary, int departmentId, int tasks) {
        if (searchEmployee(id) == null) {
            Worker worker = new Worker(id, name, surname, salary, departmentId, tasks);
            for (Department department : departments) {
                if (department.getId() == departmentId) {
                    department.getWorkers().add(worker);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean addManager(int id, String name, String surname, double salary, int departmentId) {
        if (departments.get(departmentId).getManager() == null) {
            Manager manager = new Manager(id, name, surname, salary, departmentId);
            departments.get(departmentId).setManager(manager);
            return true;
        }

        return false;
    }

    public static Worker getBestWorker(int departmentId) {
        return departments.get(departmentId).getWorkers().iterator().next();
    }



    public static Employee searchEmployee (int id) {
        Employee employee = null;
        for(Department department: departments){
            for (Worker worker : department.getWorkers())
                if (worker.getId() == id) {
                    employee = worker;
                }
                else if (department.getManager().getId() == id) {
                    employee = department.getManager();
                }
        }
        return employee;
    }

    public static void raiseEmployee (Employee emp) {
        if (emp instanceof Worker && emp.isEligibleForRaise()) {
            emp.setSalary(emp.getSalary() * 1.1);
        } else if (emp instanceof Manager && emp.isEligibleForRaise()) {
            emp.setSalary(emp.getSalary() * 1.2);
        }
    }

    public static void resetTasks() {
        for (Department department : departments) {
            for (Worker worker : department.getWorkers()) {
                worker.setTasks((int) Math.floor(Math.random() * 3) + 8);
                worker.setDoneTasks(worker.getTasks());
                department.setTotalTasksOfDept();
                department.setTotalDoneTasksOfDept();
                department.getManager().calculatePerformanceScore(department.getTotalTasksOfDept(), department.getTotalDoneTasksOfDept());
            }
        }
    }

    // - [ ] create selectedDepartmentsArray and selectedEmployeesArray in GUI button
    public static String display(int[] selectedDepartmentsArray, boolean[] selectedEmployeesArray) {
        String value = "";

        for (int i = 0; i < selectedDepartmentsArray.length; i++) {
            value += departments.get(selectedDepartmentsArray[i]).toString();
            if (selectedEmployeesArray[0]) { // for manager
                value += departments.get(selectedDepartmentsArray[i]).getManager().toString();

            }
            if (selectedEmployeesArray[1]) { // for workers
                for (Worker worker : departments.get(selectedDepartmentsArray[i]).getWorkers()) {
                    value += worker.toString();
                }
            }
        }

        return value;
    }

    public static String displayFiredEmployees() {
        String value = "";
        for (Employee emp : firedEmployees) {
            value += emp.toString();
        }

        return value;
    }

}
