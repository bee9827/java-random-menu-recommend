package co.kr.controller;

import co.kr.model.Menu;
import co.kr.model.MenuService;
import co.kr.model.RecommendTime;
import co.kr.model.Weather;
import co.kr.view.InputOption;
import co.kr.view.InputView;
import co.kr.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;
    Map<InputOption, Runnable> inputHandler;

    public Controller(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;

        inputHandler = getInputHandler();
    }

    private Map<InputOption, Runnable> getInputHandler() {
        Map<InputOption, Runnable> handler = new HashMap<>();
        handler.put(InputOption.GET_RECOMMEND, this::getRecommendMenu);
        handler.put(InputOption.GET_ALL_MENUS, this::printAllMenus);

        return handler;
    }

    public void start() {
        InputOption selected;
        //첫 입력이 잘못되면 다시 실행하지 않는다.
        while ((selected = inputView.getOption()) != InputOption.EXIT) {
            try {
                inputHandler.get(selected).run();
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
