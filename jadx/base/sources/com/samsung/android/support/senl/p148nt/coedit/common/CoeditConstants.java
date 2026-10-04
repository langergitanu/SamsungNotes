package com.samsung.android.support.senl.p148nt.coedit.common;

import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditConstants {
    public static final int COEDIT_CHECK_OBJECT_DURATION = 10000;
    public static final int COEDIT_MAX_OBJECT = 42000;
    public static final int COEDIT_MIN_OBJECT = 41500;
    public static final String GRPC_CORE_SERVER_PORT = "443";
    public static final String GRPC_OT_SERVER_PORT = "443";
    public static final String INITIAL_BODY_TEXT = "\n";
    public static final boolean INITIAL_BODY_TEXT_FEATURE = false;
    public static final int MAX_RELEASE_SECOND = 5;
    public static final int NETWORK_CHECK_DURATION = 1000;
    public static final int NUM_OF_COEDIT_THREAD_POOL_SIZE = 10;
    public static final int NUM_OF_EXTERNAL_SNAP_THREAD_POOL_SIZE = 1;
    public static final int NUM_OF_SNAP_THREAD_POOL_SIZE = 5;
    public static final int PAGE_WIDTH = 2160;
    public static final String STG_SERVER = "STG_SERVER";
    public static boolean IS_STG_SERVER = SharedPreferencesCompat.getInstance(CoeditCacheUtils.COEDIT_PREFERENCE).getBoolean(STG_SERVER, false);
    public static final String VALIDATION = "VALIDATION";
    public static boolean IS_VALIDATION = SharedPreferencesCompat.getInstance(CoeditCacheUtils.COEDIT_PREFERENCE).getBoolean(VALIDATION, true);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SnapResult {
        public static final int COEDIT_WITH_COMPOSER_RUNNING = 204;
        public static final int COPY_FAIL = 202;
        public static final int ERROR_LARGE_XML_SIZE = 205;
        public static final int ERROR_SAVE_AS_DIRECTORY = 206;
        public static final int IGNORE = 201;
        public static final int NETWORK_FAIL = 203;
        public static final int NONE = 200;
        public static final int SNAP_RESULT_BASE = 200;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum User {
        Internal,
        External,
        UpDownloader,
        DocumentService,
        Unknown
    }

    public static void toogleStgServer() {
        IS_STG_SERVER = !IS_STG_SERVER;
        SharedPreferencesCompat.getInstance(CoeditCacheUtils.COEDIT_PREFERENCE).putBoolean(STG_SERVER, IS_STG_SERVER);
    }

    public static void toogleValidation() {
        IS_VALIDATION = !IS_VALIDATION;
        SharedPreferencesCompat.getInstance(CoeditCacheUtils.COEDIT_PREFERENCE).putBoolean(VALIDATION, IS_VALIDATION);
    }
}
