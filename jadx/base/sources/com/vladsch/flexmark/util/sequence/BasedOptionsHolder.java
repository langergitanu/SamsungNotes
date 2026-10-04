package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKeyBase;
import com.vladsch.flexmark.util.data.NullableDataKey;
import com.vladsch.flexmark.util.misc.BitFieldSet;
import com.vladsch.flexmark.util.sequence.builder.SegmentedSequenceStats;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface BasedOptionsHolder {
    public static final int F_APPLICATION_OPTIONS = -65536;
    public static final int F_COLLECT_FIRST256_STATS;
    public static final int F_COLLECT_SEGMENTED_STATS;
    public static final int F_FULL_SEGMENTED_SEQUENCES;
    public static final int F_LIBRARY_OPTIONS = 65535;
    public static final int F_NO_ANCHORS;
    public static final int F_TREE_SEGMENTED_SEQUENCES;
    public static final Options O_COLLECT_FIRST256_STATS;
    public static final Options O_COLLECT_SEGMENTED_STATS;
    public static final Options O_FULL_SEGMENTED_SEQUENCES;
    public static final Options O_NO_ANCHORS;
    public static final Options O_TREE_SEGMENTED_SEQUENCES;
    public static final NullableDataKey<SegmentedSequenceStats> SEGMENTED_STATS;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Options {
        COLLECT_SEGMENTED_STATS,
        COLLECT_FIRST256_STATS,
        NO_ANCHORS,
        FULL_SEGMENTED_SEQUENCES,
        TREE_SEGMENTED_SEQUENCES
    }

    static {
        Options options = Options.COLLECT_SEGMENTED_STATS;
        O_COLLECT_SEGMENTED_STATS = options;
        Options options2 = Options.COLLECT_FIRST256_STATS;
        O_COLLECT_FIRST256_STATS = options2;
        Options options3 = Options.NO_ANCHORS;
        O_NO_ANCHORS = options3;
        Options options4 = Options.FULL_SEGMENTED_SEQUENCES;
        O_FULL_SEGMENTED_SEQUENCES = options4;
        Options options5 = Options.TREE_SEGMENTED_SEQUENCES;
        O_TREE_SEGMENTED_SEQUENCES = options5;
        F_COLLECT_SEGMENTED_STATS = BitFieldSet.intMask(options);
        F_COLLECT_FIRST256_STATS = BitFieldSet.intMask(options2);
        F_NO_ANCHORS = BitFieldSet.intMask(options3);
        F_FULL_SEGMENTED_SEQUENCES = BitFieldSet.intMask(options4);
        F_TREE_SEGMENTED_SEQUENCES = BitFieldSet.intMask(options5);
        SEGMENTED_STATS = new NullableDataKey<>("SEGMENTED_STATS", (Object) null);
    }

    static String optionsToString(int i) {
        return BitFieldSet.m13383of(Options.class, i).toString();
    }

    boolean allOptions(int i);

    boolean anyOptions(int i);

    @Nullable
    <T> T getOption(DataKeyBase<T> dataKeyBase);

    int getOptionFlags();

    @Nullable
    DataHolder getOptions();
}
