package com.vladsch.flexmark.util.ast;

import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NodeClassifier implements Function<Node, Class<?>> {
    public static final NodeClassifier INSTANCE = new NodeClassifier();

    private NodeClassifier() {
    }

    @Override // java.util.function.Function
    @NotNull
    public Class<?> apply(@NotNull Node node) {
        return node.getClass();
    }
}
