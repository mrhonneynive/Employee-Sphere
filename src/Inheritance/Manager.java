package Inheritance;

public class Manager extends Employee {
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
    public boolean isEligibleForRaise() {
        if (getPerformanceScore() >= 80){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return 
        		"Manager of Department " + (departmentId+1) +
                '\n' + super.toString();
    }
}
