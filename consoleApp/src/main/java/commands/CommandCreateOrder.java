package commands;
import populator.HttpPopulator;
import populator.Populator;
import store.Store;
import storepopulate.Product;
import java.util.Scanner;


public class CommandCreateOrder extends Command{
    Scanner scanner;
    public CommandCreateOrder(Store store, Scanner scaner) {
        super();
        this.scanner=scaner;

    }

    @Override
    public void execute()  {
        Populator populator= new HttpPopulator();
        boolean  doorder=true;
        while (doorder){
            System.out.println("Write name of order");
            switch (scanner.nextLine()){
                case "finish order":
                    doorder=false;
                    System.out.println("Order completed");
                    store.getTrash().clearTrash();
                    break;
                default:
                    String name= scanner.nextLine();
                    Product findproduct = store.findProduct(name);
                    populator.addToCart(findproduct,store);
            }}
    }
}
