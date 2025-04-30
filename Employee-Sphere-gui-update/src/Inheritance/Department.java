package Inheritance;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Department {
    private int id;
    private String name;
    private int totalTasksOfDept;
    private int totalDoneTasksOfDept;
    private Manager manager = null;
    private Set<Worker> workers = new HashSet<>();

    public Department(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

    public int getTotalTasksOfDept() {
        return totalTasksOfDept;
    }

    public void setTotalTasksOfDept() {
    	for (Worker worker : workers) {
            this.totalTasksOfDept += worker.getTasks();
        }
    }

    public int getTotalDoneTasksOfDept() {
        return totalDoneTasksOfDept;
    }

    public void setTotalDoneTasksOfDept() {
        for (Worker worker : workers) {
            this.totalDoneTasksOfDept += worker.getDoneTasks();
        }
    }
    
    
    @Override
    public String toString() {
        return " Department name=" + name + "\n" ;
    }

	public String getName() {
		return name;
	}
}
