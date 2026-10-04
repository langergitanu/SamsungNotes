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

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface InlineVisitor {
    void visit(AutoLink autoLink);

    void visit(Code code);

    void visit(Emphasis emphasis);

    void visit(HardLineBreak hardLineBreak);

    void visit(HtmlEntity htmlEntity);

    void visit(HtmlInline htmlInline);

    void visit(HtmlInlineComment htmlInlineComment);

    void visit(Image image);

    void visit(ImageRef imageRef);

    void visit(Link link);

    void visit(LinkRef linkRef);

    void visit(MailLink mailLink);

    void visit(SoftLineBreak softLineBreak);

    void visit(StrongEmphasis strongEmphasis);

    void visit(Text text);
}
