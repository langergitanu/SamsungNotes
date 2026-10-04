package com.samsung.android.spen.libinterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface MediaRecorderConfigInterface {
    public static final int AudioChannels = 2;
    public static final int AudioEncoder = 3;
    public static final int AudioEncodingBitRate = 128000;
    public static final int AudioSamplingRate = 44100;
    public static final int AudioSource = 1;
    public static final int OutputFormat = 1;

    int getAudioChannels();

    int getAudioEncoder();

    int getAudioEncodingBitRate();

    int getAudioSamplingRate();

    int getAudioSource();

    int getOutputFormat();

    void setAudioChannels(int i);

    void setAudioEncoder(int i);

    void setAudioEncodingBitRate(int i);

    void setAudioSamplingRate(int i);

    void setAudioSource(int i);

    void setOutputFormat(int i);
}
