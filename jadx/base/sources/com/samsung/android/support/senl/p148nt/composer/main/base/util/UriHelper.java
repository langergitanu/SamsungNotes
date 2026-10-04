package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ShareFileProvider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class UriHelper {
    public static final String SHARE_TAG = ".notes@share";
    private static final String TAG = Logger.createTag("UriHelper");

    @Nullable
    public static Uri getFileProviderUri(Context context, String str) {
        Uri uri = ShareFileProvider.getUri(context, str);
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("getFileProviderUri# uri: ");
        sb.append(uri == null ? null : Logger.getEncode(uri.toString()));
        Logger.m11003i(str2, sb.toString());
        return uri;
    }

    public static Uri getMediaUri(Context context, Uri uri, String str, @Nullable String str2) {
        return getMediaUri(context, uri, str, str2, true);
    }

    public static void requestScanFile(Context context, String str, @Nullable String str2) {
        requestScanFile(context, new String[]{str}, new String[]{str2});
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002f A[Catch: all -> 0x002c, TryCatch #1 {all -> 0x002c, blocks: (B:4:0x0013, B:6:0x0019, B:9:0x002f, B:11:0x003b, B:12:0x0042, B:14:0x0048, B:15:0x004d), top: B:28:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Uri getMediaUri(Context context, Uri uri, String str, @Nullable String str2, boolean z) {
        Uri uriWithAppendedPath;
        Cursor cursorQuery = context.getContentResolver().query(uri, null, "_data=? ", new String[]{str}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    uriWithAppendedPath = Uri.withAppendedPath(uri, String.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))));
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_data", str);
                    if (z) {
                        contentValues.put("name", SHARE_TAG);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        contentValues.put("mime_type", str2);
                    }
                    uriWithAppendedPath = context.getContentResolver().insert(uri, contentValues);
                }
            } catch (Throwable th) {
                if (cursorQuery == null) {
                    throw th;
                }
                try {
                    cursorQuery.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        requestScanFile(context, str, str2);
        return uriWithAppendedPath;
    }

    public static void requestScanFile(Context context, String[] strArr, String[] strArr2) {
        Logger.m10999d(TAG, "requestScanFile, paths size : " + strArr.length);
        MediaScannerConnection.scanFile(context, strArr, strArr2, new MediaScannerConnection.MediaScannerConnectionClient() { // from class: com.samsung.android.support.senl.nt.composer.main.base.util.UriHelper.1
            @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
            public void onMediaScannerConnected() {
                Logger.m10999d(UriHelper.TAG, "requestScanFile, onMediaScannerConnected");
            }

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str, Uri uri) {
                String str2 = UriHelper.TAG;
                StringBuilder sb = new StringBuilder("requestScanFile, onScanCompleted: ");
                sb.append(uri == null ? null : Logger.getEncode(uri.toString()));
                Logger.m11003i(str2, sb.toString());
            }
        });
    }
}
