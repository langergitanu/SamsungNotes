package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.ast.AutoLink;
import com.vladsch.flexmark.ast.Code;
import com.vladsch.flexmark.ast.Emphasis;
import com.vladsch.flexmark.ast.HardLineBreak;
import com.vladsch.flexmark.ast.HtmlEntity;
import com.vladsch.flexmark.ast.HtmlInline;
import com.vladsch.flexmark.ast.HtmlInlineComment;
import com.vladsch.flexmark.ast.Image;
import com.vladsch.flexmark.ast.ImageRef;
import com.vladsch.flexmark.ast.Link;
import com.vladsch.flexmark.ast.LinkRef;
import com.vladsch.flexmark.ast.MailLink;
import com.vladsch.flexmark.ast.SoftLineBreak;
import com.vladsch.flexmark.ast.StrongEmphasis;
import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.VisitHandler;
import com.vladsch.flexmark.util.ast.Visitor;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class InlineVisitorExt {
    public static <V extends InlineVisitor> VisitHandler<?>[] VISIT_HANDLERS(final V v) {
        Objects.requireNonNull(v);
        final int i = 0;
        VisitHandler visitHandler = new VisitHandler(AutoLink.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.c
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i) {
                    case 0:
                        v.visit((AutoLink) node);
                        break;
                    case 1:
                        v.visit((HtmlInline) node);
                        break;
                    case 2:
                        v.visit((HtmlInlineComment) node);
                        break;
                    case 3:
                        v.visit((Image) node);
                        break;
                    case 4:
                        v.visit((ImageRef) node);
                        break;
                    case 5:
                        v.visit((Link) node);
                        break;
                    case 6:
                        v.visit((LinkRef) node);
                        break;
                    case 7:
                        v.visit((MailLink) node);
                        break;
                    case 8:
                        v.visit((SoftLineBreak) node);
                        break;
                    case 9:
                        v.visit((StrongEmphasis) node);
                        break;
                    case 10:
                        v.visit((Text) node);
                        break;
                    case 11:
                        v.visit((Code) node);
                        break;
                    case 12:
                        v.visit((Emphasis) node);
                        break;
                    case 13:
                        v.visit((HardLineBreak) node);
                        break;
                    default:
                        v.visit((HtmlEntity) node);
                        break;
                }
            }
        });
        final int i2 = 11;
        VisitHandler visitHandler2 = new VisitHandler(Code.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.c
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i2) {
                    case 0:
                        v.visit((AutoLink) node);
                        break;
                    case 1:
                        v.visit((HtmlInline) node);
                        break;
                    case 2:
                        v.visit((HtmlInlineComment) node);
                        break;
                    case 3:
                        v.visit((Image) node);
                        break;
                    case 4:
                        v.visit((ImageRef) node);
                        break;
                    case 5:
                        v.visit((Link) node);
                        break;
                    case 6:
                        v.visit((LinkRef) node);
                        break;
                    case 7:
                        v.visit((MailLink) node);
                        break;
                    case 8:
                        v.visit((SoftLineBreak) node);
                        break;
                    case 9:
                        v.visit((StrongEmphasis) node);
                        break;
                    case 10:
                        v.visit((Text) node);
                        break;
                    case 11:
                        v.visit((Code) node);
                        break;
                    case 12:
                        v.visit((Emphasis) node);
                        break;
                    case 13:
                        v.visit((HardLineBreak) node);
                        break;
                    default:
                        v.visit((HtmlEntity) node);
                        break;
                }
            }
        });
        final int i4 = 12;
        VisitHandler visitHandler3 = new VisitHandler(Emphasis.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.c
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i4) {
                    case 0:
                        v.visit((AutoLink) node);
                        break;
                    case 1:
                        v.visit((HtmlInline) node);
                        break;
                    case 2:
                        v.visit((HtmlInlineComment) node);
                        break;
                    case 3:
                        v.visit((Image) node);
                        break;
                    case 4:
                        v.visit((ImageRef) node);
                        break;
                    case 5:
                        v.visit((Link) node);
                        break;
                    case 6:
                        v.visit((LinkRef) node);
                        break;
                    case 7:
                        v.visit((MailLink) node);
                        break;
                    case 8:
                        v.visit((SoftLineBreak) node);
                        break;
                    case 9:
                        v.visit((StrongEmphasis) node);
                        break;
                    case 10:
                        v.visit((Text) node);
                        break;
                    case 11:
                        v.visit((Code) node);
                        break;
                    case 12:
                        v.visit((Emphasis) node);
                        break;
                    case 13:
                        v.visit((HardLineBreak) node);
                        break;
                    default:
                        v.visit((HtmlEntity) node);
                        break;
                }
            }
        });
        final int i5 = 13;
        VisitHandler visitHandler4 = new VisitHandler(HardLineBreak.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.c
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i5) {
                    case 0:
                        v.visit((AutoLink) node);
                        break;
                    case 1:
                        v.visit((HtmlInline) node);
                        break;
                    case 2:
                        v.visit((HtmlInlineComment) node);
                        break;
                    case 3:
                        v.visit((Image) node);
                        break;
                    case 4:
                        v.visit((ImageRef) node);
                        break;
                    case 5:
                        v.visit((Link) node);
                        break;
                    case 6:
                        v.visit((LinkRef) node);
                        break;
                    case 7:
                        v.visit((MailLink) node);
                        break;
                    case 8:
                        v.visit((SoftLineBreak) node);
                        break;
                    case 9:
                        v.visit((StrongEmphasis) node);
                        break;
                    case 10:
                        v.visit((Text) node);
                        break;
                    case 11:
                        v.visit((Code) node);
                        break;
                    case 12:
                        v.visit((Emphasis) node);
                        break;
                    case 13:
                        v.visit((HardLineBreak) node);
                        break;
                    default:
                        v.visit((HtmlEntity) node);
                        break;
                }
            }
        });
        final int i6 = 14;
        VisitHandler visitHandler5 = new VisitHandler(HtmlEntity.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.c
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i6) {
                    case 0:
                        v.visit((AutoLink) node);
                        break;
                    case 1:
                        v.visit((HtmlInline) node);
                        break;
                    case 2:
                        v.visit((HtmlInlineComment) node);
                        break;
                    case 3:
                        v.visit((Image) node);
                        break;
                    case 4:
                        v.visit((ImageRef) node);
                        break;
                    case 5:
                        v.visit((Link) node);
                        break;
                    case 6:
                        v.visit((LinkRef) node);
                        break;
                    case 7:
                        v.visit((MailLink) node);
                        break;
                    case 8:
                        v.visit((SoftLineBreak) node);
                        break;
                    case 9:
                        v.visit((StrongEmphasis) node);
                        break;
                    case 10:
                        v.visit((Text) node);
                        break;
                    case 11:
                        v.visit((Code) node);
                        break;
                    case 12:
                        v.visit((Emphasis) node);
                        break;
                    case 13:
                        v.visit((HardLineBreak) node);
                        break;
                    default:
                        v.visit((HtmlEntity) node);
                        break;
                }
            }
        });
        final int i7 = 1;
        VisitHandler visitHandler6 = new VisitHandler(HtmlInline.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.c
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i7) {
                    case 0:
                        v.visit((AutoLink) node);
                        break;
                    case 1:
                        v.visit((HtmlInline) node);
                        break;
                    case 2:
                        v.visit((HtmlInlineComment) node);
                        break;
                    case 3:
                        v.visit((Image) node);
                        break;
                    case 4:
                        v.visit((ImageRef) node);
                        break;
                    case 5:
                        v.visit((Link) node);
                        break;
                    case 6:
                        v.visit((LinkRef) node);
                        break;
                    case 7:
                        v.visit((MailLink) node);
                        break;
                    case 8:
                        v.visit((SoftLineBreak) node);
                        break;
                    case 9:
                        v.visit((StrongEmphasis) node);
                        break;
                    case 10:
                        v.visit((Text) node);
                        break;
                    case 11:
                        v.visit((Code) node);
                        break;
                    case 12:
                        v.visit((Emphasis) node);
                        break;
                    case 13:
                        v.visit((HardLineBreak) node);
                        break;
                    default:
                        v.visit((HtmlEntity) node);
                        break;
                }
            }
        });
        final int i8 = 2;
        VisitHandler visitHandler7 = new VisitHandler(HtmlInlineComment.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.c
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i8) {
                    case 0:
                        v.visit((AutoLink) node);
                        break;
                    case 1:
                        v.visit((HtmlInline) node);
                        break;
                    case 2:
                        v.visit((HtmlInlineComment) node);
                        break;
                    case 3:
                        v.visit((Image) node);
                        break;
                    case 4:
                        v.visit((ImageRef) node);
                        break;
                    case 5:
                        v.visit((Link) node);
                        break;
                    case 6:
                        v.visit((LinkRef) node);
                        break;
                    case 7:
                        v.visit((MailLink) node);
                        break;
                    case 8:
                        v.visit((SoftLineBreak) node);
                        break;
                    case 9:
                        v.visit((StrongEmphasis) node);
                        break;
                    case 10:
                        v.visit((Text) node);
                        break;
                    case 11:
                        v.visit((Code) node);
                        break;
                    case 12:
                        v.visit((Emphasis) node);
                        break;
                    case 13:
                        v.visit((HardLineBreak) node);
                        break;
                    default:
                        v.visit((HtmlEntity) node);
                        break;
                }
            }
        });
        final int i9 = 3;
        VisitHandler visitHandler8 = new VisitHandler(Image.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.c
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i9) {
                    case 0:
                        v.visit((AutoLink) node);
                        break;
                    case 1:
                        v.visit((HtmlInline) node);
                        break;
                    case 2:
                        v.visit((HtmlInlineComment) node);
                        break;
                    case 3:
                        v.visit((Image) node);
                        break;
                    case 4:
                        v.visit((ImageRef) node);
                        break;
                    case 5:
                        v.visit((Link) node);
                        break;
                    case 6:
                        v.visit((LinkRef) node);
                        break;
                    case 7:
                        v.visit((MailLink) node);
                        break;
                    case 8:
                        v.visit((SoftLineBreak) node);
                        break;
                    case 9:
                        v.visit((StrongEmphasis) node);
                        break;
                    case 10:
                        v.visit((Text) node);
                        break;
                    case 11:
                        v.visit((Code) node);
                        break;
                    case 12:
                        v.visit((Emphasis) node);
                        break;
                    case 13:
                        v.visit((HardLineBreak) node);
                        break;
                    default:
                        v.visit((HtmlEntity) node);
                        break;
                }
            }
        });
        final int i10 = 4;
        VisitHandler visitHandler9 = new VisitHandler(ImageRef.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.c
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i10) {
                    case 0:
                        v.visit((AutoLink) node);
                        break;
                    case 1:
                        v.visit((HtmlInline) node);
                        break;
                    case 2:
                        v.visit((HtmlInlineComment) node);
                        break;
                    case 3:
                        v.visit((Image) node);
                        break;
                    case 4:
                        v.visit((ImageRef) node);
                        break;
                    case 5:
                        v.visit((Link) node);
                        break;
                    case 6:
                        v.visit((LinkRef) node);
                        break;
                    case 7:
                        v.visit((MailLink) node);
                        break;
                    case 8:
                        v.visit((SoftLineBreak) node);
                        break;
                    case 9:
                        v.visit((StrongEmphasis) node);
                        break;
                    case 10:
                        v.visit((Text) node);
                        break;
                    case 11:
                        v.visit((Code) node);
                        break;
                    case 12:
                        v.visit((Emphasis) node);
                        break;
                    case 13:
                        v.visit((HardLineBreak) node);
                        break;
                    default:
                        v.visit((HtmlEntity) node);
                        break;
                }
            }
        });
        final int i11 = 5;
        VisitHandler visitHandler10 = new VisitHandler(Link.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.c
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i11) {
                    case 0:
                        v.visit((AutoLink) node);
                        break;
                    case 1:
                        v.visit((HtmlInline) node);
                        break;
                    case 2:
                        v.visit((HtmlInlineComment) node);
                        break;
                    case 3:
                        v.visit((Image) node);
                        break;
                    case 4:
                        v.visit((ImageRef) node);
                        break;
                    case 5:
                        v.visit((Link) node);
                        break;
                    case 6:
                        v.visit((LinkRef) node);
                        break;
                    case 7:
                        v.visit((MailLink) node);
                        break;
                    case 8:
                        v.visit((SoftLineBreak) node);
                        break;
                    case 9:
                        v.visit((StrongEmphasis) node);
                        break;
                    case 10:
                        v.visit((Text) node);
                        break;
                    case 11:
                        v.visit((Code) node);
                        break;
                    case 12:
                        v.visit((Emphasis) node);
                        break;
                    case 13:
                        v.visit((HardLineBreak) node);
                        break;
                    default:
                        v.visit((HtmlEntity) node);
                        break;
                }
            }
        });
        final int i12 = 6;
        VisitHandler visitHandler11 = new VisitHandler(LinkRef.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.c
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i12) {
                    case 0:
                        v.visit((AutoLink) node);
                        break;
                    case 1:
                        v.visit((HtmlInline) node);
                        break;
                    case 2:
                        v.visit((HtmlInlineComment) node);
                        break;
                    case 3:
                        v.visit((Image) node);
                        break;
                    case 4:
                        v.visit((ImageRef) node);
                        break;
                    case 5:
                        v.visit((Link) node);
                        break;
                    case 6:
                        v.visit((LinkRef) node);
                        break;
                    case 7:
                        v.visit((MailLink) node);
                        break;
                    case 8:
                        v.visit((SoftLineBreak) node);
                        break;
                    case 9:
                        v.visit((StrongEmphasis) node);
                        break;
                    case 10:
                        v.visit((Text) node);
                        break;
                    case 11:
                        v.visit((Code) node);
                        break;
                    case 12:
                        v.visit((Emphasis) node);
                        break;
                    case 13:
                        v.visit((HardLineBreak) node);
                        break;
                    default:
                        v.visit((HtmlEntity) node);
                        break;
                }
            }
        });
        final int i13 = 7;
        VisitHandler visitHandler12 = new VisitHandler(MailLink.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.c
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i13) {
                    case 0:
                        v.visit((AutoLink) node);
                        break;
                    case 1:
                        v.visit((HtmlInline) node);
                        break;
                    case 2:
                        v.visit((HtmlInlineComment) node);
                        break;
                    case 3:
                        v.visit((Image) node);
                        break;
                    case 4:
                        v.visit((ImageRef) node);
                        break;
                    case 5:
                        v.visit((Link) node);
                        break;
                    case 6:
                        v.visit((LinkRef) node);
                        break;
                    case 7:
                        v.visit((MailLink) node);
                        break;
                    case 8:
                        v.visit((SoftLineBreak) node);
                        break;
                    case 9:
                        v.visit((StrongEmphasis) node);
                        break;
                    case 10:
                        v.visit((Text) node);
                        break;
                    case 11:
                        v.visit((Code) node);
                        break;
                    case 12:
                        v.visit((Emphasis) node);
                        break;
                    case 13:
                        v.visit((HardLineBreak) node);
                        break;
                    default:
                        v.visit((HtmlEntity) node);
                        break;
                }
            }
        });
        final int i14 = 8;
        VisitHandler visitHandler13 = new VisitHandler(SoftLineBreak.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.c
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i14) {
                    case 0:
                        v.visit((AutoLink) node);
                        break;
                    case 1:
                        v.visit((HtmlInline) node);
                        break;
                    case 2:
                        v.visit((HtmlInlineComment) node);
                        break;
                    case 3:
                        v.visit((Image) node);
                        break;
                    case 4:
                        v.visit((ImageRef) node);
                        break;
                    case 5:
                        v.visit((Link) node);
                        break;
                    case 6:
                        v.visit((LinkRef) node);
                        break;
                    case 7:
                        v.visit((MailLink) node);
                        break;
                    case 8:
                        v.visit((SoftLineBreak) node);
                        break;
                    case 9:
                        v.visit((StrongEmphasis) node);
                        break;
                    case 10:
                        v.visit((Text) node);
                        break;
                    case 11:
                        v.visit((Code) node);
                        break;
                    case 12:
                        v.visit((Emphasis) node);
                        break;
                    case 13:
                        v.visit((HardLineBreak) node);
                        break;
                    default:
                        v.visit((HtmlEntity) node);
                        break;
                }
            }
        });
        final int i15 = 9;
        VisitHandler visitHandler14 = new VisitHandler(StrongEmphasis.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.c
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i15) {
                    case 0:
                        v.visit((AutoLink) node);
                        break;
                    case 1:
                        v.visit((HtmlInline) node);
                        break;
                    case 2:
                        v.visit((HtmlInlineComment) node);
                        break;
                    case 3:
                        v.visit((Image) node);
                        break;
                    case 4:
                        v.visit((ImageRef) node);
                        break;
                    case 5:
                        v.visit((Link) node);
                        break;
                    case 6:
                        v.visit((LinkRef) node);
                        break;
                    case 7:
                        v.visit((MailLink) node);
                        break;
                    case 8:
                        v.visit((SoftLineBreak) node);
                        break;
                    case 9:
                        v.visit((StrongEmphasis) node);
                        break;
                    case 10:
                        v.visit((Text) node);
                        break;
                    case 11:
                        v.visit((Code) node);
                        break;
                    case 12:
                        v.visit((Emphasis) node);
                        break;
                    case 13:
                        v.visit((HardLineBreak) node);
                        break;
                    default:
                        v.visit((HtmlEntity) node);
                        break;
                }
            }
        });
        final int i16 = 10;
        return new VisitHandler[]{visitHandler, visitHandler2, visitHandler3, visitHandler4, visitHandler5, visitHandler6, visitHandler7, visitHandler8, visitHandler9, visitHandler10, visitHandler11, visitHandler12, visitHandler13, visitHandler14, new VisitHandler(Text.class, new Visitor() { // from class: com.vladsch.flexmark.ast.util.c
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i16) {
                    case 0:
                        v.visit((AutoLink) node);
                        break;
                    case 1:
                        v.visit((HtmlInline) node);
                        break;
                    case 2:
                        v.visit((HtmlInlineComment) node);
                        break;
                    case 3:
                        v.visit((Image) node);
                        break;
                    case 4:
                        v.visit((ImageRef) node);
                        break;
                    case 5:
                        v.visit((Link) node);
                        break;
                    case 6:
                        v.visit((LinkRef) node);
                        break;
                    case 7:
                        v.visit((MailLink) node);
                        break;
                    case 8:
                        v.visit((SoftLineBreak) node);
                        break;
                    case 9:
                        v.visit((StrongEmphasis) node);
                        break;
                    case 10:
                        v.visit((Text) node);
                        break;
                    case 11:
                        v.visit((Code) node);
                        break;
                    case 12:
                        v.visit((Emphasis) node);
                        break;
                    case 13:
                        v.visit((HardLineBreak) node);
                        break;
                    default:
                        v.visit((HtmlEntity) node);
                        break;
                }
            }
        })};
    }
}
