package KlauserJava.Composite;

public abstract class Employee {
    public static int employeeId;
    abstract void addEmployee(Employee employee);
    abstract void removeEmployee(int employeeId);
}
