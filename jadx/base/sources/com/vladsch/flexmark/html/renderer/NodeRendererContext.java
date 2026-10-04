package com.vladsch.flexmark.html.renderer;

import com.vladsch.flexmark.html.HtmlRendererOptions;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.html.Attributes;
import com.vladsch.flexmark.util.html.MutableAttributes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface NodeRendererContext extends LinkResolverContext {
    void delegateRender();

    void doNotRenderLinks();

    void doNotRenderLinks(boolean z);

    void doRenderLinks();

    @NotNull
    MutableAttributes extendRenderingNodeAttributes(@NotNull AttributablePart attributablePart, @Nullable Attributes attributes);

    @NotNull
    MutableAttributes extendRenderingNodeAttributes(@NotNull Node node, @NotNull AttributablePart attributablePart, @Nullable Attributes attributes);

    @NotNull
    NodeRendererContext getDelegatedSubContext(boolean z);

    @NotNull
    HtmlRendererOptions getHtmlOptions();

    @NotNull
    HtmlWriter getHtmlWriter();

    @Nullable
    String getNodeId(@NotNull Node node);

    @NotNull
    RenderingPhase getRenderingPhase();

    @NotNull
    NodeRendererContext getSubContext(boolean z);

    boolean isDoNotRenderLinks();
}
