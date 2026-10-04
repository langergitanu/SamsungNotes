package com.samsung.android.support.senl.p148nt.model.assist.llm.preprocessor;

import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class LinePreProcessor {
    public String removeRepeatedEmptyLine(String str) {
        int length = -1;
        while (length != str.length()) {
            length = str.length();
            str = str.replace("\n\n\n", MarkdownDocument.NEW_LINE);
        }
        return str;
    }
}
