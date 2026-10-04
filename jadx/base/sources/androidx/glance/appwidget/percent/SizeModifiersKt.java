package androidx.glance.appwidget.percent;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.GlanceModifier;
import androidx.glance.appwidget.CornerRadiusModifier;
import androidx.glance.appwidget.percent.PercentSizePolicy;
import androidx.glance.layout.HeightModifier;
import androidx.glance.layout.WidthModifier;
import androidx.glance.unit.Dimension;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a*\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000e\u001a\u00020\u0007*\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000f\u001a(\u0010\u0010\u001a\u00020\u0007*\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0011\u0010\u0015\u001a\u00020\u0012*\u00020\tH\u0001¢\u0006\u0002\u0010\u0016\u001a\u0011\u0010\u0017\u001a\u00020\u0012*\u00020\tH\u0001¢\u0006\u0002\u0010\u0016\u001a4\u0010\u0018\u001a\u00020\u0007*\u00020\u00072\b\b\u0001\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a%\u0010\u0018\u001a\u00020\u0007*\u00020\u00072\b\b\u0001\u0010\u001c\u001a\u00020\t2\b\b\u0001\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0014\u001aH\u0010\u001d\u001a\u00020\u0007*\u00020\u00072\b\b\u0001\u0010\u001c\u001a\u00020\t2\b\b\u0001\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001aD\u0010\"\u001a\u00020\u0007*\u00020\u00072\b\b\u0001\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001b\u0010\u001c\u001a\u00020\u0007*\u00020\u00072\b\b\u0001\u0010\u001c\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000f\u001a(\u0010%\u001a\u00020\u0007*\u00020\u00072\b\b\u0001\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, m13886d2 = {"PERCENT_PARAM_LAYOUT_HEIGHT", "", "PERCENT_PARAM_LAYOUT_WIDTH", "PERCENT_POLICY_BY_ALL", "PERCENT_POLICY_BY_HEIGHT", "PERCENT_POLICY_BY_WIDTH", "cornerRadius", "Landroidx/glance/GlanceModifier;", "radius", "", "policy", "Landroidx/glance/appwidget/percent/PercentSizePolicy;", "cornerRadius-LwRUR8o", "(Landroidx/glance/GlanceModifier;FILandroidx/compose/runtime/Composer;II)Landroidx/glance/GlanceModifier;", "height", "(Landroidx/glance/GlanceModifier;FLandroidx/compose/runtime/Composer;I)Landroidx/glance/GlanceModifier;", "heightIn", VElementFormulasCmd.FMAX, "Landroidx/compose/ui/unit/Dp;", "heightIn-TDGSqEk", "(Landroidx/glance/GlanceModifier;FFLandroidx/compose/runtime/Composer;I)Landroidx/glance/GlanceModifier;", "percentToDpByHeight", "(FLandroidx/compose/runtime/Composer;I)F", "percentToDpByWidth", "size", "ratio", "size-9UT-dIk", "(Landroidx/glance/GlanceModifier;FIFLandroidx/compose/runtime/Composer;II)Landroidx/glance/GlanceModifier;", "width", "sizeBySmallerPercentWithRatio", "maxWidth", "maxHeight", "sizeBySmallerPercentWithRatio-nSlTg7c", "(Landroidx/glance/GlanceModifier;FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/glance/GlanceModifier;", "sizeIn", "sizeIn-g5qJ-kM", "(Landroidx/glance/GlanceModifier;FIFFFLandroidx/compose/runtime/Composer;II)Landroidx/glance/GlanceModifier;", "widthIn", "widthIn-TDGSqEk", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSizeModifiers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SizeModifiers.kt\nandroidx/glance/appwidget/percent/SizeModifiersKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,271:1\n74#2:272\n74#2:274\n74#2:275\n74#2:278\n74#2:279\n74#2:283\n74#2:284\n74#2:287\n74#2:288\n74#2:292\n74#2:293\n74#2:295\n74#2:297\n74#2:302\n74#2:303\n74#2:305\n154#3:273\n154#3:277\n189#3:281\n154#3:282\n154#3:286\n189#3:290\n154#3:291\n189#3:298\n189#3:299\n174#3:300\n174#3:301\n88#4:276\n88#4:280\n88#4:285\n88#4:289\n88#4:294\n88#4:296\n88#4:304\n88#4:306\n*S KotlinDebug\n*F\n+ 1 SizeModifiers.kt\nandroidx/glance/appwidget/percent/SizeModifiersKt\n*L\n74#1:272\n84#1:274\n85#1:275\n100#1:278\n105#1:279\n125#1:283\n127#1:284\n141#1:287\n143#1:288\n168#1:292\n173#1:293\n176#1:295\n194#1:297\n247#1:302\n258#1:303\n261#1:305\n75#1:273\n88#1:277\n104#1:281\n113#1:282\n130#1:286\n143#1:290\n146#1:291\n201#1:298\n212#1:299\n243#1:300\n244#1:301\n85#1:276\n105#1:280\n127#1:285\n143#1:289\n173#1:294\n176#1:296\n258#1:304\n261#1:306\n*E\n"})
public final class SizeModifiersKt {
    public static final int PERCENT_PARAM_LAYOUT_HEIGHT = 9;
    public static final int PERCENT_PARAM_LAYOUT_WIDTH = 8;
    public static final int PERCENT_POLICY_BY_ALL = 0;
    public static final int PERCENT_POLICY_BY_HEIGHT = 2;
    public static final int PERCENT_POLICY_BY_WIDTH = 1;

    @Composable
    @NotNull
    /* JADX INFO: renamed from: cornerRadius-LwRUR8o, reason: not valid java name */
    public static final GlanceModifier m21385cornerRadiusLwRUR8o(@NotNull GlanceModifier cornerRadius, @PercentRange float f, int i, @Nullable Composer composer, int i2, int i4) {
        GlanceModifier glanceModifierThen;
        Intrinsics.checkNotNullParameter(cornerRadius, "$this$cornerRadius");
        composer.startReplaceableGroup(-2083610227);
        if ((i4 & 2) != 0) {
            i = PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2083610227, i2, -1, "androidx.glance.appwidget.percent.cornerRadius (SizeModifiers.kt:72)");
        }
        if (((Boolean) composer.consume(CompositionLocalsKt.getLocalRealDataPreviewMode())).booleanValue()) {
            glanceModifierThen = cornerRadius.then(new CornerRadiusModifier(new Dimension.C3532Dp(C2256Dp.m20968constructorimpl(50), null)));
        } else if (PercentSizePolicy.m21375equalsimpl0(i, PercentSizePolicy.INSTANCE.m21382getWidth3SpTkPA())) {
            composer.startReplaceableGroup(-830409886);
            glanceModifierThen = cornerRadius.then(new CornerRadiusModifier(new Dimension.C3532Dp(percentToDpByWidth(f, composer, (i2 >> 3) & 14), null)));
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-830409795);
            glanceModifierThen = cornerRadius.then(new CornerRadiusModifier(new Dimension.C3532Dp(percentToDpByHeight(f, composer, (i2 >> 3) & 14), null)));
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierThen;
    }

    @Composable
    @NotNull
    public static final GlanceModifier height(@NotNull GlanceModifier glanceModifier, @PercentRange float f, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        composer.startReplaceableGroup(1013264217);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1013264217, i, -1, "androidx.glance.appwidget.percent.height (SizeModifiers.kt:123)");
        }
        GlanceModifier glanceModifierThen = !((Boolean) composer.consume(CompositionLocalsKt.getLocalRealDataPreviewMode())).booleanValue() ? glanceModifier.then(new HeightModifier(new Dimension.C3532Dp(C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue()) * f), null))) : glanceModifier.then(new HeightModifier(new Dimension.C3532Dp(C2256Dp.m20968constructorimpl(1), null))).then(new PercentHeightModifier(f, PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA(), 0.0f, 0.0f, 12, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierThen;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: heightIn-TDGSqEk, reason: not valid java name */
    public static final GlanceModifier m21386heightInTDGSqEk(@NotNull GlanceModifier heightIn, @PercentRange float f, float f4, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(heightIn, "$this$heightIn");
        composer.startReplaceableGroup(-1434728922);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1434728922, i, -1, "androidx.glance.appwidget.percent.heightIn (SizeModifiers.kt:139)");
        }
        GlanceModifier glanceModifierThen = !((Boolean) composer.consume(CompositionLocalsKt.getLocalRealDataPreviewMode())).booleanValue() ? heightIn.then(new HeightModifier(new Dimension.C3532Dp(C2256Dp.m20968constructorimpl(Math.min(C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue()) * f), f4)), null))) : heightIn.then(new HeightModifier(new Dimension.C3532Dp(C2256Dp.m20968constructorimpl(1), null))).then(new PercentHeightModifier(f, PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA(), 0.0f, f4, 4, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierThen;
    }

    @Composable
    public static final float percentToDpByHeight(float f, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1215869108);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1215869108, i, -1, "androidx.glance.appwidget.percent.percentToDpByHeight (SizeModifiers.kt:260)");
        }
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue()) * f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM20968constructorimpl;
    }

    @Composable
    public static final float percentToDpByWidth(float f, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1525050555);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1525050555, i, -1, "androidx.glance.appwidget.percent.percentToDpByWidth (SizeModifiers.kt:257)");
        }
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue()) * f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM20968constructorimpl;
    }

    @Composable
    @NotNull
    public static final GlanceModifier size(@NotNull GlanceModifier glanceModifier, @PercentRange float f, @PercentRange float f4, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        composer.startReplaceableGroup(2083436143);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2083436143, i, -1, "androidx.glance.appwidget.percent.size (SizeModifiers.kt:159)");
        }
        GlanceModifier glanceModifierHeight = height(width(glanceModifier, f, composer, i & 126), f4, composer, (i >> 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierHeight;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: size-9UT-dIk, reason: not valid java name */
    public static final GlanceModifier m21387size9UTdIk(@NotNull GlanceModifier size, @PercentRange float f, int i, float f4, @Nullable Composer composer, int i2, int i4) {
        GlanceModifier glanceModifierThen;
        Intrinsics.checkNotNullParameter(size, "$this$size");
        composer.startReplaceableGroup(1283338883);
        if ((i4 & 2) != 0) {
            i = PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA();
        }
        if ((i4 & 4) != 0) {
            f4 = 1.0f;
        }
        float f5 = f4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1283338883, i2, -1, "androidx.glance.appwidget.percent.size (SizeModifiers.kt:166)");
        }
        if (((Boolean) composer.consume(CompositionLocalsKt.getLocalRealDataPreviewMode())).booleanValue()) {
            glanceModifierThen = size.then(new PercentRatioSizeModifier(f, f, 0.0f, 0.0f, f5, 12, null));
        } else {
            PercentSizePolicy.Companion companion = PercentSizePolicy.INSTANCE;
            if (PercentSizePolicy.m21375equalsimpl0(i, companion.m21382getWidth3SpTkPA())) {
                composer.startReplaceableGroup(857814749);
                glanceModifierThen = width(size, f, composer, i2 & 126).then(new HeightModifier(new Dimension.C3532Dp(C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue()) * f), null)));
                composer.endReplaceableGroup();
            } else if (PercentSizePolicy.m21375equalsimpl0(i, companion.m21381getHeight3SpTkPA())) {
                composer.startReplaceableGroup(857814966);
                glanceModifierThen = height(size.then(new WidthModifier(new Dimension.C3532Dp(C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue()) * f), null))), f, composer, i2 & 112);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(857815026);
                glanceModifierThen = height(width(size, f, composer, i2 & 126), f, composer, i2 & 112);
                composer.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierThen;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: sizeBySmallerPercentWithRatio-nSlTg7c, reason: not valid java name */
    public static final GlanceModifier m21388sizeBySmallerPercentWithRationSlTg7c(@NotNull GlanceModifier sizeBySmallerPercentWithRatio, @PercentRange float f, @PercentRange float f4, float f5, float f6, float f7, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(sizeBySmallerPercentWithRatio, "$this$sizeBySmallerPercentWithRatio");
        composer.startReplaceableGroup(-831206226);
        float fM20968constructorimpl = (i2 & 4) != 0 ? C2256Dp.m20968constructorimpl(Float.MAX_VALUE) : f5;
        float fM20968constructorimpl2 = (i2 & 8) != 0 ? C2256Dp.m20968constructorimpl(Float.MAX_VALUE) : f6;
        float f8 = (i2 & 16) != 0 ? 1.0f : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-831206226, i, -1, "androidx.glance.appwidget.percent.sizeBySmallerPercentWithRatio (SizeModifiers.kt:245)");
        }
        if (((Boolean) composer.consume(CompositionLocalsKt.getLocalRealDataPreviewMode())).booleanValue()) {
            GlanceModifier glanceModifierThen = sizeBySmallerPercentWithRatio.then(new PercentRatioSizeModifier(f, f4, fM20968constructorimpl, fM20968constructorimpl2, f8));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return glanceModifierThen;
        }
        int i4 = i >> 3;
        long jM21383getMinDpSizeFromPercentDataM_xkUdw = PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(f, f4, fM20968constructorimpl, fM20968constructorimpl2, f8, composer, (i4 & 14) | 196608 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (i4 & 57344), 0);
        GlanceModifier glanceModifierM21505height3ABfNKs = androidx.glance.layout.SizeModifiersKt.m21505height3ABfNKs(androidx.glance.layout.SizeModifiersKt.m21508width3ABfNKs(sizeBySmallerPercentWithRatio, DpSize.m21066getWidthD9Ej5fM(jM21383getMinDpSizeFromPercentDataM_xkUdw)), DpSize.m21064getHeightD9Ej5fM(jM21383getMinDpSizeFromPercentDataM_xkUdw));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierM21505height3ABfNKs;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: sizeIn-g5qJ-kM, reason: not valid java name */
    public static final GlanceModifier m21389sizeIng5qJkM(@NotNull GlanceModifier sizeIn, @PercentRange float f, int i, float f4, float f5, float f6, @Nullable Composer composer, int i2, int i4) {
        GlanceModifier glanceModifierThen;
        Intrinsics.checkNotNullParameter(sizeIn, "$this$sizeIn");
        composer.startReplaceableGroup(1098872734);
        if ((i4 & 2) != 0) {
            i = PercentSizePolicy.INSTANCE.m21381getHeight3SpTkPA();
        }
        if ((i4 & 16) != 0) {
            f6 = 1.0f;
        }
        float f7 = f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1098872734, i2, -1, "androidx.glance.appwidget.percent.sizeIn (SizeModifiers.kt:192)");
        }
        if (((Boolean) composer.consume(CompositionLocalsKt.getLocalRealDataPreviewMode())).booleanValue()) {
            glanceModifierThen = sizeIn.then(new PercentRatioSizeModifier(f, f, f4, f5, f7));
        } else {
            PercentSizePolicy.Companion companion = PercentSizePolicy.INSTANCE;
            if (PercentSizePolicy.m21375equalsimpl0(i, companion.m21382getWidth3SpTkPA())) {
                composer.startReplaceableGroup(-279022747);
                int i5 = i2 >> 3;
                glanceModifierThen = m21390widthInTDGSqEk(sizeIn, f, f4, composer, (i2 & 126) | (i5 & 896)).then(new HeightModifier(new Dimension.C3532Dp(C2256Dp.m20968constructorimpl(Math.min(percentToDpByWidth(f, composer, i5 & 14), f5)), null)));
                composer.endReplaceableGroup();
            } else if (PercentSizePolicy.m21375equalsimpl0(i, companion.m21381getHeight3SpTkPA())) {
                composer.startReplaceableGroup(-279022154);
                glanceModifierThen = m21386heightInTDGSqEk(sizeIn.then(new WidthModifier(new Dimension.C3532Dp(C2256Dp.m20968constructorimpl(Math.min(percentToDpByHeight(f, composer, (i2 >> 3) & 14), f4)), null))), f, f5, composer, (i2 & 112) | ((i2 >> 6) & 896));
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-279022032);
                glanceModifierThen = m21386heightInTDGSqEk(m21390widthInTDGSqEk(sizeIn, f, f4, composer, (i2 & 126) | ((i2 >> 3) & 896)), f, f5, composer, (i2 & 112) | ((i2 >> 6) & 896));
                composer.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierThen;
    }

    @Composable
    @NotNull
    public static final GlanceModifier width(@NotNull GlanceModifier glanceModifier, @PercentRange float f, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        composer.startReplaceableGroup(-1468688540);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1468688540, i, -1, "androidx.glance.appwidget.percent.width (SizeModifiers.kt:82)");
        }
        GlanceModifier glanceModifierThen = !((Boolean) composer.consume(CompositionLocalsKt.getLocalRealDataPreviewMode())).booleanValue() ? glanceModifier.then(new WidthModifier(new Dimension.C3532Dp(C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue()) * f), null))) : glanceModifier.then(new WidthModifier(new Dimension.C3532Dp(C2256Dp.m20968constructorimpl(1), null))).then(new PercentWidthModifier(f, PercentSizePolicy.INSTANCE.m21382getWidth3SpTkPA(), 0.0f, 0.0f, 12, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierThen;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: widthIn-TDGSqEk, reason: not valid java name */
    public static final GlanceModifier m21390widthInTDGSqEk(@NotNull GlanceModifier widthIn, @PercentRange float f, float f4, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(widthIn, "$this$widthIn");
        composer.startReplaceableGroup(-751719173);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-751719173, i, -1, "androidx.glance.appwidget.percent.widthIn (SizeModifiers.kt:98)");
        }
        GlanceModifier glanceModifierThen = !((Boolean) composer.consume(CompositionLocalsKt.getLocalRealDataPreviewMode())).booleanValue() ? widthIn.then(new WidthModifier(new Dimension.C3532Dp(C2256Dp.m20968constructorimpl(Math.min(C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue()) * f), f4)), null))) : widthIn.then(new WidthModifier(new Dimension.C3532Dp(C2256Dp.m20968constructorimpl(1), null))).then(new PercentWidthModifier(f, PercentSizePolicy.INSTANCE.m21382getWidth3SpTkPA(), 0.0f, f4, 4, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierThen;
    }
}
