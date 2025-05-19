package co.kr.exception;

import java.util.function.Supplier;

public enum MenuException {
    NOT_FOUND_RECOMMEND_TIME(new IllegalArgumentException("시간대에 맞는 메뉴가 없습니다.")),
    NOT_FOUND_WEATHER(new IllegalArgumentException("날씨에 맞는 메뉴가 없습니다.")),
    NOT_FOUND_MENU(new IllegalStateException("조건에 맞는 메뉴가 없습니다."));


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
