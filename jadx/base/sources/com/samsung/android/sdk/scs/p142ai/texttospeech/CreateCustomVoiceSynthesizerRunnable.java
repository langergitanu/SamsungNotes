package com.samsung.android.sdk.scs.p142ai.texttospeech;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sivs.p144ai.sdkcommon.tts.ISynthesizerInitCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class CreateCustomVoiceSynthesizerRunnable extends TaskRunnable<Integer> {
    private static final String TAG = "ScsApi@TTS:CreateCustomVoiceSynthesizerRunnable";
    private ISynthesizerInitCallback mListener;
    private TextToSpeechServiceExecutor mServiceExecutor;

    public CreateCustomVoiceSynthesizerRunnable(@NonNull TextToSpeechServiceExecutor textToSpeechServiceExecutor, @NonNull ISynthesizerInitCallback iSynthesizerInitCallback) {
        this.mServiceExecutor = textToSpeechServiceExecutor;
        this.mListener = iSynthesizerInitCallback;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        if (this.mListener == null) {
            this.mSource.setException(new IllegalArgumentException("createSynthesizer fail : invalid listener"));
            return;
        }
        try {
            int iCallerId = this.mServiceExecutor.callerId();
            int iCreateCustomVoiceSynthesizer = this.mServiceExecutor.getTTService().createCustomVoiceSynthesizer(this.mServiceExecutor.callerName(), iCallerId, this.mListener);
            if (iCreateCustomVoiceSynthesizer != 0) {
                this.mSource.setException(new IllegalArgumentException(String.format("createSynthesizer fail : %d", Integer.valueOf(iCreateCustomVoiceSynthesizer))));
            } else {
                this.mSource.setResult((TResult) 0);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_AI_CUSTOM_TEXT_TO_SPEECH";
    }
}
