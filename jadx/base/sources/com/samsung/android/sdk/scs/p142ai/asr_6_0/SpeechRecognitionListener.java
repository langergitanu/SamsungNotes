package com.samsung.android.sdk.scs.p142ai.asr_6_0;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface SpeechRecognitionListener {
    void onError(int i, String str, Bundle bundle);

    void onPartialResults(String str, Bundle bundle);

    void onResults(String str, Bundle bundle);
}
