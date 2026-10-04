package androidx.compose.p109ui.text;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a<\u0010\u000b\u001a\u00020\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a-\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00140\u00032\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00010\u0010H\u0082\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, m13886d2 = {"findParagraphByIndex", "", "paragraphInfoList", "", "Landroidx/compose/ui/text/ParagraphInfo;", "index", "findParagraphByLineIndex", "lineIndex", "findParagraphByY", "y", "", "findParagraphsByRange", "", Bixby2Constants.BIXBY_PARAM_RANGE, "Landroidx/compose/ui/text/TextRange;", "action", "Lkotlin/Function1;", "findParagraphsByRange-Sb-Bc2M", "(Ljava/util/List;JLkotlin/jvm/functions/Function1;)V", "fastBinarySearch", "T", "comparison", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMultiParagraph.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiParagraph.kt\nandroidx/compose/ui/text/MultiParagraphKt\n*L\n1#1,1149:1\n1005#1,16:1150\n1005#1,16:1166\n1005#1,16:1182\n*S KotlinDebug\n*F\n+ 1 MultiParagraph.kt\nandroidx/compose/ui/text/MultiParagraphKt\n*L\n940#1:1150,16\n961#1:1166,16\n995#1:1182,16\n*E\n"})
public final class MultiParagraphKt {
    private static final <T> int fastBinarySearch(List<? extends T> list, Function1<? super T, Integer> function1) {
        int size = list.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            int iIntValue = function1.invoke(list.get(i2)).intValue();
            if (iIntValue < 0) {
                i = i2 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i2;
                }
                size = i2 - 1;
            }
        }
        return -(i + 1);
    }

    public static final int findParagraphByIndex(@NotNull List<ParagraphInfo> list, int i) {
        int endIndex = ((ParagraphInfo) CollectionsKt.last((List) list)).getEndIndex();
        if (i > ((ParagraphInfo) CollectionsKt.last((List) list)).getEndIndex()) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(i, endIndex, "Index ", " should be less or equal than last line's end ").toString());
        }
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i4 = (i2 + size) >>> 1;
            ParagraphInfo paragraphInfo = list.get(i4);
            byte b = paragraphInfo.getStartIndex() > i ? (byte) 1 : paragraphInfo.getEndIndex() <= i ? (byte) -1 : (byte) 0;
            if (b < 0) {
                i2 = i4 + 1;
            } else {
                if (b <= 0) {
                    return i4;
                }
                size = i4 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final int findParagraphByLineIndex(@NotNull List<ParagraphInfo> list, int i) {
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i4 = (i2 + size) >>> 1;
            ParagraphInfo paragraphInfo = list.get(i4);
            byte b = paragraphInfo.getStartLineIndex() > i ? (byte) 1 : paragraphInfo.getEndLineIndex() <= i ? (byte) -1 : (byte) 0;
            if (b < 0) {
                i2 = i4 + 1;
            } else {
                if (b <= 0) {
                    return i4;
                }
                size = i4 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final int findParagraphByY(@NotNull List<ParagraphInfo> list, float f) {
        if (f <= 0.0f) {
            return 0;
        }
        if (f >= ((ParagraphInfo) CollectionsKt.last((List) list)).getBottom()) {
            return CollectionsKt.getLastIndex(list);
        }
        int size = list.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            ParagraphInfo paragraphInfo = list.get(i2);
            byte b = paragraphInfo.getTop() > f ? (byte) 1 : paragraphInfo.getBottom() <= f ? (byte) -1 : (byte) 0;
            if (b < 0) {
                i = i2 + 1;
            } else {
                if (b <= 0) {
                    return i2;
                }
                size = i2 - 1;
            }
        }
        return -(i + 1);
    }

    /* JADX INFO: renamed from: findParagraphsByRange-Sb-Bc2M, reason: not valid java name */
    public static final void m20328findParagraphsByRangeSbBc2M(@NotNull List<ParagraphInfo> list, long j, @NotNull Function1<? super ParagraphInfo, Unit> function1) {
        int size = list.size();
        for (int iFindParagraphByIndex = findParagraphByIndex(list, TextRange.m20454getMinimpl(j)); iFindParagraphByIndex < size; iFindParagraphByIndex++) {
            ParagraphInfo paragraphInfo = list.get(iFindParagraphByIndex);
            if (paragraphInfo.getStartIndex() >= TextRange.m20453getMaximpl(j)) {
                return;
            }
            if (paragraphInfo.getStartIndex() != paragraphInfo.getEndIndex()) {
                function1.invoke(paragraphInfo);
            }
        }
    }
}
