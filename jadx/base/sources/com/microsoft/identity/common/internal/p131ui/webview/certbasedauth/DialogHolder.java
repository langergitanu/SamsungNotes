package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.microsoft.identity.common.C6228R;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardCertPickerDialog;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardPinDialog;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.UserChoiceDialog;
import java.util.List;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class DialogHolder implements IDialogHolder {
    private final Activity mActivity;
    private SmartcardDialog mCurrentDialog = null;

    public DialogHolder(@NonNull Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    public synchronized void dismissDialog() {
        showDialog(null);
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    public synchronized boolean isDialogShowing() {
        return this.mCurrentDialog != null;
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    public synchronized boolean isSmartcardRemovalPromptDialogShowing() {
        return this.mCurrentDialog instanceof SmartcardRemovalPromptDialog;
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    public synchronized void onUnexpectedUnplug() {
        SmartcardDialog smartcardDialog = this.mCurrentDialog;
        if (smartcardDialog != null) {
            smartcardDialog.onUnexpectedUnplug();
        }
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    @RequiresApi(api = 21)
    public synchronized void setPinDialogErrorMode() {
        SmartcardDialog smartcardDialog = this.mCurrentDialog;
        if (smartcardDialog instanceof SmartcardPinDialog) {
            ((SmartcardPinDialog) smartcardDialog).setErrorMode();
        }
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    public synchronized void showCertPickerDialog(@NonNull List<ICertDetails> list, @NonNull SmartcardCertPickerDialog.PositiveButtonListener positiveButtonListener, @NonNull ICancelCbaCallback iCancelCbaCallback) {
        showDialog(new SmartcardCertPickerDialog(list, positiveButtonListener, iCancelCbaCallback, this.mActivity));
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    public synchronized void showDialog(@Nullable SmartcardDialog smartcardDialog) {
        try {
            SmartcardDialog smartcardDialog2 = this.mCurrentDialog;
            if (smartcardDialog2 != null) {
                smartcardDialog2.dismiss();
            }
            this.mCurrentDialog = smartcardDialog;
            if (smartcardDialog != null) {
                smartcardDialog.show();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    public synchronized void showErrorDialog(int i, int i2) {
        showDialog(new SmartcardErrorDialog(i, i2, C6228R.string.smartcard_error_dialog_positive_button, new IDismissCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.DialogHolder.1
            @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDismissCallback
            public void onDismiss() {
                DialogHolder.this.dismissDialog();
            }
        }, this.mActivity));
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    public synchronized void showPinDialog(@NonNull SmartcardPinDialog.PositiveButtonListener positiveButtonListener, @NonNull ICancelCbaCallback iCancelCbaCallback) {
        showDialog(new SmartcardPinDialog(positiveButtonListener, iCancelCbaCallback, this.mActivity));
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    public synchronized void showSmartcardNfcLoadingDialog() {
        showDialog(new SmartcardNfcLoadingDialog(this.mActivity));
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    public synchronized void showSmartcardNfcPromptDialog(@NonNull ICancelCbaCallback iCancelCbaCallback) {
        showDialog(new SmartcardNfcPromptDialog(iCancelCbaCallback, this.mActivity));
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    public synchronized void showSmartcardNfcReminderDialog(@NonNull IDismissCallback iDismissCallback) {
        showDialog(new SmartcardNfcReminderDialog(iDismissCallback, this.mActivity));
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    public synchronized void showSmartcardPromptDialog(@NonNull ICancelCbaCallback iCancelCbaCallback) {
        showDialog(new SmartcardPromptDialog(iCancelCbaCallback, this.mActivity));
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    public synchronized void showSmartcardRemovalPromptDialog(@Nullable final IDismissCallback iDismissCallback) {
        showDialog(new SmartcardRemovalPromptDialog(new IDismissCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.DialogHolder.3
            @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDismissCallback
            public void onDismiss() {
                DialogHolder.this.dismissDialog();
                IDismissCallback iDismissCallback2 = iDismissCallback;
                if (iDismissCallback2 != null) {
                    iDismissCallback2.onDismiss();
                }
            }
        }, this.mActivity));
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    public synchronized void showUserChoiceDialog(@NonNull UserChoiceDialog.PositiveButtonListener positiveButtonListener, @NonNull ICancelCbaCallback iCancelCbaCallback) {
        showDialog(new UserChoiceDialog(positiveButtonListener, iCancelCbaCallback, this.mActivity));
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDialogHolder
    public synchronized void showErrorDialog(int i, int i2, int i4) {
        showDialog(new SmartcardErrorDialog(i, i2, i4, new IDismissCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.DialogHolder.2
            @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.IDismissCallback
            public void onDismiss() {
                DialogHolder.this.dismissDialog();
            }
        }, this.mActivity));
    }
}
