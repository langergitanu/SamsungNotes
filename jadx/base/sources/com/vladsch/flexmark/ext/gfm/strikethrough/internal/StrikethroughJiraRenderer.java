package com.vladsch.flexmark.ext.gfm.strikethrough.internal;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.vladsch.flexmark.ext.gfm.strikethrough.Strikethrough;
import com.vladsch.flexmark.ext.gfm.strikethrough.Subscript;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.NodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
import com.vladsch.flexmark.util.data.DataHolder;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import p242t4.C14468a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class StrikethroughJiraRenderer implements NodeRenderer {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Factory implements NodeRendererFactory {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.html.renderer.NodeRendererFactory, java.util.function.Function
        @NotNull
        public NodeRenderer apply(@NotNull DataHolder dataHolder) {
            return new StrikethroughJiraRenderer(dataHolder);
        }
    }

    public StrikethroughJiraRenderer(DataHolder dataHolder) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(Strikethrough strikethrough, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.raw(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        nodeRendererContext.renderChildren(strikethrough);
        htmlWriter.raw(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
    }

    @Override // com.vladsch.flexmark.html.renderer.NodeRenderer
    public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
        HashSet hashSet = new HashSet();
        hashSet.add(new NodeRenderingHandler(Strikethrough.class, new C14468a(this, 0)));
        hashSet.add(new NodeRenderingHandler(Subscript.class, new C14468a(this, 1)));
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(Subscript subscript, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        htmlWriter.raw("~");
        nodeRendererContext.renderChildren(subscript);
        htmlWriter.raw("~");
    }
}
