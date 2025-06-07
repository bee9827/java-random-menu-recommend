package co.kr.exception;

import java.util.function.Supplier;

public enum MenuException {
    NOT_FOUND_RECOMMEND_TIME(new IllegalArgumentException("시간대를 잘못 입력 하였습니다.")),
    NOT_FOUND_WEATHER(new IllegalArgumentException("날씨를 잘못 입력 하였습니다.")),
    NOT_FOUND_MENU(new IllegalStateException("조건에 맞는 메뉴가 없습니다.")),
    NOT_EXIST_OPTION(new IllegalArgumentException("보기에 없는 값입니다.")),
    NUMBER_FORMAT_EXCEPTION(new IllegalArgumentException("잘못된 값입니다. 숫자만 입력해 주세요"));


    private final RuntimeException runtimeException;

    MenuException(final RuntimeException runtimeException) {
        this.runtimeException = runtimeException;
    }

    public RuntimeException getRuntimeException() {
        return runtimeException;
    }

    public Supplier<RuntimeException> getExceptionSupplier() {
        return () -> runtimeException;
    }
}
