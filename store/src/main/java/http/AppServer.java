package http;

import com.sun.net.httpserver.BasicAuthenticator;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import http.handler.CartHandler;
import http.handler.CategoryHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class AppServer {
    public static HttpServer server;

    public static void startServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(8080),0);
        createContext("/categories",new CategoryHandler());
        createContext("/cart",new CartHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server is started");




    }

    private static void createContext( String s, HttpHandler handler) {
               server.createContext(s,handler).setAuthenticator(new BasicAuthenticator("test") {
                 @Override
                 public boolean checkCredentials(String username, String password) {
                     return username.equals("test") && password.equals("test");
                 }
                 });
    }

}

