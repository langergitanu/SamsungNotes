package com.google.android.appfunctions.schema.common.p129v1.nearbysharing;

import androidx.appsearch.annotation.Document;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__FindNearbyDevicesParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\fH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0007\u0010\u0014R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/nearbysharing/FindNearbyDevicesParams;", "", "namespace", "", "id", "query", HandoffConstant.KEY_DEVICE_TYPE, "isMyDevice", "", "maxSearchTimeMillis", "", "maxCount", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;I)V", "getNamespace", "()Ljava/lang/String;", "getId", "getQuery", "getDeviceType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMaxSearchTimeMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMaxCount", "()I", "equals", "other", "hashCode", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class FindNearbyDevicesParams {

    @Document.StringProperty
    @Nullable
    private final String deviceType;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.BooleanProperty
    @Nullable
    private final Boolean isMyDevice;

    @Document.LongProperty(required = true)
    private final int maxCount;

    @Document.LongProperty
    @Nullable
    private final Long maxSearchTimeMillis;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty
    @Nullable
    private final String query;

    public FindNearbyDevicesParams(@NotNull String namespace, @NotNull String id, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable Long l, int i) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.query = str;
        this.deviceType = str2;
        this.isMyDevice = bool;
        this.maxSearchTimeMillis = l;
        this.maxCount = i;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof FindNearbyDevicesParams)) {
            return false;
        }
        FindNearbyDevicesParams findNearbyDevicesParams = (FindNearbyDevicesParams) other;
        return Intrinsics.areEqual(this.query, findNearbyDevicesParams.query) && Intrinsics.areEqual(this.deviceType, findNearbyDevicesParams.deviceType) && Intrinsics.areEqual(this.isMyDevice, findNearbyDevicesParams.isMyDevice) && Intrinsics.areEqual(this.maxSearchTimeMillis, findNearbyDevicesParams.maxSearchTimeMillis) && this.maxCount == findNearbyDevicesParams.maxCount;
    }

    @Nullable
    public final String getDeviceType() {
        return this.deviceType;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    @Nullable
    public final Long getMaxSearchTimeMillis() {
        return this.maxSearchTimeMillis;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final String getQuery() {
        return this.query;
    }

    public int hashCode() {
        return Objects.hash(this.query, this.deviceType, this.isMyDevice, this.maxSearchTimeMillis, Integer.valueOf(this.maxCount));
    }

    @Nullable
    /* JADX INFO: renamed from: isMyDevice, reason: from getter */
    public final Boolean getIsMyDevice() {
        return this.isMyDevice;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FindNearbyDevicesParams(String str, String str2, String str3, String str4, Boolean bool, Long l, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int i4;
        Long l2;
        str = (i2 & 1) != 0 ? "" : str;
        str2 = (i2 & 2) != 0 ? "" : str2;
        str3 = (i2 & 4) != 0 ? null : str3;
        str4 = (i2 & 8) != 0 ? null : str4;
        bool = (i2 & 16) != 0 ? null : bool;
        if ((i2 & 32) != 0) {
            i4 = i;
            l2 = null;
        } else {
            i4 = i;
            l2 = l;
        }
        this(str, str2, str3, str4, bool, l2, i4);
    }
}
