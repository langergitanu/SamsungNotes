package com.vladsch.flexmark.ext.gfm.strikethrough;

import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItem;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItemVisitor;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.Visitor;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.vladsch.flexmark.ext.gfm.strikethrough.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11785a implements Visitor {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8292a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8293b;

    public /* synthetic */ C11785a(Object obj, int i) {
        this.f8292a = i;
        this.f8293b = obj;
    }

    @Override // com.vladsch.flexmark.util.ast.Visitor
    public final void visit(Node node) {
        switch (this.f8292a) {
            case 0:
                ((StrikethroughVisitor) this.f8293b).visit((Strikethrough) node);
                break;
            case 1:
                ((SubscriptVisitor) this.f8293b).visit((Subscript) node);
                break;
            case 2:
                ((TaskListItemVisitor) this.f8293b).visit((TaskListItem) node);
                break;
            default:
                ((Consumer) this.f8293b).accept(node);
                break;
        }
    }
}
