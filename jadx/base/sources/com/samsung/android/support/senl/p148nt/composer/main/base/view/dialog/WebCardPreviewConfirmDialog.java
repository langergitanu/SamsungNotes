package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class WebCardPreviewConfirmDialog {
    private static final String TAG = Logger.createTag("WebCardPreviewConfirmDialog");

    public WebCardPreviewConfirmDialog(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
        if (CommonUtil.isNotAvailableActivity(activity)) {
            Logger.m11000e(TAG, "WebCardPreviewConfirmDialog# activity is invalid");
            return;
        }
        Logger.m11003i(TAG, "WebCardPreviewConfirmDialog#");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, C9086R.style.NoteAlertDialogThemeForAppCompat);
        builder.setMessage(activity.getResources().getString(C9086R.string.show_web_preview));
        if (onClickListener != null) {
            builder.setPositiveButton(activity.getResources().getString(C9086R.string.show_web_preview_dialog_positive), onClickListener);
        }
        if (onClickListener2 != null) {
            builder.setNegativeButton(activity.getResources().getString(C9086R.string.dialog_cancel), onClickListener2);
        }
        if (onDismissListener != null) {
            builder.setOnDismissListener(onDismissListener);
        }
        AlertDialog alertDialogCreate = builder.create();
        if (alertDialogCreate.getWindow() != null) {
            alertDialogCreate.getWindow().setGravity(80);
        }
        alertDialogCreate.show();
    }
}
