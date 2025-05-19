package co.kr.view;

import co.kr.exception.MenuException;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum InputOption {
    GET_RECOMMEND(1,"메뉴 추천받기"),
    GET_ALL_MENUS(2,"전체 메뉴 보기"),
    EXIT(0,"종료");


    private final Integer value;
    private final String text;

    private InputOption(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static String getAllText() {
        return Arrays.stream(InputOption.values())
                .map(InputOption::getText)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String getText(InputOption inputOption) {
        return String.format( "%d %s", inputOption.value, inputOption.text);
    }

    public static InputOption fromValue(Integer value) {
        return Arrays.stream(values())
                .filter(inputOption -> inputOption.value.equals(value))
                .findAny()
                .orElseThrow(MenuException.NOT_EXIST_OPTION.getExceptionSupplier());
    }

}
