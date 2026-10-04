package com.yubico.yubikit.piv;

import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum TouchPolicy {
    DEFAULT(0),
    NEVER(1),
    ALWAYS(2),
    CACHED(3);

    public final int value;

    TouchPolicy(int i) {
        this.value = i;
    }

    public static TouchPolicy fromValue(int i) {
        for (TouchPolicy touchPolicy : values()) {
            if (touchPolicy.value == i) {
                return touchPolicy;
            }
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Not a valid TouchPolicy :"));
    }
}
