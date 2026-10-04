package com.google.android.appfunctions.schema.common.p129v1.types;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"valueOr", "T", "Lcom/google/android/appfunctions/schema/common/v1/types/SetField;", "default", "Lkotlin/Function0;", "(Lcom/google/android/appfunctions/schema/common/v1/types/SetField;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SetFieldKt {
    public static final <T> T valueOr(@Nullable SetField<T> setField, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "default");
        return setField != null ? setField.getValue() : function0.invoke();
    }
}
