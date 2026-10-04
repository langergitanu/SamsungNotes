package com.samsung.android.support.senl.p148nt.app.lock.view.convert;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.support.senl.document.memoconverter.SNBConverter;
import com.samsung.android.support.senl.document.memoconverter.SPDConverter;
import com.samsung.android.support.senl.document.memoconverter.TMemo2Converter;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.convert.WrappedLockFileController;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.VerifyPasswordDialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class VerifyConvertPasswordDialog extends VerifyPasswordDialogFragment {
    private static final String KEY_IS_WRAPPED_NOTE = "mNotesUuid";
    private boolean mIsWrappedNote;
    private ResultListener mResultListener;
    public static final String TAG = "VerifyConvertPasswordDialog";
    private static final String LOG_TAG = LockLogger.createTag(TAG);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ResultListener {
        void onResult(String str, String str2);
    }

    public VerifyConvertPasswordDialog() {
        this.mIsWrappedNote = false;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.VerifyPasswordDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        ResultListener resultListener = this.mResultListener;
        if (resultListener != null) {
            resultListener.onResult("", "");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.VerifyPasswordDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        if (bundle != null) {
            this.mIsWrappedNote = bundle.getBoolean(KEY_IS_WRAPPED_NOTE);
        }
        this.mTitle = getString(C8003R.string.convert_dialog_unlock_snote_file);
        this.mInfoStr = getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.convert_dialog_unlock_snote_file_help_jp : C8003R.string.convert_dialog_unlock_snote_file_help);
        this.mHintStr = getString(C8003R.string.convert_dialog_unlock_snote_password);
        this.mDoneClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.convert.VerifyConvertPasswordDialog.1
            WrappedLockFileController wrappedLockFileController = null;

            private void passwordVerifyFail() {
                VerifyConvertPasswordDialog.this.setNotMatchPassword();
                releaseWrappedLockFileController();
            }

            private void passwordVerifySuccess(String str, String str2) {
                VerifyConvertPasswordDialog.this.dismiss();
                releaseWrappedLockFileController();
                if (VerifyConvertPasswordDialog.this.mResultListener != null) {
                    VerifyConvertPasswordDialog.this.mResultListener.onResult(str, str2);
                }
            }

            private void releaseWrappedLockFileController() {
                WrappedLockFileController wrappedLockFileController = this.wrappedLockFileController;
                if (wrappedLockFileController != null) {
                    wrappedLockFileController.release();
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommonSamsungAnalytics.insertLog("715", "7153");
                String string = VerifyConvertPasswordDialog.this.getArguments().getString("doc_path", null);
                int i = VerifyConvertPasswordDialog.this.getArguments().getInt(ComposerConstants.ARG_LOCK_TYPE, 0);
                if (VerifyConvertPasswordDialog.this.mIsWrappedNote) {
                    WrappedLockFileController wrappedLockFileController = new WrappedLockFileController(VerifyConvertPasswordDialog.this.getContext(), string);
                    this.wrappedLockFileController = wrappedLockFileController;
                    string = wrappedLockFileController.getFilePath();
                }
                String string2 = ((VerifyPasswordDialogFragment) VerifyConvertPasswordDialog.this).mEditText.getText().toString();
                if (i == 2) {
                    try {
                        if (new SPDConverter(VerifyConvertPasswordDialog.this.getContext()).isRightPassword(string, string2)) {
                            passwordVerifySuccess(string, string2);
                        } else {
                            passwordVerifyFail();
                        }
                        return;
                    } catch (SpenUnsupportedTypeException unused) {
                        LockLogger.m7356d(VerifyConvertPasswordDialog.LOG_TAG, "SpenUnsupportedTypeException");
                        return;
                    } catch (IOException unused2) {
                        LockLogger.m7356d(VerifyConvertPasswordDialog.LOG_TAG, "IOException");
                        return;
                    }
                }
                if (i == 3) {
                    if (new SNBConverter(VerifyConvertPasswordDialog.this.getContext()).isRightPassword(string, string2)) {
                        passwordVerifySuccess(string, string2);
                        return;
                    } else {
                        passwordVerifyFail();
                        return;
                    }
                }
                try {
                    if (new TMemo2Converter(VerifyConvertPasswordDialog.this.getContext()).isRightPassword(string, string2)) {
                        passwordVerifySuccess(string, string2);
                    } else {
                        passwordVerifyFail();
                    }
                } catch (IOException unused3) {
                    LockLogger.m7356d(VerifyConvertPasswordDialog.LOG_TAG, "IOException");
                }
            }
        };
        this.mCancelClickListener = new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.convert.VerifyConvertPasswordDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                CommonSamsungAnalytics.insertLog("715", "7152");
                VerifyConvertPasswordDialog.this.dismiss();
                if (VerifyConvertPasswordDialog.this.mResultListener != null) {
                    VerifyConvertPasswordDialog.this.mResultListener.onResult("", "");
                }
            }
        };
        return super.onCreateDialog(bundle);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.VerifyPasswordDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (getContext() != null) {
            InputMethodCompat.getInstance().forceHideSoftInput(getContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        EditText editText = this.mEditText;
        if (editText != null) {
            editText.requestFocus();
        }
        super.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(KEY_IS_WRAPPED_NOTE, this.mIsWrappedNote);
    }

    public void setOnResultListener(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    public VerifyConvertPasswordDialog(boolean z) {
        this.mIsWrappedNote = z;
    }
}
