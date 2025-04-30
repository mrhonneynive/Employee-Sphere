package Inheritance;

import Interfaces.EmployeeActions;

public class Manager extends Employee implements EmployeeActions{
    public Manager(int id, String name, String surname, double salary, int departmentId) {
        super(id, name, surname, salary, departmentId);
    }
    
    @Override
    public void calculatePerformanceScore(int totalTasksOfDept, int totalDoneTasksOfDept){
        if(totalTasksOfDept == 0)
            setPerformanceScore(0);

        else
            setPerformanceScore((double) totalDoneTasksOfDept / totalTasksOfDept * 100);
    }

   
    @Override
    public String toString() {
        return 
        		"Manager of Department " + (departmentId+1) +
                '\n' + super.toString();
    }

	@Override
	public void raiseSalary() {
		setSalary(salary*1.4);
		
	}
    
   
}
