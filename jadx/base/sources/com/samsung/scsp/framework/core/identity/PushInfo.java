package com.samsung.scsp.framework.core.identity;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.internal.providers.oauth2.ResponseType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PushInfo {

    /* JADX INFO: renamed from: id */
    @SerializedName("id")
    private String f8196id;

    @SerializedName(ResponseType.TOKEN)
    private String token;

    @SerializedName("type")
    private String type;

    public PushInfo(String str, String str2, String str3) {
        this.f8196id = str;
        this.type = str2;
        this.token = str3;
    }

    public boolean equalsValue(PushInfo pushInfo) {
        return this.f8196id.equals(pushInfo.f8196id) && this.type.equals(pushInfo.type) && this.token.equals(pushInfo.token);
    }

    public String getId() {
        return this.f8196id;
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    @NonNull
    public String toString() {
        return AbstractC2322a.m1622l(this.f8196id, "_", this.type, "_", this.token);
    }
}
