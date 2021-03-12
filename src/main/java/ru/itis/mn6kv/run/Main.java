package ru.itis.mn6kv.run;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.mn6kv.dto.ProductDto;
import ru.itis.mn6kv.util.CsvWriter;
import ru.itis.mn6kv.util.JsonReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String scanningURL = "https://gpsfront.aliexpress.com/getRecommendingResults.do" +
                "?callback=jQuery183048246769344436435_1615212363465" +
                "&widget_id=5547572" +
                "&platform=pc" +
                "&limit=1" +
                "&offset=0" +
                "&productIds2Top=" +
                "&postback=" +
                "&_=1615212370475" +
                "&phase=";
        final String FILEPATH = "src\\main\\resources\\result\\products.csv";
        CsvWriter csvWriter = new CsvWriter(FILEPATH);
        ProductDto product = null;

        JsonFactory factory = new JsonFactory();
        factory.enable(JsonParser.Feature.ALLOW_COMMENTS);

        ObjectMapper objectMapper = new ObjectMapper(factory);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        //записал шапку
        csvWriter.headerWrite();

        //считываю по одному продукту, сразу записываю
        for (int phase = 1; phase < 101; phase++) {
            try {
                product = objectMapper.readValue(JsonReader.readAll(JsonReader.getReader(scanningURL + phase)), ProductDto.class);
                csvWriter.writeToFile(product);
            } catch (IllegalAccessException | IOException e) {
                e.printStackTrace();
            }
        }
        try {
            csvWriter.getBufferedWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
