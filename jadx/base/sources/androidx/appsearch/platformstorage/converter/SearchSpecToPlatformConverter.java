package androidx.appsearch.platformstorage.converter;

import android.annotation.SuppressLint;
import android.app.appsearch.SearchSpec;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.app.JoinSpec;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SearchSpecToPlatformConverter {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(34)
    public static class ApiHelperForU {
        private ApiHelperForU() {
        }

        @DoNotInline
        public static void copyEnabledFeatures(SearchSpec.Builder builder, androidx.appsearch.app.SearchSpec searchSpec) {
            if (searchSpec.isNumericSearchEnabled()) {
                builder.setNumericSearchEnabled(true);
            }
            if (searchSpec.isVerbatimSearchEnabled()) {
                builder.setVerbatimSearchEnabled(true);
            }
            if (searchSpec.isListFilterQueryLanguageEnabled()) {
                builder.setListFilterQueryLanguageEnabled(true);
            }
        }

        @DoNotInline
        public static void setJoinSpec(SearchSpec.Builder builder, JoinSpec joinSpec) {
            builder.setJoinSpec(JoinSpecToPlatformConverter.toPlatformJoinSpec(joinSpec));
        }

        @DoNotInline
        public static void setPropertyWeights(SearchSpec.Builder builder, Map<String, Map<String, Double>> map) {
            for (Map.Entry<String, Map<String, Double>> entry : map.entrySet()) {
                builder.setPropertyWeights(entry.getKey(), entry.getValue());
            }
        }

        @DoNotInline
        public static void setRankingStrategy(SearchSpec.Builder builder, String str) {
            builder.setRankingStrategy(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(35)
    public static class ApiHelperForV {
        private ApiHelperForV() {
        }

        @DoNotInline
        public static void addFilterProperties(SearchSpec.Builder builder, Map<String, List<String>> map) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                builder.addFilterProperties(entry.getKey(), entry.getValue());
            }
        }

        @DoNotInline
        public static void copyEnabledFeatures(SearchSpec.Builder builder, androidx.appsearch.app.SearchSpec searchSpec) {
            if (searchSpec.isListFilterHasPropertyFunctionEnabled()) {
                builder.setListFilterHasPropertyFunctionEnabled(true);
            }
        }

        @DoNotInline
        public static void setSearchSourceLogTag(SearchSpec.Builder builder, String str) {
            builder.setSearchSourceLogTag(str);
        }
    }

    private SearchSpecToPlatformConverter() {
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    @SuppressLint({"WrongConstant"})
    public static SearchSpec toPlatformSearchSpec(androidx.appsearch.app.SearchSpec searchSpec) {
        Preconditions.checkNotNull(searchSpec);
        SearchSpec.Builder builderM995c = AbstractC0568e.m995c();
        if (searchSpec.getAdvancedRankingExpression().isEmpty()) {
            builderM995c.setRankingStrategy(searchSpec.getRankingStrategy());
        } else {
            if (Build.VERSION.SDK_INT < 34) {
                throw new UnsupportedOperationException("SEARCH_SPEC_ADVANCED_RANKING_EXPRESSION is not available on this AppSearch implementation.");
            }
            ApiHelperForU.setRankingStrategy(builderM995c, searchSpec.getAdvancedRankingExpression());
        }
        builderM995c.setTermMatch(searchSpec.getTermMatch()).addFilterSchemas(searchSpec.getFilterSchemas()).addFilterNamespaces(searchSpec.getFilterNamespaces()).addFilterPackageNames(searchSpec.getFilterPackageNames()).setResultCountPerPage(searchSpec.getResultCountPerPage()).setOrder(searchSpec.getOrder()).setSnippetCount(searchSpec.getSnippetCount()).setSnippetCountPerProperty(searchSpec.getSnippetCountPerProperty()).setMaxSnippetSize(searchSpec.getMaxSnippetSize());
        if (searchSpec.getResultGroupingTypeFlags() != 0) {
            if ((searchSpec.getResultGroupingTypeFlags() & 4) != 0 && Build.VERSION.SDK_INT < 35) {
                throw new UnsupportedOperationException("SEARCH_SPEC_GROUPING_TYPE_PER_SCHEMA is not available on this AppSearch implementation.");
            }
            builderM995c.setResultGrouping(searchSpec.getResultGroupingTypeFlags(), searchSpec.getResultGroupingLimit());
        }
        for (Map.Entry<String, List<String>> entry : searchSpec.getProjections().entrySet()) {
            builderM995c.addProjection(entry.getKey(), entry.getValue());
        }
        if (!searchSpec.getPropertyWeights().isEmpty()) {
            if (Build.VERSION.SDK_INT < 34) {
                throw new UnsupportedOperationException("Property weights are not supported with this backend/Android API level combination.");
            }
            ApiHelperForU.setPropertyWeights(builderM995c, searchSpec.getPropertyWeights());
        }
        if (!searchSpec.getEnabledFeatures().isEmpty()) {
            if (searchSpec.isNumericSearchEnabled() || searchSpec.isVerbatimSearchEnabled() || searchSpec.isListFilterQueryLanguageEnabled()) {
                if (Build.VERSION.SDK_INT < 34) {
                    throw new UnsupportedOperationException("Advanced query features (NUMERIC_SEARCH, VERBATIM_SEARCH and LIST_FILTER_QUERY_LANGUAGE) are not supported with this backend/Android API level combination.");
                }
                ApiHelperForU.copyEnabledFeatures(builderM995c, searchSpec);
            }
            if (searchSpec.isListFilterHasPropertyFunctionEnabled()) {
                if (Build.VERSION.SDK_INT < 35) {
                    throw new UnsupportedOperationException("LIST_FILTER_HAS_PROPERTY_FUNCTION is not available on this AppSearch implementation.");
                }
                ApiHelperForV.copyEnabledFeatures(builderM995c, searchSpec);
            }
            if (searchSpec.isListFilterMatchScoreExpressionFunctionEnabled()) {
                throw new UnsupportedOperationException("LIST_FILTER_MATCH_SCORE_EXPRESSION_FUNCTION is not available on this AppSearch implementation.");
            }
        }
        if (!searchSpec.getEmbeddingParameters().isEmpty()) {
            throw new UnsupportedOperationException("SCHEMA_EMBEDDING_PROPERTY_CONFIG is not available on this AppSearch implementation.");
        }
        if (!searchSpec.getSearchStringParameters().isEmpty()) {
            throw new UnsupportedOperationException("SEARCH_SPEC_SEARCH_STRING_PARAMETERS is not available on this AppSearch implementation.");
        }
        if (searchSpec.getJoinSpec() != null) {
            if (Build.VERSION.SDK_INT < 34) {
                throw new UnsupportedOperationException("JoinSpec is not available on this AppSearch implementation.");
            }
            ApiHelperForU.setJoinSpec(builderM995c, searchSpec.getJoinSpec());
        }
        if (!searchSpec.getFilterProperties().isEmpty()) {
            if (Build.VERSION.SDK_INT < 35) {
                throw new UnsupportedOperationException("SEARCH_SPEC_ADD_FILTER_PROPERTIES is not available on this AppSearch implementation.");
            }
            ApiHelperForV.addFilterProperties(builderM995c, searchSpec.getFilterProperties());
        }
        if (searchSpec.getSearchSourceLogTag() != null) {
            if (Build.VERSION.SDK_INT < 35) {
                throw new UnsupportedOperationException("SEARCH_SPEC_SET_SEARCH_SOURCE_LOG_TAG is not available on this AppSearch implementation.");
            }
            ApiHelperForV.setSearchSourceLogTag(builderM995c, searchSpec.getSearchSourceLogTag());
        }
        if (!searchSpec.getInformationalRankingExpressions().isEmpty()) {
            throw new UnsupportedOperationException("SEARCH_SPEC_ADD_INFORMATIONAL_RANKING_EXPRESSIONS are not available on this AppSearch implementation.");
        }
        if (!searchSpec.getFilterDocumentIds().isEmpty()) {
            throw new UnsupportedOperationException("SEARCH_SPEC_ADD_FILTER_DOCUMENT_IDS is not available on this AppSearch implementation.");
        }
        if (searchSpec.isScorablePropertyRankingEnabled()) {
            throw new UnsupportedOperationException("SCHEMA_SCORABLE_PROPERTY_CONFIG is not available on this AppSearch implementation.");
        }
        return builderM995c.build();
    }
}
