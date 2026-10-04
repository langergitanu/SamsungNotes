package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller;

import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import kotlin.Metadata;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0007H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0007H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0007H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0007H&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u0007H&J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u0007H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u0007H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020 H&¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/VoiceRecordingEventListener;", "", "onUpdateRecordTime", "", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "time", "", "onRecordStart", "cachePath", "", "onRecordStop", "onRecordResume", "onRecordCancel", "onRecordError", "i", "onRecordPause", "onRecordPlayError", "errorCode", "onRecordPlayPrepared", XmlErrorCodes.DURATION, "onRecordPlayStart", "onRecordPlayStop", "onRecordPlayPause", "onRecordPlayResume", "onUpdateRecordPlayTime", "position", "onRecordPlayComplete", "onRecordPlayInfo", "mediaInfo", "onPlayError", "spenObjectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "onPlayPrepared", "onPlayStarted", "onPlayPaused", "onPlayResumed", "onPlayStopped", "onPlaySeekComplete", "onPlayComplete", "onPlayClicked", "objectVoice", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface VoiceRecordingEventListener {
    void onPlayClicked(@NotNull SpenObjectVoice objectVoice);

    void onPlayComplete(@NotNull SpenObjectVoice spenObjectVoice);

    void onPlayError(@NotNull SpenObjectVoice spenObjectVoice, int i);

    void onPlayPaused(@NotNull SpenObjectVoice spenObjectVoice);

    void onPlayPrepared(@NotNull SpenObjectVoice spenObjectVoice, int i);

    void onPlayResumed(@NotNull SpenObjectVoice spenObjectVoice);

    void onPlaySeekComplete(@NotNull SpenObjectVoice spenObjectVoice, int i);

    void onPlayStarted(@NotNull SpenObjectVoice spenObjectVoice);

    void onPlayStopped(@NotNull SpenObjectVoice spenObjectVoice);

    void onRecordCancel(@NotNull SpenVoiceData voiceData);

    void onRecordError(@NotNull SpenVoiceData voiceData, int i);

    void onRecordPause(@NotNull SpenVoiceData voiceData);

    void onRecordPlayComplete(@NotNull SpenVoiceData voiceData);

    void onRecordPlayError(@NotNull SpenVoiceData voiceData, int errorCode);

    void onRecordPlayInfo(@NotNull SpenVoiceData voiceData, int mediaInfo);

    void onRecordPlayPause(@NotNull SpenVoiceData voiceData);

    void onRecordPlayPrepared(@NotNull SpenVoiceData voiceData, int duration);

    void onRecordPlayResume(@NotNull SpenVoiceData voiceData);

    void onRecordPlayStart(@NotNull SpenVoiceData voiceData);

    void onRecordPlayStop(@NotNull SpenVoiceData voiceData);

    void onRecordResume(@NotNull SpenVoiceData voiceData);

    void onRecordStart(@NotNull SpenVoiceData voiceData, @NotNull String cachePath);

    void onRecordStop(@NotNull SpenVoiceData voiceData);

    void onUpdateRecordPlayTime(@NotNull SpenVoiceData voiceData, int position);

    void onUpdateRecordTime(@NotNull SpenVoiceData voiceData, int time);
}
