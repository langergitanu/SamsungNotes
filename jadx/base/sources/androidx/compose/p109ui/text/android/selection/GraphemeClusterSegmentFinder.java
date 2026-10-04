package androidx.compose.p109ui.text.android.selection;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, m13886d2 = {"Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinder;", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "()V", "next", "", TypedValues.Cycle.S_WAVE_OFFSET, "nextEndBoundary", "nextStartBoundary", "previous", "previousEndBoundary", "previousStartBoundary", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class GraphemeClusterSegmentFinder implements SegmentFinder {
    public static final int $stable = 0;

    public abstract int next(int offset);

    @Override // androidx.compose.p109ui.text.android.selection.SegmentFinder
    public int nextEndBoundary(int offset) {
        return next(offset);
    }

    @Override // androidx.compose.p109ui.text.android.selection.SegmentFinder
    public int nextStartBoundary(int offset) {
        int next = next(offset);
        if (next == -1 || next(next) == -1) {
            return -1;
        }
        return next;
    }

    public abstract int previous(int offset);

    @Override // androidx.compose.p109ui.text.android.selection.SegmentFinder
    public int previousEndBoundary(int offset) {
        int iPrevious = previous(offset);
        if (iPrevious == -1 || previous(iPrevious) == -1) {
            return -1;
        }
        return iPrevious;
    }

    @Override // androidx.compose.p109ui.text.android.selection.SegmentFinder
    public int previousStartBoundary(int offset) {
        return previous(offset);
    }
}
