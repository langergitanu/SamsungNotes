package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.parser.block.CharacterNodeFactory;
import com.vladsch.flexmark.parser.core.delimiter.Bracket;
import com.vladsch.flexmark.parser.core.delimiter.Delimiter;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface InlineParser extends LightInlineParser {
    void finalizeDocument(@NotNull Document document);

    @Nullable
    Bracket getLastBracket();

    @Nullable
    Delimiter getLastDelimiter();

    void initializeDocument(@NotNull Document document);

    void mergeIfNeeded(@Nullable Text text, @Nullable Text text2);

    void mergeTextNodes(@Nullable Node node, @Nullable Node node2);

    void parse(@NotNull BasedSequence basedSequence, @NotNull Node node);

    boolean parseAutolink();

    @Nullable
    List<Node> parseCustom(@NotNull BasedSequence basedSequence, @NotNull Node node, @NotNull BitSet bitSet, @NotNull Map<Character, CharacterNodeFactory> map);

    boolean parseEntity();

    boolean parseHtmlInline();

    @Nullable
    BasedSequence parseLinkDestination();

    int parseLinkLabel();

    @Nullable
    BasedSequence parseLinkTitle();

    boolean parseNewline();

    void processDelimiters(@Nullable Delimiter delimiter);

    void removeDelimiter(@NotNull Delimiter delimiter);

    void removeDelimiterAndNode(@NotNull Delimiter delimiter);

    void removeDelimiterKeepNode(@NotNull Delimiter delimiter);

    void removeDelimitersBetween(@NotNull Delimiter delimiter, @NotNull Delimiter delimiter2);

    @Override // com.vladsch.flexmark.parser.LightInlineParser
    @Nullable
    BasedSequence toEOL();
}
