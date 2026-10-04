package androidx.appsearch.builtintypes;

import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.app.SearchSpec;
import androidx.core.util.Preconditions;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.sdk.mobileservice.social.buddy.request.TargetAppListRequest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAppSearchApi
public class BuiltInCorpusFilters {
    private BuiltInCorpusFilters() {
    }

    public static SearchSpec.Builder searchMobileApplicationCorpus(SearchSpec.Builder builder) {
        return ((SearchSpec.Builder) Preconditions.checkNotNull(builder)).addFilterPackageNames(TelemetryEventStrings.C6439Os.OS_NAME).addFilterNamespaces(TargetAppListRequest.BundleKey.APPS);
    }

    public static SearchSpec.Builder searchPersonCorpus(SearchSpec.Builder builder) {
        return ((SearchSpec.Builder) Preconditions.checkNotNull(builder)).addFilterPackageNames(TelemetryEventStrings.C6439Os.OS_NAME).addFilterSchemas(C$$__AppSearch__Person.SCHEMA_NAME);
    }
}
