package br.com.currencyconverterapi.apicurrencyconverter.application.utils.jsonutil;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonUtil {

    /**
     * Get a json in String format, then get an object and get it atribute
     *
     * @param jsonString String
     * @param obj        String
     * @param atr        String
     * @return
     */
    public static String parseJsonAndGetAtr(String jsonString, String obj, String atr) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Map<String, Object> dataMap = mapper.readValue(jsonString, Map.class);
            Map<String, Object> objMap = (Map<String, Object>) dataMap.get(obj);

            return (String) objMap.get(atr);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing Json " + e.getMessage());
        }
    }
}
