package edu.canisius.csc213.project2.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.canisius.csc213.project2.quotes.*;


import java.io.IOException;

public class PolygonJsonReplyTranslator {

    public StockQuote translateJsonToFinancialInstrument(String json) throws IOException {
        try{
        ObjectMapper objm = new ObjectMapper();
        JsonNode jsonNode = objm.readTree(json);
        JsonNode results = jsonNode.get("results").get(0);
        String symbol = jsonNode.get("ticker").asText();
        double high = results.get("h").asDouble();
        double low = results.get("l").asDouble();
        double tradingVolume = results.get("v").asDouble();
        long timeStamp = results.get("t").asLong();
        int transactions = results.get("n").asInt();
        double openPrice = results.get("o").asDouble();
        double closePrice = results.get("c").asDouble();
        return new StockQuote(symbol, closePrice, high, low, transactions, openPrice, timeStamp, tradingVolume);
        }catch(Exception e){
            throw e;
        }
    } 
}
