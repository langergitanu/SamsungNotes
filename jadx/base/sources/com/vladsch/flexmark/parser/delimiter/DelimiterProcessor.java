package com.vladsch.flexmark.parser.delimiter;

import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.parser.core.delimiter.Delimiter;
import com.vladsch.flexmark.util.ast.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface DelimiterProcessor {
    boolean canBeCloser(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6);

    boolean canBeOpener(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6);

    char getClosingCharacter();

    int getDelimiterUse(DelimiterRun delimiterRun, DelimiterRun delimiterRun2);

    int getMinLength();

    char getOpeningCharacter();

    void process(Delimiter delimiter, Delimiter delimiter2, int i);

    boolean skipNonOpenerCloser();

    Node unmatchedDelimiterNode(InlineParser inlineParser, DelimiterRun delimiterRun);
}
