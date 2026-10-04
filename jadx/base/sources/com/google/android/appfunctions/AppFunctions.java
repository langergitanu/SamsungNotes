package com.google.android.appfunctions;

import android.content.Context;
import android.p108os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import androidx.arch.core.executor.ExecutorC0579a;
import com.android.extensions.appfunctions.AppFunctionManager;
import com.google.android.appfunctions.internal.AggregateAppFunctionInventory;
import com.google.android.appfunctions.internal.Dependencies;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(31)
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0086@¢\u0006\u0002\u0010\u0010J,\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0014H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, m13886d2 = {"Lcom/google/android/appfunctions/AppFunctions;", "", "<init>", "()V", "inventory", "Lcom/google/android/appfunctions/internal/AggregateAppFunctionInventory;", "getInventory", "()Lcom/google/android/appfunctions/internal/AggregateAppFunctionInventory;", "inventory$delegate", "Lkotlin/Lazy;", "isAppFunctionEnabled", "", "context", "Landroid/content/Context;", "function", "Lkotlin/Function;", "(Landroid/content/Context;Lkotlin/Function;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAppFunctionEnabled", "", "enabledState", "Lcom/google/android/appfunctions/EnabledState;", "(Landroid/content/Context;Lkotlin/Function;Lcom/google/android/appfunctions/EnabledState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toPlatformEnabledState", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_appfunctions"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAppFunctions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppFunctions.kt\ncom/google/android/appfunctions/AppFunctions\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,94:1\n351#2,11:95\n351#2,11:106\n*S KotlinDebug\n*F\n+ 1 AppFunctions.kt\ncom/google/android/appfunctions/AppFunctions\n*L\n24#1:95,11\n61#1:106,11\n*E\n"})
public final class AppFunctions {

    @NotNull
    public static final AppFunctions INSTANCE = new AppFunctions();

    /* JADX INFO: renamed from: inventory$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy inventory = LazyKt.lazy(new Function0<AggregateAppFunctionInventory>() { // from class: com.google.android.appfunctions.AppFunctions$inventory$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AggregateAppFunctionInventory invoke() {
            return Dependencies.INSTANCE.getInstance().m3125x9661cda5();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnabledState.values().length];
            try {
                iArr[EnabledState.APP_FUNCTION_STATE_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnabledState.APP_FUNCTION_STATE_ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnabledState.APP_FUNCTION_STATE_DISABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AppFunctions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AggregateAppFunctionInventory getInventory() {
        return (AggregateAppFunctionInventory) inventory.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toPlatformEnabledState(EnabledState enabledState) {
        int i = WhenMappings.$EnumSwitchMapping$0[enabledState.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Nullable
    public final Object isAppFunctionEnabled(@NotNull Context context, @NotNull Function<? extends Object> function, @NotNull Continuation<? super Boolean> continuation) {
        String id;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        AppFunctionMetadata appFunctionMetadata = INSTANCE.getInventory().getFunctionToMetadataMap().get(function);
        if (appFunctionMetadata == null || (id = appFunctionMetadata.getId()) == null) {
            throw new IllegalArgumentException("[" + function + "] is not indexed. Is it annotated with @AppFunction or @AppSchemaImpl?");
        }
        new AppFunctionManager(context).isAppFunctionEnabled(id, context.getPackageName(), new ExecutorC0579a(2), new OutcomeReceiver() { // from class: com.google.android.appfunctions.AppFunctions$isAppFunctionEnabled$2$2
            public void onError(Exception error) {
                Intrinsics.checkNotNullParameter(error, "error");
                CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(error)));
            }

            public void onResult(Boolean result) {
                if (result != null) {
                    cancellableContinuationImpl.resumeWith(Result.m22215constructorimpl(result));
                    return;
                }
                CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(new IllegalStateException("Result is null"))));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object setAppFunctionEnabled(@NotNull Context context, @NotNull Function<? extends Object> function, @NotNull EnabledState enabledState, @NotNull Continuation<? super Unit> continuation) {
        String id;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        AppFunctions appFunctions = INSTANCE;
        AppFunctionMetadata appFunctionMetadata = appFunctions.getInventory().getFunctionToMetadataMap().get(function);
        if (appFunctionMetadata == null || (id = appFunctionMetadata.getId()) == null) {
            throw new IllegalArgumentException("[" + function + "] is not indexed. Is it annotated with @AppFunction or @AppSchemaImpl?");
        }
        new AppFunctionManager(context).setAppFunctionEnabled(id, appFunctions.toPlatformEnabledState(enabledState), new ExecutorC0579a(2), new OutcomeReceiver() { // from class: com.google.android.appfunctions.AppFunctions$setAppFunctionEnabled$2$2
            public void onError(Exception error) {
                Intrinsics.checkNotNullParameter(error, "error");
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(error)));
            }

            public void onResult(Void result) {
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
