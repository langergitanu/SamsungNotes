package androidx.compose.foundation.gestures.snapping;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.FinalSnappingItem;
import androidx.compose.foundation.pager.PageInfo;
import androidx.compose.foundation.pager.PagerLayoutInfo;
import androidx.compose.foundation.pager.PagerLayoutInfoKt;
import androidx.compose.foundation.pager.PagerSnapDistance;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.unit.LayoutDirection;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u001a8\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0000\u001a\u0017\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0082\b\u001a\f\u0010\u0014\u001a\u00020\b*\u00020\u0003H\u0002\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\u0002\u001a\f\u0010\u0017\u001a\u00020\u0016*\u00020\u0003H\u0002¨\u0006\u0018"}, m13886d2 = {"SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "calculateFinalSnappingBound", "Lkotlin/Function3;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "snapPositionalThreshold", "flingVelocity", "lowerBoundOffset", "upperBoundOffset", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "dragGestureDelta", "isLtrDragging", "", "isScrollingForward", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPagerSnapLayoutInfoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerSnapLayoutInfoProvider.kt\nandroidx/compose/foundation/gestures/snapping/PagerSnapLayoutInfoProviderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,306:1\n218#1,4:307\n218#1,4:312\n218#1,4:316\n218#1,4:320\n218#1,4:324\n1#2:311\n*S KotlinDebug\n*F\n+ 1 PagerSnapLayoutInfoProvider.kt\nandroidx/compose/foundation/gestures/snapping/PagerSnapLayoutInfoProviderKt\n*L\n246#1:307,4\n269#1:312,4\n279#1:316,4\n287#1:320,4\n291#1:324,4\n*E\n"})
public final class PagerSnapLayoutInfoProviderKt {
    @NotNull
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(@NotNull final PagerState pagerState, @NotNull final PagerSnapDistance pagerSnapDistance, @NotNull final Function3<? super Float, ? super Float, ? super Float, Float> function3) {
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.gestures.snapping.PagerSnapLayoutInfoProviderKt.SnapLayoutInfoProvider.1
            private final Pair<Float, Float> searchForSnappingBounds(SnapPosition snapPosition) {
                float f;
                List<PageInfo> visiblePagesInfo = getLayoutInfo().getVisiblePagesInfo();
                PagerState pagerState2 = pagerState;
                int size = visiblePagesInfo.size();
                float f4 = Float.NEGATIVE_INFINITY;
                float f5 = Float.POSITIVE_INFINITY;
                int i = 0;
                while (true) {
                    f = 0.0f;
                    if (i >= size) {
                        break;
                    }
                    PageInfo pageInfo = visiblePagesInfo.get(i);
                    float fCalculateDistanceToDesiredSnapPosition = SnapPositionKt.calculateDistanceToDesiredSnapPosition(PagerLayoutInfoKt.getMainAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), getLayoutInfo().getPageSize(), pageInfo.getOffset(), pageInfo.getIndex(), snapPosition, pagerState2.getPageCount());
                    if (fCalculateDistanceToDesiredSnapPosition <= 0.0f && fCalculateDistanceToDesiredSnapPosition > f4) {
                        f4 = fCalculateDistanceToDesiredSnapPosition;
                    }
                    if (fCalculateDistanceToDesiredSnapPosition >= 0.0f && fCalculateDistanceToDesiredSnapPosition < f5) {
                        f5 = fCalculateDistanceToDesiredSnapPosition;
                    }
                    i++;
                }
                if (f4 == Float.NEGATIVE_INFINITY) {
                    f4 = f5;
                }
                if (f5 == Float.POSITIVE_INFINITY) {
                    f5 = f4;
                }
                boolean z = PagerSnapLayoutInfoProviderKt.dragGestureDelta(pagerState) == 0.0f;
                if (!pagerState.getCanScrollForward()) {
                    if (z || !PagerSnapLayoutInfoProviderKt.isScrollingForward(pagerState)) {
                        f5 = 0.0f;
                    } else {
                        f4 = 0.0f;
                        f5 = 0.0f;
                    }
                }
                if (pagerState.getCanScrollBackward()) {
                    f = f4;
                } else if (!z && !PagerSnapLayoutInfoProviderKt.isScrollingForward(pagerState)) {
                    f5 = 0.0f;
                }
                return TuplesKt.m13893to(Float.valueOf(f), Float.valueOf(f5));
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(float velocity, float decayOffset) {
                int pageSpacing$foundation_release = pagerState.getPageSpacing$foundation_release() + pagerState.getPageSize$foundation_release();
                if (pageSpacing$foundation_release == 0) {
                    return 0.0f;
                }
                int firstVisiblePage = velocity < 0.0f ? pagerState.getFirstVisiblePage() + 1 : pagerState.getFirstVisiblePage();
                int iCoerceAtLeast = RangesKt.coerceAtLeast(Math.abs((RangesKt.coerceIn(pagerSnapDistance.calculateTargetPage(firstVisiblePage, RangesKt.coerceIn(((int) (decayOffset / pageSpacing$foundation_release)) + firstVisiblePage, 0, pagerState.getPageCount()), velocity, pagerState.getPageSize$foundation_release(), pagerState.getPageSpacing$foundation_release()), 0, pagerState.getPageCount()) - firstVisiblePage) * pageSpacing$foundation_release) - pageSpacing$foundation_release, 0);
                return iCoerceAtLeast == 0 ? iCoerceAtLeast : iCoerceAtLeast * Math.signum(velocity);
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnapOffset(float velocity) {
                Pair<Float, Float> pairSearchForSnappingBounds = searchForSnappingBounds(pagerState.getLayoutInfo().getSnapPosition());
                float fFloatValue = pairSearchForSnappingBounds.component1().floatValue();
                float fFloatValue2 = pairSearchForSnappingBounds.component2().floatValue();
                float fFloatValue3 = function3.invoke(Float.valueOf(velocity), Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2)).floatValue();
                if (fFloatValue3 != fFloatValue && fFloatValue3 != fFloatValue2 && fFloatValue3 != 0.0f) {
                    throw new IllegalStateException(AbstractC0541b.m770l("Final Snapping Offset Should Be one of ", fFloatValue, SQLKeyword.COMMA, fFloatValue2, " or 0.0").toString());
                }
                if (isValidDistance(fFloatValue3)) {
                    return fFloatValue3;
                }
                return 0.0f;
            }

            @NotNull
            public final PagerLayoutInfo getLayoutInfo() {
                return pagerState.getLayoutInfo();
            }

            public final boolean isValidDistance(float f) {
                return (f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY) ? false : true;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final float calculateFinalSnappingBound(@NotNull PagerState pagerState, @NotNull LayoutDirection layoutDirection, float f, float f4, float f5, float f6) {
        boolean zIsScrollingForward = (pagerState.getLayoutInfo().getOrientation() == Orientation.Vertical || layoutDirection == LayoutDirection.Ltr) ? isScrollingForward(pagerState) : !isScrollingForward(pagerState);
        int pageSize = pagerState.getLayoutInfo().getPageSize();
        float fDragGestureDelta = pageSize == 0 ? 0.0f : dragGestureDelta(pagerState) / pageSize;
        float f7 = fDragGestureDelta - ((int) fDragGestureDelta);
        int iCalculateFinalSnappingItem = LazyListSnapLayoutInfoProviderKt.calculateFinalSnappingItem(pagerState.getDensity(), f4);
        FinalSnappingItem.Companion companion = FinalSnappingItem.INSTANCE;
        if (FinalSnappingItem.m15693equalsimpl0(iCalculateFinalSnappingItem, companion.m15697getClosestItembbeMdSM())) {
            return (Math.abs(f7) <= f ? Math.abs(fDragGestureDelta) < Math.abs(pagerState.getPositionThresholdFraction$foundation_release()) ? Math.abs(f5) >= Math.abs(f6) : !zIsScrollingForward : zIsScrollingForward) ? f6 : f5;
        }
        if (!FinalSnappingItem.m15693equalsimpl0(iCalculateFinalSnappingItem, companion.m15698getNextItembbeMdSM())) {
            if (!FinalSnappingItem.m15693equalsimpl0(iCalculateFinalSnappingItem, companion.m15699getPreviousItembbeMdSM())) {
                return 0.0f;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float dragGestureDelta(PagerState pagerState) {
        return pagerState.getLayoutInfo().getOrientation() == Orientation.Horizontal ? Offset.m18284getXimpl(pagerState.m16102getUpDownDifferenceF1C5BW0$foundation_release()) : Offset.m18285getYimpl(pagerState.m16102getUpDownDifferenceF1C5BW0$foundation_release());
    }

    private static final boolean isLtrDragging(PagerState pagerState) {
        return dragGestureDelta(pagerState) > 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isScrollingForward(PagerState pagerState) {
        boolean reverseLayout = pagerState.getLayoutInfo().getReverseLayout();
        if (isLtrDragging(pagerState) && reverseLayout) {
            return true;
        }
        return (isLtrDragging(pagerState) || reverseLayout) ? false : true;
    }

    private static final void debugLog(Function0<String> function0) {
    }
}
