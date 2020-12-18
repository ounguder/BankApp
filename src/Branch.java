import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.name = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }


    public boolean newCustomer(String name, double initialTransaction) {

        if (findCustomer(name) == null) {
            this.customers.add(new Customer(name, initialTransaction));


            return true;


        } else {
            System.out.println("Customer is already in the list");
            return false;
        }


    }

    public boolean addCustomerTransaction(String customerName, double transaction) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(transaction);
            return true;
        } else {
            System.out.println("There is no customer called " + customerName + " in the customer list");
            return false;
        }


    }

    private Customer findCustomer(String customerName) {
        String listsItems = "";

        for (Customer c : customers) {
            listsItems = c.getName();
            if (customerName.equals(listsItems)) {
                return c;
            }
        }
        return null;

    }

}
