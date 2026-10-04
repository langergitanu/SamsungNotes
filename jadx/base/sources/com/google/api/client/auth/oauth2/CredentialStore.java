package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
@Deprecated
public interface CredentialStore {
    void delete(String str, Credential credential);

    boolean load(String str, Credential credential);

    void store(String str, Credential credential);
}
