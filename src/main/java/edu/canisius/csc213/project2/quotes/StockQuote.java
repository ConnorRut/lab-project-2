package edu.canisius.csc213.project2.quotes;

public class StockQuote {
    private String Symbol;
    private double ClosePrice;
    private double HighestPrice;
    private double LowestPrice;
    private int NumberOfTransactions;
    private double OpenPrice;
    private double TradingVolume;
    private long TimeStamp;
    public StockQuote(String Symbol, double ClosePrice, double HighestPrice,
                        double LowestPrice, int NumberOfTransactions, 
                        double OpenPrice, long TimeStamp, double TradingVolume){
        this.Symbol = Symbol;
        this.ClosePrice = ClosePrice;
        this.HighestPrice = HighestPrice;
        this.LowestPrice = LowestPrice;
        this.NumberOfTransactions = NumberOfTransactions;
        this.OpenPrice = OpenPrice;
        this.TradingVolume = TradingVolume;
        this.TimeStamp = TimeStamp;
    }
    public String getSymbol(){
        return Symbol;
    }
    public double getClosePrice(){
        return ClosePrice;
    }
    public double getHighestPrice(){
        return HighestPrice;
    }
    public double getLowestPrice(){
        return LowestPrice;
    }
    public int getNumberOfTransactions(){
        return NumberOfTransactions;
    }
    public double getOpenPrice(){
        return OpenPrice;
    }
    public long getTimestamp(){
        return TimeStamp;
    }
    public double getTradingVolume(){
        return TradingVolume;
    }
    public String prettyPrint(){
        return "Symbol: " + Symbol + "\n" +
                "Close Price: " + ClosePrice + "\n" +
                "Highest Price: " + HighestPrice + "\n" +
                "Lowest Price: " + LowestPrice + "\n" +
                "Number of Transactions: " + NumberOfTransactions + "\n" +
                "Open Price: " + OpenPrice + "\n" +
                "Trading Volume: " + TradingVolume + "\n";
    }

}
