package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082\b\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"NearestItemsExtraItemCount", "", "NearestItemsSlidingWindowSize", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "currentAbsoluteScrollOffset", "", "Landroidx/compose/foundation/pager/PagerState;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class PagerScrollPositionKt {
    public static final int NearestItemsExtraItemCount = 100;
    public static final int NearestItemsSlidingWindowSize = 30;

    public static final long currentAbsoluteScrollOffset(@NotNull PagerState pagerState) {
        return MathKt.roundToLong(pagerState.getCurrentPageOffsetFraction() * pagerState.getPageSizeWithSpacing$foundation_release()) + (((long) pagerState.getCurrentPage()) * ((long) pagerState.getPageSizeWithSpacing$foundation_release()));
    }

    private static final void debugLog(Function0<String> function0) {
    }
}
