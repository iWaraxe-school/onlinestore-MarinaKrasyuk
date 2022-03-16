package commands;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class CommandQuit extends Command{
    Scanner scanner;
    public CommandQuit(Scanner scaner) {
        super();
        this.scanner=scaner;
    }

    @Override
    public void execute()  {
        scanner.close();

    }
}
