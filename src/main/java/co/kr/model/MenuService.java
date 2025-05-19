package co.kr.model;

import co.kr.util.MyRandom;

import java.util.List;
import java.util.Random;

public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // 요구사항중에 여러개가 나올 경우 랜덤을 해야 합니다. 해당 요구사항이 충족되지 않았습니다.
    public Menu recommend(RecommendTime recommendTime, Weather weather) {
        List<Menu> recommendedMenus = menuRepository.getAll().stream()
                .filter(menu -> menu.equals(recommendTime, weather))
                .toList();

        Random rand = MyRandom.getInstance();
        return recommendedMenus.get(rand.nextInt(recommendedMenus.size()));
    }

    public List<Menu> getAllMenus() {
        return menuRepository.getAll();
    }
}
