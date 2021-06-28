package com.springbootmicroservicecurrencyconversionapplication.service;

import com.springbootmicroservicecurrencyconversionapplication.CurrencyConversionBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@FeignClient(name="forex-service")
@RibbonClient(name="forex-service")
@RestController
public interface CurrencyExchangeServiceProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue
            (@PathVariable("from") String from, @PathVariable("to") String to);
}
