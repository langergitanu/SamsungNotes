package com.vladsch.flexmark.parser.core.delimiter;

import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.parser.delimiter.DelimiterRun;
import com.vladsch.flexmark.util.ast.DelimitedNode;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Delimiter implements DelimiterRun {
    private final boolean canClose;
    private final boolean canOpen;
    private final char delimiterChar;
    private int index;
    private final BasedSequence input;
    private Delimiter next;
    private final Text node;
    private Delimiter previous;
    private boolean matched = false;
    private int numDelims = 1;

    public Delimiter(BasedSequence basedSequence, Text text, char c, boolean z, boolean z2, Delimiter delimiter, int i) {
        this.input = basedSequence;
        this.node = text;
        this.delimiterChar = c;
        this.canOpen = z;
        this.canClose = z2;
        this.previous = delimiter;
        this.index = i;
    }

    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterRun
    public boolean canClose() {
        return this.canClose;
    }

    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterRun
    public boolean canOpen() {
        return this.canOpen;
    }

    public void convertDelimitersToText(int i, Delimiter delimiter) {
        Text text = new Text();
        text.setChars(getTailChars(i));
        Text text2 = new Text();
        text2.setChars(delimiter.getLeadChars(i));
        getNode().insertAfter(text);
        delimiter.getNode().insertBefore(text2);
    }

    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterRun
    public char getDelimiterChar() {
        return this.delimiterChar;
    }

    public int getEndIndex() {
        return this.index + this.numDelims;
    }

    public int getIndex() {
        return this.index;
    }

    public BasedSequence getInput() {
        return this.input;
    }

    public BasedSequence getLeadChars(int i) {
        return this.input.subSequence(getStartIndex(), getStartIndex() + i);
    }

    public Text getNextNonDelimiterTextNode() {
        Node next = this.node.getNext();
        if (!(next instanceof Text)) {
            return null;
        }
        Delimiter delimiter = this.next;
        if (delimiter == null || delimiter.node != next) {
            return (Text) next;
        }
        return null;
    }

    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterRun
    public Text getNode() {
        return this.node;
    }

    public int getNumDelims() {
        return this.numDelims;
    }

    public Text getPreviousNonDelimiterTextNode() {
        Node previous = this.node.getPrevious();
        if (!(previous instanceof Text)) {
            return null;
        }
        Delimiter delimiter = this.previous;
        if (delimiter == null || delimiter.node != previous) {
            return (Text) previous;
        }
        return null;
    }

    public int getStartIndex() {
        return this.index;
    }

    public BasedSequence getTailChars(int i) {
        return this.input.subSequence(getEndIndex() - i, getEndIndex());
    }

    public boolean isMatched() {
        return this.matched;
    }

    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterRun
    public int length() {
        return this.numDelims;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void moveNodesBetweenDelimitersTo(DelimitedNode delimitedNode, Delimiter delimiter) {
        Node next = getNode().getNext();
        while (next != null && next != delimiter.getNode()) {
            Node next2 = next.getNext();
            ((Node) delimitedNode).appendChild(next);
            next = next2;
        }
        delimitedNode.setText(this.input.subSequence(getEndIndex(), delimiter.getStartIndex()));
        getNode().insertAfter((Node) delimitedNode);
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setMatched(boolean z) {
        this.matched = z;
    }

    public void setNext(Delimiter delimiter) {
        this.next = delimiter;
    }

    public void setNumDelims(int i) {
        this.numDelims = i;
    }

    public void setPrevious(Delimiter delimiter) {
        this.previous = delimiter;
    }

    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterRun
    public Delimiter getNext() {
        return this.next;
    }

    @Override // com.vladsch.flexmark.parser.delimiter.DelimiterRun
    public Delimiter getPrevious() {
        return this.previous;
    }
}
