package com.samsung.android.support.senl.p148nt.data.common.constants;

import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SearchConstants {
    public static final int NO_LIMIT = 0;
    public static final int SEARCH_TEXT_MAX_LENGTH;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface ContentFilter {
        public static final int ALL = 0;
        public static final int TITLE = 1;
        public static final int VOICE_RECORDING = 2;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface Mode {
        public static final int BIXBY = 1;
        public static final int LATEST = 2;
        public static final int NORMAL = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface OldNote {
        public static final int EXCLUDE = 2;
        public static final int INCLUDE = 0;
        public static final int INCLUDE_AFTER_COLLECT = 1;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface SearchEngineResultType {
        public static final int KEYWORD_WITHOUT_QP = 1;
        public static final int KEYWORD_WITH_QP = 2;
        public static final int SEMANTIC = 3;
        public static final int UNKNOWN = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface Source {
        public static final int COMPOSER = 0;
        public static final int IMPORT = 1;
        public static final int NONE = -1;
        public static final int OTHERS = 4;
        public static final int SMART_SWITCH = 3;
        public static final int SYNC = 2;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface Strategy {
        public static final int COUNT_BASED = 4;
        public static final int DB_SEARCH = 1;
        public static final int NEXT_IF_EMPTY = 2;
        public static final int NONE = 0;
        public static final int SEMANTIC_SEARCH = 8;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface TargetContents {
        public static final String BODY_TEXT = "BODY_TEXT";
        public static final String COVER_SUMMARY = "COVER_SUMMARY";
        public static final String STROKE = "STROKE";
        public static final String STT_CONTENT = "STT_CONTENT";
        public static final String TAG = "TAG";
        public static final String TITLE = "TITLE";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface TimeFilter {
        public static final int NOT_DEFINE = -1;
        public static final int PAST_30_DAYS = 2;
        public static final int PAST_SEVEN_DAYS = 1;
        public static final int YESTERDAY = 0;
    }

    static {
        SEARCH_TEXT_MAX_LENGTH = SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 80500 ? 350000 : 30000;
    }

    public static boolean isValidTimeCondition(long j, long j2) {
        if (j > 0 || j2 > 0) {
            return j2 <= 0 || j2 >= j;
        }
        return false;
    }
}
