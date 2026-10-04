package androidx.glance.appwidget.multiprocess;

import android.content.Context;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.Recomposer;
import androidx.glance.Applier;
import androidx.glance.appwidget.RemoteViewsRoot;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.session.InteractiveFrameClock;
import androidx.glance.session.Session;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.CoroutineSession$runComposition$3", m14021f = "CoroutineSession.kt", m14022i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2}, m14023l = {129, 130, 131, 149}, m14024m = "invokeSuspend", m14025n = {"frameClock", "snapshotMonitor", "uiReady", "recomposer", "composition", "$this$invokeSuspend_u24lambda_u240", "frameClock", "snapshotMonitor", "recomposer", "composition", "$this$invokeSuspend_u24lambda_u240", "frameClock", "snapshotMonitor", "recomposer", "composition"}, m14026s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$7", "L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$3"})
public final class CoroutineSession$runComposition$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $timer;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ CoroutineSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineSession$runComposition$3(CoroutineSession coroutineSession, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Context context, Continuation<? super CoroutineSession$runComposition$3> continuation) {
        super(2, continuation);
        this.this$0 = coroutineSession;
        this.$timer = function1;
        this.$context = context;
    }

    private static final void invokeSuspend$clear(CoroutineSession coroutineSession, Composition composition, InteractiveFrameClock interactiveFrameClock, Job job, Recomposer recomposer) {
        GlanceLog.INSTANCE.m2297d("GWT:CoroutineSession", coroutineSession.getKey() + " CoroutineSession clear");
        coroutineSession.onClosed();
        composition.dispose();
        interactiveFrameClock.stopInteractive();
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        recomposer.cancel();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CoroutineSession$runComposition$3 coroutineSession$runComposition$3 = new CoroutineSession$runComposition$3(this.this$0, this.$timer, this.$context, continuation);
        coroutineSession$runComposition$3.L$0 = obj;
        return coroutineSession$runComposition$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x02a2, code lost:
    
        if (r3.cancelCoroutine(r24) == r2) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02ad  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        InteractiveFrameClock interactiveFrameClock;
        Job job;
        Recomposer recomposer;
        Composition composition;
        final InteractiveFrameClock interactiveFrameClock2;
        Composition composition2;
        Recomposer recomposer2;
        Job job2;
        CoroutineSession$runComposition$3$1$1 coroutineSession$runComposition$3$1$1;
        String str;
        CoroutineSession coroutineSession;
        String str2;
        Context context;
        CoroutineScope coroutineScope;
        MutableStateFlow mutableStateFlow;
        CoroutineSession$runComposition$3$1$3 coroutineSession$runComposition$3$1$3;
        Recomposer recomposer3;
        Context context2;
        final CoroutineScope coroutineScope2;
        CoroutineSession coroutineSession2;
        Session eventSession;
        Context applicationContext;
        Function1<Object, Unit> function1;
        Object objM22215constructorimpl;
        Throwable thM22218exceptionOrNullimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        String str3 = "GWT:CoroutineSession";
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            GlanceLog.INSTANCE.m2301i("GWT:CoroutineSession", "runComposition " + this.this$0.getKey() + " widget / " + this.this$0);
            InteractiveFrameClock interactiveFrameClock3 = new InteractiveFrameClock(coroutineScope3, 0, 0, 0L, null, 30, null);
            Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new CoroutineSession$runComposition$3$snapshotMonitor$1(this.this$0, null), 3, null);
            RemoteViewsRoot remoteViewsRootCreateRootEmittable = this.this$0.createRootEmittable();
            MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(Boxing.boxBoolean(false));
            Recomposer recomposer4 = new Recomposer(coroutineScope3.getCoroutineContext());
            Composition Composition = CompositionKt.Composition(new Applier(remoteViewsRootCreateRootEmittable), recomposer4);
            Function1<Continuation<? super Unit>, Object> function12 = this.$timer;
            CoroutineSession coroutineSession3 = this.this$0;
            Context context3 = this.$context;
            try {
                Result.Companion companion = Result.INSTANCE;
                try {
                    coroutineSession$runComposition$3$1$1 = new CoroutineSession$runComposition$3$1$1(Composition, coroutineSession3, context3, recomposer4, null);
                    composition = Composition;
                    job = jobLaunch$default;
                } catch (Throwable th) {
                    th = th;
                    interactiveFrameClock = interactiveFrameClock3;
                    job = jobLaunch$default;
                    composition = Composition;
                }
            } catch (Throwable th2) {
                th = th2;
                interactiveFrameClock = interactiveFrameClock3;
                job = jobLaunch$default;
                recomposer = recomposer4;
                composition = Composition;
            }
            try {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, interactiveFrameClock3, null, coroutineSession$runComposition$3$1$1, 2, null);
                interactiveFrameClock2 = interactiveFrameClock3;
                try {
                    interactiveFrameClock = interactiveFrameClock2;
                    try {
                        str = "GWT:CoroutineSession";
                        coroutineSession = coroutineSession3;
                        recomposer = recomposer4;
                        str2 = "Finish CoroutineSession ";
                        context = context3;
                    } catch (Throwable th3) {
                        th = th3;
                        recomposer = recomposer4;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    recomposer = recomposer4;
                    composition2 = composition;
                    recomposer2 = recomposer;
                    job2 = job;
                }
                try {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new CoroutineSession$runComposition$3$1$2(recomposer4, MutableStateFlow, remoteViewsRootCreateRootEmittable, coroutineSession3, context3, coroutineScope3, null), 3, null);
                    this.L$0 = interactiveFrameClock;
                    this.L$1 = job;
                    this.L$2 = MutableStateFlow;
                    this.L$3 = recomposer;
                    this.L$4 = composition;
                    this.L$5 = coroutineSession;
                    this.L$6 = context;
                    this.L$7 = coroutineScope3;
                    this.label = 1;
                    if (function12.invoke(this) != coroutine_suspended) {
                        job2 = job;
                        coroutineScope = coroutineScope3;
                        interactiveFrameClock2 = interactiveFrameClock;
                        recomposer2 = recomposer;
                        composition2 = composition;
                        mutableStateFlow = MutableStateFlow;
                        coroutineSession$runComposition$3$1$3 = new CoroutineSession$runComposition$3$1$3(null);
                        this.L$0 = interactiveFrameClock2;
                        this.L$1 = job2;
                        this.L$2 = recomposer2;
                        this.L$3 = composition2;
                        this.L$4 = coroutineSession;
                        this.L$5 = context;
                        this.L$6 = coroutineScope;
                        this.L$7 = null;
                        this.label = 2;
                        if (FlowKt.first(mutableStateFlow, coroutineSession$runComposition$3$1$3, this) != coroutine_suspended) {
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    str3 = str;
                    composition2 = composition;
                    interactiveFrameClock2 = interactiveFrameClock;
                    recomposer2 = recomposer;
                    job2 = job;
                }
            } catch (Throwable th6) {
                th = th6;
                interactiveFrameClock = interactiveFrameClock3;
                recomposer = recomposer4;
                composition2 = composition;
                interactiveFrameClock2 = interactiveFrameClock;
                recomposer2 = recomposer;
                job2 = job;
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                CoroutineSession coroutineSession4 = this.this$0;
                thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                if (thM22218exceptionOrNullimpl != null) {
                }
                CoroutineSession coroutineSession5 = this.this$0;
                if (Result.m22222isSuccessimpl(objM22215constructorimpl)) {
                }
                return Result.m22214boximpl(objM22215constructorimpl);
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            coroutineScope = (CoroutineScope) this.L$7;
            Context context4 = (Context) this.L$6;
            CoroutineSession coroutineSession6 = (CoroutineSession) this.L$5;
            Composition composition3 = (Composition) this.L$4;
            Recomposer recomposer5 = (Recomposer) this.L$3;
            mutableStateFlow = (MutableStateFlow) this.L$2;
            Job job3 = (Job) this.L$1;
            InteractiveFrameClock interactiveFrameClock4 = (InteractiveFrameClock) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                str2 = "Finish CoroutineSession ";
                context = context4;
                str = "GWT:CoroutineSession";
                coroutineSession = coroutineSession6;
                composition2 = composition3;
                recomposer2 = recomposer5;
                job2 = job3;
                interactiveFrameClock2 = interactiveFrameClock4;
                try {
                    coroutineSession$runComposition$3$1$3 = new CoroutineSession$runComposition$3$1$3(null);
                    this.L$0 = interactiveFrameClock2;
                    this.L$1 = job2;
                    this.L$2 = recomposer2;
                    this.L$3 = composition2;
                    this.L$4 = coroutineSession;
                    this.L$5 = context;
                    this.L$6 = coroutineScope;
                    this.L$7 = null;
                    this.label = 2;
                    if (FlowKt.first(mutableStateFlow, coroutineSession$runComposition$3$1$3, this) != coroutine_suspended) {
                        recomposer3 = recomposer2;
                        context2 = context;
                        coroutineScope2 = coroutineScope;
                        coroutineSession2 = coroutineSession;
                        eventSession = coroutineSession2.getEventSession();
                        applicationContext = context2.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        function1 = new Function1<Object, Unit>() { // from class: androidx.glance.appwidget.multiprocess.CoroutineSession$runComposition$3$1$4

                            /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.CoroutineSession$runComposition$3$1$4$1 */
                            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
                            @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.CoroutineSession$runComposition$3$1$4$1", m14021f = "CoroutineSession.kt", m14022i = {}, m14023l = {133}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                            public static final class C29761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ InteractiveFrameClock $frameClock;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public C29761(InteractiveFrameClock interactiveFrameClock, Continuation<? super C29761> continuation) {
                                    super(2, continuation);
                                    this.$frameClock = interactiveFrameClock;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                @NotNull
                                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                    return new C29761(this.$frameClock, continuation);
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
                                    return ((C29761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C29761(interactiveFrameClock2, null), 3, null);
                            }
                        };
                        this.L$0 = interactiveFrameClock2;
                        this.L$1 = job2;
                        this.L$2 = recomposer3;
                        this.L$3 = composition2;
                        this.L$4 = coroutineSession2;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.label = 3;
                        if (eventSession.receiveEvents(applicationContext, function1, this) != coroutine_suspended) {
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    str3 = str;
                }
            } catch (Throwable th8) {
                th = th8;
                composition2 = composition3;
                recomposer2 = recomposer5;
                job2 = job3;
                interactiveFrameClock2 = interactiveFrameClock4;
            }
            return coroutine_suspended;
        }
        if (i == 2) {
            CoroutineScope coroutineScope4 = (CoroutineScope) this.L$6;
            context2 = (Context) this.L$5;
            CoroutineSession coroutineSession7 = (CoroutineSession) this.L$4;
            Composition composition4 = (Composition) this.L$3;
            recomposer3 = (Recomposer) this.L$2;
            Job job4 = (Job) this.L$1;
            InteractiveFrameClock interactiveFrameClock5 = (InteractiveFrameClock) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                str2 = "Finish CoroutineSession ";
                coroutineScope2 = coroutineScope4;
                coroutineSession2 = coroutineSession7;
                str = "GWT:CoroutineSession";
                composition2 = composition4;
                job2 = job4;
                interactiveFrameClock2 = interactiveFrameClock5;
            } catch (Throwable th9) {
                th = th9;
                composition2 = composition4;
                recomposer2 = recomposer3;
                job2 = job4;
                interactiveFrameClock2 = interactiveFrameClock5;
            }
            try {
                eventSession = coroutineSession2.getEventSession();
                applicationContext = context2.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                function1 = new Function1<Object, Unit>() { // from class: androidx.glance.appwidget.multiprocess.CoroutineSession$runComposition$3$1$4

                    /* JADX INFO: renamed from: androidx.glance.appwidget.multiprocess.CoroutineSession$runComposition$3$1$4$1 */
                    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
                    @DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.CoroutineSession$runComposition$3$1$4$1", m14021f = "CoroutineSession.kt", m14022i = {}, m14023l = {133}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                    public static final class C29761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ InteractiveFrameClock $frameClock;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C29761(InteractiveFrameClock interactiveFrameClock, Continuation<? super C29761> continuation) {
                            super(2, continuation);
                            this.$frameClock = interactiveFrameClock;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            return new C29761(this.$frameClock, continuation);
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
                            return ((C29761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C29761(interactiveFrameClock2, null), 3, null);
                    }
                };
                this.L$0 = interactiveFrameClock2;
                this.L$1 = job2;
                this.L$2 = recomposer3;
                this.L$3 = composition2;
                this.L$4 = coroutineSession2;
                this.L$5 = null;
                this.L$6 = null;
                this.label = 3;
                if (eventSession.receiveEvents(applicationContext, function1, this) != coroutine_suspended) {
                    recomposer2 = recomposer3;
                    str3 = str;
                    GlanceLog.INSTANCE.m2297d(str3, str2 + coroutineSession2.getKey());
                    invokeSuspend$clear(coroutineSession2, composition2, interactiveFrameClock2, job2, recomposer2);
                    objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
                }
            } catch (Throwable th10) {
                th = th10;
                str3 = str;
                recomposer2 = recomposer3;
                Result.Companion companion22 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
            }
            return coroutine_suspended;
        }
        if (i != 3) {
            if (i != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objM22215constructorimpl = this.L$0;
            ResultKt.throwOnFailure(obj);
            CoroutineSession coroutineSession52 = this.this$0;
            if (Result.m22222isSuccessimpl(objM22215constructorimpl)) {
                GlanceLog.INSTANCE.m2297d(str3, "onSuccess");
                coroutineSession52.onClosed();
            }
            return Result.m22214boximpl(objM22215constructorimpl);
        }
        coroutineSession2 = (CoroutineSession) this.L$4;
        composition2 = (Composition) this.L$3;
        recomposer2 = (Recomposer) this.L$2;
        job2 = (Job) this.L$1;
        interactiveFrameClock2 = (InteractiveFrameClock) this.L$0;
        try {
            ResultKt.throwOnFailure(obj);
            str2 = "Finish CoroutineSession ";
            str = "GWT:CoroutineSession";
            str3 = str;
            GlanceLog.INSTANCE.m2297d(str3, str2 + coroutineSession2.getKey());
            invokeSuspend$clear(coroutineSession2, composition2, interactiveFrameClock2, job2, recomposer2);
            objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
        } catch (Throwable th11) {
            th = th11;
            Result.Companion companion222 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Result.Companion companion2222 = Result.INSTANCE;
        objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        CoroutineSession coroutineSession42 = this.this$0;
        thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            GlanceLog.Companion companion3 = GlanceLog.INSTANCE;
            companion3.m2297d(str3, "Finished runComposition by " + thM22218exceptionOrNullimpl);
            thM22218exceptionOrNullimpl.printStackTrace();
            invokeSuspend$clear(coroutineSession42, composition2, interactiveFrameClock2, job2, recomposer2);
            if (!Intrinsics.areEqual("Finish coroutine session", thM22218exceptionOrNullimpl.getMessage())) {
                companion3.m2297d(str3, "Different message " + thM22218exceptionOrNullimpl.getMessage());
                this.L$0 = objM22215constructorimpl;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.L$6 = null;
                this.L$7 = null;
                this.label = 4;
            }
        }
        CoroutineSession coroutineSession522 = this.this$0;
        if (Result.m22222isSuccessimpl(objM22215constructorimpl)) {
        }
        return Result.m22214boximpl(objM22215constructorimpl);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Result<Unit>> continuation) {
        return ((CoroutineSession$runComposition$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
