import java.util.ArrayList;
import java.util.List;

class PayrollSystem {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(int employeeId) {
        employees.removeIf(employee -> employee.getEmployeeId() == employeeId);
    }

    public double calculateTotalPayroll() {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.calculatePay();
        }
        return total;
    }

    public void generatePayslips() {
        for (Employee employee : employees) {
            System.out.println(employee.generatePayStub());
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

