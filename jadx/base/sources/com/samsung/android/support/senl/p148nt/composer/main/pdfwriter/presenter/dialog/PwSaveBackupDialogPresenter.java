package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.dialog;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwFileManager;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.dialog.PwDialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.task.PwTaskSaveBackup;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwSaveBackupDialogPresenter extends AbsDialogFragmentPresenter {
    private static final String TAG = Logger.createTag("PwSaveBackupDialogPresenter");
    private Contract mContract;
    private final PwDialogContract.IDialogCreator mCreator;
    private final TaskController mTaskController;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void clearData();

        List<PwFileManager.CacheInfo> getCacheList();

        void getPageSize(int[] iArr);
    }

    public PwSaveBackupDialogPresenter(PwDialogContract.IDialogCreator iDialogCreator, TaskController taskController) {
        this.mCreator = iDialogCreator;
        this.mTaskController = taskController;
    }

    public void discard() {
        Logger.m10999d(TAG, "discard#");
        PwFileManager pwFileManager = new PwFileManager();
        StringBuilder sb = new StringBuilder();
        List<PwFileManager.CacheInfo> cacheList = this.mContract.getCacheList();
        if (cacheList != null) {
            for (PwFileManager.CacheInfo cacheInfo : cacheList) {
                sb.append(Logger.getEncode(cacheInfo.getOriginPdfFilePath()));
                sb.append(" | ");
                pwFileManager.deleteCache(cacheInfo.getCacheFile().getPath(), cacheInfo.getUuid());
            }
            cacheList.clear();
        }
        this.mContract.clearData();
        Logger.m11002f(TAG, "discard# " + sb.toString());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public DialogFragment findFragmentByTag(Activity activity) {
        return findFragmentByTag(activity, TAG);
    }

    public String getTitle() {
        String originPdfFilePath = this.mContract.getCacheList().get(0).getOriginPdfFilePath();
        return originPdfFilePath.substring(originPdfFilePath.lastIndexOf(File.separator) + 1);
    }

    public void save() {
        Logger.m10999d(TAG, "save#");
        int[] iArr = new int[2];
        this.mContract.getPageSize(iArr);
        PwTaskSaveBackup.InputValues inputValues = new PwTaskSaveBackup.InputValues(this.mActivity, this.mContract.getCacheList(), iArr[0], iArr[1]);
        PwTaskSaveBackup pwTaskSaveBackup = new PwTaskSaveBackup();
        this.mTaskController.execute(pwTaskSaveBackup, inputValues, pwTaskSaveBackup.getDefaultCallback(), false);
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
    }

    public void show() {
        Activity activity = this.mActivity;
        String str = TAG;
        if (canShow(activity, str)) {
            show(this.mActivity, str, this.mCreator.createSaveBackupDialogFragment());
        }
    }
}
