package androidx.glance.session;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.EmittableWithChildren;
import androidx.glance.oneui.common.GlanceLog;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 *2\u00020\u0001:\u0001*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u001e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0001H¦@¢\u0006\u0002\u0010\u001eJ%\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u000f0 ¢\u0006\u0002\b!¢\u0006\u0002\b\"2\u0006\u0010\u0014\u001a\u00020\u0015H&¢\u0006\u0002\u0010#J*\u0010$\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f0&H\u0086@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0001H\u0084@¢\u0006\u0002\u0010)R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006+"}, m13886d2 = {"Landroidx/glance/session/Session;", "", "key", "", "(Ljava/lang/String;)V", "_isOpen", "Ljava/util/concurrent/atomic/AtomicBoolean;", "eventChannel", "Lkotlinx/coroutines/channels/Channel;", "isOpen", "", "()Z", "getKey", "()Ljava/lang/String;", "close", "", "createRootEmittable", "Landroidx/glance/EmittableWithChildren;", "onClosed", "onCompositionError", "context", "Landroid/content/Context;", "throwable", "", "(Landroid/content/Context;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processEmittableTree", "root", "(Landroid/content/Context;Landroidx/glance/EmittableWithChildren;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processEvent", "event", "(Landroid/content/Context;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "provideGlance", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/glance/GlanceComposable;", "(Landroid/content/Context;)Lkotlin/jvm/functions/Function2;", "receiveEvents", "block", "Lkotlin/Function1;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendEvent", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class Session {

    @Deprecated
    @NotNull
    public static final String TAG = "GWT:GlanceSession";

    @NotNull
    private final AtomicBoolean _isOpen;

    @NotNull
    private final Channel<Object> eventChannel;

    @NotNull
    private final String key;

    @NotNull
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m13886d2 = {"Landroidx/glance/session/Session$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.glance.session.Session$receiveEvents$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.Session", m14021f = "Session.kt", m14022i = {0, 0, 0, 1, 1, 1}, m14023l = {99, 104}, m14024m = "receiveEvents", m14025n = {"this", "context", "block", "this", "context", "block"}, m14026s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class C35071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C35071(Continuation<? super C35071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Session.this.receiveEvents(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.session.Session$sendEvent$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.Session", m14021f = "Session.kt", m14022i = {0}, m14023l = {83}, m14024m = "sendEvent", m14025n = {"this"}, m14026s = {"L$0"})
    public static final class C35081 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C35081(Continuation<? super C35081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Session.this.sendEvent(null, this);
        }
    }

    public Session(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this._isOpen = new AtomicBoolean(true);
        this.eventChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    public static /* synthetic */ Object onCompositionError$suspendImpl(Session session, Context context, Throwable th, Continuation<? super Unit> continuation) {
        GlanceLog.INSTANCE.m2300e(TAG, "Error running composition", th);
        return Unit.INSTANCE;
    }

    public final void close() {
        GlanceLog.INSTANCE.m2301i(TAG, "close: this=" + this);
        SendChannel.DefaultImpls.close$default(this.eventChannel, null, 1, null);
        this._isOpen.set(false);
        onClosed();
    }

    @NotNull
    public abstract EmittableWithChildren createRootEmittable();

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public boolean isOpen() {
        return this._isOpen.get();
    }

    @Nullable
    public Object onCompositionError(@NotNull Context context, @NotNull Throwable th, @NotNull Continuation<? super Unit> continuation) {
        return onCompositionError$suspendImpl(this, context, th, continuation);
    }

    @Nullable
    public abstract Object processEmittableTree(@NotNull Context context, @NotNull EmittableWithChildren emittableWithChildren, @NotNull Continuation<? super Boolean> continuation);

    @Nullable
    public abstract Object processEvent(@NotNull Context context, @NotNull Object obj, @NotNull Continuation<? super Unit> continuation);

    @NotNull
    /* JADX INFO: renamed from: provideGlance */
    public abstract Function2<Composer, Integer, Unit> mo21926provideGlance(@NotNull Context context);

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c6, code lost:
    
        if (r14 == r2) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009b A[Catch: ClosedReceiveChannelException -> 0x0042, TRY_LEAVE, TryCatch #0 {ClosedReceiveChannelException -> 0x0042, blocks: (B:13:0x003c, B:25:0x007e, B:29:0x0093, B:31:0x009b, B:20:0x005d), top: B:39:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.glance.session.Session, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00c6 -> B:14:0x003f). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object receiveEvents(@NotNull Context context, @NotNull Function1<Object, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        C35071 c35071;
        ChannelIterator<Object> it;
        ChannelIterator<Object> channelIterator;
        ?? r32;
        Context context2;
        Object objHasNext;
        if (continuation instanceof C35071) {
            c35071 = (C35071) continuation;
            int i = c35071.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c35071.label = i - Integer.MIN_VALUE;
            } else {
                c35071 = new C35071(continuation);
            }
        }
        Object obj = c35071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r33 = c35071.label;
        try {
        } catch (ClosedReceiveChannelException e) {
            e = e;
        }
        if (r33 != 0) {
            if (r33 == 1) {
                channelIterator = (ChannelIterator) c35071.L$3;
                function1 = (Function1) c35071.L$2;
                context2 = (Context) c35071.L$1;
                Session session = (Session) c35071.L$0;
                ResultKt.throwOnFailure(obj);
                r32 = session;
                if (((Boolean) obj).booleanValue()) {
                }
                return Unit.INSTANCE;
            }
            if (r33 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            channelIterator = (ChannelIterator) c35071.L$3;
            function1 = (Function1) c35071.L$2;
            context2 = (Context) c35071.L$1;
            Session session2 = (Session) c35071.L$0;
            ResultKt.throwOnFailure(obj);
            ?? r34 = session2;
            it = channelIterator;
            context = context2;
            r33 = r34;
            c35071.L$0 = r33;
            c35071.L$1 = context;
            c35071.L$2 = function1;
            c35071.L$3 = it;
            c35071.label = 1;
            objHasNext = it.hasNext(c35071);
            if (objHasNext != coroutine_suspended) {
                return coroutine_suspended;
            }
            context2 = context;
            channelIterator = it;
            obj = objHasNext;
            r32 = r33;
            if (((Boolean) obj).booleanValue()) {
                Object next = channelIterator.next();
                GlanceLog.INSTANCE.m2301i(TAG, "receiveEvent: " + next);
                function1.invoke(next);
                c35071.L$0 = r32;
                c35071.L$1 = context2;
                c35071.L$2 = function1;
                c35071.L$3 = channelIterator;
                c35071.label = 2;
                Object objProcessEvent = r32.processEvent(context2, next, c35071);
                r34 = r32;
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        try {
            GlanceLog.INSTANCE.m2301i(TAG, "receiveEvents : " + this.eventChannel);
            it = this.eventChannel.iterator();
            r33 = this;
            c35071.L$0 = r33;
            c35071.L$1 = context;
            c35071.L$2 = function1;
            c35071.L$3 = it;
            c35071.label = 1;
            objHasNext = it.hasNext(c35071);
            if (objHasNext != coroutine_suspended) {
            }
        } catch (ClosedReceiveChannelException e2) {
            e = e2;
            r33 = this;
            GlanceLog.INSTANCE.m2305w(TAG, "receiveEvents: this=" + r33 + " ex=" + e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendEvent(@NotNull Object obj, @NotNull Continuation<? super Unit> continuation) {
        C35081 c35081;
        Session session;
        if (continuation instanceof C35081) {
            c35081 = (C35081) continuation;
            int i = c35081.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c35081.label = i - Integer.MIN_VALUE;
            } else {
                c35081 = new C35081(continuation);
            }
        }
        Object obj2 = c35081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c35081.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            try {
                GlanceLog.INSTANCE.m2301i(TAG, "sendEvent:" + obj + ", eventChannel:" + this.eventChannel.isClosedForSend() + SQLKeyword.COMMA + this.eventChannel.isClosedForReceive());
                Channel<Object> channel = this.eventChannel;
                c35081.L$0 = this;
                c35081.label = 1;
                if (channel.send(obj, c35081) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (ClosedSendChannelException e) {
                e = e;
                session = this;
                GlanceLog.INSTANCE.m2305w(TAG, "sendEvent: this=" + session + " ex=" + e);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            session = (Session) c35081.L$0;
            try {
                ResultKt.throwOnFailure(obj2);
            } catch (ClosedSendChannelException e2) {
                e = e2;
                GlanceLog.INSTANCE.m2305w(TAG, "sendEvent: this=" + session + " ex=" + e);
            }
        }
        return Unit.INSTANCE;
    }

    public void onClosed() {
    }
}
