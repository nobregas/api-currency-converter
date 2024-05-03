package br.com.currencyconverterapi.apicurrencyconverter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ApiCurrencyConverterApplication {

    public static void main(String[] args) {
        log.info("application start - BEGIN");
        SpringApplication.run(ApiCurrencyConverterApplication.class, args);
        log.info("application start - END");
    }

}
