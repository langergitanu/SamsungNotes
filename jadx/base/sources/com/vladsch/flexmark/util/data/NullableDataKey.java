package com.vladsch.flexmark.util.data;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NullableDataKey<T> extends DataKeyBase<T> {
    public NullableDataKey(@NotNull String str, @Nullable T t, @NotNull DataValueFactory<T> dataValueFactory) {
        super(str, t, dataValueFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$0(Supplier supplier, DataHolder dataHolder) {
        return supplier.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$1(Object obj, DataHolder dataHolder) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$2(DataHolder dataHolder) {
        return null;
    }

    @Override // com.vladsch.flexmark.util.data.DataKeyBase
    @Nullable
    public T get(@Nullable DataHolder dataHolder) {
        return (T) super.get(dataHolder);
    }

    @Override // com.vladsch.flexmark.util.data.DataKeyBase
    @Nullable
    public T getDefaultValue() {
        return (T) super.getDefaultValue();
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataValueSetter
    @NotNull
    public MutableDataHolder set(@NotNull MutableDataHolder mutableDataHolder, @Nullable T t) {
        return mutableDataHolder.set(this, t);
    }

    @Override // com.vladsch.flexmark.util.data.DataKeyBase
    public String toString() {
        T defaultValue = getDefaultValue();
        return defaultValue != null ? AbstractC0541b.m774p("DataKey<", defaultValue.getClass().getSimpleName(), "> ", getName()) : AbstractC0541b.m772n("DataKey<null> ", getName());
    }

    public NullableDataKey(@NotNull String str, @NotNull DataValueNullableFactory<T> dataValueNullableFactory) {
        super(str, dataValueNullableFactory.apply((DataHolder) null), dataValueNullableFactory);
    }

    @Override // com.vladsch.flexmark.util.data.DataKeyBase
    @Nullable
    public T getDefaultValue(@NotNull DataHolder dataHolder) {
        return (T) super.getDefaultValue(dataHolder);
    }

    public NullableDataKey(@NotNull String str, @NotNull Supplier<T> supplier) {
        super(str, supplier.get(), new C11845a(supplier, 1));
    }

    public NullableDataKey(@NotNull String str, @NotNull DataKeyBase<T> dataKeyBase) {
        this(str, dataKeyBase.getDefaultValue(), new C11847c(dataKeyBase, 1));
    }

    public NullableDataKey(@NotNull String str, @Nullable T t) {
        this(str, t, new C11848d(t, 1));
    }

    public NullableDataKey(@NotNull String str) {
        this(str, null, new C11849e());
    }
}
