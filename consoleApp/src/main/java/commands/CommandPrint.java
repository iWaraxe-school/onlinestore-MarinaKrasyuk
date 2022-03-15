package commands;

import store.Store;

public class CommandPrint extends Command{

    public CommandPrint(Store store) {
        this.store=store;
    }
    @Override
    public  void execute(){
        store.printStore();
    }
}
