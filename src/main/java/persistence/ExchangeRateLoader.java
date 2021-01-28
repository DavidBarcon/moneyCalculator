/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;

/**
 *
 * @author david
 */
public interface ExchangeRateLoader {
    public ExchangeRate load(Currency from, Currency to);
    
}
