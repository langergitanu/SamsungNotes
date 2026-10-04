package com.yubico.yubikit.piv;

import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum PinPolicy {
    DEFAULT(0),
    NEVER(1),
    ONCE(2),
    ALWAYS(3);

    public final int value;

    PinPolicy(int i) {
        this.value = i;
    }

    public static PinPolicy fromValue(int i) {
        if (i < 0 || i >= values().length) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Not a valid PinPolicy :"));
        }
        return values()[i];
    }
}
