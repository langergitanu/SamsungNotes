package androidx.glance.oneui.common;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m13886d2 = {"Landroidx/glance/oneui/common/GridSpanInfo;", "", "w", "", "h", "(II)V", "getH", "()I", "getW", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class GridSpanInfo {
    private final int h;
    private final int w;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final GridSpanInfo Unspecified = new GridSpanInfo(0, 0);

    @NotNull
    private static final GridSpanInfo Default = new GridSpanInfo(5, 6);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, m13886d2 = {"Landroidx/glance/oneui/common/GridSpanInfo$Companion;", "", "()V", AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME, "Landroidx/glance/oneui/common/GridSpanInfo;", "getDefault", "()Landroidx/glance/oneui/common/GridSpanInfo;", "Unspecified", "getUnspecified", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GridSpanInfo getDefault() {
            return GridSpanInfo.Default;
        }

        @NotNull
        public final GridSpanInfo getUnspecified() {
            return GridSpanInfo.Unspecified;
        }

        private Companion() {
        }
    }

    public GridSpanInfo(int i, int i2) {
        this.w = i;
        this.h = i2;
    }

    public static /* synthetic */ GridSpanInfo copy$default(GridSpanInfo gridSpanInfo, int i, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = gridSpanInfo.w;
        }
        if ((i4 & 2) != 0) {
            i2 = gridSpanInfo.h;
        }
        return gridSpanInfo.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getW() {
        return this.w;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getH() {
        return this.h;
    }

    @NotNull
    public final GridSpanInfo copy(int w, int h) {
        return new GridSpanInfo(w, h);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GridSpanInfo)) {
            return false;
        }
        GridSpanInfo gridSpanInfo = (GridSpanInfo) other;
        return this.w == gridSpanInfo.w && this.h == gridSpanInfo.h;
    }

    public final int getH() {
        return this.h;
    }

    public final int getW() {
        return this.w;
    }

    public int hashCode() {
        return Integer.hashCode(this.h) + (Integer.hashCode(this.w) * 31);
    }

    @NotNull
    public String toString() {
        return AbstractC0622a.m1164j(this.w, this.h, "GridSpanInfo(w=", ", h=", ")");
    }
}
