public  class TestBanck{
    public static void main(String[] args) {
        BanckAccount account1 = new BanckAccount();
        BanckAccount account2 = new BanckAccount();

        // account1.setCheckingBalance(100);
        // account1.setSavingBalance(500);

        // account2.setCheckingBalance(300);
        // account2.setSavingBalance(200);
        
        account1.deposit("checking" , 1000);
        account1.deposit("savings" , 700);

        account2.deposit("checking", 500);
        account2.deposit("savings", 100);

        account1.withdraw("checking" , 50);
        
        
        // System.out.println("----------");
        // account1.depositChecking(100);
        // account1.depositSaving(200);
        //account1.withdrawChecking(100);

        //account2.depositChecking(300);
        //account2.withdrawChecking(100);
        //account2.withdrawSaving(5000);


        System.out.println("Account 1 Checking Balance is : "+account1.getCheckingBalance());
        System.out.println("Account 1 Saving Balance is : "+account1.getSavingBalance());
        System.out.println("----------");
        System.out.println("Account 2 Checking Balance is : "+account2.getCheckingBalance());
        System.out.println("Account 2 Saving Balance is : "+account2.getSavingBalance());
        
        System.out.println("----------");
        System.out.println("Total of Banck Accounts : "+BanckAccount.getNumberOfAccounts());
        System.out.println("Total money in the banck : "+BanckAccount.getTotalAmountOfMoney());
        System.out.println("----------");
        System.out.println("Trying to withdraw more than u have in your savaing account : ");
        account2.withdraw("savings", 1000);
        account1.total();
        account2.total();
    }
}
