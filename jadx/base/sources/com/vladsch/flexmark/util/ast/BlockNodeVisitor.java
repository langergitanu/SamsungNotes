package com.vladsch.flexmark.util.ast;

import java.util.Collection;
import java.util.function.BiConsumer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BlockNodeVisitor extends NodeVisitor {
    public BlockNodeVisitor() {
    }

    @Override // com.vladsch.flexmark.util.visitor.AstActionHandler
    public /* bridge */ /* synthetic */ void processNode(@NotNull Node node, boolean z, @NotNull BiConsumer biConsumer) {
        processNode2(node, z, (BiConsumer<Node, Visitor<Node>>) biConsumer);
    }

    public BlockNodeVisitor(@NotNull VisitHandler... visitHandlerArr) {
        super(visitHandlerArr);
    }

    /* JADX INFO: renamed from: processNode, reason: avoid collision after fix types in other method */
    public void processNode2(@NotNull Node node, boolean z, @NotNull BiConsumer<Node, Visitor<Node>> biConsumer) {
        if (node instanceof Block) {
            super.processNode(node, z, (BiConsumer<Node, A>) biConsumer);
        }
    }

    public BlockNodeVisitor(@NotNull VisitHandler[]... visitHandlerArr) {
        super(visitHandlerArr);
    }

    public BlockNodeVisitor(@NotNull Collection<VisitHandler> collection) {
        super(collection);
    }
}
