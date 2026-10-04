package com.samsung.context.sdk.samsunganalytics.internal.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.SecureRandom;
import java.util.Objects;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class IdGenerator {
    public static final int DEVICE_ID_BIT_NUM = 128;
    private static final String FILE_NAME = "SamsungAnalyticsSdkId";

    private boolean checkSkipGenerateDeviceId(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        return !Objects.equals(str, str2);
    }

    private String generateRandomDeviceId() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[16];
        StringBuilder sb = new StringBuilder(32);
        for (int i = 0; i < 32; i++) {
            secureRandom.nextBytes(bArr);
            try {
                sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt((int) (Math.abs(new BigInteger(bArr).longValue()) % ((long) 62))));
            } catch (Exception e) {
                Debug.logwingW("failed to generate random deviceId" + e.getMessage());
                return null;
            }
        }
        return sb.toString();
    }

    public String createDeviceId(Context context) {
        return recreateDeviceId(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String recreateDeviceId(Context context, String str) {
        FileLock fileLockTryLock;
        String path = context.getFileStreamPath(FILE_NAME).getPath();
        for (int i = 0; i < 20; i++) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(path, InternalZipConstants.WRITE_MODE);
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        fileLockTryLock = channel.tryLock();
                    } finally {
                    }
                    if (fileLockTryLock != null) {
                        try {
                            if (fileLockTryLock.isValid()) {
                                String line = randomAccessFile.readLine();
                                if (checkSkipGenerateDeviceId(line, str)) {
                                    fileLockTryLock.close();
                                } else {
                                    line = generateRandomDeviceId();
                                    if (!TextUtils.isEmpty(line)) {
                                        randomAccessFile.setLength(0L);
                                        randomAccessFile.writeBytes(line);
                                    }
                                    fileLockTryLock.close();
                                }
                                channel.close();
                                randomAccessFile.close();
                                return line;
                            }
                        } finally {
                        }
                    }
                    Debug.LogI("Get file lock failed, retry: " + i);
                    Thread.sleep(500L);
                    if (fileLockTryLock != null) {
                        fileLockTryLock.close();
                    }
                    channel.close();
                    randomAccessFile.close();
                } finally {
                }
            } catch (Exception e) {
                Debug.logwingE("Generate deviceId failed, error: " + e.getMessage());
            }
        }
        return null;
    }
}
