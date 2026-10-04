package androidx.glance.oneui.template.color;

import android.content.Context;
import androidx.compose.material3.ColorScheme;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.color.ColorProviders;
import androidx.glance.material3.Material3ThemesKt;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0007\u001a²\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\u00012\b\b\u0002\u0010\"\u001a\u00020\u00012\b\b\u0002\u0010#\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020\u00012\b\b\u0002\u0010%\u001a\u00020\u00012\b\b\u0002\u0010&\u001a\u00020\u00012\b\b\u0002\u0010'\u001a\u00020\u00012\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00012\b\b\u0002\u0010*\u001a\u00020\u00012\b\b\u0002\u0010+\u001a\u00020\u00012\b\b\u0002\u0010,\u001a\u00020\u00012\b\b\u0002\u0010-\u001a\u00020\u00012\b\b\u0002\u0010.\u001a\u00020\u00012\b\b\u0002\u0010/\u001a\u00020\u00012\b\b\u0002\u00100\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\u0019\u00103\u001a\u000204*\u0002042\u0006\u00105\u001a\u000204H\u0007¢\u0006\u0002\u00106\u001a\u001e\u00107\u001a\u00020\u0001*\u00020\u00012\b\u00108\u001a\u0004\u0018\u00010\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u0014\u00107\u001a\u000204*\u0002042\b\u00108\u001a\u0004\u0018\u000104\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0014\u0010\u0010\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;"}, m13886d2 = {"ColorNotDefined", "Landroidx/compose/ui/graphics/Color;", "getColorNotDefined", "()J", "J", "MonotoneGraphColorArray", "", "", "getMonotoneGraphColorArray", "()Ljava/util/List;", "complicationColorProviders", "Landroidx/glance/color/ColorProviders;", "getComplicationColorProviders", "()Landroidx/glance/color/ColorProviders;", "defaultColorProviders", "getDefaultColorProviders", "monotoneColorProviders", "getMonotoneColorProviders", "createColorProviders", "Landroidx/compose/material3/ColorScheme;", "primary", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "createColorProviders-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "mixedByAlpha", "Landroidx/glance/unit/ColorProvider;", "alphaColor", "(Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;I)Landroidx/glance/unit/ColorProvider;", "override", "overrideColor", "override-THrllMk", "(JLandroidx/compose/ui/graphics/Color;)J", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nColorProviders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ColorProviders.kt\nandroidx/glance/oneui/template/color/ColorProvidersKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,179:1\n74#2:180\n*S KotlinDebug\n*F\n+ 1 ColorProviders.kt\nandroidx/glance/oneui/template/color/ColorProvidersKt\n*L\n172#1:180\n*E\n"})
public final class ColorProvidersKt {
    private static final long ColorNotDefined = Color.INSTANCE.m18558getMagenta0d7_KjU();

    @NotNull
    private static final List<Integer> MonotoneGraphColorArray = CollectionsKt.listOf((Object[]) new Integer[]{452984831, 1308622847, -2130706433, -1});

    @NotNull
    private static final ColorProviders defaultColorProviders = Material3ThemesKt.ColorProviders(m21701createColorProvidersG1PFcw$default(ColorKt.Color(4281891583L), ColorKt.Color(4294638335L), ColorKt.Color(419430400), ColorKt.Color(4278255874L), 0, 0, 0, 0, 0, 0, 0, 0, 0, ColorKt.Color(2583493887L), ColorKt.Color(4278255874L), ColorKt.Color(2163405554L), ColorKt.Color(3422552064L), 0, ColorKt.Color(2566914048L), 0, ColorKt.Color(2566979842L), ColorKt.Color(4294638335L), 0, 0, 0, 0, 0, 0, 0, 533340144, null), m21701createColorProvidersG1PFcw$default(ColorKt.Color(4281891583L), ColorKt.Color(4294638335L), ColorKt.Color(436207615), ColorKt.Color(4294638335L), 0, 0, 0, 0, 0, 0, 0, 0, 0, ColorKt.Color(2566979842L), ColorKt.Color(4294638335L), ColorKt.Color(2149983782L), ColorKt.Color(3439329279L), 0, ColorKt.Color(2583691263L), 0, ColorKt.Color(2583362303L), ColorKt.Color(4278255874L), 0, 0, 0, 0, 0, 0, 0, 533340144, null));

    @NotNull
    private static final ColorProviders monotoneColorProviders = Material3ThemesKt.ColorProviders(m21701createColorProvidersG1PFcw$default(ColorKt.Color(872415231), ColorKt.Color(4294967295L), ColorKt.Color(452984831), ColorKt.Color(4294967295L), 0, 0, 0, 0, 0, 0, 0, 0, 0, ColorKt.Color(16777215), ColorKt.Color(4294967295L), ColorKt.Color(654311423), ColorKt.Color(4294967295L), 0, 0, 0, ColorKt.Color(452984831), ColorKt.Color(4294967295L), 0, 0, 0, 0, 0, 0, 0, 533602288, null));

    @NotNull
    private static final ColorProviders complicationColorProviders = Material3ThemesKt.ColorProviders(m21701createColorProvidersG1PFcw$default(ColorKt.Color(1090519039), ColorKt.Color(4294967295L), 0, 0, 0, 0, ColorKt.Color(3439329279L), 0, 0, 0, ColorKt.Color(3019898879L), 0, 0, ColorKt.Color(1090519039), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 536861628, null));

    @NotNull
    /* JADX INFO: renamed from: createColorProviders-G1PFc-w, reason: not valid java name */
    public static final ColorScheme m21700createColorProvidersG1PFcw(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30) {
        return new ColorScheme(j, j2, j3, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, null);
    }

    /* JADX INFO: renamed from: createColorProviders-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m21701createColorProvidersG1PFcw$default(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, int i, Object obj) {
        long j31 = (i & 1) != 0 ? ColorNotDefined : j;
        long j32 = (i & 2) != 0 ? ColorNotDefined : j2;
        long j33 = (i & 4) != 0 ? ColorNotDefined : j3;
        long j34 = (i & 8) != 0 ? ColorNotDefined : j5;
        long j35 = (i & 16) != 0 ? ColorNotDefined : j6;
        long j36 = (i & 32) != 0 ? ColorNotDefined : j7;
        long j37 = (i & 64) != 0 ? ColorNotDefined : j8;
        long j38 = (i & 128) != 0 ? ColorNotDefined : j9;
        long j39 = j31;
        long j40 = (i & 256) != 0 ? ColorNotDefined : j10;
        long j41 = (i & 512) != 0 ? ColorNotDefined : j11;
        long j42 = (i & 1024) != 0 ? ColorNotDefined : j12;
        long j43 = (i & 2048) != 0 ? ColorNotDefined : j13;
        long j44 = (i & 4096) != 0 ? ColorNotDefined : j14;
        long j45 = (i & 8192) != 0 ? ColorNotDefined : j15;
        long j46 = (i & 16384) != 0 ? ColorNotDefined : j16;
        long j47 = (i & 32768) != 0 ? ColorNotDefined : j17;
        long j48 = (i & 65536) != 0 ? ColorNotDefined : j18;
        long j49 = (i & 131072) != 0 ? ColorNotDefined : j19;
        long j50 = (i & 262144) != 0 ? ColorNotDefined : j20;
        long j51 = (i & 524288) != 0 ? ColorNotDefined : j21;
        long j52 = (i & 1048576) != 0 ? ColorNotDefined : j22;
        long j53 = (i & 2097152) != 0 ? ColorNotDefined : j23;
        long j54 = (i & 4194304) != 0 ? ColorNotDefined : j24;
        long j55 = (i & 8388608) != 0 ? ColorNotDefined : j25;
        long j56 = (i & 16777216) != 0 ? ColorNotDefined : j26;
        long j57 = (i & 33554432) != 0 ? ColorNotDefined : j27;
        long j58 = (i & 67108864) != 0 ? ColorNotDefined : j28;
        long j59 = (i & 134217728) != 0 ? ColorNotDefined : j29;
        if ((i & 268435456) != 0) {
            j30 = ColorNotDefined;
        }
        return m21700createColorProvidersG1PFcw(j39, j32, j33, j34, j35, j36, j37, j38, j40, j41, j42, j43, j44, j45, j46, j47, j48, j49, j50, j51, j52, j53, j54, j55, j56, j57, j58, j59, j30);
    }

    public static final long getColorNotDefined() {
        return ColorNotDefined;
    }

    @NotNull
    public static final ColorProviders getComplicationColorProviders() {
        return complicationColorProviders;
    }

    @NotNull
    public static final ColorProviders getDefaultColorProviders() {
        return defaultColorProviders;
    }

    @NotNull
    public static final ColorProviders getMonotoneColorProviders() {
        return monotoneColorProviders;
    }

    @NotNull
    public static final List<Integer> getMonotoneGraphColorArray() {
        return MonotoneGraphColorArray;
    }

    @Composable
    @NotNull
    public static final ColorProvider mixedByAlpha(@NotNull ColorProvider colorProvider, @NotNull ColorProvider alphaColor, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(colorProvider, "<this>");
        Intrinsics.checkNotNullParameter(alphaColor, "alphaColor");
        composer.startReplaceableGroup(-868017351);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-868017351, i, -1, "androidx.glance.oneui.template.color.mixedByAlpha (ColorProviders.kt:170)");
        }
        Context context = (Context) composer.consume(CompositionLocalsKt.getLocalContext());
        float fM18527getAlphaimpl = Color.m18527getAlphaimpl(alphaColor.mo21422getColorvNxB06k(context));
        long jMo21422getColorvNxB06k = colorProvider.mo21422getColorvNxB06k(context);
        ColorProvider colorProviderM22055ColorProvider8_81llA = ColorProviderKt.m22055ColorProvider8_81llA(Color.m18523copywmQWz5c(jMo21422getColorvNxB06k, fM18527getAlphaimpl, Color.m18531getRedimpl(jMo21422getColorvNxB06k), Color.m18530getGreenimpl(jMo21422getColorvNxB06k), Color.m18528getBlueimpl(jMo21422getColorvNxB06k)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return colorProviderM22055ColorProvider8_81llA;
    }

    @NotNull
    public static final ColorProvider override(@NotNull ColorProvider colorProvider, @Nullable ColorProvider colorProvider2) {
        Intrinsics.checkNotNullParameter(colorProvider, "<this>");
        return colorProvider2 == null ? colorProvider : colorProvider2;
    }

    /* JADX INFO: renamed from: override-THrllMk, reason: not valid java name */
    public static final long m21702overrideTHrllMk(long j, @Nullable Color color) {
        return color != null ? color.m18535unboximpl() : j;
    }
}
