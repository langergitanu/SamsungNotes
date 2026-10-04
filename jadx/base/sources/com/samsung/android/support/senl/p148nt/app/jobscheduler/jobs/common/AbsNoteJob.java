package com.samsung.android.support.senl.p148nt.app.jobscheduler.jobs.common;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.SystemConstructor;
import com.samsung.android.support.senl.p148nt.base.common.jobscheduler.INoteJob;
import com.samsung.android.support.senl.p148nt.base.common.jobscheduler.JobTestLogger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsNoteJob implements INoteJob {
    private static final String TAG = "AbsNoteJob";

    @Override // com.samsung.android.support.senl.p148nt.base.common.jobscheduler.INoteJob
    public void cancel() {
    }

    public void schedule(@NonNull JobScheduler jobScheduler, int i, ComponentName componentName) {
        JobTestLogger.log("AbsNoteJob/ schedule");
        try {
            JobInfo.Builder builderCreateJobInfoBuilder = SystemConstructor.createJobInfoBuilder(i, componentName);
            setUpJobInfoProperties(builderCreateJobInfoBuilder);
            jobScheduler.schedule(builderCreateJobInfoBuilder.build());
        } catch (Exception e) {
            Logger.m8698e(TAG, "schedule " + e.getMessage());
        }
    }

    public abstract void setUpJobInfoProperties(JobInfo.Builder builder);
}
