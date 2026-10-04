package com.samsung.android.support.senl.p148nt.data.common.constants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DataConstants {
    public static final int CONTENT_SECURE_VERSION_1 = 1;
    public static final int CONTENT_SECURE_VERSION_NONE = 0;
    public static final String DARK_MODE_PREFIX = "d_";
    public static final int DISPLAY_CONTENT_MAX_LENGTH = 300;
    public static final String GRID_POSTFIX = "_g";
    public static final int INDEXING_CONTENT_MAX_LENGTH = 30000;
    public static final String LIST_POSTFIX = "_l";
    public static final int MAX_ALLOWED_DISPLAY_CONTENT_SIZE = 40960;
    public static final int OLD_THUMBNAIL_IMAGE_SIZE = 768;
    public static final String SPEED_PROFILE_DB_NAME = "speed_profile.db";
    public static final int STT_MAX_CONTENT_SIZE = 40960;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface INIT_REQUEST_TYPE {
        public static final int CREATE_COVER_DATA = 16;
        public static final int CREATE_DEFAULT_DATA = 31;
        public static final int CREATE_DEFAULT_FOLDERS = 1;
        public static final int CREATE_MATH_FOLDER = 8;
        public static final int CREATE_OLD_FOLDERS = 2;
        public static final int CREATE_SCREEN_OFF_MEMO_FOLDER = 4;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface Layout {
        public static final int LANDSCAPE = 2;
        public static final int NONE = 0;
        public static final int PORTRAIT = 1;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface MATH_MODE {
        public static final int OFF = 0;
        public static final int SOLVE_MATH_ON = 1;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface MIME_TYPE {
        public static final String AUDIO = "content/audio";
        public static final String DEFAULT = "application/octet-stream";
        public static final String DRAWING = "content/drawing";
        public static final String HANDWRITING = "content/handwriting";
        public static final String IMAGE = "content/image";
        public static final String VOICE = "content/voice";
        public static final String VOICE_RECORDING = "content/voice_recording";
        public static final String WEB = "content/web";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface PageBackgroundType {
        public static final int CUSTOM_PDF = 3;
        public static final int IMAGE = 1;
        public static final int NONE = 0;
        public static final int PDF = 2;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface STT_CONTENT_TYPE {
        public static final int SPEAKER = 3;
        public static final int SUMMARY = 2;
        public static final int TRANSCRIBE_LANGUAGE = 4;
        public static final int TRANSCRIPT_EXTRA_INFO = 1;
        public static final int TRANSCRIPT_TEXT = 0;
    }
}
