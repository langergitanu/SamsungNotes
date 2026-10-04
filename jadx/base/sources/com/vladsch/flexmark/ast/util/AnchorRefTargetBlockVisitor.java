package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.ast.AnchorRefTarget;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeVisitorBase;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AnchorRefTargetBlockVisitor extends NodeVisitorBase {
    public boolean preVisit(@NotNull Node node) {
        return true;
    }

    public abstract void visit(AnchorRefTarget anchorRefTarget);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vladsch.flexmark.util.ast.NodeVisitorBase
    public void visit(@NotNull Node node) {
        if (node instanceof AnchorRefTarget) {
            visit((AnchorRefTarget) node);
        }
        if (preVisit(node) && (node instanceof Block)) {
            visitChildren(node);
        }
    }
}
