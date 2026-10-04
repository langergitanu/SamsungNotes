package com.samsung.android.support.senl.p148nt.data.common.utils;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MainListThumbnailUtils {
    private static final String TAG = DataLogger.createTag("MainListThumbnailUtils");

    public static void removePreviousThumbnailFile(Context context, String str) {
        removePreviousThumbnailFile(context, str, null);
    }

    public static void removePreviousThumbnailFile(Context context, String str, List<String> list) {
        DataLogger.m12302d(TAG, "removePreviousThumbnailFile# uuid : " + str + ", excludeList : " + list);
        StringBuilder sb = new StringBuilder();
        sb.append(PageCacheUtils.getCacheDirectory(context, str, Constants.MAIN_THUMBNAIL_PATH));
        sb.append(File.separator);
        String string = sb.toString();
        String[] strArr = {"thumbnail", "thumbnail_text", Constants.MAIN_DARK_THUMBNAIL_FILE_NAME, "d_thumbnail_text", Constants.MAIN_FULL_THUMBNAIL_FILE_NAME, "full_thumbnail_text", Constants.MAIN_DARK_FULL_THUMBNAIL_FILE_NAME, "d_full_thumbnail_text"};
        StringBuilder sb2 = new StringBuilder("removePreviousThumbnailFile, path : ");
        for (int i = 0; i < 8; i++) {
            String str2 = strArr[i];
            if (list == null || !list.contains(str2)) {
                String strM756B = AbstractC0541b.m756B(string, str2);
                sb2.append(DataLogger.getEncode(strM756B));
                sb2.append(':');
                FileUtils.deleteFile(strM756B);
            }
        }
        DataLogger.m12307i(TAG, sb2.toString());
    }
}
