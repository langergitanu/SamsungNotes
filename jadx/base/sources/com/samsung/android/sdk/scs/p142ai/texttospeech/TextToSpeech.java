package com.samsung.android.sdk.scs.p142ai.texttospeech;

import android.content.Context;
import android.media.AudioAttributes;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback;
import com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesizerInitCallback;
import com.samsung.android.sivs.p144ai.sdkcommon.tts.TextToSpeechConst;
import com.samsung.android.sivs.p144ai.sdkcommon.tts.Voice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TextToSpeech {
    protected static final boolean DEBUG = false;
    protected static final String LOCALE_DELIMITER = "-";
    protected static final String TAG = "ScsApi@TTS";
    protected Context mContext;
    protected TextToSpeechServiceExecutor mTTSServiceExecutor = null;
    protected Voice mVoice = null;
    protected final Bundle mParams = new Bundle();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnConntectListener {
        void onConnected(int i);

        void onDisconnected();

        void onVoiceUpdated(List<Voice> list);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public TextToSpeech(@NonNull Context context) {
        this.mContext = null;
        this.mContext = context;
        createExecutor(context);
    }

    public static Locale convertLocaleCodeToLocale(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, "-");
        String strNextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : "";
        String strNextToken2 = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : "";
        if (strNextToken.equals("") || strNextToken2.equals("")) {
            return null;
        }
        return new Locale(strNextToken, strNextToken2);
    }

    private static String convertLocaleToLocaleCode(Locale locale) {
        if (locale == null) {
            return "";
        }
        return locale.getISO3Language() + "-" + locale.getISO3Country();
    }

    private Bundle getParams(Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return this.mParams;
        }
        Bundle bundle2 = new Bundle(this.mParams);
        bundle2.putAll(bundle);
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$bindSynthesizer$0(OnConntectListener onConntectListener, Task task) {
        if (task.isSuccessful() || onConntectListener == null) {
            return;
        }
        onConntectListener.onConnected(-2);
    }

    public int bindSynthesizer(@NonNull final OnConntectListener onConntectListener) {
        CreateSynthesizerRunnable createSynthesizerRunnable = new CreateSynthesizerRunnable(this.mTTSServiceExecutor, new ISynthesizerInitCallback.Stub() { // from class: com.samsung.android.sdk.scs.ai.texttospeech.TextToSpeech.1
            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesizerInitCallback
            public void onConnected(int i) {
                AbstractC2322a.m1631u(i, "onConnected : ", TextToSpeech.TAG);
                OnConntectListener onConntectListener2 = onConntectListener;
                if (onConntectListener2 != null) {
                    onConntectListener2.onConnected(i);
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesizerInitCallback
            public void onDisconnected() {
                OnConntectListener onConntectListener2 = onConntectListener;
                if (onConntectListener2 != null) {
                    onConntectListener2.onDisconnected();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesizerInitCallback
            public void onVoiceUpdated(List<Voice> list) {
                OnConntectListener onConntectListener2 = onConntectListener;
                if (onConntectListener2 != null) {
                    onConntectListener2.onVoiceUpdated(list);
                }
            }
        });
        this.mTTSServiceExecutor.execute(createSynthesizerRunnable);
        createSynthesizerRunnable.getTask().addOnCompleteListener(new C7774a(onConntectListener, 1));
        return 0;
    }

    public boolean checkConnection() {
        if (this.mTTSServiceExecutor.getTTService() != null) {
            return true;
        }
        Log.e(TAG, "error : not connected to synthesizer.");
        return false;
    }

    public void createExecutor(Context context) {
        this.mTTSServiceExecutor = new TextToSpeechServiceExecutor(context);
    }

    @NonNull
    public List<String> getAvailableLanguages() {
        if (!checkConnection()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            List<String> availableLocales = this.mTTSServiceExecutor.getTTService().getAvailableLocales(this.mTTSServiceExecutor.callerName(), iCallerId);
            if (availableLocales == null || availableLocales.size() <= 0) {
                return arrayList;
            }
            arrayList.addAll(availableLocales);
            return arrayList;
        } catch (RemoteException e) {
            Log.e(TAG, e.getMessage());
            return arrayList;
        }
    }

    @NonNull
    public List<Locale> getAvailableLocales() {
        if (!checkConnection()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            List<String> availableLocales = this.mTTSServiceExecutor.getTTService().getAvailableLocales(this.mTTSServiceExecutor.callerName(), iCallerId);
            if (availableLocales != null && availableLocales.size() > 0) {
                Iterator<String> it = availableLocales.iterator();
                while (it.hasNext()) {
                    arrayList.add(convertLocaleCodeToLocale(it.next()));
                }
            }
            return arrayList;
        } catch (RemoteException e) {
            Log.e(TAG, e.getMessage());
            return arrayList;
        }
    }

    public int getAvailableSynthesizerCount() {
        if (!checkConnection()) {
            return -1;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            return this.mTTSServiceExecutor.getTTService().getAvailableSynthesizerCount(this.mTTSServiceExecutor.callerName(), iCallerId);
        } catch (RemoteException e) {
            Log.e(TAG, e.getMessage());
            return 0;
        }
    }

    public int getMaxInputLength() {
        return 4000;
    }

    @NonNull
    public List<String> getSupportLanguages() {
        if (!checkConnection()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            List<String> supportLocales = this.mTTSServiceExecutor.getTTService().getSupportLocales(this.mTTSServiceExecutor.callerName(), iCallerId);
            if (supportLocales == null || supportLocales.size() <= 0) {
                return arrayList;
            }
            arrayList.addAll(supportLocales);
            return arrayList;
        } catch (RemoteException e) {
            Log.e(TAG, e.getMessage());
            return arrayList;
        }
    }

    @NonNull
    public List<Locale> getSupportLocales() {
        if (!checkConnection()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            List<String> supportLocales = this.mTTSServiceExecutor.getTTService().getSupportLocales(this.mTTSServiceExecutor.callerName(), iCallerId);
            if (supportLocales != null && supportLocales.size() > 0) {
                Iterator<String> it = supportLocales.iterator();
                while (it.hasNext()) {
                    arrayList.add(convertLocaleCodeToLocale(it.next()));
                }
            }
            return arrayList;
        } catch (RemoteException e) {
            Log.e(TAG, e.getMessage());
            return arrayList;
        }
    }

    @Nullable
    public Voice getVoice(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        if (!checkConnection()) {
            return null;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        String strCallerName = this.mTTSServiceExecutor.callerName();
        if (str != null && str2 != null && str3 != null) {
            try {
                return this.mTTSServiceExecutor.getTTService().getVoice(strCallerName, iCallerId, str, str2, str3);
            } catch (RemoteException e) {
                Log.e(TAG, e.getMessage());
            }
        }
        return null;
    }

    @NonNull
    public Set<Voice> getVoices() {
        if (!checkConnection()) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet();
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            List<Voice> voices = this.mTTSServiceExecutor.getTTService().getVoices(this.mTTSServiceExecutor.callerName(), iCallerId);
            if (voices == null || voices.size() <= 0) {
                return hashSet;
            }
            hashSet.addAll(voices);
            return hashSet;
        } catch (RemoteException e) {
            Log.e(TAG, e.getMessage());
            return hashSet;
        }
    }

    public int isLanguageAvailable(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        if (!checkConnection()) {
            return -4;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        String strCallerName = this.mTTSServiceExecutor.callerName();
        if (str == null || str2 == null || str3 == null) {
            return -1;
        }
        try {
            return this.mTTSServiceExecutor.getTTService().isLanguageAvailable(strCallerName, iCallerId, str, str2, str3);
        } catch (RemoteException e) {
            Log.e(TAG, e.getMessage());
            return -1;
        }
    }

    public int setAudioAttributes(AudioAttributes audioAttributes) {
        this.mParams.putParcelable(TextToSpeechConst.PARAM_KEY_AUDIO_ATTRIBUTES, audioAttributes);
        return 0;
    }

    public int setEndSilence(int i) {
        this.mParams.putInt(TextToSpeechConst.PARAM_KEY_END_SILENCE, i);
        return 0;
    }

    public int setPitch(float f) {
        this.mParams.putFloat(TextToSpeechConst.PARAM_KEY_PITCH, f);
        return 0;
    }

    public int setSpeechRate(float f) {
        this.mParams.putFloat(TextToSpeechConst.PARAM_KEY_SPEECH_RATE, f);
        return 0;
    }

    public int setStreamType(int i) {
        this.mParams.putInt(TextToSpeechConst.PARAM_KEY_STREAM_TYPE, i);
        return 0;
    }

    public int setVoice(@NonNull Voice voice) {
        if (!checkConnection()) {
            return -4;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        String strCallerName = this.mTTSServiceExecutor.callerName();
        int voice2 = -1;
        if (voice != null) {
            try {
                voice2 = this.mTTSServiceExecutor.getTTService().setVoice(strCallerName, iCallerId, voice);
                if (voice2 != 0) {
                    return voice2;
                }
                this.mVoice = voice;
                return voice2;
            } catch (RemoteException e) {
                Log.e(TAG, e.getMessage());
            }
        }
        return voice2;
    }

    public int shutdown() {
        if (!checkConnection()) {
            return -4;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            return this.mTTSServiceExecutor.getTTService().releaseSynthesizer(this.mTTSServiceExecutor.callerName(), iCallerId);
        } catch (RemoteException e) {
            Log.e(TAG, e.getMessage());
            return -1;
        }
    }

    public int speak(@NonNull CharSequence charSequence, @NonNull Voice voice, int i, @Nullable Bundle bundle, @Nullable String str, @NonNull final SynthesizeProgressListener synthesizeProgressListener) {
        if (!checkConnection()) {
            return -4;
        }
        if (charSequence == null || charSequence.equals("")) {
            Log.i(TAG, "speak : empty input.");
            return -31;
        }
        if (charSequence.length() > 4000) {
            Log.e(TAG, "speak error : ERROR_INVALID_REQUEST_EXCEED_MAX_INPUT_LENGTH");
            return -32;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            return this.mTTSServiceExecutor.getTTService().speak(this.mTTSServiceExecutor.callerName(), iCallerId, voice, charSequence, i, getParams(bundle), str, new ISynthesisCallback.Stub() { // from class: com.samsung.android.sdk.scs.ai.texttospeech.TextToSpeech.2
                @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
                public void onDone(String str2) {
                    SynthesizeProgressListener synthesizeProgressListener2 = synthesizeProgressListener;
                    if (synthesizeProgressListener2 != null) {
                        synthesizeProgressListener2.onDone(str2);
                    }
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
                public void onError(String str2, int i2) {
                    SynthesizeProgressListener synthesizeProgressListener2 = synthesizeProgressListener;
                    if (synthesizeProgressListener2 != null) {
                        synthesizeProgressListener2.onError(str2, i2);
                    }
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
                public void onProgress(String str2, byte[] bArr, int i2, int i4) {
                    SynthesizeProgressListener synthesizeProgressListener2 = synthesizeProgressListener;
                    if (synthesizeProgressListener2 != null) {
                        synthesizeProgressListener2.onProgress(str2, bArr, i2, i4);
                    }
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
                public void onRangeStart(String str2, int i2, int i4, int i5) {
                    SynthesizeProgressListener synthesizeProgressListener2 = synthesizeProgressListener;
                    if (synthesizeProgressListener2 != null) {
                        synthesizeProgressListener2.onRangeStart(str2, i2, i4, i5);
                    }
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
                public void onStart(String str2, int i2, int i4, int i5) {
                    SynthesizeProgressListener synthesizeProgressListener2 = synthesizeProgressListener;
                    if (synthesizeProgressListener2 != null) {
                        synthesizeProgressListener2.onStart(str2, i2, i4, i5);
                    }
                }
            });
        } catch (RemoteException e) {
            Log.e(TAG, e.getMessage());
            return -1;
        }
    }

    public int stop() {
        if (!checkConnection()) {
            return -4;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            return this.mTTSServiceExecutor.getTTService().stop(this.mTTSServiceExecutor.callerName(), iCallerId);
        } catch (RemoteException e) {
            Log.e(TAG, e.getMessage());
            return -1;
        }
    }

    public int synthesize(@NonNull CharSequence charSequence, @NonNull Voice voice, @Nullable Bundle bundle, @Nullable String str, @NonNull final SynthesizeProgressListener synthesizeProgressListener) {
        if (!checkConnection()) {
            return -4;
        }
        if (charSequence == null || charSequence.equals("")) {
            Log.i(TAG, "synthesize : empty input.");
            return -31;
        }
        if (charSequence.length() > 4000) {
            Log.e(TAG, "synthesize error : ERROR_INVALID_REQUEST_EXCEED_MAX_INPUT_LENGTH");
            return -32;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            return this.mTTSServiceExecutor.getTTService().synthesize(this.mTTSServiceExecutor.callerName(), iCallerId, voice, charSequence, getParams(bundle), str, new ISynthesisCallback.Stub() { // from class: com.samsung.android.sdk.scs.ai.texttospeech.TextToSpeech.3
                @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
                public void onDone(String str2) {
                    SynthesizeProgressListener synthesizeProgressListener2 = synthesizeProgressListener;
                    if (synthesizeProgressListener2 != null) {
                        synthesizeProgressListener2.onDone(str2);
                    }
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
                public void onError(String str2, int i) {
                    SynthesizeProgressListener synthesizeProgressListener2 = synthesizeProgressListener;
                    if (synthesizeProgressListener2 != null) {
                        synthesizeProgressListener2.onError(str2, i);
                    }
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
                public void onProgress(String str2, byte[] bArr, int i, int i2) {
                    SynthesizeProgressListener synthesizeProgressListener2 = synthesizeProgressListener;
                    if (synthesizeProgressListener2 != null) {
                        synthesizeProgressListener2.onProgress(str2, bArr, i, i2);
                    }
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
                public void onRangeStart(String str2, int i, int i2, int i4) {
                    SynthesizeProgressListener synthesizeProgressListener2 = synthesizeProgressListener;
                    if (synthesizeProgressListener2 != null) {
                        synthesizeProgressListener2.onRangeStart(str2, i, i2, i4);
                    }
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
                public void onStart(String str2, int i, int i2, int i4) {
                    SynthesizeProgressListener synthesizeProgressListener2 = synthesizeProgressListener;
                    if (synthesizeProgressListener2 != null) {
                        synthesizeProgressListener2.onStart(str2, i, i2, i4);
                    }
                }
            });
        } catch (RemoteException e) {
            Log.e(TAG, e.getMessage());
            return -1;
        }
    }

    public int synthesizeToFile(@NonNull CharSequence charSequence, @NonNull Voice voice, @Nullable ParcelFileDescriptor parcelFileDescriptor, @Nullable Bundle bundle, @Nullable String str, @NonNull final SynthesizeProgressListener synthesizeProgressListener) {
        if (!checkConnection()) {
            return -4;
        }
        if (charSequence == null || charSequence.equals("")) {
            Log.i(TAG, "synthesizeToFile : empty input.");
            return -31;
        }
        if (charSequence.length() > 4000) {
            Log.e(TAG, "synthesizeToFile error : ERROR_INVALID_REQUEST_EXCEED_MAX_INPUT_LENGTH");
            return -32;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            return this.mTTSServiceExecutor.getTTService().synthesizeToFile(this.mTTSServiceExecutor.callerName(), iCallerId, voice, charSequence, parcelFileDescriptor, getParams(bundle), str, new ISynthesisCallback.Stub() { // from class: com.samsung.android.sdk.scs.ai.texttospeech.TextToSpeech.4
                @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
                public void onDone(String str2) {
                    SynthesizeProgressListener synthesizeProgressListener2 = synthesizeProgressListener;
                    if (synthesizeProgressListener2 != null) {
                        synthesizeProgressListener2.onDone(str2);
                    }
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
                public void onError(String str2, int i) {
                    SynthesizeProgressListener synthesizeProgressListener2 = synthesizeProgressListener;
                    if (synthesizeProgressListener2 != null) {
                        synthesizeProgressListener2.onError(str2, i);
                    }
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
                public void onProgress(String str2, byte[] bArr, int i, int i2) {
                    SynthesizeProgressListener synthesizeProgressListener2 = synthesizeProgressListener;
                    if (synthesizeProgressListener2 != null) {
                        synthesizeProgressListener2.onProgress(str2, bArr, i, i2);
                    }
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
                public void onRangeStart(String str2, int i, int i2, int i4) {
                    SynthesizeProgressListener synthesizeProgressListener2 = synthesizeProgressListener;
                    if (synthesizeProgressListener2 != null) {
                        synthesizeProgressListener2.onRangeStart(str2, i, i2, i4);
                    }
                }

                @Override // com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesisCallback
                public void onStart(String str2, int i, int i2, int i4) {
                    SynthesizeProgressListener synthesizeProgressListener2 = synthesizeProgressListener;
                    if (synthesizeProgressListener2 != null) {
                        synthesizeProgressListener2.onStart(str2, i, i2, i4);
                    }
                }
            });
        } catch (RemoteException e) {
            Log.e(TAG, e.getMessage());
            return -1;
        }
    }

    @Nullable
    public Voice getVoice(@NonNull Locale locale) {
        if (!checkConnection()) {
            return null;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        String strCallerName = this.mTTSServiceExecutor.callerName();
        if (locale != null) {
            try {
                return this.mTTSServiceExecutor.getTTService().getVoice(strCallerName, iCallerId, locale.getLanguage(), locale.getCountry(), locale.getVariant());
            } catch (RemoteException e) {
                Log.e(TAG, e.getMessage());
            }
        }
        return null;
    }

    public int isLanguageAvailable(@NonNull Locale locale) {
        if (!checkConnection()) {
            return -4;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        String strCallerName = this.mTTSServiceExecutor.callerName();
        if (locale == null) {
            return -1;
        }
        try {
            return this.mTTSServiceExecutor.getTTService().isLanguageAvailable(strCallerName, iCallerId, locale.getLanguage(), locale.getCountry(), locale.getVariant());
        } catch (RemoteException e) {
            Log.e(TAG, e.getMessage());
            return -1;
        }
    }

    public int setVoice(@NonNull Locale locale) {
        if (!checkConnection()) {
            return -4;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        String strCallerName = this.mTTSServiceExecutor.callerName();
        int voice = -1;
        if (locale != null) {
            try {
                Voice voice2 = this.mTTSServiceExecutor.getTTService().getVoice(strCallerName, iCallerId, locale.getLanguage(), locale.getCountry(), locale.getVariant());
                if (voice2 != null) {
                    voice = this.mTTSServiceExecutor.getTTService().setVoice(strCallerName, iCallerId, voice2);
                    if (voice != 0) {
                        return voice;
                    }
                    this.mVoice = voice2;
                    return voice;
                }
            } catch (RemoteException e) {
                Log.e(TAG, e.getMessage());
            }
        }
        return voice;
    }

    @NonNull
    public Set<Voice> getVoices(@NonNull String str) {
        if (!checkConnection()) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet();
        int iCallerId = this.mTTSServiceExecutor.callerId();
        try {
            List<Voice> voicesWithLocale = this.mTTSServiceExecutor.getTTService().getVoicesWithLocale(this.mTTSServiceExecutor.callerName(), iCallerId, str);
            if (voicesWithLocale == null || voicesWithLocale.size() <= 0) {
                return hashSet;
            }
            hashSet.addAll(voicesWithLocale);
            return hashSet;
        } catch (RemoteException e) {
            Log.e(TAG, e.getMessage());
            return hashSet;
        }
    }

    public int speak(@NonNull CharSequence charSequence, int i, @Nullable Bundle bundle, @Nullable String str, @NonNull SynthesizeProgressListener synthesizeProgressListener) {
        Voice voice = this.mVoice;
        if (voice == null) {
            return -33;
        }
        return speak(charSequence, voice, i, bundle, str, synthesizeProgressListener);
    }

    public int synthesize(@NonNull CharSequence charSequence, @Nullable Bundle bundle, @Nullable String str, @NonNull SynthesizeProgressListener synthesizeProgressListener) {
        Voice voice = this.mVoice;
        if (voice == null) {
            return -33;
        }
        return synthesize(charSequence, voice, bundle, str, synthesizeProgressListener);
    }

    public int synthesizeToFile(@NonNull CharSequence charSequence, @Nullable ParcelFileDescriptor parcelFileDescriptor, @Nullable Bundle bundle, @Nullable String str, @NonNull SynthesizeProgressListener synthesizeProgressListener) {
        Voice voice = this.mVoice;
        if (voice == null) {
            return -33;
        }
        return synthesizeToFile(charSequence, voice, parcelFileDescriptor, bundle, str, synthesizeProgressListener);
    }

    public int speak(@NonNull CharSequence charSequence, int i, @Nullable String str, @NonNull SynthesizeProgressListener synthesizeProgressListener) {
        return speak(charSequence, i, this.mParams, str, synthesizeProgressListener);
    }

    public int synthesize(@NonNull CharSequence charSequence, @Nullable String str, @NonNull SynthesizeProgressListener synthesizeProgressListener) {
        return synthesize(charSequence, this.mParams, str, synthesizeProgressListener);
    }

    public int synthesizeToFile(@NonNull CharSequence charSequence, @Nullable ParcelFileDescriptor parcelFileDescriptor, @Nullable String str, @NonNull SynthesizeProgressListener synthesizeProgressListener) {
        return synthesizeToFile(charSequence, parcelFileDescriptor, this.mParams, str, synthesizeProgressListener);
    }

    public int speak(@NonNull CharSequence charSequence, @NonNull Voice voice, int i, @Nullable String str, @NonNull SynthesizeProgressListener synthesizeProgressListener) {
        return speak(charSequence, voice, i, this.mParams, str, synthesizeProgressListener);
    }

    public int synthesize(@NonNull CharSequence charSequence, @NonNull Voice voice, @Nullable String str, @NonNull SynthesizeProgressListener synthesizeProgressListener) {
        return synthesize(charSequence, voice, this.mParams, str, synthesizeProgressListener);
    }

    public int synthesizeToFile(@NonNull CharSequence charSequence, @NonNull Voice voice, @Nullable ParcelFileDescriptor parcelFileDescriptor, @Nullable String str, @NonNull SynthesizeProgressListener synthesizeProgressListener) {
        return synthesizeToFile(charSequence, voice, parcelFileDescriptor, this.mParams, str, synthesizeProgressListener);
    }

    public int setVoice(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        if (!checkConnection()) {
            return -4;
        }
        int iCallerId = this.mTTSServiceExecutor.callerId();
        String strCallerName = this.mTTSServiceExecutor.callerName();
        int voice = -1;
        if (str != null && str2 != null && str3 != null) {
            try {
                Voice voice2 = this.mTTSServiceExecutor.getTTService().getVoice(strCallerName, iCallerId, str, str2, str3);
                if (voice2 != null) {
                    voice = this.mTTSServiceExecutor.getTTService().setVoice(strCallerName, iCallerId, voice2);
                    if (voice != 0) {
                        return voice;
                    }
                    this.mVoice = voice2;
                    return voice;
                }
            } catch (RemoteException e) {
                Log.e(TAG, e.getMessage());
            }
        }
        return voice;
    }

    public int speak(@NonNull CharSequence charSequence, @Nullable String str, @NonNull SynthesizeProgressListener synthesizeProgressListener) {
        Voice voice = this.mVoice;
        if (voice == null) {
            return -33;
        }
        return speak(charSequence, voice, 0, this.mParams, str, synthesizeProgressListener);
    }

    public int speak(@NonNull CharSequence charSequence, @Nullable Bundle bundle, @Nullable String str, @NonNull SynthesizeProgressListener synthesizeProgressListener) {
        return speak(charSequence, 0, bundle, str, synthesizeProgressListener);
    }

    @NonNull
    public Set<Voice> getVoices(Locale locale) {
        return getVoices(convertLocaleToLocaleCode(locale));
    }

    public int speak(@NonNull CharSequence charSequence, @NonNull Voice voice, @Nullable String str, @NonNull SynthesizeProgressListener synthesizeProgressListener) {
        return speak(charSequence, voice, 0, this.mParams, str, synthesizeProgressListener);
    }
}
