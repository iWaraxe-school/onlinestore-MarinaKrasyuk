package commands;

import org.xml.sax.SAXException;
import store.Store;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public abstract class Command {
    static Store store;

    public  abstract void execute() throws IOException, ParserConfigurationException, SAXException;
}
