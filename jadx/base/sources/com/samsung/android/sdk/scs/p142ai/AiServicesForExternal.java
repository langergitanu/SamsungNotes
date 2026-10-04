package com.samsung.android.sdk.scs.p142ai;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener;
import com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognizer;
import com.samsung.android.sdk.scs.p142ai.language.Corrector;
import com.samsung.android.sdk.scs.p142ai.language.CorrectorForExternal;
import com.samsung.android.sdk.scs.p142ai.language.SmartReplyer;
import com.samsung.android.sdk.scs.p142ai.language.SmartReplyerForExternal;
import com.samsung.android.sdk.scs.p142ai.language.SuggesterForExternal;
import com.samsung.android.sdk.scs.p142ai.language.Summarizer;
import com.samsung.android.sdk.scs.p142ai.language.SummarizerForExternal;
import com.samsung.android.sdk.scs.p142ai.language.ToneConverter;
import com.samsung.android.sdk.scs.p142ai.language.ToneConverterForExternal;
import com.samsung.android.sdk.scs.p142ai.language.WritingComposer;
import com.samsung.android.sdk.scs.p142ai.language.WritingComposerForExternal;
import com.samsung.android.sdk.scs.p142ai.texttospeech.TextToSpeech;
import com.samsung.android.sdk.scs.p142ai.texttospeech.TextToSpeechForExternal;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AiServicesForExternal {
    private AiServicesForExternal() {
    }

    public static Corrector getCorrector(@NonNull Context context) {
        return new CorrectorForExternal(context);
    }

    public static NeuralTranslator getNeuralTranslator(@NonNull Context context) {
        return new NeuralTranslator(context, true);
    }

    public static SmartReplyer getSmartReplyer(@NonNull Context context) {
        return new SmartReplyerForExternal(context);
    }

    public static SpeechRecognizer getSpeechRecognizer(@NonNull Context context, @NonNull SpeechRecognitionListener speechRecognitionListener) {
        return new SpeechRecognizer(context, speechRecognitionListener);
    }

    public static SuggesterForExternal getSuggesterForExternal(@NonNull Context context) {
        return new SuggesterForExternal(context);
    }

    public static Summarizer getSummarizer(@NonNull Context context) {
        return new SummarizerForExternal(context);
    }

    public static TextToSpeech getTextToSpeechForExternal(@NonNull Context context) {
        return new TextToSpeechForExternal(context);
    }

    public static ToneConverter getToneConverter(@NonNull Context context) {
        return new ToneConverterForExternal(context);
    }

    public static WritingComposer getWritingComposer(@NonNull Context context) {
        return new WritingComposerForExternal(context);
    }
}
