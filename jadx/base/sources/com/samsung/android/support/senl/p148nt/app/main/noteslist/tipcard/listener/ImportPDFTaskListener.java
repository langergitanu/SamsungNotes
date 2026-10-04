package com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.TipCardUtil;
import com.samsung.android.support.senl.p148nt.app.main.common.task.PdfImportTask;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCardProgress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ImportPDFTaskListener extends TaskListener implements PdfImportTask.Contract {
    private static final String TAG = "ImportTaskListener";

    public ImportPDFTaskListener(Activity activity, @NonNull TipCardProgress tipCardProgress, @NonNull TipCardTaskListener tipCardTaskListener) {
        super(activity, tipCardProgress, tipCardTaskListener);
    }

    private void clearImportPDFTaskProgress() {
        MainLogger.m7254d(TAG, "clearImportPDFTaskProgress# ");
        TipCardUtil.clearImportPDFTaskProgress();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.task.PdfImportTask.Contract
    public void onPostExecute() {
        clearImportPDFTaskProgress();
        this.mTaskListener.removeTipCard(this.mTipCardProgress.getType());
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.task.PdfImportTask.Contract
    public void onTaskProgressed(int i, int i2, int i4) {
        setProgress(i, i2, i4);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TaskListener
    public void setOnCancelled() {
        super.setOnCancelled();
        MainLogger.m7254d(TAG, "setOnCancelled# ");
        clearImportPDFTaskProgress();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TaskListener
    public void setProgress(int i, int i2, int i4) {
        super.setProgress(i, i2, i4);
        TipCardUtil.setImportPDFTaskProgress(i, i2, i4);
    }
}
