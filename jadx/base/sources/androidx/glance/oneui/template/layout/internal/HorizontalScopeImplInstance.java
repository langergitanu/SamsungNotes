package androidx.glance.oneui.template.layout.internal;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.WeightModifier;
import androidx.glance.layout.WeightValue;
import androidx.glance.layout.WidthModifier;
import androidx.glance.unit.Dimension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/internal/HorizontalScopeImplInstance;", "Landroidx/glance/layout/RowScope;", "()V", "defaultWeight", "Landroidx/glance/GlanceModifier;", "weight", "Landroidx/glance/layout/WeightValue;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class HorizontalScopeImplInstance implements RowScope {
    public static final int $stable = 0;

    @NotNull
    public static final HorizontalScopeImplInstance INSTANCE = new HorizontalScopeImplInstance();

    private HorizontalScopeImplInstance() {
    }

    @Override // androidx.glance.layout.RowScope
    @NotNull
    public GlanceModifier defaultWeight(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new WidthModifier(Dimension.Expand.INSTANCE));
    }

    @NotNull
    public final GlanceModifier weight(@NotNull GlanceModifier glanceModifier, @NotNull WeightValue weight) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(weight, "weight");
        return glanceModifier.then(new WidthModifier(Dimension.Expand.INSTANCE)).then(new WeightModifier(weight));
    }
}
