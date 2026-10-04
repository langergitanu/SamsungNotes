package com.vladsch.flexmark.util.data;

import androidx.appcompat.widget.AbstractC0541b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DataKey<T> extends DataKeyBase<T> {
    public DataKey(@NotNull String str, @NotNull T t, @NotNull DataNotNullValueFactory<T> dataNotNullValueFactory) {
        super(str, t, dataNotNullValueFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$0(NotNullValueSupplier notNullValueSupplier, DataHolder dataHolder) {
        return notNullValueSupplier.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$1(Object obj, DataHolder dataHolder) {
        return obj;
    }

    @Override // com.vladsch.flexmark.util.data.DataKeyBase
    @NotNull
    public T get(@Nullable DataHolder dataHolder) {
        return (T) super.get(dataHolder);
    }

    @Override // com.vladsch.flexmark.util.data.DataKeyBase
    @NotNull
    public T getDefaultValue() {
        return (T) super.getDefaultValue();
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataValueSetter
    @NotNull
    public MutableDataHolder set(@NotNull MutableDataHolder mutableDataHolder, @NotNull T t) {
        return mutableDataHolder.set(this, t);
    }

    @Override // com.vladsch.flexmark.util.data.DataKeyBase
    public String toString() {
        return AbstractC0541b.m774p("DataKey<", getDefaultValue().getClass().getSimpleName(), "> ", getName());
    }

    public DataKey(@NotNull String str, @NotNull NotNullValueSupplier<T> notNullValueSupplier) {
        super(str, notNullValueSupplier.get(), new C11845a(notNullValueSupplier, 0));
    }

    @Override // com.vladsch.flexmark.util.data.DataKeyBase
    @NotNull
    public T getDefaultValue(@NotNull DataHolder dataHolder) {
        return (T) super.getDefaultValue(dataHolder);
    }

    @Override // com.vladsch.flexmark.util.data.DataKeyBase
    @NotNull
    public DataNotNullValueFactory<T> getFactory() {
        return (DataNotNullValueFactory) super.getFactory();
    }

    public DataKey(@NotNull String str, @NotNull DataKey<T> dataKey) {
        this(str, dataKey.getDefaultValue(), new C11846b(dataKey, 0));
    }

    public DataKey(@NotNull String str, @NotNull T t) {
        this(str, t, new C11846b(t, 2));
    }
}
