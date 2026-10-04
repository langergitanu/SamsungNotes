package com.yubico.yubikit.piv;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GzipUtils {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) GzipUtils.class);

    public static byte[] compress(byte[] bArr) {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Compressing {} bytes", Integer.valueOf(bArr.length));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                com.yubico.yubikit.core.internal.Logger.debug(logger2, "Compressed to {} bytes", Integer.valueOf(byteArrayOutputStream.size()));
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static byte[] decompress(byte[] bArr) throws IOException {
        GZIPInputStream gZIPInputStream;
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Decompressing {} bytes", Integer.valueOf(bArr.length));
        byte[] bArr2 = new byte[512];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            } finally {
            }
            while (true) {
                try {
                    int i = gZIPInputStream.read(bArr2, 0, 512);
                    if (i == -1) {
                        com.yubico.yubikit.core.internal.Logger.debug(logger, "Decompressed to {} bytes", Integer.valueOf(byteArrayOutputStream.size()));
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i);
                } finally {
                }
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
