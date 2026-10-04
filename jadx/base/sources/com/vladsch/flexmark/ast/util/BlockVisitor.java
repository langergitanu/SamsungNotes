package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.ast.BlockQuote;
import com.vladsch.flexmark.ast.BulletList;
import com.vladsch.flexmark.ast.BulletListItem;
import com.vladsch.flexmark.ast.FencedCodeBlock;
import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.ast.HtmlBlock;
import com.vladsch.flexmark.ast.HtmlCommentBlock;
import com.vladsch.flexmark.ast.IndentedCodeBlock;
import com.vladsch.flexmark.ast.OrderedList;
import com.vladsch.flexmark.ast.OrderedListItem;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.ast.Reference;
import com.vladsch.flexmark.ast.ThematicBreak;
import com.vladsch.flexmark.util.ast.Document;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface BlockVisitor {
    void visit(BlockQuote blockQuote);

    void visit(BulletList bulletList);

    void visit(BulletListItem bulletListItem);

    void visit(FencedCodeBlock fencedCodeBlock);

    void visit(Heading heading);

    void visit(HtmlBlock htmlBlock);

    void visit(HtmlCommentBlock htmlCommentBlock);

    void visit(IndentedCodeBlock indentedCodeBlock);

    void visit(OrderedList orderedList);

    void visit(OrderedListItem orderedListItem);

    void visit(Paragraph paragraph);

    void visit(Reference reference);

    void visit(ThematicBreak thematicBreak);

    void visit(Document document);
}
