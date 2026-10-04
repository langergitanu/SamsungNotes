package androidx.glance.layout;

import androidx.glance.GlanceModifier;
import androidx.glance.unit.Dimension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0004H\u0016¨\u0006\u0005"}, m13886d2 = {"Landroidx/glance/layout/RowScopeImplInstance;", "Landroidx/glance/layout/RowScope;", "()V", "defaultWeight", "Landroidx/glance/GlanceModifier;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
final class RowScopeImplInstance implements RowScope {

    @NotNull
    public static final RowScopeImplInstance INSTANCE = new RowScopeImplInstance();

    private RowScopeImplInstance() {
    }

    @Override // androidx.glance.layout.RowScope
    @NotNull
    public GlanceModifier defaultWeight(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new WidthModifier(Dimension.Expand.INSTANCE));
    }
}
