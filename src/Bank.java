import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;


    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }


    public boolean addBranch(String name) {

        if (findBranch(name) == null) {
            branches.add(new Branch(name));

            return true;


        } else {
            System.out.println("Branch is already in the list");
            return false;
        }

    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch currentBranch = findBranch(branchName);
        if (currentBranch != null) {
            //Displaying is optional
            //System.out.println("New customer = " + customerName + " is added");
            return currentBranch.newCustomer(customerName, initialTransaction);
        } else {
            System.out.println("There is no such a branch in the system!!");
            return false;
        }

    }

    public boolean addCustomerTransaction(String branchName, String customerName, double initialTransaction) {
        if (findBranch(branchName) != null) {
            Branch c = findBranch(branchName);
            c.addCustomerTransaction(customerName, initialTransaction);
            //Displaying is optional
            //System.out.println(" Transactions amount = " + initialTransaction + " was added to " + customerName + "'s account!");
            return true;
        } else {
            System.out.println("There is no such a branch in the system!!");
            return false;
        }

    }

    private Branch findBranch(String branchName) {
        String branchListsItems = "";

        for (Branch b : branches) {
            branchListsItems = b.getName();
            if (branchName.equals(branchListsItems)) {
                return b;
            }
        }
        return null;

    }

    public boolean listCustomers(String branchName, boolean printTransaction) {
        if (findBranch(branchName) != null) {
            Branch b = findBranch(branchName);
            ArrayList<Customer> customerList = b.getCustomers();
            ArrayList<Double> interactionList;
            System.out.println("Customer details " + "for branch " + b.getName());

            for (Customer c : customerList) {// to get the customers in the customerList(arrayList)
                interactionList = c.getTransactions();
                System.out.println("Customer: " + c.getName() + "[" + (customerList.indexOf(c) + 1) + "]");

                if (printTransaction) {
                    System.out.println("Interactions");

                    for (Double d : interactionList) {// to get the transactions in the transactionList(arrayList)

                        System.out.println("[" + (interactionList.indexOf(d) + 1) + "]" + " Amount " + d);
                    }
                }

            }
            return true;
        } else {
            System.out.println("There is no such a branch in the system!!");
            return false;
        }


    }

}
