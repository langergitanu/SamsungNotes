package com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.decoder;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class QuotedPrintable {
    private static byte ESCAPE_CHAR = 61;

    public static final byte[] decodeQuotedPrintable(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStreamDecodeQuotedPrintableFromByte = decodeQuotedPrintableFromByte(bArr);
        return byteArrayOutputStreamDecodeQuotedPrintableFromByte == null ? new byte[0] : byteArrayOutputStreamDecodeQuotedPrintableFromByte.toByteArray();
    }

    private static ByteArrayOutputStream decodeQuotedPrintableFromByte(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            byte b = bArr[i];
            if (b == ESCAPE_CHAR) {
                try {
                    byte b5 = bArr[i + 1];
                    if ('\r' == ((char) b5)) {
                        int i2 = i + 2;
                        if ('\n' == ((char) bArr[i2])) {
                            i = i2;
                        }
                    }
                    int iDigit = Character.digit((char) b5, 16);
                    i += 2;
                    int iDigit2 = Character.digit((char) bArr[i], 16);
                    if (iDigit != -1 && iDigit2 != -1) {
                        byteArrayOutputStream.write((char) ((iDigit << 4) + iDigit2));
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                return null;
            }
            byteArrayOutputStream.write(b);
            i++;
        }
        return byteArrayOutputStream;
    }

    public static String decodeQuotedPrintable(String str) {
        Charset charset = StandardCharsets.UTF_8;
        ByteArrayOutputStream byteArrayOutputStreamDecodeQuotedPrintableFromByte = decodeQuotedPrintableFromByte(str.getBytes(charset));
        if (byteArrayOutputStreamDecodeQuotedPrintableFromByte == null) {
            return null;
        }
        return new String(byteArrayOutputStreamDecodeQuotedPrintableFromByte.toByteArray(), charset);
    }

    public static String decodeQuotedPrintable(String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStreamDecodeQuotedPrintableFromByte = decodeQuotedPrintableFromByte(str.getBytes(StandardCharsets.UTF_8));
        if (byteArrayOutputStreamDecodeQuotedPrintableFromByte == null) {
            return null;
        }
        return byteArrayOutputStreamDecodeQuotedPrintableFromByte.toString(str2);
    }
}
