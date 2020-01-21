/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator.persistance.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.persistance.ExchangeRateLoader;

/**
 *
 * @author aridai
 */
public class RestExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Currency from, Currency to){
        ExchangeRate result = null;
        try {
           result = new ExchangeRate(from, to, read(from.getCode(), to.getCode()));
        } catch (IOException ex) {
       
        }
        
      return result;
    }

    private double read(String from, String to) throws IOException{
        URL url = 
            new URL("https://free.currconv.com/api/v7/convert?q=" +
                    from + "_" + to + "&compact=ultra&apiKey=a600768752b260e45e04");
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
