package com.sec.android.diagmonagent.log.provider.utils;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ZipHelper {
    private static final int BUFFER_SIZE = 2048;
    private static final int COMPRESSION_LEVEL = 8;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0059  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.zip.ZipOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String zip(String str, String str2) throws Exception {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        ?? zipOutputStream;
        Throwable th;
        File file = new File(str);
        if (!file.isFile() && !file.isDirectory()) {
            throw new Exception("not found");
        }
        try {
            fileOutputStream = new FileOutputStream(str2);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    zipOutputStream = new ZipOutputStream(bufferedOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    zipOutputStream = 0;
                    th = th;
                    if (zipOutputStream != 0) {
                        zipOutputStream.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                zipOutputStream = bufferedOutputStream;
                th = th;
                if (zipOutputStream != 0) {
                }
                if (bufferedOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            bufferedOutputStream = null;
        }
        try {
            zipOutputStream.setLevel(8);
            zipEntry(file, zipOutputStream);
            zipOutputStream.finish();
            zipOutputStream.close();
            bufferedOutputStream.close();
            fileOutputStream.close();
            return str2;
        } catch (Throwable th5) {
            th = th5;
            if (zipOutputStream != 0) {
            }
            if (bufferedOutputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    private static void zipEntry(File file, ZipOutputStream zipOutputStream) throws Throwable {
        if (file.isDirectory()) {
            if (file.getName().equalsIgnoreCase(".metadata")) {
                return;
            }
            for (File file2 : file.listFiles()) {
                zipEntry(file2, zipOutputStream);
            }
            return;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            String path = file.getPath();
            Log.d(DiagMonUtil.TAG, path);
            StringTokenizer stringTokenizer = new StringTokenizer(path, "/");
            int iCountTokens = stringTokenizer.countTokens();
            String string = stringTokenizer.toString();
            while (iCountTokens != 0) {
                iCountTokens--;
                string = stringTokenizer.nextToken();
            }
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                ZipEntry zipEntry = new ZipEntry(string);
                zipEntry.setTime(file.lastModified());
                zipOutputStream.putNextEntry(zipEntry);
                byte[] bArr = new byte[2048];
                while (true) {
                    int i = bufferedInputStream2.read(bArr, 0, 2048);
                    if (i == -1) {
                        zipOutputStream.closeEntry();
                        bufferedInputStream2.close();
                        return;
                    }
                    zipOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
