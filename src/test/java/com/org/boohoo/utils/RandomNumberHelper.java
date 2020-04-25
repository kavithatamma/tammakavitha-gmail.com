package com.org.boohoo.utils;

import java.util.Random;

public class RandomNumberHelper {
    public int generateRandomNumber(int size) {
        return new Random().nextInt(size );
    }
}
