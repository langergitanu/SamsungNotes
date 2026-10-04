package androidx.appsearch.flags;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Flags {
    public static final String FLAG_ENABLE_ABSTRACT_SYNTAX_TREES = "com.android.appsearch.flags.enable_abstract_syntax_trees";
    public static final String FLAG_ENABLE_ADDITIONAL_BUILDER_COPY_CONSTRUCTORS = "com.android.appsearch.flags.enable_additional_builder_copy_constructors";
    public static final String FLAG_ENABLE_APP_FUNCTIONS = "com.android.appsearch.flags.enable_app_functions";
    public static final String FLAG_ENABLE_BLOB_STORE = "com.android.appsearch.flags.enable_blob_store";
    public static final String FLAG_ENABLE_DELETE_PROPAGATION_TYPE = "com.android.appsearch.flags.enable_delete_propagation_type";
    public static final String FLAG_ENABLE_ENTERPRISE_EMPTY_BATCH_RESULT_FIX = "com.android.appsearch.flags.enable_enterprise_empty_batch_result_fix";
    public static final String FLAG_ENABLE_ENTERPRISE_GLOBAL_SEARCH_SESSION = "com.android.appsearch.flags.enable_enterprise_global_search_session";
    public static final String FLAG_ENABLE_GENERIC_DOCUMENT_BUILDER_HIDDEN_METHODS = "com.android.appsearch.flags.enable_generic_document_builder_hidden_methods";
    public static final String FLAG_ENABLE_GENERIC_DOCUMENT_COPY_CONSTRUCTOR = "com.android.appsearch.flags.enable_generic_document_copy_constructor";
    public static final String FLAG_ENABLE_GENERIC_DOCUMENT_OVER_IPC = "com.android.appsearch.flags.enable_generic_document_over_ipc";
    public static final String FLAG_ENABLE_GET_PARENT_TYPES_AND_INDEXABLE_NESTED_PROPERTIES = "com.android.appsearch.flags.enable_get_parent_types_and_indexable_nested_properties";
    public static final String FLAG_ENABLE_GROUPING_TYPE_PER_SCHEMA = "com.android.appsearch.flags.enable_grouping_type_per_schema";
    public static final String FLAG_ENABLE_INFORMATIONAL_RANKING_EXPRESSIONS = "com.android.appsearch.flags.enable_informational_ranking_expressions";
    public static final String FLAG_ENABLE_LIST_FILTER_HAS_PROPERTY_FUNCTION = "com.android.appsearch.flags.enable_list_filter_has_property_function";
    public static final String FLAG_ENABLE_LIST_FILTER_MATCH_SCORE_EXPRESSION_FUNCTION = "com.android.appsearch.flags.enable_list_filter_match_score_expression_function";
    public static final String FLAG_ENABLE_PUT_DOCUMENTS_REQUEST_ADD_TAKEN_ACTIONS = "com.android.appsearch.flags.enable_put_documents_request_add_taken_actions";
    public static final String FLAG_ENABLE_RESULT_ALREADY_EXISTS = "com.android.appsearch.flags.enable_result_already_exists";
    public static final String FLAG_ENABLE_RESULT_DENIED_AND_RESULT_RATE_LIMITED = "com.android.appsearch.flags.enable_result_denied_and_result_rate_limited";
    public static final String FLAG_ENABLE_SAFE_PARCELABLE_2 = "com.android.appsearch.flags.enable_safe_parcelable_2";
    public static final String FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG = "com.android.appsearch.flags.enable_schema_embedding_property_config";
    public static final String FLAG_ENABLE_SCHEMA_EMBEDDING_QUANTIZATION = "com.android.appsearch.flags.enable_schema_embedding_quantization";
    public static final String FLAG_ENABLE_SCORABLE_PROPERTY = "com.android.appsearch.flags.enable_scorable_property";
    public static final String FLAG_ENABLE_SEARCH_RESULT_PARENT_TYPES = "com.android.appsearch.flags.enable_search_result_parent_types";
    public static final String FLAG_ENABLE_SEARCH_SPEC_FILTER_DOCUMENT_IDS = "com.android.appsearch.flags.enable_search_spec_filter_document_ids";
    public static final String FLAG_ENABLE_SEARCH_SPEC_FILTER_PROPERTIES = "com.android.appsearch.flags.enable_search_spec_filter_properties";
    public static final String FLAG_ENABLE_SEARCH_SPEC_SEARCH_STRING_PARAMETERS = "com.android.appsearch.flags.enable_search_spec_search_string_parameters";
    public static final String FLAG_ENABLE_SEARCH_SPEC_SET_SEARCH_SOURCE_LOG_TAG = "com.android.appsearch.flags.enable_search_spec_set_search_source_log_tag";
    public static final String FLAG_ENABLE_SET_PUBLICLY_VISIBLE_SCHEMA = "com.android.appsearch.flags.enable_set_publicly_visible_schema";
    public static final String FLAG_ENABLE_SET_SCHEMA_VISIBLE_TO_CONFIGS = "com.android.appsearch.flags.enable_set_schema_visible_to_configs";
    private static final String FLAG_PREFIX = "com.android.appsearch.flags.";

    private Flags() {
    }

    public static boolean enableAbstractSyntaxTrees() {
        return true;
    }

    public static boolean enableAdditionalBuilderCopyConstructors() {
        return true;
    }

    public static boolean enableBlobStore() {
        return true;
    }

    public static boolean enableDeletePropagationType() {
        return true;
    }

    public static boolean enableDocumentLimiterReplaceTracking() {
        return true;
    }

    public static boolean enableEnterpriseEmptyBatchResultFix() {
        return true;
    }

    public static boolean enableEnterpriseGlobalSearchSession() {
        return true;
    }

    public static boolean enableGenericDocumentBuilderHiddenMethods() {
        return true;
    }

    public static boolean enableGenericDocumentCopyConstructor() {
        return true;
    }

    public static boolean enableGetParentTypesAndIndexableNestedProperties() {
        return true;
    }

    public static boolean enableGroupingTypePerSchema() {
        return true;
    }

    public static boolean enableInformationalRankingExpressions() {
        return true;
    }

    public static boolean enableListFilterHasPropertyFunction() {
        return true;
    }

    public static boolean enableListFilterMatchScoreExpressionFunction() {
        return true;
    }

    public static boolean enablePutDocumentsRequestAddTakenActions() {
        return true;
    }

    public static boolean enableResultAlreadyExists() {
        return true;
    }

    public static boolean enableResultDeniedAndResultRateLimited() {
        return true;
    }

    public static boolean enableSafeParcelable() {
        return true;
    }

    public static boolean enableSchemaEmbeddingPropertyConfig() {
        return true;
    }

    public static boolean enableSchemaEmbeddingQuantization() {
        return true;
    }

    public static boolean enableScorableProperty() {
        return true;
    }

    public static boolean enableSearchResultParentTypes() {
        return true;
    }

    public static boolean enableSearchSpecFilterDocumentIds() {
        return true;
    }

    public static boolean enableSearchSpecFilterProperties() {
        return true;
    }

    public static boolean enableSearchSpecSearchStringParameters() {
        return true;
    }

    public static boolean enableSearchSpecSetSearchSourceLogTag() {
        return true;
    }

    public static boolean enableSetPubliclyVisibleSchema() {
        return true;
    }

    public static boolean enableSetSchemaVisibleToConfigs() {
        return true;
    }
}
