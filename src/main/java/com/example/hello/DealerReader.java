package com.example.hello;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DealerReader {

    public static List<dealer> readDealersFromFile() {
        List<dealer> dealers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("dealers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length == 4) {
                    String dealerId = attributes[0].trim();
                    String dealerName = attributes[1].trim();
                    String phone = attributes[2].trim();
                    String location = attributes[3].trim();

                    dealer dealer = new dealer(dealerId, dealerName, phone, location);
                    dealers.add(dealer);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(dealers);

        return dealers;
    }
}



