package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.ast.HtmlInnerBlock;
import com.vladsch.flexmark.ast.HtmlInnerBlockComment;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.Visitor;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.vladsch.flexmark.ast.util.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11779b implements Visitor {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8279a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8280b;

    public /* synthetic */ C11779b(Object obj, int i) {
        this.f8279a = i;
        this.f8280b = obj;
    }

    @Override // com.vladsch.flexmark.util.ast.Visitor
    public final void visit(Node node) {
        switch (this.f8279a) {
            case 0:
                ((HtmlInnerVisitor) this.f8280b).visit((HtmlInnerBlock) node);
                break;
            case 1:
                ((HtmlInnerVisitor) this.f8280b).visit((HtmlInnerBlockComment) node);
                break;
            default:
                ((ArrayList) this.f8280b).add((Heading) node);
                break;
        }
    }
}
