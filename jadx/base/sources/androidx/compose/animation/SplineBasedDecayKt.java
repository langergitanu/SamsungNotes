package androidx.compose.animation;

import androidx.collection.AbstractC0622a;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.p109ui.unit.Density;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"EndTension", "", "Inflection", "P1", "P2", "StartTension", "computeSplineInfo", "", "splinePositions", "", "splineTimes", "nbSamples", "", "splineBasedDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "T", "density", "Landroidx/compose/ui/unit/Density;", "animation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SplineBasedDecayKt {
    private static final float EndTension = 1.0f;
    private static final float Inflection = 0.35f;

    /* JADX INFO: renamed from: P1 */
    private static final float f983P1 = 0.175f;

    /* JADX INFO: renamed from: P2 */
    private static final float f984P2 = 0.35000002f;
    private static final float StartTension = 0.5f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void computeSplineInfo(float[] fArr, float[] fArr2, int i) {
        float fM1155a;
        float f;
        float f4;
        float f5;
        float f6;
        float fM1155a2;
        float f7;
        float f8;
        float f9;
        float f10 = 0.0f;
        int i2 = 0;
        float f11 = 0.0f;
        while (true) {
            float f12 = 1.0f;
            if (i2 >= i) {
                fArr2[i] = 1.0f;
                fArr[i] = 1.0f;
                return;
            }
            float f13 = i2 / i;
            float f14 = 1.0f;
            while (true) {
                fM1155a = AbstractC0622a.m1155a(f14, f10, 2.0f, f10);
                f = f12 - fM1155a;
                f4 = fM1155a * 3.0f * f;
                f5 = fM1155a * fM1155a * fM1155a;
                float fM1152B = AbstractC0622a.m1152B(fM1155a, f984P2, f * f983P1, f4) + f5;
                f6 = f12;
                if (Math.abs(fM1152B - f13) < 1.0E-5d) {
                    break;
                }
                if (fM1152B > f13) {
                    f14 = fM1155a;
                } else {
                    f10 = fM1155a;
                }
                f12 = f6;
            }
            float f15 = 0.5f;
            fArr[i2] = (((f * 0.5f) + fM1155a) * f4) + f5;
            float f16 = f6;
            while (true) {
                fM1155a2 = AbstractC0622a.m1155a(f16, f11, 2.0f, f11);
                f7 = f6 - fM1155a2;
                f8 = fM1155a2 * 3.0f * f7;
                f9 = fM1155a2 * fM1155a2 * fM1155a2;
                float fM1152B2 = AbstractC0622a.m1152B(f7, f15, fM1155a2, f8) + f9;
                float f17 = f13;
                if (Math.abs(fM1152B2 - f13) >= 1.0E-5d) {
                    if (fM1152B2 > f17) {
                        f16 = fM1155a2;
                    } else {
                        f11 = fM1155a2;
                    }
                    f13 = f17;
                    f15 = 0.5f;
                }
            }
            fArr2[i2] = (((fM1155a2 * f984P2) + (f7 * f983P1)) * f8) + f9;
            i2++;
        }
    }

    @NotNull
    public static final <T> DecayAnimationSpec<T> splineBasedDecay(@NotNull Density density) {
        return DecayAnimationSpecKt.generateDecayAnimationSpec(new SplineBasedFloatDecayAnimationSpec(density));
    }
}
