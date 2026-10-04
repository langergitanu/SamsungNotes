package com.samsung.scsp.odm.dos.common;

import com.google.gson.annotations.SerializedName;
import com.samsung.scsp.odm.dos.common.OdmDosApiContract;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OdmDosFileItem {

    @SerializedName(OdmDosApiContract.Parameter.DOWNLOAD_API)
    public String downloadApi;

    @SerializedName(BundleContract.EXTRA_DATA)
    public String extension;

    @SerializedName("revision")
    public int revision;

    @SerializedName("size")
    public long size;
}
