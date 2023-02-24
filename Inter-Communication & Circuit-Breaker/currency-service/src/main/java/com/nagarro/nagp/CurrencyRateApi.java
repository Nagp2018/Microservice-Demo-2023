package com.nagarro.nagp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyRateApi {

    @GetMapping("/conversion-rate")
    public Double getConversionRate(@RequestParam("from") String fromCurrency, @RequestParam("to") String toCurrency) {
       
        Map<String, Double> currencyRates = new HashMap<>();
        currencyRates.put("USD-EUR", 0.824172);
        currencyRates.put("USD-INR", 73.141335);
        currencyRates.put("USD-CAD", 1.262251);
        currencyRates.put("USD-MXN", 20.908591);

        return currencyRates.get(fromCurrency + "-" + toCurrency);
    }
}
