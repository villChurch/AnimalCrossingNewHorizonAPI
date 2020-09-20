package com.williamspires.acnhapi.Utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WebPageDownloader {

    public List<String> getPageInfo(String urlAddress) {
        log.info("Url is {}", urlAddress);
        List<String> info = new ArrayList<>();
        URL url;
        InputStream is = null;
        try {
            url = new URL(urlAddress);
            is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                info.add(line.toLowerCase());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
        return info;
    }

    public void writeToFile(List<String> missingItems, String code) {
        code = code +".txt";
        try {
            FileWriter writer = new FileWriter(code);
            for(String item: missingItems) {
                writer.write(item + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
