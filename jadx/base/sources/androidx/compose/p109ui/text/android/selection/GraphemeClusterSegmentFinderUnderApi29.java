package androidx.compose.p109ui.text.android.selection;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.text.BreakIterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinderUnderApi29;", "Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinder;", "text", "", "(Ljava/lang/CharSequence;)V", "breakIterator", "Ljava/text/BreakIterator;", "kotlin.jvm.PlatformType", "next", "", TypedValues.Cycle.S_WAVE_OFFSET, "previous", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class GraphemeClusterSegmentFinderUnderApi29 extends GraphemeClusterSegmentFinder {
    public static final int $stable = 8;
    private final BreakIterator breakIterator;

    @NotNull
    private final CharSequence text;

    public GraphemeClusterSegmentFinderUnderApi29(@NotNull CharSequence charSequence) {
        this.text = charSequence;
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(charSequence.toString());
        this.breakIterator = characterInstance;
    }

    @Override // androidx.compose.p109ui.text.android.selection.GraphemeClusterSegmentFinder
    public int next(int offset) {
        return this.breakIterator.following(offset);
    }

    @Override // androidx.compose.p109ui.text.android.selection.GraphemeClusterSegmentFinder
    public int previous(int offset) {
        return this.breakIterator.preceding(offset);
    }
}
