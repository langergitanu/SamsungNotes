package com.samsung.android.app.sdk.deepsky.suggestion;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/Capability;", "", "capabilityParam", "Lcom/samsung/android/app/sdk/deepsky/suggestion/CapabilityEnum;", "extrasParam", "Landroid/os/Bundle;", "(Lcom/samsung/android/app/sdk/deepsky/suggestion/CapabilityEnum;Landroid/os/Bundle;)V", "capability", "getCapability", "()Lcom/samsung/android/app/sdk/deepsky/suggestion/CapabilityEnum;", "extras", "getExtras", "()Landroid/os/Bundle;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class Capability {

    @NotNull
    private final CapabilityEnum capabilityParam;

    @Nullable
    private final Bundle extrasParam;

    /* JADX WARN: Multi-variable type inference failed */
    public Capability() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final CapabilityEnum getCapabilityParam() {
        return this.capabilityParam;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final Bundle getExtrasParam() {
        return this.extrasParam;
    }

    public static /* synthetic */ Capability copy$default(Capability capability, CapabilityEnum capabilityEnum, Bundle bundle, int i, Object obj) {
        if ((i & 1) != 0) {
            capabilityEnum = capability.capabilityParam;
        }
        if ((i & 2) != 0) {
            bundle = capability.extrasParam;
        }
        return capability.copy(capabilityEnum, bundle);
    }

    @NotNull
    public final Capability copy(@NotNull CapabilityEnum capabilityParam, @Nullable Bundle extrasParam) {
        Intrinsics.checkNotNullParameter(capabilityParam, "capabilityParam");
        return new Capability(capabilityParam, extrasParam);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Capability)) {
            return false;
        }
        Capability capability = (Capability) other;
        return this.capabilityParam == capability.capabilityParam && Intrinsics.areEqual(this.extrasParam, capability.extrasParam);
    }

    @NotNull
    public final CapabilityEnum getCapability() {
        return this.capabilityParam;
    }

    @Nullable
    public final Bundle getExtras() {
        return this.extrasParam;
    }

    public int hashCode() {
        int iHashCode = this.capabilityParam.hashCode() * 31;
        Bundle bundle = this.extrasParam;
        return iHashCode + (bundle == null ? 0 : bundle.hashCode());
    }

    @NotNull
    public String toString() {
        return "Capability(capabilityParam=" + this.capabilityParam + ", extrasParam=" + this.extrasParam + ")";
    }

    public Capability(@NotNull CapabilityEnum capabilityParam, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(capabilityParam, "capabilityParam");
        this.capabilityParam = capabilityParam;
        this.extrasParam = bundle;
    }

    public /* synthetic */ Capability(CapabilityEnum capabilityEnum, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CapabilityEnum.UNKNOWN : capabilityEnum, (i & 2) != 0 ? null : bundle);
    }
}
