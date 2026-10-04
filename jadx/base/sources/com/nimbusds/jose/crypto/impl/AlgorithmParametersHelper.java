package com.nimbusds.jose.crypto.impl;

import java.security.AlgorithmParameters;
import java.security.Provider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AlgorithmParametersHelper {
    public static AlgorithmParameters getInstance(String str, Provider provider) {
        return provider == null ? AlgorithmParameters.getInstance(str) : AlgorithmParameters.getInstance(str, provider);
    }
}
