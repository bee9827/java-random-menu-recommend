package co.kr.view;

import co.kr.model.Menu;

import java.util.List;

public class OutputView {

    public void printError(RuntimeException runtimeException) {
        System.out.println();
        System.out.println(runtimeException.getMessage());
    }

    public void printRecommend(Menu menu) {
        System.out.println();
        System.out.printf(OutputText.RECOMMEND_MENU.getText(), menu.getName());
        printMenu(menu);
    }

    public void printMenu(Menu menu) {
        String tags = String.join(", ", menu.getTags());
        System.out.printf(OutputText.MENU_DETAIL.getText(), menu.getName(), menu.getRecommendTime().toString(), menu.getWeather().toString(),tags);
    }

    public void printAllMenus(List<Menu> allMenus) {
        System.out.println(OutputText.ALL_MENU.getText());
        for (Menu menu : allMenus) {
            printMenu(menu);
        }
    }
}
