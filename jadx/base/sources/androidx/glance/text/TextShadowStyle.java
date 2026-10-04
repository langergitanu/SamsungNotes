package androidx.glance.text;

import androidx.annotation.FloatRange;
import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/text/TextShadowStyle;", "", "radius", "", "dx", "dy", "color", "Landroidx/compose/ui/graphics/Color;", "(FFFJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getDx", "()F", "getDy", "getRadius", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TextShadowStyle {
    public static final int $stable = 0;
    private final long color;
    private final float dx;
    private final float dy;
    private final float radius;

    public /* synthetic */ TextShadowStyle(@FloatRange(from = 0.0d, m705to = 1.0d) float f, float f4, float f5, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, f5, j);
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getColor() {
        return this.color;
    }

    public final float getDx() {
        return this.dx;
    }

    public final float getDy() {
        return this.dy;
    }

    public final float getRadius() {
        return this.radius;
    }

    @NotNull
    public String toString() {
        float f = this.radius;
        float f4 = this.dx;
        float f5 = this.dy;
        String strM18533toStringimpl = Color.m18533toStringimpl(this.color);
        StringBuilder sbM1176v = AbstractC0622a.m1176v("TextShadowStyle(radius=", f, ", dx=", f4, ", dy=");
        sbM1176v.append(f5);
        sbM1176v.append(", color=");
        sbM1176v.append(strM18533toStringimpl);
        sbM1176v.append(")");
        return sbM1176v.toString();
    }

    private TextShadowStyle(float f, float f4, float f5, long j) {
        this.radius = f;
        this.dx = f4;
        this.dy = f5;
        this.color = j;
    }

    public /* synthetic */ TextShadowStyle(float f, float f4, float f5, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.5f : f, (i & 2) != 0 ? 0.0f : f4, (i & 4) != 0 ? 0.5f : f5, (i & 8) != 0 ? Color.INSTANCE.m18551getBlack0d7_KjU() : j, null);
    }
}
