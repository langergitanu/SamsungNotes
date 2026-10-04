package androidx.glance.oneui.template.utils;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.GlanceModifier;
import androidx.glance.action.Action;
import androidx.glance.action.ActionKt;
import androidx.glance.appwidget.AppWidgetModifiersKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.appwidget.percent.PercentSizePolicy;
import androidx.glance.layout.HeightModifier;
import androidx.glance.layout.WidthModifier;
import androidx.glance.semantics.SemanticsModifierKt;
import androidx.glance.semantics.SemanticsPropertiesKt;
import androidx.glance.semantics.SemanticsPropertyReceiver;
import androidx.glance.unit.Dimension;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000\u001a%\u0010\b\u001a\u00070\t¢\u0006\u0002\b\n*\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0016\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0000\u001a4\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0000\u001a%\u0010\u0019\u001a\u00020\u000b*\u00070\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m13886d2 = {"circle", "Landroidx/glance/GlanceModifier;", "policy", "Landroidx/glance/appwidget/percent/PercentSizePolicy;", "circle-6WKSPt0", "(Landroidx/glance/GlanceModifier;ILandroidx/compose/runtime/Composer;II)Landroidx/glance/GlanceModifier;", "contentDescription", "", "dpToPercent", "", "Landroidx/glance/appwidget/percent/PercentRange;", "Landroidx/compose/ui/unit/Dp;", "dpToPercent-X2aYo5w", "(FILandroidx/compose/runtime/Composer;II)F", "maybeAnimation", "animation", "Landroidx/glance/appwidget/animation/RemoteAnimation;", "maybeClickable", "action", "Landroidx/glance/action/Action;", "enabled", "", "removeRipple", "overrideRipple", "", "percentToDp", "percentToDp-6WKSPt0", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGlanceModifierUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceModifierUtils.kt\nandroidx/glance/oneui/template/utils/GlanceModifierUtilsKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 4 Utils.kt\nandroidx/glance/UtilsKt\n*L\n1#1,99:1\n74#2:100\n74#2:102\n74#2:104\n74#2:106\n88#3:101\n88#3:103\n81#3:105\n81#3:107\n75#3:115\n75#3:123\n22#4,7:108\n22#4,7:116\n*S KotlinDebug\n*F\n+ 1 GlanceModifierUtils.kt\nandroidx/glance/oneui/template/utils/GlanceModifierUtilsKt\n*L\n68#1:100\n69#1:102\n77#1:104\n78#1:106\n68#1:101\n69#1:103\n77#1:105\n78#1:107\n87#1:115\n94#1:123\n85#1:108,7\n92#1:116,7\n*E\n"})
public final class GlanceModifierUtilsKt {
    @Composable
    @NotNull
    /* JADX INFO: renamed from: circle-6WKSPt0, reason: not valid java name */
    public static final GlanceModifier m21965circle6WKSPt0(@NotNull GlanceModifier circle, int i, @Nullable Composer composer, int i2, int i4) {
        Dimension height;
        Intrinsics.checkNotNullParameter(circle, "$this$circle");
        composer.startReplaceableGroup(-174103990);
        if ((i4 & 1) != 0) {
            i = PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-174103990, i2, -1, "androidx.glance.oneui.template.utils.circle (GlanceModifierUtils.kt:81)");
        }
        if (PercentSizePolicy.m21375equalsimpl0(i, PercentSizePolicy.INSTANCE.m21382getWidth3SpTkPA())) {
            WidthModifier widthModifier = (WidthModifier) circle.foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.oneui.template.utils.GlanceModifierUtilsKt$circle-6WKSPt0$$inlined$findModifier$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final WidthModifier invoke(@Nullable WidthModifier widthModifier2, @NotNull GlanceModifier.Element cur) {
                    Intrinsics.checkNotNullParameter(cur, "cur");
                    return cur instanceof WidthModifier ? cur : widthModifier2;
                }
            });
            height = widthModifier != null ? widthModifier.getWidth() : null;
            if (!(height instanceof Dimension.C3532Dp)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return circle;
            }
            GlanceModifier glanceModifierM21286cornerRadius3ABfNKs = CornerRadiusKt.m21286cornerRadius3ABfNKs(circle, C2256Dp.m20968constructorimpl(((Dimension.C3532Dp) height).getDp() / 2));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return glanceModifierM21286cornerRadius3ABfNKs;
        }
        HeightModifier heightModifier = (HeightModifier) circle.foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.oneui.template.utils.GlanceModifierUtilsKt$circle-6WKSPt0$$inlined$findModifier$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final HeightModifier invoke(@Nullable HeightModifier heightModifier2, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof HeightModifier ? cur : heightModifier2;
            }
        });
        height = heightModifier != null ? heightModifier.getHeight() : null;
        if (!(height instanceof Dimension.C3532Dp)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return circle;
        }
        GlanceModifier glanceModifierM21286cornerRadius3ABfNKs2 = CornerRadiusKt.m21286cornerRadius3ABfNKs(circle, C2256Dp.m20968constructorimpl(((Dimension.C3532Dp) height).getDp() / 2));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierM21286cornerRadius3ABfNKs2;
    }

    @NotNull
    public static final GlanceModifier contentDescription(@NotNull GlanceModifier glanceModifier, @Nullable final String str) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return str != null ? SemanticsModifierKt.semantics(glanceModifier, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.glance.oneui.template.utils.GlanceModifierUtilsKt.contentDescription.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                SemanticsPropertiesKt.setContentDescription(semantics, str);
            }
        }) : glanceModifier;
    }

    @Composable
    /* JADX INFO: renamed from: dpToPercent-X2aYo5w, reason: not valid java name */
    public static final float m21966dpToPercentX2aYo5w(float f, int i, @Nullable Composer composer, int i2, int i4) {
        float fM21064getHeightD9Ej5fM;
        composer.startReplaceableGroup(-156739876);
        if ((i4 & 1) != 0) {
            i = PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-156739876, i2, -1, "androidx.glance.oneui.template.utils.dpToPercent (GlanceModifierUtils.kt:74)");
        }
        if (PercentSizePolicy.m21375equalsimpl0(i, PercentSizePolicy.INSTANCE.m21382getWidth3SpTkPA())) {
            composer.startReplaceableGroup(1566999530);
            fM21064getHeightD9Ej5fM = f / DpSize.m21066getWidthD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue());
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1566999582);
            fM21064getHeightD9Ej5fM = f / DpSize.m21064getHeightD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue());
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM21064getHeightD9Ej5fM;
    }

    @NotNull
    public static final GlanceModifier maybeAnimation(@NotNull GlanceModifier glanceModifier, @Nullable RemoteAnimation remoteAnimation) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return remoteAnimation != null ? AppWidgetModifiersKt.animation(glanceModifier, remoteAnimation) : glanceModifier;
    }

    @NotNull
    public static final GlanceModifier maybeClickable(@NotNull GlanceModifier glanceModifier, @Nullable Action action, boolean z, boolean z2, int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return action != null ? z ? i == 0 ? ActionKt.clickable(glanceModifier, action, true, z2) : ActionKt.clickable(glanceModifier, action, i) : ActionKt.clickable(glanceModifier, action, false, z2) : glanceModifier;
    }

    public static /* synthetic */ GlanceModifier maybeClickable$default(GlanceModifier glanceModifier, Action action, boolean z, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return maybeClickable(glanceModifier, action, z, z2, i);
    }

    @Composable
    /* JADX INFO: renamed from: percentToDp-6WKSPt0, reason: not valid java name */
    public static final float m21967percentToDp6WKSPt0(float f, int i, @Nullable Composer composer, int i2, int i4) {
        float fM20968constructorimpl;
        composer.startReplaceableGroup(1671736720);
        if ((i4 & 1) != 0) {
            i = PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1671736720, i2, -1, "androidx.glance.oneui.template.utils.percentToDp (GlanceModifierUtils.kt:65)");
        }
        if (PercentSizePolicy.m21375equalsimpl0(i, PercentSizePolicy.INSTANCE.m21382getWidth3SpTkPA())) {
            composer.startReplaceableGroup(1702339704);
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue()) * f);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1702339756);
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue()) * f);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM20968constructorimpl;
    }
}
