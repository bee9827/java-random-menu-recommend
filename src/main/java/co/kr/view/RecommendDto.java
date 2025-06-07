package co.kr.view;


import co.kr.model.RecommendTime;
import co.kr.model.Weather;

import java.util.Set;

public record RecommendDto(
        RecommendTime recommendTime,
        Weather weather,
        Set<String> tags) {
}
