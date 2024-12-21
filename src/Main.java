import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



    Scanner input=new Scanner(System.in);

        while (true) {
            System.out.println("Welcome! Please choose an option:");
            System.out.println("1- Register");
            System.out.println("2- Login");
            System.out.println("3- Exit");
            int choice = input.nextInt();
            input.nextLine(); // Consume the newline character
            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = input.nextLine();
                System.out.print("Enter password: ");
                String password = input.nextLine();
                User.register(username, password);
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = input.nextLine();
                System.out.print("Enter password: ");
                String password = input.nextLine();
                if (User.login(username, password)) {
                    System.out.println("Login successful!");
                    break; // Proceed to payroll system
                } else {
                    System.out.println("Invalid credentials. Please try again.");
                }
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                return;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }




        PayrollSystem system=new PayrollSystem();
    while(true) {
        System.out.println("welcome to company pay roll system please choose one of the functionalities to continue\n"
             + "1-add employee \t" + "2-remove employee \t" + "3-calculate total payroll \t" + "4-generate payslibs \t"
             + "5-update employee details \t" + "6-single employee functionalities\t" +"7-exit");
    int choice1;
        try{
     choice1=input.nextInt();
    }
    catch (java.util.InputMismatchException e){

             System.out.println("you entered an invalid input please enter another value: ");
            choice1=input.nextInt();


    }
    boolean exit = false;
    switch(choice1) {
    case 1:
        System.out.println("enter the new employee name:");
        String name = input.next();
        System.out.println("enter the new employee id: ");
        int id = input.nextInt();
        System.out.println("enter the payement method: ");
        String p_method = input.next();
        System.out.println("enter the payement details: ");
        String p_details = input.next();
        System.out.println("enter the tax information: ");
        String t_info = input.next();
        Employee e;
        while(true){
        System.out.println("enter the type of the employee: ");
        String type = input.next();
        if ((type.toLowerCase().equals("salaried")) || (type.toLowerCase().equals("salaried employee"))) {
            System.out.println("enter the salary: ");
            double salary = input.nextDouble();
            e = new SalariedEmployee(id, name, p_method, p_details, t_info, salary);
            break;
        } else if ((type.toLowerCase().equals("hourly")) || (type.toLowerCase().equals("hourly employee"))) {
            System.out.println("enter the hourly rate: ");
            double rate = input.nextDouble();
            System.out.println("enter the hours worked: ");
            int hours = input.nextInt();
            e = new HourlyEmployee(id, name, p_method, p_details, t_info, rate, hours);
            break;
        } else if ((type.toLowerCase().equals("commissioned")) || (type.toLowerCase().equals("commissioned employee"))) {
            System.out.println("enter the commission rate: ");
            double c_rate = input.nextDouble();
            System.out.println("enter the total sales: ");
            double sales = input.nextDouble();
            e = new CommissionedEmployee(id, name, p_method, p_details, t_info, c_rate, sales);
            break;
        } else{
           System.out.println("you entered an un-identified input\n"+"please enter again the type of the employee");
        }
        }
        system.addEmployee(e);
        break;
    case 2:
        System.out.println("enter the employee ID: ");
        id=input.nextInt();
        system.removeEmployee(id);
        break;
    case 3:
        system.calculateTotalPayroll();
        break;
    case 4:
        system.generatePayslips();
        break;
    case 5:
        System.out.println("enter the employee id: ");
        id=input.nextInt();
        System.out.println("enter the attribute you want to change: ");
        String attribute=input.next();
        System.out.println("enter the new value of the attribute: ");
        Object value=input.next();
        system.updateEmployeeDetails(id,attribute,value);
        break;
    case 6:
        System.out.println("enter the employee id you want to access: ");
        id=input.nextInt();
        int index=-1;
        while(true) {
            for (int i = 0; i < system.employees.size(); i++) {
                if (system.employees.get(i).getEmployeeId() == id) {
                    index = i;
                    break;
                }
            }
            if(index!=-1)
                break;
            else {
                System.out.println("you entered wrong id please try again: ");
                id = input.nextInt();
            }
        }
      while(true){
          System.out.println("1-generate pay stub \t"+"2-change deduction value \t "+"3-display deduction value \t"+
                  "4-display employee name \t"+"5-change employee name \t"+"6-display payement method \t"+"7-change payement method \t"
                  +"8-display tax information \t"+"9-change tax information \t"+"10-display employee type \t"+
                  "11-display payement details \t"+"12-return to main menu");
          int choice2 =input.nextInt();
         boolean exit2 =false;
         switch (choice2) {
             case 1:
                 system.employees.get(index).generatePayStub();
                 break;
             case 2:
                 System.out.println("enter the new deduction: ");
                 double n_deduction = input.nextDouble();
                 system.employees.get(index).setDeduction(n_deduction);
                 break;
             case 3:
                 System.out.println(system.employees.get(index).getDeduction());
                 break;
             case 4:
                 System.out.println(system.employees.get(index).getName());
                 break;
             case 5:
                 System.out.println("enter the new name: ");
                 String n_name = input.next();
                 system.employees.get(index).setName(n_name);
                 break;
             case 6:
                 System.out.println(system.employees.get(index).getPaymentMethod());
                 break;
             case 7:
                 System.out.println("enter the new payement method: ");
                 String n_pmethod = input.next();
                 system.employees.get(index).setPaymentMethod(n_pmethod);
                 break;
             case 8:
                 System.out.println(system.employees.get(index).getTaxInformation());
                 break;
             case 9:
                 System.out.println("enter the new tax information ");
                 String n_tinfo = input.next();
                 system.employees.get(index).setTaxInformation(n_tinfo);
                 break;
             case 10:
                 System.out.println(system.employees.get(index).getEmployeeType());
                 break;
             case 11:
                 System.out.println(system.employees.get(index).getPaymentDetails());
                 break;
             case 12:
                 exit2 = true;
                 break;
             default:
                 System.out.println("you entered wrong value");
                 break;
         }
         if(exit2){
             break;
         }
      }
    case 7:
        exit=true;
        break;
    }
    if(exit) {
        break;
    }
 }
 System.out.println("thank you for using our company payroll system");
}
}
