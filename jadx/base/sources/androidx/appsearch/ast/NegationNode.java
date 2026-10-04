package androidx.appsearch.ast;

import androidx.appsearch.app.ExperimentalAppSearchApi;
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
public final class NegationNode implements Node {
    private final List<Node> mChildren;

    public NegationNode(Node node) {
        ArrayList arrayList = new ArrayList(1);
        this.mChildren = arrayList;
        arrayList.add((Node) Preconditions.checkNotNull(node));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NegationNode.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.mChildren, ((NegationNode) obj).mChildren);
    }

    public Node getChild() {
        return this.mChildren.get(0);
    }

    @Override // androidx.appsearch.ast.Node
    public List<Node> getChildren() {
        return Collections.unmodifiableList(this.mChildren);
    }

    public int hashCode() {
        return Objects.hashCode(this.mChildren);
    }

    public void setChild(Node node) {
        this.mChildren.set(0, (Node) Preconditions.checkNotNull(node));
    }

    public String toString() {
        return "NOT " + getChild();
    }
}
