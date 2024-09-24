package KlauserJava.Composite;

public class Secretary extends Employee{
    public  int employeeId;

    @Override
    public String toString() {
        return "Secretary{" +
                "employeeId=" + employeeId +
                '}';
    }

    public Secretary(){
        this.employeeId = Employee.employeeId;
    }
    @Override
    void addEmployee(Employee employee) {

    }
    @Override
    void removeEmployee(int EmployeeId) {

    }
}
