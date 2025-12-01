public class Maintask2 {
    public static void main(String[] args) {
        Account myAccount = new Account("Mykyta Yevchuk", 1000, 123456);

        try {
            System.out.println("Attempting to transfer 5000");
            myAccount.transfer(5000);

        } catch (NotEnoughMoneyException e) {
            System.out.println("--- Specific Catch ---");
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("--- Generic Catch---");
            System.out.println("Some other error: " + e.toString());

        } finally {
            System.out.println("--- Finally ---");
            System.out.println("Current Account Balance: " + myAccount.getBalance());
        }
    }
}
