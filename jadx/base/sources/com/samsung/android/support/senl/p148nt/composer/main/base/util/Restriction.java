package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class Restriction {
    public static final int ATTACH_MAX_COUNT = 100;
    public static final int ATTACH_MM_MAX_COUNT = 210;
    public static final int COEDIT_LARGE_MAX_COUNT = 100;
    public static final int COEDIT_PASTE_MAX_COUNT = 100;
    public static final int FILE_NAME_MAX_BYTES = 200;
    public static final int FILE_NAME_MAX_LENGTH = 100;
    public static final int SCROLL_THRESHOLD = 20;
    public static final int SHARE_TITLE_MAX_LENGTH = 50;
    public static final int TITLE_MAX_LENGTH = 50;
    public static final int VOICE_TITLE_MAX_LENGTH = 50;

    public static String getTitleForFileName(String str) {
        return (str == null || str.length() <= 50) ? str : str.substring(0, 50);
    }

    public static boolean showToastCoeditErrorOverLargeMaxCount(Context context) {
        ToastHandler.show(context, context.getResources().getQuantityString(C9086R.plurals.can_not_add_more_than_items, 100, 100), 0);
        return false;
    }

    public static void showToastNotSupportDexScan(Context context) {
        ToastHandler.show(context, C9086R.string.cannot_use_feature_in_dex_mode, 0);
    }

    public static void showToastNotSupportMultiWindowCompareSyncConflict(Context context) {
        ToastHandler.show(context, C9086R.string.cannot_use_feature_in_multi_window, 0);
    }

    public static void showToastNotSupportMultiWindowScan(Context context) {
        ToastHandler.show(context, C9086R.string.cannot_use_feature_in_multi_window, 0);
    }
}
