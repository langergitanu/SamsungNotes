package androidx.glance.appwidget.multiprocess;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.RemoteViewsRoot;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.session.GlobalSnapshotManagerKt;
import androidx.glance.session.Session;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 '2\u00020\u0001:\u0002&'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u001e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJD\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u001e\b\u0002\u0010 \u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\"\u0012\u0006\u0012\u0004\u0018\u00010\u001c0!H\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$J\u000e\u0010%\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006("}, m13886d2 = {"Landroidx/glance/appwidget/multiprocess/CoroutineSession;", "Landroidx/glance/session/Session;", "key", "", "(Ljava/lang/String;)V", "_isRunning", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", "eventSession", "getEventSession", "()Landroidx/glance/session/Session;", "value", "isRunning", "isRunning$glance_appwidget_release", "()Z", "setRunning$glance_appwidget_release", "(Z)V", "cancelCoroutine", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createRootEmittable", "Landroidx/glance/appwidget/RemoteViewsRoot;", "onClosed", "processEvent", "context", "Landroid/content/Context;", "event", "", "(Landroid/content/Context;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runComposition", "Lkotlin/Result;", "timer", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "runComposition-0E7RQCE", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapshotMonitor", "CancelCoroutine", "Companion", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class CoroutineSession extends Session {

    @NotNull
    private static final String FINISH_SESSION_MSG = "Finish coroutine session";

    @NotNull
    private static final String TAG = "GWT:CoroutineSession";

    @NotNull
    private final AtomicReference<Boolean> _isRunning;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÄ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/appwidget/multiprocess/CoroutineSession$CancelCoroutine;", "", "()V", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class CancelCoroutine {

        @NotNull
        public static final CancelCoroutine INSTANCE = new CancelCoroutine();

        private CancelCoroutine() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineSession(@NotNull String key) {
        super(key);
        Intrinsics.checkNotNullParameter(key, "key");
        this._isRunning = new AtomicReference<>(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object cancelCoroutine(Continuation<? super Unit> continuation) {
        try {
            GlanceLog.INSTANCE.m2301i(TAG, "Cancel " + getKey() + " session(" + this + ") coroutine");
            JobKt.cancel(continuation.get$context(), new CancellationException(FINISH_SESSION_MSG));
        } catch (CancellationException e) {
            GlanceLog.INSTANCE.m2297d(TAG, "Exception : " + e);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object processEvent$suspendImpl(CoroutineSession coroutineSession, Context context, Object obj, Continuation<? super Unit> continuation) {
        if (!(obj instanceof CancelCoroutine)) {
            return Unit.INSTANCE;
        }
        Object objCancelCoroutine = coroutineSession.cancelCoroutine(continuation);
        return objCancelCoroutine == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCancelCoroutine : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: runComposition-0E7RQCE$default, reason: not valid java name */
    public static /* synthetic */ Object m21352runComposition0E7RQCE$default(CoroutineSession coroutineSession, Context context, Function1 function1, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: runComposition-0E7RQCE");
        }
        if ((i & 2) != 0) {
            function1 = new CoroutineSession$runComposition$2(null);
        }
        return coroutineSession.m21353runComposition0E7RQCE(context, function1, continuation);
    }

    public static /* synthetic */ Object snapshotMonitor$suspendImpl(CoroutineSession coroutineSession, Continuation<? super Unit> continuation) {
        Object objGlobalSnapshotMonitor = GlobalSnapshotManagerKt.globalSnapshotMonitor(continuation);
        return objGlobalSnapshotMonitor == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objGlobalSnapshotMonitor : Unit.INSTANCE;
    }

    @NotNull
    public abstract Session getEventSession();

    public final boolean isRunning$glance_appwidget_release() {
        Boolean bool = this._isRunning.get();
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        return bool.booleanValue();
    }

    @Override // androidx.glance.session.Session
    public void onClosed() {
        super.onClosed();
        setRunning$glance_appwidget_release(false);
        GlanceLog.INSTANCE.m2297d(TAG, "onClosed / " + this);
    }

    @Override // androidx.glance.session.Session
    @Nullable
    public Object processEvent(@NotNull Context context, @NotNull Object obj, @NotNull Continuation<? super Unit> continuation) {
        return processEvent$suspendImpl(this, context, obj, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /* JADX INFO: renamed from: runComposition-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m21353runComposition0E7RQCE(@NotNull Context context, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function1, @NotNull Continuation<? super Result<Unit>> continuation) {
        CoroutineSession$runComposition$1 coroutineSession$runComposition$1;
        if (continuation instanceof CoroutineSession$runComposition$1) {
            coroutineSession$runComposition$1 = (CoroutineSession$runComposition$1) continuation;
            int i = coroutineSession$runComposition$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                coroutineSession$runComposition$1.label = i - Integer.MIN_VALUE;
            } else {
                coroutineSession$runComposition$1 = new CoroutineSession$runComposition$1(this, continuation);
            }
        }
        Object objCoroutineScope = coroutineSession$runComposition$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = coroutineSession$runComposition$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCoroutineScope);
            CoroutineSession$runComposition$3 coroutineSession$runComposition$3 = new CoroutineSession$runComposition$3(this, function1, context, null);
            coroutineSession$runComposition$1.label = 1;
            objCoroutineScope = CoroutineScopeKt.coroutineScope(coroutineSession$runComposition$3, coroutineSession$runComposition$1);
            if (objCoroutineScope == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objCoroutineScope);
        }
        return ((Result) objCoroutineScope).getValue();
    }

    public final void setRunning$glance_appwidget_release(boolean z) {
        AtomicReference<Boolean> atomicReference = this._isRunning;
        Boolean boolValueOf = Boolean.valueOf(!z);
        Boolean boolValueOf2 = Boolean.valueOf(z);
        while (!atomicReference.compareAndSet(boolValueOf, boolValueOf2) && atomicReference.get() == boolValueOf) {
        }
    }

    @Nullable
    public Object snapshotMonitor(@NotNull Continuation<? super Unit> continuation) {
        return snapshotMonitor$suspendImpl(this, continuation);
    }

    @Override // androidx.glance.session.Session
    @NotNull
    public RemoteViewsRoot createRootEmittable() {
        return new RemoteViewsRoot(50);
    }
}
