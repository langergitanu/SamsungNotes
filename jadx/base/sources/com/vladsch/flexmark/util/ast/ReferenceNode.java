package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ReferenceNode<R extends NodeRepository<B>, B extends Node, N extends Node> extends Comparable<B> {
    @Nullable
    N getReferencingNode(@NotNull Node node);
}
