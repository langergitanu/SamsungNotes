package com.vladsch.flexmark.util.sequence.builder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class StringSequenceBuilder implements ISequenceBuilder<StringSequenceBuilder, CharSequence> {
    private final StringBuilder segments;

    private StringSequenceBuilder() {
        this.segments = new StringBuilder();
    }

    @NotNull
    public static StringSequenceBuilder emptyBuilder() {
        return new StringSequenceBuilder();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    public char charAt(int i) {
        return this.segments.charAt(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public CharSequence getSingleBasedSequence() {
        return toSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    public int length() {
        return this.segments.length();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public CharSequence toSequence() {
        return this.segments;
    }

    public String toString() {
        return this.segments.toString();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public StringSequenceBuilder getBuilder() {
        return new StringSequenceBuilder();
    }

    public StringSequenceBuilder(int i) {
        this.segments = new StringBuilder(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder, java.lang.Appendable
    @NotNull
    public StringSequenceBuilder append(@Nullable CharSequence charSequence, int i, int i2) {
        if (charSequence != null && charSequence.length() > 0 && i < i2) {
            this.segments.append(charSequence, i, i2);
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder, java.lang.Appendable
    @NotNull
    public StringSequenceBuilder append(char c) {
        this.segments.append(c);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public StringSequenceBuilder append(char c, int i) {
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return this;
            }
            this.segments.append(c);
            i = i2;
        }
    }
}
