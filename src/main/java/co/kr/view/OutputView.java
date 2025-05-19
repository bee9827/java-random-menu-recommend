package co.kr.view;

import co.kr.model.Menu;

import java.util.List;

public class OutputView {

    public void printError(IllegalArgumentException illegalArgumentException){
        System.out.println();
        System.out.println(illegalArgumentException.getMessage());
    }

    public void printRecommend(Menu menu){
        System.out.println();
        System.out.printf("오늘 추천 메뉴는: %s%n",menu.getName());
        printMenu(menu);
    }

    private void printMenu(Menu menu) {
        System.out.printf("이름: %s | 시간대: %s | 날씨: %s %n", menu.getName(), menu.getRecommendTime().toString(), menu.getWeather().toString());
    }

    public void printAllMenus(List<Menu> allMenus) {
        System.out.println("전체 메뉴 목록:");
        for(Menu menu : allMenus){
            printMenu(menu);
        }
    }
}
