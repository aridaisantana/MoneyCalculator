
package moneycalculator.main;

import moneycalculator.controller.CalculateCommand;
import moneycalculator.persistance.csv.CSVCurrencyListLoader;
import moneycalculator.persistance.rest.RestExchangeRateLoader;



public class MoneyCalculator {
 
    public static void main(String[] args){
        CSVCurrencyListLoader currencyLoader = new CSVCurrencyListLoader();
        RestExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        MainFrame mainFrame = new MainFrame(currencyLoader.currencies());
        mainFrame.add( new CalculateCommand( mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), exchangeRateLoader));
    }

  

    

    
}