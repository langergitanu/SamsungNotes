package com.microsoft.identity.common.java.providers.oauth2;

import com.google.gson.annotations.Expose;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AuthorizationResponse implements ISuccessResponse {
    private String mCode;
    private transient Iterable<Map.Entry<String, String>> mExtraParameters;

    @Expose
    private String mState;

    public AuthorizationResponse(String str) {
        this(str, null);
    }

    public String getCode() {
        return this.mCode;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters
    @Nullable
    public Iterable<Map.Entry<String, String>> getExtraParameters() {
        return this.mExtraParameters;
    }

    public String getState() {
        return this.mState;
    }

    public void setCode(String str) {
        this.mCode = str;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters
    public void setExtraParameters(Iterable<Map.Entry<String, String>> iterable) {
        this.mExtraParameters = iterable;
    }

    public void setState(String str) {
        this.mState = str;
    }

    public AuthorizationResponse(String str, String str2) {
        this.mCode = str;
        this.mState = str2;
    }
}
