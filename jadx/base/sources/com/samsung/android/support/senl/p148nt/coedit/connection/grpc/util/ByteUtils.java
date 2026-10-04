package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util;

import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ByteUtils {
    private static final String TAG = "ByteUtils";

    public static byte[] read(ByteArrayInputStream byteArrayInputStream) {
        byte[] bArr = new byte[byteArrayInputStream.available()];
        try {
            byteArrayInputStream.read(bArr);
            return bArr;
        } catch (IOException e) {
            CoeditLogger.m8920e(TAG, "read ByteArrayOutputStream : " + e.getMessage());
            return bArr;
        }
    }

    public static void releaseByteArrayOutputStream(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        try {
            if (byteArrayOutputStream == null) {
                return;
            }
            byteArrayOutputStream.flush();
        } catch (IOException e) {
            CoeditLogger.m8920e(TAG, "releaseByteArrayOutputStream : " + e.getMessage());
        } finally {
            byteArrayOutputStream.close();
        }
    }
}
