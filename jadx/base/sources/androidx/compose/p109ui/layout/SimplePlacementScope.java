package androidx.compose.p109ui.layout;

import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.LayoutDirection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Landroidx/compose/ui/layout/SimplePlacementScope;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "parentWidth", "", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(ILandroidx/compose/ui/unit/LayoutDirection;)V", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getParentWidth", "()I", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class SimplePlacementScope extends Placeable.PlacementScope {

    @NotNull
    private final LayoutDirection parentLayoutDirection;
    private final int parentWidth;

    public SimplePlacementScope(int i, @NotNull LayoutDirection layoutDirection) {
        this.parentWidth = i;
        this.parentLayoutDirection = layoutDirection;
    }

    @Override // androidx.compose.ui.layout.Placeable.PlacementScope
    @NotNull
    public LayoutDirection getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    @Override // androidx.compose.ui.layout.Placeable.PlacementScope
    public int getParentWidth() {
        return this.parentWidth;
    }
}
