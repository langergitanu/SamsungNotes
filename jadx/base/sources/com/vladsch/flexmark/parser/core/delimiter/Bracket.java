package com.vladsch.flexmark.parser.core.delimiter;

import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.util.sequence.BasedSequence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Bracket {
    private boolean allowed = true;
    private boolean bracketAfter = false;
    private final boolean image;
    private final int index;
    private final Text node;
    private final Bracket previous;
    private final Delimiter previousDelimiter;

    private Bracket(BasedSequence basedSequence, Text text, int i, Bracket bracket, Delimiter delimiter, boolean z) {
        this.node = text;
        this.index = i;
        this.image = z;
        this.previous = bracket;
        this.previousDelimiter = delimiter;
    }

    public static Bracket image(BasedSequence basedSequence, Text text, int i, Bracket bracket, Delimiter delimiter) {
        return new Bracket(basedSequence, text, i, bracket, delimiter, true);
    }

    public static Bracket link(BasedSequence basedSequence, Text text, int i, Bracket bracket, Delimiter delimiter) {
        return new Bracket(basedSequence, text, i, bracket, delimiter, false);
    }

    public int getEndIndex() {
        return this.image ? this.index + 2 : this.index + 1;
    }

    public Text getNode() {
        return this.node;
    }

    public Bracket getPrevious() {
        return this.previous;
    }

    public Delimiter getPreviousDelimiter() {
        return this.previousDelimiter;
    }

    public int getStartIndex() {
        return this.index;
    }

    public boolean isAllowed() {
        return this.allowed;
    }

    public boolean isBracketAfter() {
        return this.bracketAfter;
    }

    public boolean isImage() {
        return this.image;
    }

    public boolean isStraddling(BasedSequence basedSequence) {
        int startOffset = basedSequence.getStartOffset();
        int endOffset = basedSequence.getEndOffset();
        Delimiter delimiter = this.previousDelimiter;
        for (Delimiter next = delimiter == null ? null : delimiter.getNext(); next != null; next = next.getNext()) {
            int endIndex = next.getEndIndex();
            if (endIndex >= endOffset) {
                return false;
            }
            if (endIndex >= startOffset && !next.isMatched()) {
                return true;
            }
        }
        return false;
    }

    public void setAllowed(boolean z) {
        this.allowed = z;
    }

    public void setBracketAfter(boolean z) {
        this.bracketAfter = z;
    }
}
