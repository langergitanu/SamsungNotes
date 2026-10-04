package androidx.compose.foundation.layout;

import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ReadOnlyComposable;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a8\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\t\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\u001a\f\u0010\f\u001a\u00020\u0001*\u00020\rH\u0000\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000f\u001a\u0012\u0010\u000e\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, m13886d2 = {"WindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "WindowInsets-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/WindowInsets;", "", "add", "insets", "asInsets", "Landroidx/compose/foundation/layout/PaddingValues;", "asPaddingValues", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/PaddingValues;", "density", "Landroidx/compose/ui/unit/Density;", "exclude", "only", "sides", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "only-bOOhFvg", "(Landroidx/compose/foundation/layout/WindowInsets;I)Landroidx/compose/foundation/layout/WindowInsets;", XmlErrorCodes.UNION, "foundation-layout_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWindowInsets.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WindowInsets.kt\nandroidx/compose/foundation/layout/WindowInsetsKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,748:1\n77#2:749\n149#3:750\n149#3:751\n149#3:752\n149#3:753\n*S KotlinDebug\n*F\n+ 1 WindowInsets.kt\nandroidx/compose/foundation/layout/WindowInsetsKt\n*L\n245#1:749\n278#1:750\n279#1:751\n280#1:752\n281#1:753\n*E\n"})
public final class WindowInsetsKt {
    @NotNull
    public static final WindowInsets WindowInsets(int i, int i2, int i4, int i5) {
        return new FixedIntInsets(i, i2, i4, i5);
    }

    public static /* synthetic */ WindowInsets WindowInsets$default(int i, int i2, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = 0;
        }
        if ((i6 & 2) != 0) {
            i2 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return WindowInsets(i, i2, i4, i5);
    }

    @NotNull
    /* JADX INFO: renamed from: WindowInsets-a9UjIt4, reason: not valid java name */
    public static final WindowInsets m15923WindowInsetsa9UjIt4(float f, float f4, float f5, float f6) {
        return new FixedDpInsets(f, f4, f5, f6, null);
    }

    /* JADX INFO: renamed from: WindowInsets-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ WindowInsets m15924WindowInsetsa9UjIt4$default(float f, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f5 = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f6 = C2256Dp.m20968constructorimpl(0);
        }
        return m15923WindowInsetsa9UjIt4(f, f4, f5, f6);
    }

    @NotNull
    public static final WindowInsets add(@NotNull WindowInsets windowInsets, @NotNull WindowInsets windowInsets2) {
        return new AddedInsets(windowInsets, windowInsets2);
    }

    @NotNull
    public static final WindowInsets asInsets(@NotNull PaddingValues paddingValues) {
        return new PaddingValuesInsets(paddingValues);
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public static final PaddingValues asPaddingValues(@NotNull WindowInsets windowInsets, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1485016250, i, -1, "androidx.compose.foundation.layout.asPaddingValues (WindowInsets.kt:244)");
        }
        InsetsPaddingValues insetsPaddingValues = new InsetsPaddingValues(windowInsets, (Density) composer.consume(CompositionLocalsKt.getLocalDensity()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return insetsPaddingValues;
    }

    @NotNull
    public static final WindowInsets exclude(@NotNull WindowInsets windowInsets, @NotNull WindowInsets windowInsets2) {
        return new ExcludeInsets(windowInsets, windowInsets2);
    }

    @NotNull
    /* JADX INFO: renamed from: only-bOOhFvg, reason: not valid java name */
    public static final WindowInsets m15925onlybOOhFvg(@NotNull WindowInsets windowInsets, int i) {
        return new LimitInsets(windowInsets, i, null);
    }

    @NotNull
    public static final WindowInsets union(@NotNull WindowInsets windowInsets, @NotNull WindowInsets windowInsets2) {
        return new UnionInsets(windowInsets, windowInsets2);
    }

    @NotNull
    public static final PaddingValues asPaddingValues(@NotNull WindowInsets windowInsets, @NotNull Density density) {
        return new InsetsPaddingValues(windowInsets, density);
    }
}
