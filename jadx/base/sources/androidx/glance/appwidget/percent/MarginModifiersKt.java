package androidx.glance.appwidget.percent;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.GlanceModifier;
import androidx.glance.appwidget.MarginKt;
import androidx.glance.appwidget.percent.PercentSizePolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.java.awt.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\r\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0003\u0010\u000e\u001a\u00020\u00062\b\b\u0003\u0010\u000f\u001a\u00020\u00062\b\b\u0003\u0010\u0010\u001a\u00020\u00062\b\b\u0003\u0010\u0011\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, m13886d2 = {"margin", "Landroidx/glance/GlanceModifier;", "padding", "Landroidx/glance/appwidget/percent/PercentRect;", "(Landroidx/glance/GlanceModifier;Landroidx/glance/appwidget/percent/PercentRect;Landroidx/compose/runtime/Composer;I)Landroidx/glance/GlanceModifier;", "all", "", "policy", "Landroidx/glance/appwidget/percent/PercentSizePolicy;", "margin-LwRUR8o", "(Landroidx/glance/GlanceModifier;FILandroidx/compose/runtime/Composer;II)Landroidx/glance/GlanceModifier;", "horizontal", "vertical", "(Landroidx/glance/GlanceModifier;FFLandroidx/compose/runtime/Composer;I)Landroidx/glance/GlanceModifier;", "start", "top", "end", "bottom", "(Landroidx/glance/GlanceModifier;FFFFLandroidx/compose/runtime/Composer;II)Landroidx/glance/GlanceModifier;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class MarginModifiersKt {
    @Composable
    @NotNull
    public static final GlanceModifier margin(@NotNull GlanceModifier glanceModifier, @PercentRange float f, @PercentRange float f4, @PercentRange float f5, @PercentRange float f6, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        composer.startReplaceableGroup(-1056729233);
        if ((i2 & 1) != 0) {
            f = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f5 = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f6 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1056729233, i, -1, "androidx.glance.appwidget.percent.margin (MarginModifiers.kt:20)");
        }
        GlanceModifier glanceModifierM21309marginqDBjuR0 = MarginKt.m21309marginqDBjuR0(glanceModifier, SizeModifiersKt.percentToDpByWidth(f, composer, (i >> 3) & 14), SizeModifiersKt.percentToDpByHeight(f4, composer, (i >> 6) & 14), SizeModifiersKt.percentToDpByWidth(f5, composer, (i >> 9) & 14), SizeModifiersKt.percentToDpByHeight(f6, composer, (i >> 12) & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierM21309marginqDBjuR0;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0092  */
    @Composable
    @NotNull
    /* JADX INFO: renamed from: margin-LwRUR8o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final GlanceModifier m21355marginLwRUR8o(@NotNull GlanceModifier margin, @PercentRange float f, int i, @Nullable Composer composer, int i2, int i4) {
        Composer composer2;
        GlanceModifier glanceModifierMargin;
        Intrinsics.checkNotNullParameter(margin, "$this$margin");
        composer.startReplaceableGroup(1249994163);
        if ((i4 & 2) != 0) {
            i = PercentSizePolicy.INSTANCE.m21380getAll3SpTkPA();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1249994163, i2, -1, "androidx.glance.appwidget.percent.margin (MarginModifiers.kt:50)");
        }
        PercentSizePolicy.Companion companion = PercentSizePolicy.INSTANCE;
        if (PercentSizePolicy.m21375equalsimpl0(i, companion.m21382getWidth3SpTkPA())) {
            composer.startReplaceableGroup(-1545413597);
            glanceModifierMargin = MarginKt.m21306margin3ABfNKs(margin, SizeModifiersKt.percentToDpByWidth(f, composer, (i2 >> 3) & 14));
            composer.endReplaceableGroup();
        } else {
            if (!PercentSizePolicy.m21375equalsimpl0(i, companion.m21381getHeight3SpTkPA())) {
                composer.startReplaceableGroup(-1545413401);
                composer2 = composer;
                glanceModifierMargin = margin(margin, f, f, f, f, composer2, (i2 & 126) | ((i2 << 3) & 896) | ((i2 << 6) & 7168) | ((i2 << 9) & 57344), 0);
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceableGroup();
                return glanceModifierMargin;
            }
            composer.startReplaceableGroup(-1545413492);
            glanceModifierMargin = MarginKt.m21306margin3ABfNKs(margin, SizeModifiersKt.percentToDpByHeight(f, composer, (i2 >> 3) & 14));
            composer.endReplaceableGroup();
        }
        composer2 = composer;
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2.endReplaceableGroup();
        return glanceModifierMargin;
    }

    @Composable
    @NotNull
    public static final GlanceModifier margin(@NotNull GlanceModifier glanceModifier, @NotNull PercentRect padding, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(padding, "padding");
        composer.startReplaceableGroup(1342716498);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1342716498, i, -1, "androidx.glance.appwidget.percent.margin (MarginModifiers.kt:28)");
        }
        GlanceModifier glanceModifierMargin = margin(glanceModifier, padding.getLeft(), padding.getTop(), padding.getRight(), padding.getBottom(), composer, i & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierMargin;
    }

    @Composable
    @NotNull
    public static final GlanceModifier margin(@NotNull GlanceModifier glanceModifier, @PercentRange float f, @PercentRange float f4, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        composer.startReplaceableGroup(1293447183);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1293447183, i, -1, "androidx.glance.appwidget.percent.margin (MarginModifiers.kt:41)");
        }
        int i2 = i & Event.CAPS_LOCK;
        int i4 = i << 6;
        GlanceModifier glanceModifierMargin = margin(glanceModifier, f, f4, f, f4, composer, i2 | (i4 & 7168) | (i4 & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierMargin;
    }
}
