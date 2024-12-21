import java.util.ArrayList;
import java.util.HashMap;

public class PayrollSystem {
    protected ArrayList<Employee> employees = new ArrayList<>();
    private HashMap<String, String> userCredentials = new HashMap<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(int employeeId) {
        employees.removeIf(employee -> employee.getEmployeeId() == employeeId);
    }

    public double calculateTotalPayroll() {
        return employees.stream().mapToDouble(Employee::calculatePay).sum();
    }

    public void generatePayslips() {
        for (Employee employee : employees) {
            System.out.println(employee.generatePayStub());
        }
    }

    public void updateEmployeeDetails(int employeeId, String attribute, Object newValue) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                switch (attribute.toLowerCase()) {
                    case "name":
                        employee.setName((String) newValue);
                        break;
                    case "paymentmethod":
                        employee.setPaymentMethod((String) newValue);
                        break;
                    case "taxinformation":
                        employee.setTaxInformation((String) newValue);
                        break;
                    default:
                        System.out.println("Invalid attribute.");
                }
            }
        }
    }

    public void registerUser(String username, String password) {
        userCredentials.put(username, password);
    }

    public boolean login(String username, String password) {
        return userCredentials.getOrDefault(username, "").equals(password);
    }
}


