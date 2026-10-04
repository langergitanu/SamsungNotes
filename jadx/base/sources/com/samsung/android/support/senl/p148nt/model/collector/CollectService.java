package com.samsung.android.support.senl.p148nt.model.collector;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.constants.NotificationConstants;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceType;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.C11397R;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.constants.CollectorConstants;
import com.samsung.android.support.senl.p148nt.model.collector.manager.CollectTaskManager;
import com.samsung.android.support.senl.p148nt.model.collector.updater.ReadyStateUpdater;
import com.samsung.android.support.senl.p148nt.model.collector.updater.SDocSearchDataUpdater;
import com.samsung.android.support.senl.p148nt.model.collector.updater.SkippedNoteUpdater;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class CollectService extends Service {
    private static final String TAG = CollectLogger.createTag("CollectService");
    private final Executor mExternalExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));

    /* JADX INFO: Access modifiers changed from: private */
    public void executeCommand(@NonNull CollectParam collectParam) {
        int actionType = collectParam.getActionType();
        if (actionType == ICollectParam.ActionType.START.getValue()) {
            CollectTaskManager.getInstance().runCollect(collectParam);
            return;
        }
        if (actionType == ICollectParam.ActionType.CANCEL.getValue()) {
            CollectTaskManager.getInstance().cancelCollect(collectParam);
            return;
        }
        if (actionType == ICollectParam.ActionType.RESUME_PDF.getValue()) {
            CollectTaskManager.getInstance().resumePdfCollect(collectParam);
            return;
        }
        if (actionType == ICollectParam.ActionType.PAUSE_PDF.getValue()) {
            CollectTaskManager.getInstance().pausePdfCollect(collectParam);
            return;
        }
        if (actionType == ICollectParam.ActionType.UPDATE_READY_STATE_NOTES.getValue()) {
            ReadyStateUpdater.execute(null);
            return;
        }
        if (actionType == ICollectParam.ActionType.UPDATE_NOTE_DOC_OBJECT_RECOGNITION.getValue()) {
            SDocSearchDataUpdater.execute();
            return;
        }
        if (actionType == ICollectParam.ActionType.UPDATE_SKIPPED_NOTES_OBJECT_RECOGNITION.getValue()) {
            SkippedNoteUpdater.execute();
        } else if (actionType != ICollectParam.ActionType.FINISH.getValue()) {
            DataLogger.m12309w(TAG, "onStartCommand unknown ActionType");
        } else {
            DataLogger.m12302d(TAG, "executeCommand ActionType.FINISH, stopSelf()");
            stopSelf();
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DataLogger.m12302d(TAG, "onCreate " + hashCode());
        String string = getApplicationContext().getResources().getString(C11397R.string.composer_text_recognition_dialog_title);
        ServiceManager.INSTANCE.getInstance().registerService(this, NotificationConstants.COLLECT_NOTIFICATION_CHANNEL_ID, string, string, ServiceType.DEFAULT, 0);
    }

    @Override // android.app.Service
    public void onDestroy() {
        DataLogger.m12302d(TAG, "onDestroy " + hashCode());
        ServiceManager.INSTANCE.getInstance().unregisterService(this);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        String str = TAG;
        DataLogger.m12302d(str, "onStartCommand " + hashCode());
        if (intent != null) {
            this.mExternalExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.model.collector.CollectService.1
                @Override // java.lang.Runnable
                public void run() {
                    CollectParam collectParam = (CollectParam) intent.getSerializableExtra(CollectorConstants.EXTRA_KEY_COLLECT_PARAM);
                    if (collectParam != null) {
                        CollectService.this.executeCommand(collectParam);
                    } else {
                        DataLogger.m12309w(CollectService.TAG, "isAllowedIntent# invalid param");
                    }
                }
            });
        } else {
            DataLogger.m12309w(str, "isAllowedIntent# invalid intent");
        }
        if (!ServiceManager.INSTANCE.getInstance().canWorkOnBackground()) {
            return 2;
        }
        stopSelf();
        return 2;
    }
}
