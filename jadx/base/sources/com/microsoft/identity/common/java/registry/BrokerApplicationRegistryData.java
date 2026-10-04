package com.microsoft.identity.common.java.registry;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.cache.AbstractApplicationMetadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrokerApplicationRegistryData extends AbstractApplicationMetadata {

    @SerializedName("wpj_account_access_allowed")
    private boolean mWpjAccountAccessAllowed;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SerializedNames extends AbstractApplicationMetadata.SerializedNames {
        static final String ALLOW_WPJ_ACCESS = "wpj_account_access_allowed";

        private SerializedNames() {
        }
    }

    @Override // com.microsoft.identity.common.java.cache.AbstractApplicationMetadata
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && super.equals(obj) && this.mWpjAccountAccessAllowed == ((BrokerApplicationRegistryData) obj).mWpjAccountAccessAllowed;
    }

    @Override // com.microsoft.identity.common.java.cache.AbstractApplicationMetadata
    public int hashCode() {
        return (super.hashCode() * 31) + (this.mWpjAccountAccessAllowed ? 1 : 0);
    }

    public boolean isWpjAccountAccessAllowed() {
        return this.mWpjAccountAccessAllowed;
    }

    public void setWpjAccountAccessAllowed(boolean z) {
        this.mWpjAccountAccessAllowed = z;
    }
}
