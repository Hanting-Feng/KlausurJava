package KlauserJava.Composite;

import java.util.ArrayList;
import java.util.List;

public class CEO extends Employee{
    @Override
    public String toString() {
        return "CEO{" +
                "employeeId=" + employeeId +
                ", secretaries=" + secretaries +
                ", managers=" + managers +
                '}';
    }

    public int employeeId = 0;

    public List<Secretary> secretaries = new ArrayList<>();
    public List<Manager> managers = new ArrayList<>();
    public CEO(){
        this.employeeId = Employee.employeeId++;
    }
    @Override
    void addEmployee(Employee employee) {
        if(employee instanceof Secretary){
            secretaries.add((Secretary) employee);
        }
        if(employee instanceof Manager){
            managers.add((Manager) employee);
        }
    }
    @Override
    void removeEmployee(int employeeId) {
        for(Secretary s : secretaries){
            if(employeeId == s.employeeId){
                secretaries.remove(s);
            }
        }
        for(Manager m : managers){
            if(employeeId == m.employeeId){
                managers.remove(m);
            }
        }
    }
    public static void main(String[] args){
        Engineer engineer1 = new Engineer();
        Programmer programmer1 = new Programmer();
        Engineer engineer2 = new Engineer();
        Programmer programmer2 = new Programmer();
        Engineer engineer3 = new Engineer();
        Programmer programmer3 = new Programmer();
        Engineer engineer4 = new Engineer();
        Programmer programmer4 = new Programmer();
        Manager manager = new Manager();
        manager.addEmployee(programmer1);
        manager.addEmployee(engineer1);
        manager.addEmployee(programmer2);
        manager.addEmployee(engineer2);
        manager.addEmployee(programmer3);
        manager.addEmployee(engineer3);
        manager.addEmployee(programmer4);
        manager.addEmployee(engineer4);
        Secretary secretary = new Secretary();
        CEO ceo = new CEO();
        ceo.addEmployee(secretary);
        ceo.addEmployee(manager);
        manager.removeEmployee(0);
        System.out.println(ceo);
    }
}
