package co.kr.view;

public enum InputText {
    DELIMITER(", "),
    CHOOSE_OPTION("""
                        == 랜덤 점심 메뉴 추천기 ==
                        1. 메뉴 추천받기
                        2. 전체 메뉴 보기
                        0. 종료
                        선택:\s"""),
    GET_WEATHER("날씨 입력 (%s): "),
    GET_RECOMMEND_TIME("시간대 입력 (%s): ");

    private final String text;

    InputText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
