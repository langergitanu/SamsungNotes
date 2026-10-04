package com.samsung.android.sdk.scs.p142ai;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener;
import com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognizer;
import com.samsung.android.sdk.scs.p142ai.core.ActionParamExtraction;
import com.samsung.android.sdk.scs.p142ai.core.GenericInference;
import com.samsung.android.sdk.scs.p142ai.core.IntentQueryGeneration;
import com.samsung.android.sdk.scs.p142ai.downloader.ModelDownloader;
import com.samsung.android.sdk.scs.p142ai.image.BoundaryDetector;
import com.samsung.android.sdk.scs.p142ai.image.ImageUpscaler;
import com.samsung.android.sdk.scs.p142ai.language.Classifier;
import com.samsung.android.sdk.scs.p142ai.language.Configuration;
import com.samsung.android.sdk.scs.p142ai.language.Corrector;
import com.samsung.android.sdk.scs.p142ai.language.EmojiAugmentor;
import com.samsung.android.sdk.scs.p142ai.language.Extractor;
import com.samsung.android.sdk.scs.p142ai.language.FormatConverter;
import com.samsung.android.sdk.scs.p142ai.language.Generic;
import com.samsung.android.sdk.scs.p142ai.language.LlmCloudUsageRequest;
import com.samsung.android.sdk.scs.p142ai.language.NotesOrganizer;
import com.samsung.android.sdk.scs.p142ai.language.SmartCoverer;
import com.samsung.android.sdk.scs.p142ai.language.SmartReplyer;
import com.samsung.android.sdk.scs.p142ai.language.Suggester;
import com.samsung.android.sdk.scs.p142ai.language.SuggesterForExternal;
import com.samsung.android.sdk.scs.p142ai.language.Summarizer;
import com.samsung.android.sdk.scs.p142ai.language.ToneConverter;
import com.samsung.android.sdk.scs.p142ai.language.Translator;
import com.samsung.android.sdk.scs.p142ai.language.WritingComposer;
import com.samsung.android.sdk.scs.p142ai.suggestion.AppCategorizer;
import com.samsung.android.sdk.scs.p142ai.suggestion.FolderNameSuggester;
import com.samsung.android.sdk.scs.p142ai.suggestion.KeywordSuggester;
import com.samsung.android.sdk.scs.p142ai.text.bnlp.BasicNlpAnalyzer;
import com.samsung.android.sdk.scs.p142ai.text.category.DocumentCategoryClassifier;
import com.samsung.android.sdk.scs.p142ai.text.entity.BasicEntityExtractor;
import com.samsung.android.sdk.scs.p142ai.text.event.EventCategoryClassifier;
import com.samsung.android.sdk.scs.p142ai.text.event.EventExtractor;
import com.samsung.android.sdk.scs.p142ai.text.language.LanguageDetector;
import com.samsung.android.sdk.scs.p142ai.text.phrase.KeyPhraseExtractor;
import com.samsung.android.sdk.scs.p142ai.text.reminder.ReminderEntityExtractor;
import com.samsung.android.sdk.scs.p142ai.text.unit.UnitConverter;
import com.samsung.android.sdk.scs.p142ai.texttospeech.CustomTextToSpeech;
import com.samsung.android.sdk.scs.p142ai.texttospeech.CustomTextToSpeechForExternal;
import com.samsung.android.sdk.scs.p142ai.texttospeech.TextToSpeech;
import com.samsung.android.sdk.scs.p142ai.texttospeech.TextToSpeechForExternal;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslator;
import com.samsung.android.sdk.scs.p142ai.visual.ImageEditorGenerator;
import com.samsung.android.sdk.scs.p142ai.visual.RequestType;
import com.samsung.android.sdk.scs.p142ai.visual.WallpaperGenerator;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paClient;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AiServices {
    private AiServices() {
    }

    public static ActionParamExtraction getActionParamExtraction(@NonNull Context context) {
        return new ActionParamExtraction(context);
    }

    public static AppCategorizer getAppCategorizer(@NonNull Context context) {
        return new AppCategorizer(context);
    }

    public static BasicEntityExtractor getBasicEntityExtractor(@NonNull Context context) {
        return new BasicEntityExtractor(context);
    }

    public static BasicNlpAnalyzer getBasicNlpAnalyzer(@NonNull Context context) {
        return new BasicNlpAnalyzer(context);
    }

    public static BoundaryDetector getBoundaryDetector(@NonNull Context context) {
        return new BoundaryDetector(context);
    }

    public static C2paClient getC2PAClient(@NonNull Context context) {
        return new C2paClient(context);
    }

    public static Classifier getClassifier(@NonNull Context context) {
        return new Classifier(context);
    }

    public static Configuration getConfiguration(@NonNull Context context) {
        return new Configuration(context);
    }

    public static Corrector getCorrector(@NonNull Context context) {
        return new Corrector(context);
    }

    public static CustomTextToSpeech getCustomTextToSpeech(@NonNull Context context) {
        return new CustomTextToSpeech(context);
    }

    public static CustomTextToSpeechForExternal getCustomTextToSpeechForExternal(@NonNull Context context) {
        return new CustomTextToSpeechForExternal(context);
    }

    public static DocumentCategoryClassifier getDocumentCategoryClassifier(@NonNull Context context) {
        return new DocumentCategoryClassifier(context);
    }

    public static EmojiAugmentor getEmojiAugmentor(@NonNull Context context) {
        return new EmojiAugmentor(context);
    }

    public static EventCategoryClassifier getEventCategoryClassifier(@NonNull Context context) {
        return new EventCategoryClassifier(context);
    }

    public static EventExtractor getEventExtractor(@NonNull Context context) {
        return new EventExtractor(context);
    }

    public static Extractor getExtractor(@NonNull Context context) {
        return new Extractor(context);
    }

    public static FolderNameSuggester getFolderNameSuggester(@NonNull Context context) {
        return new FolderNameSuggester(context);
    }

    public static FormatConverter getFormatConverter(@NonNull Context context) {
        return new FormatConverter(context);
    }

    @Deprecated
    public static Generic getGeneric(@NonNull Context context) {
        return new Generic(context);
    }

    public static GenericInference getGenericInference(@NonNull Context context) {
        return new GenericInference(context);
    }

    public static ImageEditorGenerator getImageEditorGenerator(@NonNull Context context, int i) {
        return getImageEditorGenerator(context, i, RequestType.CLOUD);
    }

    public static ImageUpscaler getImageUpscaler(@NonNull Context context) {
        return new ImageUpscaler(context);
    }

    public static IntentQueryGeneration getIntentQueryGeneration(@NonNull Context context) {
        return new IntentQueryGeneration(context);
    }

    public static KeyPhraseExtractor getKeyPhraseExtractor(@NonNull Context context) {
        return new KeyPhraseExtractor(context);
    }

    public static KeywordSuggester getKeywordSuggester(@NonNull Context context) {
        return new KeywordSuggester(context);
    }

    public static LanguageDetector getLanguageDetector(@NonNull Context context) {
        return new LanguageDetector(context);
    }

    public static LlmCloudUsageRequest getLlmCloudUsage(@NonNull Context context) {
        return new LlmCloudUsageRequest(context);
    }

    public static ModelDownloader getModelDownloader(@NonNull Context context) {
        return new ModelDownloader(context);
    }

    public static NeuralTranslator getNeuralTranslator(@NonNull Context context) {
        return new NeuralTranslator(context);
    }

    public static NotesOrganizer getNotesOrganizer(@NonNull Context context) {
        return new NotesOrganizer(context);
    }

    public static ReminderEntityExtractor getReminderEntityExtractor(@NonNull Context context) {
        return new ReminderEntityExtractor(context);
    }

    public static SmartCoverer getSmartCoverer(@NonNull Context context) {
        return new SmartCoverer(context);
    }

    public static SmartReplyer getSmartReplyer(@NonNull Context context) {
        return new SmartReplyer(context);
    }

    public static SpeechRecognizer getSpeechRecognizer(@NonNull Context context, @NonNull SpeechRecognitionListener speechRecognitionListener) {
        return new SpeechRecognizer(context, speechRecognitionListener);
    }

    public static Suggester getSuggester(@NonNull Context context) {
        return new Suggester(context);
    }

    public static SuggesterForExternal getSuggesterForExternal(@NonNull Context context) {
        return new SuggesterForExternal(context);
    }

    public static Summarizer getSummarizer(@NonNull Context context) {
        return new Summarizer(context);
    }

    public static TextToSpeech getTextToSpeech(@NonNull Context context) {
        return new TextToSpeech(context);
    }

    public static TextToSpeech getTextToSpeechForExternal(@NonNull Context context) {
        return new TextToSpeechForExternal(context);
    }

    public static ToneConverter getToneConverter(@NonNull Context context) {
        return new ToneConverter(context);
    }

    public static Translator getTranslator(@NonNull Context context) {
        return new Translator(context);
    }

    public static UnitConverter getUnitConverter(@NonNull Context context) {
        return new UnitConverter(context);
    }

    public static WallpaperGenerator getWallpaperGenerator(@NonNull Context context) {
        return new WallpaperGenerator(context);
    }

    public static WritingComposer getWritingComposer(@NonNull Context context) {
        return new WritingComposer(context);
    }

    public static ImageEditorGenerator getImageEditorGenerator(@NonNull Context context, int i, @NonNull RequestType requestType) {
        return new ImageEditorGenerator(context, i, requestType);
    }
}
