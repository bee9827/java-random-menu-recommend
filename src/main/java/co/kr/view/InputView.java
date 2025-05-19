package co.kr.view;

import co.kr.model.RecommendTime;
import co.kr.model.Weather;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;


    public InputView() {
        scanner = new Scanner(System.in);
    }

    public InputOption getOption() {
        System.out.print(InputText.SELECT_OPTION.getFormedText(InputOption.getAllText()));
        return InputOption.fromValue(Integer.parseInt(scanner.nextLine()));
    }

    public Weather getWeather() {
        List<String> weatherList = Arrays.stream(Weather.values())
                .map(Weather::getName)
                .toList();

        System.out.print(InputText.GET_WEATHER.getFormedText(weatherList));

        return Weather.from(scanner.nextLine());
    }

    public RecommendTime getRecommendTime() {
        List<String> recommendTimeList = Arrays.stream(RecommendTime.values())
                .map(RecommendTime::getName)
                .toList();

        System.out.print(InputText.GET_RECOMMEND_TIME.getFormedText(recommendTimeList));

        return RecommendTime.from(scanner.nextLine());
    }

    public void closeScanner() {
        scanner.close();
    }

}
