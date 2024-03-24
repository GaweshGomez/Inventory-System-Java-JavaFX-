package com.example.hello;

import java.util.*;

public class SelectDealer {


    List<dealer> allDealers = DealerReader.readDealersFromFile();

    public static List<dealer> getRandomDealers(List<dealer> dealers, int count) {
        if (count >= dealers.size()) {
            return new ArrayList<>(dealers);
        }

        Set<dealer> randomDealersSet = new HashSet<>();
        Random random = new Random();
        while (randomDealersSet.size() < count) {
            dealer dealer = dealers.get(random.nextInt(dealers.size()));
            randomDealersSet.add(dealer);
        }

        List<dealer> randomDealers = new ArrayList<>(randomDealersSet);

         for (int x = 0; x < randomDealers.size() - 1; x++) {
            for (int j = 0; j < randomDealers.size() - x - 1; j++) {
                if (randomDealers.get(j).getLocation().compareTo(randomDealers.get(j + 1).getLocation()) > 0) {
                    dealer temp = randomDealers.get(j);
                    randomDealers.set(j, randomDealers.get(j + 1));
                    randomDealers.set(j + 1, temp);
                }
            }
        }

        System.out.println(randomDealers);
        return randomDealers;
    }
}


