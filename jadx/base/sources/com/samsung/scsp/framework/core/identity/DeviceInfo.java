package com.samsung.scsp.framework.core.identity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class DeviceInfo {
    private String alias;
    private String simMcc;
    private String simMnc;

    public DeviceInfo(String str, String str2, String str3) {
        this.simMcc = str;
        this.simMnc = str2;
        this.alias = str3;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getSimMcc() {
        return this.simMcc;
    }

    public String getSimMnc() {
        return this.simMnc;
    }

    public boolean isAllFieldsNull() {
        return this.simMcc == null && this.simMnc == null && this.alias == null;
    }
}
