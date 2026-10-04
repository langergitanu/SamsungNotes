package com.vladsch.flexmark.html;

import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class NodeRenderingHandlerWrapper {

    @Nullable
    public final NodeRenderingHandlerWrapper myPreviousRenderingHandler;

    @NotNull
    public final NodeRenderingHandler<?> myRenderingHandler;

    public NodeRenderingHandlerWrapper(@NotNull NodeRenderingHandler<?> nodeRenderingHandler, @Nullable NodeRenderingHandlerWrapper nodeRenderingHandlerWrapper) {
        this.myRenderingHandler = nodeRenderingHandler;
        this.myPreviousRenderingHandler = nodeRenderingHandlerWrapper;
    }
}
