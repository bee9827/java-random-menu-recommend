package co.kr.model;

import java.util.Arrays;

public enum RecommendTime {
    BREAKFAST("아침"),
    LUNCH("점심"),
    DINNER("저녁");

    private final String name;

    RecommendTime(String name) {
        this.name = name;
    }

    //Effective Java 아이템 1번 참고하여 이름 변경(컨밴션)
    public static RecommendTime from(String name) {
        return Arrays.stream(RecommendTime.values())
                .filter(recommendTime -> recommendTime.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("시간대에 맞는 메뉴가 없습니다."));
    }

    public String getName() {
        return name;
    }
}
