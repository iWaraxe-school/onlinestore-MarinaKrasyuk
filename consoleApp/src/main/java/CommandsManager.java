import commands.*;
import org.xml.sax.SAXException;
import store.Store;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandsManager {
    Store store;
    List<Command> commands;
    Scanner scaner;
    CommandsManager(Store store, Scanner scaner){
        this.scaner=scaner;
        this.store=store;
        this.commands= Arrays.asList(
                new CommandPrint(store),
                new CommandSort(store),
                new CommandTop(store),
                new CommandCreateOrder(store, scaner),
                new CommandQuit(scaner));

    }
    public void init() throws IOException, ParserConfigurationException, SAXException {
       boolean flag=true;
       while (flag){
           showMenu();
           int command=scaner.nextInt();
           if (command>commands.size()|| command<=0){
               System.out.println("Incorrect input");
               init();
           }
           else {
               if (command==5){
                   flag=false;
               }
               commands.get(command-1).execute();
           }
       }


    }

    private void showMenu() {
        System.out.println("Enter command");
        System.out.println("1- Print Store");
        System.out.println("2- Sort");
        System.out.println("3 - Top of product");
        System.out.println("4 - Create order");
        System.out.println("5 -Exit ");






    }
}
