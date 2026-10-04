package androidx.compose.p109ui.graphics.colorspace;

import androidx.annotation.Size;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import kotlin.Metadata;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006B'\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\r\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\b\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "", "x", "", "y", "z", "(FFF)V", VElementFormulasCmd.FSUM, "(FFFF)V", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "toXyz", "", "toXyz$ui_graphics_release", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class WhitePoint {
    private final float x;
    private final float y;

    public WhitePoint(float f, float f4) {
        this.x = f;
        this.y = f4;
    }

    public static /* synthetic */ WhitePoint copy$default(WhitePoint whitePoint, float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = whitePoint.x;
        }
        if ((i & 2) != 0) {
            f4 = whitePoint.y;
        }
        return whitePoint.copy(f, f4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getY() {
        return this.y;
    }

    @NotNull
    public final WhitePoint copy(float x, float y2) {
        return new WhitePoint(x, y2);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WhitePoint)) {
            return false;
        }
        WhitePoint whitePoint = (WhitePoint) other;
        return Float.compare(this.x, whitePoint.x) == 0 && Float.compare(this.y, whitePoint.y) == 0;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return Float.hashCode(this.y) + (Float.hashCode(this.x) * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("WhitePoint(x=");
        sb.append(this.x);
        sb.append(", y=");
        return AbstractC0622a.m1171q(sb, this.y, PropertyUtils.MAPPED_DELIM2);
    }

    @Size(3)
    @NotNull
    public final float[] toXyz$ui_graphics_release() {
        float f = this.x;
        float f4 = this.y;
        return new float[]{f / f4, 1.0f, ((1.0f - f) - f4) / f4};
    }

    public WhitePoint(float f, float f4, float f5) {
        this(f, f4, f5, f + f4 + f5);
    }

    private WhitePoint(float f, float f4, float f5, float f6) {
        this(f / f6, f4 / f6);
    }
}
