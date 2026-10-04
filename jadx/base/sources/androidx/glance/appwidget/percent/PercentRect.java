package androidx.glance.appwidget.percent;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, m13886d2 = {"Landroidx/glance/appwidget/percent/PercentRect;", "", "left", "", "top", "right", "bottom", "(FFFF)V", "getBottom", "()F", "getLeft", "getRight", "getTop", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class PercentRect {
    public static final int $stable = 0;
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public PercentRect(@PercentRange float f, @PercentRange float f4, @PercentRange float f5, @PercentRange float f6) {
        this.left = f;
        this.top = f4;
        this.right = f5;
        this.bottom = f6;
    }

    public static /* synthetic */ PercentRect copy$default(PercentRect percentRect, float f, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = percentRect.left;
        }
        if ((i & 2) != 0) {
            f4 = percentRect.top;
        }
        if ((i & 4) != 0) {
            f5 = percentRect.right;
        }
        if ((i & 8) != 0) {
            f6 = percentRect.bottom;
        }
        return percentRect.copy(f, f4, f5, f6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getRight() {
        return this.right;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getBottom() {
        return this.bottom;
    }

    @NotNull
    public final PercentRect copy(@PercentRange float left, @PercentRange float top, @PercentRange float right, @PercentRange float bottom) {
        return new PercentRect(left, top, right, bottom);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PercentRect)) {
            return false;
        }
        PercentRect percentRect = (PercentRect) other;
        return Float.compare(this.left, percentRect.left) == 0 && Float.compare(this.top, percentRect.top) == 0 && Float.compare(this.right, percentRect.right) == 0 && Float.compare(this.bottom, percentRect.bottom) == 0;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    public int hashCode() {
        return Float.hashCode(this.bottom) + AbstractC0622a.m1156b(this.right, AbstractC0622a.m1156b(this.top, Float.hashCode(this.left) * 31, 31), 31);
    }

    @NotNull
    public String toString() {
        float f = this.left;
        float f4 = this.top;
        return AbstractC1038a.m1216q(AbstractC0622a.m1176v("PercentRect(left=", f, ", top=", f4, ", right="), this.right, ", bottom=", this.bottom, ")");
    }
}
