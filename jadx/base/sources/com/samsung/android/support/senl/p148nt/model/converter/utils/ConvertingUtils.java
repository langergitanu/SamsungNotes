package com.samsung.android.support.senl.p148nt.model.converter.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConvertingUtils {
    private static final float DISK_FACTOR = 4.0f;
    private static final String TAG = ModelLogger.createConverterTag("ConvertingUtils");
    private static final long AVAILABLE_CONVERTING_MEMORY_SIZE_FOR_NEW_MEMO = StorageUtils.getAvailableConvertingMemorySizeForNewMemo();
    private static long sTotalSizeInConverting = 0;

    public static long getRequiredSizeForConverting(long j) {
        return (long) ((j * 4.0f) + AVAILABLE_CONVERTING_MEMORY_SIZE_FOR_NEW_MEMO);
    }

    public static long getUncompressedSDocSize(@NonNull Context context, String str) {
        return StorageUtils.getUncompressedSdocSize(context, str);
    }

    public static boolean isAvailableMemoryForSDocConverting(long j) {
        long availableInternalMemorySize = StorageUtils.getAvailableInternalMemorySize();
        long requiredSizeForConverting = getRequiredSizeForConverting(j);
        String str = TAG;
        StringBuilder sbM1323p = AbstractC1974b.m1323p(availableInternalMemorySize, "isAvailableMemoryForConverting, storage/reqSize = ", "/");
        sbM1323p.append(requiredSizeForConverting);
        DataLogger.m12302d(str, sbM1323p.toString());
        return Long.compare(availableInternalMemorySize, requiredSizeForConverting) == 1;
    }

    public static synchronized boolean isAvailableMemoryForSDocXConverting(long j) {
        boolean z;
        try {
            long availableInternalMemorySize = StorageUtils.getAvailableInternalMemorySize();
            long j2 = sTotalSizeInConverting + j;
            z = true;
            if (Long.compare(availableInternalMemorySize, j2) != 1) {
                z = false;
            }
            if (z) {
                sTotalSizeInConverting = j2;
            }
            DataLogger.m12302d(TAG, "isAvailableMemoryForConverting, available = " + z + ", storage/expected/required = " + availableInternalMemorySize + " / " + j2 + " / " + j);
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    public static synchronized void reduceConvertingSize(long j) {
        sTotalSizeInConverting = Math.max(0L, sTotalSizeInConverting - j);
        DataLogger.m12302d(TAG, "reduceConvertingSize, finished = " + j + ", total = " + sTotalSizeInConverting);
    }

    public static synchronized void resetConvertingSize() {
        DataLogger.m12302d(TAG, "resetConvertingSize");
        sTotalSizeInConverting = 0L;
    }
}
