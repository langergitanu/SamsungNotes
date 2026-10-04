package com.vladsch.flexmark.ext.tables;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.VisitHandler;
import com.vladsch.flexmark.util.ast.Visitor;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableVisitorExt {
    public static <V extends TableVisitor> VisitHandler<?>[] VISIT_HANDLERS(final V v) {
        Objects.requireNonNull(v);
        final int i = 0;
        final int i2 = 1;
        final int i4 = 2;
        final int i5 = 3;
        final int i6 = 4;
        final int i7 = 5;
        final int i8 = 6;
        return new VisitHandler[]{new VisitHandler(TableBlock.class, new Visitor() { // from class: com.vladsch.flexmark.ext.tables.b
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i) {
                    case 0:
                        v.visit((TableBlock) node);
                        break;
                    case 1:
                        v.visit((TableHead) node);
                        break;
                    case 2:
                        v.visit((TableSeparator) node);
                        break;
                    case 3:
                        v.visit((TableBody) node);
                        break;
                    case 4:
                        v.visit((TableRow) node);
                        break;
                    case 5:
                        v.visit((TableCell) node);
                        break;
                    default:
                        v.visit((TableCaption) node);
                        break;
                }
            }
        }), new VisitHandler(TableHead.class, new Visitor() { // from class: com.vladsch.flexmark.ext.tables.b
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i2) {
                    case 0:
                        v.visit((TableBlock) node);
                        break;
                    case 1:
                        v.visit((TableHead) node);
                        break;
                    case 2:
                        v.visit((TableSeparator) node);
                        break;
                    case 3:
                        v.visit((TableBody) node);
                        break;
                    case 4:
                        v.visit((TableRow) node);
                        break;
                    case 5:
                        v.visit((TableCell) node);
                        break;
                    default:
                        v.visit((TableCaption) node);
                        break;
                }
            }
        }), new VisitHandler(TableSeparator.class, new Visitor() { // from class: com.vladsch.flexmark.ext.tables.b
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i4) {
                    case 0:
                        v.visit((TableBlock) node);
                        break;
                    case 1:
                        v.visit((TableHead) node);
                        break;
                    case 2:
                        v.visit((TableSeparator) node);
                        break;
                    case 3:
                        v.visit((TableBody) node);
                        break;
                    case 4:
                        v.visit((TableRow) node);
                        break;
                    case 5:
                        v.visit((TableCell) node);
                        break;
                    default:
                        v.visit((TableCaption) node);
                        break;
                }
            }
        }), new VisitHandler(TableBody.class, new Visitor() { // from class: com.vladsch.flexmark.ext.tables.b
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i5) {
                    case 0:
                        v.visit((TableBlock) node);
                        break;
                    case 1:
                        v.visit((TableHead) node);
                        break;
                    case 2:
                        v.visit((TableSeparator) node);
                        break;
                    case 3:
                        v.visit((TableBody) node);
                        break;
                    case 4:
                        v.visit((TableRow) node);
                        break;
                    case 5:
                        v.visit((TableCell) node);
                        break;
                    default:
                        v.visit((TableCaption) node);
                        break;
                }
            }
        }), new VisitHandler(TableRow.class, new Visitor() { // from class: com.vladsch.flexmark.ext.tables.b
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i6) {
                    case 0:
                        v.visit((TableBlock) node);
                        break;
                    case 1:
                        v.visit((TableHead) node);
                        break;
                    case 2:
                        v.visit((TableSeparator) node);
                        break;
                    case 3:
                        v.visit((TableBody) node);
                        break;
                    case 4:
                        v.visit((TableRow) node);
                        break;
                    case 5:
                        v.visit((TableCell) node);
                        break;
                    default:
                        v.visit((TableCaption) node);
                        break;
                }
            }
        }), new VisitHandler(TableCell.class, new Visitor() { // from class: com.vladsch.flexmark.ext.tables.b
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i7) {
                    case 0:
                        v.visit((TableBlock) node);
                        break;
                    case 1:
                        v.visit((TableHead) node);
                        break;
                    case 2:
                        v.visit((TableSeparator) node);
                        break;
                    case 3:
                        v.visit((TableBody) node);
                        break;
                    case 4:
                        v.visit((TableRow) node);
                        break;
                    case 5:
                        v.visit((TableCell) node);
                        break;
                    default:
                        v.visit((TableCaption) node);
                        break;
                }
            }
        }), new VisitHandler(TableCaption.class, new Visitor() { // from class: com.vladsch.flexmark.ext.tables.b
            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i8) {
                    case 0:
                        v.visit((TableBlock) node);
                        break;
                    case 1:
                        v.visit((TableHead) node);
                        break;
                    case 2:
                        v.visit((TableSeparator) node);
                        break;
                    case 3:
                        v.visit((TableBody) node);
                        break;
                    case 4:
                        v.visit((TableRow) node);
                        break;
                    case 5:
                        v.visit((TableCell) node);
                        break;
                    default:
                        v.visit((TableCaption) node);
                        break;
                }
            }
        })};
    }
}
