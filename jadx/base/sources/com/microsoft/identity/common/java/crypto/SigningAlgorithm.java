package com.microsoft.identity.common.java.crypto;

import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum SigningAlgorithm {
    NONE_WITH_RSA("NONEwithRSA"),
    SHA_1_WITH_RSA("SHA1withRSA"),
    SHA_256_WITH_RSA("SHA256withRSA");

    private final String mValue;

    SigningAlgorithm(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("value is marked non-null but is null");
        }
        this.mValue = str;
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return this.mValue;
    }
}
