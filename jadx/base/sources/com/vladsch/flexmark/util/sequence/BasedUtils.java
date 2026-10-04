package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface BasedUtils {

    /* JADX INFO: renamed from: com.vladsch.flexmark.util.sequence.BasedUtils$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C118721 {
        static final /* synthetic */ boolean $assertionsDisabled = false;
    }

    static BasedSequence asBased(CharSequence charSequence) {
        return BasedSequence.m13437of(charSequence);
    }

    static void generateSegments(IBasedSegmentBuilder<?> iBasedSegmentBuilder, @NotNull BasedSequence basedSequence) {
        boolean z;
        int length = basedSequence.length();
        int i = 0;
        int i2 = -1;
        int i4 = -1;
        boolean z2 = false;
        StringBuilder sb = null;
        while (true) {
            z = true;
            if (i >= length) {
                break;
            }
            int indexOffset = basedSequence.getIndexOffset(i);
            if (indexOffset >= 0) {
                if (i2 != -1) {
                    int i5 = i4 + 1;
                    if (indexOffset > i5) {
                        iBasedSegmentBuilder.append(i2, i5);
                    }
                    i4 = indexOffset;
                } else if (sb != null) {
                    if (!z2) {
                        iBasedSegmentBuilder.appendAnchor(basedSequence.getStartOffset());
                        z2 = true;
                    }
                    iBasedSegmentBuilder.append(sb.toString());
                    sb = null;
                }
                i2 = indexOffset;
                i4 = indexOffset;
            } else {
                if (i2 != -1) {
                    iBasedSegmentBuilder.append(i2, i4 + 1);
                    i2 = -1;
                    i4 = -1;
                    z2 = true;
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(basedSequence.charAt(i));
            }
            i++;
        }
        if (i2 != -1) {
            iBasedSegmentBuilder.append(i2, i4 + 1);
            z2 = true;
        }
        if (sb != null) {
            if (z2) {
                z = z2;
            } else {
                iBasedSegmentBuilder.appendAnchor(basedSequence.getStartOffset());
            }
            iBasedSegmentBuilder.append(sb.toString());
            iBasedSegmentBuilder.appendAnchor(basedSequence.getEndOffset());
            z2 = z;
        }
        if (z2) {
            return;
        }
        if (!C118721.$assertionsDisabled && basedSequence.length() != 0) {
            throw new AssertionError();
        }
        iBasedSegmentBuilder.appendAnchor(basedSequence.getStartOffset());
    }
}
