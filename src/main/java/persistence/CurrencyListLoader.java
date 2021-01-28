/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import moneycalculator.model.Currency;

/**
 *
 * @author david
 */
public interface CurrencyListLoader {
    public Currency[] currencies();
}
