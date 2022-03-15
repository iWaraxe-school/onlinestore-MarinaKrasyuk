package http.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.xml.sax.SAXException;
import populator.DBConnector;
import categories.Category;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Objects;

public class CategoryHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        List<Category> categorylist= null;
        try {
            categorylist = new DBConnector().getALLCategory();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper=new ObjectMapper();
        OutputStream stream = null;
        try {
            byte[] json = mapper.writeValueAsBytes(categorylist);
            Headers headers = exchange.getResponseHeaders();
            headers.add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, json.length);
            stream = exchange.getResponseBody();
            stream.write(json);

        }finally {
            if (Objects.nonNull(stream)){
                stream.close();
            }
        }
    }
}
