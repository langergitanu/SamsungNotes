package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.ast.NodeRepository;
import com.vladsch.flexmark.util.ast.ReferenceNode;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ReferencingNode<R extends NodeRepository<B>, B extends ReferenceNode> {
    @NotNull
    BasedSequence getReference();

    B getReferenceNode(Document document);

    B getReferenceNode(R r);

    boolean isDefined();
}
