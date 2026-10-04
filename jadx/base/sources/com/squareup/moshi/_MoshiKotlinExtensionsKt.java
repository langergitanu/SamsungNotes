package com.squareup.moshi;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.NonNullJsonAdapter;
import com.squareup.moshi.internal.NullSafeJsonAdapter;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0087\b\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a#\u0010\u0006\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00072\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\b¨\u0006\b"}, m13886d2 = {"adapter", "Lcom/squareup/moshi/JsonAdapter;", "T", "Lcom/squareup/moshi/Moshi;", "ktype", "Lkotlin/reflect/KType;", "addAdapter", "Lcom/squareup/moshi/Moshi$Builder;", "moshi"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class _MoshiKotlinExtensionsKt {
    @ExperimentalStdlibApi
    public static final /* synthetic */ <T> JsonAdapter<T> adapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "<this>");
        Intrinsics.reifiedOperationMarker(6, "T");
        return adapter(moshi, null);
    }

    @ExperimentalStdlibApi
    public static final /* synthetic */ <T> Moshi.Builder addAdapter(Moshi.Builder builder, JsonAdapter<T> adapter) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.reifiedOperationMarker(6, "T");
        Moshi.Builder builderAdd = builder.add(TypesJVMKt.getJavaType((KType) null), adapter);
        Intrinsics.checkNotNullExpressionValue(builderAdd, "add(typeOf<T>().javaType, adapter)");
        return builderAdd;
    }

    @ExperimentalStdlibApi
    @NotNull
    public static final <T> JsonAdapter<T> adapter(@NotNull Moshi moshi, @NotNull KType ktype) {
        Intrinsics.checkNotNullParameter(moshi, "<this>");
        Intrinsics.checkNotNullParameter(ktype, "ktype");
        JsonAdapter<T> jsonAdapterAdapter = moshi.adapter(TypesJVMKt.getJavaType(ktype));
        if ((jsonAdapterAdapter instanceof NullSafeJsonAdapter) || (jsonAdapterAdapter instanceof NonNullJsonAdapter)) {
            return jsonAdapterAdapter;
        }
        if (ktype.isMarkedNullable()) {
            JsonAdapter<T> jsonAdapterNullSafe = jsonAdapterAdapter.nullSafe();
            Intrinsics.checkNotNullExpressionValue(jsonAdapterNullSafe, "{\n    adapter.nullSafe()\n  }");
            return jsonAdapterNullSafe;
        }
        JsonAdapter<T> jsonAdapterNonNull = jsonAdapterAdapter.nonNull();
        Intrinsics.checkNotNullExpressionValue(jsonAdapterNonNull, "{\n    adapter.nonNull()\n  }");
        return jsonAdapterNonNull;
    }
}
