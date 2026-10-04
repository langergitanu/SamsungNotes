package androidx.glance.oneui.common.appwidgetsize;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, m13886d2 = {"Landroidx/glance/oneui/common/appwidgetsize/HostSizeInfo;", "", "sizeTable", "", "Landroidx/glance/oneui/common/appwidgetsize/SpanSize;", "Landroidx/glance/oneui/common/appwidgetsize/AppWidgetSizeInfo;", "density", "", "hostKey", "", "(Ljava/util/Map;FI)V", "getDensity", "()F", "setDensity", "(F)V", "getHostKey", "()I", "setHostKey", "(I)V", "getSizeTable", "()Ljava/util/Map;", "setSizeTable", "(Ljava/util/Map;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class HostSizeInfo {
    private float density;
    private int hostKey;

    @NotNull
    private Map<SpanSize, AppWidgetSizeInfo> sizeTable;

    public HostSizeInfo(@NotNull Map<SpanSize, AppWidgetSizeInfo> sizeTable, float f, int i) {
        Intrinsics.checkNotNullParameter(sizeTable, "sizeTable");
        this.sizeTable = sizeTable;
        this.density = f;
        this.hostKey = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostSizeInfo copy$default(HostSizeInfo hostSizeInfo, Map map, float f, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            map = hostSizeInfo.sizeTable;
        }
        if ((i2 & 2) != 0) {
            f = hostSizeInfo.density;
        }
        if ((i2 & 4) != 0) {
            i = hostSizeInfo.hostKey;
        }
        return hostSizeInfo.copy(map, f, i);
    }

    @NotNull
    public final Map<SpanSize, AppWidgetSizeInfo> component1() {
        return this.sizeTable;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getDensity() {
        return this.density;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHostKey() {
        return this.hostKey;
    }

    @NotNull
    public final HostSizeInfo copy(@NotNull Map<SpanSize, AppWidgetSizeInfo> sizeTable, float density, int hostKey) {
        Intrinsics.checkNotNullParameter(sizeTable, "sizeTable");
        return new HostSizeInfo(sizeTable, density, hostKey);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostSizeInfo)) {
            return false;
        }
        HostSizeInfo hostSizeInfo = (HostSizeInfo) other;
        return Intrinsics.areEqual(this.sizeTable, hostSizeInfo.sizeTable) && Float.compare(this.density, hostSizeInfo.density) == 0 && this.hostKey == hostSizeInfo.hostKey;
    }

    public final float getDensity() {
        return this.density;
    }

    public final int getHostKey() {
        return this.hostKey;
    }

    @NotNull
    public final Map<SpanSize, AppWidgetSizeInfo> getSizeTable() {
        return this.sizeTable;
    }

    public int hashCode() {
        return Integer.hashCode(this.hostKey) + AbstractC0622a.m1156b(this.density, this.sizeTable.hashCode() * 31, 31);
    }

    public final void setDensity(float f) {
        this.density = f;
    }

    public final void setHostKey(int i) {
        this.hostKey = i;
    }

    public final void setSizeTable(@NotNull Map<SpanSize, AppWidgetSizeInfo> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.sizeTable = map;
    }

    @NotNull
    public String toString() {
        Map<SpanSize, AppWidgetSizeInfo> map = this.sizeTable;
        float f = this.density;
        int i = this.hostKey;
        StringBuilder sb = new StringBuilder("HostSizeInfo(sizeTable=");
        sb.append(map);
        sb.append(", density=");
        sb.append(f);
        sb.append(", hostKey=");
        return AbstractC2821a.m2223n(sb, ")", i);
    }
}
