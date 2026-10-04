package com.samsung.android.settings.search.provider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SecSearchIndexablesContract extends SearchIndexablesContract {
    public static final int AVAILABLE = 0;
    public static final int SEC_COLUMN_SITEMAP_CHILD_CLASS = 2;
    public static final int SEC_COLUMN_SITEMAP_CHILD_TITLE = 3;
    public static final int SEC_COLUMN_SITEMAP_PARENT_CLASS = 0;
    public static final int SEC_COLUMN_SITEMAP_PARENT_TITLE = 1;
    public static final String SEC_EXTRA_KEY_AVAILABILITY = "availability";
    public static final String SEC_EXTRA_KEY_CLASS_NAME = "class_name";
    public static final String SEC_EXTRA_KEY_DESKTOP_MODE_ENABLED = "desktopModeEnabled";
    public static final String SEC_EXTRA_KEY_PREFERENCE_KEY = "preference_key";
    public static final String SEC_EXTRA_KEY_REQUIRING_CONFIG_INFO = "requiringConfigInfo";
    public static final String SEC_NON_INDEXABLES_KEYS = "sec_non_indexables_key";
    public static final String SEC_NON_INDEXABLES_KEYS_PATH = "sec_settings/sec_non_indexables_key";
    private static final String SEC_SETTINGS = "sec_settings";
    public static final String SEC_VARIABLE_RAW_DATA = "sec_variable_raw_data";
    public static final String SEC_VARIABLE_RAW_DATA_PATH = "sec_settings/sec_variable_raw_data";
    public static final int UNAVAILABLE = 1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ExtraInfo {
        public static final int DESKTOP_MODE_DEFAULT = -1;
        public static final String EXTRA_KEY_DEX_MODE = "isDexMode";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SecNonIndexableKey {
        public static final String MIME_TYPE = "vnd.android.cursor.dir/sec_non_indexables_key";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SecRawData {
        public static final String MIME_TYPE = "vnd.android.cursor.dir/sec_variable_raw_data";
    }
}
