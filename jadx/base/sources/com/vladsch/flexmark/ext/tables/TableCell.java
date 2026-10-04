package com.vladsch.flexmark.ext.tables;

import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.ast.WhiteSpace;
import com.vladsch.flexmark.ast.util.TextNodeConverter;
import com.vladsch.flexmark.util.ast.DelimitedNode;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.html.CellAlignment;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableCell extends Node implements DelimitedNode {
    private Alignment alignment;
    protected BasedSequence closingMarker;
    private boolean header;
    protected BasedSequence openingMarker;
    private int span;
    protected BasedSequence text;

    /* JADX INFO: renamed from: com.vladsch.flexmark.ext.tables.TableCell$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C117921 {
        static final /* synthetic */ int[] $SwitchMap$com$vladsch$flexmark$ext$tables$TableCell$Alignment;

        static {
            int[] iArr = new int[Alignment.values().length];
            $SwitchMap$com$vladsch$flexmark$ext$tables$TableCell$Alignment = iArr;
            try {
                iArr[Alignment.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$ext$tables$TableCell$Alignment[Alignment.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$ext$tables$TableCell$Alignment[Alignment.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Alignment {
        LEFT,
        CENTER,
        RIGHT;

        public CellAlignment cellAlignment() {
            int i = C117921.$SwitchMap$com$vladsch$flexmark$ext$tables$TableCell$Alignment[ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? CellAlignment.NONE : CellAlignment.RIGHT : CellAlignment.LEFT : CellAlignment.CENTER;
        }
    }

    public TableCell() {
        BasedSequence basedSequence = BasedSequence.NULL;
        this.openingMarker = basedSequence;
        this.text = basedSequence;
        this.closingMarker = basedSequence;
        this.span = 1;
    }

    public Alignment getAlignment() {
        return this.alignment;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    public void getAstExtra(@NotNull StringBuilder sb) {
        if (this.alignment != null) {
            sb.append(" ");
            sb.append(this.alignment);
        }
        if (this.header) {
            sb.append(" header");
        }
        int i = this.span;
        if (i > 1) {
            sb.append(" span=" + i);
        }
        Node.delimitedSegmentSpanChars(sb, this.openingMarker, this.text, this.closingMarker, "text");
    }

    @Override // com.vladsch.flexmark.util.ast.DelimitedNode
    public BasedSequence getClosingMarker() {
        return this.closingMarker;
    }

    @Override // com.vladsch.flexmark.util.ast.DelimitedNode
    public BasedSequence getOpeningMarker() {
        return this.openingMarker;
    }

    @Override // com.vladsch.flexmark.util.ast.Node
    @NotNull
    public BasedSequence[] getSegments() {
        return new BasedSequence[]{this.openingMarker, this.text, this.closingMarker};
    }

    public int getSpan() {
        return this.span;
    }

    @Override // com.vladsch.flexmark.util.ast.DelimitedNode
    public BasedSequence getText() {
        return this.text;
    }

    public boolean isHeader() {
        return this.header;
    }

    public void mergeWhiteSpace() {
        Node firstChild = getFirstChild();
        boolean z = false;
        while (firstChild instanceof WhiteSpace) {
            Node next = firstChild.getNext();
            firstChild.insertBefore(new Text(firstChild.getChars()));
            firstChild.unlink();
            firstChild = next;
            z = true;
        }
        Node lastChild = getLastChild();
        while (lastChild instanceof WhiteSpace) {
            Node previous = lastChild.getPrevious();
            lastChild.insertBefore(new Text(lastChild.getChars()));
            lastChild.unlink();
            lastChild = previous;
            z = true;
        }
        if (z) {
            TextNodeConverter.mergeTextNodes(this);
        }
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    @Override // com.vladsch.flexmark.util.ast.DelimitedNode
    public void setClosingMarker(BasedSequence basedSequence) {
        this.closingMarker = basedSequence;
    }

    public void setHeader(boolean z) {
        this.header = z;
    }

    @Override // com.vladsch.flexmark.util.ast.DelimitedNode
    public void setOpeningMarker(BasedSequence basedSequence) {
        this.openingMarker = basedSequence;
    }

    public void setSpan(int i) {
        this.span = i;
    }

    @Override // com.vladsch.flexmark.util.ast.DelimitedNode
    public void setText(BasedSequence basedSequence) {
        this.text = basedSequence;
    }

    public void trimWhiteSpace() {
        Node firstChild = getFirstChild();
        Node node = firstChild;
        while (node instanceof WhiteSpace) {
            Node next = node.getNext();
            node.unlink();
            node = next;
        }
        Node lastChild = getLastChild();
        while (lastChild instanceof WhiteSpace) {
            Node previous = lastChild.getPrevious();
            lastChild.unlink();
            lastChild = previous;
        }
        if (getFirstChild() != null || firstChild == null) {
            return;
        }
        appendChild(new Text(firstChild.getChars().subSequence(0, 1)));
    }

    public TableCell(BasedSequence basedSequence) {
        super(basedSequence);
        BasedSequence basedSequence2 = BasedSequence.NULL;
        this.openingMarker = basedSequence2;
        this.text = basedSequence2;
        this.closingMarker = basedSequence2;
        this.span = 1;
    }
}
