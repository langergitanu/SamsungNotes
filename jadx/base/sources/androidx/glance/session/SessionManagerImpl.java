package androidx.glance.session;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\t\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J=\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0012¢\u0006\u0002\b\u0016H\u0096@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Landroidx/glance/session/SessionManagerImpl;", "Landroidx/glance/session/SessionManager;", "workerClass", "Ljava/lang/Class;", "Landroidx/work/ListenableWorker;", "(Ljava/lang/Class;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "scope", "androidx/glance/session/SessionManagerImpl$scope$1", "Landroidx/glance/session/SessionManagerImpl$scope$1;", "enqueueDelayedWorker", "", "context", "Landroid/content/Context;", "runWithLock", "T", "block", "Lkotlin/Function2;", "Landroidx/glance/session/SessionManagerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSessionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SessionManager.kt\nandroidx/glance/session/SessionManagerImpl\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,194:1\n120#2,10:195\n*S KotlinDebug\n*F\n+ 1 SessionManager.kt\nandroidx/glance/session/SessionManagerImpl\n*L\n173#1:195,10\n*E\n"})
public final class SessionManagerImpl implements SessionManager {
    public static final int $stable = 8;

    @NotNull
    private final Mutex mutex;

    @NotNull
    private final SessionManagerImpl$scope$1 scope;

    @NotNull
    private final Class<? extends ListenableWorker> workerClass;

    /* JADX INFO: renamed from: androidx.glance.session.SessionManagerImpl$runWithLock$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.SessionManagerImpl", m14021f = "SessionManager.kt", m14022i = {0, 0, 0, 1}, m14023l = {200, 173}, m14024m = "runWithLock", m14025n = {"this", "block", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, m14026s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class C35091<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C35091(Continuation<? super C35091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionManagerImpl.this.runWithLock(null, this);
        }
    }

    public SessionManagerImpl(@NotNull Class<? extends ListenableWorker> workerClass) {
        Intrinsics.checkNotNullParameter(workerClass, "workerClass");
        this.workerClass = workerClass;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.scope = new SessionManagerImpl$scope$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueueDelayedWorker(Context context) {
        WorkManager.getInstance(context).enqueueUniqueWork("sessionWorkerKeepEnabled", ExistingWorkPolicy.KEEP, new OneTimeWorkRequest.Builder(this.workerClass).setInitialDelay(3650L, TimeUnit.DAYS).setConstraints(new Constraints.Builder().setRequiresCharging(true).build()).build());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.glance.session.SessionManager
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object runWithLock(@NotNull Function2<? super SessionManagerScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) throws Throwable {
        C35091 c35091;
        Mutex mutex;
        SessionManagerImpl sessionManagerImpl;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof C35091) {
            c35091 = (C35091) continuation;
            int i = c35091.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c35091.label = i - Integer.MIN_VALUE;
            } else {
                c35091 = new C35091(continuation);
            }
        }
        Object obj = c35091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c35091.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.mutex;
                c35091.L$0 = this;
                c35091.L$1 = function2;
                c35091.L$2 = mutex;
                c35091.label = 1;
                if (mutex.lock(null, c35091) != coroutine_suspended) {
                    sessionManagerImpl = this;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = (Mutex) c35091.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex2.unlock(null);
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c35091.L$2;
            Function2<? super SessionManagerScope, ? super Continuation<? super T>, ? extends Object> function22 = (Function2) c35091.L$1;
            sessionManagerImpl = (SessionManagerImpl) c35091.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            function2 = function22;
            SessionManagerImpl$scope$1 sessionManagerImpl$scope$1 = sessionManagerImpl.scope;
            c35091.L$0 = mutex;
            c35091.L$1 = null;
            c35091.L$2 = null;
            c35091.label = 2;
            Object objInvoke = function2.invoke(sessionManagerImpl$scope$1, c35091);
            if (objInvoke != coroutine_suspended) {
                Mutex mutex4 = mutex;
                obj = objInvoke;
                mutex2 = mutex4;
                mutex2.unlock(null);
                return obj;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex5 = mutex;
            th = th3;
            mutex2 = mutex5;
            mutex2.unlock(null);
            throw th;
        }
    }
}
