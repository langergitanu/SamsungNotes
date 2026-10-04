package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import com.microsoft.identity.common.C6228R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SmartcardRemovalPromptDialog extends SmartcardDialog {
    private final IDismissCallback mDismissCallback;

    public SmartcardRemovalPromptDialog(@NonNull IDismissCallback iDismissCallback, @NonNull Activity activity) {
        super(activity);
        this.mDismissCallback = iDismissCallback;
        createDialog();
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardDialog
    public void createDialog() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardRemovalPromptDialog.1
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialogCreate = new AlertDialog.Builder(SmartcardRemovalPromptDialog.this.mActivity, C6228R.style.TitleOnlyAlertDialogTheme).setTitle(C6228R.string.smartcard_removal_prompt_dialog_title).setPositiveButton(C6228R.string.smartcard_removal_prompt_dialog_positive_button, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardRemovalPromptDialog.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SmartcardRemovalPromptDialog.this.mDismissCallback.onDismiss();
                    }
                }).create();
                alertDialogCreate.setCanceledOnTouchOutside(false);
                SmartcardRemovalPromptDialog.this.mDialog = alertDialogCreate;
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardDialog
    public void onUnexpectedUnplug() {
        this.mDismissCallback.onDismiss();
    }
}
