package com.samsung.android.sdk.scs.p142ai.translation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum NeuralTranslationErrorCode {
    UNKNOWN(-1),
    NOT_AVAILABLE_DIRECTION_ERROR(100),
    NONE(200),
    INTERRUPTED(300),
    COMPUTATION_ERROR(400),
    RESOURCE_ACCESS_ERROR(500),
    ILLEGAL_RESOURCE_ERROR(501),
    UNAUTHORIZED_RESOURCE_ERROR(502),
    SPEECH_LLM_ERROR_NONE(1000),
    SPEECH_LLM_ERROR_INVALID_PARAMETER(1001),
    SPEECH_LLM_ERROR_FILE_NOT_FOUND(1002),
    SPEECH_LLM_ERROR_CONFIG_ERROR(1003),
    SPEECH_LLM_ERROR_INVALID_STATE(1004),
    SPEECH_LLM_ERROR_INVALID_TYPE(1005),
    SPEECH_LLM_ERROR_INVALID_FILE(1006),
    SPEECH_LLM_ERROR_UNSUPPORTED(1007),
    SPEECH_LLM_ERROR_OVERFLOW(1008),
    SPEECH_LLM_ERROR_NOT_INITIALIZED(1009),
    SPEECH_LLM_ERROR_ALLOCATE_FAIL(1010),
    SPEECH_LLM_ERROR_INPUT_SOURCE(1011),
    SPEECH_LLM_ERROR_INSUFFICIENT_PERMISSIONS(1012),
    SPEECH_LLM_ERROR_RESULT_STREAM(1013),
    SPEECH_LLM_ERROR_TIMEOUT(1014);

    private final int codeValue;

    NeuralTranslationErrorCode(int i) {
        this.codeValue = i;
    }

    public static NeuralTranslationErrorCode from(int i) {
        for (NeuralTranslationErrorCode neuralTranslationErrorCode : values()) {
            if (neuralTranslationErrorCode.code() == i) {
                return neuralTranslationErrorCode;
            }
        }
        return UNKNOWN;
    }

    public int code() {
        return this.codeValue;
    }
}
