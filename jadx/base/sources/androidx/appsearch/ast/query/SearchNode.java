package androidx.appsearch.ast.query;

import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.app.PropertyPath;
import androidx.appsearch.ast.FunctionNode;
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
public final class SearchNode implements FunctionNode {
    private final List<Node> mChildren;
    private final List<PropertyPath> mProperties;

    public SearchNode(Node node, List<PropertyPath> list) {
        this.mChildren = new ArrayList(1);
        Preconditions.checkNotNull(node);
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            Preconditions.checkNotNull(list.get(i));
        }
        this.mChildren.add(node);
        this.mProperties = new ArrayList(list);
    }

    private String escapeQuery(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\"' || str.charAt(i) == '\\') {
                sb.append('\\');
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public void addProperty(PropertyPath propertyPath) {
        this.mProperties.add((PropertyPath) Preconditions.checkNotNull(propertyPath));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SearchNode.class == obj.getClass()) {
            SearchNode searchNode = (SearchNode) obj;
            if (Objects.equals(this.mChildren, searchNode.mChildren) && Objects.equals(this.mProperties, searchNode.mProperties)) {
                return true;
            }
        }
        return false;
    }

    public Node getChild() {
        return this.mChildren.get(0);
    }

    @Override // androidx.appsearch.ast.Node
    public List<Node> getChildren() {
        return Collections.unmodifiableList(this.mChildren);
    }

    @Override // androidx.appsearch.ast.FunctionNode
    public String getFunctionName() {
        return "search";
    }

    public List<PropertyPath> getProperties() {
        return Collections.unmodifiableList(this.mProperties);
    }

    public int hashCode() {
        return Objects.hash(this.mChildren, this.mProperties);
    }

    public void setChild(Node node) {
        this.mChildren.set(0, (Node) Preconditions.checkNotNull(node));
    }

    public void setProperties(List<PropertyPath> list) {
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            Preconditions.checkNotNull(list.get(i));
        }
        this.mProperties.clear();
        this.mProperties.addAll(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("search(\"");
        sb.append(escapeQuery(getChild().toString()));
        sb.append("\"");
        if (!this.mProperties.isEmpty()) {
            sb.append(", createList(");
            for (int i = 0; i < this.mProperties.size() - 1; i++) {
                sb.append("\"");
                sb.append(this.mProperties.get(i));
                sb.append("\", ");
            }
            sb.append("\"");
            sb.append(this.mProperties.get(r1.size() - 1));
            sb.append("\")");
        }
        sb.append(")");
        return sb.toString();
    }

    public SearchNode(Node node) {
        this(node, Collections.EMPTY_LIST);
    }
}
