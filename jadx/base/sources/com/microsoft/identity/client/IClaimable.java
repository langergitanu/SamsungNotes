package com.microsoft.identity.client;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IClaimable {
    @Nullable
    Map<String, ?> getClaims();

    @Nullable
    String getIdToken();

    @NonNull
    String getTenantId();

    @NonNull
    String getUsername();
}
