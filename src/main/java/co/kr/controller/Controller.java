package co.kr.controller;

import co.kr.model.Menu;
import co.kr.model.MenuService;
import co.kr.view.InputOption;
import co.kr.view.InputView;
import co.kr.view.OutputView;
import co.kr.view.RecommendDto;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

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

    public void start() {
        retryWithNoException(() -> handleOption(inputView.getOption()));
        inputView.closeScanner();
    }

    public void printAllMenus() {
        outputView.printAllMenus(menuService.getAllMenus());
    }

    public void getRecommendMenu() {
        RecommendDto recommendDto = inputView.getRecommend();
        Menu recommendMenu = menuService.recommend(recommendDto);

        outputView.printRecommend(recommendMenu);
    }

    public void addMenu() {
        Menu savedMenu = menuService.add(inputView.getMenu());
        outputView.printMenu(savedMenu);
    }

    public void exit() {
        inputView.closeScanner();
        System.exit(0);
    }

    public void handleOption(InputOption selectedOption) {
        inputHandler.get(selectedOption).run();
    }

    private void retryWithNoException(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
            } catch (RuntimeException e) {
                outputView.printError(e);
            }
        }
    }

    private Map<InputOption, Runnable> getInputHandler() {
        Map<InputOption, Runnable> handler = new HashMap<>();
        handler.put(InputOption.GET_RECOMMEND, this::getRecommendMenu);
        handler.put(InputOption.GET_ALL_MENUS, this::printAllMenus);
        handler.put(InputOption.ADD_MENU, this::addMenu);
        handler.put(InputOption.EXIT, this::exit);
        return handler;
    }
}
