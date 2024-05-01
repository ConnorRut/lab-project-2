package edu.canisius.csc213.project2.quotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.*;

import edu.canisius.csc213.project2.util.*;

public class PolygonStockQuoteProvider implements StockQuoteProvider{
    /*
     * The method is expected to return a well formed URL to contact a quote provider.
     * For example, if you provided:
     * 
     * symbol - AAPL
     * date   - 2023-01-09
     * key    - yourKey
     * 
     * It would reply with: 
     * https://api.polygon.io/v2/aggs/ticker/AAPL/range/1/day/2023-01-09/2023-01-09?apiKey=yourKey
     */
    public String getEndpointUrl(String symbolName, String date, String apiKey){
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(date);
        if(!m.find()){
            throw new IllegalArgumentException();
        }
        return "https://api.polygon.io/v2/aggs/ticker/" + symbolName + "/range/1/day/" + date + "/" + date + "?apiKey=" + apiKey;
    }
    @Override
    public StockQuote getStockQuote(String stockQuoteEndpoint) throws IOException {
        String json = sendGetRequest(stockQuoteEndpoint);
        PolygonJsonReplyTranslator jft = new PolygonJsonReplyTranslator();
        return jft.translateJsonToFinancialInstrument(json);
        
    }

    public static String sendGetRequest(String endpointUrl) throws IOException {
        URL obj = new URL(endpointUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Set the request method to GET
        con.setRequestMethod("GET");

        // Get the response code
        int responseCode = con.getResponseCode();

        // If the response code is not 200 (OK), throw an exception
        if (responseCode != 200) {
            throw new RuntimeException("Failed to get response from server. Response code: " + responseCode);
        }

        // Create a BufferedReader to read the response from the connection's input stream
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        // Read the response line by line and append it to the StringBuilder
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        con.disconnect();
        return response.toString();
    }

}
