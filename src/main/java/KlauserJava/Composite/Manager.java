package KlauserJava.Composite;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee{
    public int employeeId;

    @Override
    public String toString() {
        return "Manager{" +
                "employeeId=" + employeeId +
                ", programmers=" + programmers +
                ", engineers=" + engineers +
                '}';
    }

    public List<Programmer> programmers = new ArrayList<>();
    public List<Engineer> engineers = new ArrayList<>();
    public Manager(){
        this.employeeId = Employee.employeeId++;
    }
    @Override
    void addEmployee(Employee employee) {
        if(employee instanceof Programmer){
            programmers.add((Programmer) employee);
        }
        if(employee instanceof Engineer){
            engineers.add((Engineer) employee);
        }
    }
    @Override
    void removeEmployee(int employeeId) {
        int index = -1;
        int indexx = -1;
        for(Programmer p : programmers){
            if(p.employeeId == employeeId)
                index = programmers.indexOf(p);
        }
        if(index != -1){
            programmers.remove(index);
        }
        for(Engineer e : engineers){
            if(e.employeeId == employeeId){
                indexx = engineers.indexOf(e);
            }
        }
        if(indexx != -1){
            engineers.remove(indexx);
        }
    }
}
