package com.vladsch.flexmark.html;

import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
import com.vladsch.flexmark.html.renderer.ResolvedContent;
import com.vladsch.flexmark.html.renderer.ResolvedLink;
import com.vladsch.flexmark.util.ast.Node;

/* JADX INFO: renamed from: com.vladsch.flexmark.html.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11823c implements LinkResolver, UriContentResolver {
    @Override // com.vladsch.flexmark.html.UriContentResolver
    public ResolvedContent resolveContent(Node node, LinkResolverBasicContext linkResolverBasicContext, ResolvedContent resolvedContent) {
        return UriContentResolver.lambda$static$0(node, linkResolverBasicContext, resolvedContent);
    }

    @Override // com.vladsch.flexmark.html.LinkResolver
    public ResolvedLink resolveLink(Node node, LinkResolverBasicContext linkResolverBasicContext, ResolvedLink resolvedLink) {
        return LinkResolver.lambda$static$0(node, linkResolverBasicContext, resolvedLink);
    }
}
