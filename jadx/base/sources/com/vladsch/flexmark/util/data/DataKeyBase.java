package com.vladsch.flexmark.util.data;

import androidx.appcompat.widget.AbstractC0541b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class DataKeyBase<T> implements MutableDataValueSetter<T> {
    private final T defaultValue;

    @NotNull
    private final DataValueFactory<T> factory;

    @NotNull
    private final String name;

    public DataKeyBase(@NotNull String str, T t, @NotNull DataValueFactory<T> dataValueFactory) {
        this.name = str;
        this.defaultValue = t;
        this.factory = dataValueFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$0(Object obj, DataHolder dataHolder) {
        return obj;
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public T get(@Nullable DataHolder dataHolder) {
        return dataHolder == null ? this.defaultValue : (T) dataHolder.getOrCompute(this, new C11847c(this, 0));
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    @NotNull
    public DataValueFactory<T> getFactory() {
        return this.factory;
    }

    @Deprecated
    public final T getFrom(@Nullable DataHolder dataHolder) {
        return get(dataHolder);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        T t = this.defaultValue;
        return t != null ? AbstractC0541b.m774p("NullableDataKey<", t.getClass().getSimpleName(), "> ", this.name) : AbstractC0541b.m772n("NullableDataKey<unknown> ", this.name);
    }

    public T getDefaultValue(@NotNull DataHolder dataHolder) {
        return this.factory.apply(dataHolder);
    }

    public DataKeyBase(@NotNull String str, @NotNull DataKeyBase<T> dataKeyBase) {
        this(str, dataKeyBase.defaultValue, new C11847c(dataKeyBase, 1));
    }

    public DataKeyBase(@NotNull String str, T t) {
        this(str, t, new C11848d(t, 0));
    }
}
