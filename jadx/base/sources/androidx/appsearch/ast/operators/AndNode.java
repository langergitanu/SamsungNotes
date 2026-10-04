package androidx.appsearch.ast.operators;

import android.text.TextUtils;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.ast.Node;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.core.util.Preconditions;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_ABSTRACT_SYNTAX_TREES)
public final class AndNode implements Node {
    private List<Node> mChildren;

    public AndNode(List<Node> list) {
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(list.size() >= 2, "Number of nodes must be at least two.");
        this.mChildren = new ArrayList(list);
    }

    public void addChild(Node node) {
        this.mChildren.add((Node) Preconditions.checkNotNull(node));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AndNode.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.mChildren, ((AndNode) obj).mChildren);
    }

    @Override // androidx.appsearch.ast.Node
    public List<Node> getChildren() {
        return Collections.unmodifiableList(this.mChildren);
    }

    public int getIndexOfChild(Node node) {
        Preconditions.checkNotNull(node);
        return this.mChildren.indexOf(node);
    }

    public int hashCode() {
        return Objects.hashCode(this.mChildren);
    }

    public boolean removeChild(Node node) {
        Preconditions.checkState(this.mChildren.size() > 2, "List of child nodes must contain at least 3 nodes in order to remove.");
        Preconditions.checkNotNull(node);
        return this.mChildren.remove(node);
    }

    public void setChild(int i, Node node) {
        Preconditions.checkArgumentInRange(i, 0, this.mChildren.size() - 1, Bixby2Constants.BIXBY_PARAM_INDEX);
        this.mChildren.set(i, (Node) Preconditions.checkNotNull(node));
    }

    public void setChildren(List<Node> list) {
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(list.size() >= 2, "Number of nodes must be at least two.");
        this.mChildren = new ArrayList(list);
    }

    public String toString() {
        return "(" + TextUtils.join(SQLKeyword.AND, this.mChildren) + ")";
    }

    public AndNode(Node node, Node node2, Node... nodeArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Node) Preconditions.checkNotNull(node));
        arrayList.add((Node) Preconditions.checkNotNull(node2));
        Node[] nodeArr2 = (Node[]) Preconditions.checkNotNull(nodeArr);
        ArrayList arrayList2 = new ArrayList(nodeArr2.length);
        for (Node node3 : nodeArr2) {
            Objects.requireNonNull(node3);
            arrayList2.add(node3);
        }
        arrayList.addAll(Collections.unmodifiableList(arrayList2));
        this.mChildren = arrayList;
    }
}
