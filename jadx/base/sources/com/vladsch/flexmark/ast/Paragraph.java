package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeVisitor;
import com.vladsch.flexmark.util.ast.TextContainer;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Paragraph extends Block implements TextContainer {
    private static final int[] EMPTY_INDENTS = new int[0];
    private boolean hasTableSeparator;
    private int[] lineIndents;
    private boolean trailingBlankLine;

    public Paragraph() {
        this.lineIndents = EMPTY_INDENTS;
        this.trailingBlankLine = false;
    }

    @Override // com.vladsch.flexmark.util.ast.TextContainer
    public void collectEndText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> iSequenceBuilder, int i, NodeVisitor nodeVisitor) {
        if (this.trailingBlankLine) {
            iSequenceBuilder.add("\n");
        }
    }

    @Override // com.vladsch.flexmark.util.ast.TextContainer
    public boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> iSequenceBuilder, int i, NodeVisitor nodeVisitor) {
        return true;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        super.getAstExtra(sb);
        if (this.trailingBlankLine) {
            sb.append(" isTrailingBlankLine");
        }
    }

    public int getLineIndent(int i) {
        return this.lineIndents[i];
    }

    public int[] getLineIndents() {
        return this.lineIndents;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return Node.EMPTY_SEGMENTS;
    }

    public boolean hasTableSeparator() {
        return this.hasTableSeparator;
    }

    public boolean isTrailingBlankLine() {
        return this.trailingBlankLine;
    }

    @Override // com.vladsch.flexmark.util.ast.ContentNode
    public void setContent(@NotNull BasedSequence basedSequence, @NotNull List<BasedSequence> list) {
        super.setContent(basedSequence, list);
    }

    public void setHasTableSeparator(boolean z) {
        this.hasTableSeparator = z;
    }

    public void setLineIndents(List<Integer> list) {
        this.lineIndents = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            this.lineIndents[i] = it.next().intValue();
            i++;
        }
    }

    public void setTrailingBlankLine(boolean z) {
        this.trailingBlankLine = z;
    }

    public void setContent(BasedSequence basedSequence, List<BasedSequence> list, List<Integer> list2) {
        super.setContent(basedSequence, list);
        if (list.size() != list2.size()) {
            throw new IllegalArgumentException("line segments and line indents have to be of the same size");
        }
        setLineIndents(list2);
    }

    public Paragraph(BasedSequence basedSequence) {
        super(basedSequence);
        this.lineIndents = EMPTY_INDENTS;
        this.trailingBlankLine = false;
    }

    public void setLineIndents(int[] iArr) {
        this.lineIndents = iArr;
    }

    @Override // com.vladsch.flexmark.util.ast.ContentNode
    public void setContent(@NotNull List<BasedSequence> list) {
        super.setContent(list);
    }

    public Paragraph(BasedSequence basedSequence, List<BasedSequence> list, List<Integer> list2) {
        super(basedSequence, list);
        this.lineIndents = EMPTY_INDENTS;
        this.trailingBlankLine = false;
        if (list.size() == list2.size()) {
            setLineIndents(list2);
            return;
        }
        throw new IllegalArgumentException("line segments and line indents have to be of the same size");
    }

    @Override // com.vladsch.flexmark.util.ast.ContentNode
    public void setContent(@NotNull BlockContent blockContent) {
        super.setContent(blockContent);
        setLineIndents(blockContent.getLineIndents());
    }

    public void setContent(BlockContent blockContent, int i, int i2) {
        super.setContent(blockContent.getLines().subList(i, i2));
        setLineIndents(blockContent.getLineIndents().subList(i, i2));
    }

    public void setContent(Paragraph paragraph, int i, int i2) {
        super.setContent(paragraph.getContentLines(i, i2));
        if (i2 > i) {
            int i4 = i2 - i;
            int[] iArr = new int[i4];
            System.arraycopy(paragraph.lineIndents, i, iArr, 0, i4);
            this.lineIndents = iArr;
            return;
        }
        this.lineIndents = EMPTY_INDENTS;
    }

    public Paragraph(BasedSequence basedSequence, List<BasedSequence> list, int[] iArr) {
        super(basedSequence, list);
        this.lineIndents = EMPTY_INDENTS;
        this.trailingBlankLine = false;
        if (list.size() == iArr.length) {
            this.lineIndents = iArr;
            return;
        }
        throw new IllegalArgumentException("line segments and line indents have to be of the same size");
    }

    public Paragraph(BlockContent blockContent) {
        super(blockContent);
        this.lineIndents = EMPTY_INDENTS;
        this.trailingBlankLine = false;
        setLineIndents(blockContent.getLineIndents());
    }
}
