package androidx.compose.p109ui.graphics;

import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.graphics.Outline;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001c\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"RectangleShape", "Landroidx/compose/ui/graphics/Shape;", "getRectangleShape$annotations", "()V", "getRectangleShape", "()Landroidx/compose/ui/graphics/Shape;", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class RectangleShapeKt {

    @NotNull
    private static final Shape RectangleShape = new Shape() { // from class: androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1
        @NotNull
        public String toString() {
            return "RectangleShape";
        }

        @Override // androidx.compose.p109ui.graphics.Shape
        @NotNull
        /* JADX INFO: renamed from: createOutline-Pq9zytI */
        public Outline.Rectangle mo15457createOutlinePq9zytI(long size, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
            return new Outline.Rectangle(SizeKt.m18374toRectuvyYCjk(size));
        }
    };

    @NotNull
    public static final Shape getRectangleShape() {
        return RectangleShape;
    }

    @Stable
    public static /* synthetic */ void getRectangleShape$annotations() {
    }
}
