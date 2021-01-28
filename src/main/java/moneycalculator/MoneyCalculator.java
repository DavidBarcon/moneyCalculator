package moneycalculator;

import moneycalculator.control.CalculateCommand;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;
import persistence.CurrencyListLoader;
import persistence.ExchangeRateLoader;
import persistence.file.FileCurrencyListLoader;
import persistence.rest.RestExchangeRateLoader;

public class MoneyCalculator {

    


    
    private Money money;
    private ExchangeRate exchangeRate;
    private Currency currencyFrom;
    private Currency currencyTo;
    
    public static void main(String[] args){
            CurrencyListLoader currencyLoader = new FileCurrencyListLoader("currencies");
            ExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
                    
            MoneyCalculatorFrame mainFrame = new MoneyCalculatorFrame(currencyLoader.currencies());
            mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(),exchangeRateLoader));
    
    }
}    
    
    

    
    

    
