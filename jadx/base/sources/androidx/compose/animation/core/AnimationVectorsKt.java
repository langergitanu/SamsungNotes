package androidx.compose.animation.core;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a&\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003\u001a\u001b\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0000¢\u0006\u0002\u0010\r\u001a#\u0010\u000e\u001a\u00020\u000f\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000b2\u0006\u0010\u0010\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\u0011\u001a\u001b\u0010\u0012\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0000¢\u0006\u0002\u0010\r¨\u0006\u0013"}, m13886d2 = {"AnimationVector", "Landroidx/compose/animation/core/AnimationVector1D;", "v1", "", "Landroidx/compose/animation/core/AnimationVector2D;", AuthenticationConstants.Broker.BROKER_PROTOCOL_VERSION, "Landroidx/compose/animation/core/AnimationVector3D;", NetworkConfig.API_VERSION, "Landroidx/compose/animation/core/AnimationVector4D;", "v4", "copy", "T", "Landroidx/compose/animation/core/AnimationVector;", "(Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "copyFrom", "", "source", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "newInstance", "animation-core_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AnimationVectorsKt {
    @NotNull
    public static final AnimationVector1D AnimationVector(float f) {
        return new AnimationVector1D(f);
    }

    @NotNull
    public static final <T extends AnimationVector> T copy(@NotNull T t) {
        T t2 = (T) newInstance(t);
        int size = t2.getSize();
        for (int i = 0; i < size; i++) {
            t2.set$animation_core_release(i, t.get$animation_core_release(i));
        }
        return t2;
    }

    public static final <T extends AnimationVector> void copyFrom(@NotNull T t, @NotNull T t2) {
        int size = t.getSize();
        for (int i = 0; i < size; i++) {
            t.set$animation_core_release(i, t2.get$animation_core_release(i));
        }
    }

    @NotNull
    public static final <T extends AnimationVector> T newInstance(@NotNull T t) {
        T t2 = (T) t.newVector$animation_core_release();
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of androidx.compose.animation.core.AnimationVectorsKt.newInstance");
        return t2;
    }

    @NotNull
    public static final AnimationVector2D AnimationVector(float f, float f4) {
        return new AnimationVector2D(f, f4);
    }

    @NotNull
    public static final AnimationVector3D AnimationVector(float f, float f4, float f5) {
        return new AnimationVector3D(f, f4, f5);
    }

    @NotNull
    public static final AnimationVector4D AnimationVector(float f, float f4, float f5, float f6) {
        return new AnimationVector4D(f, f4, f5, f6);
    }
}
