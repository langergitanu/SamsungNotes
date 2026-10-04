package com.microsoft.identity.common.internal.fido;

import androidx.annotation.NonNull;
import com.squareup.moshi.Json;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PublicKeyCredentialRequestOptions {

    @Json(name = "allowCredentials")
    public final List<PublicKeyCredentialDescriptor> allowCredentials;

    @Json(name = "challenge")
    public final String challenge;

    @Json(name = "rpId")
    public final String rpId;

    @Json(name = "userVerification")
    public final String userVerification;

    public PublicKeyCredentialRequestOptions(@NonNull String str, @NonNull String str2, @NonNull List<PublicKeyCredentialDescriptor> list, @NonNull String str3) {
        this.challenge = str;
        this.rpId = str2;
        this.allowCredentials = list;
        this.userVerification = str3;
    }

    public List<PublicKeyCredentialDescriptor> getAllowCredentials() {
        return this.allowCredentials;
    }

    public String getChallenge() {
        return this.challenge;
    }

    public String getRpId() {
        return this.rpId;
    }

    public String getUserVerification() {
        return this.userVerification;
    }
}
