package com.vladsch.flexmark.util.format;

import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.LineAppendable;
import com.vladsch.flexmark.util.sequence.LineInfo;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
import com.vladsch.flexmark.util.sequence.builder.tree.BasedOffsetTracker;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TrackedOffsetUtils {
    /* JADX WARN: Removed duplicated region for block: B:23:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void resolveTrackedOffsets(BasedSequence basedSequence, LineAppendable lineAppendable, List<TrackedOffset> list, int i, boolean z) {
        if (list.isEmpty()) {
            return;
        }
        TrackedOffsetList trackedOffsetListCreate = TrackedOffsetList.create(basedSequence, list);
        int size = trackedOffsetListCreate.size();
        ISequenceBuilder<?, ?> builder = lineAppendable.getBuilder();
        BasedSequence baseSequence = builder instanceof SequenceBuilder ? ((SequenceBuilder) builder).getBaseSequence() : basedSequence.getBaseSequence();
        int length = 0;
        for (LineInfo lineInfo : lineAppendable.getLinesInfo(i, 0, lineAppendable.getLineCount())) {
            BasedSequence line = lineInfo.getLine();
            TrackedOffsetList trackedOffsets = trackedOffsetListCreate.getTrackedOffsets(line.getStartOffset(), line.getEndOffset());
            if (!trackedOffsets.isEmpty()) {
                for (TrackedOffset trackedOffset : trackedOffsets) {
                    BasedOffsetTracker basedOffsetTrackerCreate = BasedOffsetTracker.create(line);
                    if (!trackedOffset.isResolved()) {
                        int offset = trackedOffset.getOffset();
                        CharPredicate charPredicate = CharPredicate.WHITESPACE;
                        boolean zIsCharAt = baseSequence.isCharAt(offset, charPredicate);
                        if (zIsCharAt) {
                            int i2 = offset - 1;
                            if (!baseSequence.isCharAt(i2, charPredicate)) {
                                trackedOffset.setIndex(basedOffsetTrackerCreate.getOffsetInfo(i2, false).endIndex + length);
                            } else if (zIsCharAt || !baseSequence.isCharAt(offset + 1, charPredicate)) {
                                trackedOffset.setIndex(basedOffsetTrackerCreate.getOffsetInfo(offset, true).endIndex + length);
                            } else {
                                trackedOffset.setIndex(basedOffsetTrackerCreate.getOffsetInfo(offset, false).startIndex + length);
                            }
                            if (z) {
                                System.out.println(String.format("Resolved %d to %d, start: %d, in line[%d]: '%s'", Integer.valueOf(offset), Integer.valueOf(trackedOffset.getIndex()), Integer.valueOf(length), Integer.valueOf(lineInfo.index), line.getBuilder().append((CharSequence) line).toStringWithRanges(true)));
                            }
                            size--;
                        }
                    }
                }
            }
            length += line.length();
            if (size <= 0) {
                return;
            }
        }
    }
}
