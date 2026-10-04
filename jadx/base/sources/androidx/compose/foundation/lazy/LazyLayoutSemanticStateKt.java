package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.p109ui.semantics.CollectionInfo;
import androidx.compose.p109ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m13886d2 = {"LazyLayoutSemanticState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "isVertical", "", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LazyLayoutSemanticStateKt {
    @NotNull
    public static final LazyLayoutSemanticState LazyLayoutSemanticState(@NotNull final LazyListState lazyListState, final boolean z) {
        return new LazyLayoutSemanticState() { // from class: androidx.compose.foundation.lazy.LazyLayoutSemanticStateKt.LazyLayoutSemanticState.1
            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            @NotNull
            public CollectionInfo collectionInfo() {
                return z ? new CollectionInfo(-1, 1) : new CollectionInfo(1, -1);
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public int getContentPadding() {
                return lazyListState.getLayoutInfo().getAfterContentPadding() + lazyListState.getLayoutInfo().getBeforeContentPadding();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public float getMaxScrollOffset() {
                return LazyLayoutSemanticsKt.estimatedLazyMaxScrollOffset(lazyListState.getFirstVisibleItemIndex(), lazyListState.getFirstVisibleItemScrollOffset(), lazyListState.getCanScrollForward());
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public float getScrollOffset() {
                return LazyLayoutSemanticsKt.estimatedLazyScrollOffset(lazyListState.getFirstVisibleItemIndex(), lazyListState.getFirstVisibleItemScrollOffset());
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public int getViewport() {
                return lazyListState.getLayoutInfo().getOrientation() == Orientation.Vertical ? IntSize.m21137getHeightimpl(lazyListState.getLayoutInfo().mo15959getViewportSizeYbymL2g()) : IntSize.m21138getWidthimpl(lazyListState.getLayoutInfo().mo15959getViewportSizeYbymL2g());
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            @Nullable
            public Object scrollToItem(int i, @NotNull Continuation<? super Unit> continuation) {
                Object objScrollToItem$default = LazyListState.scrollToItem$default(lazyListState, i, 0, continuation, 2, null);
                return objScrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScrollToItem$default : Unit.INSTANCE;
            }
        };
    }
}
