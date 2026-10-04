package androidx.compose.p109ui.layout;

import androidx.compose.p109ui.unit.Density;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@MeasureScopeMarker
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH¦\u0004J\u0015\u0010\u000b\u001a\u00020\u0007*\u00020\f2\u0006\u0010\t\u001a\u00020\nH¦\u0004R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/layout/RulerScope;", "Landroidx/compose/ui/unit/Density;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "provides", "", "Landroidx/compose/ui/layout/Ruler;", "value", "", "providesRelative", "Landroidx/compose/ui/layout/VerticalRuler;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface RulerScope extends Density {
    @NotNull
    LayoutCoordinates getCoordinates();

    void provides(@NotNull Ruler ruler, float f);

    void providesRelative(@NotNull VerticalRuler verticalRuler, float f);
}
