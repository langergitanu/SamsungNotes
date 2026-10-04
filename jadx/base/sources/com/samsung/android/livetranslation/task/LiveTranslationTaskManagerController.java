package com.samsung.android.livetranslation.task;

import android.content.Context;
import android.graphics.Rect;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.livetranslation.task.LiveTranslationTask;
import com.samsung.android.livetranslation.task.LiveTranslationTaskManager;
import com.samsung.android.livetranslation.text.KeyFrame;
import com.samsung.android.livetranslation.util.LTTLogger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LiveTranslationTaskManagerController {
    private static final String TAG = "LiveTranslationTaskManagerController";
    private boolean mIsPreviewMode;
    private String mLaunchModeName;
    private ArrayList<LiveTranslationTaskManager> mLiveTranslationTaskManagers;

    public LiveTranslationTaskManagerController(boolean z) {
        this.mIsPreviewMode = z;
        init();
    }

    public int getManagerSize() {
        return this.mLiveTranslationTaskManagers.size();
    }

    public void init() {
        this.mLiveTranslationTaskManagers = new ArrayList<>();
    }

    public synchronized void release() {
        try {
            LTTLogger.m5581d(TAG, "release()");
            if (this.mLiveTranslationTaskManagers != null) {
                for (int i = 0; i < this.mLiveTranslationTaskManagers.size(); i++) {
                    this.mLiveTranslationTaskManagers.get(i).cancel();
                }
                this.mLiveTranslationTaskManagers.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void requestNewTask(Context context, KeyFrame keyFrame, Rect rect, LiveTranslationTask.TASKTYPE tasktype, LiveTranslationTaskManager.LiveTranslationTaskManagerListener liveTranslationTaskManagerListener, LttOcrResult lttOcrResult) {
        this.mLiveTranslationTaskManagers.add(new LiveTranslationTaskManager(context, keyFrame, rect, liveTranslationTaskManagerListener, this.mLaunchModeName, this.mIsPreviewMode));
        ((LiveTranslationTaskManager) AbstractC1974b.m1313f(1, this.mLiveTranslationTaskManagers)).requestTask(keyFrame.getSrcLang(), keyFrame.getTarLang(), tasktype, lttOcrResult);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x003e, code lost:
    
        r1.requestTaskPostTRL(r6, r7, r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void requestSuccessiveTRL(String str, String str2, List<String> list) {
        int size = this.mLiveTranslationTaskManagers.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            LiveTranslationTaskManager liveTranslationTaskManager = this.mLiveTranslationTaskManagers.get(size);
            LTTLogger.m5581d(TAG, "onSTRFinish : idx=" + size + "Status=" + liveTranslationTaskManager.getStatus());
            if (liveTranslationTaskManager.getStatus() == LiveTranslationTaskManager.STATUS.STR_COMPLETED) {
                break;
            } else {
                size--;
            }
        }
    }

    public void requestTask(int i, String str, String str2, LiveTranslationTask.TASKTYPE tasktype) {
        this.mLiveTranslationTaskManagers.get(i).requestTask(str, str2, tasktype, null);
    }
}
