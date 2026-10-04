package androidx.appsearch.ast.query;

import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.app.PropertyPath;
import androidx.appsearch.ast.FunctionNode;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_ABSTRACT_SYNTAX_TREES)
public final class PropertyDefinedNode implements FunctionNode {
    private PropertyPath mProperty;

    public PropertyDefinedNode(PropertyPath propertyPath) {
        this.mProperty = (PropertyPath) Preconditions.checkNotNull(propertyPath);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PropertyDefinedNode.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.mProperty, ((PropertyDefinedNode) obj).mProperty);
    }

    @Override // androidx.appsearch.ast.FunctionNode
    public String getFunctionName() {
        return FunctionNode.FUNCTION_NAME_PROPERTY_DEFINED;
    }

    public PropertyPath getProperty() {
        return this.mProperty;
    }

    public int hashCode() {
        return Objects.hashCode(this.mProperty);
    }

    public void setProperty(PropertyPath propertyPath) {
        this.mProperty = (PropertyPath) Preconditions.checkNotNull(propertyPath);
    }

    public String toString() {
        return "propertyDefined(\"" + this.mProperty + "\")";
    }
}
