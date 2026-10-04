package com.samsung.android.mcf.continuity.interfaces;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.mcf.continuity.api.ContinuityNetworkPolicy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class ContinuityNetworkPolicyWrapper extends ContinuityNetworkPolicy {
    private final int mRole;

    private ContinuityNetworkPolicyWrapper(int i, int i2, int i4) {
        super(i, i2);
        this.mRole = i4;
    }

    @NonNull
    public static ContinuityNetworkPolicyWrapper createInstance(int i, int i2, int i4) {
        return new ContinuityNetworkPolicyWrapper(i, i2, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ContinuityNetworkPolicyWrapper.class == obj.getClass()) {
            ContinuityNetworkPolicyWrapper continuityNetworkPolicyWrapper = (ContinuityNetworkPolicyWrapper) obj;
            if (getType() == continuityNetworkPolicyWrapper.getType() && getTopology() == continuityNetworkPolicyWrapper.getTopology() && getRole() == continuityNetworkPolicyWrapper.getRole()) {
                return true;
            }
        }
        return false;
    }

    public int getRole() {
        return this.mRole;
    }

    public String toString() {
        return "ContinuityNetworkPolicyWrapper{type = " + getType() + ", topology = " + getTopology() + ", role = " + getRole() + '}';
    }
}
