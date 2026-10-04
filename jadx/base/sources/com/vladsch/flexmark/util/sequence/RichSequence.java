package com.vladsch.flexmark.util.sequence;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface RichSequence extends IRichSequence<RichSequence> {
    public static final RichSequence NULL = RichSequenceImpl.create("", 0, 0);
    public static final RichSequence[] EMPTY_ARRAY = new RichSequence[0];

    /* JADX INFO: renamed from: of */
    static RichSequence m13455of(CharSequence charSequence) {
        return RichSequenceImpl.create(charSequence, 0, charSequence.length());
    }

    @NotNull
    static RichSequence ofSpaces(int i) {
        return m13455of(RepeatedSequence.ofSpaces(i));
    }

    @NotNull
    static RichSequence repeatOf(char c, int i) {
        return m13455of(RepeatedSequence.repeatOf(String.valueOf(c), 0, i));
    }

    /* JADX INFO: renamed from: of */
    static RichSequence m13456of(CharSequence charSequence, int i) {
        return RichSequenceImpl.create(charSequence, i, charSequence.length());
    }

    @NotNull
    static RichSequence repeatOf(@NotNull CharSequence charSequence, int i) {
        return m13455of(RepeatedSequence.repeatOf(charSequence, 0, charSequence.length() * i));
    }

    /* JADX INFO: renamed from: of */
    static RichSequence m13457of(CharSequence charSequence, int i, int i2) {
        return RichSequenceImpl.create(charSequence, i, i2);
    }

    @NotNull
    static RichSequence repeatOf(@NotNull CharSequence charSequence, int i, int i2) {
        return m13455of(RepeatedSequence.repeatOf(charSequence, i, i2));
    }
}
