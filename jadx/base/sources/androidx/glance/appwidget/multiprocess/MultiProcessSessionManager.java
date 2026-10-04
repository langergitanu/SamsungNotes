package androidx.glance.appwidget.multiprocess;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.session.SessionManager;
import androidx.glance.session.SessionManagerScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000e¢\u0006\u0002\b\u0012H\u0096@¢\u0006\u0002\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, m13886d2 = {"Landroidx/glance/appwidget/multiprocess/MultiProcessSessionManager;", "Landroidx/glance/session/SessionManager;", "()V", "TIME_DURATION", "Lkotlin/time/Duration;", "J", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "scope", "androidx/glance/appwidget/multiprocess/MultiProcessSessionManager$scope$1", "Landroidx/glance/appwidget/multiprocess/MultiProcessSessionManager$scope$1;", "runWithLock", "T", "block", "Lkotlin/Function2;", "Landroidx/glance/session/SessionManagerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMultiProcessSessionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiProcessSessionManager.kt\nandroidx/glance/appwidget/multiprocess/MultiProcessSessionManager\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,110:1\n120#2,10:111\n*S KotlinDebug\n*F\n+ 1 MultiProcessSessionManager.kt\nandroidx/glance/appwidget/multiprocess/MultiProcessSessionManager\n*L\n70#1:111,10\n*E\n"})
public final class MultiProcessSessionManager implements SessionManager {
    public static final int $stable;

    @NotNull
    public static final MultiProcessSessionManager INSTANCE = new MultiProcessSessionManager();
    private static final long TIME_DURATION;

    @NotNull
    private static final Mutex mutex;

    @NotNull
    private static final MultiProcessSessionManager$scope$1 scope;

    /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.MultiProcessSessionManager$runWithLock$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.MultiProcessSessionManager", m14021f = "MultiProcessSessionManager.kt", m14022i = {0, 0, 1}, m14023l = {116, 70}, m14024m = "runWithLock", m14025n = {"block", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, m14026s = {"L$0", "L$1", "L$0"})
    public static final class C29831<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C29831(Continuation<? super C29831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiProcessSessionManager.this.runWithLock(null, this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.glance.appwidget.multiprocess.MultiProcessSessionManager$scope$1] */
    static {
        Duration.Companion companion = Duration.INSTANCE;
        TIME_DURATION = DurationKt.toDuration(5, DurationUnit.SECONDS);
        mutex = MutexKt.Mutex$default(false, 1, null);
        scope = new CoroutineSessionManagerScope() { // from class: androidx.glance.appwidget.multiprocess.MultiProcessSessionManager$scope$1
            @Override // androidx.glance.appwidget.multiprocess.CoroutineSessionManagerScope
            @Nullable
            public Object startCoroutineSession(@NotNull Context context, @NotNull CoroutineSession coroutineSession, @NotNull Continuation<? super Unit> continuation) {
                if (!(coroutineSession instanceof MultiProcessSession)) {
                    return Unit.INSTANCE;
                }
                Object objWithMultiProcessContext = MultiProcessSessionManagerKt.withMultiProcessContext(coroutineSession.getKey(), new MultiProcessSessionManager$scope$1$startCoroutineSession$2(coroutineSession, context, null), continuation);
                return objWithMultiProcessContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithMultiProcessContext : Unit.INSTANCE;
            }
        };
        $stable = 8;
    }

    private MultiProcessSessionManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.glance.session.SessionManager
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object runWithLock(@NotNull Function2<? super SessionManagerScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        C29831 c29831;
        Mutex mutex2;
        Throwable th;
        Mutex mutex3;
        if (continuation instanceof C29831) {
            c29831 = (C29831) continuation;
            int i = c29831.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c29831.label = i - Integer.MIN_VALUE;
            } else {
                c29831 = new C29831(continuation);
            }
        }
        Object obj = c29831.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c29831.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex2 = mutex;
                c29831.L$0 = function2;
                c29831.L$1 = mutex2;
                c29831.label = 1;
                if (mutex2.lock(null, c29831) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex3 = (Mutex) c29831.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex3.unlock(null);
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                    mutex3.unlock(null);
                    throw th;
                }
            }
            Mutex mutex4 = (Mutex) c29831.L$1;
            Function2<? super SessionManagerScope, ? super Continuation<? super T>, ? extends Object> function22 = (Function2) c29831.L$0;
            ResultKt.throwOnFailure(obj);
            mutex2 = mutex4;
            function2 = function22;
            MultiProcessSessionManager$scope$1 multiProcessSessionManager$scope$1 = scope;
            c29831.L$0 = mutex2;
            c29831.L$1 = null;
            c29831.label = 2;
            Object objInvoke = function2.invoke(multiProcessSessionManager$scope$1, c29831);
            if (objInvoke != coroutine_suspended) {
                Mutex mutex5 = mutex2;
                obj = objInvoke;
                mutex3 = mutex5;
                mutex3.unlock(null);
                return obj;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex6 = mutex2;
            th = th3;
            mutex3 = mutex6;
            mutex3.unlock(null);
            throw th;
        }
    }
}
