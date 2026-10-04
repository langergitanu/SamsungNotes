package com.microsoft.identity.client.exception;

import androidx.annotation.NonNull;
import com.microsoft.identity.client.AcquireTokenSilentParameters;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MsalDeclinedScopeException extends MsalException {
    private List<String> mDeclinedScopes;
    private List<String> mGrantedScopes;
    private AcquireTokenSilentParameters mSilentParametersForGrantedScopes;

    public MsalDeclinedScopeException(@NonNull List<String> list, @NonNull List<String> list2, @NonNull AcquireTokenSilentParameters acquireTokenSilentParameters) {
        super(ErrorStrings.DECLINED_SCOPE_ERROR_CODE, ErrorStrings.DECLINED_SCOPE_ERROR_MESSAGE);
        this.mGrantedScopes = list;
        this.mDeclinedScopes = list2;
        this.mSilentParametersForGrantedScopes = acquireTokenSilentParameters;
    }

    public List<String> getDeclinedScopes() {
        return this.mDeclinedScopes;
    }

    public List<String> getGrantedScopes() {
        return this.mGrantedScopes;
    }

    public AcquireTokenSilentParameters getSilentParametersForGrantedScopes() {
        return this.mSilentParametersForGrantedScopes;
    }
}
