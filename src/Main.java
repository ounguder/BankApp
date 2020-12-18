public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("National Australia Bank");
        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Ozgun", 50.05);
        bank.addCustomer("Adelaide", "Dilek", 175.34);
        bank.addCustomer("Adelaide", "Utku", 220.12);

        bank.addBranch("Sydney");
        bank.addCustomer("Sydney", "Bob", 150.04);

        bank.addCustomerTransaction("Adelaide", "Ozgun", 34.34);
        bank.addCustomerTransaction("Adelaide", "Utku", 841.24);
        bank.addCustomerTransaction("Adelaide", "Dilek", 4356.54);
        bank.addCustomerTransaction("Adelaide", "Dilek", 2356.54);
        bank.addCustomerTransaction("Adelaide", "Dilek", 356.54);

        bank.listCustomers("Adelaide", true);
    }
}
