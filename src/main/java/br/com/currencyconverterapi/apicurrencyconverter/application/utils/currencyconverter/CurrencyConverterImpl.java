package br.com.currencyconverterapi.apicurrencyconverter.application.utils.currencyconverter;

import br.com.currencyconverterapi.apicurrencyconverter.domain.dto.TransactionCreateDto;
import br.com.currencyconverterapi.apicurrencyconverter.application.utils.jsonutil.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
public class CurrencyConverterImpl implements CurrencyConverter {

    private final String url = "https://economia.awesomeapi.com.br/json/last/";

    @Override
    public double convertTo(TransactionCreateDto transactionDto) {
        log.info("Consult apilayer to get conversionRate - BEGIN");
        String originCurrency = String.valueOf(transactionDto.originCurrency());
        String destinationCurrency = String.valueOf(transactionDto.destinationCurrency());

        String uri = originCurrency +
                "-" + destinationCurrency;

        String response = WebClient
                .create(url)
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class).block();

        String obj = originCurrency + destinationCurrency;

        double conversionRate = Double.parseDouble(
                JsonUtil.parseJsonAndGetAtr(response, obj, "high")
        );
        log.info("Consult apilayer to ger conversionRate - END");
        return conversionRate;
    }
}
