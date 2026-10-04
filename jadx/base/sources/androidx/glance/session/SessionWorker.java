package androidx.glance.session;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.oneui.common.GlanceLog;
import androidx.work.CoroutineWorker;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.NonCancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u001b\u001a\u00020\u001cH\u0097@¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u00020\f8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Landroidx/glance/session/SessionWorker;", "Landroidx/work/CoroutineWorker;", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", ActionHandler.PARAMS, "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "sessionManager", "Landroidx/glance/session/SessionManager;", "timeouts", "Landroidx/glance/session/TimeoutOptions;", "coroutineContext", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Landroidx/glance/session/SessionManager;Landroidx/glance/session/TimeoutOptions;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getCoroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlinx/coroutines/CoroutineDispatcher;", "effectJob", "Lkotlinx/coroutines/Job;", "getEffectJob$glance_release$annotations", "getEffectJob$glance_release", "()Lkotlinx/coroutines/Job;", "setEffectJob$glance_release", "(Lkotlinx/coroutines/Job;)V", "key", "", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forceUpdateAppWidget", "", "Companion", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class SessionWorker extends CoroutineWorker {
    public static final boolean DEBUG = true;

    @NotNull
    public static final String TIMEOUT_EXIT_REASON = "TIMEOUT_EXIT_REASON";

    @NotNull
    private final Context appContext;

    @NotNull
    private final CoroutineDispatcher coroutineContext;

    @Nullable
    private Job effectJob;

    @NotNull
    private final String key;

    @NotNull
    private final WorkerParameters params;

    @NotNull
    private final SessionManager sessionManager;

    @NotNull
    private final TimeoutOptions timeouts;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: androidx.glance.session.SessionWorker$doWork$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.SessionWorker", m14021f = "SessionWorker.kt", m14022i = {0}, m14023l = {105}, m14024m = "doWork", m14025n = {"this"}, m14026s = {"L$0"})
    public static final class C35101 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C35101(Continuation<? super C35101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionWorker.this.doWork(this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.session.SessionWorker$doWork$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "Landroidx/glance/session/TimerScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.SessionWorker$doWork$2", m14021f = "SessionWorker.kt", m14022i = {}, m14023l = {106}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C35112 extends SuspendLambda implements Function2<TimerScope, Continuation<? super ListenableWorker.Result>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.glance.session.SessionWorker$doWork$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", ""}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.glance.session.SessionWorker$doWork$2$1", m14021f = "SessionWorker.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ TimerScope $$this$withTimerOrNull;
            int label;
            final /* synthetic */ SessionWorker this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(TimerScope timerScope, SessionWorker sessionWorker, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.$$this$withTimerOrNull = timerScope;
                this.this$0 = sessionWorker;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.$$this$withTimerOrNull, this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$$this$withTimerOrNull.mo21979startTimerLRDsOJo(this.this$0.timeouts.m21975getIdleTimeoutUwyO8pc());
                GlanceLog.INSTANCE.m2297d("GWT:SessionWorker", "Received idle event, session timeout " + Duration.m23594toStringimpl(this.$$this$withTimerOrNull.getTimeLeft()));
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: androidx.glance.session.SessionWorker$doWork$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.glance.session.SessionWorker$doWork$2$2", m14021f = "SessionWorker.kt", m14022i = {1}, m14023l = {114, 130, 152, 152}, m14024m = "invokeSuspend", m14025n = {"session"}, m14026s = {"L$0"})
        public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super ListenableWorker.Result>, Object> {
            final /* synthetic */ TimerScope $$this$withTimerOrNull;
            Object L$0;
            int label;
            final /* synthetic */ SessionWorker this$0;

            /* JADX INFO: renamed from: androidx.glance.session.SessionWorker$doWork$2$2$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.glance.session.SessionWorker$doWork$2$2$2", m14021f = "SessionWorker.kt", m14022i = {}, m14023l = {153}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class C145932 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Session $session;
                int label;
                final /* synthetic */ SessionWorker this$0;

                /* JADX INFO: renamed from: androidx.glance.session.SessionWorker$doWork$2$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/glance/session/SessionManagerScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
                @DebugMetadata(m14020c = "androidx.glance.session.SessionWorker$doWork$2$2$2$1", m14021f = "SessionWorker.kt", m14022i = {}, m14023l = {155}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<SessionManagerScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Session $session;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(Session session, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$session = session;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$session, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull SessionManagerScope sessionManagerScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(sessionManagerScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            SessionManagerScope sessionManagerScope = (SessionManagerScope) this.L$0;
                            GlanceLog.INSTANCE.m2301i("GWT:SessionWorker", "closeSession " + this.$session.getKey());
                            String key = this.$session.getKey();
                            this.label = 1;
                            if (sessionManagerScope.closeSession(key, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C145932(SessionWorker sessionWorker, Session session, Continuation<? super C145932> continuation) {
                    super(2, continuation);
                    this.this$0 = sessionWorker;
                    this.$session = session;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C145932(this.this$0, this.$session, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        SessionManager sessionManager = this.this$0.sessionManager;
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$session, null);
                        this.label = 1;
                        if (sessionManager.runWithLock(anonymousClass1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C145932) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(SessionWorker sessionWorker, TimerScope timerScope, Continuation<? super AnonymousClass2> continuation) {
                super(1, continuation);
                this.this$0 = sessionWorker;
                this.$$this$withTimerOrNull = timerScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$$this$withTimerOrNull, continuation);
            }

            /* JADX WARN: Code restructure failed: missing block: B:34:0x0127, code lost:
            
                if (kotlinx.coroutines.BuildersKt.withContext(r0, r2, r15) != r6) goto L36;
             */
            /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                Object objRunWithLock;
                Session session;
                NonCancellable nonCancellable;
                C145932 c145932;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    GlanceLog.INSTANCE.m2301i("GWT:SessionWorker", "doWork " + this.this$0.key + " start " + this.this$0.getRunAttemptCount());
                    SessionManager sessionManager = this.this$0.sessionManager;
                    SessionWorker$doWork$2$2$session$1 sessionWorker$doWork$2$2$session$1 = new SessionWorker$doWork$2$2$session$1(this.this$0, null);
                    this.label = 1;
                    objRunWithLock = sessionManager.runWithLock(sessionWorker$doWork$2$2$session$1, this);
                    if (objRunWithLock != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    objRunWithLock = obj;
                } else {
                    if (i != 2) {
                        if (i == 3) {
                            ResultKt.throwOnFailure(obj);
                            return ListenableWorker.Result.success();
                        }
                        if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Throwable th = (Throwable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        throw th;
                    }
                    session = (Session) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        GlanceLog.INSTANCE.m2301i("GWT:SessionWorker", "SessionWorker " + this.this$0.key + " end");
                        NonCancellable nonCancellable2 = NonCancellable.INSTANCE;
                        C145932 c1459322 = new C145932(this.this$0, session, null);
                        this.L$0 = null;
                        this.label = 3;
                    } catch (Throwable th2) {
                        th = th2;
                        GlanceLog.INSTANCE.m2301i("GWT:SessionWorker", "SessionWorker " + this.this$0.key + " end");
                        nonCancellable = NonCancellable.INSTANCE;
                        c145932 = new C145932(this.this$0, session, null);
                        this.L$0 = th;
                        this.label = 4;
                        if (BuildersKt.withContext(nonCancellable, c145932, this) == coroutine_suspended) {
                            throw th;
                        }
                    }
                }
                Session session2 = (Session) objRunWithLock;
                if (session2 == null) {
                    if (this.this$0.params.getRunAttemptCount() == 0) {
                        throw new IllegalStateException(("No session available for key " + this.this$0.key).toString());
                    }
                    GlanceLog.INSTANCE.m2305w("GWT:SessionWorker", "SessionWorker attempted restart but Session is not available for " + this.this$0.key);
                    return ListenableWorker.Result.success();
                }
                try {
                    TimerScope timerScope = this.$$this$withTimerOrNull;
                    Context applicationContext = this.this$0.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    TimeoutOptions timeoutOptions = this.this$0.timeouts;
                    final SessionWorker sessionWorker = this.this$0;
                    Function0<Job> function0 = new Function0<Job>() { // from class: androidx.glance.session.SessionWorker.doWork.2.2.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final Job invoke() {
                            CompletableJob completableJobJob$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                            sessionWorker.setEffectJob$glance_release(completableJobJob$default);
                            return completableJobJob$default;
                        }
                    };
                    this.L$0 = session2;
                    this.label = 2;
                    if (SessionWorkerKt.runSession(timerScope, applicationContext, session2, timeoutOptions, function0, this) != coroutine_suspended) {
                        session = session2;
                        GlanceLog.INSTANCE.m2301i("GWT:SessionWorker", "SessionWorker " + this.this$0.key + " end");
                        NonCancellable nonCancellable22 = NonCancellable.INSTANCE;
                        C145932 c14593222 = new C145932(this.this$0, session, null);
                        this.L$0 = null;
                        this.label = 3;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    session = session2;
                    GlanceLog.INSTANCE.m2301i("GWT:SessionWorker", "SessionWorker " + this.this$0.key + " end");
                    nonCancellable = NonCancellable.INSTANCE;
                    c145932 = new C145932(this.this$0, session, null);
                    this.L$0 = th;
                    this.label = 4;
                    if (BuildersKt.withContext(nonCancellable, c145932, this) == coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Object invoke(@Nullable Continuation<? super ListenableWorker.Result> continuation) {
                return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        public C35112(Continuation<? super C35112> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C35112 c35112 = SessionWorker.this.new C35112(continuation);
            c35112.L$0 = obj;
            return c35112;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull TimerScope timerScope, @Nullable Continuation<? super ListenableWorker.Result> continuation) {
            return ((C35112) create(timerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            TimerScope timerScope = (TimerScope) this.L$0;
            Context applicationContext = SessionWorker.this.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(timerScope, SessionWorker.this, null);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(SessionWorker.this, timerScope, null);
            this.label = 1;
            Object objObserveIdleEvents = IdleEventBroadcastReceiverKt.observeIdleEvents(applicationContext, anonymousClass1, anonymousClass2, this);
            return objObserveIdleEvents == coroutine_suspended ? coroutine_suspended : objObserveIdleEvents;
        }
    }

    public /* synthetic */ SessionWorker(Context context, WorkerParameters workerParameters, SessionManager sessionManager, TimeoutOptions timeoutOptions, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, workerParameters, (i & 4) != 0 ? SessionManagerKt.getGlanceSessionManager() : sessionManager, (i & 8) != 0 ? new TimeoutOptions(0L, 0L, 0L, null, 15, null) : timeoutOptions, (i & 16) != 0 ? Dispatchers.getMain() : coroutineDispatcher);
    }

    private final void forceUpdateAppWidget() {
        int i = Integer.parseInt((String) CollectionsKt.last(StringsKt__StringsKt.split$default(this.key, new String[]{CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR}, false, 0, 6, (Object) null)));
        GlanceLog.INSTANCE.m2305w("GWT:SessionWorker", this.key + " forceUpdateAppWidget");
        Context context = this.appContext;
        Intent intent = new Intent(SessionWorkerKt.FORCE_UPDATE_APP_WIDGET);
        intent.setPackage(this.appContext.getPackageName());
        intent.putExtra(SessionWorkerKt.FORCE_UPDATE_WIDGET_ID, i);
        context.sendBroadcast(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    @RequiresApi(31)
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doWork(@NotNull Continuation<? super ListenableWorker.Result> continuation) {
        C35101 c35101;
        SessionWorker sessionWorker;
        String strM1615e;
        if (continuation instanceof C35101) {
            c35101 = (C35101) continuation;
            int i = c35101.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c35101.label = i - Integer.MIN_VALUE;
            } else {
                c35101 = new C35101(continuation);
            }
        }
        Object objWithTimerOrNull = c35101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c35101.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithTimerOrNull);
            try {
                TimeSource timeSource = this.timeouts.getTimeSource();
                C35112 c35112 = new C35112(null);
                c35101.L$0 = this;
                c35101.label = 1;
                objWithTimerOrNull = TimerScopeKt.withTimerOrNull(timeSource, c35112, c35101);
                if (objWithTimerOrNull == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sessionWorker = this;
            } catch (Exception e) {
                e = e;
                sessionWorker = this;
                switch (sessionWorker.getStopReason()) {
                    case 0:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_UNDEFINED");
                        break;
                    case 1:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_CANCELLED_BY_APP");
                        break;
                    case 2:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_PREEMPT");
                        break;
                    case 3:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_TIMEOUT");
                        break;
                    case 4:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_DEVICE_STATE");
                        break;
                    case 5:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_CONSTRAINT_BATTERY_NOT_LOW");
                        break;
                    case 6:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_CONSTRAINT_CHARGING");
                        break;
                    case 7:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_CONSTRAINT_CONNECTIVITY");
                        break;
                    case 8:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_CONSTRAINT_DEVICE_IDLE");
                        break;
                    case 9:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_CONSTRAINT_STORAGE_NOT_LOW");
                        break;
                    case 10:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_QUOTA");
                        break;
                    case 11:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_BACKGROUND_RESTRICTION");
                        break;
                    case 12:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_APP_STANDBY");
                        break;
                    case 13:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_USER");
                        break;
                    case 14:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_SYSTEM_PROCESSING");
                        break;
                    case 15:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " STOP_REASON_ESTIMATED_APP_LAUNCH_TIME_CHANGED");
                        break;
                    default:
                        strM1615e = AbstractC2322a.m1615e(sessionWorker.getStopReason(), " UNKNOWN_STOP_REASON");
                        break;
                }
                GlanceLog.INSTANCE.m2305w("GWT:SessionWorker", sessionWorker.key + " Worker is canceled because of " + e + " : " + strM1615e);
                if (sessionWorker.getStopReason() != 4 || sessionWorker.getStopReason() == 11) {
                    sessionWorker.forceUpdateAppWidget();
                }
                ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
                Intrinsics.checkNotNull(resultSuccess);
                return resultSuccess;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sessionWorker = (SessionWorker) c35101.L$0;
            try {
                ResultKt.throwOnFailure(objWithTimerOrNull);
            } catch (Exception e2) {
                e = e2;
                switch (sessionWorker.getStopReason()) {
                }
                GlanceLog.INSTANCE.m2305w("GWT:SessionWorker", sessionWorker.key + " Worker is canceled because of " + e + " : " + strM1615e);
                if (sessionWorker.getStopReason() != 4) {
                    sessionWorker.forceUpdateAppWidget();
                }
                ListenableWorker.Result resultSuccess2 = ListenableWorker.Result.success();
                Intrinsics.checkNotNull(resultSuccess2);
                return resultSuccess2;
            }
        }
        ListenableWorker.Result resultSuccess3 = (ListenableWorker.Result) objWithTimerOrNull;
        if (resultSuccess3 == null) {
            resultSuccess3 = ListenableWorker.Result.success(new Data.Builder().putBoolean(TIMEOUT_EXIT_REASON, true).build());
        }
        Intrinsics.checkNotNull(resultSuccess3);
        return resultSuccess3;
    }

    @Override // androidx.work.CoroutineWorker
    @NotNull
    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    @Nullable
    /* JADX INFO: renamed from: getEffectJob$glance_release, reason: from getter */
    public final Job getEffectJob() {
        return this.effectJob;
    }

    public final void setEffectJob$glance_release(@Nullable Job job) {
        this.effectJob = job;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionWorker(@NotNull Context appContext, @NotNull WorkerParameters params, @NotNull SessionManager sessionManager, @NotNull TimeoutOptions timeouts, @NotNull CoroutineDispatcher coroutineContext) {
        super(appContext, params);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        Intrinsics.checkNotNullParameter(timeouts, "timeouts");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.appContext = appContext;
        this.params = params;
        this.sessionManager = sessionManager;
        this.timeouts = timeouts;
        this.coroutineContext = coroutineContext;
        String string = getInputData().getString(sessionManager.getKeyParam());
        if (string == null) {
            throw new IllegalStateException("SessionWorker must be started with a key");
        }
        this.key = string;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionWorker(@NotNull Context appContext, @NotNull WorkerParameters params) {
        this(appContext, params, SessionManagerKt.getGlanceSessionManager(), null, null, 24, null);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(params, "params");
    }

    @Deprecated(message = "Deprecated by super class, replacement in progress, see b/245353737")
    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getEffectJob$glance_release$annotations() {
    }
}
