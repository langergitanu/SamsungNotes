package com.samsung.scsp.odm.dos.common;

import com.google.gson.annotations.SerializedName;
import com.samsung.scsp.framework.core.api.CacheableResponse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OdmDosVo implements CacheableResponse {

    @SerializedName("conditionId")
    public String conditionId;
    public String etag;

    /* JADX INFO: renamed from: id */
    @SerializedName("id")
    public String f8249id;

    @SerializedName("requestAfter")
    public int requestAfter;
    public int status;

    @Override // com.samsung.scsp.framework.core.api.CacheableResponse
    public void update(int i, String str) {
        this.status = i;
        this.etag = str;
    }
}
