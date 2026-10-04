package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.p109ui.layout.AlignmentLine;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.RulerScope;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B¿\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\t\u0010Y\u001a\u00020JH\u0096\u0001J\u000e\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\u0007R\u0014\u0010\t\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001e\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00070#X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010!R\u0014\u0010\u0010\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0011\u0010*\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001a\u0010\u0016\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010,\"\u0004\b.\u0010/R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00109R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u00103R\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010!\"\u0004\b=\u0010>R\u0012\u0010?\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b@\u0010!R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010!R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010!R\u0011\u0010\u001a\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bE\u0010,R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010,R'\u0010G\u001a\u0015\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020J\u0018\u00010H¢\u0006\u0002\bK8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0014\u0010\r\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010!R\u001a\u0010Q\u001a\u00020R8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010\f\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010!R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u00109R\u0012\u0010W\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\bX\u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\\"}, m13886d2 = {"Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "visiblePagesInfo", "", "Landroidx/compose/foundation/pager/MeasuredPage;", "pageSize", "", "pageSpacing", "afterContentPadding", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "viewportStartOffset", "viewportEndOffset", "reverseLayout", "", "beyondViewportPageCount", "firstVisiblePage", "currentPage", "currentPageOffsetFraction", "", "firstVisiblePageScrollOffset", "canScrollForward", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "measureResult", "remeasureNeeded", "extraPagesBefore", "extraPagesAfter", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Ljava/util/List;IIILandroidx/compose/foundation/gestures/Orientation;IIZILandroidx/compose/foundation/pager/MeasuredPage;Landroidx/compose/foundation/pager/MeasuredPage;FIZLandroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/ui/layout/MeasureResult;ZLjava/util/List;Ljava/util/List;Lkotlinx/coroutines/CoroutineScope;)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "beforeContentPadding", "getBeforeContentPadding", "getBeyondViewportPageCount", "canScrollBackward", "getCanScrollBackward", "()Z", "getCanScrollForward", "setCanScrollForward", "(Z)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getCurrentPage", "()Landroidx/compose/foundation/pager/MeasuredPage;", "getCurrentPageOffsetFraction", "()F", "setCurrentPageOffsetFraction", "(F)V", "getExtraPagesAfter", "()Ljava/util/List;", "getExtraPagesBefore", "getFirstVisiblePage", "getFirstVisiblePageScrollOffset", "setFirstVisiblePageScrollOffset", "(I)V", "height", "getHeight", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getPageSize", "getPageSpacing", "getRemeasureNeeded", "getReverseLayout", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "getSnapPosition", "()Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "getViewportStartOffset", "getVisiblePagesInfo", "width", "getWidth", "placeChildren", "tryToApplyScrollWithoutRemeasure", "delta", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPagerMeasureResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerMeasureResult.kt\nandroidx/compose/foundation/pager/PagerMeasureResult\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,131:1\n33#2,6:132\n33#2,6:138\n33#2,6:144\n*S KotlinDebug\n*F\n+ 1 PagerMeasureResult.kt\nandroidx/compose/foundation/pager/PagerMeasureResult\n*L\n112#1:132,6\n115#1:138,6\n118#1:144,6\n*E\n"})
public final class PagerMeasureResult implements PagerLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private final int beyondViewportPageCount;
    private boolean canScrollForward;

    @NotNull
    private final CoroutineScope coroutineScope;

    @Nullable
    private final MeasuredPage currentPage;
    private float currentPageOffsetFraction;

    @NotNull
    private final List<MeasuredPage> extraPagesAfter;

    @NotNull
    private final List<MeasuredPage> extraPagesBefore;

    @Nullable
    private final MeasuredPage firstVisiblePage;
    private int firstVisiblePageScrollOffset;

    @NotNull
    private final Orientation orientation;
    private final int pageSize;
    private final int pageSpacing;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;

    @NotNull
    private final SnapPosition snapPosition;
    private final int viewportEndOffset;
    private final int viewportStartOffset;

    @NotNull
    private final List<MeasuredPage> visiblePagesInfo;

    public PagerMeasureResult(@NotNull List<MeasuredPage> list, int i, int i2, int i4, @NotNull Orientation orientation, int i5, int i6, boolean z, int i7, @Nullable MeasuredPage measuredPage, @Nullable MeasuredPage measuredPage2, float f, int i8, boolean z2, @NotNull SnapPosition snapPosition, @NotNull MeasureResult measureResult, boolean z3, @NotNull List<MeasuredPage> list2, @NotNull List<MeasuredPage> list3, @NotNull CoroutineScope coroutineScope) {
        this.visiblePagesInfo = list;
        this.pageSize = i;
        this.pageSpacing = i2;
        this.afterContentPadding = i4;
        this.orientation = orientation;
        this.viewportStartOffset = i5;
        this.viewportEndOffset = i6;
        this.reverseLayout = z;
        this.beyondViewportPageCount = i7;
        this.firstVisiblePage = measuredPage;
        this.currentPage = measuredPage2;
        this.currentPageOffsetFraction = f;
        this.firstVisiblePageScrollOffset = i8;
        this.canScrollForward = z2;
        this.snapPosition = snapPosition;
        this.remeasureNeeded = z3;
        this.extraPagesBefore = list2;
        this.extraPagesAfter = list3;
        this.coroutineScope = coroutineScope;
        this.$$delegate_0 = measureResult;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.p109ui.layout.MeasureResult
    @NotNull
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getBeyondViewportPageCount() {
        return this.beyondViewportPageCount;
    }

    public final boolean getCanScrollBackward() {
        MeasuredPage measuredPage = this.firstVisiblePage;
        return ((measuredPage != null ? measuredPage.getIndex() : 0) == 0 && this.firstVisiblePageScrollOffset == 0) ? false : true;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @Nullable
    public final MeasuredPage getCurrentPage() {
        return this.currentPage;
    }

    public final float getCurrentPageOffsetFraction() {
        return this.currentPageOffsetFraction;
    }

    @NotNull
    public final List<MeasuredPage> getExtraPagesAfter() {
        return this.extraPagesAfter;
    }

    @NotNull
    public final List<MeasuredPage> getExtraPagesBefore() {
        return this.extraPagesBefore;
    }

    @Nullable
    public final MeasuredPage getFirstVisiblePage() {
        return this.firstVisiblePage;
    }

    public final int getFirstVisiblePageScrollOffset() {
        return this.firstVisiblePageScrollOffset;
    }

    @Override // androidx.compose.p109ui.layout.MeasureResult
    /* JADX INFO: renamed from: getHeight */
    public int getF1176$h() {
        return this.$$delegate_0.getF1176$h();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    @NotNull
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getPageSize() {
        return this.pageSize;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getPageSpacing() {
        return this.pageSpacing;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    @Override // androidx.compose.p109ui.layout.MeasureResult
    @Nullable
    public Function1<RulerScope, Unit> getRulers() {
        return this.$$delegate_0.getRulers();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    @NotNull
    public SnapPosition getSnapPosition() {
        return this.snapPosition;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    public long mo16093getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(getF1177$w(), getF1176$h());
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    @NotNull
    public List<MeasuredPage> getVisiblePagesInfo() {
        return this.visiblePagesInfo;
    }

    @Override // androidx.compose.p109ui.layout.MeasureResult
    /* JADX INFO: renamed from: getWidth */
    public int getF1177$w() {
        return this.$$delegate_0.getF1177$w();
    }

    @Override // androidx.compose.p109ui.layout.MeasureResult
    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }

    public final void setCanScrollForward(boolean z) {
        this.canScrollForward = z;
    }

    public final void setCurrentPageOffsetFraction(float f) {
        this.currentPageOffsetFraction = f;
    }

    public final void setFirstVisiblePageScrollOffset(int i) {
        this.firstVisiblePageScrollOffset = i;
    }

    public final boolean tryToApplyScrollWithoutRemeasure(int delta) {
        int i;
        int pageSpacing = getPageSpacing() + getPageSize();
        if (!this.remeasureNeeded && !getVisiblePagesInfo().isEmpty() && this.firstVisiblePage != null && (i = this.firstVisiblePageScrollOffset - delta) >= 0 && i < pageSpacing) {
            float f = pageSpacing != 0 ? delta / pageSpacing : 0.0f;
            float f4 = this.currentPageOffsetFraction - f;
            if (this.currentPage != null && f4 < 0.5f && f4 > -0.5f) {
                MeasuredPage measuredPage = (MeasuredPage) CollectionsKt.first((List) getVisiblePagesInfo());
                MeasuredPage measuredPage2 = (MeasuredPage) CollectionsKt.last((List) getVisiblePagesInfo());
                if (delta >= 0 ? Math.min(getViewportStartOffset() - measuredPage.getOffset(), getViewportEndOffset() - measuredPage2.getOffset()) > delta : Math.min((measuredPage.getOffset() + pageSpacing) - getViewportStartOffset(), (measuredPage2.getOffset() + pageSpacing) - getViewportEndOffset()) > (-delta)) {
                    this.currentPageOffsetFraction -= f;
                    this.firstVisiblePageScrollOffset -= delta;
                    List<MeasuredPage> visiblePagesInfo = getVisiblePagesInfo();
                    int size = visiblePagesInfo.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        visiblePagesInfo.get(i2).applyScrollDelta(delta);
                    }
                    List<MeasuredPage> list = this.extraPagesBefore;
                    int size2 = list.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        list.get(i4).applyScrollDelta(delta);
                    }
                    List<MeasuredPage> list2 = this.extraPagesAfter;
                    int size3 = list2.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        list2.get(i5).applyScrollDelta(delta);
                    }
                    if (!this.canScrollForward && delta > 0) {
                        this.canScrollForward = true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public /* synthetic */ PagerMeasureResult(List list, int i, int i2, int i4, Orientation orientation, int i5, int i6, boolean z, int i7, MeasuredPage measuredPage, MeasuredPage measuredPage2, float f, int i8, boolean z2, SnapPosition snapPosition, MeasureResult measureResult, boolean z3, List list2, List list3, CoroutineScope coroutineScope, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, i2, i4, orientation, i5, i6, z, i7, measuredPage, measuredPage2, f, i8, z2, snapPosition, measureResult, z3, (i9 & 131072) != 0 ? CollectionsKt.emptyList() : list2, (i9 & 262144) != 0 ? CollectionsKt.emptyList() : list3, coroutineScope);
    }
}
