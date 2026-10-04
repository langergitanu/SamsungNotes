package com.samsung.android.sdk.handwriting.resources.impl.api;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HWRResourceManagerContract {
    public static final String AUTHORITY = "com.samsung.android.sdk.handwriting.resourcemanager";
    public static final String PATH_LANG = "lang";
    public static final String PATH_LATEST = "latest";
    public static final String PATH_MD5 = "md5";
    public static final String PATH_MODE = "mode";
    public static final String PATH_PRELOADED = "preloaded";
    public static final String PATH_RESOURCE = "resource";
    public static final String PATH_VERSION = "version";
    public static final String RM_PERMISSION = "com.samsung.android.sdk.handwriting.permission.RESOURCE_LANGUAGE_UPDATE";
    public static final String RM_PERMISSION_COMMAND = "com.samsung.android.sdk.handwriting.permission.RESOURCE_LANGUAGE_UPDATE_COMMAND";
    public static final String RM_RESOURCE_LIST_KEY = "resList";
    public static final String RM_ROOT_DIR_NAME = "HWRDB";
    public static final String URI_PATH_DOWNLOADING = "downloading";
    public static final String URI_PATH_LANGS = "langs";
    public static final String URI_PATH_REFRESH = "refresh";
    public static final String URI_PATH_UPDATES = "updates";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Downloading {
        public static final Uri CONTENT_URI = Uri.parse("content://com.samsung.android.sdk.handwriting.resourcemanager/downloading");
        public static final String LANG = "lang";
        public static final String VERSION = "version";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Langs {
        public static final Uri CONTENT_URI = Uri.parse("content://com.samsung.android.sdk.handwriting.resourcemanager/langs");
        public static final String LANG = "lang";
        public static final String LATEST = "latest";
        public static final String PRELOADED = "preloaded";
        public static final String VERSION = "version";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Mode {
        public static final String MODE = "mode";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Refresh {
        public static final Uri CONTENT_URI = Uri.parse("content://com.samsung.android.sdk.handwriting.resourcemanager/refresh");
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Resource {
        public static final String MD5 = "md5";
        public static final String PRELOADED = "preloaded";
        public static final String RESOURCE = "resource";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Updates {
        public static final Uri CONTENT_URI = Uri.parse("content://com.samsung.android.sdk.handwriting.resourcemanager/updates");
        public static final String LANG = "lang";
        public static final String VERSION = "version";
    }
}
