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
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.VisitHandler;
import com.vladsch.flexmark.util.ast.Visitor;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BlockVisitorExt {
    public static <V extends BlockVisitor> VisitHandler<?>[] VISIT_HANDLERS(final V v) {
        Objects.requireNonNull(v);
        final int i = 0;
        final int i2 = 9;
        final int i4 = 10;
        final int i5 = 11;
        final int i6 = 12;
        final int i7 = 13;
        final int i8 = 1;
        final int i9 = 2;
        final int i10 = 3;
        final int i11 = 4;
        final int i12 = 5;
        final int i13 = 6;
        final int i14 = 7;
        final int i15 = 8;
        return new VisitHandler[]{new VisitHandler(BlockQuote.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i) {
                    case 0:
                        v.visit((BlockQuote) node);
                        break;
                    case 1:
                        v.visit((HtmlCommentBlock) node);
                        break;
                    case 2:
                        v.visit((IndentedCodeBlock) node);
                        break;
                    case 3:
                        v.visit((BulletListItem) node);
                        break;
                    case 4:
                        v.visit((OrderedListItem) node);
                        break;
                    case 5:
                        v.visit((OrderedList) node);
                        break;
                    case 6:
                        v.visit((Paragraph) node);
                        break;
                    case 7:
                        v.visit((Reference) node);
                        break;
                    case 8:
                        v.visit((ThematicBreak) node);
                        break;
                    case 9:
                        v.visit((BulletList) node);
                        break;
                    case 10:
                        v.visit((Document) node);
                        break;
                    case 11:
                        v.visit((FencedCodeBlock) node);
                        break;
                    case 12:
                        v.visit((Heading) node);
                        break;
                    default:
                        v.visit((HtmlBlock) node);
                        break;
                }
            }
        }), new VisitHandler(BulletList.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i2) {
                    case 0:
                        v.visit((BlockQuote) node);
                        break;
                    case 1:
                        v.visit((HtmlCommentBlock) node);
                        break;
                    case 2:
                        v.visit((IndentedCodeBlock) node);
                        break;
                    case 3:
                        v.visit((BulletListItem) node);
                        break;
                    case 4:
                        v.visit((OrderedListItem) node);
                        break;
                    case 5:
                        v.visit((OrderedList) node);
                        break;
                    case 6:
                        v.visit((Paragraph) node);
                        break;
                    case 7:
                        v.visit((Reference) node);
                        break;
                    case 8:
                        v.visit((ThematicBreak) node);
                        break;
                    case 9:
                        v.visit((BulletList) node);
                        break;
                    case 10:
                        v.visit((Document) node);
                        break;
                    case 11:
                        v.visit((FencedCodeBlock) node);
                        break;
                    case 12:
                        v.visit((Heading) node);
                        break;
                    default:
                        v.visit((HtmlBlock) node);
                        break;
                }
            }
        }), new VisitHandler(Document.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i4) {
                    case 0:
                        v.visit((BlockQuote) node);
                        break;
                    case 1:
                        v.visit((HtmlCommentBlock) node);
                        break;
                    case 2:
                        v.visit((IndentedCodeBlock) node);
                        break;
                    case 3:
                        v.visit((BulletListItem) node);
                        break;
                    case 4:
                        v.visit((OrderedListItem) node);
                        break;
                    case 5:
                        v.visit((OrderedList) node);
                        break;
                    case 6:
                        v.visit((Paragraph) node);
                        break;
                    case 7:
                        v.visit((Reference) node);
                        break;
                    case 8:
                        v.visit((ThematicBreak) node);
                        break;
                    case 9:
                        v.visit((BulletList) node);
                        break;
                    case 10:
                        v.visit((Document) node);
                        break;
                    case 11:
                        v.visit((FencedCodeBlock) node);
                        break;
                    case 12:
                        v.visit((Heading) node);
                        break;
                    default:
                        v.visit((HtmlBlock) node);
                        break;
                }
            }
        }), new VisitHandler(FencedCodeBlock.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i5) {
                    case 0:
                        v.visit((BlockQuote) node);
                        break;
                    case 1:
                        v.visit((HtmlCommentBlock) node);
                        break;
                    case 2:
                        v.visit((IndentedCodeBlock) node);
                        break;
                    case 3:
                        v.visit((BulletListItem) node);
                        break;
                    case 4:
                        v.visit((OrderedListItem) node);
                        break;
                    case 5:
                        v.visit((OrderedList) node);
                        break;
                    case 6:
                        v.visit((Paragraph) node);
                        break;
                    case 7:
                        v.visit((Reference) node);
                        break;
                    case 8:
                        v.visit((ThematicBreak) node);
                        break;
                    case 9:
                        v.visit((BulletList) node);
                        break;
                    case 10:
                        v.visit((Document) node);
                        break;
                    case 11:
                        v.visit((FencedCodeBlock) node);
                        break;
                    case 12:
                        v.visit((Heading) node);
                        break;
                    default:
                        v.visit((HtmlBlock) node);
                        break;
                }
            }
        }), new VisitHandler(Heading.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i6) {
                    case 0:
                        v.visit((BlockQuote) node);
                        break;
                    case 1:
                        v.visit((HtmlCommentBlock) node);
                        break;
                    case 2:
                        v.visit((IndentedCodeBlock) node);
                        break;
                    case 3:
                        v.visit((BulletListItem) node);
                        break;
                    case 4:
                        v.visit((OrderedListItem) node);
                        break;
                    case 5:
                        v.visit((OrderedList) node);
                        break;
                    case 6:
                        v.visit((Paragraph) node);
                        break;
                    case 7:
                        v.visit((Reference) node);
                        break;
                    case 8:
                        v.visit((ThematicBreak) node);
                        break;
                    case 9:
                        v.visit((BulletList) node);
                        break;
                    case 10:
                        v.visit((Document) node);
                        break;
                    case 11:
                        v.visit((FencedCodeBlock) node);
                        break;
                    case 12:
                        v.visit((Heading) node);
                        break;
                    default:
                        v.visit((HtmlBlock) node);
                        break;
                }
            }
        }), new VisitHandler(HtmlBlock.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i7) {
                    case 0:
                        v.visit((BlockQuote) node);
                        break;
                    case 1:
                        v.visit((HtmlCommentBlock) node);
                        break;
                    case 2:
                        v.visit((IndentedCodeBlock) node);
                        break;
                    case 3:
                        v.visit((BulletListItem) node);
                        break;
                    case 4:
                        v.visit((OrderedListItem) node);
                        break;
                    case 5:
                        v.visit((OrderedList) node);
                        break;
                    case 6:
                        v.visit((Paragraph) node);
                        break;
                    case 7:
                        v.visit((Reference) node);
                        break;
                    case 8:
                        v.visit((ThematicBreak) node);
                        break;
                    case 9:
                        v.visit((BulletList) node);
                        break;
                    case 10:
                        v.visit((Document) node);
                        break;
                    case 11:
                        v.visit((FencedCodeBlock) node);
                        break;
                    case 12:
                        v.visit((Heading) node);
                        break;
                    default:
                        v.visit((HtmlBlock) node);
                        break;
                }
            }
        }), new VisitHandler(HtmlCommentBlock.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i8) {
                    case 0:
                        v.visit((BlockQuote) node);
                        break;
                    case 1:
                        v.visit((HtmlCommentBlock) node);
                        break;
                    case 2:
                        v.visit((IndentedCodeBlock) node);
                        break;
                    case 3:
                        v.visit((BulletListItem) node);
                        break;
                    case 4:
                        v.visit((OrderedListItem) node);
                        break;
                    case 5:
                        v.visit((OrderedList) node);
                        break;
                    case 6:
                        v.visit((Paragraph) node);
                        break;
                    case 7:
                        v.visit((Reference) node);
                        break;
                    case 8:
                        v.visit((ThematicBreak) node);
                        break;
                    case 9:
                        v.visit((BulletList) node);
                        break;
                    case 10:
                        v.visit((Document) node);
                        break;
                    case 11:
                        v.visit((FencedCodeBlock) node);
                        break;
                    case 12:
                        v.visit((Heading) node);
                        break;
                    default:
                        v.visit((HtmlBlock) node);
                        break;
                }
            }
        }), new VisitHandler(IndentedCodeBlock.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i9) {
                    case 0:
                        v.visit((BlockQuote) node);
                        break;
                    case 1:
                        v.visit((HtmlCommentBlock) node);
                        break;
                    case 2:
                        v.visit((IndentedCodeBlock) node);
                        break;
                    case 3:
                        v.visit((BulletListItem) node);
                        break;
                    case 4:
                        v.visit((OrderedListItem) node);
                        break;
                    case 5:
                        v.visit((OrderedList) node);
                        break;
                    case 6:
                        v.visit((Paragraph) node);
                        break;
                    case 7:
                        v.visit((Reference) node);
                        break;
                    case 8:
                        v.visit((ThematicBreak) node);
                        break;
                    case 9:
                        v.visit((BulletList) node);
                        break;
                    case 10:
                        v.visit((Document) node);
                        break;
                    case 11:
                        v.visit((FencedCodeBlock) node);
                        break;
                    case 12:
                        v.visit((Heading) node);
                        break;
                    default:
                        v.visit((HtmlBlock) node);
                        break;
                }
            }
        }), new VisitHandler(BulletListItem.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i10) {
                    case 0:
                        v.visit((BlockQuote) node);
                        break;
                    case 1:
                        v.visit((HtmlCommentBlock) node);
                        break;
                    case 2:
                        v.visit((IndentedCodeBlock) node);
                        break;
                    case 3:
                        v.visit((BulletListItem) node);
                        break;
                    case 4:
                        v.visit((OrderedListItem) node);
                        break;
                    case 5:
                        v.visit((OrderedList) node);
                        break;
                    case 6:
                        v.visit((Paragraph) node);
                        break;
                    case 7:
                        v.visit((Reference) node);
                        break;
                    case 8:
                        v.visit((ThematicBreak) node);
                        break;
                    case 9:
                        v.visit((BulletList) node);
                        break;
                    case 10:
                        v.visit((Document) node);
                        break;
                    case 11:
                        v.visit((FencedCodeBlock) node);
                        break;
                    case 12:
                        v.visit((Heading) node);
                        break;
                    default:
                        v.visit((HtmlBlock) node);
                        break;
                }
            }
        }), new VisitHandler(OrderedListItem.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i11) {
                    case 0:
                        v.visit((BlockQuote) node);
                        break;
                    case 1:
                        v.visit((HtmlCommentBlock) node);
                        break;
                    case 2:
                        v.visit((IndentedCodeBlock) node);
                        break;
                    case 3:
                        v.visit((BulletListItem) node);
                        break;
                    case 4:
                        v.visit((OrderedListItem) node);
                        break;
                    case 5:
                        v.visit((OrderedList) node);
                        break;
                    case 6:
                        v.visit((Paragraph) node);
                        break;
                    case 7:
                        v.visit((Reference) node);
                        break;
                    case 8:
                        v.visit((ThematicBreak) node);
                        break;
                    case 9:
                        v.visit((BulletList) node);
                        break;
                    case 10:
                        v.visit((Document) node);
                        break;
                    case 11:
                        v.visit((FencedCodeBlock) node);
                        break;
                    case 12:
                        v.visit((Heading) node);
                        break;
                    default:
                        v.visit((HtmlBlock) node);
                        break;
                }
            }
        }), new VisitHandler(OrderedList.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i12) {
                    case 0:
                        v.visit((BlockQuote) node);
                        break;
                    case 1:
                        v.visit((HtmlCommentBlock) node);
                        break;
                    case 2:
                        v.visit((IndentedCodeBlock) node);
                        break;
                    case 3:
                        v.visit((BulletListItem) node);
                        break;
                    case 4:
                        v.visit((OrderedListItem) node);
                        break;
                    case 5:
                        v.visit((OrderedList) node);
                        break;
                    case 6:
                        v.visit((Paragraph) node);
                        break;
                    case 7:
                        v.visit((Reference) node);
                        break;
                    case 8:
                        v.visit((ThematicBreak) node);
                        break;
                    case 9:
                        v.visit((BulletList) node);
                        break;
                    case 10:
                        v.visit((Document) node);
                        break;
                    case 11:
                        v.visit((FencedCodeBlock) node);
                        break;
                    case 12:
                        v.visit((Heading) node);
                        break;
                    default:
                        v.visit((HtmlBlock) node);
                        break;
                }
            }
        }), new VisitHandler(Paragraph.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i13) {
                    case 0:
                        v.visit((BlockQuote) node);
                        break;
                    case 1:
                        v.visit((HtmlCommentBlock) node);
                        break;
                    case 2:
                        v.visit((IndentedCodeBlock) node);
                        break;
                    case 3:
                        v.visit((BulletListItem) node);
                        break;
                    case 4:
                        v.visit((OrderedListItem) node);
                        break;
                    case 5:
                        v.visit((OrderedList) node);
                        break;
                    case 6:
                        v.visit((Paragraph) node);
                        break;
                    case 7:
                        v.visit((Reference) node);
                        break;
                    case 8:
                        v.visit((ThematicBreak) node);
                        break;
                    case 9:
                        v.visit((BulletList) node);
                        break;
                    case 10:
                        v.visit((Document) node);
                        break;
                    case 11:
                        v.visit((FencedCodeBlock) node);
                        break;
                    case 12:
                        v.visit((Heading) node);
                        break;
                    default:
                        v.visit((HtmlBlock) node);
                        break;
                }
            }
        }), new VisitHandler(Reference.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i14) {
                    case 0:
                        v.visit((BlockQuote) node);
                        break;
                    case 1:
                        v.visit((HtmlCommentBlock) node);
                        break;
                    case 2:
                        v.visit((IndentedCodeBlock) node);
                        break;
                    case 3:
                        v.visit((BulletListItem) node);
                        break;
                    case 4:
                        v.visit((OrderedListItem) node);
                        break;
                    case 5:
                        v.visit((OrderedList) node);
                        break;
                    case 6:
                        v.visit((Paragraph) node);
                        break;
                    case 7:
                        v.visit((Reference) node);
                        break;
                    case 8:
                        v.visit((ThematicBreak) node);
                        break;
                    case 9:
                        v.visit((BulletList) node);
                        break;
                    case 10:
                        v.visit((Document) node);
                        break;
                    case 11:
                        v.visit((FencedCodeBlock) node);
                        break;
                    case 12:
                        v.visit((Heading) node);
                        break;
                    default:
                        v.visit((HtmlBlock) node);
                        break;
                }
            }
        }), new VisitHandler(ThematicBreak.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.a
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i15) {
                    case 0:
                        v.visit((BlockQuote) node);
                        break;
                    case 1:
                        v.visit((HtmlCommentBlock) node);
                        break;
                    case 2:
                        v.visit((IndentedCodeBlock) node);
                        break;
                    case 3:
                        v.visit((BulletListItem) node);
                        break;
                    case 4:
                        v.visit((OrderedListItem) node);
                        break;
                    case 5:
                        v.visit((OrderedList) node);
                        break;
                    case 6:
                        v.visit((Paragraph) node);
                        break;
                    case 7:
                        v.visit((Reference) node);
                        break;
                    case 8:
                        v.visit((ThematicBreak) node);
                        break;
                    case 9:
                        v.visit((BulletList) node);
                        break;
                    case 10:
                        v.visit((Document) node);
                        break;
                    case 11:
                        v.visit((FencedCodeBlock) node);
                        break;
                    case 12:
                        v.visit((Heading) node);
                        break;
                    default:
                        v.visit((HtmlBlock) node);
                        break;
                }
            }
        })};
    }
}
