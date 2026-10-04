package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.microsoft.identity.common.C6228R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SmartcardNfcLoadingDialog extends SmartcardDialog {
    public SmartcardNfcLoadingDialog(@NonNull Activity activity) {
        super(activity);
        createDialog();
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardDialog
    public void createDialog() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardNfcLoadingDialog.1
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialogCreate = new AlertDialog.Builder(SmartcardNfcLoadingDialog.this.mActivity, C6228R.style.UserChoiceAlertDialogTheme).setTitle(C6228R.string.smartcard_nfc_loading_dialog_title).setMessage(C6228R.string.smartcard_nfc_loading_dialog_message).setView(SmartcardNfcLoadingDialog.this.mActivity.getLayoutInflater().inflate(C6228R.layout.nfc_loading_layout, (ViewGroup) null)).create();
                alertDialogCreate.setCanceledOnTouchOutside(false);
                SmartcardNfcLoadingDialog.this.mDialog = alertDialogCreate;
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardDialog
    public void onUnexpectedUnplug() {
    }
}
