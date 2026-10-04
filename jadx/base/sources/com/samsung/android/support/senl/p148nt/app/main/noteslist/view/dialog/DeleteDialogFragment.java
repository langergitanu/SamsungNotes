package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTaskManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.DeleteTask;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DeleteDialogFragment extends AbsDialogFragment implements DialogViewContract.IDialogFragment {
    public static final String KEY_DELETE_TYPE = "key_delete_type";
    private AlertDialog mAlertDialog;
    private DialogViewContract.IDeleteDialog mContract;
    protected int mDeleteCount;
    private int mDeleteFolderCount;
    private boolean mIsProgressOn;
    private int mLockedCount;
    protected int mMessageId;
    private int mMode;
    private final DialogInterface.OnKeyListener mOnKeyListener;
    private final DialogInterface.OnShowListener mOnShowListener;
    private boolean mPermanentlyDelete;
    private boolean mPlurals;
    private int mPositiveId;
    protected int mTitleId;

    public DeleteDialogFragment() {
        this.mMode = -1;
        this.mIsProgressOn = false;
        this.mOnShowListener = new DialogInterface.OnShowListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.DeleteDialogFragment.1
            /* JADX INFO: Access modifiers changed from: private */
            public void saLogging(boolean z) {
                if (!z) {
                    if (FeatureUtils.isRecyclebinMode(DeleteDialogFragment.this.mMode)) {
                        CommonSamsungAnalytics.insertLog("720", "7201");
                        return;
                    } else if (DeleteDialogFragment.this.mLockedCount > 0) {
                        CommonSamsungAnalytics.insertLog("735", "7351");
                        return;
                    } else {
                        CommonSamsungAnalytics.insertLog("703", "7031");
                        return;
                    }
                }
                if (FeatureUtils.isRecyclebinMode(DeleteDialogFragment.this.mMode)) {
                    DeleteDialogFragment deleteDialogFragment = DeleteDialogFragment.this;
                    CommonSamsungAnalytics.insertLog("720", "7202", Integer.toString(deleteDialogFragment.mDeleteFolderCount + deleteDialogFragment.mDeleteCount));
                } else if (DeleteDialogFragment.this.mLockedCount > 0) {
                    CommonSamsungAnalytics.insertLog("735", "7352");
                } else {
                    CommonSamsungAnalytics.insertLog("703", "7032");
                }
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (DeleteDialogFragment.this.mIsProgressOn) {
                    if (DeleteDialogFragment.this.isAdded()) {
                        DeleteDialogFragment.this.replaceBtnToProgress();
                        return;
                    }
                    return;
                }
                Button button = DeleteDialogFragment.this.mAlertDialog.getButton(-1);
                button.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.DeleteDialogFragment.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (DeleteDialogFragment.this.mContract == null) {
                            return;
                        }
                        saLogging(true);
                        DeleteDialogFragment.this.mContract.onConfirm(DeleteDialogFragment.this.mLockedCount > 0);
                    }
                });
                if (FeatureUtils.isRecyclebinMode(DeleteDialogFragment.this.mMode) || FeatureUtils.isGcsSpaceMode(DeleteDialogFragment.this.mMode) || ((DeleteDialogFragment.this.mPermanentlyDelete && (FeatureUtils.isCoeditMode(DeleteDialogFragment.this.mMode) || FeatureUtils.isCoeditSpaceMode(DeleteDialogFragment.this.mMode))) || FloatingFeature.INSTANCE.getInstance().isDisableRecycleBinModel())) {
                    button.setTextColor(button.getResources().getColor(C8003R.color.basic_dialog_button_red_color, null));
                }
                DeleteDialogFragment.this.mAlertDialog.getButton(-2).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.DeleteDialogFragment.1.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (DeleteDialogFragment.this.mContract == null) {
                            return;
                        }
                        saLogging(false);
                        DeleteDialogFragment.this.mContract.onCancel();
                        DeleteDialogFragment.this.dismissAllowingStateLoss();
                    }
                });
            }
        };
        this.mOnKeyListener = new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.DeleteDialogFragment.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                DeleteDialogFragment.this.mContract.onBackPressed();
                return false;
            }
        };
    }

    public String getMessage() {
        if (!this.mPlurals) {
            int i = this.mLockedCount;
            if (i <= 0 || this.mDeleteCount + i <= i) {
                int i2 = this.mDeleteFolderCount;
                return (i2 == 1 && this.mDeleteCount == 1) ? getResources().getString(this.mMessageId) : i2 == 1 ? getResources().getString(this.mMessageId, Integer.valueOf(this.mDeleteCount)) : this.mDeleteCount == 1 ? getResources().getString(this.mMessageId, Integer.valueOf(this.mDeleteFolderCount)) : getResources().getString(this.mMessageId, Integer.valueOf(this.mDeleteFolderCount), Integer.valueOf(this.mDeleteCount));
            }
            if (i != 1) {
                return getResources().getString(this.mMessageId, Integer.valueOf(this.mDeleteCount), Integer.valueOf(this.mLockedCount));
            }
            Resources resources = getResources();
            int i4 = this.mMessageId;
            int i5 = this.mDeleteCount;
            return resources.getQuantityString(i4, i5, Integer.valueOf(i5));
        }
        if (this.mPermanentlyDelete) {
            int i6 = this.mDeleteCount + this.mDeleteFolderCount;
            return getResources().getQuantityString(this.mMessageId, i6, Integer.valueOf(i6));
        }
        if (this.mDeleteFolderCount == 0) {
            Resources resources2 = getResources();
            int i7 = this.mMessageId;
            int i8 = this.mDeleteCount;
            return resources2.getQuantityString(i7, i8, Integer.valueOf(i8));
        }
        Resources resources3 = getResources();
        int i9 = this.mMessageId;
        int i10 = this.mDeleteFolderCount;
        return resources3.getQuantityString(i9, i10, Integer.valueOf(i10));
    }

    public String getTitle() {
        return this.mTitleId <= 0 ? "" : getResources().getString(this.mTitleId, Integer.valueOf(this.mDeleteCount));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NonNull DialogInterface dialogInterface) {
        this.mContract.onCancel();
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        WorkerTask<?> runningTask;
        super.onCreateDialog(bundle);
        if (bundle != null) {
            this.mTitleId = bundle.getInt("title_id");
            this.mMessageId = bundle.getInt("message_id");
            this.mPositiveId = bundle.getInt(NotesConstants.DialogTag.KEY_POSITIVE_ID);
            this.mDeleteCount = bundle.getInt(NotesConstants.DialogTag.KEY_DELETE_COUNT);
            this.mDeleteFolderCount = bundle.getInt(NotesConstants.DialogTag.KEY_DELETE_FOLDER_COUNT);
            this.mLockedCount = bundle.getInt(NotesConstants.DialogTag.KEY_LOCKED_COUNT);
            this.mPlurals = bundle.getBoolean(NotesConstants.DialogTag.KEY_PLURALS);
            this.mIsProgressOn = bundle.getBoolean(NotesConstants.DialogTag.KEY_IS_PROGRESS_ON);
            this.mMode = bundle.getInt(NotesConstants.DialogTag.KEY_MODE_ID);
            this.mPermanentlyDelete = bundle.getBoolean(KEY_DELETE_TYPE);
        }
        if (this.mIsProgressOn && ((runningTask = WorkerTaskManager.getInstance().getRunningTask(DeleteTask.TAG, getActivity().hashCode())) == null || runningTask.isCancelled())) {
            dismissAllowingStateLoss();
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity()).setTitle(getTitle()).setMessage(getMessage()).setCancelable(true).setPositiveButton(getResources().getString(this.mPositiveId), (DialogInterface.OnClickListener) null).setNegativeButton(C8003R.string.dialog_cancel, (DialogInterface.OnClickListener) null).create();
        this.mAlertDialog = alertDialogCreate;
        alertDialogCreate.setOnShowListener(this.mOnShowListener);
        this.mAlertDialog.setOnKeyListener(this.mOnKeyListener);
        return this.mAlertDialog;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("title_id", this.mTitleId);
        bundle.putInt("message_id", this.mMessageId);
        bundle.putInt(NotesConstants.DialogTag.KEY_POSITIVE_ID, this.mPositiveId);
        bundle.putInt(NotesConstants.DialogTag.KEY_DELETE_COUNT, this.mDeleteCount);
        bundle.putInt(NotesConstants.DialogTag.KEY_DELETE_FOLDER_COUNT, this.mDeleteFolderCount);
        bundle.putInt(NotesConstants.DialogTag.KEY_LOCKED_COUNT, this.mLockedCount);
        bundle.putBoolean(NotesConstants.DialogTag.KEY_PLURALS, this.mPlurals);
        bundle.putBoolean(NotesConstants.DialogTag.KEY_IS_PROGRESS_ON, this.mIsProgressOn);
        bundle.putInt(NotesConstants.DialogTag.KEY_MODE_ID, this.mMode);
        bundle.putBoolean(KEY_DELETE_TYPE, this.mPermanentlyDelete);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDialogFragment
    public void replaceBtnToProgress() {
        this.mIsProgressOn = true;
        Button button = this.mAlertDialog.getButton(-1);
        Button button2 = this.mAlertDialog.getButton(-2);
        if (button == null || button2 == null) {
            return;
        }
        this.mAlertDialog.setCanceledOnTouchOutside(false);
        this.mAlertDialog.setCancelable(false);
        button.setEnabled(false);
        button2.setEnabled(false);
        DialogUtils.replaceBtnToProgress(button);
    }

    public void setContract(DialogViewContract.IDeleteDialog iDeleteDialog) {
        this.mContract = iDeleteDialog;
    }

    public DeleteDialogFragment(int i, int i2, int i4, int i5, int i6, int i7, boolean z, int i8, boolean z2) {
        this(i, i2, i4, i5, i6, i7, z, i8, z2, false);
    }

    public DeleteDialogFragment(int i, int i2, int i4, int i5, int i6, int i7, boolean z, int i8, boolean z2, boolean z3) {
        this.mMode = -1;
        this.mIsProgressOn = false;
        this.mOnShowListener = new DialogInterface.OnShowListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.DeleteDialogFragment.1
            /* JADX INFO: Access modifiers changed from: private */
            public void saLogging(boolean z4) {
                if (!z4) {
                    if (FeatureUtils.isRecyclebinMode(DeleteDialogFragment.this.mMode)) {
                        CommonSamsungAnalytics.insertLog("720", "7201");
                        return;
                    } else if (DeleteDialogFragment.this.mLockedCount > 0) {
                        CommonSamsungAnalytics.insertLog("735", "7351");
                        return;
                    } else {
                        CommonSamsungAnalytics.insertLog("703", "7031");
                        return;
                    }
                }
                if (FeatureUtils.isRecyclebinMode(DeleteDialogFragment.this.mMode)) {
                    DeleteDialogFragment deleteDialogFragment = DeleteDialogFragment.this;
                    CommonSamsungAnalytics.insertLog("720", "7202", Integer.toString(deleteDialogFragment.mDeleteFolderCount + deleteDialogFragment.mDeleteCount));
                } else if (DeleteDialogFragment.this.mLockedCount > 0) {
                    CommonSamsungAnalytics.insertLog("735", "7352");
                } else {
                    CommonSamsungAnalytics.insertLog("703", "7032");
                }
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (DeleteDialogFragment.this.mIsProgressOn) {
                    if (DeleteDialogFragment.this.isAdded()) {
                        DeleteDialogFragment.this.replaceBtnToProgress();
                        return;
                    }
                    return;
                }
                Button button = DeleteDialogFragment.this.mAlertDialog.getButton(-1);
                button.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.DeleteDialogFragment.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (DeleteDialogFragment.this.mContract == null) {
                            return;
                        }
                        saLogging(true);
                        DeleteDialogFragment.this.mContract.onConfirm(DeleteDialogFragment.this.mLockedCount > 0);
                    }
                });
                if (FeatureUtils.isRecyclebinMode(DeleteDialogFragment.this.mMode) || FeatureUtils.isGcsSpaceMode(DeleteDialogFragment.this.mMode) || ((DeleteDialogFragment.this.mPermanentlyDelete && (FeatureUtils.isCoeditMode(DeleteDialogFragment.this.mMode) || FeatureUtils.isCoeditSpaceMode(DeleteDialogFragment.this.mMode))) || FloatingFeature.INSTANCE.getInstance().isDisableRecycleBinModel())) {
                    button.setTextColor(button.getResources().getColor(C8003R.color.basic_dialog_button_red_color, null));
                }
                DeleteDialogFragment.this.mAlertDialog.getButton(-2).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.DeleteDialogFragment.1.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (DeleteDialogFragment.this.mContract == null) {
                            return;
                        }
                        saLogging(false);
                        DeleteDialogFragment.this.mContract.onCancel();
                        DeleteDialogFragment.this.dismissAllowingStateLoss();
                    }
                });
            }
        };
        this.mOnKeyListener = new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.DeleteDialogFragment.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i9, KeyEvent keyEvent) {
                if (i9 != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                DeleteDialogFragment.this.mContract.onBackPressed();
                return false;
            }
        };
        this.mTitleId = i;
        this.mMessageId = i2;
        this.mPositiveId = i4;
        this.mDeleteCount = i5;
        this.mDeleteFolderCount = i6;
        this.mLockedCount = i7;
        this.mPlurals = z;
        this.mMode = i8;
        this.mPermanentlyDelete = z2;
        this.mIsProgressOn = z3;
    }
}
