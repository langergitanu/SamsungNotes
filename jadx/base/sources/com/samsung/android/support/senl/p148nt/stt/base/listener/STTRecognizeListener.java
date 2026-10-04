package com.samsung.android.support.senl.p148nt.stt.base.listener;

import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J>\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H&J>\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/listener/STTRecognizeListener;", "", "onError", "", "sessionID", "", "errorCode", "", "message", "onResultWord", "recognizeText", "timingInfo", "", "speechInfoList", "", "Lcom/samsung/android/sivs/ai/sdkcommon/asr/SpeechInfo;", "isNeedGetRawText", "", "onPartialResultWord", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface STTRecognizeListener {
    void onError(@Nullable String sessionID, int errorCode, @Nullable String message);

    void onPartialResultWord(@Nullable String sessionID, @Nullable String recognizeText, @Nullable int[] timingInfo, @Nullable List<? extends SpeechInfo> speechInfoList, boolean isNeedGetRawText);

    void onResultWord(@Nullable String sessionID, @Nullable String recognizeText, @Nullable int[] timingInfo, @Nullable List<? extends SpeechInfo> speechInfoList, boolean isNeedGetRawText);
}
