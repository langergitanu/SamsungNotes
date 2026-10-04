package com.microsoft.identity.common.java.crypto;

import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface SymmetricAlgorithm extends Algorithm {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        /* JADX INFO: renamed from: of */
        public static SymmetricAlgorithm m4629of(@NonNull final String str) {
            if (str != null) {
                return new SymmetricAlgorithm() { // from class: com.microsoft.identity.common.java.crypto.SymmetricAlgorithm.Builder.1
                    @Override // com.microsoft.identity.common.java.crypto.SymmetricAlgorithm, com.microsoft.identity.common.java.crypto.Algorithm
                    public String name() {
                        return str;
                    }
                };
            }
            throw new NullPointerException("name is marked non-null but is null");
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.Algorithm
    String name();
}
