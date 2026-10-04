package com.vladsch.flexmark.ast.util;

import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import com.vladsch.flexmark.ast.HardLineBreak;
import com.vladsch.flexmark.ast.HtmlEntity;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.ast.SoftLineBreak;
import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.ast.TextBase;
import com.vladsch.flexmark.util.ast.DoNotCollectText;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeVisitor;
import com.vladsch.flexmark.util.ast.VisitHandler;
import com.vladsch.flexmark.util.ast.Visitor;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.function.BiConsumer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class TextCollectingVisitor {
    final HashSet<Class<?>> myLineBreakNodes;
    private final NodeVisitor myVisitor;
    SequenceBuilder out;

    public TextCollectingVisitor(Class<?>... clsArr) {
        this.myLineBreakNodes = clsArr.length == 0 ? null : new HashSet<>(Arrays.asList(clsArr));
        final int i = 0;
        final int i2 = 1;
        final int i4 = 2;
        final int i5 = 3;
        final int i6 = 4;
        final int i7 = 5;
        this.myVisitor = new NodeVisitor(new VisitHandler(Text.class, new Visitor(this) { // from class: com.vladsch.flexmark.ast.util.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TextCollectingVisitor f8291b;

            {
                this.f8291b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i) {
                    case 0:
                        this.f8291b.visit((Text) node);
                        break;
                    case 1:
                        this.f8291b.visit((TextBase) node);
                        break;
                    case 2:
                        this.f8291b.visit((HtmlEntity) node);
                        break;
                    case 3:
                        this.f8291b.visit((SoftLineBreak) node);
                        break;
                    case 4:
                        this.f8291b.visit((Paragraph) node);
                        break;
                    default:
                        this.f8291b.visit((HardLineBreak) node);
                        break;
                }
            }
        }), new VisitHandler(TextBase.class, new Visitor(this) { // from class: com.vladsch.flexmark.ast.util.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TextCollectingVisitor f8291b;

            {
                this.f8291b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i2) {
                    case 0:
                        this.f8291b.visit((Text) node);
                        break;
                    case 1:
                        this.f8291b.visit((TextBase) node);
                        break;
                    case 2:
                        this.f8291b.visit((HtmlEntity) node);
                        break;
                    case 3:
                        this.f8291b.visit((SoftLineBreak) node);
                        break;
                    case 4:
                        this.f8291b.visit((Paragraph) node);
                        break;
                    default:
                        this.f8291b.visit((HardLineBreak) node);
                        break;
                }
            }
        }), new VisitHandler(HtmlEntity.class, new Visitor(this) { // from class: com.vladsch.flexmark.ast.util.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TextCollectingVisitor f8291b;

            {
                this.f8291b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i4) {
                    case 0:
                        this.f8291b.visit((Text) node);
                        break;
                    case 1:
                        this.f8291b.visit((TextBase) node);
                        break;
                    case 2:
                        this.f8291b.visit((HtmlEntity) node);
                        break;
                    case 3:
                        this.f8291b.visit((SoftLineBreak) node);
                        break;
                    case 4:
                        this.f8291b.visit((Paragraph) node);
                        break;
                    default:
                        this.f8291b.visit((HardLineBreak) node);
                        break;
                }
            }
        }), new VisitHandler(SoftLineBreak.class, new Visitor(this) { // from class: com.vladsch.flexmark.ast.util.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TextCollectingVisitor f8291b;

            {
                this.f8291b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i5) {
                    case 0:
                        this.f8291b.visit((Text) node);
                        break;
                    case 1:
                        this.f8291b.visit((TextBase) node);
                        break;
                    case 2:
                        this.f8291b.visit((HtmlEntity) node);
                        break;
                    case 3:
                        this.f8291b.visit((SoftLineBreak) node);
                        break;
                    case 4:
                        this.f8291b.visit((Paragraph) node);
                        break;
                    default:
                        this.f8291b.visit((HardLineBreak) node);
                        break;
                }
            }
        }), new VisitHandler(Paragraph.class, new Visitor(this) { // from class: com.vladsch.flexmark.ast.util.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TextCollectingVisitor f8291b;

            {
                this.f8291b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i6) {
                    case 0:
                        this.f8291b.visit((Text) node);
                        break;
                    case 1:
                        this.f8291b.visit((TextBase) node);
                        break;
                    case 2:
                        this.f8291b.visit((HtmlEntity) node);
                        break;
                    case 3:
                        this.f8291b.visit((SoftLineBreak) node);
                        break;
                    case 4:
                        this.f8291b.visit((Paragraph) node);
                        break;
                    default:
                        this.f8291b.visit((HardLineBreak) node);
                        break;
                }
            }
        }), new VisitHandler(HardLineBreak.class, new Visitor(this) { // from class: com.vladsch.flexmark.ast.util.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TextCollectingVisitor f8291b;

            {
                this.f8291b = this;
            }

            @Override // com.vladsch.flexmark.util.ast.Visitor
            public final void visit(Node node) {
                switch (i7) {
                    case 0:
                        this.f8291b.visit((Text) node);
                        break;
                    case 1:
                        this.f8291b.visit((TextBase) node);
                        break;
                    case 2:
                        this.f8291b.visit((HtmlEntity) node);
                        break;
                    case 3:
                        this.f8291b.visit((SoftLineBreak) node);
                        break;
                    case 4:
                        this.f8291b.visit((Paragraph) node);
                        break;
                    default:
                        this.f8291b.visit((HardLineBreak) node);
                        break;
                }
            }
        })) { // from class: com.vladsch.flexmark.ast.util.TextCollectingVisitor.1
            @Override // com.vladsch.flexmark.util.visitor.AstActionHandler
            public /* bridge */ /* synthetic */ void processNode(@NotNull Node node, boolean z, @NotNull BiConsumer biConsumer) {
                processNode2(node, z, (BiConsumer<Node, Visitor<Node>>) biConsumer);
            }

            /* JADX INFO: renamed from: processNode, reason: avoid collision after fix types in other method */
            public void processNode2(@NotNull Node node, boolean z, @NotNull BiConsumer<Node, Visitor<Node>> biConsumer) {
                Visitor<Node> action = getAction(node);
                if (action != null) {
                    biConsumer.accept(node, action);
                    return;
                }
                processChildren(node, biConsumer);
                HashSet<Class<?>> hashSet = TextCollectingVisitor.this.myLineBreakNodes;
                if (hashSet == null || !hashSet.contains(node.getClass()) || node.isOrDescendantOfType(DoNotCollectText.class)) {
                    return;
                }
                TextCollectingVisitor.this.out.add("\n");
            }
        };
    }

    public static Class<?>[] concatArrays(Class<?>[]... clsArr) {
        int length = 0;
        for (Class<?>[] clsArr2 : clsArr) {
            length += clsArr2.length;
        }
        Class<?>[] clsArr3 = new Class[length];
        int length2 = 0;
        for (Class<?>[] clsArr4 : clsArr) {
            System.arraycopy(clsArr4, 0, clsArr3, length2, clsArr4.length);
            length2 += clsArr4.length;
        }
        return clsArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(Paragraph paragraph) {
        if (paragraph.isOrDescendantOfType(DoNotCollectText.class)) {
            return;
        }
        if (!this.out.isEmpty()) {
            this.out.add(MarkdownDocument.NEW_LINE);
        }
        this.myVisitor.visitChildren(paragraph);
    }

    public void collect(Node node) {
        this.out = SequenceBuilder.emptyBuilder(node.getChars());
        this.myVisitor.visit(node);
    }

    public BasedSequence collectAndGetSequence(Node node) {
        collect(node);
        return this.out.toSequence();
    }

    public String collectAndGetText(Node node) {
        collect(node);
        return this.out.toString();
    }

    public String getText() {
        return this.out.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(SoftLineBreak softLineBreak) {
        this.out.add(softLineBreak.getChars());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(HardLineBreak hardLineBreak) {
        BasedSequence chars = hardLineBreak.getChars();
        this.out.add(chars.subSequence(chars.length() - 1, chars.length()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(HtmlEntity htmlEntity) {
        this.out.add(htmlEntity.getChars().unescape());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(Text text) {
        if (text.isOrDescendantOfType(DoNotCollectText.class)) {
            return;
        }
        this.out.add(text.getChars());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visit(TextBase textBase) {
        this.out.add(textBase.getChars());
    }
}
