package com.microsoft.identity.common.java.cache;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.cache.AbstractApplicationMetadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrokerApplicationMetadata extends AbstractApplicationMetadata {

    @SerializedName("family_id")
    private String mFoci;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SerializedNames extends AbstractApplicationMetadata.SerializedNames {
        static final String FAMILY_ID = "family_id";

        private SerializedNames() {
        }
    }

    @Override // com.microsoft.identity.common.java.cache.AbstractApplicationMetadata
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getFoci() {
        return this.mFoci;
    }

    @Override // com.microsoft.identity.common.java.cache.AbstractApplicationMetadata
    public int hashCode() {
        return super.hashCode();
    }

    public void setFoci(String str) {
        this.mFoci = str;
    }
}
