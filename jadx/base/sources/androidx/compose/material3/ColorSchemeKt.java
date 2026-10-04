package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ReadOnlyComposable;
import com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001aµ\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+\u001aµ\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010+\u001a)\u0010.\u001a\u00020\b*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010/\u001a\u000200H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\u001a\u001f\u0010\u0007\u001a\u00020\b*\u00020\u00042\u0006\u0010\t\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\u001a\u001c\u00105\u001a\u00020\b*\u00020\u00042\u0006\u00106\u001a\u000207H\u0000ø\u0001\u0001¢\u0006\u0002\u00108\u001a\u001f\u00109\u001a\u00020\b*\u00020\u00042\u0006\u0010/\u001a\u000200ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010;\u001a\u0014\u0010<\u001a\u00020\b*\u000207H\u0001ø\u0001\u0001¢\u0006\u0002\u0010=\u001a\u0014\u0010>\u001a\u00020?*\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006A"}, m13886d2 = {"DisabledAlpha", "", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/ColorScheme;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "contentColorFor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColorScheme", "primary", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "darkColorScheme-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "lightColorScheme", "lightColorScheme-G1PFc-w", "applyTonalElevation", "elevation", "Landroidx/compose/ui/unit/Dp;", "applyTonalElevation-Hht5A8o", "(Landroidx/compose/material3/ColorScheme;JF)J", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "fromToken", "value", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "surfaceColorAtElevation", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "toColor", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "updateColorSchemeFrom", "", "other", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ColorSchemeKt {
    public static final float DisabledAlpha = 0.38f;

    @NotNull
    private static final ProvidableCompositionLocal<ColorScheme> LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(new Function0<ColorScheme>() { // from class: androidx.compose.material3.ColorSchemeKt$LocalColorScheme$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ColorScheme invoke() {
            return ColorSchemeKt.m17102lightColorSchemeG1PFcw$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, SegmentTree.MAX_VALUE, null);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ColorSchemeKeyTokens.values().length];
            iArr[ColorSchemeKeyTokens.Background.ordinal()] = 1;
            iArr[ColorSchemeKeyTokens.Error.ordinal()] = 2;
            iArr[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
            iArr[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
            iArr[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
            iArr[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
            iArr[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
            iArr[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
            iArr[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
            iArr[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
            iArr[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
            iArr[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
            iArr[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
            iArr[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
            iArr[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
            iArr[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
            iArr[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
            iArr[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
            iArr[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
            iArr[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
            iArr[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
            iArr[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
            iArr[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
            iArr[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
            iArr[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
            iArr[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
            iArr[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
            iArr[ColorSchemeKeyTokens.Tertiary.ordinal()] = 28;
            iArr[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 29;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: applyTonalElevation-Hht5A8o, reason: not valid java name */
    public static final long m17096applyTonalElevationHht5A8o(@NotNull ColorScheme applyTonalElevation, long j, float f) {
        Intrinsics.checkNotNullParameter(applyTonalElevation, "$this$applyTonalElevation");
        return Color.m18526equalsimpl0(j, applyTonalElevation.m17062getSurface0d7_KjU()) ? m17103surfaceColorAtElevation3ABfNKs(applyTonalElevation, f) : j;
    }

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m17097contentColorFor4WTKRHQ(@NotNull ColorScheme contentColorFor, long j) {
        Intrinsics.checkNotNullParameter(contentColorFor, "$this$contentColorFor");
        return Color.m18526equalsimpl0(j, contentColorFor.m17057getPrimary0d7_KjU()) ? contentColorFor.m17047getOnPrimary0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m17060getSecondary0d7_KjU()) ? contentColorFor.m17049getOnSecondary0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m17065getTertiary0d7_KjU()) ? contentColorFor.m17053getOnTertiary0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m17038getBackground0d7_KjU()) ? contentColorFor.m17044getOnBackground0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m17039getError0d7_KjU()) ? contentColorFor.m17045getOnError0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m17062getSurface0d7_KjU()) ? contentColorFor.m17051getOnSurface0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m17064getSurfaceVariant0d7_KjU()) ? contentColorFor.m17052getOnSurfaceVariant0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m17058getPrimaryContainer0d7_KjU()) ? contentColorFor.m17048getOnPrimaryContainer0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m17061getSecondaryContainer0d7_KjU()) ? contentColorFor.m17050getOnSecondaryContainer0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m17066getTertiaryContainer0d7_KjU()) ? contentColorFor.m17054getOnTertiaryContainer0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m17040getErrorContainer0d7_KjU()) ? contentColorFor.m17046getOnErrorContainer0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m17043getInverseSurface0d7_KjU()) ? contentColorFor.m17041getInverseOnSurface0d7_KjU() : Color.INSTANCE.m18561getUnspecified0d7_KjU();
    }

    @Composable
    @ReadOnlyComposable
    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m17098contentColorForek8zF_U(long j, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, i, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:473)");
        }
        long jM17097contentColorFor4WTKRHQ = m17097contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j);
        if (jM17097contentColorFor4WTKRHQ == Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
            jM17097contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return jM17097contentColorFor4WTKRHQ;
    }

    @NotNull
    /* JADX INFO: renamed from: darkColorScheme-G1PFc-w, reason: not valid java name */
    public static final ColorScheme m17099darkColorSchemeG1PFcw(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30) {
        return new ColorScheme(j, j2, j3, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, null);
    }

    /* JADX INFO: renamed from: darkColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m17100darkColorSchemeG1PFcw$default(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, int i, Object obj) {
        long jM17536getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m17536getPrimary0d7_KjU() : j;
        long jM17526getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m17526getOnPrimary0d7_KjU() : j2;
        long jM17537getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m17537getPrimaryContainer0d7_KjU() : j3;
        long jM17527getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m17527getOnPrimaryContainer0d7_KjU() : j5;
        long jM17521getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m17521getInversePrimary0d7_KjU() : j6;
        long jM17539getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m17539getSecondary0d7_KjU() : j7;
        long jM17528getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m17528getOnSecondary0d7_KjU() : j8;
        long jM17540getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m17540getSecondaryContainer0d7_KjU() : j9;
        long j31 = jM17536getPrimary0d7_KjU;
        long jM17529getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m17529getOnSecondaryContainer0d7_KjU() : j10;
        long jM17544getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m17544getTertiary0d7_KjU() : j11;
        long jM17532getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m17532getOnTertiary0d7_KjU() : j12;
        long jM17545getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m17545getTertiaryContainer0d7_KjU() : j13;
        long jM17533getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m17533getOnTertiaryContainer0d7_KjU() : j14;
        long jM17517getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m17517getBackground0d7_KjU() : j15;
        long jM17523getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m17523getOnBackground0d7_KjU() : j16;
        long jM17541getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m17541getSurface0d7_KjU() : j17;
        long jM17530getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m17530getOnSurface0d7_KjU() : j18;
        long jM17543getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m17543getSurfaceVariant0d7_KjU() : j19;
        long jM17531getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m17531getOnSurfaceVariant0d7_KjU() : j20;
        long j32 = (i & 524288) != 0 ? j31 : j21;
        long jM17522getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m17522getInverseSurface0d7_KjU() : j22;
        long jM17520getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m17520getInverseOnSurface0d7_KjU() : j23;
        long jM17518getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m17518getError0d7_KjU() : j24;
        long jM17524getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m17524getOnError0d7_KjU() : j25;
        long jM17519getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m17519getErrorContainer0d7_KjU() : j26;
        long jM17525getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m17525getOnErrorContainer0d7_KjU() : j27;
        long jM17534getOutline0d7_KjU = (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m17534getOutline0d7_KjU() : j28;
        long jM17535getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m17535getOutlineVariant0d7_KjU() : j29;
        if ((i & 268435456) != 0) {
            j30 = ColorDarkTokens.INSTANCE.m17538getScrim0d7_KjU();
        }
        return m17099darkColorSchemeG1PFcw(j31, jM17526getOnPrimary0d7_KjU, jM17537getPrimaryContainer0d7_KjU, jM17527getOnPrimaryContainer0d7_KjU, jM17521getInversePrimary0d7_KjU, jM17539getSecondary0d7_KjU, jM17528getOnSecondary0d7_KjU, jM17540getSecondaryContainer0d7_KjU, jM17529getOnSecondaryContainer0d7_KjU, jM17544getTertiary0d7_KjU, jM17532getOnTertiary0d7_KjU, jM17545getTertiaryContainer0d7_KjU, jM17533getOnTertiaryContainer0d7_KjU, jM17517getBackground0d7_KjU, jM17523getOnBackground0d7_KjU, jM17541getSurface0d7_KjU, jM17530getOnSurface0d7_KjU, jM17543getSurfaceVariant0d7_KjU, jM17531getOnSurfaceVariant0d7_KjU, j32, jM17522getInverseSurface0d7_KjU, jM17520getInverseOnSurface0d7_KjU, jM17518getError0d7_KjU, jM17524getOnError0d7_KjU, jM17519getErrorContainer0d7_KjU, jM17525getOnErrorContainer0d7_KjU, jM17534getOutline0d7_KjU, jM17535getOutlineVariant0d7_KjU, j30);
    }

    public static final long fromToken(@NotNull ColorScheme colorScheme, @NotNull ColorSchemeKeyTokens value) {
        Intrinsics.checkNotNullParameter(colorScheme, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
            case 1:
                return colorScheme.m17038getBackground0d7_KjU();
            case 2:
                return colorScheme.m17039getError0d7_KjU();
            case 3:
                return colorScheme.m17040getErrorContainer0d7_KjU();
            case 4:
                return colorScheme.m17041getInverseOnSurface0d7_KjU();
            case 5:
                return colorScheme.m17042getInversePrimary0d7_KjU();
            case 6:
                return colorScheme.m17043getInverseSurface0d7_KjU();
            case 7:
                return colorScheme.m17044getOnBackground0d7_KjU();
            case 8:
                return colorScheme.m17045getOnError0d7_KjU();
            case 9:
                return colorScheme.m17046getOnErrorContainer0d7_KjU();
            case 10:
                return colorScheme.m17047getOnPrimary0d7_KjU();
            case 11:
                return colorScheme.m17048getOnPrimaryContainer0d7_KjU();
            case 12:
                return colorScheme.m17049getOnSecondary0d7_KjU();
            case 13:
                return colorScheme.m17050getOnSecondaryContainer0d7_KjU();
            case 14:
                return colorScheme.m17051getOnSurface0d7_KjU();
            case 15:
                return colorScheme.m17052getOnSurfaceVariant0d7_KjU();
            case 16:
                return colorScheme.m17063getSurfaceTint0d7_KjU();
            case 17:
                return colorScheme.m17053getOnTertiary0d7_KjU();
            case 18:
                return colorScheme.m17054getOnTertiaryContainer0d7_KjU();
            case 19:
                return colorScheme.m17055getOutline0d7_KjU();
            case 20:
                return colorScheme.m17056getOutlineVariant0d7_KjU();
            case 21:
                return colorScheme.m17057getPrimary0d7_KjU();
            case 22:
                return colorScheme.m17058getPrimaryContainer0d7_KjU();
            case 23:
                return colorScheme.m17059getScrim0d7_KjU();
            case 24:
                return colorScheme.m17060getSecondary0d7_KjU();
            case 25:
                return colorScheme.m17061getSecondaryContainer0d7_KjU();
            case 26:
                return colorScheme.m17062getSurface0d7_KjU();
            case 27:
                return colorScheme.m17064getSurfaceVariant0d7_KjU();
            case 28:
                return colorScheme.m17065getTertiary0d7_KjU();
            case 29:
                return colorScheme.m17066getTertiaryContainer0d7_KjU();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public static final ProvidableCompositionLocal<ColorScheme> getLocalColorScheme() {
        return LocalColorScheme;
    }

    @NotNull
    /* JADX INFO: renamed from: lightColorScheme-G1PFc-w, reason: not valid java name */
    public static final ColorScheme m17101lightColorSchemeG1PFcw(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30) {
        return new ColorScheme(j, j2, j3, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, null);
    }

    /* JADX INFO: renamed from: lightColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m17102lightColorSchemeG1PFcw$default(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, int i, Object obj) {
        long jM17565getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m17565getPrimary0d7_KjU() : j;
        long jM17555getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m17555getOnPrimary0d7_KjU() : j2;
        long jM17566getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m17566getPrimaryContainer0d7_KjU() : j3;
        long jM17556getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m17556getOnPrimaryContainer0d7_KjU() : j5;
        long jM17550getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m17550getInversePrimary0d7_KjU() : j6;
        long jM17568getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m17568getSecondary0d7_KjU() : j7;
        long jM17557getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m17557getOnSecondary0d7_KjU() : j8;
        long jM17569getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m17569getSecondaryContainer0d7_KjU() : j9;
        long j31 = jM17565getPrimary0d7_KjU;
        long jM17558getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m17558getOnSecondaryContainer0d7_KjU() : j10;
        long jM17573getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m17573getTertiary0d7_KjU() : j11;
        long jM17561getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m17561getOnTertiary0d7_KjU() : j12;
        long jM17574getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m17574getTertiaryContainer0d7_KjU() : j13;
        long jM17562getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m17562getOnTertiaryContainer0d7_KjU() : j14;
        long jM17546getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m17546getBackground0d7_KjU() : j15;
        long jM17552getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m17552getOnBackground0d7_KjU() : j16;
        long jM17570getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m17570getSurface0d7_KjU() : j17;
        long jM17559getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m17559getOnSurface0d7_KjU() : j18;
        long jM17572getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m17572getSurfaceVariant0d7_KjU() : j19;
        long jM17560getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m17560getOnSurfaceVariant0d7_KjU() : j20;
        long j32 = (i & 524288) != 0 ? j31 : j21;
        long jM17551getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m17551getInverseSurface0d7_KjU() : j22;
        long jM17549getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m17549getInverseOnSurface0d7_KjU() : j23;
        long jM17547getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m17547getError0d7_KjU() : j24;
        long jM17553getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m17553getOnError0d7_KjU() : j25;
        long jM17548getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m17548getErrorContainer0d7_KjU() : j26;
        long jM17554getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m17554getOnErrorContainer0d7_KjU() : j27;
        long jM17563getOutline0d7_KjU = (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m17563getOutline0d7_KjU() : j28;
        long jM17564getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorLightTokens.INSTANCE.m17564getOutlineVariant0d7_KjU() : j29;
        if ((i & 268435456) != 0) {
            j30 = ColorLightTokens.INSTANCE.m17567getScrim0d7_KjU();
        }
        return m17101lightColorSchemeG1PFcw(j31, jM17555getOnPrimary0d7_KjU, jM17566getPrimaryContainer0d7_KjU, jM17556getOnPrimaryContainer0d7_KjU, jM17550getInversePrimary0d7_KjU, jM17568getSecondary0d7_KjU, jM17557getOnSecondary0d7_KjU, jM17569getSecondaryContainer0d7_KjU, jM17558getOnSecondaryContainer0d7_KjU, jM17573getTertiary0d7_KjU, jM17561getOnTertiary0d7_KjU, jM17574getTertiaryContainer0d7_KjU, jM17562getOnTertiaryContainer0d7_KjU, jM17546getBackground0d7_KjU, jM17552getOnBackground0d7_KjU, jM17570getSurface0d7_KjU, jM17559getOnSurface0d7_KjU, jM17572getSurfaceVariant0d7_KjU, jM17560getOnSurfaceVariant0d7_KjU, j32, jM17551getInverseSurface0d7_KjU, jM17549getInverseOnSurface0d7_KjU, jM17547getError0d7_KjU, jM17553getOnError0d7_KjU, jM17548getErrorContainer0d7_KjU, jM17554getOnErrorContainer0d7_KjU, jM17563getOutline0d7_KjU, jM17564getOutlineVariant0d7_KjU, j30);
    }

    /* JADX INFO: renamed from: surfaceColorAtElevation-3ABfNKs, reason: not valid java name */
    public static final long m17103surfaceColorAtElevation3ABfNKs(@NotNull ColorScheme surfaceColorAtElevation, float f) {
        Intrinsics.checkNotNullParameter(surfaceColorAtElevation, "$this$surfaceColorAtElevation");
        if (C2256Dp.m20973equalsimpl0(f, C2256Dp.m20968constructorimpl(0))) {
            return surfaceColorAtElevation.m17062getSurface0d7_KjU();
        }
        return ColorKt.m18570compositeOverOWjLjI(Color.m18524copywmQWz5c$default(surfaceColorAtElevation.m17063getSurfaceTint0d7_KjU(), ((((float) Math.log(f + 1)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null), surfaceColorAtElevation.m17062getSurface0d7_KjU());
    }

    @Composable
    @ReadOnlyComposable
    public static final long toColor(@NotNull ColorSchemeKeyTokens colorSchemeKeyTokens, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(colorSchemeKeyTokens, "<this>");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1330949347, i, -1, "androidx.compose.material3.toColor (ColorScheme.kt:611)");
        }
        long jFromToken = fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), colorSchemeKeyTokens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return jFromToken;
    }

    public static final void updateColorSchemeFrom(@NotNull ColorScheme colorScheme, @NotNull ColorScheme other) {
        Intrinsics.checkNotNullParameter(colorScheme, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        colorScheme.m17086setPrimary8_81llA$material3_release(other.m17057getPrimary0d7_KjU());
        colorScheme.m17076setOnPrimary8_81llA$material3_release(other.m17047getOnPrimary0d7_KjU());
        colorScheme.m17087setPrimaryContainer8_81llA$material3_release(other.m17058getPrimaryContainer0d7_KjU());
        colorScheme.m17077setOnPrimaryContainer8_81llA$material3_release(other.m17048getOnPrimaryContainer0d7_KjU());
        colorScheme.m17071setInversePrimary8_81llA$material3_release(other.m17042getInversePrimary0d7_KjU());
        colorScheme.m17089setSecondary8_81llA$material3_release(other.m17060getSecondary0d7_KjU());
        colorScheme.m17078setOnSecondary8_81llA$material3_release(other.m17049getOnSecondary0d7_KjU());
        colorScheme.m17090setSecondaryContainer8_81llA$material3_release(other.m17061getSecondaryContainer0d7_KjU());
        colorScheme.m17079setOnSecondaryContainer8_81llA$material3_release(other.m17050getOnSecondaryContainer0d7_KjU());
        colorScheme.m17094setTertiary8_81llA$material3_release(other.m17065getTertiary0d7_KjU());
        colorScheme.m17082setOnTertiary8_81llA$material3_release(other.m17053getOnTertiary0d7_KjU());
        colorScheme.m17095setTertiaryContainer8_81llA$material3_release(other.m17066getTertiaryContainer0d7_KjU());
        colorScheme.m17083setOnTertiaryContainer8_81llA$material3_release(other.m17054getOnTertiaryContainer0d7_KjU());
        colorScheme.m17067setBackground8_81llA$material3_release(other.m17038getBackground0d7_KjU());
        colorScheme.m17073setOnBackground8_81llA$material3_release(other.m17044getOnBackground0d7_KjU());
        colorScheme.m17091setSurface8_81llA$material3_release(other.m17062getSurface0d7_KjU());
        colorScheme.m17080setOnSurface8_81llA$material3_release(other.m17051getOnSurface0d7_KjU());
        colorScheme.m17093setSurfaceVariant8_81llA$material3_release(other.m17064getSurfaceVariant0d7_KjU());
        colorScheme.m17081setOnSurfaceVariant8_81llA$material3_release(other.m17052getOnSurfaceVariant0d7_KjU());
        colorScheme.m17092setSurfaceTint8_81llA$material3_release(other.m17063getSurfaceTint0d7_KjU());
        colorScheme.m17072setInverseSurface8_81llA$material3_release(other.m17043getInverseSurface0d7_KjU());
        colorScheme.m17070setInverseOnSurface8_81llA$material3_release(other.m17041getInverseOnSurface0d7_KjU());
        colorScheme.m17068setError8_81llA$material3_release(other.m17039getError0d7_KjU());
        colorScheme.m17074setOnError8_81llA$material3_release(other.m17045getOnError0d7_KjU());
        colorScheme.m17069setErrorContainer8_81llA$material3_release(other.m17040getErrorContainer0d7_KjU());
        colorScheme.m17075setOnErrorContainer8_81llA$material3_release(other.m17046getOnErrorContainer0d7_KjU());
        colorScheme.m17084setOutline8_81llA$material3_release(other.m17055getOutline0d7_KjU());
        colorScheme.m17085setOutlineVariant8_81llA$material3_release(other.m17056getOutlineVariant0d7_KjU());
        colorScheme.m17088setScrim8_81llA$material3_release(other.m17059getScrim0d7_KjU());
    }
}
