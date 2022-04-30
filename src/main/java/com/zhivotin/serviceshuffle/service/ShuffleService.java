package com.zhivotin.serviceshuffle.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ShuffleService {

    Random random = new Random();

    public Integer[] getShuffledArray(Integer number) {
        if (number == null || number < 1) {
            return null;
        }

        Integer[] resultArray = new Integer[number];
        for(int i = 0; i < resultArray.length; i++) {
            resultArray[i] = i + 1;
        }
        for(int i = resultArray.length - 1; i >= 1; i--) {
            int randomIndex = random.nextInt(i + 1);
            swap(resultArray, i, randomIndex);
        }
        return  resultArray;
    }

    private void swap(Integer[] array, int ind1, int ind2) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }
}
