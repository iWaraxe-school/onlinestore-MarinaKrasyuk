package http.handler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;


public class CartHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response="Product is added to cart";
        exchange.sendResponseHeaders(200,response.length());
        OutputStream stream= exchange.getResponseBody();
        stream.write(response.getBytes());
        stream.close();

    }
}
