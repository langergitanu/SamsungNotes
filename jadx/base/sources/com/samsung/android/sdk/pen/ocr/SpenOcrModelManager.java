package com.samsung.android.sdk.pen.ocr;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenOcrModelManager implements SpenIOcrModelManager {
    private static final String TAG = "SpenOcrManager";
    private long mNativeHandle;

    public SpenOcrModelManager(long j) {
        this.mNativeHandle = j;
        Log.i(TAG, "SpenOcrModelManager is created! mNativeHandle : " + Long.toHexString(this.mNativeHandle));
    }

    private native void Native_finalize(long j);

    private native int Native_findDB(long j, SpenDBConfig spenDBConfig);

    private native String Native_getDBVersion(long j, int i);

    private native int Native_loadDB(long j, FileDescriptor fileDescriptor, long j2, long j3, SpenDBConfig spenDBConfig);

    private native int Native_loadDB(long j, String str, SpenDBConfig spenDBConfig);

    private native void Native_setMaxDBNumber(long j, int i);

    private native void Native_setModelLoader(long j, long j2);

    private native void Native_unloadAllDB(long j);

    private native void Native_unloadDB(long j, int i);

    private static void saveFile(String str, byte[] bArr) {
        if (bArr == null) {
            Log.e(TAG, "SpenOcrManager::saveFile data is invalid");
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelManager
    public void close() {
        long j = this.mNativeHandle;
        if (j != 0) {
            Native_finalize(j);
        }
        this.mNativeHandle = 0L;
    }

    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelManager
    public int findDB(SpenDBConfig spenDBConfig) {
        Log.i(TAG, "SpenOcrManager::FindDB");
        return Native_findDB(this.mNativeHandle, spenDBConfig);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelManager
    public String getDBVersion(int i) {
        AbstractC11014a.m12328m(i, "SpenOcrManager::GetDBVersion id[", "]", TAG);
        return Native_getDBVersion(this.mNativeHandle, i);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelManager
    public int loadDB(Context context, String str, SpenDBConfig spenDBConfig) {
        if (str == null) {
            Log.e(TAG, "SpenOcrManager::LoadDB : filePath is null!");
            return -1;
        }
        int iFindDB = findDB(spenDBConfig);
        if (iFindDB == -1) {
            int iNative_loadDB = Native_loadDB(this.mNativeHandle, str, spenDBConfig);
            AbstractC11014a.m12328m(iNative_loadDB, "SpenOcrManager::LoadDB : succeed! DB num[", "]", TAG);
            return iNative_loadDB;
        }
        Log.w(TAG, "SpenOcrManager::LoadDB : There is already DB num[" + iFindDB + "]");
        return iFindDB;
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelManager
    public void setMaxDBNumber(int i) {
        AbstractC2322a.m1631u(i, "SpenOcrManager::setMaxDBNumber ", TAG);
        Native_setMaxDBNumber(this.mNativeHandle, i);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelManager
    public void setModelLoader(SpenIOcrModelLoaderNative spenIOcrModelLoaderNative) {
        long jNativeHandle = spenIOcrModelLoaderNative != null ? spenIOcrModelLoaderNative.nativeHandle() : 0L;
        Log.i(TAG, "SpenOcrManager::setModelLoader " + jNativeHandle);
        Native_setModelLoader(this.mNativeHandle, jNativeHandle);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelManager
    public void unloadAllDB() {
        Log.i(TAG, "SpenOcrManager::UnloadAllDB");
        Native_unloadAllDB(this.mNativeHandle);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelManager
    public void unloadDB(int i) {
        AbstractC11014a.m12328m(i, "SpenOcrManager::UnloadDB id[", "]", TAG);
        Native_unloadDB(this.mNativeHandle, i);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelManager
    public int loadDB(Context context, Object[] objArr, SpenDBConfig spenDBConfig) {
        if (objArr == null || objArr[0] == null) {
            Log.e(TAG, "SpenOcrManager::LoadDB : FileDescriptor is null!");
            return -1;
        }
        Log.i(TAG, "SpenOcrManager::LoadDB : fd[" + objArr[0] + "], start[" + objArr[1] + "], len[" + objArr[2] + "]");
        int iFindDB = findDB(spenDBConfig);
        if (iFindDB != -1) {
            Log.w(TAG, "SpenOcrManager::LoadDB : There is already DB num[" + iFindDB + "]");
            return iFindDB;
        }
        int iNative_loadDB = Native_loadDB(this.mNativeHandle, (FileDescriptor) objArr[0], Long.valueOf(String.valueOf(objArr[1])).longValue(), Long.valueOf(String.valueOf(objArr[2])).longValue(), spenDBConfig);
        AbstractC11014a.m12328m(iNative_loadDB, "SpenOcrManager::LoadDB : succeed! DB num[", "]", TAG);
        return iNative_loadDB;
    }
}
