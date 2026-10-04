package com.samsung.android.support.senl.p148nt.app.main.common.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ConfirmDialogFragment extends AbsDialogFragment implements DialogInterface.OnClickListener {
    protected AlertDialog mAlertDialog;
    protected int mCheckCount;
    private IConfirmDialogResultListener mConfirmDialogResultListener;
    protected String mFolderUuid;
    protected int mMessageResID;
    protected int mNegativeResId;
    protected boolean mPlurals;
    protected int mPositiveResId;
    protected int mTitleResID;

    public ConfirmDialogFragment() {
        this.mPositiveResId = C8003R.string.f6004OK;
        this.mNegativeResId = C8003R.string.dialog_cancel;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        IConfirmDialogResultListener iConfirmDialogResultListener;
        IConfirmDialogResultListener iConfirmDialogResultListener2;
        if (i == -1 && (iConfirmDialogResultListener2 = this.mConfirmDialogResultListener) != null) {
            iConfirmDialogResultListener2.onConfirm(this.mFolderUuid);
        } else {
            if (i != -2 || (iConfirmDialogResultListener = this.mConfirmDialogResultListener) == null) {
                return;
            }
            iConfirmDialogResultListener.onCancel();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(Bundle bundle) {
        String string;
        super.onCreateDialog(bundle);
        if (bundle != null) {
            this.mTitleResID = bundle.getInt(NotesConstants.DialogTag.KEY_SINGLE_MESSAGE);
            this.mMessageResID = bundle.getInt(NotesConstants.DialogTag.KEY_MULTIPLE_MESSAGE);
            this.mCheckCount = bundle.getInt(NotesConstants.DialogTag.KEY_CHECK_COUNT);
            this.mPositiveResId = bundle.getInt(NotesConstants.DialogTag.KEY_POSITIVVE_RES_ID);
            this.mNegativeResId = bundle.getInt(NotesConstants.DialogTag.KEY_NEGATIVE_RES_ID);
            this.mFolderUuid = bundle.getString("folder_uuid");
            this.mPlurals = bundle.getBoolean(NotesConstants.DialogTag.KEY_PLURALS);
        }
        String string2 = this.mTitleResID != 0 ? getResources().getString(this.mTitleResID) : "";
        if (this.mPlurals) {
            Resources resources = getResources();
            int i = this.mMessageResID;
            int i2 = this.mCheckCount;
            string = resources.getQuantityString(i, i2, Integer.valueOf(i2));
        } else if (this.mCheckCount == 1) {
            string = getResources().getString(this.mMessageResID);
        } else {
            string2 = getResources().getString(this.mTitleResID, Integer.valueOf(this.mCheckCount));
            string = getResources().getString(this.mMessageResID, Integer.valueOf(this.mCheckCount));
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity()).setTitle(string2).setMessage(string).setCancelable(true).setPositiveButton(this.mPositiveResId, this).setNegativeButton(this.mNegativeResId, this).create();
        this.mAlertDialog = alertDialogCreate;
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.ConfirmDialogFragment.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button button = ConfirmDialogFragment.this.mAlertDialog.getButton(-1);
                if (FloatingFeature.INSTANCE.getInstance().isDisableRecycleBinModel()) {
                    button.setTextColor(button.getResources().getColor(C8003R.color.basic_dialog_button_red_color, null));
                }
            }
        });
        return this.mAlertDialog;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(NotesConstants.DialogTag.KEY_SINGLE_MESSAGE, this.mTitleResID);
        bundle.putInt(NotesConstants.DialogTag.KEY_MULTIPLE_MESSAGE, this.mMessageResID);
        bundle.putInt(NotesConstants.DialogTag.KEY_CHECK_COUNT, this.mCheckCount);
        bundle.putInt(NotesConstants.DialogTag.KEY_POSITIVVE_RES_ID, this.mPositiveResId);
        bundle.putInt(NotesConstants.DialogTag.KEY_NEGATIVE_RES_ID, this.mNegativeResId);
        bundle.putString("folder_uuid", this.mFolderUuid);
        bundle.putBoolean(NotesConstants.DialogTag.KEY_PLURALS, this.mPlurals);
    }

    public void setConfirmDialogResultListener(IConfirmDialogResultListener iConfirmDialogResultListener) {
        this.mConfirmDialogResultListener = iConfirmDialogResultListener;
    }

    public void setSelectedUuid(String str) {
        this.mFolderUuid = str;
    }

    public ConfirmDialogFragment(int i, int i2, int i4, int i5, int i6, boolean z) {
        this.mTitleResID = i;
        this.mMessageResID = i2;
        this.mCheckCount = i6;
        this.mPlurals = z;
        this.mPositiveResId = i4;
        this.mNegativeResId = i5;
    }
}
