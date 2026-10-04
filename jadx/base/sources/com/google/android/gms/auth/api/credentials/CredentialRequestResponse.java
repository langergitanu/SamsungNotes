package com.google.android.gms.auth.api.credentials;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Response;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class CredentialRequestResponse extends Response<CredentialRequestResult> {
    @Nullable
    public Credential getCredential() {
        return getResult().getCredential();
    }
}
