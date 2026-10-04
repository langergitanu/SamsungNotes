package com.vladsch.flexmark.util.sequence.builder;

import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface IBasedSegmentBuilder<S extends IBasedSegmentBuilder<S>> extends ISegmentBuilder<S> {
    @NotNull
    BasedSequence getBaseSequence();

    @NotNull
    String toStringChars();

    @NotNull
    String toStringWithRanges();

    @NotNull
    String toStringWithRangesVisibleWhitespace();
}
