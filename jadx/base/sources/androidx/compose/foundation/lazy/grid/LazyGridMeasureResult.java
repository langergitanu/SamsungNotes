package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.p109ui.layout.AlignmentLine;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.RulerScope;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BÊ\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u00123\u0010\u0012\u001a/\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u00180\u00170\u0013\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\u0006\u0010#\u001a\u00020\u0006¢\u0006\u0002\u0010$J\t\u0010[\u001a\u00020LH\u0096\u0001J\u000e\u0010\\\u001a\u00020\b2\u0006\u0010]\u001a\u00020\u0006R\u0014\u0010\"\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001e\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00060(X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010&R\u0011\u0010.\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00100\"\u0004\b2\u00103R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010&\"\u0004\b?\u0010@R\u0012\u0010A\u001a\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\bB\u0010&R\u0014\u0010#\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010&R\u0014\u0010 \u001a\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER>\u0010\u0012\u001a/\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u00180\u00170\u0013¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bH\u00100R\u0014\u0010\u001f\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00100R'\u0010J\u001a\u0015\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L\u0018\u00010\u0013¢\u0006\u0002\bM8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bN\u0010GR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bO\u0010&R\u0014\u0010\u001e\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010&R\u0014\u0010\u001d\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010&R\u001a\u0010R\u001a\u00020S8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010\u001c\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010&R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0012\u0010Y\u001a\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\bZ\u0010&\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006^"}, m13886d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleLine", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "firstVisibleLineScrollOffset", "", "canScrollForward", "", "consumedScroll", "", "measureResult", "remeasureNeeded", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "density", "Landroidx/compose/ui/unit/Density;", "slotsPerLine", "prefetchInfoRetriever", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/Constraints;", "visibleItemsInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "viewportStartOffset", "viewportEndOffset", "totalItemsCount", "reverseLayout", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "afterContentPadding", "mainAxisItemSpacing", "(Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;IZFLandroidx/compose/ui/layout/MeasureResult;ZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function1;Ljava/util/List;IIIZLandroidx/compose/foundation/gestures/Orientation;II)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "beforeContentPadding", "getBeforeContentPadding", "canScrollBackward", "getCanScrollBackward", "()Z", "getCanScrollForward", "setCanScrollForward", "(Z)V", "getConsumedScroll", "()F", "setConsumedScroll", "(F)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFirstVisibleLine", "()Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "getFirstVisibleLineScrollOffset", "setFirstVisibleLineScrollOffset", "(I)V", "height", "getHeight", "getMainAxisItemSpacing", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getPrefetchInfoRetriever", "()Lkotlin/jvm/functions/Function1;", "getRemeasureNeeded", "getReverseLayout", "rulers", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulers", "getSlotsPerLine", "getTotalItemsCount", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "getViewportStartOffset", "getVisibleItemsInfo", "()Ljava/util/List;", "width", "getWidth", "placeChildren", "tryToApplyScrollWithoutRemeasure", "delta", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyGridMeasureResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridMeasureResult.kt\nandroidx/compose/foundation/lazy/grid/LazyGridMeasureResult\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,135:1\n33#2,6:136\n*S KotlinDebug\n*F\n+ 1 LazyGridMeasureResult.kt\nandroidx/compose/foundation/lazy/grid/LazyGridMeasureResult\n*L\n121#1:136,6\n*E\n"})
public final class LazyGridMeasureResult implements LazyGridLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private boolean canScrollForward;
    private float consumedScroll;

    @NotNull
    private final CoroutineScope coroutineScope;

    @NotNull
    private final Density density;

    @Nullable
    private final LazyGridMeasuredLine firstVisibleLine;
    private int firstVisibleLineScrollOffset;
    private final int mainAxisItemSpacing;

    @NotNull
    private final Orientation orientation;

    @NotNull
    private final Function1<Integer, List<Pair<Integer, Constraints>>> prefetchInfoRetriever;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final int slotsPerLine;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;

    @NotNull
    private final List<LazyGridMeasuredItem> visibleItemsInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyGridMeasureResult(@Nullable LazyGridMeasuredLine lazyGridMeasuredLine, int i, boolean z, float f, @NotNull MeasureResult measureResult, boolean z2, @NotNull CoroutineScope coroutineScope, @NotNull Density density, int i2, @NotNull Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> function1, @NotNull List<LazyGridMeasuredItem> list, int i4, int i5, int i6, boolean z3, @NotNull Orientation orientation, int i7, int i8) {
        this.firstVisibleLine = lazyGridMeasuredLine;
        this.firstVisibleLineScrollOffset = i;
        this.canScrollForward = z;
        this.consumedScroll = f;
        this.remeasureNeeded = z2;
        this.coroutineScope = coroutineScope;
        this.density = density;
        this.slotsPerLine = i2;
        this.prefetchInfoRetriever = function1;
        this.visibleItemsInfo = list;
        this.viewportStartOffset = i4;
        this.viewportEndOffset = i5;
        this.totalItemsCount = i6;
        this.reverseLayout = z3;
        this.orientation = orientation;
        this.afterContentPadding = i7;
        this.mainAxisItemSpacing = i8;
        this.$$delegate_0 = measureResult;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.p109ui.layout.MeasureResult
    @NotNull
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    public final boolean getCanScrollBackward() {
        LazyGridMeasuredLine lazyGridMeasuredLine = this.firstVisibleLine;
        return ((lazyGridMeasuredLine != null ? lazyGridMeasuredLine.getIndex() : 0) == 0 && this.firstVisibleLineScrollOffset == 0) ? false : true;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @Nullable
    public final LazyGridMeasuredLine getFirstVisibleLine() {
        return this.firstVisibleLine;
    }

    public final int getFirstVisibleLineScrollOffset() {
        return this.firstVisibleLineScrollOffset;
    }

    @Override // androidx.compose.p109ui.layout.MeasureResult
    public int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    @NotNull
    public Orientation getOrientation() {
        return this.orientation;
    }

    @NotNull
    public final Function1<Integer, List<Pair<Integer, Constraints>>> getPrefetchInfoRetriever() {
        return this.prefetchInfoRetriever;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    @Override // androidx.compose.p109ui.layout.MeasureResult
    @Nullable
    public Function1<RulerScope, Unit> getRulers() {
        return this.$$delegate_0.getRulers();
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    public long mo15994getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    @NotNull
    public List<LazyGridMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    @Override // androidx.compose.p109ui.layout.MeasureResult
    public int getWidth() {
        return this.$$delegate_0.getWidth();
    }

    @Override // androidx.compose.p109ui.layout.MeasureResult
    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }

    public final void setCanScrollForward(boolean z) {
        this.canScrollForward = z;
    }

    public final void setConsumedScroll(float f) {
        this.consumedScroll = f;
    }

    public final void setFirstVisibleLineScrollOffset(int i) {
        this.firstVisibleLineScrollOffset = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean tryToApplyScrollWithoutRemeasure(int delta) {
        LazyGridMeasuredLine lazyGridMeasuredLine;
        boolean z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        if (!this.remeasureNeeded && !getVisibleItemsInfo().isEmpty() && (lazyGridMeasuredLine = this.firstVisibleLine) != null) {
            int mainAxisSizeWithSpacings = lazyGridMeasuredLine.getMainAxisSizeWithSpacings();
            int i = this.firstVisibleLineScrollOffset - delta;
            if (i >= 0 && i < mainAxisSizeWithSpacings) {
                LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) CollectionsKt.first((List) getVisibleItemsInfo());
                LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) CollectionsKt.last((List) getVisibleItemsInfo());
                if (!lazyGridMeasuredItem.getNonScrollableItem() && !lazyGridMeasuredItem2.getNonScrollableItem()) {
                    if (delta < 0) {
                        if (Math.min((lazyGridMeasuredItem.getMainAxisSizeWithSpacings() + LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridMeasuredItem, getOrientation())) - getViewportStartOffset(), (lazyGridMeasuredItem2.getMainAxisSizeWithSpacings() + LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridMeasuredItem2, getOrientation())) - getViewportEndOffset()) > (-delta)) {
                            this.firstVisibleLineScrollOffset -= delta;
                            List<LazyGridMeasuredItem> visibleItemsInfo = getVisibleItemsInfo();
                            int size = visibleItemsInfo.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                visibleItemsInfo.get(i2).applyScrollDelta(delta);
                            }
                            this.consumedScroll = delta;
                            z = true;
                            z = true;
                            z = true;
                            if (!this.canScrollForward && delta > 0) {
                                this.canScrollForward = true;
                            }
                        }
                    } else if (Math.min(getViewportStartOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridMeasuredItem, getOrientation()), getViewportEndOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridMeasuredItem2, getOrientation())) > delta) {
                    }
                }
            }
        }
        return z;
    }
}
