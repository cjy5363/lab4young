package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class WebServiceCaller {
    public static void main(String[] args) {
        try {
            // Create Pizza objects
            main.Pizza flatPizza = new main.Pizza("Medium", "Cheese", 9.99);
            main.Pizza jsonPizza = new main.Pizza("Large", "Pepperoni", 12.99);

            //URL for server
            URL url = new URL("http://localhost:8080/hello");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            System.out.println("Sent Flat Pizza: " + flatPizza.toFlatString());
            System.out.println("Response Code: " + con.getResponseCode());

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            System.out.println("Server response: " + response);

            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            System.out.println("Sent JSON Pizza: " + jsonPizza.toJsonString());
            System.out.println("Response Code: " + con.getResponseCode());

            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            response = new StringBuilder();
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