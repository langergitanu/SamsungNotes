package com.vladsch.flexmark.util.sequence.builder;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PlainSegmentBuilder extends SegmentBuilderBase<PlainSegmentBuilder> {
    public PlainSegmentBuilder() {
    }

    @NotNull
    public static PlainSegmentBuilder emptyBuilder() {
        return new PlainSegmentBuilder();
    }

    public PlainSegmentBuilder(int i) {
        super(i);
    }

    @NotNull
    public static PlainSegmentBuilder emptyBuilder(int i) {
        return new PlainSegmentBuilder(i);
    }
}
