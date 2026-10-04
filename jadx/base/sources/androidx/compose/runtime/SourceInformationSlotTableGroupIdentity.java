package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0001HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, m13886d2 = {"Landroidx/compose/runtime/SourceInformationSlotTableGroupIdentity;", "", "parentIdentity", "index", "", "(Ljava/lang/Object;I)V", "getIndex", "()I", "getParentIdentity", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final /* data */ class SourceInformationSlotTableGroupIdentity {
    private final int index;

    @NotNull
    private final Object parentIdentity;

    public SourceInformationSlotTableGroupIdentity(@NotNull Object obj, int i) {
        this.parentIdentity = obj;
        this.index = i;
    }

    public static /* synthetic */ SourceInformationSlotTableGroupIdentity copy$default(SourceInformationSlotTableGroupIdentity sourceInformationSlotTableGroupIdentity, Object obj, int i, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = sourceInformationSlotTableGroupIdentity.parentIdentity;
        }
        if ((i2 & 2) != 0) {
            i = sourceInformationSlotTableGroupIdentity.index;
        }
        return sourceInformationSlotTableGroupIdentity.copy(obj, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Object getParentIdentity() {
        return this.parentIdentity;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final SourceInformationSlotTableGroupIdentity copy(@NotNull Object parentIdentity, int index) {
        return new SourceInformationSlotTableGroupIdentity(parentIdentity, index);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SourceInformationSlotTableGroupIdentity)) {
            return false;
        }
        SourceInformationSlotTableGroupIdentity sourceInformationSlotTableGroupIdentity = (SourceInformationSlotTableGroupIdentity) other;
        return Intrinsics.areEqual(this.parentIdentity, sourceInformationSlotTableGroupIdentity.parentIdentity) && this.index == sourceInformationSlotTableGroupIdentity.index;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final Object getParentIdentity() {
        return this.parentIdentity;
    }

    public int hashCode() {
        return Integer.hashCode(this.index) + (this.parentIdentity.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("SourceInformationSlotTableGroupIdentity(parentIdentity=");
        sb.append(this.parentIdentity);
        sb.append(", index=");
        return AbstractC0000a.m13j(sb, this.index, PropertyUtils.MAPPED_DELIM2);
    }
}
