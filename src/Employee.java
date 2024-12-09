public abstract class Employee {
    private int employeeId;
    private String name;
    private String employeeType;
    private String paymentMethod;
    private String paymentDetails;
    private String taxInformation;

    public Employee(int employeeId, String name, String employeeType, String paymentMethod, String paymentDetails, String taxInformation) {
        this.employeeId = employeeId;
        this.name = name;
        this.employeeType = employeeType;
        this.paymentMethod = paymentMethod;
        this.paymentDetails = paymentDetails;
        this.taxInformation = taxInformation;
    }

    public abstract double calculatePay();

    public String generatePayStub() {
        return "Pay Stub:\nEmployee ID: " + employeeId + "\nName: " + name +
                "\nEmployee Type: " + employeeType + "\nPayment Method: " + paymentMethod +
                "\nPayment Details: " + paymentDetails + "\nTax Information: " + taxInformation +
                "\nCalculated Pay: " + calculatePay();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTaxInformation() {
        return taxInformation;
    }

    public void setTaxInformation(String taxInformation) {
        this.taxInformation = taxInformation;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }
}





class SalariedEmployee extends Employee {
    private double salary;
    public SalariedEmployee(int employeeId, String name, String paymentMethod, String paymentDetails, String taxInformation, double salary) {
        super(employeeId, name, "Salaried", paymentMethod, paymentDetails, taxInformation);
        this.salary = salary;
    }

    @Override
    public double calculatePay() {
        return salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}



 class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(int employeeId, String name, String paymentMethod, String paymentDetails, String taxInformation, double hourlyRate, int hoursWorked) {
        super(employeeId, name, "Hourly", paymentMethod, paymentDetails, taxInformation);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}




class CommissionedEmployee extends Employee {
    private double commissionRate;
    private double totalSales;

    public CommissionedEmployee(int employeeId, String name, String paymentMethod, String paymentDetails, String taxInformation, double commissionRate, double totalSales) {
        super(employeeId, name, "Commissioned", paymentMethod, paymentDetails, taxInformation);
        this.commissionRate = commissionRate;
        this.totalSales = totalSales;
    }

    @Override
    public double calculatePay() {
        return commissionRate * totalSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
}














































