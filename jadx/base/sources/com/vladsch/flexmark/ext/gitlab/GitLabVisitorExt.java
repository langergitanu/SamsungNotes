package com.vladsch.flexmark.ext.gitlab;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.VisitHandler;
import com.vladsch.flexmark.util.ast.Visitor;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GitLabVisitorExt {
    public static <V extends GitLabVisitor> VisitHandler<?>[] VISIT_HANDLERS(final V v) {
        Objects.requireNonNull(v);
        final int i = 0;
        final int i2 = 1;
        final int i4 = 2;
        final int i5 = 3;
        return new VisitHandler[]{new VisitHandler(GitLabIns.class, new Visitor() { // from class: com.vladsch.flexmark.ext.gitlab.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i) {
                    case 0:
                        v.visit((GitLabIns) node);
                        break;
                    case 1:
                        v.visit((GitLabDel) node);
                        break;
                    case 2:
                        v.visit((GitLabInlineMath) node);
                        break;
                    default:
                        v.visit((GitLabBlockQuote) node);
                        break;
                }
            }
        }), new VisitHandler(GitLabDel.class, new Visitor() { // from class: com.vladsch.flexmark.ext.gitlab.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i2) {
                    case 0:
                        v.visit((GitLabIns) node);
                        break;
                    case 1:
                        v.visit((GitLabDel) node);
                        break;
                    case 2:
                        v.visit((GitLabInlineMath) node);
                        break;
                    default:
                        v.visit((GitLabBlockQuote) node);
                        break;
                }
            }
        }), new VisitHandler(GitLabInlineMath.class, new Visitor() { // from class: com.vladsch.flexmark.ext.gitlab.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i4) {
                    case 0:
                        v.visit((GitLabIns) node);
                        break;
                    case 1:
                        v.visit((GitLabDel) node);
                        break;
                    case 2:
                        v.visit((GitLabInlineMath) node);
                        break;
                    default:
                        v.visit((GitLabBlockQuote) node);
                        break;
                }
            }
        }), new VisitHandler(GitLabBlockQuote.class, new Visitor() { // from class: com.vladsch.flexmark.ext.gitlab.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i5) {
                    case 0:
                        v.visit((GitLabIns) node);
                        break;
                    case 1:
                        v.visit((GitLabDel) node);
                        break;
                    case 2:
                        v.visit((GitLabInlineMath) node);
                        break;
                    default:
                        v.visit((GitLabBlockQuote) node);
                        break;
                }
            }
        })};
    }
}
