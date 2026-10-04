package androidx.compose.foundation;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.semantics.SemanticsPropertyKey;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001\u001a\u0014\u0010\n\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001a\u0094\u0001\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0002\b\u00122\u001b\b\u0002\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010¢\u0006\u0002\b\u00122\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a¬\u0001\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0002\b\u00122\u001b\b\u0002\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010¢\u0006\u0002\b\u00122\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0000ø\u0001\u0000¢\u0006\u0004\b#\u0010$\" \u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006%"}, m13886d2 = {"MagnifierPositionInRoot", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Offset;", "getMagnifierPositionInRoot", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "isPlatformMagnifierSupported", "", "sdkVersion", "", "equalsIncludingNaN", "", "other", "magnifier", "Landroidx/compose/ui/Modifier;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clip", "magnifier-UpNRX3w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FJFFZ)Landroidx/compose/ui/Modifier;", "useTextDefault", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "magnifier-jPUL71Q", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;)Landroidx/compose/ui/Modifier;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class Magnifier_androidKt {

    @NotNull
    private static final SemanticsPropertyKey<Function0<Offset>> MagnifierPositionInRoot = new SemanticsPropertyKey<>("MagnifierPositionInRoot", null, 2, null);

    public static final boolean equalsIncludingNaN(float f, float f4) {
        return (Float.isNaN(f) && Float.isNaN(f4)) || f == f4;
    }

    @NotNull
    public static final SemanticsPropertyKey<Function0<Offset>> getMagnifierPositionInRoot() {
        return MagnifierPositionInRoot;
    }

    @ChecksSdkIntAtLeast(api = 28)
    public static final boolean isPlatformMagnifierSupported(int i) {
        return i >= 28;
    }

    public static /* synthetic */ boolean isPlatformMagnifierSupported$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return isPlatformMagnifierSupported(i);
    }

    @NotNull
    /* JADX INFO: renamed from: magnifier-UpNRX3w, reason: not valid java name */
    public static final Modifier m15476magnifierUpNRX3w(@NotNull Modifier modifier, @NotNull Function1<? super Density, Offset> function1, @Nullable Function1<? super Density, Offset> function12, @Nullable Function1<? super DpSize, Unit> function13, float f, long j, float f4, float f5, boolean z) {
        return m15479magnifierjPUL71Q$default(modifier, function1, function12, function13, f, false, j, f4, f5, z, null, 512, null);
    }

    /* JADX INFO: renamed from: magnifier-UpNRX3w$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15477magnifierUpNRX3w$default(Modifier modifier, Function1 function1, Function1 function12, Function1 function13, float f, long j, float f4, float f5, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            function12 = null;
        }
        if ((i & 4) != 0) {
            function13 = null;
        }
        if ((i & 8) != 0) {
            f = Float.NaN;
        }
        if ((i & 16) != 0) {
            j = DpSize.INSTANCE.m21075getUnspecifiedMYxV2XQ();
        }
        if ((i & 32) != 0) {
            f4 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 64) != 0) {
            f5 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 128) != 0) {
            z = true;
        }
        return m15476magnifierUpNRX3w(modifier, function1, function12, function13, f, j, f4, f5, z);
    }

    @NotNull
    /* JADX INFO: renamed from: magnifier-jPUL71Q, reason: not valid java name */
    public static final Modifier m15478magnifierjPUL71Q(@NotNull Modifier modifier, @NotNull Function1<? super Density, Offset> function1, @Nullable Function1<? super Density, Offset> function12, @Nullable Function1<? super DpSize, Unit> function13, float f, boolean z, long j, float f4, float f5, boolean z2, @Nullable PlatformMagnifierFactory platformMagnifierFactory) {
        if (isPlatformMagnifierSupported$default(0, 1, null)) {
            return modifier.then(new MagnifierElement(function1, function12, function13, f, z, j, f4, f5, z2, platformMagnifierFactory == null ? PlatformMagnifierFactory.INSTANCE.getForCurrentPlatform() : platformMagnifierFactory, null));
        }
        return modifier;
    }

    /* JADX INFO: renamed from: magnifier-jPUL71Q$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15479magnifierjPUL71Q$default(Modifier modifier, Function1 function1, Function1 function12, Function1 function13, float f, boolean z, long j, float f4, float f5, boolean z2, PlatformMagnifierFactory platformMagnifierFactory, int i, Object obj) {
        if ((i & 2) != 0) {
            function12 = null;
        }
        if ((i & 4) != 0) {
            function13 = null;
        }
        if ((i & 8) != 0) {
            f = Float.NaN;
        }
        if ((i & 16) != 0) {
            z = false;
        }
        if ((i & 32) != 0) {
            j = DpSize.INSTANCE.m21075getUnspecifiedMYxV2XQ();
        }
        if ((i & 64) != 0) {
            f4 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 128) != 0) {
            f5 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 256) != 0) {
            z2 = true;
        }
        if ((i & 512) != 0) {
            platformMagnifierFactory = null;
        }
        return m15478magnifierjPUL71Q(modifier, function1, function12, function13, f, z, j, f4, f5, z2, platformMagnifierFactory);
    }
}
