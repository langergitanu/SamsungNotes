package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.html.renderer.LinkResolverContext;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.format.NodeContext;
import com.vladsch.flexmark.util.format.TrackedOffsetList;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface NodeFormatterContext extends NodeContext<Node, NodeFormatterContext>, TranslationContext, LinkResolverContext, ExplicitAttributeIdProvider {
    void delegateRender();

    @NotNull
    BasedSequence getBlockQuoteLikePrefixChars();

    @NotNull
    CharPredicate getBlockQuoteLikePrefixPredicate();

    @NotNull
    Document getDocument();

    @NotNull
    FormatterOptions getFormatterOptions();

    @NotNull
    FormattingPhase getFormattingPhase();

    @NotNull
    MarkdownWriter getMarkdown();

    @Override // com.vladsch.flexmark.util.format.NodeContext, com.vladsch.flexmark.html.renderer.LinkResolverContext, com.vladsch.flexmark.html.renderer.LinkResolverBasicContext
    @NotNull
    DataHolder getOptions();

    @NotNull
    TrackedOffsetList getTrackedOffsets();

    @NotNull
    BasedSequence getTrackedSequence();

    boolean isRestoreTrackedSpaces();

    @NotNull
    Iterable<? extends Node> nodesOfType(@NotNull Collection<Class<?>> collection);

    @NotNull
    Iterable<? extends Node> nodesOfType(@NotNull Class<?>[] clsArr);

    void render(@NotNull Node node);

    void renderChildren(@NotNull Node node);

    @NotNull
    Iterable<? extends Node> reversedNodesOfType(@NotNull Collection<Class<?>> collection);

    @NotNull
    Iterable<? extends Node> reversedNodesOfType(@NotNull Class<?>[] clsArr);
}
