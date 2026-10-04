package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.microsoft.identity.common.C6228R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SmartcardNfcReminderDialog extends SmartcardDialog {
    private final IDismissCallback mDismissCallback;

    public SmartcardNfcReminderDialog(@NonNull IDismissCallback iDismissCallback, @NonNull Activity activity) {
        super(activity);
        this.mDismissCallback = iDismissCallback;
        createDialog();
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardDialog
    public void createDialog() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardNfcReminderDialog.1
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialogCreate = new AlertDialog.Builder(SmartcardNfcReminderDialog.this.mActivity, C6228R.style.UserChoiceAlertDialogTheme).setTitle(C6228R.string.smartcard_nfc_reminder_dialog_title).setMessage(C6228R.string.smartcard_nfc_reminder_dialog_message).setPositiveButton(C6228R.string.smartcard_nfc_reminder_dialog_positive_button, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardNfcReminderDialog.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SmartcardNfcReminderDialog.this.mDismissCallback.onDismiss();
                    }
                }).create();
                alertDialogCreate.setCanceledOnTouchOutside(false);
                alertDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardNfcReminderDialog.1.2
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        SmartcardNfcReminderDialog.this.mDismissCallback.onDismiss();
                    }
                });
                SmartcardNfcReminderDialog.this.mDialog = alertDialogCreate;
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardDialog
    public void onUnexpectedUnplug() {
    }
}
