package com.vladsch.flexmark.parser.delimiter;

import com.vladsch.flexmark.ast.Text;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface DelimiterRun {
    boolean canClose();

    boolean canOpen();

    char getDelimiterChar();

    DelimiterRun getNext();

    Text getNode();

    DelimiterRun getPrevious();

    int length();
}
