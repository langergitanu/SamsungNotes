package com.vladsch.flexmark.html.renderer;

import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.visitor.AstAction;
import com.vladsch.flexmark.util.visitor.AstHandler;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NodeRenderingHandler<N extends Node> extends AstHandler<N, CustomNodeRenderer<N>> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CustomNodeRenderer<N extends Node> extends AstAction<N> {
        void render(@NotNull N n, @NotNull NodeRendererContext nodeRendererContext, @NotNull HtmlWriter htmlWriter);
    }

    public NodeRenderingHandler(@NotNull Class<N> cls, @NotNull CustomNodeRenderer<N> customNodeRenderer) {
        super(cls, customNodeRenderer);
    }

    public void render(@NotNull Node node, @NotNull NodeRendererContext nodeRendererContext, @NotNull HtmlWriter htmlWriter) {
        getAdapter().render(node, nodeRendererContext, htmlWriter);
    }
}
