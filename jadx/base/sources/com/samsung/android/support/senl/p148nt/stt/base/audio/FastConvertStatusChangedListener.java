package com.samsung.android.support.senl.p148nt.stt.base.audio;

import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechInfo;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H&J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0018\u001a\u00020\u0003H&¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertStatusChangedListener;", "", "onResultWord", "", "recognizeText", "", "timingInfo", "", "speechInfoList", "", "Lcom/samsung/android/sivs/ai/sdkcommon/asr/SpeechInfo;", "isNeedGetRawText", "", "onRecognitionStart", "onProgressUpdate", "percent", "", "onLocaleChanged", "locale", "Ljava/util/Locale;", "onNoLangPackInstalled", "mChangedLocale", "onError", "error", "onNoMatch", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface FastConvertStatusChangedListener {
    void onError(@Nullable String error);

    void onLocaleChanged(@Nullable Locale locale);

    void onNoLangPackInstalled(@Nullable Locale mChangedLocale);

    void onNoMatch();

    void onProgressUpdate(int percent);

    void onRecognitionStart();

    void onResultWord(@Nullable String recognizeText, @Nullable int[] timingInfo, @Nullable List<? extends SpeechInfo> speechInfoList, boolean isNeedGetRawText);
}
