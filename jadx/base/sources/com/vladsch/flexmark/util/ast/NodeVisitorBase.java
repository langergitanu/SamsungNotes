package com.vladsch.flexmark.util.ast;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class NodeVisitorBase {
    public abstract void visit(@NotNull Node node);

    public void visitChildren(@NotNull Node node) {
        Node firstChild = node.getFirstChild();
        while (firstChild != null) {
            Node next = firstChild.getNext();
            visit(firstChild);
            firstChild = next;
        }
    }
}
