package com.samsung.android.sdk.handwriting.text.impl;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.handwriting.LanguageID;
import com.samsung.android.sdk.handwriting.text.impl.LanguageManagerContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LanguageRMHelper {
    private static final int MAX_DATA_MD5_MAP_SIZE = 300;
    private static final String TAG = "LanguageRMHelper";
    private static final Map<String, String[]> mMultiDB;
    private Context mContext;
    private final boolean mbContentProviderAvailable;
    private byte[] mDataBuffer = null;
    private byte[][] mWholeDataBuffers = null;
    private final Map<String, String> DATA_MD5_MAP = new HashMap();

    static {
        HashMap map = new HashMap();
        map.put("ko_KR", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
        map.put("ko_KR_NoHanJa", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
        map.put("ja_JP", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
        map.put("zh_CN", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
        map.put("zh_HK", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
        map.put("zh_TW", new String[]{DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE, "en_GB"});
        mMultiDB = Collections.unmodifiableMap(map);
    }

    public LanguageRMHelper(Context context) {
        this.mContext = context.getApplicationContext();
        ContentProviderClient contentProviderClient = getContentProviderClient();
        if (contentProviderClient == null) {
            this.mbContentProviderAvailable = false;
        } else {
            this.mbContentProviderAvailable = true;
            closeContentProviderClient(contentProviderClient);
        }
    }

    private void closeContentProviderClient(ContentProviderClient contentProviderClient) {
        String str = TAG;
        Log.i(str, "Close ContentProviderClient");
        if (contentProviderClient == null) {
            Log.e(str, "[closeContentProviderClient] content provider client is null!");
        } else {
            contentProviderClient.release();
        }
    }

    private String getAuthorityString(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        String str = TAG;
        Log.i(str, "[getAuthorityString] package name : " + packageName);
        new SepUseWrapper();
        try {
            int i = packageManager.getPackageInfo(packageName, 0).applicationInfo.uid;
            int i2 = i / 100000;
            Log.i(str, "[getAuthorityString] uid = " + i + ", userId = " + i2 + ", appId = " + (i - (100000 * i2)));
            return "com.samsung.android.sdk.handwriting.resourcemanager";
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "[getAuthorityString] Error : package name not found! ", e);
            return "com.samsung.android.sdk.handwriting.resourcemanager";
        }
    }

    private ContentProviderClient getContentProviderClient() {
        ContentProviderClient contentProviderClientAcquireContentProviderClient;
        String str = TAG;
        Log.i(str, "Get ContentProviderClient");
        ContentResolver contentResolver = this.mContext.getContentResolver();
        if (contentResolver == null) {
            Log.e(str, "[getContentProviderClient] content resolver is null!");
            return null;
        }
        try {
            contentProviderClientAcquireContentProviderClient = contentResolver.acquireContentProviderClient(getAuthorityString(this.mContext));
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "[getContentProviderClient] Exception! - " + e.getMessage());
            contentProviderClientAcquireContentProviderClient = null;
        }
        if (contentProviderClientAcquireContentProviderClient != null) {
            return contentProviderClientAcquireContentProviderClient;
        }
        Log.e(TAG, "[getContentProviderClient] content provider client is null!");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.lang.Object, java.lang.String] */
    private byte[] getResourceBuffer(String str, String str2) throws Throwable {
        byte[] string;
        Throwable th;
        Throwable th2;
        int iAvailable;
        byte[] bArr;
        int i;
        ContentProviderClient contentProviderClient = getContentProviderClient();
        if (contentProviderClient == null) {
            Log.e(TAG, "[getResourceBuffer] client is null");
            return null;
        }
        Uri uriWithAppendedPath = Uri.withAppendedPath(Uri.withAppendedPath(LanguageManagerContract.Langs.CONTENT_URI, str), str2);
        this.mDataBuffer = null;
        try {
            Cursor cursorQuery = contentProviderClient.query(uriWithAppendedPath, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("resource"));
                string = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("preloaded"));
                String str3 = TAG;
                Log.i(str3, "getResourceBuffer : path = " + string2);
                Log.i(str3, "getResourceBuffer : md5 = " + ((String) string));
                Log.i(str3, "getResourceBuffer : preload = " + i2);
                if (this.DATA_MD5_MAP.size() < 300) {
                    this.DATA_MD5_MAP.put(str, (String) string);
                } else {
                    Log.e(str3, "getResourceBuffer : So lots of DATA_MD5_MAP size!" + this.DATA_MD5_MAP.size());
                }
                cursorQuery.close();
                String strSubstring = string2.substring(string2.lastIndexOf("HWRDB") + 6);
                Log.i(str3, "getResourceBuffer : filePath = " + strSubstring);
                Uri uri = Uri.parse("content://com.samsung.android.sdk.handwriting.resourcemanager/" + strSubstring);
                Log.i(str3, "getResourceBuffer : uriForFile = " + uri.toString());
                try {
                    ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(contentProviderClient.openFile(uri, i2 == 1 ? "preload" : "download"));
                    try {
                        try {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(autoCloseInputStream);
                            try {
                                iAvailable = bufferedInputStream.available();
                                Log.i(str3, "getResourceBuffer : bufferSize = " + iAvailable);
                                this.mDataBuffer = new byte[iAvailable];
                                bArr = new byte[8192];
                                i = 0;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            while (true) {
                                int i4 = bufferedInputStream.read(bArr);
                                if (i4 == -1) {
                                    break;
                                }
                                try {
                                    System.arraycopy(bArr, 0, this.mDataBuffer, i, i4);
                                    i += i4;
                                } catch (Throwable th4) {
                                    th2 = th4;
                                }
                                th2 = th;
                                try {
                                    bufferedInputStream.close();
                                    throw th2;
                                } catch (Throwable th5) {
                                    th2.addSuppressed(th5);
                                    throw th2;
                                }
                            }
                            if (i != iAvailable) {
                                Log.e(TAG, "getResourceBuffer : TotalByte = " + i + " and BufferSize = " + iAvailable + " is different!");
                                try {
                                    this.mDataBuffer = null;
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            }
                            bufferedInputStream.close();
                            autoCloseInputStream.close();
                        } catch (Throwable th7) {
                            th = th7;
                            th = th;
                            try {
                                autoCloseInputStream.close();
                                throw th;
                            } catch (Throwable th8) {
                                th.addSuppressed(th8);
                                throw th;
                            }
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        th = th;
                        autoCloseInputStream.close();
                        throw th;
                    }
                } catch (RemoteException e) {
                    e = e;
                    Log.e(TAG, e.toString());
                    closeContentProviderClient(contentProviderClient);
                    return string;
                } catch (IOException e2) {
                    e = e2;
                    Log.e(TAG, e.toString());
                    closeContentProviderClient(contentProviderClient);
                    return string;
                }
            }
            closeContentProviderClient(contentProviderClient);
            return this.mDataBuffer;
        } catch (RemoteException e3) {
            e = e3;
            string = 0;
            Log.e(TAG, e.toString());
            closeContentProviderClient(contentProviderClient);
            return string;
        } catch (IOException e5) {
            e = e5;
            string = 0;
            Log.e(TAG, e.toString());
            closeContentProviderClient(contentProviderClient);
            return string;
        }
    }

    private String getResourcePath(String str, String str2) {
        ContentProviderClient contentProviderClient = getContentProviderClient();
        String string = "";
        if (contentProviderClient == null) {
            Log.e(TAG, "[getResourcePath] client is null");
            return "";
        }
        try {
            Cursor cursorQuery = contentProviderClient.query(Uri.withAppendedPath(Uri.withAppendedPath(LanguageManagerContract.Langs.CONTENT_URI, str), str2), null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("resource"));
                cursorQuery.close();
            }
            closeContentProviderClient(contentProviderClient);
            return string;
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            closeContentProviderClient(contentProviderClient);
            return "";
        }
    }

    public void close() {
        if (this.mDataBuffer != null) {
            this.mDataBuffer = null;
        }
        byte[][] bArr = this.mWholeDataBuffers;
        if (bArr != null) {
            Arrays.fill(bArr, (Object) null);
            this.mWholeDataBuffers = null;
        }
        this.mContext = null;
    }

    public List<String> getInstalledLanguageListByQuery() {
        ArrayList arrayList = new ArrayList();
        ContentProviderClient contentProviderClient = getContentProviderClient();
        if (contentProviderClient == null) {
            Log.e(TAG, "[getInstalledLanguageListByQuery] client is null");
            return arrayList;
        }
        try {
            Cursor cursorQuery = contentProviderClient.query(LanguageManagerContract.Updates.CONTENT_URI, null, null, null, null);
            if (cursorQuery == null) {
                Log.e(TAG, "[getInstalledLanguageListByQuery] cursor is null!");
                closeContentProviderClient(contentProviderClient);
                return arrayList;
            }
            for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("lang")));
            }
            cursorQuery.close();
            closeContentProviderClient(contentProviderClient);
            return arrayList;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            closeContentProviderClient(contentProviderClient);
            return arrayList;
        }
    }

    public String getMD5StringOf(String str) {
        if (this.DATA_MD5_MAP.containsKey(str)) {
            return this.DATA_MD5_MAP.get(str);
        }
        Log.i(TAG, "[getMD5StringOf] There is no language in DATA_MD5_MAP.");
        return "";
    }

    public String[] getResources(String str, String str2) {
        boolean zContains;
        Map<String, String[]> map = mMultiDB;
        if (!map.containsKey(str)) {
            return new String[]{getResourcePath(str, str2)};
        }
        String[] strArr = map.get(str);
        List<String> installedLanguageListByQuery = getInstalledLanguageListByQuery();
        if (installedLanguageListByQuery == null || installedLanguageListByQuery.size() <= 0) {
            zContains = false;
        } else {
            Log.i(TAG, "getResources : installedList = " + LanguageID.getIDs(installedLanguageListByQuery));
            zContains = installedLanguageListByQuery.contains(DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE);
        }
        AbstractC4539a.m3208r("getResources : isSupportEnUS = ", TAG, zContains);
        return new String[]{getResourcePath(str, str2), getResourcePath(zContains ? strArr[0] : strArr[1], str2)};
    }

    public byte[][] getResourcesByBuffer(String str, String str2) {
        boolean zContains;
        this.mWholeDataBuffers = null;
        Map<String, String[]> map = mMultiDB;
        if (map.containsKey(str)) {
            String[] strArr = map.get(str);
            List<String> installedLanguageListByQuery = getInstalledLanguageListByQuery();
            if (installedLanguageListByQuery == null || installedLanguageListByQuery.size() <= 0) {
                zContains = false;
            } else {
                Log.i(TAG, "getResourcesByBuffer : installedList = " + LanguageID.getIDs(installedLanguageListByQuery));
                zContains = installedLanguageListByQuery.contains(DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE);
            }
            AbstractC4539a.m3208r("getResourcesByBuffer : isSupportEnUS = ", TAG, zContains);
            byte[][] bArr = new byte[2][];
            this.mWholeDataBuffers = bArr;
            bArr[0] = getResourceBuffer(str, str2);
            this.mWholeDataBuffers[1] = getResourceBuffer(zContains ? strArr[0] : strArr[1], str2);
        } else {
            this.mWholeDataBuffers = new byte[][]{getResourceBuffer(str, str2)};
        }
        return this.mWholeDataBuffers;
    }

    public boolean isContentProviderAvailable() {
        return this.mbContentProviderAvailable;
    }
}
