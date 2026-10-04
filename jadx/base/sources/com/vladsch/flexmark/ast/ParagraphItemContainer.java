package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.parser.ListOptions;
import com.vladsch.flexmark.util.data.DataHolder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ParagraphItemContainer {
    boolean isItemParagraph(Paragraph paragraph);

    boolean isParagraphInTightListItem(Paragraph paragraph);

    boolean isParagraphWrappingDisabled(Paragraph paragraph, ListOptions listOptions, DataHolder dataHolder);
}
