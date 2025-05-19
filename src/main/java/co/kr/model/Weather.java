package co.kr.model;

import java.util.Arrays;

public enum Weather {
    CLOUDY("흐림"),
    SUNNY("맑음"),
    RAINY("비"),
    SNOWY("눈");


    private final String name;

    Weather(String name) {
        this.name = name;
    }

    public static Weather from(String name) {
        return Arrays.stream(Weather.values())
                .filter(weather -> weather.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("날씨에 맞는 메뉴가 없습니다."));
    }

    public String getName() {
        return name;
    }
}