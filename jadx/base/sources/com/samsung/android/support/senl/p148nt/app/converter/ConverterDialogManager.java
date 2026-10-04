package com.samsung.android.support.senl.p148nt.app.converter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.dialog.AppUpdateDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.lock.view.convert.VerifyConvertPasswordDialog;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ConverterDialogManager {
    private static final String TAG = "ConverterDialogManager";
    private final WeakReference<FragmentActivity> mActivityWeakRef;
    private final int mCallerId;
    private boolean mIsOKClickInSaveConfirmDialog = false;
    private IDialogListener mListener;
    private DialogUtils.ProgressDialogFragment mProgressDialog;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IDialogListener {
        void onCancel();

        void requestConvert(String str, String str2);
    }

    public ConverterDialogManager(FragmentActivity fragmentActivity, int i) {
        this.mActivityWeakRef = new WeakReference<>(fragmentActivity);
        this.mCallerId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showProgressDialog$0(DialogInterface dialogInterface) {
        Logger.m8697d(TAG, "ProgressDialog, cancel");
        ConvertTaskManager.getInstance().cancel(this.mCallerId, -1);
        dismiss();
        notifyOnCancelListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnCancelListener() {
        IDialogListener iDialogListener = this.mListener;
        if (iDialogListener != null) {
            iDialogListener.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRequestConvertListener(String str, String str2) {
        IDialogListener iDialogListener = this.mListener;
        if (iDialogListener != null) {
            iDialogListener.requestConvert(str, str2);
        }
    }

    public void dismiss() {
        DialogUtils.ProgressDialogFragment progressDialogFragment = this.mProgressDialog;
        if (progressDialogFragment == null || !progressDialogFragment.isShowing() || CommonUtil.isNotAvailableActivity(this.mActivityWeakRef.get())) {
            return;
        }
        this.mProgressDialog.dismissAllowingStateLoss();
        Logger.m8697d(TAG, "dismiss");
    }

    public boolean isProgressDialogShowing() {
        DialogUtils.ProgressDialogFragment progressDialogFragment = this.mProgressDialog;
        return progressDialogFragment != null && progressDialogFragment.isShowing();
    }

    public void setListener(IDialogListener iDialogListener) {
        this.mListener = iDialogListener;
    }

    public void showAppUpdateDialog(AppUpdateDialogFragment.AppUpdateDialogListener appUpdateDialogListener) {
        Logger.m8702i(TAG, "showAppUpdateDialog");
        FragmentActivity fragmentActivity = this.mActivityWeakRef.get();
        if (CommonUtil.isNotAvailableActivity(fragmentActivity)) {
            Logger.m8697d(TAG, "showAppUpdateDialog, activity is in invalid status");
            return;
        }
        AppUpdateDialogFragment appUpdateDialogFragment = (AppUpdateDialogFragment) fragmentActivity.getSupportFragmentManager().findFragmentByTag(AppUpdateDialogFragment.FOR_UNSUPPORTED_FORMAT_IMPORT);
        if (appUpdateDialogFragment != null && appUpdateDialogFragment.isResumed() && appUpdateDialogFragment.isAdded()) {
            Logger.m8702i(TAG, "showAppUpdateDialog# already showing");
            return;
        }
        AppUpdateDialogFragment appUpdateDialogFragment2 = new AppUpdateDialogFragment();
        appUpdateDialogFragment2.setDialogListener(appUpdateDialogListener);
        appUpdateDialogFragment2.showAllowingStateLoss(fragmentActivity.getSupportFragmentManager(), AppUpdateDialogFragment.FOR_UNSUPPORTED_FORMAT_IMPORT);
    }

    public void showConvertProgressDialog() {
        Logger.m8697d(TAG, "showConvertProgressDialog");
        showProgressDialog(this.mActivityWeakRef.get().getResources().getString(C8003R.string.base_string_converting));
    }

    public boolean showImportProgressDialog() {
        Logger.m8697d(TAG, "showImportProgressDialog");
        return showProgressDialog(this.mActivityWeakRef.get().getResources().getString(C8003R.string.base_string_importing));
    }

    public void showPasswordDialog(String str, int i, boolean z) {
        DialogFragment dialogFragment = (DialogFragment) this.mActivityWeakRef.get().getSupportFragmentManager().findFragmentByTag(VerifyConvertPasswordDialog.TAG);
        if (dialogFragment != null) {
            Logger.m8697d(TAG, "showPasswordDialog");
            dialogFragment.dismissAllowingStateLoss();
        }
        VerifyConvertPasswordDialog verifyConvertPasswordDialog = new VerifyConvertPasswordDialog(z);
        Bundle bundle = new Bundle();
        bundle.putString("doc_path", str);
        bundle.putInt(ComposerConstants.ARG_LOCK_TYPE, i);
        verifyConvertPasswordDialog.setArguments(bundle);
        verifyConvertPasswordDialog.setOnResultListener(new VerifyConvertPasswordDialog.ResultListener() { // from class: com.samsung.android.support.senl.nt.app.converter.ConverterDialogManager.1
            @Override // com.samsung.android.support.senl.nt.app.lock.view.convert.VerifyConvertPasswordDialog.ResultListener
            public void onResult(final String str2, final String str3) {
                Logger.m8697d(ConverterDialogManager.TAG, "showPasswordDialog$onResult");
                ((FragmentActivity) ConverterDialogManager.this.mActivityWeakRef.get()).runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.converter.ConverterDialogManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!TextUtils.isEmpty(str2)) {
                            ConverterDialogManager.this.notifyRequestConvertListener(str2, str3);
                            return;
                        }
                        Logger.m8697d(ConverterDialogManager.TAG, "ResultListener, file path is empty.");
                        ConverterDialogManager.this.dismiss();
                        ConverterDialogManager.this.notifyOnCancelListener();
                    }
                });
            }
        });
        verifyConvertPasswordDialog.show(this.mActivityWeakRef.get().getSupportFragmentManager(), VerifyConvertPasswordDialog.TAG);
    }

    public boolean showPdfCheckerProgressDialog() {
        Logger.m8697d(TAG, "showPdfCheckerProgressDialog");
        return showProgressDialog("");
    }

    public boolean showProgressDialog(String str) {
        FragmentActivity fragmentActivity = this.mActivityWeakRef.get();
        if (CommonUtil.isNotAvailableActivity(fragmentActivity)) {
            Logger.m8697d(TAG, "showProgressDialog, activity is in invalid status");
            return false;
        }
        DialogUtils.ProgressDialogFragment progressDialogFragment = (DialogUtils.ProgressDialogFragment) DialogUtils.createProgressDialogFragment();
        this.mProgressDialog = progressDialogFragment;
        progressDialogFragment.setTextInProgressDialog(str);
        this.mProgressDialog.setCancelable(true);
        this.mProgressDialog.setCanceledOnTouchOutside(false);
        this.mProgressDialog.setOnCancelListener(new DialogInterfaceOnCancelListenerC8050a(this, 0));
        this.mProgressDialog.showAllowingStateLoss(fragmentActivity.getSupportFragmentManager(), TAG);
        return true;
    }

    public void showSaveConfirmDialog(final String str) {
        this.mActivityWeakRef.get();
        this.mIsOKClickInSaveConfirmDialog = false;
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(this.mActivityWeakRef.get());
        alertDialogBuilderForAppCompat.setTitle(C8003R.string.save_in_notes).setMessage(this.mActivityWeakRef.get().getResources().getString(C8003R.string.save_in_notes_description)).setPositiveButton(this.mActivityWeakRef.get().getResources().getString(C8003R.string.string_save_full), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.converter.ConverterDialogManager.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Logger.m8697d(ConverterDialogManager.TAG, "ConfirmDialog#, save");
                ConverterDialogManager.this.mIsOKClickInSaveConfirmDialog = true;
                dialogInterface.dismiss();
                ConverterDialogManager.this.notifyRequestConvertListener(str, null);
            }
        }).setNeutralButton(this.mActivityWeakRef.get().getResources().getString(C8003R.string.string_cancel), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.converter.ConverterDialogManager.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Logger.m8697d(ConverterDialogManager.TAG, "ConfirmDialog, cancel");
                dialogInterface.dismiss();
                ConverterDialogManager.this.dismiss();
                ConverterDialogManager.this.notifyOnCancelListener();
            }
        });
        alertDialogBuilderForAppCompat.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.app.converter.ConverterDialogManager.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (ConverterDialogManager.this.mIsOKClickInSaveConfirmDialog) {
                    return;
                }
                ((FragmentActivity) ConverterDialogManager.this.mActivityWeakRef.get()).finish();
            }
        });
        alertDialogBuilderForAppCompat.show();
    }
}
