package com.samsung.android.sivs.p144ai.sdkcommon.translation;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class TranslationConst {
    public static final int VERSION = 13;
    public static final Integer SINCE_NEURAL_TRANSLATION = 1;
    public static final Integer SINCE_LANGUAGE_LIST_IDENTIFICATION = 7;
    public static final Integer SINCE_LANGUAGE_IDENTIFICATION_AND_GET_CANDIDATE = 8;
    public static final Integer SINCE_CLEAR_WITH_SOURCE_ID = 10;
    public static final Integer SINCE_TAGGED_TRANSLATION_SUPPORTED = 10;
    public static final Integer SINCE_CHUNK_TEXT = 11;
    public static final Integer SINCE_NEURAL_TRANSLATION_FOR_EXTERNAL = 12;
    public static final Integer SINCE_ONDEVICE_LLM_TRANSLATION = 12;
    public static final Integer SINCE_SPEECH_LLM_TRANSLATION = 13;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface KEY_LANGUAGE_IDENTIFICATION {
        public static final String DIFFERENTIATE = "differentiate";
        public static final String FALLBACK_LANGUAGE = "fallbackLanguage";
        public static final String MAX_CANDIDATES = "maxCandidates";
        public static final String TEXT = "text";
        public static final String TEXT_LIST = "textList";
        public static final String VERBOSE = "verbose";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface KEY_SPEECH_LLM {
        public static final String KEY_SPEECH_LLM_BUNDLE = "speech-llm-bundle";
        public static final String SOURCE_LANGUAGE = "sourceLanguage";
        public static final String TARGET_LANGUAGE = "targetLanguage";
        public static final String TARGET_TEXT = "targetText";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface KEY_TEXT_TRANSLATION_REQUEST {
        public static final String APPEND_META = "appendMeta";
        public static final String CONTEXT_CANDIDATE = "contextCandidate";
        public static final String END_OF_CONTEXT = "endOfContext";
        public static final String FORCE_PIVOT = "forcePivot";
        public static final String FORMALITY = "formality";

        /* JADX INFO: renamed from: ID */
        public static final String f5425ID = "id";
        public static final String MODE = "mode";
        public static final String NEED_SENTENCE_SPLIT = "needSentenceSplit";
        public static final String REQUESTING_PACKAGE_NAME = "requestingPackageName";
        public static final String REQUESTING_SOURCE_ID = "requestingSourceId";
        public static final String SOURCE_LANGUAGE = "sourceLanguage";
        public static final String SOURCE_TEXT = "sourceText";
        public static final String TARGET_LANGUAGE = "targetLanguage";
        public static final String TID = "tid";
        public static final String VERBOSE = "verbose";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface KEY_TEXT_TRANSLATION_RESULT {
        public static final String APPEND_META = "appendMeta";
        public static final String FORCE_PIVOT = "forcePivot";
        public static final String FORMALITY = "formality";

        /* JADX INFO: renamed from: ID */
        public static final String f5426ID = "id";
        public static final String INTERIM_RESULT = "interimResult";
        public static final String SOURCE_LANGUAGE = "sourceLanguage";
        public static final String SOURCE_TEXT = "sourceText";
        public static final String TARGET_LANGUAGE = "targetLanguage";
        public static final String TARGET_TEXT = "targetText";
        public static final String VERBOSE = "verbose";
    }
}
