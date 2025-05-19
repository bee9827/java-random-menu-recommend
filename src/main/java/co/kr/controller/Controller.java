package co.kr.controller;

import co.kr.model.Menu;
import co.kr.model.MenuService;
import co.kr.model.RecommendTime;
import co.kr.model.Weather;
import co.kr.view.InputView;
import co.kr.view.InputOption;
import co.kr.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;
    Map<InputOption, Runnable> functions;

    public Controller(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;

        functions = getFunctions();
    }

    private Map<InputOption, Runnable> getFunctions() {
        Map<InputOption, Runnable> functions = new HashMap<>();
        functions.put(InputOption.GET_RECOMMEND, this::getRecommendMenu);
        functions.put(InputOption.GET_ALL_MENUS, this::printAllMenus);

        return functions;
    }

    public void start() {
        InputOption selected;
        while ((selected = inputView.getOption()) != InputOption.EXIT) {
            try {
                functions.get(selected).run();
            } catch (RuntimeException e) {
                outputView.printError(e);
            }
        }

    }

    public void getRecommendMenu() {
        RecommendTime recommendTime = inputView.getRecommendTime();
        Weather weather = inputView.getWeather();

        Menu recommendMenu = menuService.recommend(recommendTime, weather);
        outputView.printRecommend(recommendMenu);
    }

    public void printAllMenus() {
        outputView.printAllMenus(menuService.getAllMenus());
    }

}
