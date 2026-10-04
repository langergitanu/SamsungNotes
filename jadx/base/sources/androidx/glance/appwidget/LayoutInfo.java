package androidx.glance.appwidget;

import androidx.annotation.LayoutRes;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m13886d2 = {"Landroidx/glance/appwidget/LayoutInfo;", "", "layoutId", "", "(I)V", "getLayoutId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class LayoutInfo {
    public static final int $stable = 0;
    private final int layoutId;

    public LayoutInfo(@LayoutRes int i) {
        this.layoutId = i;
    }

    public static /* synthetic */ LayoutInfo copy$default(LayoutInfo layoutInfo, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = layoutInfo.layoutId;
        }
        return layoutInfo.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLayoutId() {
        return this.layoutId;
    }

    @NotNull
    public final LayoutInfo copy(@LayoutRes int layoutId) {
        return new LayoutInfo(layoutId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LayoutInfo) && this.layoutId == ((LayoutInfo) other).layoutId;
    }

    public final int getLayoutId() {
        return this.layoutId;
    }

    public int hashCode() {
        return Integer.hashCode(this.layoutId);
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m767i(this.layoutId, "LayoutInfo(layoutId=", ")");
    }
}
