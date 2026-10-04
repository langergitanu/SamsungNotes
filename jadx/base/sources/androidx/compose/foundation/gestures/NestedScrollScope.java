package androidx.compose.foundation.gestures;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000¢\u0006\u0004\b\n\u0010\bø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, m13886d2 = {"Landroidx/compose/foundation/gestures/NestedScrollScope;", "", "scrollBy", "Landroidx/compose/ui/geometry/Offset;", TypedValues.Cycle.S_WAVE_OFFSET, "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "scrollBy-OzD1aCk", "(JI)J", "scrollByWithOverscroll", "scrollByWithOverscroll-OzD1aCk", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface NestedScrollScope {
    /* JADX INFO: renamed from: scrollBy-OzD1aCk, reason: not valid java name */
    long mo15627scrollByOzD1aCk(long offset, int source);

    /* JADX INFO: renamed from: scrollByWithOverscroll-OzD1aCk, reason: not valid java name */
    long mo15628scrollByWithOverscrollOzD1aCk(long offset, int source);
}
