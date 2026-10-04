package com.microsoft.identity.common.internal.platform;

import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import java.security.KeyStore;
import java.security.PublicKey;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface AsymmetricKeyAccessor extends IManagedKeyAccessor<KeyStore.PrivateKeyEntry> {
    String getPublicKey(IDevicePopManager.PublicKeyFormat publicKeyFormat);

    PublicKey getPublicKey();
}
