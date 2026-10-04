package com.samsung.context.sdk.samsunganalytics.internal.connection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum Directory {
    DEVICE_CONTROLLER_DIR("/v3/sdk/quotas"),
    DATA_DELETE("/v3/sdk/indiv/delete"),
    DLS_DIR(""),
    DLS_DIR_BAT("");

    String directory;

    Directory(String str) {
        this.directory = str;
    }

    public String getDirectory() {
        return this.directory;
    }

    public void setDirectory(String str) {
        this.directory = str;
    }
}
