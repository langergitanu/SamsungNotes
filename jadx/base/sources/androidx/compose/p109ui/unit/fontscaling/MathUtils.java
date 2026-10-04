package androidx.compose.p109ui.unit.fontscaling;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¨\u0006\u0011"}, m13886d2 = {"Landroidx/compose/ui/unit/fontscaling/MathUtils;", "", "()V", "constrainedMap", "", "rangeMin", "rangeMax", "valueMin", "valueMax", "value", "lerp", "start", "stop", "amount", "lerpInv", "a", "b", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class MathUtils {
    public static final int $stable = 0;

    @NotNull
    public static final MathUtils INSTANCE = new MathUtils();

    private MathUtils() {
    }

    public final float constrainedMap(float rangeMin, float rangeMax, float valueMin, float valueMax, float value) {
        return lerp(rangeMin, rangeMax, Math.max(0.0f, Math.min(1.0f, lerpInv(valueMin, valueMax, value))));
    }

    public final float lerp(float start, float stop, float amount) {
        return AbstractC0000a.m29z(stop, start, amount, start);
    }

    public final float lerpInv(float a, float b, float value) {
        if (a == b) {
            return 0.0f;
        }
        return (value - a) / (b - a);
    }
}
