import java.util.*;

class Customer {
    int customerId;
    String customerName;
    int unitsConsumed;
    double billAmount;

    Customer(int customerId, String customerName, int unitsConsumed) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.unitsConsumed = unitsConsumed;
        this.billAmount = calculateBill(unitsConsumed);
    }

    double calculateBill(int units) {
        double amount;

        if (units <= 100) {
            amount = units * 1.5;
        } else if (units <= 300) {
            amount = (100 * 1.5) + ((units - 100) * 2.5);
        } else {
            amount = (100 * 1.5) + (200 * 2.5) + ((units - 300) * 4);
        }

        return amount;
    }

    void displayBill() {
        System.out.println("\n========== Electricity Bill ==========");
        System.out.println("Customer ID   : " + customerId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Units Used    : " + unitsConsumed);
        System.out.println("Bill Amount   : Rs." + billAmount);
        System.out.println("======================================");
    }
}

public class ElectricityBillingSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Customer> customerList = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Electricity Billing System =====");
            System.out.println("1. Add Customer Bill");
            System.out.println("2. View All Bills");
            System.out.println("3. Search Customer Bill");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addCustomer();
                    break;

                case 2:
                    viewBills();
                    break;

                case 3:
                    searchCustomer();
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);
    }

    static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Units Consumed: ");
        int units = sc.nextInt();

        Customer c = new Customer(id, name, units);
        customerList.add(c);

        System.out.println("Customer Bill Added Successfully!");
    }

    static void viewBills() {

        if (customerList.isEmpty()) {
            System.out.println("No Records Found!");
            return;
        }

        for (Customer c : customerList) {
            c.displayBill();
        }
    }

    static void searchCustomer() {
        System.out.print("Enter Customer ID to Search: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Customer c : customerList) {
            if (c.customerId == id) {
                c.displayBill();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Customer Record Not Found!");
        }
    }
}

