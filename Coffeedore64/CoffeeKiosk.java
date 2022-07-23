import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;
    public CoffeeKiosk(){
        menu = new ArrayList<Item>();
        orders = new ArrayList<Order>();
    }

    public ArrayList<Item> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Item> menu) {
        this.menu = menu;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
    
    public void addMenuItem(String name,double price){
        // creat a new object called item
        Item item = new Item(); 
        item.setName(name);
        item.setPrice(price);
        // add the item to the menu arrayList by .add methode
        menu.add(item);
        // also i can do it from the main 
    }

    public void displayMenu(){
        for(int i=0; i<menu.size(); i++){
            System.out.println(i+" "+menu.get(i).getName()+"--"+menu.get(i).getPrice());
            /* this for loop will go throgh all the menu arrayList then will print (name and price)
            for every item we added in the menu*/
        }
    }

    public void newOrder() {
        // here we will create a new order but it will be enterd from the user 
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    	// Your code:
        // Create a new order with the given input string
        // we used .setName this method we already created it in Order.java
        Order order = new Order();
        order.setName(name);
        // Show the user the menu, so they can choose items to add.
        displayMenu();
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            // Get the item object from the menu, and add the item to the order
            //***here */ we have to store into i here inside the loop to store every item that user choose
            int i = Integer.parseInt(itemNumber);
            Item item = menu.get(i);
            // ArrayList<Item> orderItems = order.getItems();
            // orderItems.add(item);
            order.getItems().add(item);
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        System.out.println(order.getName()+" orders details:");
        for (Item item : order.getItems()){
            System.out.println(item.getName()+" "+item.getPrice());
        }
    	// as the example below. You may use the order's display method.
        
    }

    
}
