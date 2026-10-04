package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.ast.HardLineBreak;
import com.vladsch.flexmark.ast.HtmlEntity;
import com.vladsch.flexmark.ast.HtmlInline;
import com.vladsch.flexmark.ast.SoftLineBreak;
import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.ast.TextBase;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeVisitor;
import com.vladsch.flexmark.util.ast.VisitHandler;
import com.vladsch.flexmark.util.ast.Visitor;
import com.vladsch.flexmark.util.sequence.Range;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LineCollectingVisitor {
    private List<Integer> myEOLs;
    private int myEndOffset;
    private List<Range> myLines = Collections.EMPTY_LIST;
    private int myStartOffset;
    private final NodeVisitor myVisitor;

    public LineCollectingVisitor() {
        final int i = 0;
        final int i2 = 1;
        final int i4 = 2;
        final int i5 = 3;
        final int i6 = 4;
        final int i7 = 5;
        this.myVisitor = new NodeVisitor(new VisitHandler(Text.class, new Visitor(this) { // from class: com.vladsch.flexmark.ast.util.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ LineCollectingVisitor f8284b;

            {
                this.f8284b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i) {
                    case 0:
                        this.f8284b.visit((Text) node);
                        break;
                    case 1:
                        this.f8284b.visit((TextBase) node);
                        break;
                    case 2:
                        this.f8284b.visit((HtmlEntity) node);
                        break;
                    case 3:
                        this.f8284b.visit((HtmlInline) node);
                        break;
                    case 4:
                        this.f8284b.visit((SoftLineBreak) node);
                        break;
                    default:
                        this.f8284b.visit((HardLineBreak) node);
                        break;
                }
            }
        }), new VisitHandler(TextBase.class, new Visitor(this) { // from class: com.vladsch.flexmark.ast.util.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ LineCollectingVisitor f8284b;

            {
                this.f8284b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i2) {
                    case 0:
                        this.f8284b.visit((Text) node);
                        break;
                    case 1:
                        this.f8284b.visit((TextBase) node);
                        break;
                    case 2:
                        this.f8284b.visit((HtmlEntity) node);
                        break;
                    case 3:
                        this.f8284b.visit((HtmlInline) node);
                        break;
                    case 4:
                        this.f8284b.visit((SoftLineBreak) node);
                        break;
                    default:
                        this.f8284b.visit((HardLineBreak) node);
                        break;
                }
            }
        }), new VisitHandler(HtmlEntity.class, new Visitor(this) { // from class: com.vladsch.flexmark.ast.util.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ LineCollectingVisitor f8284b;

            {
                this.f8284b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i4) {
                    case 0:
                        this.f8284b.visit((Text) node);
                        break;
                    case 1:
                        this.f8284b.visit((TextBase) node);
                        break;
                    case 2:
                        this.f8284b.visit((HtmlEntity) node);
                        break;
                    case 3:
                        this.f8284b.visit((HtmlInline) node);
                        break;
                    case 4:
                        this.f8284b.visit((SoftLineBreak) node);
                        break;
                    default:
                        this.f8284b.visit((HardLineBreak) node);
                        break;
                }
            }
        }), new VisitHandler(HtmlInline.class, new Visitor(this) { // from class: com.vladsch.flexmark.ast.util.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ LineCollectingVisitor f8284b;

            {
                this.f8284b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i5) {
                    case 0:
                        this.f8284b.visit((Text) node);
                        break;
                    case 1:
                        this.f8284b.visit((TextBase) node);
                        break;
                    case 2:
                        this.f8284b.visit((HtmlEntity) node);
                        break;
                    case 3:
                        this.f8284b.visit((HtmlInline) node);
                        break;
                    case 4:
                        this.f8284b.visit((SoftLineBreak) node);
                        break;
                    default:
                        this.f8284b.visit((HardLineBreak) node);
                        break;
                }
            }
        }), new VisitHandler(SoftLineBreak.class, new Visitor(this) { // from class: com.vladsch.flexmark.ast.util.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ LineCollectingVisitor f8284b;

            {
                this.f8284b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i6) {
                    case 0:
                        this.f8284b.visit((Text) node);
                        break;
                    case 1:
                        this.f8284b.visit((TextBase) node);
                        break;
                    case 2:
                        this.f8284b.visit((HtmlEntity) node);
                        break;
                    case 3:
                        this.f8284b.visit((HtmlInline) node);
                        break;
                    case 4:
                        this.f8284b.visit((SoftLineBreak) node);
                        break;
                    default:
                        this.f8284b.visit((HardLineBreak) node);
                        break;
                }
            }
        }), new VisitHandler(HardLineBreak.class, new Visitor(this) { // from class: com.vladsch.flexmark.ast.util.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ LineCollectingVisitor f8284b;

            {
                this.f8284b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i7) {
                    case 0:
                        this.f8284b.visit((Text) node);
                        break;
                    case 1:
                        this.f8284b.visit((TextBase) node);
                        break;
                    case 2:
                        this.f8284b.visit((HtmlEntity) node);
                        break;
                    case 3:
                        this.f8284b.visit((HtmlInline) node);
                        break;
                    case 4:
                        this.f8284b.visit((SoftLineBreak) node);
                        break;
                    default:
                        this.f8284b.visit((HardLineBreak) node);
                        break;
                }
            }
        }));
    }

    private void finalizeLines() {
        int i = this.myStartOffset;
        int i2 = this.myEndOffset;
        if (i < i2) {
            this.myLines.add(Range.m13451of(i, i2));
            this.myEOLs.add(0);
            this.myStartOffset = this.myEndOffset;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(SoftLineBreak softLineBreak) {
        this.myLines.add(Range.m13451of(this.myStartOffset, softLineBreak.getEndOffset()));
        this.myEOLs.add(Integer.valueOf(softLineBreak.getTextLength()));
        this.myStartOffset = softLineBreak.getEndOffset();
    }

    public void collect(Node node) {
        this.myLines = new ArrayList();
        this.myEOLs = new ArrayList();
        this.myStartOffset = node.getStartOffset();
        this.myEndOffset = node.getEndOffset();
        this.myVisitor.visit(node);
    }

    public List<Range> collectAndGetRanges(Node node) {
        collect(node);
        return getLines();
    }

    public List<Integer> getEOLs() {
        finalizeLines();
        return this.myEOLs;
    }

    public List<Range> getLines() {
        finalizeLines();
        return this.myLines;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(HardLineBreak hardLineBreak) {
        this.myLines.add(Range.m13451of(this.myStartOffset, hardLineBreak.getEndOffset()));
        this.myEOLs.add(Integer.valueOf(hardLineBreak.getTextLength()));
        this.myStartOffset = hardLineBreak.getEndOffset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(HtmlEntity htmlEntity) {
        this.myEndOffset = htmlEntity.getEndOffset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(HtmlInline htmlInline) {
        this.myEndOffset = htmlInline.getEndOffset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(Text text) {
        this.myEndOffset = text.getEndOffset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(TextBase textBase) {
        this.myEndOffset = textBase.getEndOffset();
    }
}
