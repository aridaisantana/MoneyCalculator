/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator.persistance.csv;

import moneycalculator.model.Currency;
import moneycalculator.model.Currency;
import java.io.BufferedReader;
import java.io.FileReader;
import moneycalculator.persistance.CurrencyListLoader;

/**
 *
 * @author usuario
 */
public class CSVCurrencyListLoader implements CurrencyListLoader { 

    @Override
    public Currency[] currencies() {
        Currency [] currencies = new Currency [3];
        int i = 0;
        try {
         BufferedReader br = new BufferedReader(new FileReader("currencies.csv"));
         String line = br.readLine();
         while (null!=line) {
             String [] fields = line.split(",");
             Currency currency = new Currency((fields[0]), fields[1], fields[2]);
             currencies[i] = currency;
             i++;
             line = br.readLine();
         }
         br.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
      } 
        return currencies;
    }
    
}
