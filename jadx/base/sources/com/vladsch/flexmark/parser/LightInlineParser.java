package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.ast.util.Parsing;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface LightInlineParser {
    void appendNode(@NotNull Node node);

    @NotNull
    Text appendSeparateText(@NotNull BasedSequence basedSequence);

    void appendText(@NotNull BasedSequence basedSequence);

    void appendText(@NotNull BasedSequence basedSequence, int i, int i2);

    boolean flushTextNode();

    @NotNull
    Node getBlock();

    @NotNull
    ArrayList<BasedSequence> getCurrentText();

    @NotNull
    Document getDocument();

    int getIndex();

    @NotNull
    BasedSequence getInput();

    @NotNull
    InlineParserOptions getOptions();

    @NotNull
    Parsing getParsing();

    @Nullable
    BasedSequence match(Pattern pattern);

    @Nullable
    BasedSequence[] matchWithGroups(Pattern pattern);

    @Nullable
    Matcher matcher(Pattern pattern);

    void moveNodes(@NotNull Node node, @NotNull Node node2);

    boolean nonIndentSp();

    char peek();

    char peek(int i);

    void setBlock(@NotNull Node node);

    void setDocument(@NotNull Document document);

    void setIndex(int i);

    void setInput(BasedSequence basedSequence);

    /* JADX INFO: renamed from: sp */
    boolean mo13314sp();

    boolean spnl();

    boolean spnlUrl();

    @Nullable
    BasedSequence toEOL();
}
