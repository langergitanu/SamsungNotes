package com.samsung.android.support.senl.p148nt.app.common.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class BtnProgressDialogFragment extends DialogFragment {
    public static final String DB_RESTORE_DIALOG = "db_restore_dialog";
    private static final String DIALOG_TYPE = "dialog_type";
    public static final String INSTALL_ADDONS_DIALOG = "install_addons_dialog";
    public static final String RECOMMEND_CONVERT_DIALOG = "recommend_convert_dialog";
    private static final String TAG = "BtnProgressDialogFragment";
    public static final String UPDATE_ADDONS_DIALOG = "update_addons_dialog";
    private AlertDialog mAlertDialog;
    private IAddonsInstallDialog mContract;
    private String mDialogType;
    private boolean mIsProgressOn;
    private final DialogInterface.OnKeyListener mOnKeyListener;
    private final DialogInterface.OnShowListener mOnShowListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IAddonsInstallDialog {
        void onBackPressed();

        void onCancel(String str);

        void onConfirm(String str);
    }

    public BtnProgressDialogFragment() {
        this.mIsProgressOn = false;
        this.mOnShowListener = new DialogInterface.OnShowListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (BtnProgressDialogFragment.this.mIsProgressOn) {
                    BtnProgressDialogFragment.this.replaceBtnToProgress();
                } else {
                    BtnProgressDialogFragment.this.mAlertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (BtnProgressDialogFragment.this.mContract == null) {
                                return;
                            }
                            BtnProgressDialogFragment.this.mContract.onConfirm(BtnProgressDialogFragment.this.mDialogType);
                            BtnProgressDialogFragment.this.replaceBtnToProgress();
                        }
                    });
                    BtnProgressDialogFragment.this.mAlertDialog.getButton(-2).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.1.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (BtnProgressDialogFragment.this.mContract == null) {
                                return;
                            }
                            BtnProgressDialogFragment.this.dismissAllowingStateLoss();
                            BtnProgressDialogFragment.this.mContract.onCancel(BtnProgressDialogFragment.this.mDialogType);
                        }
                    });
                }
            }
        };
        this.mOnKeyListener = new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1 || BtnProgressDialogFragment.this.mContract == null) {
                    return false;
                }
                BtnProgressDialogFragment.this.mContract.onBackPressed();
                return false;
            }
        };
    }

    private String getMessage() {
        boolean zIsSecBrandAsGalaxy;
        String string;
        zIsSecBrandAsGalaxy = CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy();
        string = getString(zIsSecBrandAsGalaxy ? C8003R.string.notes_jp : C8003R.string.notes);
        String str = this.mDialogType;
        str.getClass();
        switch (str) {
            case "install_addons_dialog":
                return getResources().getString(C8003R.string.install_addons_message, string);
            case "update_addons_dialog":
                return getResources().getString(C8003R.string.update_addons_message, string);
            case "db_restore_dialog":
                return getResources().getString(C8003R.string.db_restore_dialog_message);
            case "recommend_convert_dialog":
                return getResources().getString(zIsSecBrandAsGalaxy ? C8003R.string.convert_note_jp_desctiption : C8003R.string.convert_note_description);
            default:
                MainLogger.m7255e(TAG, "getMessage# DialogType: " + this.mDialogType + " do not need message");
                return "";
        }
    }

    @StringRes
    private int getPositiveBtnRes() {
        String str = this.mDialogType;
        str.getClass();
        switch (str) {
            case "install_addons_dialog":
                return C8003R.string.dialog_install;
            case "update_addons_dialog":
                return C8003R.string.dialog_update;
            case "db_restore_dialog":
                return C8003R.string.action_restore;
            case "recommend_convert_dialog":
                return C8003R.string.convert;
            default:
                MainLogger.m7255e(TAG, "getPositiveBtnRes# DialogType: " + this.mDialogType + " do not need positiveBtnRes");
                return -1;
        }
    }

    private String getTitle() {
        String str = this.mDialogType;
        str.getClass();
        switch (str) {
            case "install_addons_dialog":
                return getResources().getString(C8003R.string.install_addons_title, getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.notes_jp : C8003R.string.notes));
            case "db_restore_dialog":
                return getResources().getString(C8003R.string.db_restore_dialog_title);
            case "recommend_convert_dialog":
                return getResources().getString(C8003R.string.convert_note_title);
            default:
                MainLogger.m7254d(TAG, "getTitle# DialogType: " + this.mDialogType + " do not need title");
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceBtnToProgress() {
        if (isAdded()) {
            this.mIsProgressOn = true;
            Button button = this.mAlertDialog.getButton(-1);
            Button button2 = this.mAlertDialog.getButton(-2);
            if (button == null || button2 == null) {
                return;
            }
            this.mAlertDialog.setCanceledOnTouchOutside(false);
            this.mAlertDialog.setCancelable(false);
            button.setEnabled(false);
            if (!DB_RESTORE_DIALOG.equals(this.mDialogType)) {
                button2.setEnabled(false);
            }
            DialogUtils.replaceBtnToProgress(button);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.mIsProgressOn = bundle.getBoolean(NotesConstants.DialogTag.KEY_IS_PROGRESS_ON);
            this.mDialogType = bundle.getString("dialog_type");
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity()).setTitle(getTitle()).setMessage(getMessage()).setCancelable(true).setPositiveButton(getPositiveBtnRes(), (DialogInterface.OnClickListener) null).setNegativeButton(C8003R.string.dialog_cancel, (DialogInterface.OnClickListener) null).create();
        this.mAlertDialog = alertDialogCreate;
        alertDialogCreate.setOnShowListener(this.mOnShowListener);
        this.mAlertDialog.setOnKeyListener(this.mOnKeyListener);
        return this.mAlertDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(NotesConstants.DialogTag.KEY_IS_PROGRESS_ON, this.mIsProgressOn);
        bundle.putString("dialog_type", this.mDialogType);
    }

    public void setContract(IAddonsInstallDialog iAddonsInstallDialog) {
        this.mContract = iAddonsInstallDialog;
    }

    public void showAllowingStateLoss(FragmentManager fragmentManager, String str) {
        if (fragmentManager == null || fragmentManager.isDestroyed() || isAdded()) {
            return;
        }
        fragmentManager.beginTransaction().add(this, str).commitAllowingStateLoss();
    }

    public BtnProgressDialogFragment(String str, boolean z) {
        this.mIsProgressOn = false;
        this.mOnShowListener = new DialogInterface.OnShowListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (BtnProgressDialogFragment.this.mIsProgressOn) {
                    BtnProgressDialogFragment.this.replaceBtnToProgress();
                } else {
                    BtnProgressDialogFragment.this.mAlertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (BtnProgressDialogFragment.this.mContract == null) {
                                return;
                            }
                            BtnProgressDialogFragment.this.mContract.onConfirm(BtnProgressDialogFragment.this.mDialogType);
                            BtnProgressDialogFragment.this.replaceBtnToProgress();
                        }
                    });
                    BtnProgressDialogFragment.this.mAlertDialog.getButton(-2).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.1.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (BtnProgressDialogFragment.this.mContract == null) {
                                return;
                            }
                            BtnProgressDialogFragment.this.dismissAllowingStateLoss();
                            BtnProgressDialogFragment.this.mContract.onCancel(BtnProgressDialogFragment.this.mDialogType);
                        }
                    });
                }
            }
        };
        this.mOnKeyListener = new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.BtnProgressDialogFragment.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1 || BtnProgressDialogFragment.this.mContract == null) {
                    return false;
                }
                BtnProgressDialogFragment.this.mContract.onBackPressed();
                return false;
            }
        };
        this.mDialogType = str;
        this.mIsProgressOn = z;
    }
}
