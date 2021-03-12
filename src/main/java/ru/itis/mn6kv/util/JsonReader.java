package ru.itis.mn6kv.util;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JsonReader {

    public static Reader getReader(String url) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream(), StandardCharsets.UTF_8));
            return reader;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String readAll(Reader reader) {
        StringBuilder sb = new StringBuilder();
        int cp;
        try {
            for (int j = 0; j < 128; j++)
                reader.read();
            while ((cp = reader.read()) != -1)
                sb.append((char) cp);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return sb.toString();
    }
}