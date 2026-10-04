package com.yubico.yubikit.core.smartcard;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Apdu {
    private final byte cla;
    private final byte[] data;
    private final byte ins;

    /* JADX INFO: renamed from: p1 */
    private final byte f8445p1;

    /* JADX INFO: renamed from: p2 */
    private final byte f8446p2;

    private Apdu(byte b, byte b5, byte b6, byte b7, @Nullable byte[] bArr) {
        this.cla = b;
        this.ins = b5;
        this.f8445p1 = b6;
        this.f8446p2 = b7;
        this.data = bArr == null ? new byte[0] : bArr;
    }

    private static byte validateByte(int i, String str) {
        if (i > 255 || i < -128) {
            throw new IllegalArgumentException(AbstractC0541b.m773o("Invalid value for ", str, ", must fit in a byte"));
        }
        return (byte) i;
    }

    public byte getCla() {
        return this.cla;
    }

    public byte[] getData() {
        byte[] bArr = this.data;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public byte getIns() {
        return this.ins;
    }

    public byte getP1() {
        return this.f8445p1;
    }

    public byte getP2() {
        return this.f8446p2;
    }

    public Apdu(int i, int i2, int i4, int i5, @Nullable byte[] bArr) {
        this(validateByte(i, "CLA"), validateByte(i2, "INS"), validateByte(i4, "P1"), validateByte(i5, "P2"), bArr);
    }
}
