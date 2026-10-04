package com.samsung.android.sdk.scs.p142ai.texttospeech;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.texttospeech.TextToSpeech;
import com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesizerInitCallback;
import com.samsung.android.sivs.p144ai.sdkcommon.tts.Voice;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CustomTextToSpeech extends TextToSpeech {
    public CustomTextToSpeech(@NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$bindSynthesizer$0(TextToSpeech.OnConntectListener onConntectListener, Task task) {
        if (task.isSuccessful() || onConntectListener == null) {
            return;
        }
        onConntectListener.onConnected(-2);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.texttospeech.TextToSpeech
    public int bindSynthesizer(@NonNull final TextToSpeech.OnConntectListener onConntectListener) {
        CreateCustomVoiceSynthesizerRunnable createCustomVoiceSynthesizerRunnable = new CreateCustomVoiceSynthesizerRunnable(this.mTTSServiceExecutor, new ISynthesizerInitCallback.Stub() { // from class: com.samsung.android.sdk.scs.ai.texttospeech.CustomTextToSpeech.1
            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesizerInitCallback
            public void onConnected(int i) {
                AbstractC2322a.m1631u(i, "onConnected : ", "ScsApi@TTS");
                TextToSpeech.OnConntectListener onConntectListener2 = onConntectListener;
                if (onConntectListener2 != null) {
                    onConntectListener2.onConnected(i);
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesizerInitCallback
            public void onDisconnected() {
                TextToSpeech.OnConntectListener onConntectListener2 = onConntectListener;
                if (onConntectListener2 != null) {
                    onConntectListener2.onDisconnected();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesizerInitCallback
            public void onVoiceUpdated(List<Voice> list) {
                TextToSpeech.OnConntectListener onConntectListener2 = onConntectListener;
                if (onConntectListener2 != null) {
                    onConntectListener2.onVoiceUpdated(list);
                }
            }
        });
        this.mTTSServiceExecutor.execute(createCustomVoiceSynthesizerRunnable);
        createCustomVoiceSynthesizerRunnable.getTask().addOnCompleteListener(new C7774a(onConntectListener, 0));
        return 0;
    }

    public List<String> getAvailableCustomVoiceLanguages() {
        if (!checkConnection()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            List<String> availableCustomVoiceLocales = this.mTTSServiceExecutor.getTTService().getAvailableCustomVoiceLocales(this.mTTSServiceExecutor.callerName(), iCallerId);
            if (availableCustomVoiceLocales == null || availableCustomVoiceLocales.size() <= 0) {
                return arrayList;
            }
            arrayList.addAll(availableCustomVoiceLocales);
            return arrayList;
        } catch (RemoteException e) {
            Log.e("ScsApi@TTS", e.getMessage());
            return arrayList;
        }
    }

    public List<Locale> getAvailableCustomVoiceLocales() {
        if (!checkConnection()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            List<String> availableCustomVoiceLocales = this.mTTSServiceExecutor.getTTService().getAvailableCustomVoiceLocales(this.mTTSServiceExecutor.callerName(), iCallerId);
            if (availableCustomVoiceLocales != null && availableCustomVoiceLocales.size() > 0) {
                Iterator<String> it = availableCustomVoiceLocales.iterator();
                while (it.hasNext()) {
                    arrayList.add(TextToSpeech.convertLocaleCodeToLocale(it.next()));
                }
            }
            return arrayList;
        } catch (RemoteException e) {
            Log.e("ScsApi@TTS", e.getMessage());
            return arrayList;
        }
    }

    public String getCustomVoicePackageName(String str, int i, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            return this.mTTSServiceExecutor.getTTService().getCustomVoicePackageName(str, i, str2);
        } catch (RemoteException e) {
            Log.e("ScsApi@TTS", e.getMessage());
            return null;
        }
    }

    public List<String> getSupportCustomVoiceLanguages() {
        if (!checkConnection()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            List<String> supportCustomVoiceLocales = this.mTTSServiceExecutor.getTTService().getSupportCustomVoiceLocales(this.mTTSServiceExecutor.callerName(), iCallerId);
            if (supportCustomVoiceLocales == null || supportCustomVoiceLocales.size() <= 0) {
                return arrayList;
            }
            arrayList.addAll(supportCustomVoiceLocales);
            return arrayList;
        } catch (RemoteException e) {
            Log.e("ScsApi@TTS", e.getMessage());
            return arrayList;
        }
    }

    public List<Locale> getSupportCustomVoiceLocales() {
        if (!checkConnection()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            List<String> supportCustomVoiceLocales = this.mTTSServiceExecutor.getTTService().getSupportCustomVoiceLocales(this.mTTSServiceExecutor.callerName(), iCallerId);
            if (supportCustomVoiceLocales != null && supportCustomVoiceLocales.size() > 0) {
                Iterator<String> it = supportCustomVoiceLocales.iterator();
                while (it.hasNext()) {
                    arrayList.add(TextToSpeech.convertLocaleCodeToLocale(it.next()));
                }
            }
            return arrayList;
        } catch (RemoteException e) {
            Log.e("ScsApi@TTS", e.getMessage());
            return arrayList;
        }
    }

    public int openCustomVoice(@NonNull String str) {
        if (!checkConnection()) {
            return -4;
        }
        String customVoicePackageName = getCustomVoicePackageName(this.mTTSServiceExecutor.callerName(), this.mTTSServiceExecutor.callerId(), str);
        if (customVoicePackageName != null && !customVoicePackageName.equals("")) {
            List<String> availableCustomVoiceLanguages = getAvailableCustomVoiceLanguages();
            if (str != null && availableCustomVoiceLanguages.size() != 0 && availableCustomVoiceLanguages.contains(str)) {
                Intent intent = new Intent("com.samsung.android.ptts.action.CREATE_PERSONAL_VOICE_FOR_EXTERNAL");
                try {
                    intent.setPackage(customVoicePackageName);
                    intent.addFlags(335544352);
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

    public int openCustomVoiceDeepLink(@NonNull String str) {
        if (!checkConnection()) {
            return -4;
        }
        String customVoicePackageName = getCustomVoicePackageName(this.mTTSServiceExecutor.callerName(), this.mTTSServiceExecutor.callerId(), str);
        if (customVoicePackageName != null && !customVoicePackageName.equals("")) {
            List<String> supportCustomVoiceLanguages = getSupportCustomVoiceLanguages();
            if (str != null && supportCustomVoiceLanguages.size() != 0 && supportCustomVoiceLanguages.contains(str)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("samsungapps://productDetail/".concat(customVoicePackageName)));
                intent.putExtra("type", Constants.MAIN_THUMBNAIL_FILE_NAME_COVER);
                intent.addFlags(335544352);
                this.mContext.startActivity(intent);
                return 0;
            }
        }
        return -51;
    }

    public int removeCustomVoice(@NonNull Voice voice) {
        if (!checkConnection()) {
            return -4;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        String strCallerName = this.mTTSServiceExecutor.callerName();
        if (voice == null) {
            return -1;
        }
        try {
            return this.mTTSServiceExecutor.getTTService().removeCustomVoice(strCallerName, iCallerId, voice);
        } catch (RemoteException e) {
            Log.e("ScsApi@TTS", e.getMessage());
            return -1;
        }
    }

    public int renameCustomVoice(@NonNull Voice voice, @NonNull String str) {
        if (!checkConnection()) {
            return -4;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        String strCallerName = this.mTTSServiceExecutor.callerName();
        if (voice == null || str == null) {
            return -1;
        }
        if (str.equals("")) {
            return -53;
        }
        try {
            return this.mTTSServiceExecutor.getTTService().renameCustomVoice(strCallerName, iCallerId, voice, str);
        } catch (RemoteException e) {
            Log.e("ScsApi@TTS", e.getMessage());
            return -1;
        }
    }
}
