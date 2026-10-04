package com.google.android.appfunctions.internal;

import androidx.annotation.RestrictTo;
import com.google.android.appfunctions.AppFunctionContext;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J6\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH¦@¢\u0006\u0002\u0010\rR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, m13886d2 = {"Lcom/google/android/appfunctions/internal/AppFunctionInvoker;", "", "supportedFunctionIds", "", "", "getSupportedFunctionIds", "()Ljava/util/Set;", "unsafeInvoke", "appFunctionContext", "Lcom/google/android/appfunctions/AppFunctionContext;", "functionIdentifier", "parameters", "", "(Lcom/google/android/appfunctions/AppFunctionContext;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.libraries.llm.appfunctions.appfunctions_appfunctions"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface AppFunctionInvoker {
    @NotNull
    Set<String> getSupportedFunctionIds();

    @Nullable
    Object unsafeInvoke(@NotNull AppFunctionContext appFunctionContext, @NotNull String str, @NotNull Map<String, ? extends Object> map, @NotNull Continuation<Object> continuation);
}
