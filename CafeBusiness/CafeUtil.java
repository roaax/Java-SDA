import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal(){
        int sum = 0;
        for(int i = 1; i <=10; i++){
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double sum = 0.0;
        for(int i = 0; i<prices.length;i++){
            sum += prices[i];
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for(int i = 0;i<menuItems.size();i++){
            System.out.println(i+" "+menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name: ");
        String userName = System.console().readLine();
        System.out.println(String.format("Hello, %s!",userName));
        System.out.println(String.format("There are %s people in front of you",customers.size()));
        customers.add(userName);
        System.out.println(customers);
    }
}