package com.vladsch.flexmark.util.sequence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TagRange extends Range {
    protected final String tag;

    public TagRange(CharSequence charSequence, Range range) {
        super(range);
        this.tag = String.valueOf(charSequence);
    }

    /* JADX INFO: renamed from: of */
    public static TagRange m13469of(CharSequence charSequence, int i, int i2) {
        return new TagRange(charSequence, i, i2);
    }

    public String getTag() {
        return this.tag;
    }

    public TagRange withTag(CharSequence charSequence) {
        return this.tag.equals(String.valueOf(charSequence)) ? this : new TagRange(charSequence, getStart(), getEnd());
    }

    @Override // com.vladsch.flexmark.util.sequence.Range
    public TagRange withEnd(int i) {
        return i == getEnd() ? this : new TagRange(getTag(), getStart(), i);
    }

    @Override // com.vladsch.flexmark.util.sequence.Range
    public TagRange withRange(int i, int i2) {
        return (i == getStart() && i2 == getEnd()) ? this : new TagRange(getTag(), i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.Range
    public TagRange withStart(int i) {
        return i == getStart() ? this : new TagRange(getTag(), i, getEnd());
    }

    public TagRange(CharSequence charSequence, int i, int i2) {
        super(i, i2);
        this.tag = String.valueOf(charSequence);
    }
}
