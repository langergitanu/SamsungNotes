package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003J\u0016\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003J\u0016\u0010&\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0005J\u0018\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0005H\u0002J\u000e\u0010*\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, m13886d2 = {"Landroidx/compose/foundation/pager/PagerScrollPosition;", "", "currentPage", "", "currentPageOffsetFraction", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "(IFLandroidx/compose/foundation/pager/PagerState;)V", "<set-?>", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "currentPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "getCurrentPageOffsetFraction", "()F", "setCurrentPageOffsetFraction", "(F)V", "currentPageOffsetFraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "hadFirstNotEmptyLayout", "", "lastKnownCurrentPageKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getState", "()Landroidx/compose/foundation/pager/PagerState;", "applyScrollDelta", "", "delta", "matchPageWithKey", "itemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "index", "requestPositionAndForgetLastKnownKey", "offsetFraction", Constants.ARG_UPDATE, "page", "updateCurrentPageOffsetFraction", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPagerScrollPosition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerScrollPosition.kt\nandroidx/compose/foundation/pager/PagerScrollPosition\n+ 2 SnapshotIntState.kt\nandroidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt\n+ 3 SnapshotFloatState.kt\nandroidx/compose/runtime/PrimitiveSnapshotStateKt__SnapshotFloatStateKt\n+ 4 PagerScrollPosition.kt\nandroidx/compose/foundation/pager/PagerScrollPositionKt\n*L\n1#1,146:1\n78#2:147\n111#2,2:148\n79#3:150\n112#3,2:151\n136#4,4:153\n*S KotlinDebug\n*F\n+ 1 PagerScrollPosition.kt\nandroidx/compose/foundation/pager/PagerScrollPosition\n*L\n38#1:147\n38#1:148,2\n41#1:150\n41#1:151,2\n114#1:153,4\n*E\n"})
public final class PagerScrollPosition {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: currentPage$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableIntState currentPage;

    /* JADX INFO: renamed from: currentPageOffsetFraction$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableFloatState currentPageOffsetFraction;
    private boolean hadFirstNotEmptyLayout;

    @Nullable
    private Object lastKnownCurrentPageKey;

    @NotNull
    private final LazyLayoutNearestRangeState nearestRangeState;

    @NotNull
    private final PagerState state;

    public PagerScrollPosition(int i, float f, @NotNull PagerState pagerState) {
        this.state = pagerState;
        this.currentPage = SnapshotIntStateKt.mutableIntStateOf(i);
        this.currentPageOffsetFraction = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.nearestRangeState = new LazyLayoutNearestRangeState(i, 30, 100);
    }

    private final void setCurrentPage(int i) {
        this.currentPage.setIntValue(i);
    }

    private final void setCurrentPageOffsetFraction(float f) {
        this.currentPageOffsetFraction.setFloatValue(f);
    }

    private final void update(int page, float offsetFraction) {
        setCurrentPage(page);
        this.nearestRangeState.update(page);
        setCurrentPageOffsetFraction(offsetFraction);
    }

    public final void applyScrollDelta(int delta) {
        setCurrentPageOffsetFraction(getCurrentPageOffsetFraction() + (this.state.getPageSizeWithSpacing$foundation_release() == 0 ? 0.0f : delta / this.state.getPageSizeWithSpacing$foundation_release()));
    }

    public final int getCurrentPage() {
        return this.currentPage.getIntValue();
    }

    public final float getCurrentPageOffsetFraction() {
        return this.currentPageOffsetFraction.getFloatValue();
    }

    @NotNull
    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    @NotNull
    public final PagerState getState() {
        return this.state;
    }

    public final int matchPageWithKey(@NotNull PagerLazyLayoutItemProvider itemProvider, int index) {
        int iFindIndexByKey = LazyLayoutItemProviderKt.findIndexByKey(itemProvider, this.lastKnownCurrentPageKey, index);
        if (index != iFindIndexByKey) {
            setCurrentPage(iFindIndexByKey);
            this.nearestRangeState.update(index);
        }
        return iFindIndexByKey;
    }

    public final void requestPositionAndForgetLastKnownKey(int index, float offsetFraction) {
        update(index, offsetFraction);
        this.lastKnownCurrentPageKey = null;
    }

    public final void updateCurrentPageOffsetFraction(float offsetFraction) {
        setCurrentPageOffsetFraction(offsetFraction);
    }

    public final void updateFromMeasureResult(@NotNull PagerMeasureResult measureResult) {
        MeasuredPage currentPage = measureResult.getCurrentPage();
        this.lastKnownCurrentPageKey = currentPage != null ? currentPage.getKey() : null;
        if (this.hadFirstNotEmptyLayout || !measureResult.getVisiblePagesInfo().isEmpty()) {
            this.hadFirstNotEmptyLayout = true;
            MeasuredPage currentPage2 = measureResult.getCurrentPage();
            update(currentPage2 != null ? currentPage2.getIndex() : 0, measureResult.getCurrentPageOffsetFraction());
        }
    }

    public /* synthetic */ PagerScrollPosition(int i, float f, PagerState pagerState, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0.0f : f, pagerState);
    }
}
