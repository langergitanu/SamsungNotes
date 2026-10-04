package androidx.glance.oneui.common.appwidgetsize;

import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m13886d2 = {"Landroidx/glance/oneui/common/appwidgetsize/HostId;", "", "id", "", "packageName", "", "(ILjava/lang/String;)V", "getId", "()I", "getPackageName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class HostId {
    private final int id;

    @NotNull
    private final String packageName;

    public HostId(int i, @NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.id = i;
        this.packageName = packageName;
    }

    public static /* synthetic */ HostId copy$default(HostId hostId, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = hostId.id;
        }
        if ((i2 & 2) != 0) {
            str = hostId.packageName;
        }
        return hostId.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final HostId copy(int id, @NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new HostId(id, packageName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostId)) {
            return false;
        }
        HostId hostId = (HostId) other;
        return this.id == hostId.id && Intrinsics.areEqual(this.packageName, hostId.packageName);
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return this.packageName.hashCode() + (Integer.hashCode(this.id) * 31);
    }

    @NotNull
    public String toString() {
        return AbstractC11014a.m12321f("HostId(id=", this.id, ", packageName=", this.packageName, ")");
    }
}
