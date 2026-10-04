package androidx.glance.oneui.common.appwidgetsize;

import androidx.collection.AbstractC0622a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Landroidx/glance/oneui/common/appwidgetsize/SpanSize;", "", "col", "", "row", "(II)V", "getCol", "()I", "getRow", "compareTo", "other", "component1", "component2", "copy", "equals", "", "", "hashCode", "toString", "", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class SpanSize implements Comparable<SpanSize> {
    private final int col;
    private final int row;

    public SpanSize(int i, int i2) {
        this.col = i;
        this.row = i2;
    }

    public static /* synthetic */ SpanSize copy$default(SpanSize spanSize, int i, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = spanSize.col;
        }
        if ((i4 & 2) != 0) {
            i2 = spanSize.row;
        }
        return spanSize.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCol() {
        return this.col;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRow() {
        return this.row;
    }

    @NotNull
    public final SpanSize copy(int col, int row) {
        return new SpanSize(col, row);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpanSize)) {
            return false;
        }
        SpanSize spanSize = (SpanSize) other;
        return this.col == spanSize.col && this.row == spanSize.row;
    }

    public final int getCol() {
        return this.col;
    }

    public final int getRow() {
        return this.row;
    }

    public int hashCode() {
        return Integer.hashCode(this.row) + (Integer.hashCode(this.col) * 31);
    }

    @NotNull
    public String toString() {
        return AbstractC0622a.m1164j(this.col, this.row, "SpanSize(col=", ", row=", ")");
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull SpanSize other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i = this.row;
        int i2 = other.row;
        if (i > i2) {
            return 1;
        }
        if (i < i2) {
            return -1;
        }
        int i4 = this.col;
        int i5 = other.col;
        if (i4 > i5) {
            return 1;
        }
        return i4 < i5 ? -1 : 0;
    }
}
