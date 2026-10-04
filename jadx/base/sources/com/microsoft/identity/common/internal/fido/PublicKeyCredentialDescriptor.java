package com.microsoft.identity.common.internal.fido;

import androidx.annotation.NonNull;
import com.squareup.moshi.Json;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PublicKeyCredentialDescriptor {

    /* JADX INFO: renamed from: id */
    @Json(name = "id")
    public final String f3585id;

    @Json(name = "type")
    public final String type;

    public PublicKeyCredentialDescriptor(@NonNull String str, @NonNull String str2) {
        this.type = str;
        this.f3585id = str2;
    }

    public String getId() {
        return this.f3585id;
    }

    public String getType() {
        return this.type;
    }
}
