package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.ast.util.LinkResolvingHandler;
import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
import com.vladsch.flexmark.html.renderer.ResolvedLink;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.visitor.AstActionHandler;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LinkResolverAdapter extends AstActionHandler<LinkResolverAdapter, Node, LinkResolvingHandler.LinkResolvingVisitor<Node>, LinkResolvingHandler<Node>> implements LinkResolvingHandler.LinkResolvingVisitor<Node> {
    protected static final LinkResolvingHandler[] EMPTY_HANDLERS = new LinkResolvingHandler[0];

    public LinkResolverAdapter(LinkResolvingHandler... linkResolvingHandlerArr) {
        super(Node.AST_ADAPTER);
        addActionHandlers(linkResolvingHandlerArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ResolvedLink lambda$resolveLink$0(LinkResolverBasicContext linkResolverBasicContext, ResolvedLink resolvedLink, Node node, LinkResolvingHandler.LinkResolvingVisitor linkResolvingVisitor) {
        return linkResolvingVisitor.resolveLink(node, linkResolverBasicContext, resolvedLink);
    }

    public LinkResolverAdapter addHandler(LinkResolvingHandler linkResolvingHandler) {
        return (LinkResolverAdapter) super.addActionHandler(linkResolvingHandler);
    }

    public LinkResolverAdapter addHandlers(Collection<LinkResolvingHandler> collection) {
        return addActionHandlers((LinkResolvingHandler[]) collection.toArray(EMPTY_HANDLERS));
    }

    @Override // com.vladsch.flexmark.ast.util.LinkResolvingHandler.LinkResolvingVisitor
    public ResolvedLink resolveLink(Node node, LinkResolverBasicContext linkResolverBasicContext, ResolvedLink resolvedLink) {
        return (ResolvedLink) processNodeOnly(node, resolvedLink, new C11782e(linkResolverBasicContext, resolvedLink, 0));
    }

    public LinkResolverAdapter addHandlers(LinkResolvingHandler[] linkResolvingHandlerArr) {
        return addActionHandlers(linkResolvingHandlerArr);
    }

    public LinkResolverAdapter(LinkResolvingHandler[]... linkResolvingHandlerArr) {
        super(Node.AST_ADAPTER);
        addActionHandlers(linkResolvingHandlerArr);
    }

    public LinkResolverAdapter addHandlers(LinkResolvingHandler[]... linkResolvingHandlerArr) {
        return addActionHandlers(linkResolvingHandlerArr);
    }

    public LinkResolverAdapter(Collection<LinkResolvingHandler> collection) {
        super(Node.AST_ADAPTER);
        addHandlers(collection);
    }
}
