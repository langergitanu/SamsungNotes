package com.samsung.android.support.senl.document.contract;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.Spanned;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentWeb;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface DocumentContract {
    Spanned charUtils_fromHtml(String str);

    boolean detourUtils_commitEditor(SharedPreferences.Editor editor);

    String fileUtils_logPath(String str);

    int getDocInitModeAppWidget();

    String getExtraValueLockConfirmed();

    int getLockTypeSNB();

    int getLockTypeSPD();

    int getLockTypeTMEMO();

    int getMaxTextureSize();

    String getNoteFilePath(Context context);

    File getPrivateFile(Context context, String str);

    Rect getScreenDimension(Context context);

    int getThumbnailCompressQuality();

    File imageUtils_saveToCache(Context context, Bitmap bitmap, int i, int i2, int i4, int i5);

    boolean isAllActivityFinished();

    void logger_d(String str, String str2);

    void logger_e(String str, String str2);

    void logger_e(String str, String str2, Throwable th);

    String logger_getEncode(String str);

    String logger_getLogFilePath(Context context);

    void logger_i(String str, String str2);

    void makeWebCardData(SpenContentWeb spenContentWeb, MemoMetaDataItem memoMetaDataItem);

    String newUUID(Context context);
}
