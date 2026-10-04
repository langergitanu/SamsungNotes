package com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener;

import android.app.Activity;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.TipCardUtil;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCardProgress;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import java.util.Map;
import p084U0.InterfaceC0313e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ImportSDocTaskListener extends TaskListener implements InterfaceC0313e {
    private static final String TAG = "ImportSDocTaskListener";

    public ImportSDocTaskListener(Activity activity, @NonNull TipCardProgress tipCardProgress, @NonNull TipCardTaskListener tipCardTaskListener) {
        super(activity, tipCardProgress, tipCardTaskListener);
    }

    private void clearImportSamsungNoteTaskData() {
        MainLogger.m7258i(TAG, "clearImportSamsungNoteTaskData# ");
        TipCardUtil.clearImportSamsungNoteTaskProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFinish$0(int i, Activity activity, int i2, int i4) {
        this.mTaskListener.removeTipCard(this.mTipCardProgress.getType());
        if (i > 0) {
            ToastHandler.show(activity, activity.getResources().getString(C8003R.string.sync_imported_corrupted_files, Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i)), 0, false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
    public void onFail(@NonNull String str, @NonNull String str2, int i, @Nullable String str3) {
        MainLogger.m7258i(TAG, "onFail# errorCode: " + i + " message: " + str3);
    }

    public void onFinish(final int i, final int i2, @NonNull Map<String, Integer> map, final int i4) {
        AbstractC8014b.m7212n(AbstractC0622a.m1173s(i, i2, "onFinish# total: ", " errorCount: ", " successCount: "), TAG, i4);
        clearImportSamsungNoteTaskData();
        final Activity activity = this.mWeakRefActivity.get();
        activity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.listener.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f6254a.lambda$onFinish$0(i2, activity, i, i4);
            }
        });
        this.mWeakRefActivity.clear();
    }

    public void onProgress(int i, int i2) {
        AbstractC8014b.m7200b(i2, i, "onProgress# total: ", " progress: ", TAG);
        setProgress(i2, i, 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
    public void onStart(@NonNull String str, @NonNull String str2) {
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
    public void onSuccess(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable Pair<String, String> pair) {
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
    public void onUnsupportedVersionError(@NonNull String str, @NonNull String str2) {
        MainLogger.m7258i(TAG, "onUnsupportedVersionError");
        this.mTaskListener.onUnsupportedVersionError();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TaskListener
    public void setOnCancelled() {
        super.setOnCancelled();
        MainLogger.m7258i(TAG, "setOnCancelled# ");
        clearImportSamsungNoteTaskData();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TaskListener
    public void setProgress(int i, int i2, int i4) {
        super.setProgress(i, i2, i4);
        TipCardUtil.setImportSamsungNoteTaskProgress(i, i2, i4);
    }
}
