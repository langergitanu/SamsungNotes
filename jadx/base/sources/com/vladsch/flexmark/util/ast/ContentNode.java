package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.SegmentedSequence;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ContentNode extends Node implements Content {
    protected List<BasedSequence> lineSegments;

    public ContentNode() {
        this.lineSegments = BasedSequence.EMPTY_LIST;
    }

    @Override // com.vladsch.flexmark.util.ast.Content
    @NotNull
    public BasedSequence getContentChars() {
        return this.lineSegments.isEmpty() ? BasedSequence.NULL : SegmentedSequence.create(this.lineSegments.get(0), this.lineSegments);
    }

    @Override // com.vladsch.flexmark.util.ast.Content
    @NotNull
    public List<BasedSequence> getContentLines() {
        return this.lineSegments;
    }

    @Override // com.vladsch.flexmark.util.ast.Content
    @NotNull
    public BasedSequence getLineChars(int i) {
        return this.lineSegments.get(i);
    }

    @Override // com.vladsch.flexmark.util.ast.Content
    public int getLineCount() {
        return this.lineSegments.size();
    }

    @Override // com.vladsch.flexmark.util.ast.Content
    @NotNull
    public BasedSequence getSpanningChars() {
        return getSpanningChars(this.lineSegments);
    }

    public void setContent(@NotNull BasedSequence basedSequence, @NotNull List<BasedSequence> list) {
        setChars(basedSequence);
        this.lineSegments = list;
    }

    public void setContentLine(int i, @NotNull BasedSequence basedSequence) {
        ArrayList arrayList = new ArrayList(this.lineSegments);
        arrayList.set(i, basedSequence);
        this.lineSegments = arrayList;
        setCharsFromContent();
    }

    public void setContentLines(@NotNull List<BasedSequence> list) {
        this.lineSegments = list;
    }

    @NotNull
    private static BasedSequence getSpanningChars(@NotNull List<BasedSequence> list) {
        return list.isEmpty() ? BasedSequence.NULL : list.get(0).baseSubSequence(list.get(0).getStartOffset(), ((BasedSequence) AbstractC0000a.m10g(list, 1)).getEndOffset());
    }

    @Override // com.vladsch.flexmark.util.ast.Content
    @NotNull
    public BasedSequence getContentChars(int i, int i2) {
        return this.lineSegments.isEmpty() ? BasedSequence.NULL : SegmentedSequence.create(this.lineSegments.get(0), getContentLines(i, i2));
    }

    @Override // com.vladsch.flexmark.util.ast.Content
    @NotNull
    public List<BasedSequence> getContentLines(int i, int i2) {
        return this.lineSegments.subList(i, i2);
    }

    public ContentNode(@NotNull BasedSequence basedSequence) {
        super(basedSequence);
        this.lineSegments = BasedSequence.EMPTY_LIST;
    }

    public void setContent(@NotNull List<BasedSequence> list) {
        this.lineSegments = list;
        setChars(getSpanningChars());
    }

    public ContentNode(@NotNull BasedSequence basedSequence, @NotNull List<BasedSequence> list) {
        super(basedSequence);
        BasedSequence basedSequence2 = BasedSequence.NULL;
        this.lineSegments = list;
    }

    public void setContent(@NotNull BlockContent blockContent) {
        setChars(blockContent.getSpanningChars());
        this.lineSegments = blockContent.getLines();
    }

    public ContentNode(@NotNull List<BasedSequence> list) {
        this(getSpanningChars(list), list);
    }

    public ContentNode(@NotNull BlockContent blockContent) {
        this(blockContent.getSpanningChars(), blockContent.getLines());
    }
}
