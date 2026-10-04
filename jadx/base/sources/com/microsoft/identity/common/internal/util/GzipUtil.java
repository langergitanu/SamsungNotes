package com.microsoft.identity.common.internal.util;

import androidx.annotation.NonNull;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class GzipUtil {
    public static byte[] compressString(@NonNull String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bytes, 0, bytes.length);
        gZIPOutputStream.flush();
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    public static String decompressBytesToString(@NonNull byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[256];
        while (true) {
            int i = gZIPInputStream.read(bArr2);
            if (i < 0) {
                gZIPInputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                return new String(byteArray, 0, byteArray.length, "UTF-8");
            }
            byteArrayOutputStream.write(bArr2, 0, i);
        }
    }
}
