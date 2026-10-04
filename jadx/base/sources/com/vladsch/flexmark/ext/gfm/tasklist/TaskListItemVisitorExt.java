package com.vladsch.flexmark.ext.gfm.tasklist;

import com.vladsch.flexmark.ext.gfm.strikethrough.C11785a;
import com.vladsch.flexmark.util.ast.VisitHandler;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TaskListItemVisitorExt {
    public static <V extends TaskListItemVisitor> VisitHandler<?>[] VISIT_HANDLERS(V v) {
        Objects.requireNonNull(v);
        return new VisitHandler[]{new VisitHandler(TaskListItem.class, new C11785a(v, 2))};
    }
}
