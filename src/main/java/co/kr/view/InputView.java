package co.kr.view;

import co.kr.model.RecommendTime;
import co.kr.model.Weather;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner;


    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int getOption() {
        System.out.print(InputText.CHOOSE_OPTION.getText());
        return Integer.parseInt(scanner.nextLine());
    }

    public String getWeather() {
        String weatherList = Arrays.stream(Weather.values())
                .map(Weather::getName)
                .collect(getJoining());

        System.out.printf(InputText.GET_WEATHER.getText(), weatherList);

        return scanner.nextLine();
    }

    public String getTime() {
        String timeList = Arrays.stream(RecommendTime.values())
                .map(RecommendTime::getName)
                .collect(getJoining());

        System.out.printf(InputText.GET_RECOMMEND_TIME.getText(), timeList);

        return scanner.nextLine();
    }

    @NotNull
    private Collector<CharSequence, ?, String> getJoining() {
        return Collectors.joining(InputText.DELIMITER.getText());
    }

    public void closeScanner() {
        scanner.close();
    }

}
