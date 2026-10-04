package com.samsung.scsp.common;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.constants.FidoConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PushVo {

    @SerializedName("callbackUrl")
    public String callbackUrl;

    @SerializedName("category")
    public String category;

    @SerializedName("dataJson")
    public JsonObject data;

    @SerializedName("data")
    public String dataValue;

    @SerializedName("deviceSignature")
    public String deviceSignature;
    public int originalPriority;
    public int priority;

    @SerializedName(FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY)
    public String signature;
}
