package com.yubico.yubikit.core;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum YubiKeyType {
    YKS("YubiKey Standard"),
    NEO("YubiKey NEO"),
    SKY("Security Key by Yubico"),
    YKP("YubiKey Plus"),
    YK4("YubiKey");

    public final String name;

    YubiKeyType(String str) {
        this.name = str;
    }
}
