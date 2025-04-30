package Inheritance;

import java.lang.Math;

import Interfaces.EmployeeActions;
import SystemClassAndMain.EmployeeSystem;

    public class Worker extends Employee  implements EmployeeActions{
    private int tasks;
    private int doneTasks;

    public Worker (int id, String name, String surname, double salary, int departmentId, int tasks) {
        super(id, name, surname, salary, departmentId);
        this.tasks = tasks;
        setDoneTasks(tasks);
    }

    public int getTasks() {
        return tasks;
    }

    public void setTasks(int tasks) {
        this.tasks = tasks;
    }

    public int getDoneTasks() {
        return doneTasks;
    }

    public void setDoneTasks(int tasks) {
        doneTasks = (int) Math.floor(Math.random() * (tasks + 1));
    }

    public void calculatePerformanceScore(int tasks, int doneTasks){
        if (tasks == 0)
            setPerformanceScore(0);
        else
            setPerformanceScore((double) doneTasks / tasks * 100);
    }

    
    

    @Override
    public String toString() {
        return 	"Worker in Department " +EmployeeSystem.getDepartments().get(departmentId).getName() +
                '\n' +
        		super.toString() + 
        		"Done Tasks= " + doneTasks+ "   Tasks= " + tasks 
                ;
    }

	@Override
	public void raiseSalary() {
		// TODO Auto-generated method stub
		setSalary(salary*1.1);
	}

	
}
