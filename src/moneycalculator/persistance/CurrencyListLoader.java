/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator.persistance;

import moneycalculator.model.Currency;

/**
 *
 * @author aridai
 */
public interface CurrencyListLoader {
    Currency[] currencies();
    
}
