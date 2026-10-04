package com.samsung.scsp.odm.dos.configuration;

import com.google.gson.annotations.SerializedName;
import com.samsung.scsp.framework.core.api.DrsSupportableResponse;
import com.samsung.scsp.odm.dos.common.OdmDosVo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ContentInfo extends OdmDosVo implements DrsSupportableResponse {

    @SerializedName("file")
    public ConfigurationFile file;
    public boolean isDrs;
    public String ticketId;

    @Override // com.samsung.scsp.framework.core.api.DrsSupportableResponse
    public void update(boolean z, String str) {
        this.isDrs = z;
        this.ticketId = str;
    }
}
