package com.samsung.android.support.senl.p148nt.model.collector;

import android.content.Intent;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.jobscheduler.INoteJob;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.constants.CollectorConstants;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class CollectController {
    private static final String TAG = CollectLogger.createTag("CollectController");
    private static CollectController sInstance;

    private CollectController() {
    }

    public static CollectController getInstance() {
        CollectController collectController;
        synchronized (CollectController.class) {
            try {
                if (sInstance == null) {
                    sInstance = new CollectController();
                }
                collectController = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return collectController;
    }

    public void collectReadyState(boolean z) {
        DataLogger.m12302d(TAG, "collectReadyState");
        new ReadyStateCollectExecutor().execute(z);
    }

    public void collectSavingByWhichPid() {
        new SavingByWhichPidCollectExecutor().execute();
    }

    public void postCollectorTask(CollectParam collectParam) {
        DataLogger.m12302d(TAG, "postCollectorTask, uuid: " + collectParam.getUuid());
        Intent intent = new Intent(BaseUtils.getApplicationContext(), (Class<?>) CollectService.class);
        intent.putExtra(CollectorConstants.EXTRA_KEY_COLLECT_PARAM, collectParam);
        ServiceManager.INSTANCE.getInstance().startService(BaseUtils.getContext(), intent);
    }

    public void collectReadyState(INoteJob.INoteJobFinishCallback iNoteJobFinishCallback) {
        DataLogger.m12302d(TAG, "collectReadyState by JobService");
        new ReadyStateCollectExecutor().execute(iNoteJobFinishCallback);
    }
}
