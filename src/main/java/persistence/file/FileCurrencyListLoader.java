/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import moneycalculator.model.Currency;
import persistence.CurrencyListLoader;

/**
 *
 * @author david
 */
public class FileCurrencyListLoader implements CurrencyListLoader {
    private final String fileName; 

    public FileCurrencyListLoader(String fileName) {
        this.fileName = fileName;
    }

    private Currency currencyOf(String line) {
        String[] splitedData = line.split(",");
        return new Currency(splitedData[0], splitedData[1], splitedData[2]);
    }    
    
    @Override
    public Currency[] currencies() {
        List<Currency> list = new ArrayList<>();
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File(this.fileName)));
            while(true){
                String line = reader.readLine();
                if (line == null) break;
                list.add(currencyOf(line));
            }
        }catch (FileNotFoundException exeption) {
            
        }catch (IOException exeption){
            
        }
        
        return list.toArray(new Currency[0]);
    }


    
}
