package com.microsoft.identity.common.java.dto;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum CredentialType {
    RefreshToken,
    AccessToken,
    IdToken,
    V1IdToken,
    Password,
    Cookie,
    Certificate,
    AccessToken_With_AuthScheme,
    PrimaryRefreshToken;

    public static final Collection<CredentialType> ID_TOKEN_TYPES = Collections.unmodifiableList(Arrays.asList(IdToken, V1IdToken));

    @Nullable
    public static CredentialType fromString(@Nullable String str) {
        for (CredentialType credentialType : values()) {
            if (credentialType.name().equalsIgnoreCase(str)) {
                return credentialType;
            }
        }
        return null;
    }

    public static Set<String> valueSet() {
        HashSet hashSet = new HashSet();
        for (CredentialType credentialType : values()) {
            hashSet.add(credentialType.name());
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
