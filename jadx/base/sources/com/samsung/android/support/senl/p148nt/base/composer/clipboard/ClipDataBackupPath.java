package com.samsung.android.support.senl.p148nt.base.composer.clipboard;

import android.content.ClipData;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ClipDataBackupPath {
    public static final String CLIPDATA_BACKUP_PATH_POSTFIX = "-->";
    public static final String CLIPDATA_BACKUP_PATH_PREFIX = "<!--";
    private static final String TAG = Logger.createTag("CPLog$ClipDataBackupPath");

    public static String getBackupPathFromHtml(ClipData clipData) {
        if (clipData == null) {
            Logger.m8702i(TAG, "getBackupPathFromHtml# clipData is null");
            return null;
        }
        String htmlText = clipData.getItemAt(Math.max(clipData.getItemCount() - 1, 0)).getHtmlText();
        if (!TextUtils.isEmpty(htmlText)) {
            return getBackupPathFromHtml(htmlText);
        }
        Logger.m8702i(TAG, "getBackupPathFromHtml# htmlText is empty");
        return null;
    }

    @NonNull
    public static String getClipDataBackupPath(String str) {
        return AbstractC0541b.m773o("<!--", str, "-->");
    }

    public static boolean isNoteClip(ClipData clipData) {
        return isNoteClip(getBackupPathFromHtml(clipData));
    }

    public static boolean isNoteClip(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.toLowerCase().endsWith("sdocx") || str.toLowerCase().endsWith("spd")) {
            return true;
        }
        Logger.m8702i(TAG, "isNoteClip : extension of restoreFilePath is wrong");
        return false;
    }

    public static String getBackupPathFromHtml(String str) {
        int i;
        int iLastIndexOf = str.lastIndexOf("-->");
        int iLastIndexOf2 = str.lastIndexOf("<!--", iLastIndexOf);
        if (iLastIndexOf >= 0 && iLastIndexOf2 >= 0 && iLastIndexOf <= str.length() && iLastIndexOf >= (i = iLastIndexOf2 + 4)) {
            String strSubstring = str.substring(i, iLastIndexOf);
            if (AbstractC2322a.m1607A(strSubstring)) {
                return strSubstring;
            }
            Logger.m8702i(TAG, "getBackupPathFromHtml# backup file is not exists" + Logger.getEncode(strSubstring));
            return null;
        }
        Logger.m8702i(TAG, "getBackupPathFromHtml# backup path index is wrong :" + iLastIndexOf2 + "," + iLastIndexOf);
        return null;
    }
}
