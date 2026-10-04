package com.google.android.appfunctions;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m13886d2 = {"appFunctionExceptionOrNull", "Lcom/google/android/appfunctions/AppFunctionException;", "T", "Lkotlin/Result;", "(Ljava/lang/Object;)Lcom/google/android/appfunctions/AppFunctionException;", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
@JvmName(name = "ResultUtils")
public final class ResultUtils {
    @Nullable
    public static final <T> AppFunctionException appFunctionExceptionOrNull(@NotNull Object obj) {
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(obj);
        if (thM22218exceptionOrNullimpl == null || !(thM22218exceptionOrNullimpl instanceof AppFunctionException)) {
            return null;
        }
        return (AppFunctionException) thM22218exceptionOrNullimpl;
    }
}
