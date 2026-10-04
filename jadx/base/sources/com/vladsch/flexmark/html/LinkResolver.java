package com.vladsch.flexmark.html;

import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
import com.vladsch.flexmark.html.renderer.ResolvedLink;
import com.vladsch.flexmark.util.ast.Node;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface LinkResolver {
    public static final LinkResolver NULL = new C11823c();

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ ResolvedLink lambda$static$0(Node node, LinkResolverBasicContext linkResolverBasicContext, ResolvedLink resolvedLink) {
        return resolvedLink;
    }

    @NotNull
    ResolvedLink resolveLink(@NotNull Node node, @NotNull LinkResolverBasicContext linkResolverBasicContext, @NotNull ResolvedLink resolvedLink);
}
