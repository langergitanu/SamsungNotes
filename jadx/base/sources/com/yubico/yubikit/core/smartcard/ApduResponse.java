package com.yubico.yubikit.core.smartcard;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ApduResponse {
    private final byte[] bytes;

    public ApduResponse(byte[] bArr) {
        if (bArr.length < 2) {
            throw new IllegalArgumentException("Invalid APDU response data");
        }
        this.bytes = Arrays.copyOf(bArr, bArr.length);
    }

    public byte[] getBytes() {
        byte[] bArr = this.bytes;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public byte[] getData() {
        return Arrays.copyOfRange(this.bytes, 0, r0.length - 2);
    }

    public short getSw() {
        byte[] bArr = this.bytes;
        return (short) ((bArr[bArr.length - 1] & 255) | ((bArr[bArr.length - 2] & 255) << 8));
    }
}
