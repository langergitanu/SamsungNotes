package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.access.folder.FolderAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialog;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import p071Q2.ViewOnClickListenerC0219a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FolderViewManager {
    private static final String TAG = Logger.createTag("FolderViewManager");
    private final Contract mContract;
    private IFolderPickerDialog mDialog;
    private final ImageView mFolderIconView;
    private final TextView mFolderNameView;
    private final KeyguardPresenter mKeyguardPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        AppCompatActivity getActivity();

        TitleEditorPresenter getPresenter();
    }

    public FolderViewManager(View view, @NonNull KeyguardPresenter keyguardPresenter, Contract contract) {
        this.mKeyguardPresenter = keyguardPresenter;
        this.mContract = contract;
        this.mFolderNameView = (TextView) view.findViewById(C9086R.id.comp_title_folder_name);
        this.mFolderIconView = (ImageView) view.findViewById(C9086R.id.comp_title_folder_icon);
    }

    private IFolderPickerDialog initFolderPickerDialog() {
        IFolderPickerDialog iFolderPickerDialog;
        Exception e;
        IFolderPickerDialog iFolderPickerDialog2 = null;
        try {
            iFolderPickerDialog = (IFolderPickerDialog) this.mContract.getActivity().getSupportFragmentManager().findFragmentByTag("FolderPickerDialog");
            if (iFolderPickerDialog == null) {
                try {
                    if (FolderAccessHandler.getFolderPickerDialogClass() == null) {
                        PostLaunchManager.getInstance().executeBaseLogic(1);
                        if (FolderAccessHandler.getFolderPickerDialogClass() == null) {
                            Logger.m11000e(TAG, "initFolderPickerDialog: cannot get the FolderPickerDialog class");
                            return null;
                        }
                    }
                    iFolderPickerDialog2 = (IFolderPickerDialog) FolderAccessHandler.getFolderPickerDialogClass().getDeclaredConstructor(null).newInstance(null);
                } catch (Exception e2) {
                    e = e2;
                    Logger.m11001e(TAG, "folder click exception. " + e.getMessage(), e);
                    return iFolderPickerDialog;
                }
            } else {
                iFolderPickerDialog2 = iFolderPickerDialog;
            }
            iFolderPickerDialog2.setPickerDialogData(this.mContract.getPresenter().getDocUuid(), this.mContract.getPresenter().getFolderUuid());
            iFolderPickerDialog2.setHighlightFolderUuid(this.mContract.getPresenter().getFolderUuid());
            iFolderPickerDialog2.setFolderSelectedListener(new C8886c(this, 12));
            return iFolderPickerDialog2;
        } catch (Exception e3) {
            iFolderPickerDialog = iFolderPickerDialog2;
            e = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(AlertDialog alertDialog) {
        this.mKeyguardPresenter.dismissKeyguard(this.mContract.getActivity(), new RunnableC10497b(this, alertDialog, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(AlertDialog alertDialog, View view) {
        if (!this.mContract.getPresenter().isMde() && this.mContract.getPresenter().isMovableFolder() && this.mContract.getActivity().getSupportFragmentManager().findFragmentByTag("FolderPickerDialog") == null) {
            UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
            if (UserInputSkipper.isValidEvent(tag)) {
                UserInputSkipper.setHoldingEventTime(500L, tag);
                this.mContract.getPresenter().getSoftInputManager().hideAndExecute(new RunnableC10497b(this, alertDialog, 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initFolderPickerDialog$3(String str) {
        this.mContract.getPresenter().setFolderUuid(str);
        updateFolderInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showDialog, reason: merged with bridge method [inline-methods] */
    public void lambda$init$0(AlertDialog alertDialog) {
        IFolderPickerDialog iFolderPickerDialogInitFolderPickerDialog = initFolderPickerDialog();
        this.mDialog = iFolderPickerDialogInitFolderPickerDialog;
        if (iFolderPickerDialogInitFolderPickerDialog == null) {
            return;
        }
        if (alertDialog == null) {
            iFolderPickerDialogInitFolderPickerDialog.setAnchorViewId(this.mFolderIconView.getId());
        } else {
            iFolderPickerDialogInitFolderPickerDialog.setAnchorViewId(alertDialog, this.mFolderIconView.getId());
        }
        this.mDialog.show(this.mContract.getActivity().getSupportFragmentManager(), "FolderPickerDialog");
        if (this.mContract.getPresenter().isEditMode()) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_SELECT_CATEGORY);
        } else {
            ComposerSA.insertLog("301", ComposerSAConstants.EVENT_EDIT_SELECT_CATEGORY);
            ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_CHANGE_CATEGORY);
        }
    }

    public void dismiss() {
        IFolderPickerDialog iFolderPickerDialog = this.mDialog;
        if (iFolderPickerDialog != null) {
            iFolderPickerDialog.dismiss();
        }
    }

    public void init(View view) {
        init(view, null);
    }

    public void updateFolderInfo() {
        updateFolderInfo(this.mContract.getPresenter().getFolderName(), this.mContract.getPresenter().getFolderColor(), this.mContract.getPresenter().getFolderIcon());
    }

    public void init(View view, AlertDialog alertDialog) {
        if (this.mContract.getPresenter().isMde()) {
            return;
        }
        view.setOnClickListener(new ViewOnClickListenerC0219a(this, alertDialog, 12));
    }

    public void updateFolderInfo(String str, int i, int i2) {
        TextView textView = this.mFolderNameView;
        if (textView != null) {
            textView.setText(str);
            this.mFolderNameView.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        }
        ImageView imageView = this.mFolderIconView;
        if (imageView != null) {
            imageView.setImageResource(i2);
            this.mFolderIconView.setColorFilter(i);
            this.mFolderIconView.setVisibility(i2 == 0 ? 8 : 0);
        }
    }
}
