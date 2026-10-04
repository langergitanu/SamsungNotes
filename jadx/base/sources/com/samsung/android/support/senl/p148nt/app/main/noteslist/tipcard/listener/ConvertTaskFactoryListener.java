package com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.TipCardUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardFailToConvertStorageError;
import com.samsung.android.support.senl.p148nt.app.settings.externalsearch.SettingsSearchIndexingManager;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCardProgress;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTaskFactory;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTaskGroup;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult;
import com.samsung.android.support.senl.p148nt.model.utils.FeatureUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ConvertTaskFactoryListener extends TaskListener implements ConvertTaskGroup.IGroupTaskCallback {
    private static final String TAG = "ConvertTaskFactoryListener";

    public ConvertTaskFactoryListener(Activity activity, @NonNull TipCardProgress tipCardProgress, @NonNull TipCardTaskListener tipCardTaskListener) {
        super(activity, tipCardProgress, tipCardTaskListener);
    }

    private void clearConvertTaskData() {
        MainLogger.m7258i(TAG, "clearConvertTaskData# ");
        TipCardUtil.clearConvertTaskProgress();
        TipCardUtil.setConvertAll(false);
    }

    private void disconnectConvertTaskManager() {
        MainLogger.m7258i(TAG, "disconnectConvertTaskManager# ");
        ConvertTaskManager.disconnect();
        clearConvertTaskData();
        updateTipCardAfterDisconnected();
        this.mTaskListener.filteredInvalidateOptionsMenu();
        this.mWeakRefActivity.clear();
    }

    private void sendSALogging(boolean z) {
        if (NotesConstants.ACTION_CONVERT_SDOC_FROM_SETTINGS.equals(this.mWeakRefActivity.get().getIntent().getAction())) {
            CommonSamsungAnalytics.insertLog(SettingsSAConstants.SCREEN_OLDNOTES, SettingsSAConstants.EVENT_SETTINGS_CONVERT_ALL, z ? "a" : "b");
        }
    }

    private void updateTipCardAfterDisconnected() {
        ViewModeUtils.runOnUiThread(this.mWeakRefActivity.get(), new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.listener.ConvertTaskFactoryListener.1
            @Override // java.lang.Runnable
            public void run() {
                ConvertTaskFactoryListener convertTaskFactoryListener = ConvertTaskFactoryListener.this;
                if (convertTaskFactoryListener.mIsCancelled) {
                    return;
                }
                convertTaskFactoryListener.mTaskListener.removeTipCard(convertTaskFactoryListener.mTipCardProgress.getType());
                int failed = ConvertTaskFactoryListener.this.mTipCardProgress.getFailed();
                if (failed > 0) {
                    ConvertTaskFactoryListener.this.mTaskListener.addTipCard(new TipCardFailToConvertStorageError(failed));
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskFactory.IConvertTaskFactoryCallback
    public void onCreated() {
        MainLogger.m7258i(TAG, "onCreated# ");
    }

    @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskGroup.IGroupTaskCallback
    public void onEnd(boolean z, IConvertResult iConvertResult) {
        setProgress(iConvertResult.getTotalCount(), iConvertResult.getProgressCount(), iConvertResult.getStorageFailedCount());
        sendSALogging(iConvertResult.getStorageFailedCount() == 0);
        disconnectConvertTaskManager();
        SettingsSearchIndexingManager.requestIndexing();
        if (FeatureUtils.ENABLE_DELETE_OLD_DOC_AFTER_CONVERTING && z) {
            ToastHandler.show(BaseUtils.getApplicationContext(), BaseUtils.getApplicationContext().getResources().getString(C8003R.string.base_string_convert_finish), 0, false);
            NotesSamsungAnalytics.insertLog(SettingsSAConstants.SCREEN_OLDNOTES, NotesSAConstants.EVENT_OLDNOTES_CONVERT);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
    public void onFailed(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
        MainLogger.m7258i(TAG, "onFailed# state : " + iConvertResult.getState());
        setProgress(iConvertResult.getTotalCount(), iConvertResult.getProgressCount(), iConvertResult.getStorageFailedCount());
    }

    @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskFactory.IConvertTaskFactoryCallback
    public void onPreFailed(ConvertTaskFactory.IConvertTaskFactoryCallback.ErrorMsg errorMsg) {
        MainLogger.m7258i(TAG, "onPreFailed# msg : " + errorMsg);
        sendSALogging(false);
        disconnectConvertTaskManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
    public void onSuccess(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
        MainLogger.m7258i(TAG, "onSuccess# state : " + iConvertResult.getState());
        if (iConvertResult.getDstType() == 9) {
            setProgress(iConvertResult.getTotalCount(), iConvertResult.getProgressCount(), iConvertResult.getStorageFailedCount());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TaskListener
    public void setOnCancelled() {
        super.setOnCancelled();
        MainLogger.m7258i(TAG, "setOnCancelled# ");
        clearConvertTaskData();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TaskListener
    public void setProgress(int i, int i2, int i4) {
        super.setProgress(i, i2, i4);
        TipCardUtil.setConvertTaskProgress(i, i2, i4);
    }
}
