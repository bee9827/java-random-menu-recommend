package co.kr.util;

import java.util.Random;

public class MyRandom {
    private static final Random INSTANCE = new Random();

    public static Random getInstance() {
        return INSTANCE;
    }


}
