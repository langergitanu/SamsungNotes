package com.vladsch.flexmark.util.ast;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface NodeTracker {
    void nodeAdded(@NotNull Node node);

    void nodeAddedWithChildren(@NotNull Node node);

    void nodeAddedWithDescendants(@NotNull Node node);

    void nodeRemoved(@NotNull Node node);

    void nodeRemovedWithChildren(@NotNull Node node);

    void nodeRemovedWithDescendants(@NotNull Node node);
}
