abstract class Employee {
    protected int employeeId;
    protected String name;
    protected String paymentMethod;
    protected String paymentDetails;
    protected String taxInformation;

    public Employee(int employeeId, String name, String paymentMethod, String paymentDetails, String taxInformation) {
        this.employeeId = employeeId;
        this.name = name;
        this.paymentMethod = paymentMethod;
        this.paymentDetails = paymentDetails;
        this.taxInformation = taxInformation;
    }

    public abstract double calculatePay();

    public String generatePayStub() {
        return "Employee ID: " + employeeId + "\n" +
                "Name: " + name + "\n" +
                "Pay: " + calculatePay() + "\n" +
                "Payment Method: " + paymentMethod + "\n";
    }

    public int getEmployeeId() {
        return employeeId;
    }
}




class SalariedEmployee extends Employee {
    private double salary;

    public SalariedEmployee(int employeeId, String name, String paymentMethod, String paymentDetails, String taxInformation, double salary) {
        super(employeeId, name, paymentMethod, paymentDetails, taxInformation);
        this.salary = salary;
    }

    @Override
    public double calculatePay() {
        return salary;
    }
}


class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public HourlyEmployee(int employeeId, String name, String paymentMethod, String paymentDetails, String taxInformation, double hourlyRate, double hoursWorked) {
        super(employeeId, name, paymentMethod, paymentDetails, taxInformation);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }
}



class CommissionedEmployee extends Employee {
    private double commissionRate;
    private double totalSales;

    public CommissionedEmployee(int employeeId, String name, String paymentMethod, String paymentDetails, String taxInformation, double commissionRate, double totalSales) {
        super(employeeId, name, paymentMethod, paymentDetails, taxInformation);
        this.commissionRate = commissionRate;
        this.totalSales = totalSales;
    }

    @Override
    public double calculatePay() {
        return commissionRate * totalSales;
    }
}













































