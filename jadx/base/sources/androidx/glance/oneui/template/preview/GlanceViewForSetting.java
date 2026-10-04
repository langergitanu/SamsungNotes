package androidx.glance.oneui.template.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.unit.C2256Dp;
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
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.layout.compose.TopLevelLayoutKt;
import java.util.List;
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
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u000b\u001a\u00020\fH\u0005¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0015R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, m13886d2 = {"Landroidx/glance/oneui/template/preview/GlanceViewForSetting;", "Landroidx/glance/oneui/template/preview/AbstractGlanceView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "localSize", "Landroidx/compose/ui/unit/DpSize;", "PrepareContent", "", "(Landroidx/compose/runtime/Composer;I)V", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGlanceViewForSetting.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceViewForSetting.kt\nandroidx/glance/oneui/template/preview/GlanceViewForSetting\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,90:1\n154#2:91\n88#3:92\n88#3:93\n*S KotlinDebug\n*F\n+ 1 GlanceViewForSetting.kt\nandroidx/glance/oneui/template/preview/GlanceViewForSetting\n*L\n48#1:91\n57#1:92\n60#1:93\n*E\n"})
public class GlanceViewForSetting extends AbstractGlanceView {
    public static final int $stable = 8;

    @Nullable
    private DpSize localSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GlanceViewForSetting(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.glance.oneui.template.preview.AbstractGlanceView
    @Composable
    public final void PrepareContent(@Nullable Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1263109817);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1263109817, i, -1, "androidx.glance.oneui.template.preview.GlanceViewForSetting.PrepareContent (GlanceViewForSetting.kt:68)");
        }
        CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalCompositionDelegator().provides(ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1886338270, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.GlanceViewForSetting.PrepareContent.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1886338270, i2, -1, "androidx.glance.oneui.template.preview.GlanceViewForSetting.PrepareContent.<anonymous> (GlanceViewForSetting.kt:72)");
                }
                List list = (List) composer2.consume(CompositionLocalsKt.getLocalCornerRadius());
                TopLevelLayoutKt.m21816setBlurqDBjuR0(GlanceViewForSetting.this, ((C2256Dp) list.get(0)).m20982unboximpl(), ((C2256Dp) list.get(1)).m20982unboximpl(), ((C2256Dp) list.get(2)).m20982unboximpl(), ((C2256Dp) list.get(3)).m20982unboximpl());
                GlanceViewForSetting.this.localSize = (DpSize) composer2.consume(androidx.glance.CompositionLocalsKt.getLocalSize());
                GlanceViewForSetting.this.setScaleX(((Number) composer2.consume(CompositionLocalsKt.getLocalContainerScale())).floatValue());
                GlanceViewForSetting glanceViewForSetting = GlanceViewForSetting.this;
                glanceViewForSetting.setScaleY(glanceViewForSetting.getScaleX());
                GlanceLog.INSTANCE.m2301i("GWT:GlanceViewSetting", "LocalCompositionDelegator cornerRadius:" + list + " localSize:" + GlanceViewForSetting.this.localSize + " scale:" + GlanceViewForSetting.this.getScaleX());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        })), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1232944647, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.GlanceViewForSetting.PrepareContent.2
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
                    ComposerKt.traceEventStart(1232944647, i2, -1, "androidx.glance.oneui.template.preview.GlanceViewForSetting.PrepareContent.<anonymous> (GlanceViewForSetting.kt:83)");
                }
                GlanceViewForSetting.super.PrepareContent(composer2, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.preview.GlanceViewForSetting.PrepareContent.3
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
                    GlanceViewForSetting.this.PrepareContent(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    @RequiresApi(33)
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        DpSize dpSize = this.localSize;
        if (dpSize == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        long packedValue = dpSize.getPackedValue();
        float f = getResources().getDisplayMetrics().density;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(packedValue) * f), 1073741824), View.MeasureSpec.makeMeasureSpec((int) C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(packedValue) * f), 1073741824));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GlanceViewForSetting(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GlanceViewForSetting(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GlanceViewForSetting(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        float f = 24;
        TopLevelLayoutKt.m21816setBlurqDBjuR0(this, C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f));
        updateGlanceView();
    }
}
