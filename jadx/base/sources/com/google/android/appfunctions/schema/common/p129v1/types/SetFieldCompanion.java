package com.google.android.appfunctions.schema.common.p129v1.types;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u001b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0006J\"\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/types/SetFieldCompanion;", "T", "", "setField", "Lcom/google/android/appfunctions/schema/common/v1/types/SetField;", "value", "(Ljava/lang/Object;)Lcom/google/android/appfunctions/schema/common/v1/types/SetField;", "setNullableField", "setListField", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SetFieldCompanion<T> {
    @NotNull
    SetField<T> setField(@NotNull T value);

    @NotNull
    SetField<List<T>> setListField(@NotNull List<? extends T> value);

    @NotNull
    SetField<T> setNullableField(@Nullable T value);
}
