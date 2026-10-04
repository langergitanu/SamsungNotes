package com.vladsch.flexmark.html;

import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.util.ast.Node;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class NodeRendererSubContext implements NodeRendererContext {
    final HtmlWriter htmlWriter;
    NodeRenderingHandlerWrapper renderingHandlerWrapper;
    Node renderingNode = null;
    int doNotRenderLinksNesting = 0;

    public NodeRendererSubContext(@NotNull HtmlWriter htmlWriter) {
        this.htmlWriter = htmlWriter;
    }

    @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
    public void doNotRenderLinks(boolean z) {
        if (z) {
            doNotRenderLinks();
        } else {
            doRenderLinks();
        }
    }

    @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
    public void doRenderLinks() {
        int i = this.doNotRenderLinksNesting;
        if (i == 0) {
            throw new IllegalStateException("Not in do not render links context");
        }
        this.doNotRenderLinksNesting = i - 1;
    }

    public void flushTo(@NotNull Appendable appendable, int i) {
        flushTo(appendable, getHtmlOptions().maxBlankLines, i);
    }

    public int getDoNotRenderLinksNesting() {
        return this.doNotRenderLinksNesting;
    }

    @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
    @NotNull
    public HtmlWriter getHtmlWriter() {
        return this.htmlWriter;
    }

    @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
    public boolean isDoNotRenderLinks() {
        return this.doNotRenderLinksNesting != 0;
    }

    public void flushTo(@NotNull Appendable appendable, int i, int i2) {
        this.htmlWriter.line();
        try {
            this.htmlWriter.appendTo(appendable, i, i2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.vladsch.flexmark.html.renderer.NodeRendererContext
    public void doNotRenderLinks() {
        this.doNotRenderLinksNesting++;
    }
}
