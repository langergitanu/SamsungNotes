package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardCertPickerDialog;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardPinDialog;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.UserChoiceDialog;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IDialogHolder {
    void dismissDialog();

    boolean isDialogShowing();

    boolean isSmartcardRemovalPromptDialogShowing();

    void onUnexpectedUnplug();

    void setPinDialogErrorMode();

    void showCertPickerDialog(@NonNull List<ICertDetails> list, @NonNull SmartcardCertPickerDialog.PositiveButtonListener positiveButtonListener, @NonNull ICancelCbaCallback iCancelCbaCallback);

    void showDialog(@Nullable SmartcardDialog smartcardDialog);

    void showErrorDialog(int i, int i2);

    void showErrorDialog(int i, int i2, int i4);

    void showPinDialog(@NonNull SmartcardPinDialog.PositiveButtonListener positiveButtonListener, @NonNull ICancelCbaCallback iCancelCbaCallback);

    void showSmartcardNfcLoadingDialog();

    void showSmartcardNfcPromptDialog(@NonNull ICancelCbaCallback iCancelCbaCallback);

    void showSmartcardNfcReminderDialog(@NonNull IDismissCallback iDismissCallback);

    void showSmartcardPromptDialog(@NonNull ICancelCbaCallback iCancelCbaCallback);

    void showSmartcardRemovalPromptDialog(@Nullable IDismissCallback iDismissCallback);

    void showUserChoiceDialog(@NonNull UserChoiceDialog.PositiveButtonListener positiveButtonListener, @NonNull ICancelCbaCallback iCancelCbaCallback);
}
