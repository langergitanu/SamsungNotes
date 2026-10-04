package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.misc.BitFieldSet;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.Range;
import com.vladsch.flexmark.util.sequence.builder.BasedSegmentBuilder;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import com.vladsch.flexmark.util.sequence.builder.SegmentOptimizer;
import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SpaceInsertingSequenceBuilder implements ISequenceBuilder<SpaceInsertingSequenceBuilder, BasedSequence> {
    boolean addSpaces;
    final boolean addSpacesBetweenNodes;
    Node lastNode;
    boolean needEol;
    final SequenceBuilder out;

    private SpaceInsertingSequenceBuilder(SequenceBuilder sequenceBuilder, boolean z) {
        this.out = sequenceBuilder;
        this.addSpacesBetweenNodes = z;
    }

    @NotNull
    public static SpaceInsertingSequenceBuilder emptyBuilder(@NotNull BasedSequence basedSequence) {
        return new SpaceInsertingSequenceBuilder(SequenceBuilder.emptyBuilder(basedSequence), false);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public /* bridge */ /* synthetic */ ISequenceBuilder addAll(Iterable iterable) {
        return addAll((Iterable<? extends CharSequence>) iterable);
    }

    @NotNull
    public SpaceInsertingSequenceBuilder addByLength(int i, int i2) {
        return append(i, i2 + i);
    }

    @NotNull
    public SpaceInsertingSequenceBuilder addByOffsets(int i, int i2) {
        return append(i, i2);
    }

    @NotNull
    public SpaceInsertingSequenceBuilder addRange(@NotNull Range range) {
        return append(range.getStart(), range.getEnd());
    }

    public void appendEol() {
        append('\n');
        this.needEol = false;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    public char charAt(int i) {
        return this.out.charAt(i);
    }

    @NotNull
    public BasedSequence getBaseSequence() {
        return this.out.getBaseSequence();
    }

    public Node getLastNode() {
        return this.lastNode;
    }

    public SequenceBuilder getOut() {
        return this.out;
    }

    @NotNull
    public BasedSegmentBuilder getSegmentBuilder() {
        return this.out.getSegmentBuilder();
    }

    public boolean isNeedEol() {
        return this.needEol;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    public int length() {
        return this.out.length();
    }

    public boolean needEol() {
        boolean zTest;
        if (this.needEol) {
            return true;
        }
        for (int size = this.out.getSegmentBuilder().size(); size >= 0; size--) {
            Object part = this.out.getSegmentBuilder().getPart(size);
            if (part instanceof Range) {
                Range range = (Range) part;
                if (range.isNotNull()) {
                    BasedSequence basedSequenceSubSequence = getBaseSequence().subSequence(range.getStart(), range.getEnd());
                    if (basedSequenceSubSequence.length() > 0) {
                        zTest = CharPredicate.EOL.test(basedSequenceSubSequence.charAt(basedSequenceSubSequence.length() - 1));
                        return !zTest;
                    }
                } else {
                    continue;
                }
            } else {
                if (!(part instanceof CharSequence)) {
                    throw new IllegalStateException("Invalid part type ".concat(part.getClass().getSimpleName()));
                }
                CharSequence charSequence = (CharSequence) part;
                if (charSequence.length() > 0) {
                    zTest = CharPredicate.EOL.test(charSequence.charAt(charSequence.length() - 1));
                    return !zTest;
                }
            }
        }
        return false;
    }

    public boolean needSpace() {
        boolean zTest;
        for (int size = this.out.getSegmentBuilder().size(); size >= 0; size--) {
            Object part = this.out.getSegmentBuilder().getPart(size);
            if (part instanceof Range) {
                Range range = (Range) part;
                if (range.isNotNull()) {
                    BasedSequence basedSequenceSubSequence = getBaseSequence().subSequence(range.getStart(), range.getEnd());
                    if (basedSequenceSubSequence.length() > 0) {
                        zTest = CharPredicate.WHITESPACE.test(basedSequenceSubSequence.charAt(basedSequenceSubSequence.length() - 1));
                        return !zTest;
                    }
                } else {
                    continue;
                }
            } else {
                if (!(part instanceof CharSequence)) {
                    throw new IllegalStateException("Invalid part type ".concat(part.getClass().getSimpleName()));
                }
                CharSequence charSequence = (CharSequence) part;
                if (charSequence.length() > 0) {
                    zTest = CharPredicate.WHITESPACE.test(charSequence.charAt(charSequence.length() - 1));
                    return !zTest;
                }
            }
        }
        return false;
    }

    public void setLastNode(Node node) {
        if (node instanceof Document) {
            return;
        }
        Node node2 = this.lastNode;
        if (node2 != null && node2.getEndOffset() < node.getStartOffset()) {
            BasedSequence basedSequenceSubSequence = getBaseSequence().subSequence(this.lastNode.getEndOffset(), node.getStartOffset());
            this.needEol = basedSequenceSubSequence.trim(CharPredicate.SPACE_TAB).length() > 0 && basedSequenceSubSequence.trim(CharPredicate.WHITESPACE).isEmpty();
        }
        this.addSpaces = this.addSpacesBetweenNodes;
        this.lastNode = node;
    }

    public void setNeedEol(boolean z) {
        this.needEol = z;
    }

    public String toString() {
        return this.out.toString();
    }

    public String toStringNoAddedSpaces() {
        return this.out.toStringNoAddedSpaces();
    }

    @NotNull
    public String toStringWithRanges() {
        return this.out.toStringWithRanges();
    }

    @NotNull
    public static SpaceInsertingSequenceBuilder emptyBuilder(@NotNull BasedSequence basedSequence, @NotNull SegmentOptimizer segmentOptimizer) {
        return new SpaceInsertingSequenceBuilder(SequenceBuilder.emptyBuilder(basedSequence, segmentOptimizer), false);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public SpaceInsertingSequenceBuilder add(@Nullable CharSequence charSequence) {
        return append(charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public SpaceInsertingSequenceBuilder addAll(Iterable<? extends CharSequence> iterable) {
        return append(iterable);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public SpaceInsertingSequenceBuilder getBuilder() {
        return new SpaceInsertingSequenceBuilder(this.out.getBuilder(), this.addSpacesBetweenNodes);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @Nullable
    public BasedSequence getSingleBasedSequence() {
        return this.out.getSingleBasedSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public BasedSequence toSequence() {
        return this.out.toSequence();
    }

    @NotNull
    public static SpaceInsertingSequenceBuilder emptyBuilder(@NotNull BasedSequence basedSequence, int i) {
        return new SpaceInsertingSequenceBuilder(SequenceBuilder.emptyBuilder(basedSequence, i), BitFieldSet.any(i, TextContainer.F_ADD_SPACES_BETWEEN_NODES));
    }

    @NotNull
    public static SpaceInsertingSequenceBuilder emptyBuilder(@NotNull BasedSequence basedSequence, int i, @NotNull SegmentOptimizer segmentOptimizer) {
        return new SpaceInsertingSequenceBuilder(SequenceBuilder.emptyBuilder(basedSequence, i, segmentOptimizer), BitFieldSet.any(i, TextContainer.F_ADD_SPACES_BETWEEN_NODES));
    }

    @NotNull
    public static SpaceInsertingSequenceBuilder emptyBuilder(@NotNull SequenceBuilder sequenceBuilder) {
        return new SpaceInsertingSequenceBuilder(sequenceBuilder, false);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public /* bridge */ /* synthetic */ ISequenceBuilder append(Iterable iterable) {
        return append((Iterable<? extends CharSequence>) iterable);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder, java.lang.Appendable
    @NotNull
    public SpaceInsertingSequenceBuilder append(@Nullable CharSequence charSequence, int i, int i2) {
        if (this.addSpaces && charSequence != null && i < i2 && !CharPredicate.WHITESPACE.test(charSequence.charAt(i)) && needSpace()) {
            this.out.append(' ');
            this.addSpaces = false;
        }
        this.out.append(charSequence, i, i2);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder, java.lang.Appendable
    @NotNull
    public SpaceInsertingSequenceBuilder append(char c) {
        if (this.addSpaces && !CharPredicate.WHITESPACE.test(c) && needSpace()) {
            this.out.append(' ');
            this.addSpaces = false;
        }
        this.out.append(c);
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public SpaceInsertingSequenceBuilder append(char c, int i) {
        if (this.addSpaces && !CharPredicate.WHITESPACE.test(c) && needSpace()) {
            this.out.append(' ');
            this.addSpaces = false;
        }
        this.out.append(c, i);
        return this;
    }

    @NotNull
    public SpaceInsertingSequenceBuilder append(int i, int i2) {
        if (this.addSpaces && i < i2 && !CharPredicate.WHITESPACE.test(this.out.getBaseSequence().charAt(i)) && needSpace()) {
            this.out.append(' ');
            this.addSpaces = false;
        }
        this.out.append(i, i2);
        return this;
    }

    @NotNull
    public SpaceInsertingSequenceBuilder append(@NotNull Range range) {
        return append(range.getStart(), range.getEnd());
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public SpaceInsertingSequenceBuilder append(Iterable<? extends CharSequence> iterable) {
        Iterator<? extends CharSequence> it = iterable.iterator();
        while (it.hasNext()) {
            append(it.next());
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder, java.lang.Appendable
    @NotNull
    public SpaceInsertingSequenceBuilder append(@Nullable CharSequence charSequence) {
        return charSequence == null ? this : append(charSequence, 0, charSequence.length());
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder
    @NotNull
    public SpaceInsertingSequenceBuilder append(@Nullable CharSequence charSequence, int i) {
        return charSequence == null ? this : append(charSequence, i, charSequence.length());
    }
}
