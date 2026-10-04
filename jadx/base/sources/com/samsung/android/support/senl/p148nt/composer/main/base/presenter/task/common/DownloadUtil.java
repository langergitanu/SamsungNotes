package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DownloadUtil {
    public static final int ERROR_TYPE_DOWNLOAD_FAIL = 256;
    public static final int ERROR_TYPE_EXCEED_ATTACH_COUNT = 512;
    public static final int ERROR_TYPE_NOT_AVAILABLE_DOWNLOAD = 2048;
    public static final int ERROR_TYPE_OVER_NOTE_SIZE = 1024;
    private static final String TAG = Logger.createTag("DownloadUtil");

    public static void showErrorToast(Context context, int i) {
        String string = (i & 256) != 0 ? context.getResources().getString(C9086R.string.base_string_failed_to_load_image) : ((i & 1024) == 0 || (131072 & i) != 0) ? (i & 512) != 0 ? context.getResources().getString(C9086R.string.composer_unable_to_insert_more_than, 100) : (i & 2048) != 0 ? context.getResources().getString(C9086R.string.composer_failed_to_download_content) : null : DialogUtils.getOverSizeString(context, 1024L);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        Logger.m11004w(TAG, string);
        ToastHandler.show(context, string, 0);
    }
}
