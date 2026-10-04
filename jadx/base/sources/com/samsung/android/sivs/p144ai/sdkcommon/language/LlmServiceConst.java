package com.samsung.android.sivs.p144ai.sdkcommon.language;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LlmServiceConst {
    public static final String CONFIG_URI_STRING = "com.samsung.android.intellivoiceservice.common.config";
    public static final String SYSTEM_CONFIG_URI_STRING = "com.samsung.android.intellivoiceservice.common.config.systemlevel";
    public static final String SYSTEM_PERMISSION_QUERY_CONFIG_CP = "com.samsung.android.intellivoiceservice.common.permission.SYSTEM_CONFIG_PROVIDER";
    public static final Integer VERSION = 16;
    public static final Integer SINCE_AI_SUMMARY = 6;
    public static final Integer SINCE_AI_TRANSLATION = 6;
    public static final Integer SINCE_AI_TRANSLATION_ONDEVICE = 13;
    public static final Integer SINCE_AI_TONE = 6;
    public static final Integer SINCE_AI_CORRECTION = 6;
    public static final Integer SINCE_AI_SUGGESTION = 7;
    public static final Integer SINCE_AI_SUGGESTION_ONDEVICE = 10;
    public static final Integer SINCE_AI_SMART_COVER = 6;
    public static final Integer SINCE_AI_SMART_REPLY = 6;
    public static final Integer SINCE_AI_EMOJI_AUGMENTATION = 6;
    public static final Integer SINCE_AI_NOTES_ORGANIZATION = 6;
    public static final Integer SINCE_AI_SMART_CAPTURE = 6;
    public static final Integer SINCE_SIVS_CLASSIFICATION = 6;
    public static final Integer SINCE_SIVS_EXTRACTION = 6;
    public static final Integer SINCE_SIVS_EXTRACTION_ONDEVICE = 10;
    public static final Integer SINCE_SIVS_WRITING_COMPOSER = 8;
    public static final Integer SINCE_SIVS_WRITING_COMPOSER_ONDEVICE = 10;
    public static final Integer SINCE_SIVS_FORMAT_CONVERSION = 10;
    public static final Integer SINCE_SIVS_CONFIGURATION = 6;
    public static final Integer SINCE_AI_GENERIC = 6;
    public static final Integer SINCE_AI_USAGE = 6;
    public static final Integer SINCE_AI_LANGUAGE_PACK_CONFIGURATION_PROVIDER = 9;
    public static final Integer SINCE_AI_SUMMARY_FOR_EXTERNAL = 11;
    public static final Integer SINCE_AI_TONE_FOR_EXTERNAL = 11;
    public static final Integer SINCE_AI_CORRECTION_FOR_EXTERNAL = 11;
    public static final Integer SINCE_AI_SMART_REPLY_FOR_EXTERNAL = 11;
    public static final Integer SINCE_SIVS_WRITING_COMPOSER_FOR_EXTERNAL = 11;
    public static final Integer SINCE_AI_LANGUAGE_B2B_ACCOUNT = 12;
    public static final Integer SINCE_AI_ONDEVICE_SUMMARY_EXTRA_PROMPT = 14;
    public static final Integer SINCE_AI_CLOUD_LLM_INTERPRETATION = 15;
    public static final Integer SINCE_AI_ONDEVICE_LLM_PREWARM = 16;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Error {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Code {
            public static final int AUTH_ERROR_PACKAGE_NOT_REGISTERED_IN_WHITELIST = 2600;
            public static final int DEVICE_EXCEED_RATE_LIMIT = 250;
            public static final int DEVICE_INIT_ERROR = 102;
            public static final int DEVICE_WATCH_DATA_LAYER_ERROR = 181;
            public static final int DEVICE_WATCH_INTERNAL_ERROR = 183;
            public static final int DEVICE_WATCH_NOT_CONNECTED_ERROR = 180;
            public static final int DEVICE_WATCH_NOT_SUPPORT_TASK_ERROR = 184;
            public static final int DEVICE_WATCH_ON_DEVICE_PACKAGE_ERROR = 182;
            public static final int GRPC_CANCELLED = 1;
            public static final int GRPC_UNAUTHENTICATED = 16;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Key {
        public static final String ERROR_CODE = "error_code";
        public static final String ERROR_MESSAGE = "error_message";
        public static final String LANGUAGE_PACK_CONFIGURATION_JSON = "language_pack_configuration_json";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Method {
        public static final String GET_LANGUAGE_PACK_CONFIGURATION = "get_language_pack_configuration";
    }
}
