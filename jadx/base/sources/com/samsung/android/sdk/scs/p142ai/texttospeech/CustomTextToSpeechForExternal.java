package com.samsung.android.sdk.scs.p142ai.texttospeech;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CustomTextToSpeechForExternal extends CustomTextToSpeech {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public CustomTextToSpeechForExternal(@NonNull Context context) {
        super(context);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.texttospeech.TextToSpeech
    public void createExecutor(Context context) {
        this.mTTSServiceExecutor = new TextToSpeechServiceExecutorForExternal(context);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.texttospeech.CustomTextToSpeech
    public int openCustomVoice(@NonNull String str) {
        if (!checkConnection()) {
            return -4;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        String strCallerName = this.mTTSServiceExecutor.callerName();
        String customVoicePackageName = getCustomVoicePackageName(strCallerName, iCallerId, str);
        if (customVoicePackageName != null && !customVoicePackageName.equals("")) {
            List<String> availableCustomVoiceLanguages = getAvailableCustomVoiceLanguages();
            if (str != null && availableCustomVoiceLanguages.size() != 0 && availableCustomVoiceLanguages.contains(str)) {
                Intent intent = new Intent("com.samsung.android.ptts.action.CREATE_PERSONAL_VOICE_FOR_EXTERNAL");
                try {
                    intent.setPackage(customVoicePackageName);
                    intent.addFlags(335544352);
                    intent.putExtra("callerName", strCallerName);
                    intent.putExtra("externalCall", true);
                    this.mContext.startActivity(intent);
                    return 0;
                } catch (ActivityNotFoundException unused) {
                    Log.i("ScsApi@TTS", "Can't find compatible custom voice.");
                    return openCustomVoiceDeepLink(str);
                }
            }
        }
        return -51;
    }
}
