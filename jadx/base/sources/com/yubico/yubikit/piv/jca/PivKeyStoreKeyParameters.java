package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.piv.PinPolicy;
import com.yubico.yubikit.piv.TouchPolicy;
import java.security.KeyStore;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PivKeyStoreKeyParameters implements KeyStore.ProtectionParameter {
    final PinPolicy pinPolicy;
    final TouchPolicy touchPolicy;

    public PivKeyStoreKeyParameters(PinPolicy pinPolicy, TouchPolicy touchPolicy) {
        this.pinPolicy = pinPolicy;
        this.touchPolicy = touchPolicy;
    }
}
