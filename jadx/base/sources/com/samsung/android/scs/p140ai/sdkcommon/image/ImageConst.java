package com.samsung.android.scs.p140ai.sdkcommon.image;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ImageConst {
    public static final String KEY_BOUNDARY = "boundary";
    public static final String KEY_BOUNDARY_COUNT = "boundaryCount";
    public static final String KEY_BOUNDARY_LIST = "boundaryList";
    public static final String KEY_BOUNDARY_RECT = "boundaryRect";
    public static final String KEY_PARAM_BMP = "bmp";
    public static final String KEY_PARAM_URI = "uri";
    public static final String KEY_RECT = "rect";
    public static final String KEY_RESULT_CODE = "resultCode";
    public static final String METHOD_GET_BOUNDARY = "getBoundaries";
    public static final String METHOD_GET_LARGEST_BOUNDARY = "largestBoundary";
    public static final String METHOD_UPSCALE_IMAGE = "upscaleImage";
    public static final int SINCE_METHOD_GET_BOUNDARY = 1;
    public static final int SINCE_METHOD_GET_LARGEST_BOUNDARY = 1;
    public static final int SINCE_METHOD_UPSCALE_IMAGE = 2;
    public static final String URI_STRING = "com.samsung.android.scs.ai.image";
    public static final int VERSION = 2;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ImageUpscaleConst {
        public static final String ARG_CREATE_SESSION = "createSession";
        public static final String ARG_END_SESSION = "endSession";
        public static final String ARG_PERFORM_UPSCALE = "performUpscale";
        public static final String KEY_APPLICATION_ID = "applicationId";
        public static final String KEY_ENGINE_TYPE = "engineType";
        public static final String KEY_IMAGE_HEIGHT = "imageHeight";
        public static final String KEY_IMAGE_PADDING = "imagePadding";
        public static final String KEY_IMAGE_SIZE = "imageSize";
        public static final String KEY_IMAGE_WIDTH = "imageWidth";
        public static final String KEY_SCALE_FACTOR = "scaleFactor";
        public static final String KEY_SCENE_TYPE = "sceneType";
        public static final String SHARED_MEM_CAPACITY = "capacity";
        public static final String SHARED_MEM_READ = "readMemory";
        public static final int SHARED_MEM_READ_IDX = 0;
        public static final String SHARED_MEM_WRITE = "writeMemory";
        public static final int SHARED_MEM_WRITE_IDX = 1;
    }
}
