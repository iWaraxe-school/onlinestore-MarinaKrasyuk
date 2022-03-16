package commands;

import org.xml.sax.SAXException;
import store.Store;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CommandSort extends Command{
    public CommandSort(Store store) {
        super();
    }

    @Override
    public void execute() throws IOException, ParserConfigurationException, SAXException {
        store.sortProduct();
    }
}
