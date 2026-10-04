package com.vladsch.flexmark.parser.core.delimiter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class UnderscoreDelimiterProcessor extends EmphasisDelimiterProcessor {
    public UnderscoreDelimiterProcessor(boolean z) {
        super('_', z);
    }

    @Override // com.vladsch.flexmark.parser.core.delimiter.EmphasisDelimiterProcessor, com.vladsch.flexmark.parser.delimiter.DelimiterProcessor
    public boolean canBeCloser(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        if (z2) {
            return !z || z4;
        }
        return false;
    }

    @Override // com.vladsch.flexmark.parser.core.delimiter.EmphasisDelimiterProcessor, com.vladsch.flexmark.parser.delimiter.DelimiterProcessor
    public boolean canBeOpener(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        if (z) {
            return !z2 || z3;
        }
        return false;
    }
}
