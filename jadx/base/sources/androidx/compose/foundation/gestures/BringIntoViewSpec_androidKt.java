package androidx.compose.foundation.gestures;

import android.content.Context;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\u00020\u0002X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"LocalBringIntoViewSpec", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "getLocalBringIntoViewSpec$annotations", "()V", "getLocalBringIntoViewSpec", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "PivotBringIntoViewSpec", "getPivotBringIntoViewSpec$annotations", "getPivotBringIntoViewSpec", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class BringIntoViewSpec_androidKt {

    @NotNull
    private static final ProvidableCompositionLocal<BringIntoViewSpec> LocalBringIntoViewSpec = CompositionLocalKt.compositionLocalWithComputedDefaultOf(new Function1<CompositionLocalAccessorScope, BringIntoViewSpec>() { // from class: androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt$LocalBringIntoViewSpec$1
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final BringIntoViewSpec invoke(@NotNull CompositionLocalAccessorScope compositionLocalAccessorScope) {
            return !((Context) compositionLocalAccessorScope.getCurrentValue(AndroidCompositionLocals_androidKt.getLocalContext())).getPackageManager().hasSystemFeature("android.software.leanback") ? BringIntoViewSpec.INSTANCE.getDefaultBringIntoViewSpec$foundation_release() : BringIntoViewSpec_androidKt.getPivotBringIntoViewSpec();
        }
    });

    @NotNull
    private static final BringIntoViewSpec PivotBringIntoViewSpec = new BringIntoViewSpec() { // from class: androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt$PivotBringIntoViewSpec$1
        private final float childFraction;
        private final float parentFraction = 0.3f;

        @NotNull
        private final AnimationSpec<Float> scrollAnimationSpec = AnimationSpecKt.tween$default(125, 0, new CubicBezierEasing(0.25f, 0.1f, 0.25f, 1.0f), 2, null);

        @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
        public float calculateScrollDistance(float offset, float size, float containerSize) {
            float fAbs = Math.abs((size + offset) - offset);
            boolean z = fAbs <= containerSize;
            float f = (this.parentFraction * containerSize) - (this.childFraction * fAbs);
            float f4 = containerSize - f;
            if (z && f4 < fAbs) {
                f = containerSize - fAbs;
            }
            return offset - f;
        }

        public final float getChildFraction() {
            return this.childFraction;
        }

        public final float getParentFraction() {
            return this.parentFraction;
        }

        @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
        @NotNull
        public AnimationSpec<Float> getScrollAnimationSpec() {
            return this.scrollAnimationSpec;
        }
    };

    @ExperimentalFoundationApi
    @NotNull
    public static final ProvidableCompositionLocal<BringIntoViewSpec> getLocalBringIntoViewSpec() {
        return LocalBringIntoViewSpec;
    }

    @NotNull
    public static final BringIntoViewSpec getPivotBringIntoViewSpec() {
        return PivotBringIntoViewSpec;
    }

    @ExperimentalFoundationApi
    public static /* synthetic */ void getLocalBringIntoViewSpec$annotations() {
    }

    public static /* synthetic */ void getPivotBringIntoViewSpec$annotations() {
    }
}
