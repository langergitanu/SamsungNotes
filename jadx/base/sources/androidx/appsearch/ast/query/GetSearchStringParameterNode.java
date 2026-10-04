package androidx.appsearch.ast.query;

import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.ast.FunctionNode;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.core.util.Preconditions;
import androidx.glance.AbstractC2821a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_ABSTRACT_SYNTAX_TREES)
public final class GetSearchStringParameterNode implements FunctionNode {
    private int mSearchStringIndex;

    public GetSearchStringParameterNode(int i) {
        Preconditions.checkArgument(i >= 0, "SearchStringIndex must be non-negative.");
        this.mSearchStringIndex = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && GetSearchStringParameterNode.class == obj.getClass() && this.mSearchStringIndex == ((GetSearchStringParameterNode) obj).mSearchStringIndex;
    }

    @Override // androidx.appsearch.ast.FunctionNode
    public String getFunctionName() {
        return FunctionNode.FUNCTION_NAME_GET_SEARCH_STRING_PARAMETER;
    }

    public int getSearchStringIndex() {
        return this.mSearchStringIndex;
    }

    public int hashCode() {
        return Integer.hashCode(this.mSearchStringIndex);
    }

    public void setSearchStringIndex(int i) {
        Preconditions.checkArgument(i >= 0, "SearchStringIndex must be non-negative.");
        this.mSearchStringIndex = i;
    }

    public String toString() {
        return AbstractC2821a.m2223n(new StringBuilder("getSearchStringParameter("), ")", this.mSearchStringIndex);
    }
}
