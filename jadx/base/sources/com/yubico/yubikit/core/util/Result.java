package com.yubico.yubikit.core.util;

import java.lang.Throwable;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Result<T, E extends Throwable> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Nullable
    private final E error;

    @Nullable
    private final T value;

    private Result(@Nullable T t, @Nullable E e) {
        this.value = t;
        this.error = e;
    }

    public static <T, E extends Throwable> Result<T, E> failure(E e) {
        return new Result<>(null, e);
    }

    /* JADX INFO: renamed from: of */
    public static <T> Result<T, Exception> m13504of(Callable<T> callable) {
        try {
            return success(callable.call());
        } catch (Exception e) {
            return failure(e);
        }
    }

    public static <T, E extends Throwable> Result<T, E> success(T t) {
        return new Result<>(t, null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends java.lang.Throwable */
    public T getValue() throws E {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw this.error;
    }

    public boolean isError() {
        return this.error != null;
    }

    public boolean isSuccess() {
        return this.value != null;
    }
}
