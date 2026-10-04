package com.vladsch.flexmark.util.sequence;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ReplacedTextMapper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private BasedSequence original;
    private ReplacedTextMapper parent;
    private ArrayList<ReplacedTextRegion> regions;
    private int replacedLength;
    private ArrayList<BasedSequence> replacedSegments;
    private BasedSequence replacedSequence;

    public ReplacedTextMapper(BasedSequence basedSequence) {
        this.regions = new ArrayList<>();
        this.replacedSegments = new ArrayList<>();
        this.replacedLength = 0;
        this.replacedSequence = null;
        this.original = basedSequence;
        this.parent = null;
    }

    private void finalizeMods() {
        if (this.replacedSequence == null) {
            this.replacedSequence = this.replacedSegments.isEmpty() ? BasedSequence.NULL : SegmentedSequence.create(this.original, this.replacedSegments);
        }
    }

    private int parentOriginalOffset(int i) {
        ReplacedTextMapper replacedTextMapper = this.parent;
        return replacedTextMapper != null ? replacedTextMapper.originalOffset(i) : i;
    }

    public void addOriginalText(int i, int i2) {
        if (isFinalized()) {
            throw new IllegalStateException("Cannot modify finalized ReplacedTextMapper");
        }
        if (i < i2) {
            BasedSequence basedSequenceSubSequence = this.original.subSequence(i, i2);
            ArrayList<ReplacedTextRegion> arrayList = this.regions;
            Range sourceRange = basedSequenceSubSequence.getSourceRange();
            Range rangeM13451of = Range.m13451of(i, i2);
            int i4 = this.replacedLength;
            arrayList.add(new ReplacedTextRegion(sourceRange, rangeM13451of, Range.m13451of(i4, basedSequenceSubSequence.length() + i4)));
            this.replacedLength = basedSequenceSubSequence.length() + this.replacedLength;
            this.replacedSegments.add(basedSequenceSubSequence);
        }
    }

    public void addReplacedText(int i, int i2, BasedSequence basedSequence) {
        if (isFinalized()) {
            throw new IllegalStateException("Cannot modify finalized ReplacedTextMapper");
        }
        ArrayList<ReplacedTextRegion> arrayList = this.regions;
        Range sourceRange = this.original.subSequence(i, i2).getSourceRange();
        Range rangeM13451of = Range.m13451of(i, i2);
        int i4 = this.replacedLength;
        arrayList.add(new ReplacedTextRegion(sourceRange, rangeM13451of, Range.m13451of(i4, basedSequence.length() + i4)));
        this.replacedLength = basedSequence.length() + this.replacedLength;
        this.replacedSegments.add(basedSequence);
    }

    public ReplacedTextMapper getParent() {
        return this.parent;
    }

    public ArrayList<ReplacedTextRegion> getRegions() {
        finalizeMods();
        return this.regions;
    }

    public int getReplacedLength() {
        finalizeMods();
        return this.replacedLength;
    }

    public ArrayList<BasedSequence> getReplacedSegments() {
        finalizeMods();
        return this.replacedSegments;
    }

    public BasedSequence getReplacedSequence() {
        finalizeMods();
        return this.replacedSequence;
    }

    public boolean isFinalized() {
        return this.replacedSequence != null;
    }

    public boolean isModified() {
        return this.replacedLength > 0;
    }

    public int originalOffset(int i) {
        finalizeMods();
        if (this.regions.isEmpty()) {
            return parentOriginalOffset(i);
        }
        if (i == this.replacedLength) {
            return parentOriginalOffset(this.original.length());
        }
        Iterator<ReplacedTextRegion> it = this.regions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ReplacedTextRegion next = it.next();
            if (next.containsReplacedIndex(i)) {
                i = (next.getOriginalRange().getStart() + i) - next.getReplacedRange().getStart();
                if (i > next.getOriginalRange().getEnd()) {
                    i = next.getOriginalRange().getEnd();
                }
            }
        }
        return parentOriginalOffset(i);
    }

    public void startNestedReplacement(BasedSequence basedSequence) {
        this.parent = new ReplacedTextMapper(this);
        this.original = basedSequence;
        this.regions = new ArrayList<>();
        this.replacedSegments = new ArrayList<>();
        this.replacedLength = 0;
        this.replacedSequence = null;
    }

    private ReplacedTextMapper(ReplacedTextMapper replacedTextMapper) {
        this.regions = new ArrayList<>();
        this.replacedSegments = new ArrayList<>();
        this.replacedLength = 0;
        this.replacedSequence = null;
        this.parent = replacedTextMapper.parent;
        this.original = replacedTextMapper.original;
        this.regions = replacedTextMapper.regions;
        this.replacedSegments = replacedTextMapper.replacedSegments;
        this.replacedLength = replacedTextMapper.replacedLength;
        this.replacedSequence = replacedTextMapper.getReplacedSequence();
    }
}
