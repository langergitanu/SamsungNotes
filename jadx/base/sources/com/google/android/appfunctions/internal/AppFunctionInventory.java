package com.google.android.appfunctions.internal;

import androidx.annotation.RestrictTo;
import com.google.android.appfunctions.AppFunctionMetadata;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R$\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, m13886d2 = {"Lcom/google/android/appfunctions/internal/AppFunctionInventory;", "", "functionToMetadataMap", "", "Lkotlin/Function;", "Lcom/google/android/appfunctions/AppFunctionMetadata;", "getFunctionToMetadataMap", "()Ljava/util/Map;", "java.com.google.android.libraries.llm.appfunctions.appfunctions_appfunctions"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface AppFunctionInventory {
    @NotNull
    Map<Function<Object>, AppFunctionMetadata> getFunctionToMetadataMap();
}
