import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
        // Menu items
        Item item1 = new Item("cappucino", 3.50);
        Item item2 = new Item("Mocha", 2.50);
        Item item3 = new Item("Latte", 2.00);
        Item item4 = new Item("Drip Coffee", 1.50);
    
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Cindhuri");
        Order order4 = new Order("Jimmy");
        Order order5 = new Order("Noah");

        order1.addItem(item1);
        order1.addItem(item3);

        order2.addItem(item3);
        order2.addItem(item2);


        System.out.println(" ");
        System.out.println("order before change status/not ready --> "+order2.getStatusMessage());
        // i just tried to set ready method to order2 
        order2.setReady(true);
        // check the status after change
        System.out.println("order after change status/ready  --> "+order2.getStatusMessage());
        System.out.println("Total of order1: $"+order1.getOrderTotal());


     

        order3.addItem(item1);
        order3.addItem(item4);
        order3.addItem(item2);

        order4.addItem(item1);
        order4.addItem(item2);
        order4.addItem(item3);
        order4.addItem(item4);

        order5.addItem(item2);
        order5.addItem(item4);
        

        System.out.println(" ");
        order1.display();
        System.out.println(order1.getStatusMessage());

        System.out.println(" ");
        order2.display();
        System.out.println(order2.getStatusMessage());

        System.out.println(" ");
        order3.display();
        System.out.println(order3.getStatusMessage());

        System.out.println(" ");
        order4.display();
        order4.setReady(true);
        System.out.println(order4.getStatusMessage());

        System.out.println(" ");
        order5.display();
        order5.setReady(true);
        System.out.println(order5.getStatusMessage());
    }
}
