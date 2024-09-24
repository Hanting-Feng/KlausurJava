package KlauserJava.Composite;

public class Programmer extends Employee{
    public int employeeId;

    @Override
    public String toString() {
        return "Programmer{" +
                "employeeId=" + employeeId +
                '}';
    }

    Programmer(){
        this.employeeId = Employee.employeeId++;
    }
    @Override
    void addEmployee(Employee employee) {
    }
    @Override
    void removeEmployee(int EmployeeId) {
    }
}
