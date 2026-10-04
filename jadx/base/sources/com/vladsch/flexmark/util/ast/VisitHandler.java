package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.visitor.AstHandler;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class VisitHandler<N extends Node> extends AstHandler<N, Visitor<N>> implements Visitor<Node> {
    public VisitHandler(@NotNull Class<N> cls, @NotNull Visitor<N> visitor) {
        super(cls, visitor);
    }

    @Override // com.vladsch.flexmark.util.ast.Visitor
    public void visit(@NotNull Node node) {
        getAdapter().visit(node);
    }
}
