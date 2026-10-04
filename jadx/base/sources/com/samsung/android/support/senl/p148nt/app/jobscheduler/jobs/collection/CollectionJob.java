package com.samsung.android.support.senl.p148nt.app.jobscheduler.jobs.collection;

import android.app.job.JobInfo;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.BatteryManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.jobscheduler.jobs.common.AbsNoteJob;
import com.samsung.android.support.senl.p148nt.base.common.jobscheduler.INoteJob;
import com.samsung.android.support.senl.p148nt.base.common.jobscheduler.JobTestLogger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.model.collector.CollectController;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.manager.CollectTaskManager;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CollectionJob extends AbsNoteJob {
    private static final int PERIODIC_HOUR_TIME = 4;
    private static final String TAG = "CollectionJob";

    private void runCollection(INoteJob.INoteJobFinishCallback iNoteJobFinishCallback) {
        JobTestLogger.log("CollectionJob/ runCollection");
        CollectController.getInstance().collectReadyState(iNoteJobFinishCallback);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.jobscheduler.jobs.common.AbsNoteJob, com.samsung.android.support.senl.p148nt.base.common.jobscheduler.INoteJob
    public void cancel() {
        JobTestLogger.log("CollectionJob/ cancel");
        Logger.m8700f(TAG, "cancel");
        CollectTaskManager.getInstance().cancelCollect(new CollectParam.CollectParamBuilder().setActionType(ICollectParam.ActionType.CANCEL.getValue()).setCancelType(ICollectParam.CancelType.UPDATE.getValue()).build());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.jobscheduler.INoteJob
    public boolean execute(INoteJob.INoteJobFinishCallback iNoteJobFinishCallback) {
        if (2 != BatteryManagerCompat.getBatteryStatus(BaseUtils.getApplicationContext()).intValue()) {
            return false;
        }
        runCollection(iNoteJobFinishCallback);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.jobscheduler.jobs.common.AbsNoteJob
    public void setUpJobInfoProperties(JobInfo.Builder builder) {
        builder.setRequiresDeviceIdle(true).setRequiresCharging(true).setPeriodic(TimeUnit.HOURS.toMillis(4L));
        JobTestLogger.log("CollectionJob/ setUpJobInfoProperties " + builder.toString());
    }
}
