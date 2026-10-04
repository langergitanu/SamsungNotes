package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001aA\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"unsupportedDirection", "", "lazyLayoutBeyondBoundsModifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "reverseLayout", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;ZLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyLayoutBeyondBoundsModifierLocal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyLayoutBeyondBoundsModifierLocal.kt\nandroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocalKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,176:1\n1225#2,6:177\n*S KotlinDebug\n*F\n+ 1 LazyLayoutBeyondBoundsModifierLocal.kt\nandroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocalKt\n*L\n55#1:177,6\n*E\n"})
public final class LazyLayoutBeyondBoundsModifierLocalKt {
    @Composable
    @NotNull
    public static final Modifier lazyLayoutBeyondBoundsModifier(@NotNull Modifier modifier, @NotNull LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsState, @NotNull LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo, boolean z, @NotNull LayoutDirection layoutDirection, @NotNull Orientation orientation, boolean z2, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1331498025, i, -1, "androidx.compose.foundation.lazy.layout.lazyLayoutBeyondBoundsModifier (LazyLayoutBeyondBoundsModifierLocal.kt:51)");
        }
        if (z2) {
            composer.startReplaceGroup(-1890632411);
            boolean z3 = ((((i & 112) ^ 48) > 32 && composer.changed(lazyLayoutBeyondBoundsState)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(lazyLayoutBeyondBoundsInfo)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(z)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) > 16384 && composer.changed(layoutDirection)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) > 131072 && composer.changed(orientation)) || (i & 196608) == 131072);
            Object objRememberedValue = composer.rememberedValue();
            if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                LazyLayoutBeyondBoundsModifierLocal lazyLayoutBeyondBoundsModifierLocal = new LazyLayoutBeyondBoundsModifierLocal(lazyLayoutBeyondBoundsState, lazyLayoutBeyondBoundsInfo, z, layoutDirection, orientation);
                composer.updateRememberedValue(lazyLayoutBeyondBoundsModifierLocal);
                objRememberedValue = lazyLayoutBeyondBoundsModifierLocal;
            }
            modifier = modifier.then((LazyLayoutBeyondBoundsModifierLocal) objRememberedValue);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1890658823);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void unsupportedDirection() {
        throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction");
    }
}
