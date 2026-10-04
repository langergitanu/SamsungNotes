package com.microsoft.identity.client.configuration;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class HttpConfiguration {

    @SerializedName("connect_timeout")
    private int mConnectTimeout;

    @SerializedName("read_timeout")
    private int mReadTimeout;

    public int getConnectTimeout() {
        return this.mConnectTimeout;
    }

    public int getReadTimeout() {
        return this.mReadTimeout;
    }

    public void setConnectTimeout(int i) {
        this.mConnectTimeout = i;
    }

    public void setReadTimeout(int i) {
        this.mReadTimeout = i;
    }
}
