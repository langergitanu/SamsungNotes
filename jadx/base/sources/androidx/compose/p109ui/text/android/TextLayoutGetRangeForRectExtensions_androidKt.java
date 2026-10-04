package androidx.compose.p109ui.text.android;

import android.graphics.RectF;
import android.text.Layout;
import androidx.compose.p109ui.text.android.LayoutHelper;
import androidx.compose.p109ui.text.android.selection.SegmentFinder;
import androidx.compose.p109ui.text.android.selection.SegmentFinder_androidKt;
import androidx.compose.p109ui.text.android.selection.WordSegmentFinder;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001af\u0010\b\u001a\u00020\u0003*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001aH\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00032\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013H\u0000\u001af\u0010\u001d\u001a\u00020\u0003*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001aV\u0010\u001e\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010 \u001a\u00020\u0014H\u0002\u001a\u001c\u0010!\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0001H\u0002¨\u0006$"}, m13886d2 = {"getCharacterLeftBounds", "", TypedValues.Cycle.S_WAVE_OFFSET, "", "lineStart", "horizontalBounds", "", "getCharacterRightBounds", "getEndOffsetForRectWithinRun", "Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "rect", "Landroid/graphics/RectF;", "lineTop", "lineBottom", "runLeft", "runRight", "segmentFinder", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "inclusionStrategy", "Lkotlin/Function2;", "", "getRangeForRect", "", "Landroidx/compose/ui/text/android/TextLayout;", DBSchema.DocumentThumbnail.LAYOUT, "Landroid/text/Layout;", "layoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "granularity", "getStartOffsetForRectWithinRun", "getStartOrEndOffsetForRectWithinLine", "lineIndex", "getStart", "horizontalOverlap", "left", "right", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextLayoutGetRangeForRectExtensions_androidKt {
    private static final float getCharacterLeftBounds(int i, int i2, float[] fArr) {
        return fArr[(i - i2) * 2];
    }

    private static final float getCharacterRightBounds(int i, int i2, float[] fArr) {
        return fArr[AbstractC1974b.m1304A(i, i2, 2, 1)];
    }

    private static final int getEndOffsetForRectWithinRun(LayoutHelper.BidiRun bidiRun, RectF rectF, int i, int i2, int i4, float f, float f4, float[] fArr, SegmentFinder segmentFinder, Function2<? super RectF, ? super RectF, Boolean> function2) {
        int start;
        int iNextEndBoundary;
        if (!horizontalOverlap(rectF, f, f4)) {
            return -1;
        }
        if ((bidiRun.isRtl() || rectF.right < f4) && (!bidiRun.isRtl() || rectF.left > f)) {
            start = bidiRun.getStart();
            int end = bidiRun.getEnd();
            while (end - start > 1) {
                int i5 = (end + start) / 2;
                float characterLeftBounds = getCharacterLeftBounds(i5, i, fArr);
                if ((bidiRun.isRtl() || characterLeftBounds <= rectF.right) && (!bidiRun.isRtl() || characterLeftBounds >= rectF.left)) {
                    start = i5;
                } else {
                    end = i5;
                }
            }
            if (bidiRun.isRtl()) {
                start = end;
            }
        } else {
            start = bidiRun.getEnd() - 1;
        }
        int iPreviousStartBoundary = segmentFinder.previousStartBoundary(start + 1);
        if (iPreviousStartBoundary == -1 || (iNextEndBoundary = segmentFinder.nextEndBoundary(iPreviousStartBoundary)) <= bidiRun.getStart()) {
            return -1;
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(iPreviousStartBoundary, bidiRun.getStart());
        int iCoerceAtMost = RangesKt.coerceAtMost(iNextEndBoundary, bidiRun.getEnd());
        RectF rectF2 = new RectF(0.0f, i2, 0.0f, i4);
        while (true) {
            rectF2.left = bidiRun.isRtl() ? getCharacterLeftBounds(iCoerceAtMost - 1, i, fArr) : getCharacterLeftBounds(iCoerceAtLeast, i, fArr);
            rectF2.right = bidiRun.isRtl() ? getCharacterRightBounds(iCoerceAtLeast, i, fArr) : getCharacterRightBounds(iCoerceAtMost - 1, i, fArr);
            if (function2.invoke(rectF2, rectF).booleanValue()) {
                return iCoerceAtMost;
            }
            iCoerceAtMost = segmentFinder.previousEndBoundary(iCoerceAtMost);
            if (iCoerceAtMost == -1 || iCoerceAtMost <= bidiRun.getStart()) {
                break;
            }
            iCoerceAtLeast = RangesKt.coerceAtLeast(segmentFinder.previousStartBoundary(iCoerceAtMost), bidiRun.getStart());
        }
        return -1;
    }

    @Nullable
    public static final int[] getRangeForRect(@NotNull TextLayout textLayout, @NotNull Layout layout, @NotNull LayoutHelper layoutHelper, @NotNull RectF rectF, int i, @NotNull Function2<? super RectF, ? super RectF, Boolean> function2) {
        int i2;
        SegmentFinder wordSegmentFinder = i == 1 ? new WordSegmentFinder(textLayout.getText(), textLayout.getWordIterator()) : SegmentFinder_androidKt.createGraphemeClusterSegmentFinder(textLayout.getText(), textLayout.getTextPaint());
        int lineForVertical = layout.getLineForVertical((int) rectF.top);
        if (rectF.top > textLayout.getLineBottom(lineForVertical) && (lineForVertical = lineForVertical + 1) >= textLayout.getLineCount()) {
            return null;
        }
        int i4 = lineForVertical;
        int lineForVertical2 = layout.getLineForVertical((int) rectF.bottom);
        if (lineForVertical2 == 0 && rectF.bottom < textLayout.getLineTop(0)) {
            return null;
        }
        int startOrEndOffsetForRectWithinLine = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i4, rectF, wordSegmentFinder, function2, true);
        while (true) {
            i2 = i4;
            if (startOrEndOffsetForRectWithinLine != -1 || i2 >= lineForVertical2) {
                break;
            }
            i4 = i2 + 1;
            startOrEndOffsetForRectWithinLine = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i4, rectF, wordSegmentFinder, function2, true);
        }
        if (startOrEndOffsetForRectWithinLine == -1) {
            return null;
        }
        int startOrEndOffsetForRectWithinLine2 = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, lineForVertical2, rectF, wordSegmentFinder, function2, false);
        while (startOrEndOffsetForRectWithinLine2 == -1 && i2 < lineForVertical2) {
            int i5 = lineForVertical2 - 1;
            startOrEndOffsetForRectWithinLine2 = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i5, rectF, wordSegmentFinder, function2, false);
            lineForVertical2 = i5;
        }
        if (startOrEndOffsetForRectWithinLine2 == -1) {
            return null;
        }
        return new int[]{wordSegmentFinder.previousStartBoundary(startOrEndOffsetForRectWithinLine + 1), wordSegmentFinder.nextEndBoundary(startOrEndOffsetForRectWithinLine2 - 1)};
    }

    private static final int getStartOffsetForRectWithinRun(LayoutHelper.BidiRun bidiRun, RectF rectF, int i, int i2, int i4, float f, float f4, float[] fArr, SegmentFinder segmentFinder, Function2<? super RectF, ? super RectF, Boolean> function2) {
        int start;
        int iPreviousStartBoundary;
        if (!horizontalOverlap(rectF, f, f4)) {
            return -1;
        }
        if ((bidiRun.isRtl() || rectF.left > f) && (!bidiRun.isRtl() || rectF.right < f4)) {
            start = bidiRun.getStart();
            int end = bidiRun.getEnd();
            while (end - start > 1) {
                int i5 = (end + start) / 2;
                float characterLeftBounds = getCharacterLeftBounds(i5, i, fArr);
                if ((bidiRun.isRtl() || characterLeftBounds <= rectF.left) && (!bidiRun.isRtl() || characterLeftBounds >= rectF.right)) {
                    start = i5;
                } else {
                    end = i5;
                }
            }
            if (bidiRun.isRtl()) {
                start = end;
            }
        } else {
            start = bidiRun.getStart();
        }
        int iNextEndBoundary = segmentFinder.nextEndBoundary(start);
        if (iNextEndBoundary == -1 || (iPreviousStartBoundary = segmentFinder.previousStartBoundary(iNextEndBoundary)) >= bidiRun.getEnd()) {
            return -1;
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(iPreviousStartBoundary, bidiRun.getStart());
        int iCoerceAtMost = RangesKt.coerceAtMost(iNextEndBoundary, bidiRun.getEnd());
        RectF rectF2 = new RectF(0.0f, i2, 0.0f, i4);
        while (true) {
            rectF2.left = bidiRun.isRtl() ? getCharacterLeftBounds(iCoerceAtMost - 1, i, fArr) : getCharacterLeftBounds(iCoerceAtLeast, i, fArr);
            rectF2.right = bidiRun.isRtl() ? getCharacterRightBounds(iCoerceAtLeast, i, fArr) : getCharacterRightBounds(iCoerceAtMost - 1, i, fArr);
            if (function2.invoke(rectF2, rectF).booleanValue()) {
                return iCoerceAtLeast;
            }
            iCoerceAtLeast = segmentFinder.nextStartBoundary(iCoerceAtLeast);
            if (iCoerceAtLeast == -1 || iCoerceAtLeast >= bidiRun.getEnd()) {
                break;
            }
            iCoerceAtMost = RangesKt.coerceAtMost(segmentFinder.nextEndBoundary(iCoerceAtLeast), bidiRun.getEnd());
        }
        return -1;
    }

    private static final int getStartOrEndOffsetForRectWithinLine(TextLayout textLayout, Layout layout, LayoutHelper layoutHelper, int i, RectF rectF, SegmentFinder segmentFinder, Function2<? super RectF, ? super RectF, Boolean> function2, boolean z) {
        int lineTop = layout.getLineTop(i);
        int lineBottom = layout.getLineBottom(i);
        int lineStart = layout.getLineStart(i);
        int lineEnd = layout.getLineEnd(i);
        if (lineStart == lineEnd) {
            return -1;
        }
        float[] fArr = new float[(lineEnd - lineStart) * 2];
        textLayout.fillLineHorizontalBounds$ui_text_release(i, fArr);
        LayoutHelper.BidiRun[] lineBidiRuns$ui_text_release = layoutHelper.getLineBidiRuns$ui_text_release(i);
        IntProgression indices = z ? ArraysKt.getIndices(lineBidiRuns$ui_text_release) : RangesKt.downTo(ArraysKt.getLastIndex(lineBidiRuns$ui_text_release), 0);
        int first = indices.getFirst();
        int last = indices.getLast();
        int step = indices.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            int i2 = first;
            while (true) {
                LayoutHelper.BidiRun bidiRun = lineBidiRuns$ui_text_release[i2];
                float characterLeftBounds = bidiRun.isRtl() ? getCharacterLeftBounds(bidiRun.getEnd() - 1, lineStart, fArr) : getCharacterLeftBounds(bidiRun.getStart(), lineStart, fArr);
                float characterRightBounds = bidiRun.isRtl() ? getCharacterRightBounds(bidiRun.getStart(), lineStart, fArr) : getCharacterRightBounds(bidiRun.getEnd() - 1, lineStart, fArr);
                int startOffsetForRectWithinRun = z ? getStartOffsetForRectWithinRun(bidiRun, rectF, lineStart, lineTop, lineBottom, characterLeftBounds, characterRightBounds, fArr, segmentFinder, function2) : getEndOffsetForRectWithinRun(bidiRun, rectF, lineStart, lineTop, lineBottom, characterLeftBounds, characterRightBounds, fArr, segmentFinder, function2);
                if (startOffsetForRectWithinRun < 0) {
                    if (i2 == last) {
                        break;
                    }
                    i2 += step;
                } else {
                    return startOffsetForRectWithinRun;
                }
            }
        }
        return -1;
    }

    private static final boolean horizontalOverlap(RectF rectF, float f, float f4) {
        return f4 >= rectF.left && f <= rectF.right;
    }
}
