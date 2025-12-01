class Account {
    private String owner;
    private int balance;
    private int accountNumber;

    public Account(String owner, int balance, int accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
    public void transfer(int amount) throws NotEnoughMoneyException {
        if (amount > this.balance) {
            throw new NotEnoughMoneyException("Transfer failed");
        }
        this.balance -= amount;
        System.out.println("Transfer successful. New balance: " + this.balance);
    }
    public int getBalance() {
        return this.balance;
    }
    public String getOwner() {
        return this.owner;
    }
    public int getAccountNumber() {
        return this.accountNumber;
    }
}

