package com.samsung.android.sdk.pen.ocr;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenOcrDataProviderContract {
    public static final String ASSETS_MODEL_BLOCK_ANALYZER = "ba";
    public static final String ASSETS_MODEL_DIR_BLOCK_ANALYZER = "blockanalyzer";
    public static final String ASSETS_MODEL_DIR_MOIRE_DETECTOR = "moiredetector";
    public static final String ASSETS_MODEL_DIR_OCRDB = "ocrdb";
    public static final String ASSETS_MODEL_MOIRE_DETECTOR = "moire";
    public static final String AUTHORITY = "com.samsung.android.sdk.ocr.resourcemanager";
    public static final String COMMON_LANGUAGE = "language";
    public static final String COMMON_PRELOADED = "preloaded";
    public static final String COMMON_VERSION = "version";
    public static final String DBNAME_EXTENSION = ".dat";
    public static final String TFLITE_EXTENSION = ".tflite";
    public static final String URI_PATH_INSTALLED_LANGUAGES = "installed_languages";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InstalledLanguages {
        public static final Uri CONTENT_URI = Uri.parse("content://com.samsung.android.sdk.ocr.resourcemanager/installed_languages");
        public static final String LANGUAGE = "language";
        public static final String VERSION = "version";
    }
}
