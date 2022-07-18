import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
    public static void main(String[] args){
        CafeUtil coffeeApp = new CafeUtil();
        int reward = coffeeApp.getStreakGoal();
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n",reward);

        double[] prices = {13.5, 9.8, 20.5, 8.1, 9.0};
        double total = coffeeApp.getOrderTotal(prices);
        System.out.println("\n----- Order Total Test -----");
        System.out.printf("Order total: %s \n\n", total);

        ArrayList<String> items = new ArrayList<String>();
        items.add("Latte");
        items.add("Cap");
        items.add("Drip");
        System.out.println("\n----- Display Menu Test -----");
        coffeeApp.displayMenu(items);
        
        ArrayList<String> customers = new ArrayList<String>();
        customers.add("Nathan");
        customers.add("Roaa");
        System.out.println("\n----- Add Customer Test -----");
        for (int i = 0; i < 4; i++) {
            coffeeApp.addCustomer(customers);
            System.out.println("\n");
            }
        
    }
}