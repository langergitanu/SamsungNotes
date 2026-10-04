package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.misc.BitField;
import com.vladsch.flexmark.util.misc.BitFieldSet;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface TextContainer {
    public static final int F_LINK_ANCHOR = 2;
    public static final int F_LINK_NODE_TEXT = 4;
    public static final int F_LINK_PAGE_REF = 1;
    public static final int F_LINK_TEXT = 0;
    public static final int F_LINK_URL = 3;
    public static final int F_LINK_TEXT_TYPE = BitFieldSet.intMask(Flags.LINK_TEXT_TYPE);
    public static final int F_NODE_TEXT = BitFieldSet.intMask(Flags.NODE_TEXT);
    public static final int F_FOR_HEADING_ID = BitFieldSet.intMask(Flags.FOR_HEADING_ID);
    public static final int F_NO_TRIM_REF_TEXT_START = BitFieldSet.intMask(Flags.NO_TRIM_REF_TEXT_START);
    public static final int F_NO_TRIM_REF_TEXT_END = BitFieldSet.intMask(Flags.NO_TRIM_REF_TEXT_END);
    public static final int F_ADD_SPACES_BETWEEN_NODES = BitFieldSet.intMask(Flags.ADD_SPACES_BETWEEN_NODES);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Flags implements BitField {
        LINK_TEXT_TYPE(3),
        NODE_TEXT,
        FOR_HEADING_ID,
        NO_TRIM_REF_TEXT_START,
        NO_TRIM_REF_TEXT_END,
        ADD_SPACES_BETWEEN_NODES;

        final int bits;

        Flags() {
            this(1);
        }

        @Override // com.vladsch.flexmark.util.misc.BitField
        public int getBits() {
            return this.bits;
        }

        Flags(int i) {
            this.bits = i;
        }
    }

    default void collectEndText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> iSequenceBuilder, int i, NodeVisitor nodeVisitor) {
    }

    boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> iSequenceBuilder, int i, NodeVisitor nodeVisitor);
}
