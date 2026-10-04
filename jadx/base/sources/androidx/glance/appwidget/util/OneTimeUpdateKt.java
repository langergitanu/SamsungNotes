package androidx.glance.appwidget.util;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.Recomposer;
import androidx.glance.Applier;
import androidx.glance.Emittable;
import androidx.glance.EmittableWithChildren;
import androidx.glance.appwidget.AppWidgetId;
import androidx.glance.appwidget.AppWidgetSession;
import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.appwidget.RemoteViewsRoot;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.session.InteractiveFrameClock;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0080@¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "updateForOneTime", "", "Landroidx/glance/appwidget/GlanceAppWidget;", "context", "Landroid/content/Context;", "glanceId", "Landroidx/glance/appwidget/AppWidgetId;", "options", "Landroid/os/Bundle;", "(Landroidx/glance/appwidget/GlanceAppWidget;Landroid/content/Context;Landroidx/glance/appwidget/AppWidgetId;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class OneTimeUpdateKt {

    @NotNull
    private static final String TAG = "GWT:OneTimeUpdate";

    /* JADX INFO: renamed from: androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2", m14021f = "OneTimeUpdate.kt", m14022i = {}, m14023l = {48}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C30742 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ AppWidgetId $glanceId;
        final /* synthetic */ Bundle $options;
        final /* synthetic */ GlanceAppWidget $this_updateForOneTime;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2$1", m14021f = "OneTimeUpdate.kt", m14022i = {}, m14023l = {81, 86, 88}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Composition $composition;
            final /* synthetic */ Context $context;
            final /* synthetic */ InteractiveFrameClock $frameClock;
            final /* synthetic */ AppWidgetId $glanceId;
            final /* synthetic */ Recomposer $recomposer;
            final /* synthetic */ RemoteViewsRoot $root;
            final /* synthetic */ AppWidgetSession $session;
            final /* synthetic */ Job $snapshotMonitor;
            final /* synthetic */ MutableStateFlow<Boolean> $uiReady;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2$1$1", m14021f = "OneTimeUpdate.kt", m14022i = {}, m14023l = {52}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class C145641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Composition $composition;
                final /* synthetic */ Context $context;
                final /* synthetic */ Recomposer $recomposer;
                final /* synthetic */ AppWidgetSession $session;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C145641(Composition composition, AppWidgetSession appWidgetSession, Context context, Recomposer recomposer, Continuation<? super C145641> continuation) {
                    super(2, continuation);
                    this.$composition = composition;
                    this.$session = appWidgetSession;
                    this.$context = context;
                    this.$recomposer = recomposer;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C145641(this.$composition, this.$session, this.$context, this.$recomposer, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.$composition.setContent(this.$session.mo21926provideGlance(this.$context));
                        Recomposer recomposer = this.$recomposer;
                        this.label = 1;
                        if (recomposer.runRecomposeAndApplyChanges(this) == coroutine_suspended) {
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
                    return ((C145641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX INFO: renamed from: androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2$1$2", m14021f = "OneTimeUpdate.kt", m14022i = {}, m14023l = {56}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Context $context;
                final /* synthetic */ Recomposer $recomposer;
                final /* synthetic */ RemoteViewsRoot $root;
                final /* synthetic */ AppWidgetSession $session;
                final /* synthetic */ MutableStateFlow<Boolean> $uiReady;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(Recomposer recomposer, MutableStateFlow<Boolean> mutableStateFlow, AppWidgetSession appWidgetSession, Context context, RemoteViewsRoot remoteViewsRoot, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$recomposer = recomposer;
                    this.$uiReady = mutableStateFlow;
                    this.$session = appWidgetSession;
                    this.$context = context;
                    this.$root = remoteViewsRoot;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$recomposer, this.$uiReady, this.$session, this.$context, this.$root, continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
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
                        C145651 c145651 = new C145651(this.$recomposer, longRef, this.$uiReady, this.$session, this.$context, this.$root, coroutineScope);
                        this.label = 1;
                        if (currentState.collect(c145651, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    throw new KotlinNothingValueException();
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2$1$2$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m13886d2 = {"<anonymous>", "", "state", "Landroidx/compose/runtime/Recomposer$State;", "emit", "(Landroidx/compose/runtime/Recomposer$State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
                public static final class C145651<T> implements FlowCollector {
                    final /* synthetic */ CoroutineScope $$this$launch;
                    final /* synthetic */ Context $context;
                    final /* synthetic */ Ref.LongRef $lastRecomposeCount;
                    final /* synthetic */ Recomposer $recomposer;
                    final /* synthetic */ RemoteViewsRoot $root;
                    final /* synthetic */ AppWidgetSession $session;
                    final /* synthetic */ MutableStateFlow<Boolean> $uiReady;

                    /* JADX INFO: renamed from: androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2$1$2$1$WhenMappings */
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

                    public C145651(Recomposer recomposer, Ref.LongRef longRef, MutableStateFlow<Boolean> mutableStateFlow, AppWidgetSession appWidgetSession, Context context, RemoteViewsRoot remoteViewsRoot, CoroutineScope coroutineScope) {
                        this.$recomposer = recomposer;
                        this.$lastRecomposeCount = longRef;
                        this.$uiReady = mutableStateFlow;
                        this.$session = appWidgetSession;
                        this.$context = context;
                        this.$root = remoteViewsRoot;
                        this.$$this$launch = coroutineScope;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cf, code lost:
                    
                        if (r9.emit(r2, r0) != r1) goto L37;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(@NotNull Recomposer.State state, @NotNull Continuation<? super Unit> continuation) throws Throwable {
                        OneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1 oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1;
                        C145651<T> c145651;
                        if (continuation instanceof OneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1) {
                            oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1 = (OneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1) continuation;
                            int i = oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1.label = i - Integer.MIN_VALUE;
                            } else {
                                oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1 = new OneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1(this, continuation);
                            }
                        }
                        Object objProcessEmittableTree = oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i2 = oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1.label;
                        if (i2 == 0) {
                            ResultKt.throwOnFailure(objProcessEmittableTree);
                            int i4 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                            if (i4 != 1) {
                                if (i4 == 2) {
                                    CoroutineScopeKt.cancel$default(this.$$this$launch, null, 1, null);
                                }
                            } else {
                                if (this.$recomposer.getChangeCount() > this.$lastRecomposeCount.element || !this.$uiReady.getValue().booleanValue()) {
                                    AppWidgetSession appWidgetSession = this.$session;
                                    Context context = this.$context;
                                    Emittable emittableCopy = this.$root.copy();
                                    Intrinsics.checkNotNull(emittableCopy, "null cannot be cast to non-null type androidx.glance.EmittableWithChildren");
                                    oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1.L$0 = this;
                                    oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1.label = 1;
                                    objProcessEmittableTree = appWidgetSession.processEmittableTree(context, (EmittableWithChildren) emittableCopy, oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1);
                                    if (objProcessEmittableTree != coroutine_suspended) {
                                        c145651 = this;
                                        boolean zBooleanValue = ((Boolean) objProcessEmittableTree).booleanValue();
                                        GlanceLog.INSTANCE.m2301i(OneTimeUpdateKt.TAG, "Session is processed / " + zBooleanValue);
                                        if (!c145651.$uiReady.getValue().booleanValue()) {
                                            MutableStateFlow<Boolean> mutableStateFlow = c145651.$uiReady;
                                            Boolean boolBoxBoolean = Boxing.boxBoolean(true);
                                            oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1.L$0 = c145651;
                                            oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1.label = 2;
                                        }
                                        c145651.$lastRecomposeCount.element = c145651.$recomposer.getChangeCount();
                                    }
                                    return coroutine_suspended;
                                }
                                c145651 = this;
                                c145651.$lastRecomposeCount.element = c145651.$recomposer.getChangeCount();
                            }
                        } else if (i2 == 1) {
                            c145651 = (C145651) oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1.L$0;
                            ResultKt.throwOnFailure(objProcessEmittableTree);
                            boolean zBooleanValue2 = ((Boolean) objProcessEmittableTree).booleanValue();
                            GlanceLog.INSTANCE.m2301i(OneTimeUpdateKt.TAG, "Session is processed / " + zBooleanValue2);
                            if (!c145651.$uiReady.getValue().booleanValue() && zBooleanValue2) {
                                MutableStateFlow<Boolean> mutableStateFlow2 = c145651.$uiReady;
                                Boolean boolBoxBoolean2 = Boxing.boxBoolean(true);
                                oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1.L$0 = c145651;
                                oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1.label = 2;
                            }
                            c145651.$lastRecomposeCount.element = c145651.$recomposer.getChangeCount();
                        } else {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            c145651 = (C145651) oneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1.L$0;
                            ResultKt.throwOnFailure(objProcessEmittableTree);
                            c145651.$lastRecomposeCount.element = c145651.$recomposer.getChangeCount();
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                        return emit((Recomposer.State) obj, (Continuation<? super Unit>) continuation);
                    }
                }
            }

            /* JADX INFO: renamed from: androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", "", LangPackConfigConstants.LANGUAGE_CODE_IT}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2$1$3", m14021f = "OneTimeUpdate.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class AnonymousClass3 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
                /* synthetic */ boolean Z$0;
                int label;

                public AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                    anonymousClass3.Z$0 = ((Boolean) obj).booleanValue();
                    return anonymousClass3;
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
                    boolean z = this.Z$0;
                    GlanceLog.INSTANCE.m2301i(OneTimeUpdateKt.TAG, "get uiready " + z);
                    return Boxing.boxBoolean(z);
                }

                @Nullable
                public final Object invoke(boolean z, @Nullable Continuation<? super Boolean> continuation) {
                    return ((AnonymousClass3) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(InteractiveFrameClock interactiveFrameClock, MutableStateFlow<Boolean> mutableStateFlow, Composition composition, AppWidgetSession appWidgetSession, Context context, Recomposer recomposer, RemoteViewsRoot remoteViewsRoot, Job job, CoroutineScope coroutineScope, AppWidgetId appWidgetId, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$frameClock = interactiveFrameClock;
                this.$uiReady = mutableStateFlow;
                this.$composition = composition;
                this.$session = appWidgetSession;
                this.$context = context;
                this.$recomposer = recomposer;
                this.$root = remoteViewsRoot;
                this.$snapshotMonitor = job;
                this.$$this$coroutineScope = coroutineScope;
                this.$glanceId = appWidgetId;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$frameClock, this.$uiReady, this.$composition, this.$session, this.$context, this.$recomposer, this.$root, this.$snapshotMonitor, this.$$this$coroutineScope, this.$glanceId, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(1:32)|(1:(1:(3:7|28|29)(2:8|9))(1:12))(4:14|15|(1:17)|27)|18|19|30|20|21|(1:(0))) */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0097, code lost:
            
                if (androidx.glance.appwidget.util.OneTimeUpdateKt.C30742.invokeSuspend$clearResource(r5, r6, r7, r8, r9, r10, r14) == r0) goto L27;
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x009a, code lost:
            
                r7 = r14;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x009b, code lost:
            
                r1 = r7.$composition;
                r2 = r7.$frameClock;
                r3 = r7.$snapshotMonitor;
                r4 = r7.$recomposer;
                r5 = r7.$$this$coroutineScope;
                r6 = r7.$glanceId;
                r7.label = 3;
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x00ae, code lost:
            
                if (androidx.glance.appwidget.util.OneTimeUpdateKt.C30742.invokeSuspend$clearResource(r1, r2, r3, r4, r5, r6, r7) != r0) goto L28;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                } catch (Exception unused) {
                    AnonymousClass1 anonymousClass1 = this;
                }
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, this.$frameClock, null, new C145641(this.$composition, this.$session, this.$context, this.$recomposer, null), 2, null);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(this.$recomposer, this.$uiReady, this.$session, this.$context, this.$root, null), 3, null);
                    GlanceLog.INSTANCE.m2301i(OneTimeUpdateKt.TAG, "Waiting for widget ui...");
                    MutableStateFlow<Boolean> mutableStateFlow = this.$uiReady;
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(null);
                    this.label = 1;
                    if (FlowKt.first(mutableStateFlow, anonymousClass3, this) == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2 && i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                GlanceLog.INSTANCE.m2301i(OneTimeUpdateKt.TAG, "Widget ui is generated");
                Composition composition = this.$composition;
                InteractiveFrameClock interactiveFrameClock = this.$frameClock;
                Job job = this.$snapshotMonitor;
                Recomposer recomposer = this.$recomposer;
                CoroutineScope coroutineScope2 = this.$$this$coroutineScope;
                AppWidgetId appWidgetId = this.$glanceId;
                this.label = 2;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C30742(AppWidgetId appWidgetId, GlanceAppWidget glanceAppWidget, Bundle bundle, Context context, Continuation<? super C30742> continuation) {
            super(2, continuation);
            this.$glanceId = appWidgetId;
            this.$this_updateForOneTime = glanceAppWidget;
            this.$options = bundle;
            this.$context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final Object invokeSuspend$clearResource(Composition composition, InteractiveFrameClock interactiveFrameClock, Job job, Recomposer recomposer, CoroutineScope coroutineScope, AppWidgetId appWidgetId, Continuation<? super Unit> continuation) {
            OneTimeUpdateKt$updateForOneTime$2$clearResource$1 oneTimeUpdateKt$updateForOneTime$2$clearResource$1;
            if (continuation instanceof OneTimeUpdateKt$updateForOneTime$2$clearResource$1) {
                oneTimeUpdateKt$updateForOneTime$2$clearResource$1 = (OneTimeUpdateKt$updateForOneTime$2$clearResource$1) continuation;
                int i = oneTimeUpdateKt$updateForOneTime$2$clearResource$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    oneTimeUpdateKt$updateForOneTime$2$clearResource$1.label = i - Integer.MIN_VALUE;
                } else {
                    oneTimeUpdateKt$updateForOneTime$2$clearResource$1 = new OneTimeUpdateKt$updateForOneTime$2$clearResource$1(continuation);
                }
            }
            Object obj = oneTimeUpdateKt$updateForOneTime$2$clearResource$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = oneTimeUpdateKt$updateForOneTime$2$clearResource$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                composition.dispose();
                interactiveFrameClock.stopInteractive();
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                recomposer.close();
                oneTimeUpdateKt$updateForOneTime$2$clearResource$1.L$0 = coroutineScope;
                oneTimeUpdateKt$updateForOneTime$2$clearResource$1.L$1 = appWidgetId;
                oneTimeUpdateKt$updateForOneTime$2$clearResource$1.label = 1;
                if (recomposer.join(oneTimeUpdateKt$updateForOneTime$2$clearResource$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                appWidgetId = (AppWidgetId) oneTimeUpdateKt$updateForOneTime$2$clearResource$1.L$1;
                coroutineScope = (CoroutineScope) oneTimeUpdateKt$updateForOneTime$2$clearResource$1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            JobKt.cancel(coroutineScope.getCoroutineContext(), new CancellationException("Clear " + appWidgetId + " resource"));
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C30742 c30742 = new C30742(this.$glanceId, this.$this_updateForOneTime, this.$options, this.$context, continuation);
            c30742.L$0 = obj;
            return c30742;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                GlanceLog.INSTANCE.m2301i(OneTimeUpdateKt.TAG, "Update AppWidget-" + this.$glanceId + " for one time");
                InteractiveFrameClock interactiveFrameClock = new InteractiveFrameClock(coroutineScope, 0, 0, 0L, null, 30, null);
                Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OneTimeUpdateKt$updateForOneTime$2$snapshotMonitor$1(null), 3, null);
                AppWidgetSession appWidgetSession = new AppWidgetSession(this.$this_updateForOneTime, this.$glanceId, this.$options, null, null, null, false, null, 248, null);
                RemoteViewsRoot remoteViewsRootCreateRootEmittable = appWidgetSession.createRootEmittable();
                MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(Boxing.boxBoolean(false));
                Recomposer recomposer = new Recomposer(coroutineScope.getCoroutineContext());
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(interactiveFrameClock, MutableStateFlow, CompositionKt.Composition(new Applier(remoteViewsRootCreateRootEmittable), recomposer), appWidgetSession, this.$context, recomposer, remoteViewsRootCreateRootEmittable, jobLaunch$default, coroutineScope, this.$glanceId, null);
                this.label = 1;
                if (TimeoutKt.withTimeout(2000L, anonymousClass1, this) == coroutine_suspended) {
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
            return ((C30742) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Nullable
    public static final Object updateForOneTime(@NotNull GlanceAppWidget glanceAppWidget, @NotNull Context context, @NotNull AppWidgetId appWidgetId, @Nullable Bundle bundle, @NotNull Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C30742(appWidgetId, glanceAppWidget, bundle, context, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }
}
