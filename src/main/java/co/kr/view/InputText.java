package co.kr.view;

import java.util.List;

public enum InputText {
    SELECT_OPTION(
            """
                    == 랜덤 점심 메뉴 추천기 ==
                    %s
                    선택:\s"""),
    GET_WEATHER("날씨 입력 (%s): "),
    GET_RECOMMEND_TIME("시간대 입력 (%s): ");

    private final String text;

    InputText(String text) {
        this.text = text;
    }

    public String getFormedText(List<String> list) {
        return getFormedText(getJoining(list));
    }

    public String getFormedText(String list) {
        return String.format(text, list);
    }

    private String getJoining(List<String> list) {
        return String.join(", ", list);
    }
}
