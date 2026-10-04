package androidx.appsearch.platformstorage.converter;

import android.annotation.SuppressLint;
import android.app.appsearch.SearchSuggestionSpec;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.platformstorage.AbstractC0575j;
import androidx.core.util.Preconditions;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(34)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SearchSuggestionSpecToPlatformConverter {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(35)
    public static class ApiHelperForV {
        private ApiHelperForV() {
        }

        @DoNotInline
        public static void addFilterProperties(SearchSuggestionSpec.Builder builder, String str, Collection<String> collection) {
            builder.addFilterProperties(str, collection);
        }
    }

    private SearchSuggestionSpecToPlatformConverter() {
    }

    @SuppressLint({"WrongConstant"})
    public static SearchSuggestionSpec toPlatformSearchSuggestionSpec(androidx.appsearch.app.SearchSuggestionSpec searchSuggestionSpec) {
        Preconditions.checkNotNull(searchSuggestionSpec);
        AbstractC0575j.m1079A();
        SearchSuggestionSpec.Builder builderM1090h = AbstractC0575j.m1090h(searchSuggestionSpec.getMaximumResultCount());
        builderM1090h.addFilterNamespaces(searchSuggestionSpec.getFilterNamespaces()).addFilterSchemas(searchSuggestionSpec.getFilterSchemas()).setRankingStrategy(searchSuggestionSpec.getRankingStrategy());
        for (Map.Entry<String, List<String>> entry : searchSuggestionSpec.getFilterDocumentIds().entrySet()) {
            builderM1090h.addFilterDocumentIds(entry.getKey(), (Collection<String>) entry.getValue());
        }
        Map<String, List<String>> filterProperties = searchSuggestionSpec.getFilterProperties();
        if (!filterProperties.isEmpty()) {
            if (Build.VERSION.SDK_INT < 35) {
                throw new UnsupportedOperationException("SEARCH_SPEC_ADD_FILTER_PROPERTIES is not available on this AppSearch implementation.");
            }
            for (Map.Entry<String, List<String>> entry2 : filterProperties.entrySet()) {
                ApiHelperForV.addFilterProperties(builderM1090h, entry2.getKey(), entry2.getValue());
            }
        }
        if (searchSuggestionSpec.getSearchStringParameters().isEmpty()) {
            return builderM1090h.build();
        }
        throw new UnsupportedOperationException("SEARCH_SPEC_SEARCH_STRING_PARAMETERS is not available on this AppSearch implementation.");
    }
}
