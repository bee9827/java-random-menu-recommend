package co.kr.model;


public class Menu {
    // 생성자를 default가 아닌 정확한 접근제어자를 고민해보세요.
    private final String name;
    private final RecommendTime recommendTime;
    private final Weather weather;

    public Menu(String name, RecommendTime recommendTime, Weather weather) {
        this.name = name;
        this.recommendTime = recommendTime;
        this.weather = weather;
    }

    // 좀더 의미있는 이름으로 변경하면 좋겠습니다. 예를들어 equls 같은 이름.
    public boolean equals(RecommendTime recommendTime, Weather weather) {
        return this.recommendTime.equals(recommendTime)
                && this.weather.equals(weather);
    }

    public String getName() {
        return name;
    }

    public RecommendTime getRecommendTime() {
        return recommendTime;
    }

    public Weather getWeather() {
        return weather;
    }
}
