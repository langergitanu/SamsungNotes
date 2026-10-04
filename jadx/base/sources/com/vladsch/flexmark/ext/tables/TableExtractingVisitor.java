package com.vladsch.flexmark.ext.tables;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeVisitor;
import com.vladsch.flexmark.util.ast.VisitHandler;
import com.vladsch.flexmark.util.ast.Visitor;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.format.MarkdownTable;
import com.vladsch.flexmark.util.format.TableFormatOptions;
import com.vladsch.flexmark.util.html.CellAlignment;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableExtractingVisitor {
    private MarkdownTable myTable;
    private final List<MarkdownTable> myTables = new ArrayList();
    private final NodeVisitor myVisitor;
    private final TableFormatOptions options;

    public TableExtractingVisitor(DataHolder dataHolder) {
        final int i = 0;
        final int i2 = 1;
        final int i4 = 2;
        final int i5 = 3;
        final int i6 = 4;
        final int i7 = 5;
        final int i8 = 6;
        this.myVisitor = new NodeVisitor(new VisitHandler(TableBlock.class, new Visitor(this) { // from class: com.vladsch.flexmark.ext.tables.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableExtractingVisitor f8308b;

            {
                this.f8308b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i) {
                    case 0:
                        this.f8308b.visit((TableBlock) node);
                        break;
                    case 1:
                        this.f8308b.visit((TableHead) node);
                        break;
                    case 2:
                        this.f8308b.visit((TableSeparator) node);
                        break;
                    case 3:
                        this.f8308b.visit((TableBody) node);
                        break;
                    case 4:
                        this.f8308b.visit((TableRow) node);
                        break;
                    case 5:
                        this.f8308b.visit((TableCell) node);
                        break;
                    default:
                        this.f8308b.visit((TableCaption) node);
                        break;
                }
            }
        }), new VisitHandler(TableHead.class, new Visitor(this) { // from class: com.vladsch.flexmark.ext.tables.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableExtractingVisitor f8308b;

            {
                this.f8308b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i2) {
                    case 0:
                        this.f8308b.visit((TableBlock) node);
                        break;
                    case 1:
                        this.f8308b.visit((TableHead) node);
                        break;
                    case 2:
                        this.f8308b.visit((TableSeparator) node);
                        break;
                    case 3:
                        this.f8308b.visit((TableBody) node);
                        break;
                    case 4:
                        this.f8308b.visit((TableRow) node);
                        break;
                    case 5:
                        this.f8308b.visit((TableCell) node);
                        break;
                    default:
                        this.f8308b.visit((TableCaption) node);
                        break;
                }
            }
        }), new VisitHandler(TableSeparator.class, new Visitor(this) { // from class: com.vladsch.flexmark.ext.tables.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableExtractingVisitor f8308b;

            {
                this.f8308b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i4) {
                    case 0:
                        this.f8308b.visit((TableBlock) node);
                        break;
                    case 1:
                        this.f8308b.visit((TableHead) node);
                        break;
                    case 2:
                        this.f8308b.visit((TableSeparator) node);
                        break;
                    case 3:
                        this.f8308b.visit((TableBody) node);
                        break;
                    case 4:
                        this.f8308b.visit((TableRow) node);
                        break;
                    case 5:
                        this.f8308b.visit((TableCell) node);
                        break;
                    default:
                        this.f8308b.visit((TableCaption) node);
                        break;
                }
            }
        }), new VisitHandler(TableBody.class, new Visitor(this) { // from class: com.vladsch.flexmark.ext.tables.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableExtractingVisitor f8308b;

            {
                this.f8308b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i5) {
                    case 0:
                        this.f8308b.visit((TableBlock) node);
                        break;
                    case 1:
                        this.f8308b.visit((TableHead) node);
                        break;
                    case 2:
                        this.f8308b.visit((TableSeparator) node);
                        break;
                    case 3:
                        this.f8308b.visit((TableBody) node);
                        break;
                    case 4:
                        this.f8308b.visit((TableRow) node);
                        break;
                    case 5:
                        this.f8308b.visit((TableCell) node);
                        break;
                    default:
                        this.f8308b.visit((TableCaption) node);
                        break;
                }
            }
        }), new VisitHandler(TableRow.class, new Visitor(this) { // from class: com.vladsch.flexmark.ext.tables.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableExtractingVisitor f8308b;

            {
                this.f8308b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i6) {
                    case 0:
                        this.f8308b.visit((TableBlock) node);
                        break;
                    case 1:
                        this.f8308b.visit((TableHead) node);
                        break;
                    case 2:
                        this.f8308b.visit((TableSeparator) node);
                        break;
                    case 3:
                        this.f8308b.visit((TableBody) node);
                        break;
                    case 4:
                        this.f8308b.visit((TableRow) node);
                        break;
                    case 5:
                        this.f8308b.visit((TableCell) node);
                        break;
                    default:
                        this.f8308b.visit((TableCaption) node);
                        break;
                }
            }
        }), new VisitHandler(TableCell.class, new Visitor(this) { // from class: com.vladsch.flexmark.ext.tables.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableExtractingVisitor f8308b;

            {
                this.f8308b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i7) {
                    case 0:
                        this.f8308b.visit((TableBlock) node);
                        break;
                    case 1:
                        this.f8308b.visit((TableHead) node);
                        break;
                    case 2:
                        this.f8308b.visit((TableSeparator) node);
                        break;
                    case 3:
                        this.f8308b.visit((TableBody) node);
                        break;
                    case 4:
                        this.f8308b.visit((TableRow) node);
                        break;
                    case 5:
                        this.f8308b.visit((TableCell) node);
                        break;
                    default:
                        this.f8308b.visit((TableCaption) node);
                        break;
                }
            }
        }), new VisitHandler(TableCaption.class, new Visitor(this) { // from class: com.vladsch.flexmark.ext.tables.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TableExtractingVisitor f8308b;

            {
                this.f8308b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i8) {
                    case 0:
                        this.f8308b.visit((TableBlock) node);
                        break;
                    case 1:
                        this.f8308b.visit((TableHead) node);
                        break;
                    case 2:
                        this.f8308b.visit((TableSeparator) node);
                        break;
                    case 3:
                        this.f8308b.visit((TableBody) node);
                        break;
                    case 4:
                        this.f8308b.visit((TableRow) node);
                        break;
                    case 5:
                        this.f8308b.visit((TableCell) node);
                        break;
                    default:
                        this.f8308b.visit((TableCaption) node);
                        break;
                }
            }
        }));
        this.options = new TableFormatOptions(dataHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(TableBlock tableBlock) {
        this.myTable = new MarkdownTable(tableBlock.getChars(), this.options);
        this.myVisitor.visitChildren(tableBlock);
        this.myTables.add(this.myTable);
        this.myTable = null;
    }

    public MarkdownTable[] getTables(Node node) {
        this.myTable = null;
        this.myVisitor.visit(node);
        return (MarkdownTable[]) this.myTables.toArray(new MarkdownTable[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(TableHead tableHead) {
        this.myTable.setSeparator(false);
        this.myTable.setHeader(true);
        this.myVisitor.visitChildren(tableHead);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(TableSeparator tableSeparator) {
        this.myTable.setSeparator(true);
        this.myVisitor.visitChildren(tableSeparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(TableBody tableBody) {
        this.myTable.setSeparator(false);
        this.myTable.setHeader(false);
        this.myVisitor.visitChildren(tableBody);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(TableRow tableRow) {
        this.myVisitor.visitChildren(tableRow);
        if (this.myTable.isSeparator()) {
            return;
        }
        this.myTable.nextRow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(TableCaption tableCaption) {
        this.myTable.setCaptionWithMarkers(tableCaption, tableCaption.getOpeningMarker(), tableCaption.getText(), tableCaption.getClosingMarker());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(TableCell tableCell) {
        BasedSequence text = tableCell.getText();
        if (this.options.trimCellWhitespace) {
            if (text.isBlank() && !text.isEmpty()) {
                text = text.subSequence(0, 1);
            } else {
                text = text.trim();
            }
        }
        this.myTable.addCell(new com.vladsch.flexmark.util.format.TableCell(tableCell, tableCell.getOpeningMarker(), text, tableCell.getClosingMarker(), 1, tableCell.getSpan(), tableCell.getAlignment() == null ? CellAlignment.NONE : tableCell.getAlignment().cellAlignment()));
    }
}
