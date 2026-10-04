package com.samsung.android.sdk.composer.voice;

import android.util.Log;
import com.samsung.android.spen.libinterface.MediaRecorderConfigInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/SpenMediaRecorderConfig;", "Lcom/samsung/android/spen/libinterface/MediaRecorderConfigInterface;", "<init>", "()V", "mAudioEncodingBitRate", "", "mAudioSamplingRate", "mAudioChannels", "mAudioSource", "mAudioEncoder", "mOutputFormat", "setAudioEncodingBitRate", "", "encodingBitRate", "getAudioEncodingBitRate", "setAudioSamplingRate", "samplingRate", "getAudioSamplingRate", "setAudioChannels", "audioChannels", "getAudioChannels", "setAudioSource", "audioSource", "getAudioSource", "setAudioEncoder", "audioEncoder", "getAudioEncoder", "setOutputFormat", "outputFormat", "getOutputFormat", "copy", "recorderConfig", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMediaRecorderConfig implements MediaRecorderConfigInterface {

    @NotNull
    private static final String TAG = "SpenMediaRecorderConfig";
    private int mAudioEncodingBitRate = MediaRecorderConfigInterface.AudioEncodingBitRate;
    private int mAudioSamplingRate = MediaRecorderConfigInterface.AudioSamplingRate;
    private int mAudioChannels = 2;
    private int mAudioSource = 1;
    private int mAudioEncoder = 3;
    private int mOutputFormat = 1;

    public SpenMediaRecorderConfig() {
        Log.i(TAG, "SpenMediaRecorderConfig()");
    }

    public final void copy(@Nullable SpenMediaRecorderConfig recorderConfig) {
        if (recorderConfig == null) {
            return;
        }
        this.mAudioEncodingBitRate = recorderConfig.getMAudioEncodingBitRate();
        this.mAudioSamplingRate = recorderConfig.getMAudioSamplingRate();
        this.mAudioChannels = recorderConfig.getMAudioChannels();
        this.mAudioSource = recorderConfig.getMAudioSource();
        this.mAudioEncoder = recorderConfig.getMAudioEncoder();
        this.mOutputFormat = recorderConfig.getMOutputFormat();
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderConfigInterface
    /* JADX INFO: renamed from: getAudioChannels, reason: from getter */
    public int getMAudioChannels() {
        return this.mAudioChannels;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderConfigInterface
    /* JADX INFO: renamed from: getAudioEncoder, reason: from getter */
    public int getMAudioEncoder() {
        return this.mAudioEncoder;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderConfigInterface
    /* JADX INFO: renamed from: getAudioEncodingBitRate, reason: from getter */
    public int getMAudioEncodingBitRate() {
        return this.mAudioEncodingBitRate;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderConfigInterface
    /* JADX INFO: renamed from: getAudioSamplingRate, reason: from getter */
    public int getMAudioSamplingRate() {
        return this.mAudioSamplingRate;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderConfigInterface
    /* JADX INFO: renamed from: getAudioSource, reason: from getter */
    public int getMAudioSource() {
        return this.mAudioSource;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderConfigInterface
    /* JADX INFO: renamed from: getOutputFormat, reason: from getter */
    public int getMOutputFormat() {
        return this.mOutputFormat;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderConfigInterface
    public void setAudioChannels(int audioChannels) {
        this.mAudioChannels = audioChannels;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderConfigInterface
    public void setAudioEncoder(int audioEncoder) {
        this.mAudioEncoder = audioEncoder;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderConfigInterface
    public void setAudioEncodingBitRate(int encodingBitRate) {
        this.mAudioEncodingBitRate = encodingBitRate;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderConfigInterface
    public void setAudioSamplingRate(int samplingRate) {
        this.mAudioSamplingRate = samplingRate;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderConfigInterface
    public void setAudioSource(int audioSource) {
        this.mAudioSource = audioSource;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderConfigInterface
    public void setOutputFormat(int outputFormat) {
        this.mOutputFormat = outputFormat;
    }
}
