package com.samsung.android.imagetranslation.common;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LttEngineErrors {
    public static final int ERROR_CALLBACK_NULL = -2;
    public static final int ERROR_CONTEXT_NULL = -3;
    public static final int ERROR_GENERATE_TRANSLATION_MASK = -16;
    public static final int ERROR_HARD_ERROR = -400;
    public static final int ERROR_INPAINTER_SOFT_ERROR = -200;
    public static final int ERROR_INPAINTING_FAILED = -101;
    public static final int ERROR_INPAINTING_GET_MASK_NATIVE_FAILED = -108;
    public static final int ERROR_INPAINTING_IMG_DECODING_FAILED = -105;
    public static final int ERROR_INPAINTING_IMG_DIM_MISMATCH = -106;
    public static final int ERROR_INPAINTING_INITIALIZATION_FAILED = -102;
    public static final int ERROR_INPAINTING_INPUT_IMAGE_NULL = -109;
    public static final int ERROR_INPAINTING_NOT_SUPPORTED = -104;
    public static final int ERROR_INPAINTING_OCR_BLOCK_EMPTY = -112;
    public static final int ERROR_INPAINTING_OCR_BLOCK_TABULAR = -113;
    public static final int ERROR_INPAINTING_OCR_NULL = -111;
    public static final int ERROR_INPAINTING_PROCESSING_FAILED = -103;
    public static final int ERROR_INPAINTING_RESOLUTION_NOT_SUPPORTED = -110;
    public static final int ERROR_INPAINTING_VEX_MANAGER_NULL = -107;
    public static final int ERROR_INPUT_IMAGE_NULL = -7;
    public static final int ERROR_JAR_NATIVE_COMPATIBILITY = -4;
    public static final int ERROR_LTT_INIT_FAILED = -6;
    public static final int ERROR_NATIVE_INIT_FAILED = -5;
    public static final int ERROR_NATIVE_RENDER_API_FAILED = -17;
    public static final int ERROR_OCR_BLOCK_EMPTY = -10;
    public static final int ERROR_OCR_NULL = -9;
    public static final int ERROR_OCR_TRL_MISMATCH = -14;
    public static final int ERROR_RENDERER_SOFT_ERROR = -300;
    public static final int ERROR_RESOLUTION_NOT_SUPPORTED = -8;
    public static final int ERROR_SCENE_TEXT_CONVERSION = -18;
    public static final int ERROR_SESSION_NULL = -1;
    public static final int ERROR_TEXT_DISTRIBUTION = -15;
    public static final int ERROR_TRL_EMPTY = -12;
    public static final int ERROR_TRL_EMPTY_ALL_LINES = -13;
    public static final int ERROR_TRL_NULL = -11;
    public static final int NO_ERROR = 1;

    public static int mapToClientErrorType(int i) {
        if (i == -400) {
            return -400;
        }
        return (i > -101 || i < -200) ? -300 : -200;
    }
}
