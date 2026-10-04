package androidx.glance.oneui.template.preview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.view.ViewGroupKt;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import androidx.glance.GlanceComposable;
import androidx.glance.appwidget.GlanceRemoteViews;
import androidx.glance.appwidget.RemoteViewsCompositionResult;
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.DeviceType;
import androidx.glance.oneui.common.DeviceTypeUtil;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.TemplateCompositor;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u001d\u001a\u00020\u001bH\u0017¢\u0006\u0002\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u001bH\u0015¢\u0006\u0002\u0010\u001eJ\u0010\u0010 \u001a\u0004\u0018\u00010!H\u0084@¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020!H\u0002J#\u0010%\u001a\u00020\u001b2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b&¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\u001bR\"\u0010\t\u001a\u00020\nX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u0011X\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\"\u0010\u0014\u001a\u00020\u0015X\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR!\u0010\u0018\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a¢\u0006\u0002\b\u001c0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, m13886d2 = {"Landroidx/glance/oneui/template/preview/AbstractGlanceView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "appWidgetHostType", "Landroidx/glance/oneui/common/AppWidgetHostType;", "getAppWidgetHostType-mn_SBp8", "()I", "setAppWidgetHostType-RLJl_S0", "(I)V", "I", "appWidgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "getAppWidgetSize-rx25Pp4", "setAppWidgetSize-L2j3NV4", "appWidgetStyle", "Landroidx/glance/oneui/common/AppWidgetStyle;", "getAppWidgetStyle-WOdBnnM", "setAppWidgetStyle-zt4u-bU", "content", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "PrepareContent", "createGlanceView", "Landroid/view/View;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAllViewsExceptNewOne", "newView", "setContent", "Landroidx/glance/GlanceComposable;", "(Lkotlin/jvm/functions/Function2;)V", "updateGlanceView", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAbstractGlanceView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractGlanceView.kt\nandroidx/glance/oneui/template/preview/AbstractGlanceView\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,138:1\n154#2:139\n1313#3,2:140\n*S KotlinDebug\n*F\n+ 1 AbstractGlanceView.kt\nandroidx/glance/oneui/template/preview/AbstractGlanceView\n*L\n78#1:139\n120#1:140,2\n*E\n"})
public abstract class AbstractGlanceView extends FrameLayout {
    public static final int $stable = 8;
    private int appWidgetHostType;
    private int appWidgetSize;
    private int appWidgetStyle;

    @NotNull
    private final MutableState<Function2<Composer, Integer, Unit>> content;

    /* JADX INFO: renamed from: androidx.glance.oneui.template.preview.AbstractGlanceView$createGlanceView$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.AbstractGlanceView", m14021f = "AbstractGlanceView.kt", m14022i = {0, 0}, m14023l = {76}, m14024m = "createGlanceView", m14025n = {"this", "currentTime"}, m14026s = {"L$0", "J$0"})
    public static final class C34661 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C34661(Continuation<? super C34661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AbstractGlanceView.this.createGlanceView(this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.oneui.template.preview.AbstractGlanceView$updateGlanceView$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.AbstractGlanceView$updateGlanceView$1", m14021f = "AbstractGlanceView.kt", m14022i = {}, m14023l = {111}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C34681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C34681(Continuation<? super C34681> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return AbstractGlanceView.this.new C34681(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AbstractGlanceView abstractGlanceView = AbstractGlanceView.this;
                this.label = 1;
                obj = abstractGlanceView.createGlanceView(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            View view = (View) obj;
            if (view != null) {
                AbstractGlanceView abstractGlanceView2 = AbstractGlanceView.this;
                abstractGlanceView2.addView(view);
                abstractGlanceView2.removeAllViewsExceptNewOne(view);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C34681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbstractGlanceView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeAllViewsExceptNewOne(final View newView) {
        Iterator it = SequencesKt.filter(ViewGroupKt.getChildren(this), new Function1<View, Boolean>() { // from class: androidx.glance.oneui.template.preview.AbstractGlanceView.removeAllViewsExceptNewOne.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull View child) {
                Intrinsics.checkNotNullParameter(child, "child");
                return Boolean.valueOf(!Intrinsics.areEqual(child, newView));
            }
        }).iterator();
        while (it.hasNext()) {
            removeView((View) it.next());
        }
    }

    @Composable
    @GlanceComposable
    public void Content(@Nullable Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1459576996);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1459576996, i, -1, "androidx.glance.oneui.template.preview.AbstractGlanceView.Content (AbstractGlanceView.kt:124)");
        }
        Function2<Composer, Integer, Unit> value = this.content.getValue();
        if (value != null) {
            value.invoke(composerStartRestartGroup, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.AbstractGlanceView.Content.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    AbstractGlanceView.this.Content(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public void PrepareContent(@Nullable Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2119424281);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2119424281, i, -1, "androidx.glance.oneui.template.preview.AbstractGlanceView.PrepareContent (AbstractGlanceView.kt:94)");
        }
        ProvidableCompositionLocal<DeviceType> localDeviceType = CompositionLocalsKt.getLocalDeviceType();
        DeviceTypeUtil.Companion companion = DeviceTypeUtil.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{localDeviceType.provides(companion.get(context)), CompositionLocalsKt.getLocalCompositor().provides(TemplateCompositor.INSTANCE.getGlance()), androidx.glance.CompositionLocalsKt.getLocalRealDataPreviewMode().provides(Boolean.FALSE), CompositionLocalsKt.getLocalWidgetSize().provides(AppWidgetSize.m21545boximpl(this.appWidgetSize)), CompositionLocalsKt.getLocalWidgetStyle().provides(AppWidgetStyle.m21574boximpl(this.appWidgetStyle)), CompositionLocalsKt.getLocalHostType().provides(AppWidgetHostType.m21520boximpl(this.appWidgetHostType)), androidx.glance.appwidget.CompositionLocalsKt.getLocalDensity().provides(Float.valueOf(getContext().getResources().getConfiguration().densityDpi / 160.0f))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1676457049, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.AbstractGlanceView.PrepareContent.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.glance.GlanceComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1676457049, i2, -1, "androidx.glance.oneui.template.preview.AbstractGlanceView.PrepareContent.<anonymous> (AbstractGlanceView.kt:104)");
                }
                AbstractGlanceView.this.Content(composer2, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.AbstractGlanceView.PrepareContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    AbstractGlanceView.this.PrepareContent(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object createGlanceView(@NotNull Continuation<? super View> continuation) {
        C34661 c34661;
        AbstractGlanceView abstractGlanceView;
        long j;
        if (continuation instanceof C34661) {
            c34661 = (C34661) continuation;
            int i = c34661.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c34661.label = i - Integer.MIN_VALUE;
            } else {
                c34661 = new C34661(continuation);
            }
        }
        C34661 c346612 = c34661;
        Object objM21295compose8HUqYh0$default = c346612.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c346612.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objM21295compose8HUqYh0$default);
                long jCurrentTimeMillis = System.currentTimeMillis();
                GlanceLog.INSTANCE.m2297d("GWT:GlanceView", "createGlanceView start");
                GlanceRemoteViews glanceRemoteViews = new GlanceRemoteViews();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                float f = 200;
                long jM20990DpSizeYgX7TsA = DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f));
                Preferences preferencesCreateEmpty = PreferencesFactory.createEmpty();
                ComposableLambda composableLambdaComposableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(343922968, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.AbstractGlanceView$createGlanceView$view$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer, int i4) {
                        if ((i4 & 11) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(343922968, i4, -1, "androidx.glance.oneui.template.preview.AbstractGlanceView.createGlanceView.<anonymous> (AbstractGlanceView.kt:81)");
                        }
                        this.this$0.PrepareContent(composer, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
                c346612.L$0 = this;
                c346612.J$0 = jCurrentTimeMillis;
                c346612.label = 1;
                objM21295compose8HUqYh0$default = GlanceRemoteViews.m21295compose8HUqYh0$default(glanceRemoteViews, context, jM20990DpSizeYgX7TsA, preferencesCreateEmpty, null, true, composableLambdaComposableLambdaInstance, c346612, 8, null);
                if (objM21295compose8HUqYh0$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                abstractGlanceView = this;
                j = jCurrentTimeMillis;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = c346612.J$0;
                abstractGlanceView = (AbstractGlanceView) c346612.L$0;
                ResultKt.throwOnFailure(objM21295compose8HUqYh0$default);
            }
            View viewApply = ((RemoteViewsCompositionResult) objM21295compose8HUqYh0$default).getRemoteViews().apply(abstractGlanceView.getContext(), abstractGlanceView);
            GlanceLog.INSTANCE.m2301i("GWT:GlanceView", "createGlanceView elapsed : " + (System.currentTimeMillis() - j) + " ms");
            return viewApply;
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2300e("GWT:GlanceView", "Exception in createGlanceView", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: getAppWidgetHostType-mn_SBp8, reason: not valid java name and from getter */
    public final int getAppWidgetHostType() {
        return this.appWidgetHostType;
    }

    /* JADX INFO: renamed from: getAppWidgetSize-rx25Pp4, reason: not valid java name and from getter */
    public final int getAppWidgetSize() {
        return this.appWidgetSize;
    }

    /* JADX INFO: renamed from: getAppWidgetStyle-WOdBnnM, reason: not valid java name and from getter */
    public final int getAppWidgetStyle() {
        return this.appWidgetStyle;
    }

    /* JADX INFO: renamed from: setAppWidgetHostType-RLJl_S0, reason: not valid java name */
    public final void m21911setAppWidgetHostTypeRLJl_S0(int i) {
        this.appWidgetHostType = i;
    }

    /* JADX INFO: renamed from: setAppWidgetSize-L2j3NV4, reason: not valid java name */
    public final void m21912setAppWidgetSizeL2j3NV4(int i) {
        this.appWidgetSize = i;
    }

    /* JADX INFO: renamed from: setAppWidgetStyle-zt4u-bU, reason: not valid java name */
    public final void m21913setAppWidgetStylezt4ubU(int i) {
        this.appWidgetStyle = i;
    }

    public final void setContent(@NotNull Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content.setValue(content);
        if (isAttachedToWindow()) {
            updateGlanceView();
        }
    }

    public final void updateGlanceView() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new C34681(null), 3, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbstractGlanceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AbstractGlanceView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbstractGlanceView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.content = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        this.appWidgetSize = companion.m21572getUnknownrx25Pp4();
        AppWidgetStyle.Companion companion2 = AppWidgetStyle.INSTANCE;
        this.appWidgetStyle = companion2.m21586getColorfulWOdBnnM();
        this.appWidgetHostType = AppWidgetHostType.m21521constructorimpl(AppWidgetHostType.m21528toIntimpl(AppWidgetHostType.INSTANCE.m21535getHomemn_SBp8()));
        GlanceLog.Companion companion3 = GlanceLog.INSTANCE;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        companion3.init(packageName);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3094R.styleable.AndroidGlanceViewBase);
        this.appWidgetSize = companion.m21562getIQT_O7U(typedArrayObtainStyledAttributes.getInt(C3094R.styleable.AndroidGlanceViewBase_widgetSize, AppWidgetSize.m21557toIntimpl(companion.m21572getUnknownrx25Pp4())));
        this.appWidgetStyle = companion2.m21585getPRK4rM(typedArrayObtainStyledAttributes.getInt(C3094R.styleable.AndroidGlanceViewBase_widgetStyle, AppWidgetStyle.m21582toIntimpl(companion2.m21586getColorfulWOdBnnM())));
        typedArrayObtainStyledAttributes.recycle();
        companion3.m2297d("GWT:GlanceView", AbstractC2322a.m1622l(context.getPackageName(), " attributes : ", AppWidgetSize.m21559toStringimpl(this.appWidgetSize), " ", AppWidgetStyle.m21583toStringimpl(this.appWidgetStyle)));
    }
}
