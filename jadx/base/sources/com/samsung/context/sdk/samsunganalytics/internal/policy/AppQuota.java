package com.samsung.context.sdk.samsunganalytics.internal.policy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class AppQuota {
    private int dataQuota;
    private int dataUsed;
    private int loadedSize;
    private int wifiQuota;
    private int wifiUsed;

    public int getDataQuota() {
        return this.dataQuota;
    }

    public int getDataUsed() {
        return this.dataUsed;
    }

    public int getLoadedSize() {
        return this.loadedSize;
    }

    public int getWifiQuota() {
        return this.wifiQuota;
    }

    public int getWifiUsed() {
        return this.wifiUsed;
    }

    public void setDataQuota(int i) {
        this.dataQuota = i;
    }

    public void setDataUsed(int i) {
        this.dataUsed = i;
    }

    public void setLoadedSize(int i) {
        this.loadedSize = i;
    }

    public void setWifiQuota(int i) {
        this.wifiQuota = i;
    }

    public void setWifiUsed(int i) {
        this.wifiUsed = i;
    }
}
