package com.samsung.android.sdk.scs.p142ai.texttospeech;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.utils.ConnectionHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class TextToSpeechServiceExecutorForExternal extends TextToSpeechServiceExecutor {
    public TextToSpeechServiceExecutorForExternal(Context context) {
        super(context);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.texttospeech.TextToSpeechServiceExecutor, com.samsung.android.sdk.scs.base.connection.ServiceExecutor
    public Intent getServiceIntent() {
        return ConnectionHelper.getTextToSpeechServiceIntentForExternal();
    }
}
