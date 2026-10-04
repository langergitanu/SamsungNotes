package androidx.compose.material;

import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ReadOnlyComposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u008b\u0001\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u008b\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001b\u001a\u001f\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0014\u0010 \u001a\u00020!*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m13886d2 = {"LocalColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/Colors;", "getLocalColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "primarySurface", "Landroidx/compose/ui/graphics/Color;", "getPrimarySurface", "(Landroidx/compose/material/Colors;)J", "contentColorFor", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColors", "primary", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "darkColors-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material/Colors;", "lightColors", "lightColors-2qZNXz8", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material/Colors;J)J", "updateColorsFrom", "", "other", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ColorsKt {

    @NotNull
    private static final ProvidableCompositionLocal<Colors> LocalColors = CompositionLocalKt.staticCompositionLocalOf(new Function0<Colors>() { // from class: androidx.compose.material.ColorsKt$LocalColors$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Colors invoke() {
            return ColorsKt.m16698lightColors2qZNXz8$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 4095, null);
        }
    });

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m16693contentColorFor4WTKRHQ(@NotNull Colors contentColorFor, long j) {
        Intrinsics.checkNotNullParameter(contentColorFor, "$this$contentColorFor");
        return Color.m18526equalsimpl0(j, contentColorFor.m16676getPrimary0d7_KjU()) ? contentColorFor.m16673getOnPrimary0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m16677getPrimaryVariant0d7_KjU()) ? contentColorFor.m16673getOnPrimary0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m16678getSecondary0d7_KjU()) ? contentColorFor.m16674getOnSecondary0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m16679getSecondaryVariant0d7_KjU()) ? contentColorFor.m16674getOnSecondary0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m16669getBackground0d7_KjU()) ? contentColorFor.m16671getOnBackground0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m16680getSurface0d7_KjU()) ? contentColorFor.m16675getOnSurface0d7_KjU() : Color.m18526equalsimpl0(j, contentColorFor.m16670getError0d7_KjU()) ? contentColorFor.m16672getOnError0d7_KjU() : Color.INSTANCE.m18561getUnspecified0d7_KjU();
    }

    @Composable
    @ReadOnlyComposable
    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m16694contentColorForek8zF_U(long j, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441849991, i, -1, "androidx.compose.material.contentColorFor (Colors.kt:295)");
        }
        long jM16693contentColorFor4WTKRHQ = m16693contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColors(composer, 6), j);
        if (jM16693contentColorFor4WTKRHQ == Color.INSTANCE.m18561getUnspecified0d7_KjU()) {
            jM16693contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return jM16693contentColorFor4WTKRHQ;
    }

    @NotNull
    /* JADX INFO: renamed from: darkColors-2qZNXz8, reason: not valid java name */
    public static final Colors m16695darkColors2qZNXz8(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13) {
        return new Colors(j, j2, j3, j5, j6, j7, j8, j9, j10, j11, j12, j13, false, null);
    }

    /* JADX INFO: renamed from: darkColors-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ Colors m16696darkColors2qZNXz8$default(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, int i, Object obj) {
        long jColor = (i & 1) != 0 ? ColorKt.Color(4290479868L) : j;
        long jColor2 = (i & 2) != 0 ? ColorKt.Color(4281794739L) : j2;
        long jColor3 = (i & 4) != 0 ? ColorKt.Color(4278442694L) : j3;
        long j14 = (i & 8) != 0 ? jColor3 : j5;
        long jColor4 = (i & 16) != 0 ? ColorKt.Color(4279374354L) : j6;
        long jColor5 = (i & 32) != 0 ? ColorKt.Color(4279374354L) : j7;
        long jColor6 = (i & 64) != 0 ? ColorKt.Color(4291782265L) : j8;
        long jM18551getBlack0d7_KjU = (i & 128) != 0 ? Color.INSTANCE.m18551getBlack0d7_KjU() : j9;
        long jM18551getBlack0d7_KjU2 = (i & 256) != 0 ? Color.INSTANCE.m18551getBlack0d7_KjU() : j10;
        long jM18562getWhite0d7_KjU = (i & 512) != 0 ? Color.INSTANCE.m18562getWhite0d7_KjU() : j11;
        long jM18562getWhite0d7_KjU2 = (i & 1024) != 0 ? Color.INSTANCE.m18562getWhite0d7_KjU() : j12;
        if ((i & 2048) != 0) {
            j13 = Color.INSTANCE.m18551getBlack0d7_KjU();
        }
        return m16695darkColors2qZNXz8(jColor, jColor2, jColor3, j14, jColor4, jColor5, jColor6, jM18551getBlack0d7_KjU, jM18551getBlack0d7_KjU2, jM18562getWhite0d7_KjU, jM18562getWhite0d7_KjU2, j13);
    }

    @NotNull
    public static final ProvidableCompositionLocal<Colors> getLocalColors() {
        return LocalColors;
    }

    public static final long getPrimarySurface(@NotNull Colors colors) {
        Intrinsics.checkNotNullParameter(colors, "<this>");
        return colors.isLight() ? colors.m16676getPrimary0d7_KjU() : colors.m16680getSurface0d7_KjU();
    }

    @NotNull
    /* JADX INFO: renamed from: lightColors-2qZNXz8, reason: not valid java name */
    public static final Colors m16697lightColors2qZNXz8(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13) {
        return new Colors(j, j2, j3, j5, j6, j7, j8, j9, j10, j11, j12, j13, true, null);
    }

    /* JADX INFO: renamed from: lightColors-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ Colors m16698lightColors2qZNXz8$default(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, int i, Object obj) {
        long jColor = (i & 1) != 0 ? ColorKt.Color(4284612846L) : j;
        long jColor2 = (i & 2) != 0 ? ColorKt.Color(4281794739L) : j2;
        long jColor3 = (i & 4) != 0 ? ColorKt.Color(4278442694L) : j3;
        long jColor4 = (i & 8) != 0 ? ColorKt.Color(4278290310L) : j5;
        long jM18562getWhite0d7_KjU = (i & 16) != 0 ? Color.INSTANCE.m18562getWhite0d7_KjU() : j6;
        long jM18562getWhite0d7_KjU2 = (i & 32) != 0 ? Color.INSTANCE.m18562getWhite0d7_KjU() : j7;
        long jColor5 = (i & 64) != 0 ? ColorKt.Color(4289724448L) : j8;
        long jM18562getWhite0d7_KjU3 = (i & 128) != 0 ? Color.INSTANCE.m18562getWhite0d7_KjU() : j9;
        long j14 = jColor;
        long jM18551getBlack0d7_KjU = (i & 256) != 0 ? Color.INSTANCE.m18551getBlack0d7_KjU() : j10;
        long jM18551getBlack0d7_KjU2 = (i & 512) != 0 ? Color.INSTANCE.m18551getBlack0d7_KjU() : j11;
        long jM18551getBlack0d7_KjU3 = (i & 1024) != 0 ? Color.INSTANCE.m18551getBlack0d7_KjU() : j12;
        if ((i & 2048) != 0) {
            j13 = Color.INSTANCE.m18562getWhite0d7_KjU();
        }
        return m16697lightColors2qZNXz8(j14, jColor2, jColor3, jColor4, jM18562getWhite0d7_KjU, jM18562getWhite0d7_KjU2, jColor5, jM18562getWhite0d7_KjU3, jM18551getBlack0d7_KjU, jM18551getBlack0d7_KjU2, jM18551getBlack0d7_KjU3, j13);
    }

    public static final void updateColorsFrom(@NotNull Colors colors, @NotNull Colors other) {
        Intrinsics.checkNotNullParameter(colors, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        colors.m16688setPrimary8_81llA$material_release(other.m16676getPrimary0d7_KjU());
        colors.m16689setPrimaryVariant8_81llA$material_release(other.m16677getPrimaryVariant0d7_KjU());
        colors.m16690setSecondary8_81llA$material_release(other.m16678getSecondary0d7_KjU());
        colors.m16691setSecondaryVariant8_81llA$material_release(other.m16679getSecondaryVariant0d7_KjU());
        colors.m16681setBackground8_81llA$material_release(other.m16669getBackground0d7_KjU());
        colors.m16692setSurface8_81llA$material_release(other.m16680getSurface0d7_KjU());
        colors.m16682setError8_81llA$material_release(other.m16670getError0d7_KjU());
        colors.m16685setOnPrimary8_81llA$material_release(other.m16673getOnPrimary0d7_KjU());
        colors.m16686setOnSecondary8_81llA$material_release(other.m16674getOnSecondary0d7_KjU());
        colors.m16683setOnBackground8_81llA$material_release(other.m16671getOnBackground0d7_KjU());
        colors.m16687setOnSurface8_81llA$material_release(other.m16675getOnSurface0d7_KjU());
        colors.m16684setOnError8_81llA$material_release(other.m16672getOnError0d7_KjU());
        colors.setLight$material_release(other.isLight());
    }
}
