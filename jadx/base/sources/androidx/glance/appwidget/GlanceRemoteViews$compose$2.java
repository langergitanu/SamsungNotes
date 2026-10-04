package androidx.glance.appwidget;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.Applier;
import androidx.glance.oneui.common.GlanceLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Landroidx/glance/appwidget/RemoteViewsCompositionResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceRemoteViews$compose$2", m14021f = "GlanceRemoteViews.kt", m14022i = {0, 0, 1, 1, 1}, m14023l = {92, 111}, m14024m = "invokeSuspend", m14025n = {"$this$withContext", "currentTime", "layoutConfiguration", "root", "currentTime"}, m14026s = {"L$0", "J$0", "L$0", "L$1", "J$0"})
public final class GlanceRemoteViews$compose$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RemoteViewsCompositionResult>, Object> {
    final /* synthetic */ Bundle $appWidgetOptions;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Context $context;
    final /* synthetic */ long $size;
    final /* synthetic */ boolean $skipInteraction;
    final /* synthetic */ Object $state;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GlanceRemoteViews this$0;

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceRemoteViews$compose$2$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceRemoteViews$compose$2$2", m14021f = "GlanceRemoteViews.kt", m14022i = {}, m14023l = {109}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C28642 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Recomposer $recomposer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28642(Recomposer recomposer, Continuation<? super C28642> continuation) {
            super(2, continuation);
            this.$recomposer = recomposer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C28642(this.$recomposer, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
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
            return ((C28642) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GlanceRemoteViews$compose$2(boolean z, GlanceRemoteViews glanceRemoteViews, Context context, long j, Object obj, Bundle bundle, Function2<? super Composer, ? super Integer, Unit> function2, Continuation<? super GlanceRemoteViews$compose$2> continuation) {
        super(2, continuation);
        this.$skipInteraction = z;
        this.this$0 = glanceRemoteViews;
        this.$context = context;
        this.$size = j;
        this.$state = obj;
        this.$appWidgetOptions = bundle;
        this.$content = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GlanceRemoteViews$compose$2 glanceRemoteViews$compose$2 = new GlanceRemoteViews$compose$2(this.$skipInteraction, this.this$0, this.$context, this.$size, this.$state, this.$appWidgetOptions, this.$content, continuation);
        glanceRemoteViews$compose$2.L$0 = obj;
        return glanceRemoteViews$compose$2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
    
        if (r8 == r1) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        CoroutineScope coroutineScope;
        long jCurrentTimeMillis;
        Object objInitializeLayoutConfiguration;
        CoroutineScope coroutineScope2;
        LayoutConfiguration layoutConfiguration;
        Recomposer recomposer;
        LayoutConfiguration layoutConfiguration2;
        long j;
        RemoteViewsRoot remoteViewsRoot;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            jCurrentTimeMillis = System.currentTimeMillis();
            if (this.$skipInteraction) {
                coroutineScope2 = coroutineScope;
                layoutConfiguration = null;
                RemoteViewsRoot remoteViewsRoot2 = new RemoteViewsRoot(50);
                Applier applier = new Applier(remoteViewsRoot2);
                recomposer = new Recomposer(coroutineScope2.getCoroutineContext());
                Composition Composition = CompositionKt.Composition(applier, recomposer);
                final Context context = this.$context;
                final Object obj2 = this.$state;
                final Bundle bundle = this.$appWidgetOptions;
                final long j2 = this.$size;
                final Function2<Composer, Integer, Unit> function2 = this.$content;
                Composition.setContent(ComposableLambdaKt.composableLambdaInstance(-983930055, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.GlanceRemoteViews$compose$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(@Nullable Composer composer, int i2) {
                        if ((i2 & 11) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-983930055, i2, -1, "androidx.glance.appwidget.GlanceRemoteViews.compose.<anonymous>.<anonymous> (GlanceRemoteViews.kt:98)");
                        }
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{androidx.glance.CompositionLocalsKt.getLocalContext().provides(context), androidx.glance.CompositionLocalsKt.getLocalGlanceId().provides(GlanceRemoteViewsKt.REMOTE_VIEWS_ID), androidx.glance.CompositionLocalsKt.getLocalState().provides(obj2), CompositionLocalsKt.getLocalAppWidgetOptions().provides(bundle), androidx.glance.CompositionLocalsKt.getLocalSize().provides(DpSize.m21054boximpl(j2))}, function2, composer, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C28642(recomposer, null), 3, null);
                recomposer.close();
                this.L$0 = layoutConfiguration;
                this.L$1 = remoteViewsRoot2;
                this.J$0 = jCurrentTimeMillis;
                this.label = 2;
                if (recomposer.join(this) != coroutine_suspended) {
                    long j3 = jCurrentTimeMillis;
                    layoutConfiguration2 = layoutConfiguration;
                    j = j3;
                    remoteViewsRoot = remoteViewsRoot2;
                    NormalizeCompositionTreeKt.normalizeCompositionTree(remoteViewsRoot);
                    RemoteViewsCompositionResult remoteViewsCompositionResult = new RemoteViewsCompositionResult(RemoteViewsTranslatorKt.m21316translateComposition_rDzMTw(this.$context, 0, remoteViewsRoot, layoutConfiguration2, layoutConfiguration2 == null ? layoutConfiguration2.addLayout(remoteViewsRoot) : 0, this.$size, null, this.$skipInteraction));
                    GlanceLog.INSTANCE.m2297d("GWT:GlanceRemoteViews", AbstractC1974b.m1317j(System.currentTimeMillis() - j, "translateComposition elapsed : ", " ms"));
                    return remoteViewsCompositionResult;
                }
                return coroutine_suspended;
            }
            GlanceRemoteViews glanceRemoteViews = this.this$0;
            Context context2 = this.$context;
            this.L$0 = coroutineScope;
            this.J$0 = jCurrentTimeMillis;
            this.label = 1;
            objInitializeLayoutConfiguration = glanceRemoteViews.initializeLayoutConfiguration(context2, this);
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                RemoteViewsRoot remoteViewsRoot3 = (RemoteViewsRoot) this.L$1;
                LayoutConfiguration layoutConfiguration3 = (LayoutConfiguration) this.L$0;
                ResultKt.throwOnFailure(obj);
                remoteViewsRoot = remoteViewsRoot3;
                layoutConfiguration2 = layoutConfiguration3;
                NormalizeCompositionTreeKt.normalizeCompositionTree(remoteViewsRoot);
                RemoteViewsCompositionResult remoteViewsCompositionResult2 = new RemoteViewsCompositionResult(RemoteViewsTranslatorKt.m21316translateComposition_rDzMTw(this.$context, 0, remoteViewsRoot, layoutConfiguration2, layoutConfiguration2 == null ? layoutConfiguration2.addLayout(remoteViewsRoot) : 0, this.$size, null, this.$skipInteraction));
                GlanceLog.INSTANCE.m2297d("GWT:GlanceRemoteViews", AbstractC1974b.m1317j(System.currentTimeMillis() - j, "translateComposition elapsed : ", " ms"));
                return remoteViewsCompositionResult2;
            }
            jCurrentTimeMillis = this.J$0;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            objInitializeLayoutConfiguration = obj;
        }
        LayoutConfiguration layoutConfiguration4 = (LayoutConfiguration) objInitializeLayoutConfiguration;
        coroutineScope2 = coroutineScope;
        layoutConfiguration = layoutConfiguration4;
        RemoteViewsRoot remoteViewsRoot22 = new RemoteViewsRoot(50);
        Applier applier2 = new Applier(remoteViewsRoot22);
        recomposer = new Recomposer(coroutineScope2.getCoroutineContext());
        Composition Composition2 = CompositionKt.Composition(applier2, recomposer);
        final Context context3 = this.$context;
        final Object obj22 = this.$state;
        final Bundle bundle2 = this.$appWidgetOptions;
        final long j22 = this.$size;
        final Function2<? super Composer, ? super Integer, Unit> function22 = this.$content;
        Composition2.setContent(ComposableLambdaKt.composableLambdaInstance(-983930055, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.GlanceRemoteViews$compose$2.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@Nullable Composer composer, int i2) {
                if ((i2 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-983930055, i2, -1, "androidx.glance.appwidget.GlanceRemoteViews.compose.<anonymous>.<anonymous> (GlanceRemoteViews.kt:98)");
                }
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{androidx.glance.CompositionLocalsKt.getLocalContext().provides(context3), androidx.glance.CompositionLocalsKt.getLocalGlanceId().provides(GlanceRemoteViewsKt.REMOTE_VIEWS_ID), androidx.glance.CompositionLocalsKt.getLocalState().provides(obj22), CompositionLocalsKt.getLocalAppWidgetOptions().provides(bundle2), androidx.glance.CompositionLocalsKt.getLocalSize().provides(DpSize.m21054boximpl(j22))}, function22, composer, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C28642(recomposer, null), 3, null);
        recomposer.close();
        this.L$0 = layoutConfiguration;
        this.L$1 = remoteViewsRoot22;
        this.J$0 = jCurrentTimeMillis;
        this.label = 2;
        if (recomposer.join(this) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super RemoteViewsCompositionResult> continuation) {
        return ((GlanceRemoteViews$compose$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
