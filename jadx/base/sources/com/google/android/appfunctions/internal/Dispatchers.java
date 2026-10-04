package com.google.android.appfunctions.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\r"}, m13886d2 = {"Lcom/google/android/appfunctions/internal/Dispatchers;", "", "<init>", "()V", "Main", "Lkotlin/coroutines/CoroutineContext;", "getMain", "()Lkotlin/coroutines/CoroutineContext;", "Main$delegate", "Lkotlin/Lazy;", "Worker", "getWorker", "Worker$delegate", "java.com.google.android.libraries.llm.appfunctions.appfunctions_appfunctions"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Dispatchers {

    @NotNull
    public static final Dispatchers INSTANCE = new Dispatchers();

    /* JADX INFO: renamed from: Main$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy Main = LazyKt.lazy(new Function0<HandlerDispatcher>() { // from class: com.google.android.appfunctions.internal.Dispatchers$Main$2
        @Override // kotlin.jvm.functions.Function0
        public final HandlerDispatcher invoke() {
            return HandlerDispatcherKt.from$default(new Handler(Looper.getMainLooper()), null, 1, null);
        }
    });

    /* JADX INFO: renamed from: Worker$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy Worker = LazyKt.lazy(new Function0<ExecutorCoroutineDispatcher>() { // from class: com.google.android.appfunctions.internal.Dispatchers$Worker$2
        @Override // kotlin.jvm.functions.Function0
        public final ExecutorCoroutineDispatcher invoke() {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
            return ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
        }
    });

    private Dispatchers() {
    }

    @NotNull
    public final CoroutineContext getMain() {
        return (CoroutineContext) Main.getValue();
    }

    @NotNull
    public final CoroutineContext getWorker() {
        return (CoroutineContext) Worker.getValue();
    }
}
