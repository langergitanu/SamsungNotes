package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import com.vladsch.flexmark.util.sequence.builder.RichSequenceBuilder;
import com.vladsch.flexmark.util.sequence.mappers.CharMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class RichSequenceImpl extends IRichSequenceBase<RichSequence> implements RichSequence {
    final CharSequence charSequence;

    private RichSequenceImpl(CharSequence charSequence) {
        super(charSequence instanceof String ? charSequence.hashCode() : 0);
        this.charSequence = charSequence;
    }

    public static RichSequence create(CharSequence charSequence, int i, int i2) {
        return charSequence instanceof RichSequence ? ((RichSequence) charSequence).subSequence(i, i2) : charSequence != null ? (i == 0 && i2 == charSequence.length()) ? new RichSequenceImpl(charSequence) : new RichSequenceImpl(charSequence.subSequence(i, i2)) : RichSequence.NULL;
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static RichSequence m13458of(CharSequence charSequence) {
        return RichSequence.m13457of(charSequence, 0, charSequence.length());
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        char cCharAt = this.charSequence.charAt(i);
        if (cCharAt == 0) {
            return (char) 65533;
        }
        return cCharAt;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public <B extends ISequenceBuilder<B, RichSequence>> B getBuilder() {
        return RichSequenceBuilder.emptyBuilder();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.charSequence.length();
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static RichSequence m13459of(CharSequence charSequence, int i) {
        return RichSequence.m13457of(charSequence, i, charSequence.length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public RichSequence[] emptyArray() {
        return RichSequence.EMPTY_ARRAY;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public RichSequence nullSequence() {
        return RichSequence.NULL;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public RichSequence sequenceOf(@Nullable CharSequence charSequence, int i, int i2) {
        return m13460of(charSequence, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public RichSequence toMapped(CharMapper charMapper) {
        return MappedRichSequence.mappedOf(charMapper, this);
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static RichSequence m13460of(CharSequence charSequence, int i, int i2) {
        return RichSequence.m13457of(charSequence, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence, java.lang.CharSequence
    @NotNull
    public RichSequence subSequence(int i, int i2) {
        SequenceUtils.validateStartEnd(i, i2, length());
        return (i == 0 && i2 == this.charSequence.length()) ? this : create(this.charSequence, i, i2);
    }
}
