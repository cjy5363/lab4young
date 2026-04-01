package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebServiceCaller {
    public static void main(String[] args) {
        try {
            // Flat Pizza
            String flatPizza = "Medium,Cheese,9.99";
            // JSON Pizza
            String jsonPizza = "{size:Large,toppings:Pepperoni,price:12.99}";

            // URL
            URL url = new URL("http://localhost:8080/hello");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();


            con.setRequestMethod("POST");
            con.setDoOutput(true);

            // Send Flat Pizza
            OutputStream os = con.getOutputStream();
            os.write(flatPizza.getBytes());
            os.close();

            // Get response code
            int responseCode = con.getResponseCode();
            System.out.println("Sent Flat Pizza: " + flatPizza);
            System.out.println("Response Code: " + responseCode);

            // Send JSON Pizza
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            os = con.getOutputStream();
            os.write(jsonPizza.getBytes());
            os.close();

            responseCode = con.getResponseCode();
            System.out.println("Sent JSON Pizza: " + jsonPizza);
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}