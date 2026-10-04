package com.vladsch.flexmark.util.ast;

import androidx.compose.runtime.AbstractC1974b;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.SegmentedSequence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BlockContent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ArrayList<Integer> lineIndents;
    private final ArrayList<BasedSequence> lines;

    public BlockContent() {
        this.lines = new ArrayList<>();
        this.lineIndents = new ArrayList<>();
    }

    public void add(@NotNull BasedSequence basedSequence, int i) {
        this.lines.add(basedSequence);
        this.lineIndents.add(Integer.valueOf(i));
    }

    public void addAll(@NotNull List<BasedSequence> list, List<Integer> list2) {
        this.lines.addAll(list);
        this.lineIndents.addAll(list2);
    }

    @NotNull
    public BasedSequence getContents() {
        return this.lines.size() == 0 ? BasedSequence.NULL : getContents(0, this.lines.size());
    }

    public int getEndOffset() {
        if (this.lines.size() > 0) {
            return ((BasedSequence) AbstractC1974b.m1313f(1, this.lines)).getEndOffset();
        }
        return -1;
    }

    @NotNull
    public BasedSequence getLine(int i) {
        return this.lines.get(i);
    }

    public int getLineCount() {
        return this.lines.size();
    }

    public int getLineIndent() {
        if (this.lines.size() > 0) {
            return this.lineIndents.get(0).intValue();
        }
        return 0;
    }

    @NotNull
    public List<Integer> getLineIndents() {
        return this.lineIndents;
    }

    @NotNull
    public List<BasedSequence> getLines() {
        return this.lines;
    }

    public int getSourceLength() {
        if (this.lines.size() > 0) {
            return ((BasedSequence) AbstractC1974b.m1313f(1, this.lines)).getEndOffset() - this.lines.get(0).getStartOffset();
        }
        return -1;
    }

    @NotNull
    public BasedSequence getSpanningChars() {
        return this.lines.size() > 0 ? this.lines.get(0).baseSubSequence(this.lines.get(0).getStartOffset(), ((BasedSequence) AbstractC1974b.m1313f(1, this.lines)).getEndOffset()) : BasedSequence.NULL;
    }

    public int getStartOffset() {
        if (this.lines.size() > 0) {
            return this.lines.get(0).getStartOffset();
        }
        return -1;
    }

    @NotNull
    public String getString() {
        if (this.lines.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<BasedSequence> it = this.lines.iterator();
        while (it.hasNext()) {
            sb.append((CharSequence) it.next().trimEOL());
            sb.append('\n');
        }
        return sb.toString();
    }

    public boolean hasSingleLine() {
        return this.lines.size() == 1;
    }

    @NotNull
    public BlockContent subContents(int i, int i2) {
        return new BlockContent(this, i, i2);
    }

    @NotNull
    public BasedSequence getContents(int i, int i2) {
        if (this.lines.size() == 0) {
            return BasedSequence.NULL;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("startLine must be at least 0");
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("endLine must be at least 0");
        }
        if (i2 >= i) {
            if (i2 <= this.lines.size()) {
                return SegmentedSequence.create(this.lines.get(0), this.lines.subList(i, i2));
            }
            throw new IndexOutOfBoundsException("endLine must not be greater than line cardinality");
        }
        throw new IndexOutOfBoundsException("endLine must not be less than startLine");
    }

    public BlockContent(@NotNull BlockContent blockContent, int i, int i2) {
        ArrayList<BasedSequence> arrayList = new ArrayList<>();
        this.lines = arrayList;
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        this.lineIndents = arrayList2;
        if (blockContent.lines.size() <= 0 || i >= i2) {
            return;
        }
        arrayList.addAll(blockContent.lines.subList(i, i2));
        arrayList2.addAll(blockContent.lineIndents.subList(i, i2));
    }
}
