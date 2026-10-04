package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SaveAsRenameDialogPresenter extends RenameDialogCommonPresenter {
    public static final String TAG = Logger.createTag("SaveAsRenameDialogPresenter");
    protected String mExportStorageDir;
    protected String mExtension;
    protected OnClickListener mOnClickListener;
    protected ShareData mShareData;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnClickListener {
        void dismiss(View view);

        void onClick(String str);
    }

    public SaveAsRenameDialogPresenter(DialogContract.IDialogCreator iDialogCreator) {
        super(iDialogCreator);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public boolean allowableDefaultName() {
        return true;
    }

    public DialogFragment createDialogFragment() {
        return this.mCreator.createSaveAsRenameDialogFragment();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public void dismiss(View view) {
        this.mOnClickListener.dismiss(view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public String getDefaultName() {
        return FileUtils.extractFileName(new File(FileUtils.generateUniqueFilePath(this.mExportStorageDir, ShareUtils.generateNewFileName(this.mShareData.getTitle(), this.mShareData.getLastModifiedTime()), this.mExtension)).getName());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public boolean isExistName(String str) {
        String str2 = this.mExportStorageDir;
        StringBuilder sbM781w = AbstractC0541b.m781w(str, Extension.DOT);
        sbM781w.append(this.mExtension);
        return new File(str2, sbM781w.toString()).exists();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public void setNewName(String str) {
        String str2 = this.mExportStorageDir;
        StringBuilder sbM781w = AbstractC0541b.m781w(str, Extension.DOT);
        sbM781w.append(this.mExtension);
        this.mOnClickListener.onClick(new File(str2, sbM781w.toString()).getAbsolutePath());
    }

    public void showRenameDialog(ShareData shareData, String str, String str2, OnClickListener onClickListener) {
        if (CommonUtil.isNotAvailableActivity(this.mActivity)) {
            Logger.m10999d(getTag(), "showRenameDialog# " + this.mActivity);
            return;
        }
        this.mShareData = shareData;
        this.mExportStorageDir = str;
        this.mExtension = str2;
        this.mOnClickListener = onClickListener;
        ((AppCompatActivity) this.mActivity).getSupportFragmentManager().beginTransaction().add(createDialogFragment(), getTag()).commitAllowingStateLoss();
        ((AppCompatActivity) this.mActivity).getSupportFragmentManager().executePendingTransactions();
    }
}
