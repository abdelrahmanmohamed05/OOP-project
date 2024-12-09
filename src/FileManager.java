import java.io.*;
import java.util.ArrayList;

class FileManager {

    // Method to save a single employee to a file
    public static void saveEmployee(Employee employee, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) { // 'true' appends to the file
            String line = employee.getEmployeeId() + "," +
                    employee.getName() + "," +
                    employee.getPaymentMethod() + "," +
                    employee.getPaymentDetails() + "," +
                    employee.getTaxInformation() + ",";

            if (employee instanceof SalariedEmployee) {
                line += "Salaried," + ((SalariedEmployee) employee).calculatePay();
            } else if (employee instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) employee;
                line += "Hourly," + he.calculatePay();
            } else if (employee instanceof CommissionedEmployee) {
                CommissionedEmployee ce = (CommissionedEmployee) employee;
                line += "Commissioned," + ce.calculatePay();
            }

            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving employee: " + e.getMessage());
        }
    }

    // Helper method to create an employee from the parsed data
    private static Employee createEmployee(String[] parts) {
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        String paymentMethod = parts[2];
        String paymentDetails = parts[3];
        String taxInformation = parts[4];
        Employee employee = null;

        // Create the correct type of employee based on the data
        if (parts[5].equals("Salaried")) {
            double salary = Double.parseDouble(parts[6]);
            employee = new SalariedEmployee(id, name, paymentMethod, paymentDetails, taxInformation, salary);
        } else if (parts[5].equals("Hourly")) {
            double hourlyRate = Double.parseDouble(parts[6]);
            double hoursWorked = Double.parseDouble(parts[7]);
            employee = new HourlyEmployee(id, name, paymentMethod, paymentDetails, taxInformation, hourlyRate, (int) hoursWorked);
        } else if (parts[5].equals("Commissioned")) {
            double commissionRate = Double.parseDouble(parts[6]);
            double totalSales = Double.parseDouble(parts[7]);
            employee = new CommissionedEmployee(id, name, paymentMethod, paymentDetails, taxInformation, commissionRate, totalSales);
        }
        return employee;
    }

    // Method to load a single employee by ID from the file
    public static Employee loadEmployee(String filename, int employeeId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                if (id == employeeId) {  // Match employee by ID
                    return createEmployee(parts);  // Use the helper method to create the employee
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading employee: " + e.getMessage());
        }
        return null;  // Return null if employee is not found
    }

    // Method to load all employees from the file
    public static void loadEmployees(ArrayList<Employee> employees, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Employee employee = createEmployee(parts);  // Use the helper method to create the employee
                employees.add(employee);  // Add employee to the list
            }
        } catch (IOException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
    }
}
