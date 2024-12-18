package Inheritance;

import java.lang.Math;

    public class Worker extends Employee implements Comparable<Worker> {
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
    public boolean isEligibleForRaise() {
        if (getPerformanceScore() >= 70){
            return true;
        }

        return false;
    }

    @Override
    public int compareTo(Worker w1) {
        return (int) (getPerformanceScore() - w1.getPerformanceScore());
    }

    @Override
    public String toString() {
        return "Inheritance.Worker{" +
                "tasks=" + tasks +
                ", doneTasks=" + doneTasks +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", performanceScore=" + performanceScore +
                '}';
    }
}
