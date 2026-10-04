package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.ast.HtmlInnerBlock;
import com.vladsch.flexmark.ast.HtmlInnerBlockComment;
import com.vladsch.flexmark.util.ast.VisitHandler;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HtmlInnerVisitorExt {
    public static <V extends HtmlInnerVisitor> VisitHandler<?>[] VISIT_HANDLERS(V v) {
        Objects.requireNonNull(v);
        return new VisitHandler[]{new VisitHandler(HtmlInnerBlock.class, new C11779b(v, 0)), new VisitHandler(HtmlInnerBlockComment.class, new C11779b(v, 1))};
    }
}
