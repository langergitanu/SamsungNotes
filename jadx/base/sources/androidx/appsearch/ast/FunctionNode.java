package androidx.appsearch.ast;

import androidx.annotation.RestrictTo;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_ABSTRACT_SYNTAX_TREES)
public interface FunctionNode extends Node {
    public static final String FUNCTION_NAME_GET_SEARCH_STRING_PARAMETER = "getSearchStringParameter";
    public static final String FUNCTION_NAME_HAS_PROPERTY = "hasProperty";
    public static final String FUNCTION_NAME_PROPERTY_DEFINED = "propertyDefined";
    public static final String FUNCTION_NAME_SEARCH = "search";
    public static final String FUNCTION_NAME_SEMANTIC_SEARCH = "semanticSearch";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface FunctionName {
    }

    String getFunctionName();
}
