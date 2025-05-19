package co.kr.view;

import co.kr.model.RecommendTime;
import co.kr.model.Weather;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner;


    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int getOption() {
        System.out.print(
                """
                        == 랜덤 점심 메뉴 추천기 ==
                        1. 메뉴 추천받기
                        2. 전체 메뉴 보기
                        0. 종료
                        선택:\s""");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getWeather() {
        String weatherList = Arrays.stream(Weather.values())
                .map(Weather::getName)
                .collect(Collectors.joining(","));

        System.out.printf("날씨 입력 (%s): ", weatherList);

        return scanner.nextLine();
    }

    public String getTime() {
        String timeList = Arrays.stream(RecommendTime.values())
                .map(RecommendTime::getName)
                .collect(Collectors.joining(","));

        System.out.printf("시간대 입력 (%s): ", timeList);

        return scanner.nextLine();
    }

    private String getString(List<String> values) {
        return String.join(", ", values);

    }

    public void closeScanner() {
        scanner.close();
    }

}
