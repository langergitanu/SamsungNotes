package androidx.compose.p109ui.text.android.selection;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0005"}, m13886d2 = {"getWordEnd", "", "Landroidx/compose/ui/text/android/selection/WordIterator;", TypedValues.Cycle.S_WAVE_OFFSET, "getWordStart", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class WordBoundary_androidKt {
    public static final int getWordEnd(@NotNull WordIterator wordIterator, int i) {
        int punctuationEnd = wordIterator.isAfterPunctuation(wordIterator.nextBoundary(i)) ? wordIterator.getPunctuationEnd(i) : wordIterator.getNextWordEndOnTwoWordBoundary(i);
        return punctuationEnd == -1 ? i : punctuationEnd;
    }

    public static final int getWordStart(@NotNull WordIterator wordIterator, int i) {
        int punctuationBeginning = wordIterator.isOnPunctuation(wordIterator.prevBoundary(i)) ? wordIterator.getPunctuationBeginning(i) : wordIterator.getPrevWordBeginningOnTwoWordsBoundary(i);
        return punctuationBeginning == -1 ? i : punctuationBeginning;
    }
}
