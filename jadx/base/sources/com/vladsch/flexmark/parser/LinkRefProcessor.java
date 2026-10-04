package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface LinkRefProcessor {
    @NotNull
    BasedSequence adjustInlineText(@NotNull Document document, @NotNull Node node);

    boolean allowDelimiters(@NotNull BasedSequence basedSequence, @NotNull Document document, @NotNull Node node);

    @NotNull
    Node createNode(@NotNull BasedSequence basedSequence);

    int getBracketNestingLevel();

    boolean getWantExclamationPrefix();

    boolean isMatch(@NotNull BasedSequence basedSequence);

    void updateNodeElements(@NotNull Document document, @NotNull Node node);
}
