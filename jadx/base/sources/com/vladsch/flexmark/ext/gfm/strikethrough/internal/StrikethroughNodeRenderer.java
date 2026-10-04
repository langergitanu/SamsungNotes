package com.vladsch.flexmark.ext.gfm.strikethrough.internal;

import com.vladsch.flexmark.ext.gfm.strikethrough.Strikethrough;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughSubscriptExtension;
import com.vladsch.flexmark.ext.gfm.strikethrough.Subscript;
import com.vladsch.flexmark.ext.gfm.strikethrough.internal.StrikethroughNodeRenderer;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.NodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class StrikethroughNodeRenderer implements NodeRenderer {
    private final String strikethroughStyleHtmlClose;
    private final String strikethroughStyleHtmlOpen;
    private final String subscriptStyleHtmlClose;
    private final String subscriptStyleHtmlOpen;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Factory implements NodeRendererFactory {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.html.renderer.NodeRendererFactory, java.util.function.Function
        @NotNull
        public NodeRenderer apply(@NotNull DataHolder dataHolder) {
            return new StrikethroughNodeRenderer(dataHolder);
        }
    }

    public StrikethroughNodeRenderer(DataHolder dataHolder) {
        this.strikethroughStyleHtmlOpen = StrikethroughSubscriptExtension.STRIKETHROUGH_STYLE_HTML_OPEN.get(dataHolder);
        this.strikethroughStyleHtmlClose = StrikethroughSubscriptExtension.STRIKETHROUGH_STYLE_HTML_CLOSE.get(dataHolder);
        this.subscriptStyleHtmlOpen = StrikethroughSubscriptExtension.SUBSCRIPT_STYLE_HTML_OPEN.get(dataHolder);
        this.subscriptStyleHtmlClose = StrikethroughSubscriptExtension.SUBSCRIPT_STYLE_HTML_CLOSE.get(dataHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(Strikethrough strikethrough, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        String str = this.strikethroughStyleHtmlOpen;
        if (str != null && this.strikethroughStyleHtmlClose != null) {
            htmlWriter.raw((CharSequence) str);
            nodeRendererContext.renderChildren(strikethrough);
            htmlWriter.raw((CharSequence) this.strikethroughStyleHtmlClose);
        } else {
            if (nodeRendererContext.getHtmlOptions().sourcePositionParagraphLines) {
                htmlWriter.withAttr().tag("del");
            } else {
                htmlWriter.srcPos(strikethrough.getText()).withAttr().tag("del");
            }
            nodeRendererContext.renderChildren(strikethrough);
            htmlWriter.tag("/del");
        }
    }

    @Override // com.vladsch.flexmark.html.renderer.NodeRenderer
    public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
        HashSet hashSet = new HashSet();
        final int i = 0;
        hashSet.add(new NodeRenderingHandler(Strikethrough.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: t4.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ StrikethroughNodeRenderer f10271b;

            {
                this.f10271b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i) {
                    case 0:
                        this.f10271b.render((Strikethrough) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f10271b.render((Subscript) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }));
        final int i2 = 1;
        hashSet.add(new NodeRenderingHandler(Subscript.class, new NodeRenderingHandler.CustomNodeRenderer(this) { // from class: t4.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ StrikethroughNodeRenderer f10271b;

            {
                this.f10271b = this;
            }

            @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
            public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
                switch (i2) {
                    case 0:
                        this.f10271b.render((Strikethrough) node, nodeRendererContext, htmlWriter);
                        break;
                    default:
                        this.f10271b.render((Subscript) node, nodeRendererContext, htmlWriter);
                        break;
                }
            }
        }));
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(Subscript subscript, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        String str = this.subscriptStyleHtmlOpen;
        if (str != null && this.subscriptStyleHtmlClose != null) {
            htmlWriter.raw((CharSequence) str);
            nodeRendererContext.renderChildren(subscript);
            htmlWriter.raw((CharSequence) this.subscriptStyleHtmlClose);
        } else {
            if (nodeRendererContext.getHtmlOptions().sourcePositionParagraphLines) {
                htmlWriter.withAttr().tag("sub");
            } else {
                htmlWriter.srcPos(subscript.getText()).withAttr().tag("sub");
            }
            nodeRendererContext.renderChildren(subscript);
            htmlWriter.tag("/sub");
        }
    }
}
