package androidx.glance.oneui.template.preview;

import android.appwidget.AppWidgetHostView;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpKt;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.AbstractC2821a;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.common.PreviewMode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\f\u001a\u00020\rH\u0005¢\u0006\u0002\u0010\u000eJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0015J\b\u0010\u0014\u001a\u00020\rH\u0002R\u0016\u0010\t\u001a\u00020\nX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, m13886d2 = {"Landroidx/glance/oneui/template/preview/GlanceViewForPreviewLayout;", "Landroidx/glance/oneui/template/preview/AbstractGlanceView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "localSize", "Landroidx/compose/ui/unit/DpSize;", "J", "PrepareContent", "", "(Landroidx/compose/runtime/Composer;I)V", "findAppWidgetHostView", "Landroid/appwidget/AppWidgetHostView;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "overrideAppWidgetPropertiesByHost", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGlanceViewForPreviewLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceViewForPreviewLayout.kt\nandroidx/glance/oneui/template/preview/GlanceViewForPreviewLayout\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,117:1\n154#2:118\n174#2:119\n*S KotlinDebug\n*F\n+ 1 GlanceViewForPreviewLayout.kt\nandroidx/glance/oneui/template/preview/GlanceViewForPreviewLayout\n*L\n61#1:118\n68#1:119\n*E\n"})
public class GlanceViewForPreviewLayout extends AbstractGlanceView {
    public static final int $stable = 8;
    private long localSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GlanceViewForPreviewLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final AppWidgetHostView findAppWidgetHostView() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof AppWidgetHostView) {
                return (AppWidgetHostView) parent;
            }
        }
        return null;
    }

    private final void overrideAppWidgetPropertiesByHost() {
        Object tag;
        AppWidgetHostView appWidgetHostViewFindAppWidgetHostView = findAppWidgetHostView();
        if (appWidgetHostViewFindAppWidgetHostView == null || (tag = appWidgetHostViewFindAppWidgetHostView.getTag()) == null) {
            return;
        }
        Intrinsics.checkNotNull(tag);
        Map map = (Map) tag;
        Object obj = map.get("hostType");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        m21911setAppWidgetHostTypeRLJl_S0(AppWidgetHostType.m21521constructorimpl(((Integer) obj).intValue()));
        Object obj2 = map.get("widgetStyle");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        m21913setAppWidgetStylezt4ubU(AppWidgetStyle.m21575constructorimpl(((Integer) obj2).intValue()));
        if (AppWidgetSize.m21550equalsimpl0(getAppWidgetSize(), AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4())) {
            Object obj3 = map.get("widgetSize");
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            m21912setAppWidgetSizeL2j3NV4(AppWidgetSize.m21547constructorimpl(((Integer) obj3).intValue()));
            GlanceLog.INSTANCE.m2301i("GWT:GlanceViewPreview", getContext().getPackageName() + " appWidgetSize set by host tag : " + AppWidgetSize.m21559toStringimpl(getAppWidgetSize()));
        }
        GlanceLog.Companion companion = GlanceLog.INSTANCE;
        String packageName = getContext().getPackageName();
        String strM21529toStringimpl = AppWidgetHostType.m21529toStringimpl(getAppWidgetHostType());
        String strM21583toStringimpl = AppWidgetStyle.m21583toStringimpl(getAppWidgetStyle());
        String strM21559toStringimpl = AppWidgetSize.m21559toStringimpl(getAppWidgetSize());
        StringBuilder sbM2228s = AbstractC2821a.m2228s(packageName, " overrideAppWidgetPropertiesByHost : ", strM21529toStringimpl, " ", strM21583toStringimpl);
        sbM2228s.append(" ");
        sbM2228s.append(strM21559toStringimpl);
        companion.m2301i("GWT:GlanceViewPreview", sbM2228s.toString());
    }

    @Override // androidx.glance.oneui.template.preview.AbstractGlanceView
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public final void PrepareContent(@Nullable Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1942106297);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1942106297, i, -1, "androidx.glance.oneui.template.preview.GlanceViewForPreviewLayout.PrepareContent (GlanceViewForPreviewLayout.kt:73)");
        }
        overrideAppWidgetPropertiesByHost();
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{CompositionLocalsKt.getLocalSize().provides(DpSize.m21054boximpl(this.localSize)), androidx.glance.oneui.template.CompositionLocalsKt.getLocalPreviewMode().provides(PreviewMode.m21606boximpl(PreviewMode.INSTANCE.m21614getDummyBmZA40c()))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1531147271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.GlanceViewForPreviewLayout.PrepareContent.1
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
                    ComposerKt.traceEventStart(1531147271, i2, -1, "androidx.glance.oneui.template.preview.GlanceViewForPreviewLayout.PrepareContent.<anonymous> (GlanceViewForPreviewLayout.kt:79)");
                }
                GlanceViewForPreviewLayout.super.PrepareContent(composer2, 8);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.GlanceViewForPreviewLayout.PrepareContent.2
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
                    GlanceViewForPreviewLayout.this.PrepareContent(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    @RequiresApi(33)
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float f = getResources().getDisplayMetrics().density;
        this.localSize = DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(View.MeasureSpec.getSize(widthMeasureSpec) / f), C2256Dp.m20968constructorimpl(View.MeasureSpec.getSize(heightMeasureSpec) / f));
        updateGlanceView();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GlanceViewForPreviewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GlanceViewForPreviewLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GlanceViewForPreviewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        float f = 200;
        this.localSize = DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f));
    }
}
