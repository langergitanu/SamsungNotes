package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKeyBase;
import com.vladsch.flexmark.util.misc.BitFieldSet;
import com.vladsch.flexmark.util.sequence.BasedOptionsHolder;
import java.util.stream.IntStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class BasedOptionsSequence implements CharSequence, BasedOptionsHolder {

    @NotNull
    private final CharSequence chars;
    private final int optionFlags;

    @Nullable
    private final DataHolder options;

    private BasedOptionsSequence(@NotNull CharSequence charSequence, int i, @Nullable DataHolder dataHolder) {
        this.chars = charSequence;
        this.optionFlags = (~((dataHolder == null || BasedOptionsHolder.SEGMENTED_STATS.get(dataHolder) == null) ? BasedOptionsHolder.F_COLLECT_SEGMENTED_STATS : 0)) & i;
        this.options = dataHolder;
    }

    /* JADX INFO: renamed from: of */
    public static BasedOptionsSequence m13435of(@NotNull CharSequence charSequence, BitFieldSet<BasedOptionsHolder.Options> bitFieldSet) {
        return new BasedOptionsSequence(charSequence, bitFieldSet.toInt(), null);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public boolean allOptions(int i) {
        return (this.optionFlags & i) == i;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public boolean anyOptions(int i) {
        return (i & this.optionFlags) != 0;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.chars.charAt(i);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return this.chars.chars();
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return this.chars.codePoints();
    }

    public boolean equals(Object obj) {
        return this.chars.equals(obj);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public <T> T getOption(DataKeyBase<T> dataKeyBase) {
        return dataKeyBase.get(this.options);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public int getOptionFlags() {
        return this.optionFlags;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    @Nullable
    public DataHolder getOptions() {
        return this.options;
    }

    public int hashCode() {
        return this.chars.hashCode();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.chars.length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.chars.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.chars.toString();
    }

    /* JADX INFO: renamed from: of */
    public static BasedOptionsSequence m13433of(@NotNull CharSequence charSequence, int i) {
        return new BasedOptionsSequence(charSequence, i, null);
    }

    /* JADX INFO: renamed from: of */
    public static BasedOptionsSequence m13436of(@NotNull CharSequence charSequence, BitFieldSet<BasedOptionsHolder.Options> bitFieldSet, @Nullable DataHolder dataHolder) {
        return new BasedOptionsSequence(charSequence, bitFieldSet.toInt(), dataHolder);
    }

    /* JADX INFO: renamed from: of */
    public static BasedOptionsSequence m13434of(@NotNull CharSequence charSequence, int i, @Nullable DataHolder dataHolder) {
        return new BasedOptionsSequence(charSequence, i, dataHolder);
    }
}
