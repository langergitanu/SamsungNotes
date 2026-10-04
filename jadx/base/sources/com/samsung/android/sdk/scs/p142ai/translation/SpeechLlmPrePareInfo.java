package com.samsung.android.sdk.scs.p142ai.translation;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SpeechLlmPrePareInfo {
    private String sourceLanguage;
    private String targetLanguage;

    public SpeechLlmPrePareInfo(@NonNull String str, @NonNull String str2) {
        this.sourceLanguage = str;
        this.targetLanguage = str2;
    }

    @NonNull
    public String getSourceLanguage() {
        return this.sourceLanguage;
    }

    @NonNull
    public String getTargetLanguage() {
        return this.targetLanguage;
    }
}
