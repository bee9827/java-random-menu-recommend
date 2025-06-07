package co.kr.model;

import co.kr.exception.MenuException;
import co.kr.view.RecommendDto;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu add(Menu menu) {
        menuRepository.add(menu);
        return menu;
    }

    public Menu recommend(RecommendDto recommendDto) {
        return this.recommend(recommendDto.recommendTime(), recommendDto.weather(), recommendDto.tags());
    }

    public Menu recommend(RecommendTime recommendTime, Weather weather, Set<String> tags) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        List<Menu> recommendedMenus = menuRepository.getAll().stream()
                .filter(menu -> menu.matches(recommendTime, weather, tags))
                .toList();

        if (recommendedMenus.isEmpty()) {
            throw MenuException.NOT_FOUND_MENU.getRuntimeException();
        }

        return recommendedMenus.get(random.nextInt(recommendedMenus.size()));
    }

    public List<Menu> getAllMenus() {
        return menuRepository.getAll();
    }
}
