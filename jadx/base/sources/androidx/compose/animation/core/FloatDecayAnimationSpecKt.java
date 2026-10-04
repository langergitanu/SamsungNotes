package androidx.compose.animation.core;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"ExponentialDecayFriction", "", "createAnimation", "Landroidx/compose/animation/core/Animation;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "startValue", "startVelocity", "animation-core_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FloatDecayAnimationSpecKt {
    private static final float ExponentialDecayFriction = -4.2f;

    @NotNull
    public static final Animation<Float, AnimationVector1D> createAnimation(@NotNull FloatDecayAnimationSpec floatDecayAnimationSpec, float f, float f4) {
        return AnimationKt.DecayAnimation(floatDecayAnimationSpec, f, f4);
    }

    public static /* synthetic */ Animation createAnimation$default(FloatDecayAnimationSpec floatDecayAnimationSpec, float f, float f4, int i, Object obj) {
        if ((i & 2) != 0) {
            f4 = 0.0f;
        }
        return createAnimation(floatDecayAnimationSpec, f, f4);
    }
}
