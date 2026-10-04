package com.samsung.android.sdk.scs.base.feature;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.scs.p140ai.sdkcommon.feature.FeatureConst;
import com.samsung.android.sdk.scs.base.StatusCodes;
import com.samsung.android.sdk.scs.base.utils.BaseConstants;
import com.samsung.android.sdk.scs.base.utils.FeatureHelper;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.BuildConfig;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechRecognitionConst;
import com.samsung.android.sivs.p144ai.sdkcommon.feature.SivsFeatureConst;
import com.samsung.android.sivs.p144ai.sdkcommon.language.LlmServiceConst;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.TranslationConst;
import com.samsung.android.visual.p167ai.sdkcommon.feature.VisualFeatureConst;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Feature {
    public static final String FEATURE_AI_CLOUD_LLM_INTERPRETATION = "FEATURE_AI_CLOUD_LLM_INTERPRETATION";
    public static final String FEATURE_AI_CUSTOM_TEXT_TO_SPEECH = "FEATURE_AI_CUSTOM_TEXT_TO_SPEECH";
    public static final String FEATURE_AI_GEN_B2B_ACCOUNT = "FEATURE_AI_GEN_B2B_ACCOUNT";
    public static final String FEATURE_AI_GEN_CORRECTION = "FEATURE_AI_GEN_CORRECTION";
    public static final String FEATURE_AI_GEN_CORRECTION_FOR_EXTERNAL = "FEATURE_AI_GEN_CORRECTION_FOR_EXTERNAL";
    public static final String FEATURE_AI_GEN_EMOJI_AUGMENTATION = "FEATURE_AI_GEN_EMOJI_AUGMENTATION";
    public static final String FEATURE_AI_GEN_GENERIC = "FEATURE_AI_GEN_GENERIC";
    public static final String FEATURE_AI_GEN_NOTES_ORGANIZATION = "FEATURE_AI_GEN_NOTES_ORGANIZATION";
    public static final String FEATURE_AI_GEN_SMART_CAPTURE = "FEATURE_AI_GEN_SMART_CAPTURE";
    public static final String FEATURE_AI_GEN_SMART_COVER = "FEATURE_AI_GEN_SMART_COVER";
    public static final String FEATURE_AI_GEN_SMART_REPLY = "FEATURE_AI_GEN_SMART_REPLY";
    public static final String FEATURE_AI_GEN_SMART_REPLY_FOR_EXTERNAL = "FEATURE_AI_GEN_SMART_REPLY_FOR_EXTERNAL";
    public static final String FEATURE_AI_GEN_SUGGESTION = "FEATURE_AI_GEN_SUGGESTION";
    public static final String FEATURE_AI_GEN_SUGGESTION_ONDEVICE = "FEATURE_AI_GEN_SUGGESTION_ONDEVICE";
    public static final String FEATURE_AI_GEN_SUMMARY = "FEATURE_AI_GEN_SUMMARY";
    public static final String FEATURE_AI_GEN_SUMMARY_FOR_EXTERNAL = "FEATURE_AI_GEN_SUMMARY_FOR_EXTERNAL";
    public static final String FEATURE_AI_GEN_TONE = "FEATURE_AI_GEN_TONE";
    public static final String FEATURE_AI_GEN_TONE_FOR_EXTERNAL = "FEATURE_AI_GEN_TONE_FOR_EXTERNAL";
    public static final String FEATURE_AI_GEN_TRANSLATION = "FEATURE_AI_GEN_TRANSLATION";
    public static final String FEATURE_AI_GEN_TRANSLATION_ONDEVICE = "FEATURE_AI_GEN_TRANSLATION_ONDEVICE";
    public static final String FEATURE_AI_GEN_USAGE = "FEATURE_AI_GEN_USAGE";
    public static final String FEATURE_AI_LANGUAGE_PACK_CONFIGURATION_PROVIDER = "FEATURE_AI_LANGUAGE_PACK_CONFIGURATION_PROVIDER";
    public static final String FEATURE_AI_ONDEVICE_LLM_PREWARM = "FEATURE_AI_ONDEVICE_LLM_PREWARM";
    public static final String FEATURE_AI_ONDEVICE_SUMMARY_EXTRA_PROMPT = "FEATURE_AI_ONDEVICE_SUMMARY_EXTRA_PROMPT";
    public static final String FEATURE_AI_TEXT_TO_SPEECH = "FEATURE_AI_TEXT_TO_SPEECH";
    public static final String FEATURE_AUDIO_TO_TRANSLATION = "FEATURE_AUDIO_TO_TRANSLATION";
    public static final String FEATURE_CORE_EXT_ACTION_PARAM_EXTRACTION = "FEATURE_ACTION_PARAM_EXTRACTION";
    public static final String FEATURE_CORE_EXT_GENERIC_INFERENCE = "FEATURE_GENERIC_INFERENCE";
    public static final String FEATURE_CORE_EXT_INTENT_QUERY = "FEATURE_INTENT_QUERY";
    public static final String FEATURE_FAST_SPEAKER_DIARISATION = "FEATURE_FAST_SPEAKER_DIARISATION";
    public static final String FEATURE_IMAGE_GET_BOUNDARIES = "FEATURE_IMAGE_GET_BOUNDARIES";
    public static final String FEATURE_IMAGE_GET_LARGEST_BOUNDARY = "FEATURE_IMAGE_GET_LARGEST_BOUNDARY";
    public static final String FEATURE_IMAGE_UPSCALE_IMAGE = "FEATURE_IMAGE_UPSCALE";
    public static final String FEATURE_LANGUAGE_IDENTIFICATION_AND_GET_CANDIDATE = "FEATURE_LANGUAGE_IDENTIFICATION_AND_GET_CANDIDATE";
    public static final String FEATURE_LANGUAGE_LIST_IDENTIFICATION = "FEATURE_LANGUAGE_LIST_IDENTIFICATION";
    public static final String FEATURE_NATURAL_LANGUAGE_QUERY = "FEATURE_NATURAL_LANGUAGE_QUERY";
    public static final String FEATURE_NEURAL_TRANSLATION = "FEATURE_NEURAL_TRANSLATION";
    public static final String FEATURE_NEURAL_TRANSLATION_BY_CHUNK = "FEATURE_NEURAL_TRANSLATION_BY_CHUNK";
    public static final String FEATURE_NEURAL_TRANSLATION_CLEAR_WITH_SOURCE_ID = "FEATURE_NEURAL_TRANSLATION_CLEAR_WITH_SOURCE_ID";
    public static final String FEATURE_NEURAL_TRANSLATION_FOR_EXTERNAL = "FEATURE_NEURAL_TRANSLATION_FOR_EXTERNAL";
    public static final String FEATURE_NEURAL_TRANSLATION_ONDEVICE_LLM = "FEATURE_NEURAL_TRANSLATION_ONDEVICE_LLM";
    public static final String FEATURE_NEURAL_TRANSLATION_SPEECH_LLM = "FEATURE_NEURAL_TRANSLATION_SPEECH_LLM";
    public static final String FEATURE_NEURAL_TRANSLATION_TAG_SUPPORTED = "FEATURE_NEURAL_TRANSLATION_TAG_SUPPORTED";
    public static final String FEATURE_SIVS_CLASSIFICATION = "FEATURE_SIVS_CLASSIFICATION";
    public static final String FEATURE_SIVS_CONFIGURATION = "FEATURE_SIVS_CONFIGURATION";
    public static final String FEATURE_SIVS_EXTRACTION = "FEATURE_SIVS_EXTRACTION";
    public static final String FEATURE_SIVS_EXTRACTION_ONDEVICE = "FEATURE_SIVS_EXTRACTION_ONDEVICE";
    public static final String FEATURE_SIVS_FORMAT_CONVERSION = "FEATURE_SIVS_FORMAT_CONVERSION";
    public static final String FEATURE_SIVS_WRITING_COMPOSER = "FEATURE_SIVS_WRITING_COMPOSER";
    public static final String FEATURE_SIVS_WRITING_COMPOSER_FOR_EXTERNAL = "FEATURE_SIVS_WRITING_COMPOSER_FOR_EXTERNAL";
    public static final String FEATURE_SIVS_WRITING_COMPOSER_ONDEVICE = "FEATURE_SIVS_WRITING_COMPOSER_ONDEVICE";
    public static final String FEATURE_SKETCH_GUIDED_EDITING_CROPPING_RECT = "FEATURE_SKETCH_GUIDE_EDITING_CROPPING_RECT";
    public static final String FEATURE_SPEAKER_DIARISATION = "FEATURE_SPEAKER_DIARISATION";
    public static final String FEATURE_SPEECH_LOCALE_RECOGNITION = "FEATURE_SPEECH_LOCALE_RECOGNITION";
    public static final String FEATURE_SPEECH_RECOGNITION = "FEATURE_SPEECH_RECOGNITION";
    public static final String FEATURE_STREAMING_LANGUAGE_IDENTIFICATION = "FEATURE_STREAMING_LANGUAGE_IDENTIFICATION";
    public static final String FEATURE_SUGGESTION_SUGGEST_APP_CATEGORY = "FEATURE_SUGGESTION_SUGGEST_APP_CATEGORY";
    public static final String FEATURE_SUGGESTION_SUGGEST_APP_CATEGORY_DETAILS = "FEATURE_SUGGESTION_SUGGEST_APP_CATEGORY_DETAILS";
    public static final String FEATURE_SUGGESTION_SUGGEST_FOLDER_NAME = "FEATURE_SUGGESTION_SUGGEST_FOLDER_NAME";
    public static final String FEATURE_SUGGESTION_SUGGEST_KEYWORD = "FEATURE_SUGGESTION_SUGGEST_KEYWORD";
    public static final String FEATURE_TEXT_CONVERT_UNIT = "FEATURE_TEXT_CONVERT_UNIT";
    public static final String FEATURE_TEXT_DETECT_LANGUAGE = "FEATURE_TEXT_DETECT_LANGUAGE";
    public static final String FEATURE_TEXT_GET_BNLP = "FEATURE_TEXT_GET_BNLP";
    public static final String FEATURE_TEXT_GET_BNLP_LIGHT_MODEL = "FEATURE_TEXT_GET_BNLP_LIGHT_MODEL";
    public static final String FEATURE_TEXT_GET_BNLP_TOKEN = "FEATURE_TEXT_GET_BNLP_TOKEN";
    public static final String FEATURE_TEXT_GET_DOCUMENT_CATEGORY = "FEATURE_TEXT_GET_DOCUMENT_CATEGORY";
    public static final String FEATURE_TEXT_GET_ENTITY = "FEATURE_TEXT_GET_ENTITY";
    public static final String FEATURE_TEXT_GET_ENTITY_BANK = "FEATURE_TEXT_GET_ENTITY_BANK";
    public static final String FEATURE_TEXT_GET_ENTITY_BULK = "FEATURE_TEXT_GET_ENTITY_BULK";
    public static final String FEATURE_TEXT_GET_ENTITY_DATETIME_NUMERAL = "FEATURE_TEXT_GET_ENTITY_DATETIME_NUMERAL";
    public static final String FEATURE_TEXT_GET_ENTITY_DATETIME_SEARCH = "FEATURE_TEXT_GET_ENTITY_DATETIME_SEARCH";
    public static final String FEATURE_TEXT_GET_ENTITY_HAS_YEAR_MONTH_DAY = "FEATURE_TEXT_GET_ENTITY_HAS_YEAR_MONTH_DAY";
    public static final String FEATURE_TEXT_GET_ENTITY_IS_MAPPABLE = "FEATURE_TEXT_GET_ENTITY_IS_MAPPABLE";
    public static final String FEATURE_TEXT_GET_ENTITY_IS_RELATIVE = "FEATURE_TEXT_GET_ENTITY_IS_RELATIVE";
    public static final String FEATURE_TEXT_GET_ENTITY_IS_SPECIAL_DAY = "FEATURE_TEXT_GET_ENTITY_IS_SPECIAL_DAY";
    public static final String FEATURE_TEXT_GET_ENTITY_LOCAL_DATE_TIME = "FEATURE_TEXT_GET_ENTITY_LOCAL_DATE_TIME";
    public static final String FEATURE_TEXT_GET_ENTITY_PHONE_NUMBER = "FEATURE_TEXT_GET_ENTITY_PHONE_NUMBER";
    public static final String FEATURE_TEXT_GET_ENTITY_POI = "FEATURE_TEXT_GET_ENTITY_POI";
    public static final String FEATURE_TEXT_GET_ENTITY_START_OF_WEEK = "FEATURE_TEXT_GET_ENTITY_START_OF_WEEK";
    public static final String FEATURE_TEXT_GET_ENTITY_UNIT = "FEATURE_TEXT_GET_ENTITY_UNIT";
    public static final String FEATURE_TEXT_GET_ENTITY_UPI_ID = "FEATURE_TEXT_GET_ENTITY_UPI_ID";
    public static final String FEATURE_TEXT_GET_EVENT = "FEATURE_TEXT_GET_EVENT";
    public static final String FEATURE_TEXT_GET_EVENT_CATEGORY = "FEATURE_TEXT_GET_EVENT_CATEGORY";
    public static final String FEATURE_TEXT_GET_EVENT_HAS_YEAR_MONTH_DAY = "FEATURE_TEXT_GET_EVENT_HAS_YEAR_MONTH_DAY";
    public static final String FEATURE_TEXT_GET_EVENT_INDEX = "FEATURE_TEXT_GET_EVENT_INDEX";
    public static final String FEATURE_TEXT_GET_KEY_PHRASE = "FEATURE_TEXT_GET_KEY_PHRASE";
    public static final String FEATURE_TEXT_GET_KEY_PHRASE_EVENT_TITLE = "FEATURE_TEXT_GET_KEY_PHRASE_EVENT_TITLE";
    public static final String FEATURE_TEXT_GET_REMINDER_ENTITY = "FEATURE_TEXT_GET_REMINDER_ENTITY";
    public static final String FEATURE_VISUAL_AI_ERASER_ON_DEVICE = "FEATURE_AI_ERASER_ON_DEVICE";
    public static final String FEATURE_VISUAL_B2B_ACCOUNT = "FEATURE_B2B_ACCOUNT";
    public static final String FEATURE_VISUAL_C2PA = "FEATURE_C2PA";
    public static final String FEATURE_VISUAL_DESIGN_IMAGE = "FEATURE_DESIGN_IMAGE";
    public static final String FEATURE_VISUAL_DESIGN_STICKER = "FEATURE_DESIGN_STICKER";
    public static final String FEATURE_VISUAL_DOWNLOAD = "FEATURE_DOWNLOAD";
    public static final String FEATURE_VISUAL_GEN_EDIT_ON_DEVICE = "FEATURE_GEN_EDIT_ON_DEVICE";
    public static final String FEATURE_VISUAL_GEN_STICKER = "FEATURE_GEN_STICKER";
    public static final String FEATURE_VISUAL_HARMONIZATION_ON_DEVICE = "FEATURE_HARMONIZATION_ON_DEVICE";
    public static final String FEATURE_VISUAL_IMAGE_CONVERSION = "FEATURE_IMAGE_CONVERSION";
    public static final String FEATURE_VISUAL_IMAGE_CONVERSION_ON_DEVICE = "FEATURE_IMAGE_CONVERSION_ON_DEVICE";
    public static final String FEATURE_VISUAL_PET_PORTRAIT = "FEATURE_PET_PORTRAIT";
    public static final String FEATURE_VISUAL_PET_PORTRAIT_ON_DEVICE = "FEATURE_PET_PORTRAIT_ON_DEVICE";
    public static final String FEATURE_VISUAL_PORTRAIT = "FEATURE_PORTRAIT";
    public static final String FEATURE_VISUAL_PORTRAIT_ON_DEVICE = "FEATURE_PORTRAIT_ON_DEVICE";
    public static final String FEATURE_VISUAL_PORTRAIT_RELIGHT_ON_DEVICE = "FEATURE_PORTRAIT_RELIGHT_ON_DEVICE";
    public static final String FEATURE_VISUAL_PREREQUISITE = "FEATURE_PREREQUISITE";
    public static final String FEATURE_VISUAL_RESTYLING = "FEATURE_RESTYLING";
    public static final String FEATURE_VISUAL_SKETCH_GUIDED_EDITING = "FEATURE_SKETCH_GUIDE_EDITING";
    public static final String FEATURE_VISUAL_SKETCH_GUIDED_EDITING_ON_DEVICE = "FEATURE_SKETCH_GUIDE_EDITING_ON_DEVICE";
    public static final String FEATURE_VISUAL_SKETCH_TO_IMAGE = "FEATURE_SKETCH_TO_IMAGE";
    public static final String FEATURE_VISUAL_SKETCH_TO_IMAGE_ON_DEVICE = "FEATURE_SKETCH_TO_IMAGE_ON_DEVICE";
    public static final String FEATURE_VISUAL_WALLPAPER = "FEATURE_WALLPAPER";
    private static final String TAG = "ScsApi@Feature";
    private static Boolean sIsVst;
    private static Boolean sIsWatch;
    private static final Map<String, Integer> sinceVersionMap;
    private static final List<String> SUPPORTED_SIVS_FEATURES = Arrays.asList("FEATURE_SPEECH_RECOGNITION", "FEATURE_SPEECH_LOCALE_RECOGNITION", "FEATURE_SPEAKER_DIARISATION", "FEATURE_AUDIO_TO_TRANSLATION", "FEATURE_FAST_SPEAKER_DIARISATION", "FEATURE_STREAMING_LANGUAGE_IDENTIFICATION", "FEATURE_AI_GEN_SUMMARY", "FEATURE_AI_GEN_TRANSLATION", "FEATURE_AI_GEN_TONE", "FEATURE_AI_GEN_CORRECTION", "FEATURE_AI_GEN_SUGGESTION", "FEATURE_AI_GEN_SUGGESTION_ONDEVICE", "FEATURE_AI_GEN_SMART_COVER", "FEATURE_AI_GEN_SMART_REPLY", "FEATURE_AI_GEN_EMOJI_AUGMENTATION", "FEATURE_AI_GEN_NOTES_ORGANIZATION", "FEATURE_AI_GEN_SMART_CAPTURE", "FEATURE_AI_GEN_GENERIC", "FEATURE_AI_GEN_USAGE", "FEATURE_NEURAL_TRANSLATION", "FEATURE_LANGUAGE_LIST_IDENTIFICATION", "FEATURE_LANGUAGE_IDENTIFICATION_AND_GET_CANDIDATE", "FEATURE_NEURAL_TRANSLATION_BY_CHUNK", "FEATURE_NEURAL_TRANSLATION_CLEAR_WITH_SOURCE_ID", "FEATURE_NEURAL_TRANSLATION_TAG_SUPPORTED", "FEATURE_NEURAL_TRANSLATION_FOR_EXTERNAL", "FEATURE_NEURAL_TRANSLATION_SPEECH_LLM", "FEATURE_SIVS_CLASSIFICATION", "FEATURE_SIVS_CONFIGURATION", "FEATURE_SIVS_EXTRACTION", "FEATURE_SIVS_EXTRACTION_ONDEVICE", "FEATURE_SIVS_WRITING_COMPOSER", "FEATURE_SIVS_WRITING_COMPOSER_ONDEVICE", "FEATURE_SIVS_FORMAT_CONVERSION", "FEATURE_AI_LANGUAGE_PACK_CONFIGURATION_PROVIDER", "FEATURE_AI_GEN_B2B_ACCOUNT", "FEATURE_AI_GEN_TRANSLATION_ONDEVICE", "FEATURE_NEURAL_TRANSLATION_ONDEVICE_LLM", "FEATURE_AI_TEXT_TO_SPEECH", "FEATURE_AI_GEN_SUMMARY_FOR_EXTERNAL", "FEATURE_AI_GEN_TONE_FOR_EXTERNAL", "FEATURE_AI_GEN_CORRECTION_FOR_EXTERNAL", "FEATURE_AI_GEN_SMART_REPLY_FOR_EXTERNAL", "FEATURE_SIVS_WRITING_COMPOSER_FOR_EXTERNAL", "FEATURE_AI_CUSTOM_TEXT_TO_SPEECH", "FEATURE_AI_ONDEVICE_SUMMARY_EXTRA_PROMPT", "FEATURE_AI_CLOUD_LLM_INTERPRETATION", "FEATURE_AI_ONDEVICE_LLM_PREWARM");
    private static final List<String> SUPPORTED_AI_CORE_FEATURES = Arrays.asList("FEATURE_DOWNLOAD", "FEATURE_WALLPAPER", "FEATURE_GEN_EDIT_ON_DEVICE", "FEATURE_PORTRAIT_ON_DEVICE", "FEATURE_SKETCH_TO_IMAGE_ON_DEVICE", "FEATURE_SKETCH_GUIDE_EDITING_ON_DEVICE", "FEATURE_PORTRAIT_RELIGHT_ON_DEVICE", "FEATURE_IMAGE_CONVERSION_ON_DEVICE", "FEATURE_AI_ERASER_ON_DEVICE", "FEATURE_HARMONIZATION_ON_DEVICE", "FEATURE_PET_PORTRAIT_ON_DEVICE");
    private static final List<String> SUPPORTED_AI_CORE_EXT_FEATURES = Arrays.asList("FEATURE_INTENT_QUERY", "FEATURE_ACTION_PARAM_EXTRACTION", "FEATURE_GENERIC_INFERENCE");
    private static final List<String> SUPPORTED_VISUAL_CLOUD_FEATURES = Arrays.asList("FEATURE_PORTRAIT", "FEATURE_SKETCH_TO_IMAGE", "FEATURE_SKETCH_GUIDE_EDITING", "FEATURE_SKETCH_GUIDE_EDITING_CROPPING_RECT", "FEATURE_C2PA", "FEATURE_PREREQUISITE", "FEATURE_GEN_STICKER", "FEATURE_IMAGE_CONVERSION", "FEATURE_PET_PORTRAIT", "FEATURE_RESTYLING", "FEATURE_DESIGN_IMAGE", "FEATURE_DESIGN_STICKER");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.CLASS)
    public @interface featureName {
    }

    static {
        HashMap map = new HashMap();
        map.put("FEATURE_IMAGE_GET_BOUNDARIES", 1);
        map.put("FEATURE_IMAGE_GET_LARGEST_BOUNDARY", 1);
        map.put("FEATURE_IMAGE_UPSCALE", 2);
        map.put("FEATURE_SUGGESTION_SUGGEST_KEYWORD", 1);
        map.put("FEATURE_SUGGESTION_SUGGEST_APP_CATEGORY", 2);
        map.put("FEATURE_SUGGESTION_SUGGEST_APP_CATEGORY_DETAILS", 3);
        map.put("FEATURE_SUGGESTION_SUGGEST_FOLDER_NAME", 2);
        map.put("FEATURE_TEXT_GET_ENTITY", 2);
        map.put("FEATURE_TEXT_GET_ENTITY_BULK", 24);
        map.put("FEATURE_TEXT_GET_ENTITY_DATETIME_NUMERAL", 9);
        map.put("FEATURE_TEXT_GET_ENTITY_DATETIME_SEARCH", 22);
        map.put("FEATURE_TEXT_GET_ENTITY_PHONE_NUMBER", 9);
        map.put("FEATURE_TEXT_GET_ENTITY_POI", 10);
        map.put("FEATURE_TEXT_GET_ENTITY_BANK", 9);
        map.put("FEATURE_TEXT_GET_ENTITY_IS_MAPPABLE", 15);
        map.put("FEATURE_TEXT_GET_ENTITY_IS_RELATIVE", 15);
        map.put("FEATURE_TEXT_GET_ENTITY_IS_SPECIAL_DAY", 17);
        map.put("FEATURE_TEXT_GET_ENTITY_HAS_YEAR_MONTH_DAY", 18);
        map.put("FEATURE_TEXT_GET_ENTITY_UPI_ID", 16);
        map.put("FEATURE_TEXT_GET_ENTITY_UNIT", 20);
        map.put("FEATURE_TEXT_GET_ENTITY_START_OF_WEEK", 26);
        map.put("FEATURE_TEXT_GET_ENTITY_LOCAL_DATE_TIME", 27);
        map.put("FEATURE_TEXT_GET_EVENT", 13);
        map.put("FEATURE_TEXT_GET_EVENT_HAS_YEAR_MONTH_DAY", 18);
        map.put("FEATURE_TEXT_GET_EVENT_INDEX", 21);
        map.put("FEATURE_TEXT_GET_KEY_PHRASE", 3);
        map.put("FEATURE_TEXT_GET_KEY_PHRASE_EVENT_TITLE", 11);
        map.put("FEATURE_TEXT_GET_DOCUMENT_CATEGORY", 5);
        map.put("FEATURE_TEXT_GET_BNLP", 2);
        map.put("FEATURE_TEXT_GET_BNLP_TOKEN", 12);
        map.put("FEATURE_TEXT_GET_BNLP_LIGHT_MODEL", 26);
        map.put("FEATURE_TEXT_DETECT_LANGUAGE", 9);
        map.put("FEATURE_TEXT_CONVERT_UNIT", 19);
        map.put("FEATURE_TEXT_GET_REMINDER_ENTITY", 23);
        map.put("FEATURE_TEXT_GET_EVENT_CATEGORY", 25);
        map.put("FEATURE_NATURAL_LANGUAGE_QUERY", 1);
        map.put("FEATURE_SPEECH_RECOGNITION", SpeechRecognitionConst.SINCE_SPEECH_RECOGNITION);
        map.put("FEATURE_SPEECH_LOCALE_RECOGNITION", SpeechRecognitionConst.SINCE_SPEECH_LOCALE_RECOGNITION);
        map.put("FEATURE_SPEAKER_DIARISATION", SpeechRecognitionConst.SINCE_SPEAKER_DIARISATION);
        map.put("FEATURE_AUDIO_TO_TRANSLATION", SpeechRecognitionConst.SINCE_AUDIO_TO_TRANSLATION);
        map.put("FEATURE_FAST_SPEAKER_DIARISATION", SpeechRecognitionConst.SINCE_FEATURE_FAST_SOUND_RECOGNITION);
        map.put("FEATURE_STREAMING_LANGUAGE_IDENTIFICATION", SpeechRecognitionConst.SINCE_STREAMING_LANGUAGE_IDENTIFICATION);
        map.put("FEATURE_AI_GEN_SUMMARY", LlmServiceConst.SINCE_AI_SUMMARY);
        map.put("FEATURE_AI_GEN_TRANSLATION", LlmServiceConst.SINCE_AI_TRANSLATION);
        map.put("FEATURE_AI_GEN_TONE", LlmServiceConst.SINCE_AI_TONE);
        map.put("FEATURE_AI_GEN_CORRECTION", LlmServiceConst.SINCE_AI_CORRECTION);
        map.put("FEATURE_AI_GEN_SUGGESTION", LlmServiceConst.SINCE_AI_SUGGESTION);
        map.put("FEATURE_AI_GEN_SUGGESTION_ONDEVICE", LlmServiceConst.SINCE_AI_SUGGESTION_ONDEVICE);
        map.put("FEATURE_AI_GEN_SMART_COVER", LlmServiceConst.SINCE_AI_SMART_COVER);
        map.put("FEATURE_AI_GEN_SMART_REPLY", LlmServiceConst.SINCE_AI_SMART_REPLY);
        map.put("FEATURE_AI_GEN_EMOJI_AUGMENTATION", LlmServiceConst.SINCE_AI_EMOJI_AUGMENTATION);
        map.put("FEATURE_AI_GEN_NOTES_ORGANIZATION", LlmServiceConst.SINCE_AI_NOTES_ORGANIZATION);
        map.put("FEATURE_AI_GEN_SMART_CAPTURE", LlmServiceConst.SINCE_AI_SMART_CAPTURE);
        map.put("FEATURE_AI_GEN_GENERIC", LlmServiceConst.SINCE_AI_GENERIC);
        map.put("FEATURE_NEURAL_TRANSLATION", TranslationConst.SINCE_NEURAL_TRANSLATION);
        map.put("FEATURE_LANGUAGE_LIST_IDENTIFICATION", TranslationConst.SINCE_LANGUAGE_LIST_IDENTIFICATION);
        map.put("FEATURE_LANGUAGE_IDENTIFICATION_AND_GET_CANDIDATE", TranslationConst.SINCE_LANGUAGE_IDENTIFICATION_AND_GET_CANDIDATE);
        map.put("FEATURE_NEURAL_TRANSLATION_BY_CHUNK", TranslationConst.SINCE_CHUNK_TEXT);
        map.put("FEATURE_NEURAL_TRANSLATION_TAG_SUPPORTED", TranslationConst.SINCE_TAGGED_TRANSLATION_SUPPORTED);
        map.put("FEATURE_NEURAL_TRANSLATION_CLEAR_WITH_SOURCE_ID", TranslationConst.SINCE_CLEAR_WITH_SOURCE_ID);
        map.put("FEATURE_NEURAL_TRANSLATION_FOR_EXTERNAL", TranslationConst.SINCE_NEURAL_TRANSLATION_FOR_EXTERNAL);
        map.put("FEATURE_SIVS_CLASSIFICATION", LlmServiceConst.SINCE_SIVS_CLASSIFICATION);
        map.put("FEATURE_SIVS_EXTRACTION", LlmServiceConst.SINCE_SIVS_EXTRACTION);
        map.put("FEATURE_SIVS_EXTRACTION_ONDEVICE", LlmServiceConst.SINCE_SIVS_EXTRACTION_ONDEVICE);
        map.put("FEATURE_SIVS_WRITING_COMPOSER", LlmServiceConst.SINCE_SIVS_WRITING_COMPOSER);
        map.put("FEATURE_SIVS_WRITING_COMPOSER_ONDEVICE", LlmServiceConst.SINCE_SIVS_WRITING_COMPOSER_ONDEVICE);
        map.put("FEATURE_SIVS_FORMAT_CONVERSION", LlmServiceConst.SINCE_SIVS_FORMAT_CONVERSION);
        map.put("FEATURE_SIVS_CONFIGURATION", LlmServiceConst.SINCE_SIVS_CONFIGURATION);
        map.put("FEATURE_AI_GEN_USAGE", LlmServiceConst.SINCE_AI_USAGE);
        map.put("FEATURE_AI_LANGUAGE_PACK_CONFIGURATION_PROVIDER", LlmServiceConst.SINCE_AI_LANGUAGE_PACK_CONFIGURATION_PROVIDER);
        map.put("FEATURE_AI_GEN_B2B_ACCOUNT", LlmServiceConst.SINCE_AI_LANGUAGE_B2B_ACCOUNT);
        map.put("FEATURE_AI_GEN_TRANSLATION_ONDEVICE", LlmServiceConst.SINCE_AI_TRANSLATION_ONDEVICE);
        map.put("FEATURE_NEURAL_TRANSLATION_ONDEVICE_LLM", TranslationConst.SINCE_ONDEVICE_LLM_TRANSLATION);
        map.put("FEATURE_NEURAL_TRANSLATION_SPEECH_LLM", TranslationConst.SINCE_SPEECH_LLM_TRANSLATION);
        map.put("FEATURE_AI_ONDEVICE_SUMMARY_EXTRA_PROMPT", LlmServiceConst.SINCE_AI_ONDEVICE_SUMMARY_EXTRA_PROMPT);
        map.put("FEATURE_AI_CLOUD_LLM_INTERPRETATION", LlmServiceConst.SINCE_AI_CLOUD_LLM_INTERPRETATION);
        map.put("FEATURE_AI_ONDEVICE_LLM_PREWARM", LlmServiceConst.SINCE_AI_ONDEVICE_LLM_PREWARM);
        map.put("FEATURE_AI_GEN_SUMMARY_FOR_EXTERNAL", LlmServiceConst.SINCE_AI_SUMMARY_FOR_EXTERNAL);
        map.put("FEATURE_AI_GEN_TONE_FOR_EXTERNAL", LlmServiceConst.SINCE_AI_TONE_FOR_EXTERNAL);
        map.put("FEATURE_AI_GEN_CORRECTION_FOR_EXTERNAL", LlmServiceConst.SINCE_AI_CORRECTION_FOR_EXTERNAL);
        map.put("FEATURE_AI_GEN_SMART_REPLY_FOR_EXTERNAL", LlmServiceConst.SINCE_AI_SMART_REPLY_FOR_EXTERNAL);
        map.put("FEATURE_SIVS_WRITING_COMPOSER_FOR_EXTERNAL", LlmServiceConst.SINCE_SIVS_WRITING_COMPOSER_FOR_EXTERNAL);
        map.put("FEATURE_AI_TEXT_TO_SPEECH", 2);
        map.put("FEATURE_AI_CUSTOM_TEXT_TO_SPEECH", 3);
        map.put("FEATURE_WALLPAPER", 1);
        map.put("FEATURE_DOWNLOAD", 1);
        map.put("FEATURE_PORTRAIT", 1);
        map.put("FEATURE_SKETCH_TO_IMAGE", 1);
        map.put("FEATURE_SKETCH_GUIDE_EDITING", 1);
        map.put("FEATURE_SKETCH_GUIDE_EDITING_CROPPING_RECT", 2);
        map.put("FEATURE_C2PA", 3);
        map.put("FEATURE_GEN_STICKER", 6);
        map.put("FEATURE_IMAGE_CONVERSION", 6);
        map.put("FEATURE_B2B_ACCOUNT", 7);
        map.put("FEATURE_PET_PORTRAIT", 8);
        map.put("FEATURE_RESTYLING", 9);
        map.put("FEATURE_DESIGN_IMAGE", 10);
        map.put("FEATURE_DESIGN_STICKER", 10);
        map.put("FEATURE_IMAGE_CONVERSION_ON_DEVICE", 8);
        map.put("FEATURE_AI_ERASER_ON_DEVICE", 9);
        map.put("FEATURE_HARMONIZATION_ON_DEVICE", 9);
        map.put("FEATURE_GEN_EDIT_ON_DEVICE", 4);
        map.put("FEATURE_SKETCH_TO_IMAGE_ON_DEVICE", 5);
        map.put("FEATURE_PORTRAIT_ON_DEVICE", 10);
        map.put("FEATURE_PET_PORTRAIT_ON_DEVICE", 10);
        map.put("FEATURE_PREREQUISITE", 2);
        map.put("FEATURE_INTENT_QUERY", 1);
        map.put("FEATURE_ACTION_PARAM_EXTRACTION", 1);
        map.put("FEATURE_GENERIC_INFERENCE", 2);
        sinceVersionMap = Collections.unmodifiableMap(map);
    }

    @StatusCodes.checkFeatureResult
    public static int checkFeature(Context context, @featureName String str) {
        Log.m6489i(TAG, "checkFeature() : " + str + ", sdk : 4.0.55");
        if (context == null || str == null) {
            Log.m6487e(TAG, "checkFeature(). input is null. context: " + context + ", feature: " + str);
            return 300;
        }
        String serviceAppName = getServiceAppName(context, str);
        try {
            if (context.getPackageManager().getApplicationInfo(serviceAppName, 128).enabled) {
                int iCheckScsFeature = checkScsFeature(context, serviceAppName, str);
                FeatureStatusCache.setStatus(str, iCheckScsFeature);
                return iCheckScsFeature;
            }
            Log.m6490w(TAG, "checkFeature(). " + serviceAppName + " has disabled.");
            FeatureStatusCache.setStatus(str, 2);
            return 2;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.m6490w(TAG, "dump(), " + serviceAppName + " does not exist");
            FeatureStatusCache.setStatus(str, 1);
            return 1;
        }
    }

    @StatusCodes.checkFeatureResult
    private static int checkScsFeature(@NonNull Context context, @NonNull String str, @NonNull @featureName String str2) {
        int featureVersionFromSettings = FeatureHelper.getFeatureVersionFromSettings(context, str, str2, getGlobalSettingsKeyName(context, str2));
        if (featureVersionFromSettings == -2) {
            featureVersionFromSettings = FeatureHelper.getFeatureVersionFromProvider(context, Uri.parse(getUriString(context, str2)), str2);
        }
        if (featureVersionFromSettings == -2) {
            Log.m6487e(TAG, "checkScsFeature(). retBundle == null!!!");
            return 2000;
        }
        if (featureVersionFromSettings == 0) {
            Log.m6490w(TAG, "checkScsFeature(). " + str2 + " is not available!!");
            return 5;
        }
        if (featureVersionFromSettings == -1) {
            Log.m6490w(TAG, "checkScsFeature(). SCS doesn't know " + str2 + ". SCS update might be required.");
            return 3;
        }
        Map<String, Integer> map = sinceVersionMap;
        int iIntValue = map.containsKey(str2) ? map.get(str2).intValue() : Integer.MAX_VALUE;
        if (featureVersionFromSettings >= iIntValue) {
            return 0;
        }
        StringBuilder sbM780v = AbstractC0541b.m780v("checkScsFeature(). ", featureVersionFromSettings, str2, ", scsVersion: ", ", sinceVersion: ");
        sbM780v.append(iIntValue);
        Log.m6487e(TAG, sbM780v.toString());
        return 3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void clear() {
        FeatureStatusCache.clear();
    }

    public static int getApiVersionCode() {
        return Integer.parseInt(BuildConfig.VERSION_CODE);
    }

    public static String getApiVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    private static String getGlobalSettingsKeyName(Context context, @NonNull String str) {
        return (isSIVSAvailableOSVersion(context) && SUPPORTED_SIVS_FEATURES.contains(str)) ? SivsFeatureConst.GLOBAL_SETTINGS_KEY_NAME : (SUPPORTED_AI_CORE_FEATURES.contains(str) || SUPPORTED_VISUAL_CLOUD_FEATURES.contains(str)) ? VisualFeatureConst.GLOBAL_SETTINGS_KEY_NAME : FeatureConst.GLOBAL_SETTINGS_KEY_NAME;
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getQueryService(Context context, Intent intent, String str) {
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices.isEmpty()) {
            Log.m6485d(TAG, "getQueryService is null. use default " + str);
            return str;
        }
        Log.m6485d(TAG, "getQueryService : " + listQueryIntentServices.get(0).serviceInfo.packageName);
        return listQueryIntentServices.get(0).serviceInfo.packageName;
    }

    public static int getScsVersionCode(Context context) {
        PackageInfo packageInfo = getPackageInfo(context, BaseConstants.PACKAGE_INFO.PACKAGE_CORE_SERVICES);
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    public static String getScsVersionName(Context context) {
        PackageInfo packageInfo = getPackageInfo(context, BaseConstants.PACKAGE_INFO.PACKAGE_CORE_SERVICES);
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    private static String getServiceAppName(Context context, String str) {
        return (isSIVSAvailableOSVersion(context) && SUPPORTED_SIVS_FEATURES.contains(str)) ? BaseConstants.PACKAGE_INFO.PACKAGE_SIVS_SERVICES : SUPPORTED_AI_CORE_FEATURES.contains(str) ? BaseConstants.PACKAGE_INFO.PACKAGE_AICORE_SERVICES : SUPPORTED_VISUAL_CLOUD_FEATURES.contains(str) ? BaseConstants.PACKAGE_INFO.PACKAGE_VISUAL_CLOUD_CORE_SERVICES : SUPPORTED_AI_CORE_EXT_FEATURES.contains(str) ? getQueryService(context, new Intent(BaseConstants.SERVICE_ACTION.ACTION_ON_DEVICE_SERVICE), BaseConstants.PACKAGE_INFO.PACKAGE_AICORE_SERVICES) : BaseConstants.PACKAGE_INFO.PACKAGE_CORE_SERVICES;
    }

    public static int getSivsVersionCode(Context context) {
        PackageInfo packageInfo = getPackageInfo(context, BaseConstants.PACKAGE_INFO.PACKAGE_SIVS_SERVICES);
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    public static String getSivsVersionName(Context context) {
        PackageInfo packageInfo = getPackageInfo(context, BaseConstants.PACKAGE_INFO.PACKAGE_SIVS_SERVICES);
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    private static String getUriString(Context context, String str) {
        return (isSIVSAvailableOSVersion(context) && SUPPORTED_SIVS_FEATURES.contains(str)) ? "content://com.samsung.android.intellivoiceservice.feature" : (SUPPORTED_AI_CORE_FEATURES.contains(str) || SUPPORTED_AI_CORE_EXT_FEATURES.contains(str)) ? VisualFeatureConst.URI_STRING : SUPPORTED_VISUAL_CLOUD_FEATURES.contains(str) ? VisualFeatureConst.CLOUD_URI_STRING : FeatureConst.CORE_URI_STRING;
    }

    public static boolean isSIVSAvailableOSVersion(Context context) {
        try {
            if (!isWatch(context) && !isVst(context)) {
                return Build.VERSION.SDK_INT >= 34 && Build.VERSION.SEM_PLATFORM_INT >= 150100;
            }
        } catch (Exception | NoSuchFieldError unused) {
        }
        return Build.VERSION.SDK_INT >= 34 && Build.VERSION.SEM_PLATFORM_INT >= 150000;
    }

    private static boolean isVst(Context context) {
        Boolean bool = sIsVst;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean boolValueOf = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.software.xr.api.spatial") || context.getPackageManager().hasSystemFeature("android.software.xr.api.openxr"));
            sIsVst = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Error | Exception unused) {
            return false;
        }
    }

    private static boolean isWatch(Context context) {
        Boolean bool = sIsWatch;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean boolValueOf = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
            sIsWatch = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Error | Exception unused) {
            return false;
        }
    }
}
