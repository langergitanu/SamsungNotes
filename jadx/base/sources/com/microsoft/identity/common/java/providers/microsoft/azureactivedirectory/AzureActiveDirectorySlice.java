package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectorySlice {
    public static final String DC_PARAMETER = "dc";
    public static final String SLICE_PARAMETER = "slice";

    @SerializedName("dc")
    private String mDataCenter;

    @SerializedName(SLICE_PARAMETER)
    private String mSlice;

    public AzureActiveDirectorySlice() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof AzureActiveDirectorySlice;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AzureActiveDirectorySlice)) {
            return false;
        }
        AzureActiveDirectorySlice azureActiveDirectorySlice = (AzureActiveDirectorySlice) obj;
        if (!azureActiveDirectorySlice.canEqual(this)) {
            return false;
        }
        String slice = getSlice();
        String slice2 = azureActiveDirectorySlice.getSlice();
        if (slice != null ? !slice.equals(slice2) : slice2 != null) {
            return false;
        }
        String dataCenter = getDataCenter();
        String dataCenter2 = azureActiveDirectorySlice.getDataCenter();
        return dataCenter != null ? dataCenter.equals(dataCenter2) : dataCenter2 == null;
    }

    public String getDataCenter() {
        return this.mDataCenter;
    }

    public String getSlice() {
        return this.mSlice;
    }

    public int hashCode() {
        String slice = getSlice();
        int iHashCode = slice == null ? 43 : slice.hashCode();
        String dataCenter = getDataCenter();
        return ((iHashCode + 59) * 59) + (dataCenter != null ? dataCenter.hashCode() : 43);
    }

    public void setDataCenter(String str) {
        this.mDataCenter = str;
    }

    public void setSlice(String str) {
        this.mSlice = str;
    }

    public AzureActiveDirectorySlice(String str, String str2) {
        this.mSlice = str;
        this.mDataCenter = str2;
    }
}
