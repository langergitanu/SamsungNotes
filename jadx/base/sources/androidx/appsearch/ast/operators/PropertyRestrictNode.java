package androidx.appsearch.ast.operators;

import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.app.PropertyPath;
import androidx.appsearch.ast.Node;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_ABSTRACT_SYNTAX_TREES)
public final class PropertyRestrictNode implements Node {
    private final List<Node> mChildren;
    private PropertyPath mProperty;

    public PropertyRestrictNode(PropertyPath propertyPath, Node node) {
        ArrayList arrayList = new ArrayList(1);
        this.mChildren = arrayList;
        this.mProperty = (PropertyPath) Preconditions.checkNotNull(propertyPath);
        arrayList.add((Node) Preconditions.checkNotNull(node));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PropertyRestrictNode)) {
            return false;
        }
        PropertyRestrictNode propertyRestrictNode = (PropertyRestrictNode) obj;
        return Objects.equals(this.mProperty, propertyRestrictNode.mProperty) && Objects.equals(this.mChildren, propertyRestrictNode.mChildren);
    }

    public Node getChild() {
        return this.mChildren.get(0);
    }

    @Override // androidx.appsearch.ast.Node
    public List<Node> getChildren() {
        return Collections.unmodifiableList(this.mChildren);
    }

    public PropertyPath getProperty() {
        return this.mProperty;
    }

    public int hashCode() {
        return Objects.hash(this.mProperty, this.mChildren);
    }

    public void setChild(Node node) {
        this.mChildren.set(0, (Node) Preconditions.checkNotNull(node));
    }

    public void setProperty(PropertyPath propertyPath) {
        this.mProperty = (PropertyPath) Preconditions.checkNotNull(propertyPath);
    }

    public String toString() {
        return "(" + this.mProperty + ":" + getChild() + ")";
    }
}
