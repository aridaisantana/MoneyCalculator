/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoneyCalculator;

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
        SwingDisplay display = new SwingDisplay( currencies );
        display.display();
    }

    
}