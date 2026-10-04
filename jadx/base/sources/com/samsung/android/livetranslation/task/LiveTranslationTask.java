package com.samsung.android.livetranslation.task;

import android.os.AsyncTask;
import com.samsung.android.livetranslation.task.LiveTranslationTaskManager;
import com.samsung.android.livetranslation.text.KeyFrame;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class LiveTranslationTask extends AsyncTask<Void, Void, Boolean> {
    KeyFrame mKeyFrame;
    TaskStatusListener mStatusListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ERRORTYPE {
        public static final int ERR_INVALID_PARSING_DATA = 3003;
        public static final int ERR_NO_ERROR = 3005;
        public static final int ERR_SAME_LANGUAGE = 3004;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TASKTYPE {
        ENTIRE,
        POST_STR,
        POST_TRL
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TaskStatusListener {
        void updateStatus(LiveTranslationTaskManager.STATUS status);
    }

    public LiveTranslationTask(KeyFrame keyFrame, TaskStatusListener taskStatusListener) {
        this.mKeyFrame = keyFrame;
        this.mStatusListener = taskStatusListener;
    }

    public void cancel() {
    }

    @Override // android.os.AsyncTask
    public abstract Boolean doInBackground(Void... voidArr);

    @Override // android.os.AsyncTask
    public abstract void onPostExecute(Boolean bool);
}
