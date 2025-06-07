package co.kr.view;

import co.kr.model.Menu;
import co.kr.model.RecommendTime;
import co.kr.model.Weather;

import java.util.Set;

public record AddMenuDto(
        String name,
        RecommendTime recommendTime,
        Weather weather,
        Set<String> tags
) {
    public Menu toEntity() {
        return new Menu(name, recommendTime, weather, tags);
    }
}
