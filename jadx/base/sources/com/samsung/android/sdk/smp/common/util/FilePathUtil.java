package com.samsung.android.sdk.smp.common.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class FilePathUtil {
    private static final String RESOURCE_PATH = "/ppmt";
    private static final String RES_IMAGE_PATH = "/img";
    private static final String RES_TEXT_FILENAME = "text.txt";
    private static final String RES_TEXT_PATH = "/txt";

    public static String getImgDirectory(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return getResDirectory(context, str) + RES_IMAGE_PATH;
    }

    public static String getResDirectory(Context context) {
        if (context == null) {
            return null;
        }
        return AbstractC0541b.m756B(context.getApplicationContext().getFilesDir().getPath(), RESOURCE_PATH);
    }

    public static String getTxtFilePath(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return getResDirectory(context, str) + "/txt/text.txt";
    }

    public static String getResDirectory(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return AbstractC0541b.m757C(context.getApplicationContext().getFilesDir().getPath(), "/ppmt/", str);
    }
}
