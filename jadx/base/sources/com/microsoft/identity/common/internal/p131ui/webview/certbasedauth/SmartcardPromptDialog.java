package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.microsoft.identity.common.C6228R;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SmartcardPromptDialog extends SmartcardDialog {
    private final ICancelCbaCallback mCancelCbaCallback;

    public SmartcardPromptDialog(@NonNull ICancelCbaCallback iCancelCbaCallback, @NonNull Activity activity) {
        super(activity);
        if (iCancelCbaCallback == null) {
            throw new NullPointerException("cancelCbaCallback is marked non-null but is null");
        }
        if (activity == null) {
            throw new NullPointerException("activity is marked non-null but is null");
        }
        this.mCancelCbaCallback = iCancelCbaCallback;
        createDialog();
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardDialog
    public void createDialog() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardPromptDialog.1
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialogCreate = new AlertDialog.Builder(SmartcardPromptDialog.this.mActivity, C6228R.style.UserChoiceAlertDialogTheme).setTitle(C6228R.string.smartcard_prompt_dialog_title).setMessage(C6228R.string.smartcard_prompt_dialog_message).setNegativeButton(C6228R.string.smartcard_prompt_dialog_negative_button, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardPromptDialog.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SmartcardPromptDialog.this.mCancelCbaCallback.onCancel();
                    }
                }).create();
                alertDialogCreate.setCanceledOnTouchOutside(false);
                alertDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardPromptDialog.1.2
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        SmartcardPromptDialog.this.mCancelCbaCallback.onCancel();
                    }
                });
                SmartcardPromptDialog.this.mDialog = alertDialogCreate;
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardDialog
    public void onUnexpectedUnplug() {
        this.mCancelCbaCallback.onCancel();
    }
}
