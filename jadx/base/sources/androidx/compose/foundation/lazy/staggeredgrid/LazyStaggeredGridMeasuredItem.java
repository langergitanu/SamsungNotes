package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntOffsetKt;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultMeetingParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002Bs\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0004J\u001d\u0010C\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u0004H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u0012\u0010F\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010G\u001a\u00020A2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KJ\u001e\u0010L\u001a\u00020A2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004J(\u0010L\u001a\u00020A2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004H\u0016J\b\u0010Q\u001a\u00020RH\u0016J\u000e\u0010S\u001a\u00020A2\u0006\u0010&\u001a\u00020\u0004J+\u0010T\u001a\u000203*\u0002032\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040VH\u0082\bø\u0001\u0000¢\u0006\u0004\bW\u0010XR\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u00020\u0015X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010 R\u001a\u0010!\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010 \"\u0004\b\"\u0010#R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0014\u0010\r\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u000e\u0010&\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b(\u0010\u001eR\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0014\u0010+\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u000e\u0010-\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010#R&\u00104\u001a\u0002032\u0006\u00102\u001a\u000203@RX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b5\u0010\u0018R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u001eR\u001c\u00108\u001a\u000209X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b:\u0010\u0018R\u0014\u0010\u000e\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001eR\u0018\u0010<\u001a\u00020\u0004*\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0019\u0010)\u001a\u00020\u0004*\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010?\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Y"}, m13886d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "key", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "spacing", "lane", "span", "beforeContentPadding", "afterContentPadding", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(ILjava/lang/Object;Ljava/util/List;ZIIIIILjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "getContentType", "()Ljava/lang/Object;", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "()Z", "isVisible", "setVisible", "(Z)V", "getKey", "getLane", "mainAxisLayoutSize", "mainAxisOffset", "getMainAxisOffset", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "maxMainAxisOffset", "minMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", TypedValues.Cycle.S_WAVE_OFFSET, "getOffset-nOcc-ac", "placeablesCount", "getPlaceablesCount", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "getSpan", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "applyScrollDelta", "", "delta", "getOffset", "getOffset-Bjo55l4", "(I)J", "getParentData", ServerResultMeetingParser.PLACE, "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "context", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "crossAxis", "crossAxisOffset", "layoutWidth", "layoutHeight", "toString", "", "updateMainAxisLayoutSize", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyStaggeredGridMeasure.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyStaggeredGridMeasure.kt\nandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1354:1\n1341#1:1376\n1343#1:1377\n1341#1:1378\n1343#1:1380\n1343#1:1381\n317#2,8:1355\n317#2,8:1363\n69#2,4:1372\n74#2:1379\n1#3:1371\n*S KotlinDebug\n*F\n+ 1 LazyStaggeredGridMeasure.kt\nandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem\n*L\n1283#1:1376\n1303#1:1377\n1304#1:1378\n1331#1:1380\n1335#1:1381\n1220#1:1355,8\n1226#1:1363,8\n1282#1:1372,4\n1282#1:1379\n*E\n"})
public final class LazyStaggeredGridMeasuredItem implements LazyStaggeredGridItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;

    @NotNull
    private final LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> animator;
    private final int beforeContentPadding;
    private final long constraints;

    @Nullable
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible;

    @NotNull
    private final Object key;
    private final int lane;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;

    @NotNull
    private final List<Placeable> placeables;
    private final long size;
    private final int span;

    public /* synthetic */ LazyStaggeredGridMeasuredItem(int i, Object obj, List list, boolean z, int i2, int i4, int i5, int i6, int i7, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, obj, list, z, i2, i4, i5, i6, i7, obj2, lazyLayoutItemAnimator, j);
    }

    /* JADX INFO: renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m16070copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        int iM21096getXimpl = getIsVertical() ? IntOffset.m21096getXimpl(j) : function1.invoke(Integer.valueOf(IntOffset.m21096getXimpl(j))).intValue();
        boolean isVertical = getIsVertical();
        int iM21097getYimpl = IntOffset.m21097getYimpl(j);
        if (isVertical) {
            iM21097getYimpl = function1.invoke(Integer.valueOf(iM21097getYimpl)).intValue();
        }
        return IntOffsetKt.IntOffset(iM21096getXimpl, iM21097getYimpl);
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m16071getMainAxisgyyYBs(long j) {
        return getIsVertical() ? IntOffset.m21097getYimpl(j) : IntOffset.m21096getXimpl(j);
    }

    public final void applyScrollDelta(int delta) {
        if (getNonScrollableItem()) {
            return;
        }
        long offset = getOffset();
        int iM21096getXimpl = getIsVertical() ? IntOffset.m21096getXimpl(offset) : IntOffset.m21096getXimpl(offset) + delta;
        boolean isVertical = getIsVertical();
        int iM21097getYimpl = IntOffset.m21097getYimpl(offset);
        if (isVertical) {
            iM21097getYimpl += delta;
        }
        this.offset = IntOffsetKt.IntOffset(iM21096getXimpl, iM21097getYimpl);
        int placeablesCount = getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i);
            if (animation != null) {
                long rawOffset = animation.getRawOffset();
                int iM21096getXimpl2 = getIsVertical() ? IntOffset.m21096getXimpl(rawOffset) : Integer.valueOf(IntOffset.m21096getXimpl(rawOffset) + delta).intValue();
                boolean isVertical2 = getIsVertical();
                int iM21097getYimpl2 = IntOffset.m21097getYimpl(rawOffset);
                if (isVertical2) {
                    iM21097getYimpl2 += delta;
                }
                animation.m16017setRawOffsetgyyYBs(IntOffsetKt.IntOffset(iM21096getXimpl2, iM21097getYimpl2));
            }
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: from getter */
    public long getConstraints() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    @Nullable
    public Object getContentType() {
        return this.contentType;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    @NotNull
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getLane() {
        return this.lane;
    }

    public final int getMainAxisOffset() {
        return !getIsVertical() ? IntOffset.m21096getXimpl(getOffset()) : IntOffset.m21097getYimpl(getOffset());
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getOffset-Bjo55l4 */
    public long mo15966getOffsetBjo55l4(int index) {
        return getOffset();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* JADX INFO: renamed from: getOffset-nOcc-ac, reason: from getter */
    public long getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    @Nullable
    public Object getParentData(int index) {
        return this.placeables.get(index).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* JADX INFO: renamed from: getSize-YbymL2g, reason: from getter */
    public long getSize() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: isVertical, reason: from getter */
    public boolean getIsVertical() {
        return this.isVertical;
    }

    /* JADX INFO: renamed from: isVisible, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    public final void place(@NotNull Placeable.PlacementScope scope, @NotNull LazyStaggeredGridMeasureContext context) {
        GraphicsLayer layer;
        Placeable.PlacementScope placementScope;
        int iM21096getXimpl;
        int iM21097getYimpl;
        if (this.mainAxisLayoutSize == -1) {
            throw new IllegalArgumentException("position() should be called first");
        }
        List<Placeable> list = this.placeables;
        int size = list.size();
        int i = 0;
        while (i < size) {
            Placeable placeable = list.get(i);
            int height = this.minMainAxisOffset - (getIsVertical() ? placeable.getHeight() : placeable.getWidth());
            int i2 = this.maxMainAxisOffset;
            long offset = getOffset();
            LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i);
            if (animation != null) {
                long jM21100plusqkQi6aY = IntOffset.m21100plusqkQi6aY(offset, animation.m16013getPlacementDeltanOccac());
                if ((m16071getMainAxisgyyYBs(offset) <= height && m16071getMainAxisgyyYBs(jM21100plusqkQi6aY) <= height) || (m16071getMainAxisgyyYBs(offset) >= i2 && m16071getMainAxisgyyYBs(jM21100plusqkQi6aY) >= i2)) {
                    animation.cancelPlacementAnimation();
                }
                layer = animation.getLayer();
                offset = jM21100plusqkQi6aY;
            } else {
                layer = null;
            }
            if (context.getReverseLayout()) {
                if (getIsVertical()) {
                    iM21096getXimpl = IntOffset.m21096getXimpl(offset);
                } else {
                    iM21096getXimpl = (this.mainAxisLayoutSize - IntOffset.m21096getXimpl(offset)) - (getIsVertical() ? placeable.getHeight() : placeable.getWidth());
                }
                if (getIsVertical()) {
                    iM21097getYimpl = (this.mainAxisLayoutSize - IntOffset.m21097getYimpl(offset)) - (getIsVertical() ? placeable.getHeight() : placeable.getWidth());
                } else {
                    iM21097getYimpl = IntOffset.m21097getYimpl(offset);
                }
                offset = IntOffsetKt.IntOffset(iM21096getXimpl, iM21097getYimpl);
            }
            long jM21100plusqkQi6aY2 = IntOffset.m21100plusqkQi6aY(offset, context.getContentOffset());
            if (animation != null) {
                animation.m16015setFinalOffsetgyyYBs(jM21100plusqkQi6aY2);
            }
            if (layer != null) {
                placementScope = scope;
                Placeable.PlacementScope.m19922placeRelativeWithLayeraW9wM$default(placementScope, placeable, jM21100plusqkQi6aY2, layer, 0.0f, 4, (Object) null);
            } else {
                placementScope = scope;
                Placeable.PlacementScope.m19921placeRelativeWithLayeraW9wM$default(placementScope, placeable, jM21100plusqkQi6aY2, 0.0f, (Function1) null, 6, (Object) null);
            }
            i++;
            scope = placementScope;
        }
    }

    public final void position(int mainAxis, int crossAxis, int mainAxisLayoutSize) {
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = mainAxisLayoutSize + this.afterContentPadding;
        this.offset = getIsVertical() ? IntOffsetKt.IntOffset(crossAxis, mainAxis) : IntOffsetKt.IntOffset(mainAxis, crossAxis);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void setNonScrollableItem(boolean z) {
        this.nonScrollableItem = z;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }

    @NotNull
    public String toString() {
        return super.toString();
    }

    public final void updateMainAxisLayoutSize(int mainAxisLayoutSize) {
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.maxMainAxisOffset = mainAxisLayoutSize + this.afterContentPadding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyStaggeredGridMeasuredItem(int i, Object obj, List<? extends Placeable> list, boolean z, int i2, int i4, int i5, int i6, int i7, Object obj2, LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> lazyLayoutItemAnimator, long j) {
        Integer numValueOf;
        this.index = i;
        this.key = obj;
        this.placeables = list;
        this.isVertical = z;
        this.lane = i4;
        this.span = i5;
        this.beforeContentPadding = i6;
        this.afterContentPadding = i7;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j;
        int i8 = 1;
        this.isVisible = true;
        Integer num = null;
        if (list.isEmpty()) {
            numValueOf = null;
        } else {
            Placeable placeable = (Placeable) list.get(0);
            numValueOf = Integer.valueOf(getIsVertical() ? placeable.getHeight() : placeable.getWidth());
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                int i9 = 1;
                while (true) {
                    Placeable placeable2 = (Placeable) list.get(i9);
                    Integer numValueOf2 = Integer.valueOf(getIsVertical() ? placeable2.getHeight() : placeable2.getWidth());
                    numValueOf = numValueOf2.compareTo(numValueOf) > 0 ? numValueOf2 : numValueOf;
                    if (i9 == lastIndex) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
        this.mainAxisSize = iIntValue;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(iIntValue + i2, 0);
        List<Placeable> list2 = this.placeables;
        if (!list2.isEmpty()) {
            Placeable placeable3 = list2.get(0);
            Integer numValueOf3 = Integer.valueOf(getIsVertical() ? placeable3.getWidth() : placeable3.getHeight());
            int lastIndex2 = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex2) {
                while (true) {
                    Placeable placeable4 = list2.get(i8);
                    Integer numValueOf4 = Integer.valueOf(getIsVertical() ? placeable4.getWidth() : placeable4.getHeight());
                    numValueOf3 = numValueOf4.compareTo(numValueOf3) > 0 ? numValueOf4 : numValueOf3;
                    if (i8 == lastIndex2) {
                        break;
                    } else {
                        i8++;
                    }
                }
            }
            num = numValueOf3;
        }
        int iIntValue2 = num != null ? num.intValue() : 0;
        this.crossAxisSize = iIntValue2;
        this.mainAxisLayoutSize = -1;
        this.size = getIsVertical() ? IntSizeKt.IntSize(iIntValue2, this.mainAxisSize) : IntSizeKt.IntSize(this.mainAxisSize, iIntValue2);
        this.offset = IntOffset.INSTANCE.m21106getZeronOccac();
    }

    private final int getMainAxisSize(Placeable placeable) {
        return getIsVertical() ? placeable.getHeight() : placeable.getWidth();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight) {
        if (getIsVertical()) {
            layoutWidth = layoutHeight;
        }
        position(mainAxisOffset, crossAxisOffset, layoutWidth);
    }
}
