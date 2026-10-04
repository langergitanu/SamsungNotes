package com.samsung.scsp.framework.core.ers;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DomainVo {

    @SerializedName("default")
    public String defaultUrl;
    public long expiredTime = 0;

    @SerializedName("odm")
    public String odmUrl;

    @SerializedName("play")
    public String playUrl;
}
