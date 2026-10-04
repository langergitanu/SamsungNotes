package com.google.firebase.installations;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RandomFidGenerator {
    private static final int FID_LENGTH = 22;
    private static final byte FID_4BIT_PREFIX = Byte.parseByte("01110000", 2);
    private static final byte REMOVE_PREFIX_MASK = Byte.parseByte("00001111", 2);

    private static String encodeFidBase64UrlSafe(byte[] bArr) {
        return new String(Base64.encode(bArr, 11), Charset.defaultCharset()).substring(0, 22);
    }

    private static byte[] getBytesFromUUID(UUID uuid, byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.putLong(uuid.getMostSignificantBits());
        byteBufferWrap.putLong(uuid.getLeastSignificantBits());
        return byteBufferWrap.array();
    }

    @NonNull
    public String createRandomFid() {
        byte[] bytesFromUUID = getBytesFromUUID(UUID.randomUUID(), new byte[17]);
        byte b = bytesFromUUID[0];
        bytesFromUUID[16] = b;
        bytesFromUUID[0] = (byte) ((b & REMOVE_PREFIX_MASK) | FID_4BIT_PREFIX);
        return encodeFidBase64UrlSafe(bytesFromUUID);
    }
}
