package co.kr.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


// 왜라는 이유를 찾는것은 어려움
// 내가 혼자 찾기 어려워 하는것을 지피티에게 물어보자.
// 지피티에게 물어보면 좀 알려준다. -> 근거 및 문서를 출처를 물어본다.(확실하지 않기 때문에 출처를 무조건 봐야한다. -> 공식 문서 가져와)
// ai가 피드백을 줄 수 있도록

public class MenuRepository {
    private static final List<Menu> menus = getDefaultMenus();

    private static List<Menu> getDefaultMenus() {
        List<Menu> menus = new ArrayList<>();
        menus.addAll(Arrays.asList(
                new Menu("김치찌개", RecommendTime.LUNCH, Weather.CLOUDY, Set.of("매콤", "김치")),
                new Menu("비빔밥", RecommendTime.LUNCH, Weather.SUNNY, Set.of("한식")),
                new Menu("우동", RecommendTime.DINNER, Weather.SNOWY, Set.of("면", "뜨끈")),
                new Menu("돈까스", RecommendTime.LUNCH, Weather.SUNNY, Set.of("돼지고기"))
        ));

        return menus;
    }

    public List<Menu> getAll() {
        return List.copyOf(menus);
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
