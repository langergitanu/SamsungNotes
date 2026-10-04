package com.samsung.android.sdk.smp;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.app.job.JobWorkItem;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.task.SMarketingTask;
import com.samsung.android.sdk.smp.task.STask;
import com.samsung.android.sdk.smp.taskhandler.STaskHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@TargetApi(26)
public class SmpJobService extends JobService {
    private static final String KEY_JOBPARAMS = "JOBPARAMS";
    private static final String TAG = "SmpJobService";
    private volatile JobServiceHandler mServiceHandler;
    private volatile Looper mServiceLooper;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class JobServiceHandler extends Handler {
        private boolean mIsServiceRunning;

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceRunning(boolean z) {
            this.mIsServiceRunning = z;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                JobParameters jobParameters = (JobParameters) message.getData().getParcelable(SmpJobService.KEY_JOBPARAMS);
                if (jobParameters != null) {
                    while (true) {
                        JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                        if (jobWorkItemDequeueWork == null) {
                            break;
                        }
                        if (jobWorkItemDequeueWork.getIntent() != null) {
                            STaskHandler.handle(SmpJobService.this.getApplicationContext(), STask.fromBundle(jobWorkItemDequeueWork.getIntent().getExtras()));
                        }
                        jobParameters.completeWork(jobWorkItemDequeueWork);
                    }
                    if (this.mIsServiceRunning) {
                        SmpJobService.this.jobFinished(jobParameters, false);
                    }
                }
            } catch (Exception e) {
                SmpLog.m6501w(SmpJobService.TAG, "Error while handling job. " + e.toString());
            }
        }

        private JobServiceHandler(Looper looper) {
            super(looper);
            this.mIsServiceRunning = true;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        SmpLog.m6492d(TAG, "onCreate");
        HandlerThread handlerThread = new HandlerThread("SmpJobService");
        handlerThread.start();
        this.mServiceLooper = handlerThread.getLooper();
        this.mServiceHandler = new JobServiceHandler(this.mServiceLooper);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        SmpLog.m6492d(TAG, "onDestroy");
        if (this.mServiceHandler != null) {
            this.mServiceHandler.setServiceRunning(false);
            this.mServiceHandler = null;
        }
        if (this.mServiceLooper != null) {
            this.mServiceLooper.quit();
            this.mServiceLooper = null;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.mServiceHandler == null) {
            SmpLog.m6501w(TAG, "already destroyed");
            return true;
        }
        Message messageObtainMessage = this.mServiceHandler.obtainMessage();
        messageObtainMessage.what = jobParameters.getJobId();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_JOBPARAMS, jobParameters);
        messageObtainMessage.setData(bundle);
        this.mServiceHandler.sendMessage(messageObtainMessage);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        String str = TAG;
        SmpLog.m6498i(str, "onStopJob - " + jobParameters.getJobId());
        int jobId = jobParameters.getJobId();
        if (!SMarketingTask.isBasicMarketingTask(jobId)) {
            return false;
        }
        SmpLog.m6498i(str, "[" + jobId + "] reschedule marketing job");
        return true;
    }
}
