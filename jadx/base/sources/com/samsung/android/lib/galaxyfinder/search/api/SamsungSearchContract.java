package com.samsung.android.lib.galaxyfinder.search.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/SamsungSearchContract;", "", "Companion", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface SamsungSearchContract {

    @NotNull
    public static final String API_VERSION = "2.1.7";

    @NotNull
    public static final String CALL_METHOD_GET_INFO = "getInfo";

    @NotNull
    public static final String COLUMN_COUNT = "count";

    @NotNull
    public static final String COLUMN_RESULT = "result";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String KEY_API_VERSION = "api_version";

    @NotNull
    public static final String KEY_ICON = "icon";

    @NotNull
    public static final String KEY_IN_APP_SEARCH = "inAppSearchActivity";

    @NotNull
    public static final String KEY_LABEL = "label";

    @NotNull
    public static final String KEY_LAUNCH_INTENT = "launchIntent";

    @NotNull
    public static final String KEY_LEGACY_SEARCH = "legacySearchActivity";

    @NotNull
    public static final String KEY_PROVIDER_KEY = "module_key";

    @NotNull
    public static final String PROVIDER_SEARCH_INTERFACE = "com.samsung.android.search.intent.ACTION_CONTENT_SEARCH";

    @NotNull
    public static final String PROVIDER_TAG_INTERFACE = "com.samsung.android.search.intent.ACTION_TAG_SEARCH";

    @NotNull
    public static final String SEARCH_DATA = "search";

    @NotNull
    public static final String SEARCH_DATA_PATH = "v1/search";

    @NotNull
    public static final String SEARCH_KEY_LIMIT = "limit";

    @NotNull
    public static final String SEARCH_KEY_QUERY = "query";

    @NotNull
    public static final String SEARCH_KEY_REQ_ID = "requestId";

    @NotNull
    public static final String SEARCH_MIME_TYPE = "vnd.android.cursor.dir/vnd.search";

    @NotNull
    public static final String SUGGESTION_DATA = "suggestion";

    @NotNull
    public static final String TAG_DATA = "tag";

    @NotNull
    public static final String VERSION_1 = "v1";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/SamsungSearchContract$Companion;", "", "()V", "API_VERSION", "", "CALL_METHOD_GET_INFO", "COLUMN_COUNT", "COLUMN_RESULT", "KEY_API_VERSION", "KEY_ICON", "KEY_IN_APP_SEARCH", "KEY_LABEL", "KEY_LAUNCH_INTENT", "KEY_LEGACY_SEARCH", "KEY_PROVIDER_KEY", "PROVIDER_SEARCH_INTERFACE", "PROVIDER_TAG_INTERFACE", "SEARCH_DATA", "SEARCH_DATA_PATH", "SEARCH_KEY_LIMIT", "SEARCH_KEY_QUERY", "SEARCH_KEY_REQ_ID", "SEARCH_MIME_TYPE", "SUGGESTION_DATA", "TAG_DATA", "VERSION_1", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String API_VERSION = "2.1.7";

        @NotNull
        public static final String CALL_METHOD_GET_INFO = "getInfo";

        @NotNull
        public static final String COLUMN_COUNT = "count";

        @NotNull
        public static final String COLUMN_RESULT = "result";

        @NotNull
        public static final String KEY_API_VERSION = "api_version";

        @NotNull
        public static final String KEY_ICON = "icon";

        @NotNull
        public static final String KEY_IN_APP_SEARCH = "inAppSearchActivity";

        @NotNull
        public static final String KEY_LABEL = "label";

        @NotNull
        public static final String KEY_LAUNCH_INTENT = "launchIntent";

        @NotNull
        public static final String KEY_LEGACY_SEARCH = "legacySearchActivity";

        @NotNull
        public static final String KEY_PROVIDER_KEY = "module_key";

        @NotNull
        public static final String PROVIDER_SEARCH_INTERFACE = "com.samsung.android.search.intent.ACTION_CONTENT_SEARCH";

        @NotNull
        public static final String PROVIDER_TAG_INTERFACE = "com.samsung.android.search.intent.ACTION_TAG_SEARCH";

        @NotNull
        public static final String SEARCH_DATA = "search";

        @NotNull
        public static final String SEARCH_DATA_PATH = "v1/search";

        @NotNull
        public static final String SEARCH_KEY_LIMIT = "limit";

        @NotNull
        public static final String SEARCH_KEY_QUERY = "query";

        @NotNull
        public static final String SEARCH_KEY_REQ_ID = "requestId";

        @NotNull
        public static final String SEARCH_MIME_TYPE = "vnd.android.cursor.dir/vnd.search";

        @NotNull
        public static final String SUGGESTION_DATA = "suggestion";

        @NotNull
        public static final String TAG_DATA = "tag";

        @NotNull
        public static final String VERSION_1 = "v1";

        private Companion() {
        }
    }
}
