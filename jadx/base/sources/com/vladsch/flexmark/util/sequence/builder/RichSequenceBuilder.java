package com.vladsch.flexmark.util.sequence.builder;

import com.vladsch.flexmark.util.sequence.RichSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class RichSequenceBuilder implements ISequenceBuilder<RichSequenceBuilder, RichSequence> {
    private final StringBuilder segments;

    private RichSequenceBuilder() {
        this.segments = new StringBuilder();
    }

    @NotNull
    public static RichSequenceBuilder emptyBuilder() {
        return new RichSequenceBuilder();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    public char charAt(int i) {
        return this.segments.charAt(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    public int length() {
        return this.segments.length();
    }

    public String toString() {
        return this.segments.toString();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public RichSequenceBuilder getBuilder() {
        return new RichSequenceBuilder();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public RichSequence getSingleBasedSequence() {
        return toSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public RichSequence toSequence() {
        return RichSequence.m13455of(this.segments);
    }

    public RichSequenceBuilder(int i) {
        this.segments = new StringBuilder(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder, java.lang.Appendable
    @NotNull
    public RichSequenceBuilder append(@Nullable CharSequence charSequence, int i, int i2) {
        if (charSequence != null && charSequence.length() > 0 && i < i2) {
            this.segments.append(charSequence, i, i2);
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder, java.lang.Appendable
    @NotNull
    public RichSequenceBuilder append(char c) {
        this.segments.append(c);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public RichSequenceBuilder append(char c, int i) {
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
