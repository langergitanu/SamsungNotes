package androidx.glance.layout;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/layout/WeightModifier;", "Landroidx/glance/GlanceModifier$Element;", "weight", "Landroidx/glance/layout/WeightValue;", "(Landroidx/glance/layout/WeightValue;)V", "getWeight", "()Landroidx/glance/layout/WeightValue;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class WeightModifier implements GlanceModifier.Element {
    public static final int $stable = 0;

    @NotNull
    private final WeightValue weight;

    public WeightModifier(@NotNull WeightValue weight) {
        Intrinsics.checkNotNullParameter(weight, "weight");
        this.weight = weight;
    }

    @NotNull
    public final WeightValue getWeight() {
        return this.weight;
    }
}
