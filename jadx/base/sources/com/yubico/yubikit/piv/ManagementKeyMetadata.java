package com.yubico.yubikit.piv;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ManagementKeyMetadata {
    private final boolean defaultValue;
    private final ManagementKeyType keyType;
    private final TouchPolicy touchPolicy;

    public ManagementKeyMetadata(ManagementKeyType managementKeyType, boolean z, TouchPolicy touchPolicy) {
        this.keyType = managementKeyType;
        this.defaultValue = z;
        this.touchPolicy = touchPolicy;
    }

    public ManagementKeyType getKeyType() {
        return this.keyType;
    }

    public TouchPolicy getTouchPolicy() {
        return this.touchPolicy;
    }

    public boolean isDefaultValue() {
        return this.defaultValue;
    }
}
