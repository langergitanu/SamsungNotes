package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SummaryOptionDialogPresenter implements DialogContract.ISummaryOptionDialogPresenter {
    private static final String TAG = Logger.createTag("SummaryOptionDialogPresenter");
    private View mAnchorView;
    private Contract mContract;
    private final DialogContract.IDialogCreator mCreator;
    private DialogContract.IDialog mDialog;
    private int[] mLocation;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void setOption(int i);
    }

    public SummaryOptionDialogPresenter(DialogContract.IDialogCreator iDialogCreator) {
        this.mCreator = iDialogCreator;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.ISummaryOptionDialogPresenter
    public View getAnchorView() {
        return this.mAnchorView;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.ISummaryOptionDialogPresenter
    public int[] getLocation() {
        return this.mLocation;
    }

    public void hide() {
        if (isShowing()) {
            this.mDialog.dismiss();
        }
    }

    public boolean isShowing() {
        DialogContract.IDialog iDialog = this.mDialog;
        return iDialog != null && iDialog.isShowing();
    }

    public void onDetachView() {
        DialogContract.IDialog iDialog = this.mDialog;
        if (iDialog == null || !iDialog.isShowing()) {
            return;
        }
        this.mDialog.dismiss();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IPresenter
    public void onDismiss() {
        this.mContract = null;
        this.mAnchorView = null;
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
        if (view == null) {
            return;
        }
        this.mLocation = new int[2];
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int[] iArr = this.mLocation;
        iArr[0] = (rect.left + rect.right) / 2;
        iArr[1] = view.getResources().getDimensionPixelSize(C9086R.dimen.ai_disclaimer_dialog_margin_bottom) + rect.bottom;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.ISummaryOptionDialogPresenter
    public void setOption(int i) {
        this.mContract.setOption(i);
    }

    public void showDialog(Activity activity, int i, Contract contract, boolean z) {
        if (CommonUtil.isNotAvailableActivity(activity)) {
            Logger.m11004w(TAG, "showDialog# " + activity);
            return;
        }
        this.mContract = contract;
        DialogContract.IDialog iDialog = this.mDialog;
        if (iDialog != null && iDialog.isShowing()) {
            Logger.m11004w(TAG, "showDialog# dialog is already shown");
            return;
        }
        DialogContract.IDialog iDialogCreateSummaryOptionDialog = this.mCreator.createSummaryOptionDialog(activity, i, this, z);
        this.mDialog = iDialogCreateSummaryOptionDialog;
        iDialogCreateSummaryOptionDialog.show();
    }
}
