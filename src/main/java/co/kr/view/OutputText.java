package co.kr.view;

public enum OutputText {
    RECOMMEND_MENU("오늘 추천 메뉴는: %s%n"),
    MENU_DETAIL("이름: %s | 시간대: %s | 날씨: %s %n"),
    ALL_MENU("전체 메뉴 목록:");

    private final String text;

    OutputText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
