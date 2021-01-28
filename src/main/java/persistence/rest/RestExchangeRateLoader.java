/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import persistence.ExchangeRateLoader;

/**
 *
 * @author david
 */
public class RestExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            return new ExchangeRate(from,to, read(from.getIsoCode(), to.getIsoCode()));
        } catch (IOException ex) {
            return null;
        }
    }

    private double read(String from, String to) throws IOException {
        String line = read(new URL("http://api.fixer.io/lastest?base="+from+"&symbols"+to));
        return Double.parseDouble(line.substring(line.indexOf(to)+5, line.indexOf("}")));
    }

    private String read(URL url) throws IOException {
        InputStream is = url.openStream();
        byte[] buffer = new byte[1024];       
        int length = is.read(buffer);
        return new String(buffer,0,length);
    }
    
}
