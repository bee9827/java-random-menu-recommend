package co.kr.model;

import java.util.Arrays;
import java.util.List;


// 왜라는 이유를 찾는것은 어려움
// 내가 혼자 찾기 어려워 하는것을 지피티에게 물어보자.
// 지피티에게 물어보면 좀 알려준다. -> 근거 및 문서를 출처를 물어본다.(확실하지 않기 때문에 출처를 무조건 봐야한다. -> 공식 문서 가져와)
// ai가 피드백을 줄 수 있도록

public class MenuRepository {
    private static final List<Menu> menus = getDefaultMenus();

    private static List<Menu> getDefaultMenus() {
        return Arrays.asList(
                new Menu("김치찌개", RecommendTime.LUNCH, Weather.CLOUDY),
                new Menu("비빔밥", RecommendTime.LUNCH, Weather.SUNNY),
                new Menu("우동", RecommendTime.DINNER, Weather.SNOWY),
                new Menu("돈까스", RecommendTime.LUNCH, Weather.SUNNY),
                new Menu("불고기덮밥", RecommendTime.LUNCH, Weather.CLOUDY),
                new Menu("라면", RecommendTime.LUNCH, Weather.RAINY),
                new Menu("짬뽕", RecommendTime.LUNCH, Weather.SNOWY),
                new Menu("샐러드", RecommendTime.LUNCH, Weather.SUNNY),
                new Menu("떡볶이", RecommendTime.LUNCH, Weather.RAINY),
                new Menu("치킨", RecommendTime.DINNER, Weather.CLOUDY));
    }

    public List<Menu> getAll() {
        return menus;
    }

    public void addAll(List<Menu> addMenus) {
        for (Menu menu : addMenus) {
            add(menu);
        }
    }

    public void add(Menu menu) {
        menus.add(menu);
    }


}
