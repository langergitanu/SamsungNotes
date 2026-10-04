package com.samsung.android.sdk.pen.ocr;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.ocr.SpenOcrDataProviderContract;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenOcrDataProviderHelper {
    private static final String TAG = "SpenOcrDataProviderHelper";

    private static synchronized void closeContentProviderClient(ContentProviderClient contentProviderClient) {
        Log.i(TAG, "Close ContentProviderClient");
        if (contentProviderClient == null) {
            Log.e(TAG, "closeContentProviderClient() content provider client is null!");
        } else {
            contentProviderClient.close();
        }
    }

    public static synchronized AssetFileDescriptor getAssetFileDescriptor(Context context, String str, SpenDBType spenDBType) {
        Log.d(TAG, "getAssetFileDescriptor");
        ContentProviderClient contentProviderClientOpenContentProviderClient = openContentProviderClient(context);
        AssetFileDescriptor assetFileDescriptorOpenAssetFile = null;
        if (contentProviderClientOpenContentProviderClient == null) {
            Log.e(TAG, "getAssetFileDescriptor : ContentProviderClient is null");
            return null;
        }
        try {
            Uri uri = Uri.parse("content://com.samsung.android.sdk.ocr.resourcemanager/" + str);
            String str2 = SpenOcrDataProviderContract.ASSETS_MODEL_DIR_OCRDB;
            if (spenDBType.equals(SpenDBType.BlockAnalyzer)) {
                str2 = SpenOcrDataProviderContract.ASSETS_MODEL_DIR_BLOCK_ANALYZER;
            } else if (spenDBType.equals(SpenDBType.MoireDetector)) {
                str2 = SpenOcrDataProviderContract.ASSETS_MODEL_DIR_MOIRE_DETECTOR;
            }
            Log.i(TAG, uri.toString());
            assetFileDescriptorOpenAssetFile = contentProviderClientOpenContentProviderClient.openAssetFile(uri, str2);
            Log.i(TAG, "getAssetFileDescriptor : asset data size: " + assetFileDescriptorOpenAssetFile.getLength());
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        closeContentProviderClient(contentProviderClientOpenContentProviderClient);
        return assetFileDescriptorOpenAssetFile;
    }

    private static synchronized byte[] getBytesFrom(AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor == null) {
            Log.e(TAG, "getBytesFrom : AssetFileDescriptor is null");
            return null;
        }
        ParcelFileDescriptor parcelFileDescriptor = assetFileDescriptor.getParcelFileDescriptor();
        long startOffset = assetFileDescriptor.getStartOffset();
        long length = assetFileDescriptor.getLength();
        if (length == -1) {
            Log.e(TAG, "getBytesFrom : UNKNOWN_LENGTH");
            return null;
        }
        return getBytesFrom(parcelFileDescriptor, startOffset, (int) length);
    }

    public static synchronized String getCachedFilePath(Context context, String str, String str2, SpenDBType spenDBType) {
        return getCachedFilePath(context, str, str2, spenDBType, getBytesFrom(getAssetFileDescriptor(context, str2, spenDBType)));
    }

    private static synchronized List<String> getSupportedLanguageList(ContentProviderClient contentProviderClient) {
        Cursor cursorQuery;
        Log.i(TAG, "getSupportedLanguageList : start query");
        ArrayList arrayList = new ArrayList();
        if (contentProviderClient == null) {
            Log.e(TAG, "getSupportedLanguageList : client is null");
            return arrayList;
        }
        try {
            cursorQuery = contentProviderClient.query(SpenOcrDataProviderContract.InstalledLanguages.CONTENT_URI, new String[0], "", new String[0], "");
            try {
            } finally {
            }
        } catch (Exception e) {
            Log.e(TAG, "getSupportedLanguageList : query exception : " + e.getMessage());
        }
        if (cursorQuery == null) {
            Log.e(TAG, "getSupportedLanguageList : cursor is null!");
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        }
        for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
            arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("language")));
        }
        cursorQuery.close();
        Log.i(TAG, "getSupportedLanguageList : " + arrayList);
        return arrayList;
    }

    public static synchronized List<String> getSupportedLanguages(Context context) {
        List<String> supportedLanguageList;
        Log.d(TAG, "getSupportedLanguages");
        ContentProviderClient contentProviderClientOpenContentProviderClient = openContentProviderClient(context);
        supportedLanguageList = getSupportedLanguageList(contentProviderClientOpenContentProviderClient);
        closeContentProviderClient(contentProviderClientOpenContentProviderClient);
        return supportedLanguageList;
    }

    private static synchronized ContentProviderClient openContentProviderClient(Context context) {
        Log.i(TAG, "Open ContentProviderClient");
        ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
        if (contentResolver == null) {
            Log.e(TAG, "openContentProviderClient() content resolver is null!");
            return null;
        }
        ContentProviderClient contentProviderClientAcquireContentProviderClient = contentResolver.acquireContentProviderClient(SpenOcrDataProviderContract.AUTHORITY);
        if (contentProviderClientAcquireContentProviderClient != null) {
            return contentProviderClientAcquireContentProviderClient;
        }
        Log.e(TAG, "openContentProviderClient() content provider client is null!");
        return null;
    }

    private static synchronized void readAndWriteToBuffer(OutputStream outputStream, InputStream inputStream, byte[] bArr, int i) {
        outputStream.write(bArr, 0, inputStream.read(bArr, 0, i));
    }

    public static synchronized void releaseCachedDBFilePath(Context context, String str) {
        Log.d(TAG, "releaseCachedDBFilePath dbFilePath : " + str);
        File file = new File(Uri.parse(str).getPath());
        file.delete();
        if (file.exists()) {
            try {
                file.getCanonicalFile().delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (file.exists()) {
                context.deleteFile(file.getName());
            }
        }
    }

    private static synchronized boolean writeBytesToFile(File file, byte[] bArr) {
        if (bArr != null) {
            if (bArr.length != 0) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                        return true;
                    } catch (Throwable th) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    Log.e(TAG, "writeBytesToFile : error message = " + e.getMessage());
                    return false;
                }
            }
        }
        Log.e(TAG, "writeBytesToFile : input bytes is wrong!");
        return false;
    }

    public static synchronized String getCachedFilePath(Context context, String str, String str2, SpenDBType spenDBType, byte[] bArr) {
        String strConcat;
        File file;
        File cacheDir = context.getApplicationContext().getCacheDir();
        if (cacheDir == null) {
            Log.e(TAG, "cache dir is null!");
            return "";
        }
        String str3 = cacheDir.getAbsolutePath() + File.separator + SpenOcrDataProviderContract.ASSETS_MODEL_DIR_OCRDB;
        File file2 = new File(str3);
        if (!file2.exists() && !file2.mkdirs()) {
            Log.e(TAG, "Fail to create moire cache dir!");
            return "";
        }
        if (!spenDBType.equals(SpenDBType.MoireDetector)) {
            file = new File(str3, "_" + str2 + ".dat");
        } else {
            if (str != null && str.length() > 0) {
                strConcat = str.concat(SpenOcrDataProviderContract.TFLITE_EXTENSION);
            } else {
                strConcat = "_moire.tflite";
            }
            file = new File(str3, strConcat);
        }
        if (file.exists()) {
            if (!file.delete()) {
                Log.e(TAG, "Fail to delete existing file!");
                return "";
            }
            Log.d(TAG, "Success to delete existing file!");
        }
        if (!writeBytesToFile(file, bArr)) {
            return "";
        }
        return file.getAbsolutePath();
    }

    @NonNull
    private static synchronized byte[] getBytesFrom(ParcelFileDescriptor parcelFileDescriptor, long j, int i) {
        BufferedInputStream bufferedInputStream;
        Log.i(TAG, "getBytesFrom : startOffset = " + j + ", bufferSize = " + i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bufferedInputStream = new BufferedInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            long jSkip = bufferedInputStream.skip(j);
            if (j != jSkip) {
                Log.e(TAG, "getBytesFrom : startoffset skip failed!");
                byte[] bArr = new byte[0];
                bufferedInputStream.close();
                return bArr;
            }
            byte[] bArr2 = new byte[8192];
            int i2 = i / 8192;
            int i4 = i % 8192;
            for (int i5 = 0; i5 < i2; i5++) {
                readAndWriteToBuffer(byteArrayOutputStream, bufferedInputStream, bArr2, 8192);
            }
            readAndWriteToBuffer(byteArrayOutputStream, bufferedInputStream, bArr2, i4);
            bufferedInputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
