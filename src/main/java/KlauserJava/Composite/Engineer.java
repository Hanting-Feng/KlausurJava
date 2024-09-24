package KlauserJava.Composite;

public class Engineer extends Employee{
    public int employeeId = 0;

    @Override
    public String toString() {
        return "Engineer{" +
                "employeeId=" + employeeId +
                '}';
    }

    public Engineer(){
        this.employeeId = Employee.employeeId++;
    }
    @Override
    void addEmployee(Employee employee) {
    }
    @Override
    void removeEmployee(int EmployeeId) {

    }
}
