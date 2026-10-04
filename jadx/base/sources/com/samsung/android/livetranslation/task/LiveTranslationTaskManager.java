package com.samsung.android.livetranslation.task;

import android.content.Context;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.livetranslation.task.LiveTranslationTask;
import com.samsung.android.livetranslation.text.KeyFrame;
import com.samsung.android.livetranslation.util.LTTLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LiveTranslationTaskManager {
    private Context mContext;
    private KeyFrame mKeyFrame;
    private LiveTranslationTaskManagerListener mLiveTranslationTaskManagerListener;
    private STATUS mStatus;
    private final String TAG = "LiveTranslationTaskManager";
    private List<LiveTranslationTask> mSTRTasks = new ArrayList();
    private List<LiveTranslationTask> mPostSTRTasks = new ArrayList();
    private List<LiveTranslationTask> mPostTRLTasks = new ArrayList();

    /* JADX INFO: renamed from: com.samsung.android.livetranslation.task.LiveTranslationTaskManager$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C71591 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$livetranslation$task$LiveTranslationTask$TASKTYPE */
        static final /* synthetic */ int[] f4813xb8d27437;

        static {
            int[] iArr = new int[LiveTranslationTask.TASKTYPE.values().length];
            f4813xb8d27437 = iArr;
            try {
                iArr[LiveTranslationTask.TASKTYPE.ENTIRE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4813xb8d27437[LiveTranslationTask.TASKTYPE.POST_STR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4813xb8d27437[LiveTranslationTask.TASKTYPE.POST_TRL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LiveTranslationTaskManagerListener {
        void onSTRFinish(boolean z, KeyFrame keyFrame, LttOcrResult lttOcrResult, int i);

        void onTRLFinish(boolean z, KeyFrame keyFrame, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum STATUS {
        STR_PREPARING,
        STR_WAITING,
        STR_ARRIVED,
        STR_FAIL,
        STR_COMPLETED,
        TRL_PREPARING,
        TRL_WAITING,
        TRL_ARRIVED,
        TRL_FAIL,
        TRL_COMPLETED,
        CANCELED
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class TaskStatusListenerImpl implements LiveTranslationTask.TaskStatusListener {
        public TaskStatusListenerImpl() {
        }

        @Override // com.samsung.android.livetranslation.task.LiveTranslationTask.TaskStatusListener
        public synchronized void updateStatus(STATUS status) {
            LiveTranslationTaskManager.this.mStatus = status;
        }
    }

    public LiveTranslationTaskManager(Context context, KeyFrame keyFrame, Rect rect, LiveTranslationTaskManagerListener liveTranslationTaskManagerListener, String str, boolean z) {
        this.mContext = context;
        this.mKeyFrame = keyFrame;
        this.mLiveTranslationTaskManagerListener = liveTranslationTaskManagerListener;
        this.mSTRTasks.clear();
        this.mPostSTRTasks.clear();
        this.mPostTRLTasks.clear();
    }

    private void cancelTask(@NonNull List<LiveTranslationTask> list) {
        Iterator<LiveTranslationTask> it = list.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    @Nullable
    private static <T> T getLastElement(@NonNull List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return (T) AbstractC0000a.m10g(list, 1);
    }

    private boolean isValidCPs() {
        return this.mKeyFrame.isValidSTRCP() && this.mKeyFrame.isValidTRLCP();
    }

    private synchronized void updateStatus(STATUS status) {
        try {
            if (STATUS.CANCELED != this.mStatus) {
                this.mStatus = status;
            } else {
                LTTLogger.m5582e(this.TAG, "updateStatus() But current Status is STATUS.CANCELED , It can NOT change to newStatus:" + status);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void cancel() {
        updateStatus(STATUS.CANCELED);
        cancelTask(this.mPostTRLTasks);
        cancelTask(this.mPostSTRTasks);
        cancelTask(this.mSTRTasks);
    }

    public STATUS getStatus() {
        return this.mStatus;
    }

    public void requestTask(String str, String str2, LiveTranslationTask.TASKTYPE tasktype, LttOcrResult lttOcrResult) {
        requestTask(str, str2, tasktype, lttOcrResult, null);
    }

    public void requestTaskPostTRL(String str, String str2, List<String> list) {
        requestTask(str, str2, LiveTranslationTask.TASKTYPE.POST_TRL, null, list);
    }

    private synchronized void requestTask(String str, String str2, LiveTranslationTask.TASKTYPE tasktype, LttOcrResult lttOcrResult, List<String> list) {
        LTTLogger.m5581d(this.TAG, "requestTask() : srcLang=" + str + ", tarLang=" + str2 + ", taskType=" + tasktype);
        if (!isValidCPs()) {
            LTTLogger.m5582e(this.TAG, "Unexpected CP : STR_CP=" + this.mKeyFrame.getSTRCP() + " TRL_CP=" + this.mKeyFrame.getTRLCP());
            return;
        }
        if (this.mStatus == STATUS.CANCELED) {
            LTTLogger.m5582e(this.TAG, "requestTask() is canceled Task.......  return");
            return;
        }
        int i = C71591.f4813xb8d27437[tasktype.ordinal()];
        if (i == 1 || i == 2) {
            PostSTRTask postSTRTask = new PostSTRTask(this.mKeyFrame, new TaskStatusListenerImpl(), this.mContext, this.mLiveTranslationTaskManagerListener, lttOcrResult);
            postSTRTask.execute(new Void[0]);
            this.mPostSTRTasks.add(postSTRTask);
        } else if (i == 3) {
            this.mKeyFrame.setTRLReqString(list);
            PostTRLTask postTRLTask = new PostTRLTask(this.mKeyFrame, new TaskStatusListenerImpl(), this.mContext, this.mLiveTranslationTaskManagerListener, list);
            postTRLTask.execute(new Void[0]);
            this.mPostTRLTasks.add(postTRLTask);
        }
    }
}
