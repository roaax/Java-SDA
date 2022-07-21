public class BanckAccount{
    private double checkingBalance;
    private double savingBalance;
    private static int numberOfAccounts=0;
    private static double totalAmountOfMoney;


    public BanckAccount() {
        numberOfAccounts++;
    }

    public static int getNumberOfAccounts(){
        return numberOfAccounts;
    }
    public static double getTotalAmountOfMoney(){
        return totalAmountOfMoney;
    }
    // Getter
    public double getCheckingBalance(){
        return checkingBalance;
    }
    public double getSavingBalance(){
        return savingBalance;
    }
    // Setter
    public void setCheckingBalance(double checkingBalance){
        this.checkingBalance = checkingBalance;
        // totalAmountOfMoney +=checkingBalance;
    }
    public void setSavingBalance(double savingBalance ){
        this.savingBalance = savingBalance;
        // totalAmountOfMoney +=savingBalance;
    }
    /* method that will allow a user to deposit money into 
    either the checking or saving, be sure to add to total amount stored.*/
    public void deposit(String balance , double amount){
        if (balance.equals("checking")){
            checkingBalance += amount;
            totalAmountOfMoney += amount;

        }else if ( balance.equals("savings")){
            savingBalance += amount;
            totalAmountOfMoney += amount;
        }
    }
    /*method to withdraw money from one balance.
    Do not allow them to withdraw money if there are insufficient funds.*/
        public void withdraw(String balance , double amount){
        if(balance.equals("checking") && checkingBalance >= amount){
            checkingBalance -= amount;
            totalAmountOfMoney -= amount;
        }else if(balance.equals("savings") && savingBalance >= amount){
            savingBalance -= amount;
            totalAmountOfMoney -=amount;
        }else{
            System.out.println("insufficient funds");
        }
        }
        

        // method to see the total money from the checking and saving
        public void total(){
            double totalMoney = checkingBalance+savingBalance;
            System.out.println("---------");
            System.out.println("You have $"+totalMoney+" in your banck account");
        }

        // Another way i tried :
        // public void depositChecking(double amount){
        //     checkingBalance += amount;
        //     totalAmountOfMoney += amount;
        // }
        // public void depositSaving(double amount){
        //     savingBalance += amount;
        //     totalAmountOfMoney += amount;
        // }

        // public void withdrawChecking(double amount){
        //     if(checkingBalance >= amount){
        //         checkingBalance -= amount;
        //         totalAmountOfMoney -= amount;
            
        //     }else{
        //         System.out.println("insufficient funds");
        //     }
        // }
        

        // public void withdrawSaving(double amount){
        // if (savingBalance >= amount){
        //         savingBalance -= amount;
        //         totalAmountOfMoney -=amount;
        //         }else{
        //         System.out.println("insufficient funds");
        //     }


        }
        