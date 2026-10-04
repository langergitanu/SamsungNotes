package com.microsoft.identity.common.internal.platform;

import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface AsymmetricRsaKey extends AsymmetricKey {
    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    @RequiresApi(18)
    String decrypt(String str);

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    @RequiresApi(18)
    String encrypt(String str);

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    String getPublicKey();

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    String getThumbprint();

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    String sign(String str);

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKey
    boolean verify(String str, String str2);
}
