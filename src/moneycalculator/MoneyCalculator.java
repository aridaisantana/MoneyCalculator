/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */

public class MoneyCalculator {
 
    public static void main(String[] args) throws IOException{
        
        CSVCurrencyCreator create = new CSVCurrencyCreator();
        Currency [] currencies = create.create();
        
        String fromS,toS;
        Currency from = null;
        Currency to = null;

               
        System.out.println("Introduce una cantidad : ");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        Money money = new Money( amount, currencies[1]);
        
        System.out.println("Introduce una divisa inicial");
        fromS = scanner.next();
        
        for (int i = 0; i < currencies.length; i++) {
            if(currencies[i].getName().equals(fromS)){
                from = currencies[i];
            }
        }
        
        System.out.println("Introduce otra divisa: ");
        toS = scanner.next();
        
        for (int i = 0; i < currencies.length; i++) {
            if(currencies[i].getName().equals(toS)){
                to = currencies[i];
            }
        }
        
        ExchangeRate exchangerate = new ExchangeRate();
        double exchangeRate = exchangerate.getExchangeRate(from, to);
        
        double result = money.getAmount() * exchangeRate;
        System.out.println("Conversión:" + result );
    }

    
}