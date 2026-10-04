package com.yubico.yubikit.piv;

import java.security.PublicKey;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SlotMetadata {
    private final boolean generated;
    private final KeyType keyType;
    private final PinPolicy pinPolicy;
    private final byte[] publicKeyEncoded;
    private final TouchPolicy touchPolicy;

    public SlotMetadata(KeyType keyType, PinPolicy pinPolicy, TouchPolicy touchPolicy, boolean z, byte[] bArr) {
        this.keyType = keyType;
        this.pinPolicy = pinPolicy;
        this.touchPolicy = touchPolicy;
        this.generated = z;
        this.publicKeyEncoded = Arrays.copyOf(bArr, bArr.length);
    }

    public KeyType getKeyType() {
        return this.keyType;
    }

    public PinPolicy getPinPolicy() {
        return this.pinPolicy;
    }

    public PublicKey getPublicKey() {
        return PivSession.parsePublicKeyFromDevice(this.keyType, this.publicKeyEncoded);
    }

    public TouchPolicy getTouchPolicy() {
        return this.touchPolicy;
    }

    public boolean isGenerated() {
        return this.generated;
    }
}
