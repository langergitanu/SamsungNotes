package androidx.appsearch.platformstorage;

import android.content.Context;
import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.annotation.OptIn;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.app.Features;
import androidx.appsearch.platformstorage.util.AppSearchVersionUtil;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
final class FeaturesImpl implements Features {
    private final Context mContext;

    public FeaturesImpl(Context context) {
        this.mContext = (Context) Preconditions.checkNotNull(context);
    }

    @Override // androidx.appsearch.app.Features
    public int getMaxIndexedProperties() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            return 64;
        }
        return (i != 33 || AppSearchVersionUtil.getAppSearchVersionCode(this.mContext) < AppSearchVersionUtil.MainlineVersions.U_BASE) ? 16 : 64;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017a A[RETURN] */
    @Override // androidx.appsearch.app.Features
    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isFeatureSupported(String str) {
        int extensionVersion;
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            extensionVersion = SdkExtensions.getExtensionVersion(33);
            str.getClass();
            switch (str) {
                case "GLOBAL_SEARCH_SESSION_GET_SCHEMA":
                case "ADD_PERMISSIONS_AND_GET_VISIBILITY":
                case "GLOBAL_SEARCH_SESSION_REGISTER_OBSERVER_CALLBACK":
                case "SEARCH_RESULT_MATCH_INFO_SUBMATCH":
                case "GLOBAL_SEARCH_SESSION_GET_BY_ID":
                    if (i >= 33) {
                        return true;
                    }
                    break;
                case "SEARCH_SPEC_SET_SEARCH_SOURCE_LOG_TAG":
                case "ENTERPRISE_GLOBAL_SEARCH_SESSION":
                case "SCHEMA_ADD_PARENT_TYPE":
                case "SEARCH_SPEC_GROUPING_TYPE_PER_SCHEMA":
                case "SET_SCHEMA_REQUEST_ADD_SCHEMA_TYPE_VISIBLE_TO_CONFIG":
                case "SCHEMA_ADD_INDEXABLE_NESTED_PROPERTIES":
                case "LIST_FILTER_HAS_PROPERTY_FUNCTION":
                case "SEARCH_SPEC_ADD_FILTER_PROPERTIES":
                case "SET_SCHEMA_REQUEST_SET_PUBLICLY_VISIBLE":
                    if (i >= 35) {
                    }
                    break;
                case "SEARCH_SPEC_ADVANCED_RANKING_EXPRESSION":
                case "JOIN_SPEC_AND_QUALIFIED_ID":
                case "TOKENIZER_TYPE_RFC822":
                case "LIST_FILTER_QUERY_LANGUAGE":
                case "VERBATIM_SEARCH":
                case "SEARCH_SPEC_PROPERTY_WEIGHTS":
                case "SEARCH_SUGGESTION":
                case "NUMERIC_SEARCH":
                    if (i >= 34 || extensionVersion >= 7) {
                    }
                    break;
                case "SET_SCHEMA_CIRCULAR_REFERENCES":
                    if (i >= 34) {
                    }
                    break;
                case "INDEXER_MOBILE_APPLICATIONS":
                    if (i > 35 || AppSearchVersionUtil.getAppSearchVersionCode(this.mContext) >= AppSearchVersionUtil.MainlineVersions.M2024_11) {
                    }
                    break;
            }
        }
        return false;
    }
}
