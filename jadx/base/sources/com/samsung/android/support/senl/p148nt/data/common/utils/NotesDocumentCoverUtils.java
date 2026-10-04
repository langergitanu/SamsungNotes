package com.samsung.android.support.senl.p148nt.data.common.utils;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesDocumentCoverUtils {
    private static final String TAG = DataLogger.createTag("NotesDocumentCoverUtils");

    public static int getVersion(String str) {
        int iIndexOf;
        if (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf(CoverConstants.VERSION_PREFIX)) < 0) {
            return 0;
        }
        try {
            return Integer.parseInt(str.substring(iIndexOf + 7));
        } catch (NumberFormatException e) {
            DataLogger.m12303e(TAG, "getVersion, e: " + e.getMessage());
            return 0;
        }
    }

    public static boolean isHigherCoverVersion(String str) {
        return isHigherCoverVersion(str, getVersion(CoverConstants.VERSION));
    }

    public static boolean isHigherCoverVersion(String str, int i) {
        int i2;
        int iIndexOf = str.indexOf(CoverConstants.VERSION_PREFIX);
        int iIndexOf2 = str.indexOf(CoverConstants.VERSION_SEPARATOR);
        if (iIndexOf < 0 || iIndexOf2 < 0) {
            return false;
        }
        try {
            i2 = Integer.parseInt(str.substring(iIndexOf + 7, iIndexOf2));
        } catch (NumberFormatException e) {
            DataLogger.m12303e(TAG, "isHigherCoverVersion, e: " + e.getMessage());
            i2 = 0;
        }
        return i2 > i;
    }
}
