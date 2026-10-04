package com.samsung.android.support.senl.p148nt.app.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import com.samsung.android.support.senl.p148nt.app.jobscheduler.jobs.collection.CollectionJob;
import com.samsung.android.support.senl.p148nt.app.jobscheduler.jobs.common.AbsNoteJob;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.jobscheduler.INoteJob;
import com.samsung.android.support.senl.p148nt.base.common.jobscheduler.JobTestLogger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesJobService extends JobService {
    private static final int JOB_ID_COLLECTION = 1;
    private static final String TAG = "NotesJobService";
    private static NotesJobService sInstance;
    private final Map<Integer, INoteJob> mRunningJobs = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EmptyJob extends AbsNoteJob {
        public /* synthetic */ EmptyJob(int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.jobscheduler.INoteJob
        public boolean execute(INoteJob.INoteJobFinishCallback iNoteJobFinishCallback) {
            return false;
        }

        @Override // com.samsung.android.support.senl.p148nt.app.jobscheduler.jobs.common.AbsNoteJob
        public void setUpJobInfoProperties(JobInfo.Builder builder) {
        }

        private EmptyJob() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FinishListener implements INoteJob.INoteJobFinishCallback {
        private JobParameters mParameters;

        public FinishListener(JobParameters jobParameters) {
            this.mParameters = jobParameters;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.jobscheduler.INoteJob.INoteJobFinishCallback
        public void onFinishJob() {
            try {
                JobTestLogger.log("NotesJobService/ onFinishJob " + this.mParameters.getJobId());
                Logger.m8700f(NotesJobService.TAG, "onFinishJob " + this.mParameters.getJobId());
                NotesJobService.getInstance().dumpRunningJobs();
                INoteJob iNoteJob = (INoteJob) NotesJobService.getInstance().mRunningJobs.remove(Integer.valueOf(this.mParameters.getJobId()));
                if (iNoteJob == null) {
                    JobTestLogger.log("NotesJobService/ onFinishJob invalid job");
                    NotesJobService.getInstance().jobFinished(this.mParameters, false);
                } else {
                    iNoteJob.cancel();
                    NotesJobService.getInstance().jobFinished(this.mParameters, false);
                    this.mParameters = null;
                }
            } catch (Exception e) {
                JobTestLogger.log(getClass().getSimpleName() + "/ onFinishJob " + e.getMessage());
            }
        }
    }

    private AbsNoteJob createJobs(int i) {
        JobTestLogger.log("NotesJobService/ createJobs " + i);
        return i == 1 ? new CollectionJob() : new EmptyJob(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dumpRunningJobs() {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = this.mRunningJobs.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("/");
        }
        Logger.m8700f(TAG, "dumpRunningJobs " + ((Object) sb));
    }

    private void dumpStopJobReason(JobParameters jobParameters) {
        try {
            Method method = Class.forName("android.app.job.JobParameters").getMethod("getStopReason", null);
            method.setAccessible(true);
            int iIntValue = ((Integer) method.invoke(jobParameters, null)).intValue();
            JobTestLogger.log(getClass().getSimpleName() + "/ dumpStopJobReason " + iIntValue);
            StringBuilder sb = new StringBuilder("dumpStopJobReason ");
            sb.append(iIntValue);
            Logger.m8700f(TAG, sb.toString());
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            JobTestLogger.log(getClass().getSimpleName() + "/ dumpStopJobReason error " + e.getMessage());
        }
    }

    public static synchronized NotesJobService getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new NotesJobService();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    private void scheduleJob(JobScheduler jobScheduler, int i, ComponentName componentName) {
        JobTestLogger.log("NotesJobService/ scheduleJob " + i);
        createJobs(i).schedule(jobScheduler, i, componentName);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        INoteJob iNoteJobPut;
        int jobId = jobParameters.getJobId();
        JobTestLogger.log("NotesJobService/ onStartJob " + jobId);
        Logger.m8700f(TAG, "onStartJob " + jobId);
        AbsNoteJob absNoteJobCreateJobs = createJobs(jobId);
        boolean zExecute = absNoteJobCreateJobs.execute(new FinishListener(jobParameters));
        if (zExecute && (iNoteJobPut = this.mRunningJobs.put(Integer.valueOf(jobId), absNoteJobCreateJobs)) != null) {
            iNoteJobPut.cancel();
            JobTestLogger.log("NotesJobService/ onStartJob, same job is triggered");
        }
        dumpRunningJobs();
        return zExecute;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        int jobId = jobParameters.getJobId();
        JobTestLogger.log("NotesJobService/ onStopJob " + jobId);
        Logger.m8700f(TAG, "onStopJob " + jobId);
        dumpStopJobReason(jobParameters);
        INoteJob iNoteJobRemove = this.mRunningJobs.remove(Integer.valueOf(jobId));
        if (iNoteJobRemove != null) {
            iNoteJobRemove.cancel();
        }
        dumpRunningJobs();
        return false;
    }

    public void registerJobs() {
        Logger.m8702i(TAG, "registerJobs# start");
        JobTestLogger.log("NotesJobService/ registerJobs");
        Context appContext = ApplicationManager.getInstance().getAppContext();
        scheduleJob((JobScheduler) appContext.getSystemService("jobscheduler"), 1, new ComponentName(appContext, (Class<?>) NotesJobService.class));
        Logger.m8702i(TAG, "registerJobs# end");
    }
}
