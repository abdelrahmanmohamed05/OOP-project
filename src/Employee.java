abstract public class Employee {
    protected int employeeId;
    protected String name;
    protected String paymentMethod;
    protected String paymentDetails;
    protected String taxInformation;
    protected String employeeType;
    public Employee(String employeeType,int employeeId,String name,String paymentDetails,String paymentMethod,String taxInformation){

        this.employeeId=employeeId;
        this.name=name;
        this.paymentDetails=paymentDetails;
        this.paymentMethod=paymentMethod;
        this.taxInformation=taxInformation;
        this.employeeType=employeeType;
    }

    abstract double calculatepay();

    String generatePayStub(){

        return "EmployeeId: "+ employeeId + "/n" +
                "EmployeeName: "+ name + "/n" +
                "EmployeeType: "+ employeeType + "/n" +
                "Pay: "+ calculatepay() + "/n" +
                "PaymentMethod: "+ paymentMethod;


    }




}



 class SalariedEmployee extends Employee{

    private double salary;

    SalariedEmployee(double salary,String employeeType,int employeeId,String name,String paymentDetails,String paymentMethod,String taxInformation){
        super(employeeType, employeeId, name, paymentDetails, paymentMethod, taxInformation);
        this.salary=salary;
    }

    @Override
    double calculatepay() {
        return salary;
    }
}

class HourlyEmployee extends Employee{

    private double hourlyRate;
    private double hoursWorked;


    HourlyEmployee(String employeeType,int employeeId,String name,String paymentDetails,String paymentMethod,String taxInformation,double hourlyRate,double hoursWorked){

        super( employeeType, employeeId, name, paymentDetails, paymentMethod, taxInformation);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;

    }

    @Override
    double calculatepay() {
        return hourlyRate*hoursWorked;
    }
}


class CommissionedEmployee extends Employee{

    private double commissionRate;
    private double totalSales;

    CommissionedEmployee(String employeeType,int employeeId,String name,String paymentDetails,String paymentMethod,String taxInformation,double commissionRate,double totalSales){

        super( employeeType, employeeId, name, paymentDetails, paymentMethod, taxInformation);

        this.commissionRate=commissionRate;
        this.totalSales=totalSales;

    }


    @Override
    double calculatepay() {
        return commissionRate*totalSales;
    }
}












































