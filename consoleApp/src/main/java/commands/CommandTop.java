package commands;

import org.xml.sax.SAXException;
import store.Store;


public class CommandTop extends Command{
    public CommandTop(Store store) {
        super();
    }

    @Override
    public void execute()  {
        store.top();
    }
}
