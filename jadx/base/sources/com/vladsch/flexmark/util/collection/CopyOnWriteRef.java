package com.vladsch.flexmark.util.collection;

import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CopyOnWriteRef<T> {

    @NotNull
    private final Function<T, T> copyFunction;
    private int referenceCount = 0;

    @Nullable
    private T value;

    public CopyOnWriteRef(@Nullable T t, @NotNull Function<T, T> function) {
        this.value = t;
        this.copyFunction = function;
    }

    @Nullable
    public T getImmutable() {
        T t = this.value;
        if (t != null) {
            this.referenceCount++;
        }
        return t;
    }

    @Nullable
    public T getMutable() {
        if (this.referenceCount > 0) {
            this.value = this.copyFunction.apply(this.value);
            this.referenceCount = 0;
        }
        return this.value;
    }

    @Nullable
    public T getPeek() {
        return this.value;
    }

    public boolean isMutable() {
        return this.referenceCount == 0;
    }

    public void setValue(@Nullable T t) {
        this.referenceCount = 0;
        this.value = this.copyFunction.apply(t);
    }
}
