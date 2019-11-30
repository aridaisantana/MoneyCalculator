
package moneycalculator;


public class Currency {
    
    private final int code;
    private final String name;
    private final String symbol;
    
    public Currency( int code, String name, String symbol){
    
        this.code = code;
        this.name = name;
        this.symbol = symbol;

    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
    
}