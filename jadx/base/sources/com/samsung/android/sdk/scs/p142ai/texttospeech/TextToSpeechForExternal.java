package com.samsung.android.sdk.scs.p142ai.texttospeech;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TextToSpeechForExternal extends TextToSpeech {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public TextToSpeechForExternal(@NonNull Context context) {
        super(context);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.texttospeech.TextToSpeech
    public void createExecutor(Context context) {
        this.mTTSServiceExecutor = new TextToSpeechServiceExecutorForExternal(context);
    }
}
