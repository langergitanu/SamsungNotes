package com.samsung.android.spen.libinterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface MediaRecorderInterface {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ActionListener {
        void onError(int i, int i2);

        void onInfo(int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MediaRecorderListener {
        void onError();

        void onPaused();

        void onResumed();

        void onStarted();

        void onStopped();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TimeListener {
        void onUpdateTime(int i);
    }

    boolean cancel();

    int getMaxAmplitude();

    boolean isPauseSupported();

    boolean isStarting();

    boolean pause(MediaRecorderListener mediaRecorderListener);

    void prepare();

    boolean prepareRecording(String str, int i, int i2);

    void release();

    void reset();

    boolean resume(MediaRecorderListener mediaRecorderListener);

    void setActionListener(ActionListener actionListener);

    void setAudioEncoder(int i);

    void setAudioSource(int i);

    void setMediaRecorderConfig(MediaRecorderConfigInterface mediaRecorderConfigInterface);

    void setOutputFile(String str);

    void setOutputFormat(int i);

    void setTimeListener(TimeListener timeListener);

    boolean start(String str, MediaRecorderListener mediaRecorderListener, int i, int i2);

    boolean stop(MediaRecorderListener mediaRecorderListener);
}
