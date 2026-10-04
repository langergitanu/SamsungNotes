package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKeyBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class CharSubSequence extends BasedSequenceImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final CharSubSequence base;
    private final char[] baseChars;
    private final int endOffset;
    private final int startOffset;

    private CharSubSequence(char[] cArr, int i) {
        super(i);
        int length = cArr.length;
        this.base = this;
        this.baseChars = cArr;
        this.startOffset = 0;
        this.endOffset = cArr.length;
    }

    /* JADX INFO: renamed from: of */
    public static CharSubSequence m13438of(CharSequence charSequence) {
        return m13440of(charSequence, 0, charSequence.length());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public boolean allOptions(int i) {
        return false;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public boolean anyOptions(int i) {
        return false;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        SequenceUtils.validateIndex(i, length());
        char c = this.baseChars[i + this.startOffset];
        if (c == 0) {
            return (char) 65533;
        }
        return c;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int getEndOffset() {
        return this.endOffset;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int getIndexOffset(int i) {
        SequenceUtils.validateIndexInclusiveEnd(i, length());
        return this.startOffset + i;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public <T> T getOption(DataKeyBase<T> dataKeyBase) {
        return dataKeyBase.get(null);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public int getOptionFlags() {
        return 0;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    @Nullable
    public DataHolder getOptions() {
        return null;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public Range getSourceRange() {
        return Range.m13451of(this.startOffset, this.endOffset);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int getStartOffset() {
        return this.startOffset;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.endOffset - this.startOffset;
    }

    /* JADX INFO: renamed from: of */
    public static CharSubSequence m13439of(CharSequence charSequence, int i) {
        return m13440of(charSequence, i, charSequence.length());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequenceImpl, com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public CharSubSequence baseSubSequence(int i, int i2) {
        SequenceUtils.validateStartEnd(i, i2, this.baseChars.length);
        if (i == this.startOffset && i2 == this.endOffset) {
            return this;
        }
        CharSubSequence charSubSequence = this.base;
        return charSubSequence != this ? charSubSequence.baseSubSequence(i, i2) : new CharSubSequence(charSubSequence, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public char[] getBase() {
        return this.baseChars;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public CharSubSequence getBaseSequence() {
        return this.base;
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static CharSubSequence m13441of(char[] cArr, int i, int i2) {
        char[] cArr2 = new char[cArr.length];
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
        return (i == 0 && i2 == cArr.length) ? new CharSubSequence(cArr2, 0) : new CharSubSequence(cArr2, 0).subSequence(i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence, java.lang.CharSequence
    @NotNull
    public CharSubSequence subSequence(int i, int i2) {
        SequenceUtils.validateStartEnd(i, i2, length());
        CharSubSequence charSubSequence = this.base;
        int i4 = this.startOffset;
        return charSubSequence.baseSubSequence(i + i4, i4 + i2);
    }

    /* JADX INFO: renamed from: of */
    private static CharSubSequence m13440of(CharSequence charSequence, int i, int i2) {
        CharSubSequence charSubSequence;
        if (charSequence instanceof CharSubSequence) {
            charSubSequence = (CharSubSequence) charSequence;
        } else if (charSequence instanceof String) {
            String str = (String) charSequence;
            charSubSequence = new CharSubSequence(str.toCharArray(), str.hashCode());
        } else if (charSequence instanceof StringBuilder) {
            StringBuilder sb = (StringBuilder) charSequence;
            char[] cArr = new char[sb.length()];
            sb.getChars(0, sb.length(), cArr, 0);
            charSubSequence = new CharSubSequence(cArr, 0);
        } else {
            charSubSequence = new CharSubSequence(charSequence.toString().toCharArray(), 0);
        }
        return (i == 0 && i2 == charSequence.length()) ? charSubSequence : charSubSequence.subSequence(i, i2);
    }

    private CharSubSequence(CharSubSequence charSubSequence, int i, int i2) {
        super(0);
        this.base = charSubSequence;
        this.baseChars = charSubSequence.baseChars;
        this.startOffset = charSubSequence.startOffset + i;
        this.endOffset = charSubSequence.startOffset + i2;
    }
}
