package co.kr.view;

import co.kr.model.Menu;
import co.kr.model.RecommendTime;
import co.kr.model.Weather;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner;


    public InputView() {
        scanner = new Scanner(System.in);
    }

    public InputOption getOption() {
        System.out.print(InputText.SELECT_OPTION.getFormedText(InputOption.getAllText()));
        return InputOption.fromValue(Integer.parseInt(scanner.nextLine()));
    }

    public RecommendDto getRecommend() {
        return new RecommendDto(getRecommendTime(),getWeather(),getTags());
    }

    public Menu getMenu() {
        String name = getMenuName();
        Weather weather = getWeather();
        RecommendTime recommendTime = getRecommendTime();
        Set<String> tag = getTags();
        return new Menu(name, recommendTime, weather, tag);
    }

    private Set<String> getTags() {
        System.out.print(InputText.GET_TAG.getText());
        String tags = scanner.nextLine();

        return Arrays.stream(tags.split(","))
                .map(String::trim)
                .collect(Collectors.toSet());
    }

    private String getMenuName() {
        System.out.print(InputText.GET_MENU_NAME.getText());
        return scanner.nextLine();
    }

    private Weather getWeather() {
        List<String> weatherList = Arrays.stream(Weather.values())
                .map(Weather::getName)
                .toList();

        System.out.print(InputText.GET_WEATHER.getFormedText(weatherList));

        return Weather.from(scanner.nextLine());
    }

    private RecommendTime getRecommendTime() {
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
