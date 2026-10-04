package androidx.glance.session;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.Recomposer;
import androidx.glance.Applier;
import androidx.glance.Emittable;
import androidx.glance.EmittableWithChildren;
import androidx.glance.oneui.common.GlanceLog;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0087@¢\u0006\u0002\u0010\t\u001a:\u0010\u0004\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0082@¢\u0006\u0002\u0010\u0011\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0087T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0006X\u0087T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"FORCE_UPDATE_APP_WIDGET", "", "FORCE_UPDATE_WIDGET_ID", SearchConstants.TargetContents.TAG, "runSession", "", "Landroidx/glance/session/Session;", "context", "Landroid/content/Context;", "(Landroidx/glance/session/Session;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/glance/session/TimerScope;", "session", "timeouts", "Landroidx/glance/session/TimeoutOptions;", "effectJobFactory", "Lkotlin/Function0;", "Lkotlinx/coroutines/Job;", "(Landroidx/glance/session/TimerScope;Landroid/content/Context;Landroidx/glance/session/Session;Landroidx/glance/session/TimeoutOptions;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSessionWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SessionWorker.kt\nandroidx/glance/session/SessionWorkerKt\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,320:1\n48#2,4:321\n*S KotlinDebug\n*F\n+ 1 SessionWorker.kt\nandroidx/glance/session/SessionWorkerKt\n*L\n221#1:321,4\n*E\n"})
public final class SessionWorkerKt {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final String FORCE_UPDATE_APP_WIDGET = "com.samsung.intent.action.TEMPLATE_WIDGET_FORCE_UPDATE";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final String FORCE_UPDATE_WIDGET_ID = "force_widget_id";

    @NotNull
    private static final String TAG = "GWT:SessionWorker";

    /* JADX INFO: renamed from: androidx.glance.session.SessionWorkerKt$runSession$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.SessionWorkerKt", m14021f = "SessionWorker.kt", m14022i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m14023l = {280, 281}, m14024m = "runSession", m14025n = {"$this$runSession", "context", "session", "timeouts", "frameClock", "snapshotMonitor", "recomposer", "composition", "session", "frameClock", "snapshotMonitor", "recomposer", "composition"}, m14026s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class C35121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C35121(Continuation<? super C35121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionWorkerKt.runSession(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.session.SessionWorkerKt$runSession$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.SessionWorkerKt$runSession$3", m14021f = "SessionWorker.kt", m14022i = {1}, m14023l = {JPEG.APP14, 242}, m14024m = "invokeSuspend", m14025n = {"throwable"}, m14026s = {"L$0"})
    public static final class C35143 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Composition $composition;
        final /* synthetic */ Context $context;
        final /* synthetic */ Recomposer $recomposer;
        final /* synthetic */ Session $session;
        final /* synthetic */ TimerScope $this_runSession;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C35143(Composition composition, Session session, Context context, Recomposer recomposer, TimerScope timerScope, Continuation<? super C35143> continuation) {
            super(2, continuation);
            this.$composition = composition;
            this.$session = session;
            this.$context = context;
            this.$recomposer = recomposer;
            this.$this_runSession = timerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C35143(this.$composition, this.$session, this.$context, this.$recomposer, this.$this_runSession, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
        
            if (r6.runRecomposeAndApplyChanges(r5) == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (CancellationException unused) {
            } catch (Throwable th2) {
                Session session = this.$session;
                Context context = this.$context;
                this.L$0 = th2;
                this.label = 2;
                if (session.onCompositionError(context, th2, this) != coroutine_suspended) {
                    th = th2;
                }
                return coroutine_suspended;
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.$composition.setContent(this.$session.mo21926provideGlance(this.$context));
                Recomposer recomposer = this.$recomposer;
                this.label = 1;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    th = (Throwable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    CoroutineScopeKt.cancel(this.$this_runSession, "Error in recomposition coroutine", th);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C35143) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.session.SessionWorkerKt$runSession$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.SessionWorkerKt$runSession$4", m14021f = "SessionWorker.kt", m14022i = {}, m14023l = {248}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C35154 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Recomposer $recomposer;
        final /* synthetic */ EmittableWithChildren $root;
        final /* synthetic */ Session $session;
        final /* synthetic */ TimerScope $this_runSession;
        final /* synthetic */ TimeoutOptions $timeouts;
        final /* synthetic */ MutableStateFlow<Boolean> $uiReady;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.glance.session.SessionWorkerKt$runSession$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "state", "Landroidx/compose/runtime/Recomposer$State;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.glance.session.SessionWorkerKt$runSession$4$1", m14021f = "SessionWorker.kt", m14022i = {}, m14023l = {260, 267}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<Recomposer.State, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$launch;
            final /* synthetic */ Context $context;
            final /* synthetic */ Ref.LongRef $lastRecomposeCount;
            final /* synthetic */ Recomposer $recomposer;
            final /* synthetic */ EmittableWithChildren $root;
            final /* synthetic */ Session $session;
            final /* synthetic */ TimerScope $this_runSession;
            final /* synthetic */ TimeoutOptions $timeouts;
            final /* synthetic */ MutableStateFlow<Boolean> $uiReady;
            /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.glance.session.SessionWorkerKt$runSession$4$1$WhenMappings */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Recomposer.State.values().length];
                    try {
                        iArr[Recomposer.State.Idle.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Recomposer.State.ShutDown.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Recomposer recomposer, Ref.LongRef longRef, MutableStateFlow<Boolean> mutableStateFlow, Session session, Context context, EmittableWithChildren emittableWithChildren, TimerScope timerScope, TimeoutOptions timeoutOptions, CoroutineScope coroutineScope, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$recomposer = recomposer;
                this.$lastRecomposeCount = longRef;
                this.$uiReady = mutableStateFlow;
                this.$session = session;
                this.$context = context;
                this.$root = emittableWithChildren;
                this.$this_runSession = timerScope;
                this.$timeouts = timeoutOptions;
                this.$$this$launch = coroutineScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$recomposer, this.$lastRecomposeCount, this.$uiReady, this.$session, this.$context, this.$root, this.$this_runSession, this.$timeouts, this.$$this$launch, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull Recomposer.State state, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:26:0x00b4, code lost:
            
                if (r9.emit(r1, r8) == r0) goto L27;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    int i2 = WhenMappings.$EnumSwitchMapping$0[((Recomposer.State) this.L$0).ordinal()];
                    if (i2 != 1) {
                        if (i2 == 2) {
                            CoroutineScopeKt.cancel$default(this.$$this$launch, null, 1, null);
                        }
                        return Unit.INSTANCE;
                    }
                    if (this.$recomposer.getChangeCount() > this.$lastRecomposeCount.element || !this.$uiReady.getValue().booleanValue()) {
                        GlanceLog.INSTANCE.m2297d(SessionWorkerKt.TAG, "UI tree updated (" + this.$session.getKey() + ")");
                        Session session = this.$session;
                        Context context = this.$context;
                        Emittable emittableCopy = this.$root.copy();
                        Intrinsics.checkNotNull(emittableCopy, "null cannot be cast to non-null type androidx.glance.EmittableWithChildren");
                        this.label = 1;
                        obj = session.processEmittableTree(context, (EmittableWithChildren) emittableCopy, this);
                        if (obj != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    this.$lastRecomposeCount.element = this.$recomposer.getChangeCount();
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$this_runSession.mo21979startTimerLRDsOJo(this.$timeouts.m21976getInitialTimeoutUwyO8pc());
                    this.$lastRecomposeCount.element = this.$recomposer.getChangeCount();
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                if (!this.$uiReady.getValue().booleanValue() && zBooleanValue) {
                    MutableStateFlow<Boolean> mutableStateFlow = this.$uiReady;
                    Boolean boolBoxBoolean = Boxing.boxBoolean(true);
                    this.label = 2;
                }
                this.$lastRecomposeCount.element = this.$recomposer.getChangeCount();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C35154(Recomposer recomposer, MutableStateFlow<Boolean> mutableStateFlow, Session session, Context context, EmittableWithChildren emittableWithChildren, TimerScope timerScope, TimeoutOptions timeoutOptions, Continuation<? super C35154> continuation) {
            super(2, continuation);
            this.$recomposer = recomposer;
            this.$uiReady = mutableStateFlow;
            this.$session = session;
            this.$context = context;
            this.$root = emittableWithChildren;
            this.$this_runSession = timerScope;
            this.$timeouts = timeoutOptions;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C35154 c35154 = new C35154(this.$recomposer, this.$uiReady, this.$session, this.$context, this.$root, this.$this_runSession, this.$timeouts, continuation);
            c35154.L$0 = obj;
            return c35154;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = this.$recomposer.getChangeCount();
                StateFlow<Recomposer.State> currentState = this.$recomposer.getCurrentState();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$recomposer, longRef, this.$uiReady, this.$session, this.$context, this.$root, this.$this_runSession, this.$timeouts, coroutineScope, null);
                this.label = 1;
                if (FlowKt.collectLatest(currentState, anonymousClass1, this) == coroutine_suspended) {
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
            return ((C35154) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.session.SessionWorkerKt$runSession$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", "", LangPackConfigConstants.LANGUAGE_CODE_IT}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.SessionWorkerKt$runSession$5", m14021f = "SessionWorker.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C35165 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        public C35165(Continuation<? super C35165> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C35165 c35165 = new C35165(continuation);
            c35165.Z$0 = ((Boolean) obj).booleanValue();
            return c35165;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Boolean> continuation) {
            return invoke(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(this.Z$0);
        }

        @Nullable
        public final Object invoke(boolean z, @Nullable Continuation<? super Boolean> continuation) {
            return ((C35165) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.session.SessionWorkerKt$runSession$8 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/glance/session/TimerScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.SessionWorkerKt$runSession$8", m14021f = "SessionWorker.kt", m14022i = {}, m14023l = {306}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C35188 extends SuspendLambda implements Function2<TimerScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Session $this_runSession;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C35188(Context context, Session session, Continuation<? super C35188> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$this_runSession = session;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C35188 c35188 = new C35188(this.$context, this.$this_runSession, continuation);
            c35188.L$0 = obj;
            return c35188;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull TimerScope timerScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C35188) create(timerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TimerScope timerScope = (TimerScope) this.L$0;
                Context context = this.$context;
                Session session = this.$this_runSession;
                TimeoutOptions timeoutOptions = new TimeoutOptions(0L, 0L, 0L, null, 15, null);
                this.label = 1;
                if (SessionWorkerKt.runSession$default(timerScope, context, session, timeoutOptions, null, this, 8, null) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object runSession(TimerScope timerScope, Context context, Session session, TimeoutOptions timeoutOptions, Function0<? extends Job> function0, Continuation<? super Unit> continuation) throws Throwable {
        C35121 c35121;
        String str;
        String str2;
        CancellationException cancellationException;
        InteractiveFrameClock interactiveFrameClock;
        String str3;
        Session session2;
        String str4;
        Composition composition;
        Recomposer recomposer;
        Job job;
        Composition composition2;
        Recomposer recomposer2;
        InteractiveFrameClock interactiveFrameClock2;
        Job job2;
        C35154 c35154;
        final TimerScope timerScope2;
        final TimeoutOptions timeoutOptions2;
        final Session session3;
        final InteractiveFrameClock interactiveFrameClock3;
        Context context2;
        Job job3;
        Function1<Object, Unit> function1;
        if (continuation instanceof C35121) {
            c35121 = (C35121) continuation;
            int i = c35121.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c35121.label = i - Integer.MIN_VALUE;
            } else {
                c35121 = new C35121(continuation);
            }
        }
        C35121 c351212 = c35121;
        Object obj = c351212.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c351212.label;
        if (i2 != 0) {
            if (i2 == 1) {
                composition2 = (Composition) c351212.L$7;
                recomposer2 = (Recomposer) c351212.L$6;
                job3 = (Job) c351212.L$5;
                interactiveFrameClock3 = (InteractiveFrameClock) c351212.L$4;
                TimeoutOptions timeoutOptions3 = (TimeoutOptions) c351212.L$3;
                session3 = (Session) c351212.L$2;
                context2 = (Context) c351212.L$1;
                TimerScope timerScope3 = (TimerScope) c351212.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    timerScope2 = timerScope3;
                    str = TAG;
                    timeoutOptions2 = timeoutOptions3;
                    str2 = "-worker resource";
                    cancellationException = null;
                    try {
                        function1 = new Function1<Object, Unit>() { // from class: androidx.glance.session.SessionWorkerKt.runSession.6

                            /* JADX INFO: renamed from: androidx.glance.session.SessionWorkerKt$runSession$6$1, reason: invalid class name */
                            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
                            @DebugMetadata(m14020c = "androidx.glance.session.SessionWorkerKt$runSession$6$1", m14021f = "SessionWorker.kt", m14022i = {}, m14023l = {287}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ InteractiveFrameClock $frameClock;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public AnonymousClass1(InteractiveFrameClock interactiveFrameClock, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$frameClock = interactiveFrameClock;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                @NotNull
                                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$frameClock, continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                @Nullable
                                public final Object invokeSuspend(@NotNull Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        InteractiveFrameClock interactiveFrameClock = this.$frameClock;
                                        this.label = 1;
                                        if (interactiveFrameClock.startInteractive(this) == coroutine_suspended) {
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
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                                invoke2(obj2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull Object it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (Duration.m23553compareToLRDsOJo(timerScope2.getTimeLeft(), timeoutOptions2.m21974getAdditionalTimeUwyO8pc()) < 0) {
                                    timerScope2.mo21977addTimeLRDsOJo(timeoutOptions2.m21974getAdditionalTimeUwyO8pc());
                                }
                                GlanceLog.INSTANCE.m2297d(SessionWorkerKt.TAG, AbstractC0541b.m775q("processing event for ", session3.getKey(), "; ", Duration.m23594toStringimpl(timerScope2.getTimeLeft()), " left"));
                                BuildersKt__Builders_commonKt.launch$default(timerScope2, null, null, new AnonymousClass1(interactiveFrameClock3, null), 3, null);
                            }
                        };
                        c351212.L$0 = session3;
                        c351212.L$1 = interactiveFrameClock3;
                        c351212.L$2 = job3;
                        c351212.L$3 = recomposer2;
                        c351212.L$4 = composition2;
                        c351212.L$5 = cancellationException;
                        c351212.L$6 = cancellationException;
                        c351212.L$7 = cancellationException;
                        c351212.label = 2;
                        if (session3.receiveEvents(context2, function1, c351212) != coroutine_suspended) {
                            recomposer = recomposer2;
                            job = job3;
                            interactiveFrameClock = interactiveFrameClock3;
                            session2 = session3;
                            GlanceLog.INSTANCE.m2301i(str, "Clear " + session2.getKey() + str2);
                            composition2.dispose();
                            interactiveFrameClock.stopInteractive();
                            Job.DefaultImpls.cancel$default(job, cancellationException, 1, (Object) cancellationException);
                            recomposer.cancel();
                            return Unit.INSTANCE;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th) {
                        th = th;
                        str3 = str2;
                        str4 = str;
                        recomposer = recomposer2;
                        job = job3;
                        interactiveFrameClock = interactiveFrameClock3;
                        session2 = session3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str4 = TAG;
                    recomposer = recomposer2;
                    job = job3;
                    interactiveFrameClock = interactiveFrameClock3;
                    session2 = session3;
                    str3 = "-worker resource";
                    cancellationException = null;
                }
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                composition2 = (Composition) c351212.L$4;
                recomposer = (Recomposer) c351212.L$3;
                job = (Job) c351212.L$2;
                interactiveFrameClock = (InteractiveFrameClock) c351212.L$1;
                session2 = (Session) c351212.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    str = TAG;
                    str2 = "-worker resource";
                    cancellationException = null;
                    GlanceLog.INSTANCE.m2301i(str, "Clear " + session2.getKey() + str2);
                    composition2.dispose();
                    interactiveFrameClock.stopInteractive();
                    Job.DefaultImpls.cancel$default(job, cancellationException, 1, (Object) cancellationException);
                    recomposer.cancel();
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    str4 = TAG;
                }
            }
            str3 = "-worker resource";
            cancellationException = null;
            GlanceLog.INSTANCE.m2301i(str4, "Clear " + session2.getKey() + str3);
            composition2.dispose();
            interactiveFrameClock.stopInteractive();
            Job.DefaultImpls.cancel$default(job, cancellationException, 1, (Object) cancellationException);
            recomposer.cancel();
            throw th;
        }
        ResultKt.throwOnFailure(obj);
        GlanceLog.INSTANCE.m2297d(TAG, "Setting up composition for " + session.getKey());
        str = TAG;
        str2 = "-worker resource";
        cancellationException = null;
        interactiveFrameClock = new InteractiveFrameClock(timerScope, 0, 0, 0L, null, 30, null);
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(timerScope, null, null, new SessionWorkerKt$runSession$snapshotMonitor$1(null), 3, null);
        EmittableWithChildren emittableWithChildrenCreateRootEmittable = session.createRootEmittable();
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(Boxing.boxBoolean(false));
        SessionWorkerKt$runSession$$inlined$CoroutineExceptionHandler$1 sessionWorkerKt$runSession$$inlined$CoroutineExceptionHandler$1 = new SessionWorkerKt$runSession$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, timerScope, session, context);
        final Job jobInvoke = function0.invoke();
        Job job4 = (Job) timerScope.getCoroutineContext().get(Job.INSTANCE);
        if (job4 != null) {
            job4.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.glance.session.SessionWorkerKt$runSession$effectCoroutineContext$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th4) {
                    invoke2(th4);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th4) {
                    Job.DefaultImpls.cancel$default(jobInvoke, (CancellationException) null, 1, (Object) null);
                }
            });
        }
        Recomposer recomposer3 = new Recomposer(timerScope.getCoroutineContext().plus(jobInvoke).plus(sessionWorkerKt$runSession$$inlined$CoroutineExceptionHandler$1));
        Composition Composition = CompositionKt.Composition(new Applier(emittableWithChildrenCreateRootEmittable), recomposer3);
        try {
            composition2 = Composition;
            try {
                composition = composition2;
                recomposer2 = recomposer3;
                try {
                    BuildersKt__Builders_commonKt.launch$default(timerScope, interactiveFrameClock, null, new C35143(composition2, session, context, recomposer3, timerScope, null), 2, null);
                    job2 = jobLaunch$default;
                    interactiveFrameClock2 = interactiveFrameClock;
                    try {
                        c35154 = new C35154(recomposer2, MutableStateFlow, session, context, emittableWithChildrenCreateRootEmittable, timerScope, timeoutOptions, null);
                        recomposer2 = recomposer2;
                        session2 = session;
                        timerScope2 = timerScope;
                    } catch (Throwable th4) {
                        th = th4;
                        recomposer2 = recomposer2;
                        session2 = session;
                        str4 = str;
                        str3 = str2;
                    }
                    try {
                        BuildersKt__Builders_commonKt.launch$default(timerScope2, null, null, c35154, 3, null);
                        C35165 c35165 = new C35165(null);
                        c351212.L$0 = timerScope2;
                        c351212.L$1 = context;
                        c351212.L$2 = session2;
                        timeoutOptions2 = timeoutOptions;
                        c351212.L$3 = timeoutOptions2;
                        c351212.L$4 = interactiveFrameClock2;
                        c351212.L$5 = job2;
                        c351212.L$6 = recomposer2;
                        c351212.L$7 = composition;
                        c351212.label = 1;
                        if (FlowKt.first(MutableStateFlow, c35165, c351212) != coroutine_suspended) {
                            session3 = session2;
                            interactiveFrameClock3 = interactiveFrameClock2;
                            composition2 = composition;
                            context2 = context;
                            job3 = job2;
                            function1 = new Function1<Object, Unit>() { // from class: androidx.glance.session.SessionWorkerKt.runSession.6

                                /* JADX INFO: renamed from: androidx.glance.session.SessionWorkerKt$runSession$6$1, reason: invalid class name */
                                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
                                @DebugMetadata(m14020c = "androidx.glance.session.SessionWorkerKt$runSession$6$1", m14021f = "SessionWorker.kt", m14022i = {}, m14023l = {287}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ InteractiveFrameClock $frameClock;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public AnonymousClass1(InteractiveFrameClock interactiveFrameClock, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$frameClock = interactiveFrameClock;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    @NotNull
                                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$frameClock, continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    @Nullable
                                    public final Object invokeSuspend(@NotNull Object obj) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            InteractiveFrameClock interactiveFrameClock = this.$frameClock;
                                            this.label = 1;
                                            if (interactiveFrameClock.startInteractive(this) == coroutine_suspended) {
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
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                                    invoke2(obj2);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull Object it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    if (Duration.m23553compareToLRDsOJo(timerScope2.getTimeLeft(), timeoutOptions2.m21974getAdditionalTimeUwyO8pc()) < 0) {
                                        timerScope2.mo21977addTimeLRDsOJo(timeoutOptions2.m21974getAdditionalTimeUwyO8pc());
                                    }
                                    GlanceLog.INSTANCE.m2297d(SessionWorkerKt.TAG, AbstractC0541b.m775q("processing event for ", session3.getKey(), "; ", Duration.m23594toStringimpl(timerScope2.getTimeLeft()), " left"));
                                    BuildersKt__Builders_commonKt.launch$default(timerScope2, null, null, new AnonymousClass1(interactiveFrameClock3, null), 3, null);
                                }
                            };
                            c351212.L$0 = session3;
                            c351212.L$1 = interactiveFrameClock3;
                            c351212.L$2 = job3;
                            c351212.L$3 = recomposer2;
                            c351212.L$4 = composition2;
                            c351212.L$5 = cancellationException;
                            c351212.L$6 = cancellationException;
                            c351212.L$7 = cancellationException;
                            c351212.label = 2;
                            if (session3.receiveEvents(context2, function1, c351212) != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    } catch (Throwable th5) {
                        th = th5;
                        str3 = str2;
                        str4 = str;
                        recomposer = recomposer2;
                        job = job2;
                        interactiveFrameClock = interactiveFrameClock2;
                        composition2 = composition;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    str3 = str2;
                    interactiveFrameClock2 = interactiveFrameClock;
                    job2 = jobLaunch$default;
                    str4 = str;
                    session2 = session;
                }
            } catch (Throwable th7) {
                th = th7;
                str3 = str2;
                str4 = str;
                session2 = session;
                recomposer = recomposer3;
                job = jobLaunch$default;
            }
        } catch (Throwable th8) {
            th = th8;
            str3 = str2;
            session2 = session;
            str4 = str;
            composition = Composition;
            recomposer = recomposer3;
            job = jobLaunch$default;
        }
    }

    public static /* synthetic */ Object runSession$default(TimerScope timerScope, Context context, Session session, TimeoutOptions timeoutOptions, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            function0 = new Function0<CompletableJob>() { // from class: androidx.glance.session.SessionWorkerKt.runSession.2
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final CompletableJob invoke() {
                    return JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                }
            };
        }
        return runSession(timerScope, context, session, timeoutOptions, function0, continuation);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public static final Object runSession(@NotNull Session session, @NotNull Context context, @NotNull Continuation<? super Unit> continuation) {
        Object objNoopTimer = TimerScopeKt.noopTimer(new C35188(context, session, null), continuation);
        return objNoopTimer == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objNoopTimer : Unit.INSTANCE;
    }
}
