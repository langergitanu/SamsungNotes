package com.samsung.android.spen.libse;

import android.media.MediaRecorder;
import android.os.AsyncTask;
import android.util.Log;
import com.samsung.android.spen.libinterface.MediaRecorderConfigInterface;
import com.samsung.android.spen.libinterface.MediaRecorderInterface;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SeMediaRecorder implements MediaRecorderInterface {
    private static final String TAG = "SemMediaRecorder";
    private static final long mMaxWaitTime = 1000;
    private static long mWaitTimeForStartRecording;
    MediaRecorder mSepMediaRecorder;
    private MediaRecorderConfigInterface mMediaRecorderConfig = null;
    private Executor SINGLE_THREAD_EXECUTOR = Executors.newSingleThreadExecutor();
    private MediaRecorderAsyncTask mRecorderAsyncTask = new MediaRecorderAsyncTask();
    private String mResultFilePath = null;
    private MediaRecorder.OnInfoListener mInfoListener = new MediaRecorder.OnInfoListener() { // from class: com.samsung.android.spen.libse.SeMediaRecorder.1
        @Override // android.media.MediaRecorder.OnInfoListener
        public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
            if (SeMediaRecorder.this.mListener != null) {
                if (i != 901) {
                    SeMediaRecorder.this.mListener.onInfo(i, i2);
                } else {
                    SeMediaRecorder.this.mTimeListener.onUpdateTime(i2 / 1000);
                }
            }
        }
    };
    private MediaRecorder.OnErrorListener mErrorListener = new MediaRecorder.OnErrorListener() { // from class: com.samsung.android.spen.libse.SeMediaRecorder.2
        @Override // android.media.MediaRecorder.OnErrorListener
        public void onError(MediaRecorder mediaRecorder, int i, int i2) {
            if (SeMediaRecorder.this.mListener != null) {
                SeMediaRecorder.this.mListener.onError(i, i2);
            }
        }
    };
    private MediaRecorderInterface.ActionListener mListener = null;
    private MediaRecorderInterface.TimeListener mTimeListener = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MediaRecorderAsyncTask extends AsyncTask<MediaRecorderInterface.MediaRecorderListener, Integer, Boolean> {
        private MediaRecorderInterface.MediaRecorderListener mListener = null;
        public int mMaxDuration = 0;
        public int mMaxFileSize = 0;
        private RecorderTaskState mState = RecorderTaskState.IDLE;

        public MediaRecorderAsyncTask() {
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        public boolean run(MediaRecorderInterface.MediaRecorderListener mediaRecorderListener) {
            if (getStatus() != AsyncTask.Status.RUNNING) {
                synchronized (this) {
                    this.mState = RecorderTaskState.READY;
                }
                executeOnExecutor(SeMediaRecorder.this.SINGLE_THREAD_EXECUTOR, mediaRecorderListener);
                return true;
            }
            Log.d(SeMediaRecorder.TAG, "previous RecorderTask is not finished(" + getStatus() + "). Skip run.");
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Boolean doInBackground(MediaRecorderInterface.MediaRecorderListener... mediaRecorderListenerArr) {
            Log.d(SeMediaRecorder.TAG, "doInBackground");
            synchronized (this) {
                try {
                    if (this.mState != RecorderTaskState.READY) {
                        Log.d(SeMediaRecorder.TAG, "invalid RecorderTask state(" + this.mState + "). Skip doInBackground.");
                        return Boolean.FALSE;
                    }
                    this.mState = RecorderTaskState.DO_IN_BACKGROUND;
                    Boolean bool = Boolean.FALSE;
                    MediaRecorderInterface.MediaRecorderListener mediaRecorderListener = mediaRecorderListenerArr[0];
                    this.mListener = mediaRecorderListener;
                    if (mediaRecorderListener != null) {
                        SeMediaRecorder seMediaRecorder = SeMediaRecorder.this;
                        if (seMediaRecorder.prepareRecording(seMediaRecorder.mResultFilePath, this.mMaxDuration, this.mMaxFileSize) && SeMediaRecorder.this.startImpl()) {
                            SeMediaRecorder seMediaRecorder2 = SeMediaRecorder.this;
                            MediaRecorder mediaRecorder = seMediaRecorder2.mSepMediaRecorder;
                            if (mediaRecorder != null) {
                                mediaRecorder.setOnInfoListener(seMediaRecorder2.mInfoListener);
                                SeMediaRecorder seMediaRecorder3 = SeMediaRecorder.this;
                                seMediaRecorder3.mSepMediaRecorder.setOnErrorListener(seMediaRecorder3.mErrorListener);
                            }
                            bool = Boolean.TRUE;
                        } else {
                            SeMediaRecorder.this.reset();
                            SeMediaRecorder.this.release();
                            SeMediaRecorder seMediaRecorder4 = SeMediaRecorder.this;
                            seMediaRecorder4.mSepMediaRecorder = null;
                            seMediaRecorder4.mMediaRecorderConfig = null;
                        }
                    }
                    synchronized (this) {
                        notify();
                        this.mState = RecorderTaskState.ON_POST_EXECUTE;
                    }
                    return bool;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.os.AsyncTask
        public void onCancelled(Boolean bool) {
            super.onCancelled(bool);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            if (this.mState != RecorderTaskState.ON_POST_EXECUTE) {
                Log.d(SeMediaRecorder.TAG, "invalid RecorderTask state(" + this.mState + "). Skip onPostExecute.");
                return;
            }
            if (bool.booleanValue()) {
                Log.d(SeMediaRecorder.TAG, "onPostExecute: success");
                if (this.mListener != null) {
                    SeMediaRecorder.setWaitTimeForStartRecording(500L);
                    this.mListener.onStarted();
                }
            } else {
                Log.d(SeMediaRecorder.TAG, "onPostExecute: fail");
                MediaRecorderInterface.MediaRecorderListener mediaRecorderListener = this.mListener;
                if (mediaRecorderListener != null) {
                    mediaRecorderListener.onError();
                }
            }
            this.mState = RecorderTaskState.IDLE;
        }

        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            super.onCancelled();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum RecorderTaskState {
        IDLE,
        READY,
        DO_IN_BACKGROUND,
        ON_POST_EXECUTE
    }

    public static boolean isRecorderWorking() {
        try {
            Class<?> cls = Class.forName("android.media.MediaRecorder");
            Method declaredMethod = cls.getDeclaredMethod("semIsRecording", null);
            if (declaredMethod != null) {
                Object objInvoke = declaredMethod.invoke(cls, null);
                if (objInvoke instanceof Boolean) {
                    return objInvoke == Boolean.TRUE;
                }
            }
        } catch (NoSuchMethodException unused) {
            Log.e(TAG, "NoSuchMethodException");
        } catch (Exception unused2) {
            Log.e(TAG, "Exception");
        }
        return false;
    }

    private void printLog(Throwable th) {
        Log.e(TAG, Log.getStackTraceString(th));
    }

    private void setDurationInterval(int i) {
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.semSetDurationInterval(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setWaitTimeForStartRecording(long j) {
        mWaitTimeForStartRecording = System.currentTimeMillis() + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startImpl() {
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder == null) {
            return false;
        }
        try {
            mediaRecorder.start();
            return true;
        } catch (Exception e) {
            printLog(e);
            return false;
        }
    }

    private static void waitForStartRecording() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = mWaitTimeForStartRecording;
        if (jCurrentTimeMillis < j) {
            long j2 = j - jCurrentTimeMillis;
            if (j2 > 1000) {
                j2 = 1000;
            }
            try {
                Thread.sleep(j2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean cancel() {
        waitForStartRecording();
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        boolean z = false;
        if (mediaRecorder == null) {
            return false;
        }
        try {
            mediaRecorder.stop();
            reset();
            release();
            z = true;
        } catch (Exception e) {
            printLog(e);
        }
        this.mSepMediaRecorder = null;
        this.mMediaRecorderConfig = null;
        return z;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public int getMaxAmplitude() {
        try {
            MediaRecorder mediaRecorder = this.mSepMediaRecorder;
            if (mediaRecorder != null) {
                return mediaRecorder.getMaxAmplitude();
            }
            return -1;
        } catch (Exception e) {
            printLog(e);
            return -1;
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean isPauseSupported() {
        return true;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean isStarting() {
        return this.mRecorderAsyncTask.getStatus() == AsyncTask.Status.RUNNING;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean pause(MediaRecorderInterface.MediaRecorderListener mediaRecorderListener) {
        waitForStartRecording();
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.pause();
                mediaRecorderListener.onPaused();
                return true;
            } catch (Exception e) {
                printLog(e);
            }
        }
        return false;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void prepare() throws IOException {
        Log.d(TAG, "prepare");
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.prepare();
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean prepareRecording(String str, int i, int i2) {
        try {
            Log.d(TAG, "prepareRecording");
            this.mSepMediaRecorder = new MediaRecorder();
            MediaRecorderConfigInterface mediaRecorderConfigInterface = this.mMediaRecorderConfig;
            setAudioSamplingRate(mediaRecorderConfigInterface != null ? mediaRecorderConfigInterface.getAudioSamplingRate() : MediaRecorderConfigInterface.AudioSamplingRate);
            MediaRecorderConfigInterface mediaRecorderConfigInterface2 = this.mMediaRecorderConfig;
            setAudioEncodingBitRate(mediaRecorderConfigInterface2 != null ? mediaRecorderConfigInterface2.getAudioEncodingBitRate() : MediaRecorderConfigInterface.AudioEncodingBitRate);
            MediaRecorderConfigInterface mediaRecorderConfigInterface3 = this.mMediaRecorderConfig;
            setAudioChannels(mediaRecorderConfigInterface3 != null ? mediaRecorderConfigInterface3.getAudioChannels() : 2);
            MediaRecorderConfigInterface mediaRecorderConfigInterface4 = this.mMediaRecorderConfig;
            setAudioSource(mediaRecorderConfigInterface4 != null ? mediaRecorderConfigInterface4.getAudioSource() : 1);
            MediaRecorderConfigInterface mediaRecorderConfigInterface5 = this.mMediaRecorderConfig;
            setOutputFormat(mediaRecorderConfigInterface5 != null ? mediaRecorderConfigInterface5.getOutputFormat() : 1);
            MediaRecorderConfigInterface mediaRecorderConfigInterface6 = this.mMediaRecorderConfig;
            setAudioEncoder(mediaRecorderConfigInterface6 != null ? mediaRecorderConfigInterface6.getAudioEncoder() : 3);
            setOutputFile(str);
            setMaxDuration(i);
            setMaxFileSize(i2);
            setDurationInterval(1000);
            prepare();
            return true;
        } catch (IllegalStateException e) {
            printLog(e);
            return false;
        } catch (RuntimeException e2) {
            printLog(e2);
            return false;
        } catch (Exception e3) {
            printLog(e3);
            return false;
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void release() {
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.release();
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void reset() {
        Log.d(TAG, "reset");
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.reset();
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean resume(MediaRecorderInterface.MediaRecorderListener mediaRecorderListener) {
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.resume();
                mediaRecorderListener.onResumed();
                return true;
            } catch (Exception e) {
                printLog(e);
            }
        }
        return false;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void setActionListener(MediaRecorderInterface.ActionListener actionListener) {
        this.mListener = actionListener;
    }

    public void setAudioChannels(int i) {
        Log.d(TAG, "setAudioChannels");
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setAudioChannels(i);
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void setAudioEncoder(int i) {
        Log.d(TAG, "setAudioEncoder");
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setAudioEncoder(i);
        }
    }

    public void setAudioEncodingBitRate(int i) {
        Log.d(TAG, "setAudioEncodingBitRate");
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setAudioEncodingBitRate(i);
        }
    }

    public void setAudioSamplingRate(int i) {
        Log.d(TAG, "setAudioSamplingRate");
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setAudioSamplingRate(i);
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void setAudioSource(int i) {
        Log.d(TAG, "setAudioSource");
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setAudioSource(i);
        }
    }

    public void setMaxDuration(int i) {
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setMaxDuration(i);
        }
    }

    public void setMaxFileSize(long j) {
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setMaxFileSize(j);
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void setMediaRecorderConfig(MediaRecorderConfigInterface mediaRecorderConfigInterface) {
        this.mMediaRecorderConfig = mediaRecorderConfigInterface;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void setOutputFile(String str) {
        Log.d(TAG, "setOutputFile");
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setOutputFile(str);
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void setOutputFormat(int i) {
        Log.d(TAG, "setOutputFormat");
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setOutputFormat(i);
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void setTimeListener(MediaRecorderInterface.TimeListener timeListener) {
        this.mTimeListener = timeListener;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean start(String str, MediaRecorderInterface.MediaRecorderListener mediaRecorderListener, int i, int i2) {
        Log.d(TAG, "start");
        setWaitTimeForStartRecording(1000L);
        this.mResultFilePath = str;
        MediaRecorderAsyncTask mediaRecorderAsyncTask = this.mRecorderAsyncTask;
        mediaRecorderAsyncTask.mMaxDuration = i;
        mediaRecorderAsyncTask.mMaxFileSize = i2;
        return mediaRecorderAsyncTask.run(mediaRecorderListener);
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean stop(MediaRecorderInterface.MediaRecorderListener mediaRecorderListener) {
        Log.d(TAG, "stop");
        waitForStartRecording();
        MediaRecorder mediaRecorder = this.mSepMediaRecorder;
        boolean z = false;
        if (mediaRecorder == null) {
            return false;
        }
        try {
            mediaRecorder.stop();
            reset();
            release();
            z = true;
        } catch (Exception e) {
            printLog(e);
        }
        this.mSepMediaRecorder = null;
        this.mMediaRecorderConfig = null;
        mediaRecorderListener.onStopped();
        return z;
    }
}
