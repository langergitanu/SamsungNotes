package com.yubico.yubikit.core.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NdefUtils {
    private static final byte[] DOMAIN;
    private static final byte HTTPS_PROTOCOL = 4;
    private static final byte[] NEO_REMAINDER_PREFIX;
    private static final byte TYPE_LENGTH = 1;
    private static final byte NDEF_RECORD = -47;
    private static final byte URL_TYPE = 85;
    private static final byte[] HEADER = {NDEF_RECORD, URL_TYPE, 4};

    static {
        Charset charset = StandardCharsets.UTF_8;
        DOMAIN = "my.yubico.com".getBytes(charset);
        NEO_REMAINDER_PREFIX = "/neo/".getBytes(charset);
    }

    public static String getNdefPayload(byte[] bArr) {
        return new String(getNdefPayloadBytes(bArr), StandardCharsets.UTF_8);
    }

    public static byte[] getNdefPayloadBytes(byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byte b = byteBufferWrap.get();
        byte b5 = byteBufferWrap.get();
        int i = (byteBufferWrap.get() - b5) & 255;
        byte b6 = byteBufferWrap.get();
        byte b7 = byteBufferWrap.get();
        if (b != -47 || b5 != 1 || b6 != 85 || b7 != 4) {
            throw new IllegalArgumentException("Not a HTTPS URL NDEF record");
        }
        byte[] bArr2 = DOMAIN;
        byte[] bArr3 = new byte[bArr2.length];
        byteBufferWrap.get(bArr3);
        if (!Arrays.equals(bArr2, bArr3)) {
            throw new IllegalArgumentException("Incorrect URL domain");
        }
        int length = i - bArr2.length;
        byte[] bArr4 = new byte[length];
        byteBufferWrap.get(bArr4);
        byte[] bArr5 = NEO_REMAINDER_PREFIX;
        if (Arrays.equals(bArr5, Arrays.copyOf(bArr4, bArr5.length))) {
            return Arrays.copyOfRange(bArr4, bArr5.length, length);
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr4[i2] == 35) {
                return Arrays.copyOfRange(bArr4, i2 + 1, length);
            }
        }
        throw new IllegalArgumentException("Incorrect URL format");
    }
}
