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
@Document(name = C$$__AppSearch__NearbyDevice.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\b\u0010\u0012¨\u0006\u0018"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/nearbysharing/NearbyDevice;", "", "namespace", "", "id", "nearbyDeviceId", "deviceName", HandoffConstant.KEY_DEVICE_TYPE, "isMyDevice", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getNearbyDeviceId", "getDeviceName", "getDeviceType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "equals", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class NearbyDevice {

    @Document.StringProperty(required = true)
    @NotNull
    private final String deviceName;

    @Document.StringProperty
    @Nullable
    private final String deviceType;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.BooleanProperty
    @Nullable
    private final Boolean isMyDevice;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty(required = true)
    @NotNull
    private final String nearbyDeviceId;

    public NearbyDevice(@NotNull String namespace, @NotNull String id, @NotNull String nearbyDeviceId, @NotNull String deviceName, @Nullable String str, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(nearbyDeviceId, "nearbyDeviceId");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        this.namespace = namespace;
        this.id = id;
        this.nearbyDeviceId = nearbyDeviceId;
        this.deviceName = deviceName;
        this.deviceType = str;
        this.isMyDevice = bool;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof NearbyDevice)) {
            return false;
        }
        NearbyDevice nearbyDevice = (NearbyDevice) other;
        return Intrinsics.areEqual(this.nearbyDeviceId, nearbyDevice.nearbyDeviceId) && Intrinsics.areEqual(this.deviceName, nearbyDevice.deviceName) && Intrinsics.areEqual(this.deviceType, nearbyDevice.deviceType) && Intrinsics.areEqual(this.isMyDevice, nearbyDevice.isMyDevice);
    }

    @NotNull
    public final String getDeviceName() {
        return this.deviceName;
    }

    @Nullable
    public final String getDeviceType() {
        return this.deviceType;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    public final String getNearbyDeviceId() {
        return this.nearbyDeviceId;
    }

    public int hashCode() {
        return Objects.hash(this.nearbyDeviceId, this.deviceName, this.deviceType, this.isMyDevice);
    }

    @Nullable
    /* JADX INFO: renamed from: isMyDevice, reason: from getter */
    public final Boolean getIsMyDevice() {
        return this.isMyDevice;
    }

    public /* synthetic */ NearbyDevice(String str, String str2, String str3, String str4, String str5, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : bool);
    }
}
