package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
import com.vladsch.flexmark.html.renderer.ResolvedLink;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.visitor.AstAction;
import com.vladsch.flexmark.util.visitor.AstHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LinkResolvingHandler<N extends Node> extends AstHandler<N, LinkResolvingVisitor<N>> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LinkResolvingVisitor<N extends Node> extends AstAction<N> {
        ResolvedLink resolveLink(N n, LinkResolverBasicContext linkResolverBasicContext, ResolvedLink resolvedLink);
    }

    public LinkResolvingHandler(Class<N> cls, LinkResolvingVisitor<N> linkResolvingVisitor) {
        super(cls, linkResolvingVisitor);
    }

    public ResolvedLink resolveLink(Node node, LinkResolverBasicContext linkResolverBasicContext, ResolvedLink resolvedLink) {
        return getAdapter().resolveLink(node, linkResolverBasicContext, resolvedLink);
    }
}
