package androidx.glance.appwidget.multiprocess;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.session.Session;
import androidx.glance.session.SessionManagerScope;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\u0005J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Landroidx/glance/appwidget/multiprocess/CoroutineSessionManagerScope;", "Landroidx/glance/session/SessionManagerScope;", "()V", Constants.EXTRA_KEY_SESSIONS, "Ljava/util/concurrent/ConcurrentHashMap;", "", "Landroidx/glance/appwidget/multiprocess/CoroutineSession;", "closeSession", "", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSession", "Landroidx/glance/session/Session;", "isSessionRunning", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startCoroutineSession", "session", "(Landroid/content/Context;Landroidx/glance/appwidget/multiprocess/CoroutineSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startSession", "(Landroid/content/Context;Landroidx/glance/session/Session;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class CoroutineSessionManagerScope implements SessionManagerScope {

    @NotNull
    private static final String TAG = "GWT:SessionScope";

    @NotNull
    private final ConcurrentHashMap<String, CoroutineSession> sessions = new ConcurrentHashMap<>();
    public static final int $stable = 8;

    /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.CoroutineSessionManagerScope$startSession$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.CoroutineSessionManagerScope", m14021f = "CoroutineSessionManagerScope.kt", m14022i = {}, m14023l = {30}, m14024m = "startSession", m14025n = {}, m14026s = {})
    public static final class C29771 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C29771(Continuation<? super C29771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CoroutineSessionManagerScope.this.startSession(null, null, this);
        }
    }

    @Override // androidx.glance.session.SessionManagerScope
    @Nullable
    public final Object closeSession(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        CoroutineSession coroutineSessionRemove;
        GlanceLog.INSTANCE.m2297d(TAG, "closeSession " + str);
        synchronized (this.sessions) {
            coroutineSessionRemove = this.sessions.remove(str);
        }
        if (coroutineSessionRemove != null) {
            coroutineSessionRemove.onClosed();
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.glance.session.SessionManagerScope
    @Nullable
    public final Session getSession(@NotNull String key) {
        CoroutineSession coroutineSession;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.sessions) {
            coroutineSession = this.sessions.get(key);
        }
        return coroutineSession;
    }

    @Override // androidx.glance.session.SessionManagerScope
    @Nullable
    public final Object isSessionRunning(@NotNull Context context, @NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        CoroutineSession coroutineSession = this.sessions.get(str);
        boolean z = false;
        if (coroutineSession == null) {
            return Boxing.boxBoolean(false);
        }
        if (coroutineSession.isOpen() && coroutineSession.isRunning$glance_appwidget_release()) {
            z = true;
        }
        return Boxing.boxBoolean(z);
    }

    @Nullable
    public abstract Object startCoroutineSession(@NotNull Context context, @NotNull CoroutineSession coroutineSession, @NotNull Continuation<? super Unit> continuation);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.glance.session.SessionManagerScope
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startSession(@NotNull Context context, @NotNull Session session, @NotNull Continuation<? super Unit> continuation) {
        C29771 c29771;
        if (continuation instanceof C29771) {
            c29771 = (C29771) continuation;
            int i = c29771.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c29771.label = i - Integer.MIN_VALUE;
            } else {
                c29771 = new C29771(continuation);
            }
        }
        Object obj = c29771.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c29771.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (!(session instanceof CoroutineSession)) {
                    return Unit.INSTANCE;
                }
                GlanceLog.INSTANCE.m2297d(TAG, "startSession " + session.getKey() + SQLKeyword.COMMA + session + " / thread : " + MultiProcessSessionManagerKt.getCurrentThread());
                CoroutineSession coroutineSessionPut = this.sessions.put(session.getKey(), session);
                if (coroutineSessionPut != null) {
                    coroutineSessionPut.onClosed();
                }
                ((CoroutineSession) session).setRunning$glance_appwidget_release(true);
                c29771.label = 1;
                if (startCoroutineSession(context, (CoroutineSession) session, c29771) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (IllegalArgumentException e) {
            GlanceLog.INSTANCE.m2297d(TAG, "Exception " + e + " occurred at coroutine session");
        }
        return Unit.INSTANCE;
    }
}
