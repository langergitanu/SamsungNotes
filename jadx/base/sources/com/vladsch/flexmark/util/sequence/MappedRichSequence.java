package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import com.vladsch.flexmark.util.sequence.builder.RichSequenceBuilder;
import com.vladsch.flexmark.util.sequence.mappers.CharMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MappedRichSequence extends IRichSequenceBase<RichSequence> implements RichSequence, MappedSequence<RichSequence> {
    private final RichSequence base;
    private final CharMapper mapper;

    private MappedRichSequence(CharMapper charMapper, RichSequence richSequence) {
        super(0);
        this.base = richSequence;
        this.mapper = charMapper;
    }

    public static RichSequence mappedOf(CharMapper charMapper, RichSequence richSequence) {
        return mappedOf(charMapper, richSequence, 0, richSequence.length());
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.mapper.map(this.base.charAt(i));
    }

    public RichSequence getBaseSequence() {
        return this.base;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public <B extends ISequenceBuilder<B, RichSequence>> B getBuilder() {
        return RichSequenceBuilder.emptyBuilder();
    }

    @Override // com.vladsch.flexmark.util.sequence.MappedSequence
    @NotNull
    public CharMapper getCharMapper() {
        return this.mapper;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.base.length();
    }

    public static RichSequence mappedOf(CharMapper charMapper, RichSequence richSequence, int i) {
        return mappedOf(charMapper, richSequence, i, richSequence.length());
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public RichSequence[] emptyArray() {
        return this.base.emptyArray();
    }

    @Override // com.vladsch.flexmark.util.sequence.MappedSequence
    @NotNull
    public RichSequence getCharSequence() {
        return this.base;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public RichSequence nullSequence() {
        return this.base.nullSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public RichSequence sequenceOf(@Nullable CharSequence charSequence, int i, int i2) {
        return charSequence instanceof MappedRichSequence ? (i == 0 && i2 == charSequence.length()) ? (RichSequence) charSequence : ((RichSequence) charSequence).subSequence(i, i2).toMapped(this.mapper) : new MappedRichSequence(this.mapper, this.base.sequenceOf(charSequence, i, i2));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public RichSequence toMapped(CharMapper charMapper) {
        return charMapper == CharMapper.IDENTITY ? this : new MappedRichSequence(this.mapper.andThen(charMapper), this.base);
    }

    public static RichSequence mappedOf(CharMapper charMapper, RichSequence richSequence, int i, int i2) {
        if (!(richSequence instanceof MappedRichSequence)) {
            return new MappedRichSequence(charMapper, richSequence.subSequence(i, i2));
        }
        if (i != 0 || i2 != richSequence.length()) {
            richSequence = richSequence.subSequence(i, i2);
        }
        return richSequence.toMapped(charMapper);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence, java.lang.CharSequence
    @NotNull
    public RichSequence subSequence(int i, int i2) {
        RichSequence richSequenceSubSequence = this.base.subSequence(i, i2);
        return richSequenceSubSequence == this.base ? this : new MappedRichSequence(this.mapper, richSequenceSubSequence);
    }
}
