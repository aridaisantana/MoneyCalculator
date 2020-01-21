/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author usuario
 */
public class ExchangeRate {
    
    private final Currency from;
    private final Currency to;
    private final double amount;
    
    public ExchangeRate( Currency from, Currency to, double amount){
        
        this.from = from;
        this.to = to;
        this.amount = amount;
        
    }
    
    public Currency getFrom(){
        return from;
    }
    
    public Currency getTo(){
        return to;
    }
    
    public double getAmount(){
        return amount;
    }
 
    public double getExchangeRate(Currency from, Currency to) throws IOException {
        URL url = 
            new URL("https://free.currconv.com/api/v7/convert?q=" +
                    from.getName() + "_" + to.getName() + "&compact=ultra&apiKey=a600768752b260e45e04");
        URLConnection connection = url.openConnection();
        try (BufferedReader reader = 
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            String line1 = line.substring(11, line.indexOf("}"));
            return Double.parseDouble(line1);
        }
    }
 }

