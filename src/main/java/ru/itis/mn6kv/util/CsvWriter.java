package ru.itis.mn6kv.util;

import ru.itis.mn6kv.dto.ProductDto;
import lombok.Getter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

@Getter
public class CsvWriter {

    private BufferedWriter bufferedWriter;

    public CsvWriter(String filepath) {
        try {
            this.bufferedWriter = new BufferedWriter(new FileWriter(new File(filepath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void headerWrite() {
        Class<ProductDto> productClass = ProductDto.class;
        for (Field field : productClass.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                bufferedWriter.write(field.getName() + ", ");
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(ProductDto product) throws IllegalAccessException, IOException {
        for (Field field : product.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.get(product) != null)
                bufferedWriter.write(field.get(product).toString() + ", ");
            else
                bufferedWriter.write("null, ");
            System.out.println(field.get(product));
            bufferedWriter.flush();
        }
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
}
