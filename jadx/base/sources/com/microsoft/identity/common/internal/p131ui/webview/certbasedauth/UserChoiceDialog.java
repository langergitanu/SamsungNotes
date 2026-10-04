package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.microsoft.identity.common.C6228R;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class UserChoiceDialog extends SmartcardDialog {
    private final ICancelCbaCallback mCancelCbaCallback;
    private final PositiveButtonListener mPositiveButtonListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PositiveButtonListener {
        void onClick(int i);
    }

    public UserChoiceDialog(@NonNull PositiveButtonListener positiveButtonListener, @NonNull ICancelCbaCallback iCancelCbaCallback, @NonNull Activity activity) {
        super(activity);
        this.mPositiveButtonListener = positiveButtonListener;
        this.mCancelCbaCallback = iCancelCbaCallback;
        createDialog();
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardDialog
    public void createDialog() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mActivity.getResources().getString(C6228R.string.user_choice_dialog_on_device_name));
        arrayList.add(this.mActivity.getResources().getString(C6228R.string.user_choice_dialog_smartcard_name));
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.mActivity, C6228R.style.UserChoiceAlertDialogTheme).setTitle(C6228R.string.user_choice_dialog_title).setSingleChoiceItems((String[]) Arrays.copyOf(arrayList.toArray(), arrayList.size(), String[].class), 0, (DialogInterface.OnClickListener) null).setPositiveButton(C6228R.string.user_choice_dialog_positive_button, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UserChoiceDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UserChoiceDialog.this.mPositiveButtonListener.onClick(((AlertDialog) dialogInterface).getListView().getCheckedItemPosition());
            }
        }).setNegativeButton(C6228R.string.user_choice_dialog_negative_button, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UserChoiceDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UserChoiceDialog.this.mCancelCbaCallback.onCancel();
            }
        }).create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UserChoiceDialog.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UserChoiceDialog.this.mCancelCbaCallback.onCancel();
            }
        });
        this.mDialog = alertDialogCreate;
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.SmartcardDialog
    public void onUnexpectedUnplug() {
    }
}
