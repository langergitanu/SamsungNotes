package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class FingerprintTrustManagerFactoryBuilder {
    private final String algorithm;
    private final List<String> fingerprints = new ArrayList();

    public FingerprintTrustManagerFactoryBuilder(String str) {
        this.algorithm = (String) ObjectUtil.checkNotNull(str, "algorithm");
    }

    public FingerprintTrustManagerFactory build() {
        if (this.fingerprints.isEmpty()) {
            throw new IllegalStateException("No fingerprints provided");
        }
        return new FingerprintTrustManagerFactory(this.algorithm, FingerprintTrustManagerFactory.toFingerprintArray(this.fingerprints));
    }

    public FingerprintTrustManagerFactoryBuilder fingerprints(CharSequence... charSequenceArr) {
        return fingerprints(Arrays.asList((Object[]) ObjectUtil.checkNotNull(charSequenceArr, "fingerprints")));
    }

    public FingerprintTrustManagerFactoryBuilder fingerprints(Iterable<? extends CharSequence> iterable) {
        ObjectUtil.checkNotNull(iterable, "fingerprints");
        for (CharSequence charSequence : iterable) {
            ObjectUtil.checkNotNullWithIAE(charSequence, "fingerprint");
            this.fingerprints.add(charSequence.toString());
        }
        return this;
    }
}
