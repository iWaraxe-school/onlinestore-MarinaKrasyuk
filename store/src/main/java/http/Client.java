package http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import categories.Category;
import store.Store;
import storepopulate.Product;
import java.io.*;
import java.net.*;
import java.util.Base64;
import java.util.List;
import java.util.Map;



public class Client {

    public List<Category> getAllCategories() throws IOException {
        List<Category> result=null;
      HttpURLConnection connection=new Client().getConnection("/categories", HttpMethod.GET);
      String contentType=connection.getHeaderField("Content-Type");
      if (contentType.equals("application/json")) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                result= mapper.readValue(connection.getInputStream(), new TypeReference<List<Category>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }
        }
        else {
            System.out.println("Unexpected content-type");
        }
        return result;
    }
    public void addProductToCart(Product product, Store store){
        HttpURLConnection connection;
        connection=new Client().getConnection("/cart", HttpMethod.PUT);
        connection.setRequestProperty("Content-Type","application/json; utf-8");
        ObjectMapper mapper= new ObjectMapper();
        connection.setDoOutput(true);
        try {
            OutputStream stream= connection.getOutputStream();
            byte[] data= mapper.writeValueAsBytes(store.addToCart(product));
            stream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response =new StringBuilder();
            String response_str=null;
            while((response_str=reader.readLine())!=null){
                response.append(response_str.trim());
            }
            System.out.println(product.getName()+"  " +response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            connection.disconnect();
        }
    }
    public static HttpURLConnection getConnection(String endpoint, HttpMethod method) {
        HttpURLConnection connection=null;
        try {
            URL url = new URL("http", "localhost", 8080, endpoint);
            String authStr = "test:test";
            String credentials = Base64.getEncoder().encodeToString(authStr.getBytes("UTF-8"));

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method.name());
            connection.setRequestProperty("Authorization", "Basic " + credentials);
            return connection;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }



    }





