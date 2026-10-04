package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.visitor.AstAction;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface Visitor<N extends Node> extends AstAction<N> {
    void visit(@NotNull N n);
}
