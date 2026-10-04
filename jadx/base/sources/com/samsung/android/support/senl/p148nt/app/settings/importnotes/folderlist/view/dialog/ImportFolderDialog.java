package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.view.dialog;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.dialog.ErrorDialog;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.dialog.FileDownloadDialogFragment;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.dialog.ImportDialogResultListener;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0018\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\rJ\u0006\u0010\u0018\u001a\u00020\u000bJ\u0010\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/view/dialog/ImportFolderDialog;", "", "mPresenter", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenter;", "mDialogContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/view/dialog/ImportFolderDialogContract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenter;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/view/dialog/ImportFolderDialogContract;)V", "mFileDownloadResultListener", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/dialog/ImportDialogResultListener$Downloading;", "mIsFileDownloadEnded", "", "onRestoreDialogState", "", "savedInstanceState", "Landroid/os/Bundle;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "showFileDownloadingDialog", "appName", "", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "dismissFileDownloadingDialog", "isFileDownloadInProgress", "showErrorDialog", "context", "Landroid/content/Context;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportFolderDialog {

    @NotNull
    private static final String KEY_FILE_DOWNLOAD_ENDED = "key_file_download_ended";

    @NotNull
    private static final String TAG = "ST$ImportFolderDialog";

    @NotNull
    private final ImportFolderDialogContract mDialogContract;

    @NotNull
    private final ImportDialogResultListener.Downloading mFileDownloadResultListener;
    private boolean mIsFileDownloadEnded;

    @NotNull
    private final ImportFolderPresenter mPresenter;

    public ImportFolderDialog(@NotNull ImportFolderPresenter mPresenter, @NotNull ImportFolderDialogContract mDialogContract) {
        Intrinsics.checkNotNullParameter(mPresenter, "mPresenter");
        Intrinsics.checkNotNullParameter(mDialogContract, "mDialogContract");
        this.mPresenter = mPresenter;
        this.mDialogContract = mDialogContract;
        this.mFileDownloadResultListener = new ImportDialogResultListener.Downloading() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.folderlist.view.dialog.ImportFolderDialog$mFileDownloadResultListener$1
            @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.common.dialog.ImportDialogResultListener.Downloading
            public void onCancel() {
                MainLogger.m7258i("ST$ImportFolderDialog", "mFileDownloadResultListener onCancel# ");
                this.this$0.mPresenter.unregisterImportListRequest();
                this.this$0.mDialogContract.activityFinish();
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.common.dialog.ImportDialogResultListener.Downloading
            public void onDismiss() {
                this.this$0.mIsFileDownloadEnded = true;
                this.this$0.mDialogContract.updateLayout();
            }
        };
    }

    public final void dismissFileDownloadingDialog() {
        FragmentManager childFragmentManager;
        FileDownloadDialogFragment fileDownloadDialogFragment;
        try {
            childFragmentManager = this.mDialogContract.getChildFragmentManager();
        } catch (IllegalStateException e) {
            AbstractC6670b.m4738C("dismissFileDownloadingDialog, e: ", e.getMessage(), TAG);
            childFragmentManager = null;
        }
        if (childFragmentManager == null || (fileDownloadDialogFragment = (FileDownloadDialogFragment) childFragmentManager.findFragmentByTag(FileDownloadDialogFragment.TAG)) == null || !fileDownloadDialogFragment.isAdded()) {
            return;
        }
        MainLogger.m7258i(TAG, "dismissFileDownloadingDialog# ");
        fileDownloadDialogFragment.dismissAllowingStateLoss();
        this.mIsFileDownloadEnded = true;
    }

    public final boolean isFileDownloadInProgress() {
        FragmentManager childFragmentManager;
        FileDownloadDialogFragment fileDownloadDialogFragment;
        try {
            childFragmentManager = this.mDialogContract.getChildFragmentManager();
        } catch (IllegalStateException e) {
            AbstractC6670b.m4738C("isFileDownloadInProgress, e: ", e.getMessage(), TAG);
            childFragmentManager = null;
        }
        if (childFragmentManager == null || (fileDownloadDialogFragment = (FileDownloadDialogFragment) childFragmentManager.findFragmentByTag(FileDownloadDialogFragment.TAG)) == null) {
            return false;
        }
        return fileDownloadDialogFragment.isAdded();
    }

    public final void onRestoreDialogState(@NotNull Bundle savedInstanceState) {
        FragmentManager childFragmentManager;
        FileDownloadDialogFragment fileDownloadDialogFragment;
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        this.mIsFileDownloadEnded = savedInstanceState.getBoolean(KEY_FILE_DOWNLOAD_ENDED, true);
        try {
            childFragmentManager = this.mDialogContract.getChildFragmentManager();
        } catch (IllegalStateException e) {
            AbstractC6670b.m4738C("showFileDownloadingDialog, e: ", e.getMessage(), TAG);
            childFragmentManager = null;
        }
        if (childFragmentManager == null || (fileDownloadDialogFragment = (FileDownloadDialogFragment) childFragmentManager.findFragmentByTag(FileDownloadDialogFragment.TAG)) == null) {
            return;
        }
        fileDownloadDialogFragment.setOnResultListener(this.mFileDownloadResultListener);
        if (this.mIsFileDownloadEnded) {
            fileDownloadDialogFragment.dismissAllowingStateLoss();
            this.mIsFileDownloadEnded = false;
        }
    }

    public final void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putBoolean(KEY_FILE_DOWNLOAD_ENDED, this.mIsFileDownloadEnded);
    }

    public final void showErrorDialog(@Nullable Context context) {
        MainLogger.m7258i(TAG, "showErrorDialog# ");
        if (context != null) {
            new ErrorDialog(context).show();
        }
    }

    public final void showFileDownloadingDialog(@Nullable String appName, @NotNull DocTypeConstants importType) {
        FragmentManager childFragmentManager;
        Intrinsics.checkNotNullParameter(importType, "importType");
        MainLogger.m7258i(TAG, "showFileDownloadingDialog# importType : " + importType);
        try {
            childFragmentManager = this.mDialogContract.getChildFragmentManager();
        } catch (IllegalStateException e) {
            AbstractC6670b.m4738C("showFileDownloadingDialog, e: ", e.getMessage(), TAG);
            childFragmentManager = null;
        }
        if (childFragmentManager != null) {
            FileDownloadDialogFragment fileDownloadDialogFragment = (FileDownloadDialogFragment) childFragmentManager.findFragmentByTag(FileDownloadDialogFragment.TAG);
            if (fileDownloadDialogFragment == null || !fileDownloadDialogFragment.isAdded()) {
                FileDownloadDialogFragment fileDownloadDialogFragment2 = new FileDownloadDialogFragment();
                fileDownloadDialogFragment2.setData(appName, importType);
                fileDownloadDialogFragment2.setOnResultListener(this.mFileDownloadResultListener);
                childFragmentManager.beginTransaction().add(fileDownloadDialogFragment2, FileDownloadDialogFragment.TAG).commitAllowingStateLoss();
            }
        }
    }
}
