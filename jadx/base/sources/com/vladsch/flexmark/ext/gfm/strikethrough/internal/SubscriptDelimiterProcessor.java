package com.vladsch.flexmark.ext.gfm.strikethrough.internal;

import com.vladsch.flexmark.ext.gfm.strikethrough.Subscript;
import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.parser.core.delimiter.Delimiter;
import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
import com.vladsch.flexmark.parser.delimiter.DelimiterRun;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SubscriptDelimiterProcessor implements DelimiterProcessor {
    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterProcessor
    public boolean canBeCloser(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return z2;
    }

    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterProcessor
    public boolean canBeOpener(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return z;
    }

    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterProcessor
    public char getClosingCharacter() {
        return '~';
    }

    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterProcessor
    public int getDelimiterUse(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        return (delimiterRun.length() < 1 || delimiterRun2.length() < 1) ? 0 : 1;
    }

    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterProcessor
    public int getMinLength() {
        return 1;
    }

    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterProcessor
    public char getOpeningCharacter() {
        return '~';
    }

    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterProcessor
    public void process(Delimiter delimiter, Delimiter delimiter2, int i) {
        delimiter.moveNodesBetweenDelimitersTo(new Subscript(delimiter.getTailChars(i), BasedSequence.NULL, delimiter2.getLeadChars(i)), delimiter2);
    }

    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterProcessor
    public boolean skipNonOpenerCloser() {
        return false;
    }

    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterProcessor
    public Node unmatchedDelimiterNode(InlineParser inlineParser, DelimiterRun delimiterRun) {
        return null;
    }
}
