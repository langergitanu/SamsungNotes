package com.microsoft.identity.common.java.jwt;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.jwt.AbstractJwtRequest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class JwtRequestHeader extends AbstractJwtRequest {
    public static final String ALG_VALUE_HS256 = "HS256";
    public static final String ALG_VALUE_RS256 = "RS256";
    private static final String JWT_VALUE = "JWT";

    @SerializedName("alg")
    private String mAlg;

    @SerializedName(AbstractJwtRequest.ClaimNames.CTX)
    private String mCtx;

    @SerializedName("kid")
    private String mKId;

    @SerializedName(AbstractJwtRequest.ClaimNames.KDF_VER)
    private int mKdfVersion = 1;

    @SerializedName("typ")
    private String mType;

    public String getAlg() {
        return this.mAlg;
    }

    public String getCtx() {
        return this.mCtx;
    }

    public String getKId() {
        return this.mKId;
    }

    public int getKdfVersion() {
        return this.mKdfVersion;
    }

    public String getType() {
        return this.mType;
    }

    public void setAlg(String str) {
        this.mAlg = str;
    }

    public void setCtx(String str) {
        this.mCtx = str;
    }

    public void setKId(String str) {
        this.mKId = str;
    }

    public void setKdfVersion(int i) {
        this.mKdfVersion = i;
    }

    public void setType() {
        this.mType = JWT_VALUE;
    }
}
