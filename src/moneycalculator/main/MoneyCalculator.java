
package moneycalculator.main;

import moneycalculator.controller.CalculateCommand;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.persistance.CurrencyListLoader;
import moneycalculator.persistance.ExchangeRateLoader;
import moneycalculator.persistance.csv.CSVCurrencyListLoader;
import moneycalculator.persistance.files.FileCurrencyListLoader;
import moneycalculator.persistance.rest.RestExchangeRateLoader;



public class MoneyCalculator {
 
    public static void main(String[] args){
        CurrencyListLoader currencyLoader = new CSVCurrencyListLoader();
        RestExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        MainFrame mainFrame = new MainFrame(currencyLoader.currencies());
        mainFrame.add( new CalculateCommand( mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), exchangeRateLoader));
    }

  

    

    
}