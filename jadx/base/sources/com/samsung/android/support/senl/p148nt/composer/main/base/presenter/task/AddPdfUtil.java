package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AddPdfUtil {
    public static final int ERROR_DOWNLOAD = 16777216;
    public static final int ERROR_NOT_ENOUGH_MEMORY = 65536;
    public static final int ERROR_OVER_NOTE_SIZE = 131072;
    public static final int ERROR_OVER_PDF_SIZE = 67108864;
    public static final int ERROR_PDF_COPYRIGHT_PROTECTED = 8388608;
    public static final int ERROR_PDF_ERROR = 2097152;
    public static final int ERROR_PDF_FORMAT = 262144;
    public static final int ERROR_PDF_OWNER_PERMISSION = 524288;
    public static final int ERROR_PDF_PASSWORD_PROTECTED = 4194304;
    public static final int ERROR_PDF_RATIO_RESTRICTION = 268435456;
    public static final int ERROR_PDF_RATIO_RESTRICTION_IN_LANDSCAPE = 536870912;
    public static final int ERROR_PDF_RATIO_RESTRICTION_LANDSCAPE_IN_INFINITE = 1073741824;
    public static final int ERROR_PDF_RESTRICTION = 134217728;
    public static final int ERROR_PDF_UNKNOWN_ERROR = 1048576;
    public static final int ERROR_UNKNOWN = 32768;
    public static final int ERROR_UNSUPPORTED_NOTE_VERSION = 33554432;
    public static final long MAXIMUM_PDF_PAGE_COUNT = 200;
    public static final int MAXIMUM_PDF_SIZE_MB = 100;
    private static final String TAG = Logger.createTag("AddPdfUtil");
    private static int mMaximumPdfSizeMB = 100;

    public static int getConvertErrorCode(int i) {
        if (i == 65536 || i == 131072 || i == 67108864 || i == 4194304 || i == 8388608 || i == 16777216 || i == 134217728 || i == 268435456 || i == 536870912 || i == 1073741824) {
            return i;
        }
        if (i == ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_FORMAT.ordinal()) {
            return 262144;
        }
        if (i == ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_PROTECTED.ordinal()) {
            return 524288;
        }
        if (i == ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNSUPPORTED_NOTE_VERSION.ordinal()) {
            return 33554432;
        }
        if (i == ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN.ordinal()) {
            return 1048576;
        }
        return (i == ISpenNotePdfManager.ResultType.RESULT_TYPE_SUCCESS.ordinal() || i == ISpenNotePdfManager.ResultType.RESULT_TYPE_CANCEL.ordinal()) ? 0 : 2097152;
    }

    public static long getMaximumPdfSize() {
        return ((long) mMaximumPdfSizeMB) * 1048576;
    }

    public static int getMaximumPdfSizeMB() {
        return mMaximumPdfSizeMB;
    }

    public static void setMaximumPdfSizeMB(int i) {
        mMaximumPdfSizeMB = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void showErrorToast(Context context, int i, boolean z) {
        String string;
        if (context == null) {
            Logger.m11003i(TAG, "showErrorToast# context is null");
            return;
        }
        if ((65536 & i) != 0) {
            showErrorToastLowMemory(context, z);
            return;
        }
        if ((131072 & i) != 0) {
            showErrorToastOverSize(context, z, 1024L);
            return;
        }
        if ((67108864 & i) == 0) {
            if ((524288 & i) != 0) {
                string = context.getResources().getString(C9086R.string.composer_can_not_import_secured_pdfs);
            } else if ((4194304 & i) != 0) {
                string = context.getResources().getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C9086R.string.composer_can_not_open_password_protected_pdf_for_galaxy : C9086R.string.composer_can_not_open_password_protected_pdf);
            } else if ((8388608 & i) != 0) {
                string = context.getResources().getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C9086R.string.composer_can_not_open_copyright_protected_pdf_for_galaxy : C9086R.string.composer_can_not_open_copyright_protected_pdf);
            } else if ((3407872 & i) != 0) {
                string = context.getResources().getString(C9086R.string.composer_can_not_open_file);
            } else if ((16777216 & i) != 0) {
                string = context.getResources().getString(C9086R.string.composer_failed_to_download_file);
            } else if ((33554432 & i) != 0) {
                string = context.getResources().getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C9086R.string.sync_new_format_content_jp : C9086R.string.sync_new_format_content);
            } else if ((134217728 & i) != 0) {
                string = context.getResources().getString(C9086R.string.coedit_restriction_import_pdf, 200L, 100);
            } else if ((268435456 & i) != 0) {
                string = context.getResources().getString(C9086R.string.composer_could_not_add_any_page_to_note_to_portrait);
            } else if ((536870912 & i) != 0) {
                string = context.getResources().getString(C9086R.string.composer_could_not_add_any_page_to_note_to_landscape);
            } else if ((i & 1073741824) != 0) {
                string = context.getResources().getString(C9086R.string.composer_could_not_add_any_page_to_note_to_infinite);
            }
            if (TextUtils.isEmpty(string)) {
                Logger.m11004w(TAG, string);
                ToastHandler.show(context, string, 0);
                return;
            }
            return;
        }
        showErrorToastOverSize(context, z, getMaximumPdfSizeMB());
        string = null;
        if (TextUtils.isEmpty(string)) {
        }
    }

    private static void showErrorToastLowMemory(Context context, boolean z) {
        if (z) {
            ToastHandler.show(context, DialogUtils.getNotEnoughStorageString(context), 0);
        } else {
            StorageChecker.showErrorDialog(context, 1);
        }
    }

    private static void showErrorToastOverSize(Context context, boolean z, long j) {
        Logger.m10999d(TAG, "showErrorToastOverSize# " + j);
        if (z) {
            ToastHandler.show(context, DialogUtils.getOverSizeString(context, j), 0);
        } else {
            StorageChecker.showErrorDialog(context, 2, j);
        }
    }
}
