package co.kr.controller;

import co.kr.model.Menu;
import co.kr.model.MenuService;
import co.kr.model.RecommendTime;
import co.kr.model.Weather;
import co.kr.view.InputView;
import co.kr.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public Controller(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }

    public void start(){

        while (true){
            int option = inputView.getOption();
            if(option == 1){
                getRecommendMenu();
            }
            else if(option == 2){
                printAllMenus();
            }
            else if(option == 0){
                break;
            }
        }

        inputView.closeScanner();
    }

    public void getRecommendMenu(){
        try {
            RecommendTime recommendTime = RecommendTime.from(inputView.getTime());
            Weather weather = Weather.from(inputView.getWeather());

            Menu recommendMenu = menuService.recommend(recommendTime, weather);
            outputView.printRecommend(recommendMenu);
        }catch (IllegalArgumentException e){
            outputView.printError(e);
        }
    }

    public void printAllMenus(){
        outputView.printAllMenus(menuService.getAllMenus());
    }


}
