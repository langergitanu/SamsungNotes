package com.vladsch.flexmark.html.renderer;

import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.html.Attributes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface LinkResolverContext extends LinkResolverBasicContext {
    @NotNull
    String encodeUrl(@NotNull CharSequence charSequence);

    @NotNull
    Node getCurrentNode();

    @Override // com.vladsch.flexmark.html.renderer.LinkResolverBasicContext
    @NotNull
    Document getDocument();

    @Override // com.vladsch.flexmark.html.renderer.LinkResolverBasicContext
    @NotNull
    DataHolder getOptions();

    void render(@NotNull Node node);

    void renderChildren(@NotNull Node node);

    @NotNull
    ResolvedLink resolveLink(@NotNull LinkType linkType, @NotNull CharSequence charSequence, @Nullable Attributes attributes, @Nullable Boolean bool);

    @NotNull
    default ResolvedLink resolveLink(@NotNull LinkType linkType, @NotNull CharSequence charSequence, @Nullable Boolean bool) {
        return resolveLink(linkType, charSequence, null, bool);
    }
}
