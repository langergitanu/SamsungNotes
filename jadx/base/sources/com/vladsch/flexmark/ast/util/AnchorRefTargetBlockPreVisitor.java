package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.util.ast.Node;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface AnchorRefTargetBlockPreVisitor {
    boolean preVisit(@NotNull Node node, @NotNull AnchorRefTargetBlockVisitor anchorRefTargetBlockVisitor);
}
