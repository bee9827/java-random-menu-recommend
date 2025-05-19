package co.kr;

import co.kr.controller.Controller;
import co.kr.model.MenuRepository;
import co.kr.model.MenuService;
import co.kr.view.InputView;
import co.kr.view.OutputView;

public class RandomMenuRecommendation {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MenuService menuService = new MenuService(new MenuRepository());


        Controller controller = new Controller(inputView, outputView, menuService);
        controller.start();
    }
}